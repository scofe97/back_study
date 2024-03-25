package org.example.chapter6.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests2 {
    public static void main(String[] args) throws Exception{
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName(Sample2.class.getName());
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ExceptionTest.class)) {	//Test 애너테이션이 선언된 메서드만을 호출한다.
                tests++;
                try {
                    m.invoke(null);
                    System.out.println("예외를 던지지 않음");
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    Class<? extends Throwable> excType = m.getAnnotation(ExceptionTest.class).value();

                    if(excType.isInstance(exc)){
                        passed++;
                    }else{
                        System.out.printf("테스트 %s 실패: 기대한 예외 %s, 발생한 예외 %s%n", m, excType.getName(), exc);
                    }
                } catch (Exception e) {
                    System.out.println("잘못 사용한 테스트 @ExceptionTest : " + m);
                }
            }
        }
        System.out.printf("suc :: %d, fail : %d%n", passed, tests - passed);
    }
}