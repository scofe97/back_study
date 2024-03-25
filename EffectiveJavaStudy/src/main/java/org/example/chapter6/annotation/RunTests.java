package org.example.chapter6.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {
    public static void main(String[] args) throws Exception{
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName(Sample.class.getName());
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {	//Test 애너테이션이 선언된 메서드만을 호출한다.
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " 실패 : " + exc);
                } catch (Exception e) {
                    System.out.println("잘못 사용한 테스트 @Test : " + m);
                }
            }
        }
        System.out.printf("suc :: %d, fail : %d%n", passed, tests - passed);
    }
}