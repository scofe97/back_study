package annotation.basic.inherited;

import java.lang.annotation.Annotation;

public class InheritedMain {

    public static void main(String[] args) {
        print(Parent.class); // 2개 다 있음
        print(Child.class); // 1개(상속)만 있음
        print(TestInterface.class); // 2개 모두 있음
        print(TestInterfaceImpl.class); // 2개 모두 없음(인터페이스의 구현체는 메서드 시그니처만 정의할뿐 상태나 행위를 가지지 않는다.)
    }

    private static void print(Class<?> clazz) {
        System.out.println("clazz = " + clazz);
        Annotation[] annotations = clazz.getAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println("- = " + annotation.annotationType().getSimpleName());
        }
        System.out.println();
    }
}
