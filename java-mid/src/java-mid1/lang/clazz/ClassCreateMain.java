package lang.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassCreateMain {

    public static void main(String[] args) throws Exception{
        Class helloClass = Hello.class;
        Class helloClass2 = Class.forName("lang.clazz.Hello");

        // Hello 클래스의 인스턴스 생성
        Hello hello = (Hello) helloClass.getDeclaredConstructor().newInstance();

        // hello 메서드 호출
        String result = hello.hello();
        System.out.println("result = " + result);
        Field message = helloClass.getDeclaredField("message");
        message.setAccessible(true); // private 필드라면 접근 가능하게 설정
        message.set(hello, "Hello, Reflection!");

        // 변경된 필드 값을 사용하여 메서드 호출
        String updatedResult = hello.hello();
        System.out.println("updatedResult = " + updatedResult);

        // 동적으로 메서드 호출하기
        Method helloMethod = helloClass.getDeclaredMethod("hello");
        String dynamicResult = (String) helloMethod.invoke(hello);
        System.out.println("dynamicResult = " + dynamicResult);
    }
}
