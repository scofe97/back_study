package lang.object;

public class Dog {
    private String dogName;
    private int age;

    public Dog(){}

    public Dog(String dogName, int age) {
        this.dogName = dogName;
        this.age = age;
    }

        @Override
    public String toString() {
        return "Dog{" +
                "dogName='" + dogName + '\'' +
                ", age=" + age +
                '}';
    }
    public void sound(){
        System.out.println("멍멍");
    }
}
