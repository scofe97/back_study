package org.example.functional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.nio.charset.StandardCharsets.UTF_8;

public class TestJava2 {
    // ConcurrentHashMap을 사용해 스레드 안전성 확보
    private static final Map<String, Object> cache = new ConcurrentHashMap<>();

    // 제네릭 타입 안정성 강화 및 경고 제거
    @SuppressWarnings("unchecked")
    static <T> T memoize(String identifier, Supplier<T> fn) {
        return (T) cache.computeIfAbsent(identifier, key -> fn.get());
    }

    // 시간 소요가 큰 연산 시뮬레이션
    static Integer expensiveCall(String arg0, int arg1) {
        try {
            Thread.sleep(2000); // 2초 대기
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 현재 스레드의 interrupt 상태 복구
            throw new RuntimeException("Thread interrupted", e);
        }
        return arg1 + arg0.length();
    }

    // 메모이제이션된 메서드
    static Integer memoized(String arg0, int arg1) {
        var compoundKey = String.format("expensiveCall:%s-%d", arg0, arg1);
        return memoize(compoundKey, () -> expensiveCall(arg0, arg1));
    }

    public static void main(String[] args) {
        System.out.println("1번째 연산");

        // 가상 스레드로 비동기 작업 수행
        var thread = Thread.startVirtualThread(() -> {
            var calculated = memoized("hello", 42); // 2초 대기
            System.out.println("결과(1번째 연산): " + calculated);
        });
        System.out.println("2번째 연산 준비 중");

        // 추가 작업
        var secondThread = Thread.startVirtualThread(() -> {
            var cached = memoized("hello", 42); // 캐시에서 즉시 반환
            System.out.println("결과(2번째 연산): " + cached);
        });

        // 메인 스레드의 종료를 막기 위해 가상 스레드가 끝날 때까지 대기
        try {
            thread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted", e);
        }
    }
}
