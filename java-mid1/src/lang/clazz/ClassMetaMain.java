package lang.clazz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ClassMetaMain {

    public static void main(String[] args) throws Exception{
        // 클래스 불러오기
        Class clazz = String.class;
        Class clazz1 = new String().getClass();
        Class<?> clazz2 = Class.forName("java.lang.String");


        // 생성자 정보 얻기
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("constructor = " + constructor);
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.println("parameterType = " + parameterType);
            }
        }

        // 필드 정보 얻기
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field.getType() + " " + field.getName());
        }

        // 메서드 정보 얻기(전체 혹은 하나를 가져올 수 있다.)
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Method declaredMethod = clazz.getDeclaredMethod("toString");
        for (Method method : declaredMethods) {
            System.out.println("method = " + method);
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("parameter = " + parameter);
            }

        }
        System.out.println("declaredMethod = " + declaredMethod);

        // 슈퍼 클래스 정보 얻기
        System.out.println("SuperClass " + clazz.getSuperclass().getName());

        // 구현 인터페이스 정보 얻기
        Class[] interfaces = clazz.getInterfaces();
        for (Class i : interfaces) {
            System.out.println("i = " + i);
        }
    }
}
