package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV2 {

    public static void main(String[] args) {
        AnimalHospitalV2<Dog> dogHospital = new AnimalHospitalV2<>();
        AnimalHospitalV2<Cat> catHospital = new AnimalHospitalV2<>();

        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("냐옹이1", 300);

        // 개 병원
        dogHospital.setAnimal(dog);
        dogHospital.checkup();

        // 고양이 병원
        catHospital.setAnimal(cat);
        catHospital.checkup();

        dogHospital.setAnimal(dog);
        catHospital.setAnimal(cat);

        Dog biggerDog = dogHospital.getBigger(new Dog("멍멍이", 200));
        System.out.println("biggerDog = " + biggerDog);
    }
}
