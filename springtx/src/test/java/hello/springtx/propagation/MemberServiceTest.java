package hello.springtx.propagation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.UnexpectedRollbackException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    LogRepository logRepository;

    @Test
    public void testNonTransientException() {
        String username = "duplicateUser";

        // 첫 번째 사용자 생성
        memberService.createUser(username);

        // 두 번째 사용자 생성 시도 (중복된 username으로 인해 예외 발생 예상)
        assertThrows(DataIntegrityViolationException.class, () -> {
            memberService.createUser(username);
        });
    }

    @Test
    public void testTransientException() {
        String username = "transientUser";

        assertThrows(RuntimeException.class, () -> {
            memberService.createUserTransient(username);
        });
    }

    /**
     * memberService    트랜잭션 off
     * memberRepository 트랜잭션 on
     * logRepository ㅌ  트랜잭션 On
     */
    @Test
    void outerTxOff_success() {
        // given
        String username = "outerTxOff_success";

        // when
        memberService.joinV1(username);

        // then
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * memberService    트랜잭션 off
     * memberRepository 트랜잭션 on
     * logRepository    트랜잭션 On Exception
     */
    @Test
    void outerTxOff_fail() {
        // given
        String username = "로그예외_outerTxOff_success";

        // when
        assertThatThrownBy(() -> memberService.joinV1(username))
                .isInstanceOf(RuntimeException.class);

        // then (log는 롤백되어 저장되지 않음)
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isEmpty());
    }

    /**
     * memberService    트랜잭션 On
     * memberRepository 트랜잭션 Off
     * logRepository    트랜잭션 Off
     */
    @Test
    void singleTx() {
        // given
        String username = "singleTx";

        // when
        memberService.joinV1(username);

        // then
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * memberService    트랜잭션 On
     * memberRepository 트랜잭션 On
     * logRepository    트랜잭션 On
     */
    @Test
    void outerTxOn_success() {
        // given
        String username = "outerTxOn_success";

        // when
        memberService.joinV1(username);

        // then
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isPresent());
    }

    /**
     * memberService    트랜잭션 On
     * memberRepository 트랜잭션 on
     * logRepository    트랜잭션 On Exception
     */
    @Test
    void outerTxOn_fail() {
        // given
        String username = "로그예외_outerTxOn_success";

        // when
        assertThatThrownBy(() -> memberService.joinV1(username))
                .isInstanceOf(RuntimeException.class);

        // then 모든 데이터가 롤백된다.
        assertTrue(memberRepository.find(username).isEmpty());
        assertTrue(logRepository.find(username).isEmpty());
    }

    /**
     * memberService    트랜잭션 off
     * memberRepository 트랜잭션 on
     * logRepository    트랜잭션 On Exception
     */
    @Test
    void recoverException_fail() {
        // given
        String username = "로그예외_recoverException_fail";

        // when
        assertThatThrownBy(() -> memberService.joinV2(username))
                .isInstanceOf(UnexpectedRollbackException.class);

        // then
        assertTrue(memberRepository.find(username).isEmpty());
        assertTrue(logRepository.find(username).isEmpty());
    }

    /**
     * memberService    트랜잭션 on
     * memberRepository 트랜잭션 on
     * logRepository    트랜잭션 On(REQUIRES_NEW) Exception
     */
    @Test
    void recoverException_success() {
        // given
        String username = "로그예외_recoverException_success";

        // when
        memberService.joinV2(username);

        // then
        assertTrue(memberRepository.find(username).isPresent());
        assertTrue(logRepository.find(username).isEmpty());
    }
}