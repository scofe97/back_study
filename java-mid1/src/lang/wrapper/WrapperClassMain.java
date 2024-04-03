package lang.wrapper;

public class WrapperClassMain {
    public static void main(String[] args) {
        // 래퍼 클래스 생성
        Integer newInteger = new Integer(10); //미래에 삭제 예정, 대신에 valueOf() 사용
        Integer integerObj = Integer.valueOf(10); //-128 ~ 127 자주 사용하는 숫자 값재사용, 불변
        Integer autoBoxing = 10; // 오토박싱
        Long longObj = Long.valueOf(100);
        Double doubleObj = Double.valueOf(10.5);

        System.out.println("newInteger = " + newInteger);
        System.out.println("integerObj = " + integerObj);
        System.out.println("longObj = " + longObj);
        System.out.println("doubleObj = " + doubleObj);
        System.out.println("내부 값 읽기");


        // 래퍼 클래스  -> 기본형
        int intValue = integerObj.intValue();
        Integer intValue2 = intValue; // 오토 언박싱
        System.out.println("intValue = " + intValue);

        long longValue = longObj.longValue();
        System.out.println("longObj = " + longValue);
        System.out.println("비교");

        System.out.println("==: " + (newInteger == integerObj));
        System.out.println("equals: " + newInteger.equals(integerObj));
    }
}
