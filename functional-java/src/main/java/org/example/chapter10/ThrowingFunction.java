package org.example.chapter10;

import java.util.function.Function;

@FunctionalInterface
public interface ThrowingFunction<T, R> extends Function<T, R> {

    // 추상 메서드: 입력 T를 받아 R을 반환하며, 예외를 던질 수 있음
    R applyThrowing(T t) throws Exception;

    // Function 인터페이스의 apply 메서드를 오버라이드
    @Override
    default R apply(T t) {
        try{
            return applyThrowing(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 정적 메서드: ThrowingFunction을 일반 Function으로 변환
    static <T, R> Function<T, R> uncheck(ThrowingFunction<T, R> function) {
        return function::apply;
    }

}
