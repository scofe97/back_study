package org.example.chapter10;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class Try<T, R> implements Function<T, Optional<R>> {
    private final Function<T, R> fn;
    private final Function<RuntimeException, R> failureFn;

    // 정적 팩토리 메서드, catch-or-specify 요구사항을 회피하기 위해 사용
    public static <T,R> Try<T,R> of(ThrowingFunction<T,R> fn) {
        Objects.requireNonNull(fn);
        return new Try<>(fn, null);
    }

    // private 생성자를 만들기 위해 class 사용(외부 접근제한)
    private Try(Function<T, R> fn
            , Function<RuntimeException, R> failureFn) {
        this.fn = fn;
        this.failureFn = failureFn;
    }

    // 새로운 Try 인스턴스의 기반을 형성하기 위해 원래의 람다에 합성된다.
    public Try<T, R> success(Function<R, R> successFn) {
        Objects.requireNonNull(successFn);

        var composeFn = this.fn.andThen(successFn);
        return new Try<>(composeFn, failureFn);
    }

    // 오류를 처리하는 것은 원래의 fn 과 failureFn 을 전달하는것으로 충분하다.
    public Try<T,R> failure(Function<RuntimeException, R> failureFn) {
        Objects.requireNonNull(failureFn);
        return new Try<>(fn, failureFn);
    }

    @Override
    public Optional<R> apply(T value) {
        try{
            var result = this.fn.apply(value);
            return Optional.ofNullable(result);
        }  catch (RuntimeException e) {
            if(this.failureFn != null) {
                var result = this.failureFn.apply(e);
                return Optional.ofNullable(result);
            }
        }

        return Optional.empty();
    }


}
