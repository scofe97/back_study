package lang.object;

public class ObjectPolyExample1 {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();

        action(dog);
        action(car);

        Car car1 = new Car("ModelY");
        Dog dog1 = new Dog("멍멍이1", 2);


        System.out.println("2. println 내부에서 toString 호출");
        System.out.println(car1);
        System.out.println(dog1);
        System.out.println("3. Object 다형성 활용");
        print(car1);
        print(dog1);
    }

    private static void action(Object obj) {
        // obj.sound() // 컴파일 오류, Object는 sound()가 없다.
        // obj.move() // 컴파일 오류, Object는 move()가 없다.

        if (obj instanceof Dog dog) {
            dog.sound();
        }

        if (obj instanceof Car car) {
            car.move();
        }
    }

    public static void print(Object obj) {
        String string = "객체 정보 출력: " + obj.toString();
        System.out.println(string);
    }
}
