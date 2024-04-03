package lang.object;

public class Car {

    private String carName;

    public Car(){};
    public Car(String carName) {
        this.carName = carName;
    }


    public void move(){
        System.out.println("자동차 이동");
    }
}
