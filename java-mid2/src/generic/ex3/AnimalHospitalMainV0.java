package generic.ex3;

import generic.animal.Cat;
import generic.animal.Dog;

public class AnimalHospitalMainV0 {

    public static void main(String[] args) {
        DogHospital dogHospital = new DogHospital();
        CatHospital catHospital = new CatHospital();

        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("냐옹이1", 300);

        // 개 병원
        dogHospital.setAnimal(dog);
        dogHospital.checkup();

        // 고양이 병원
        catHospital.setAnimal(cat);
        catHospital.checkup();

        // dogHospital.setAnimal(cat);
        dogHospital.setAnimal(dog);
        Dog biggerDog = dogHospital.bigger(new Dog("멍멍이", 200));
        System.out.println("biggerDog = " + biggerDog);
    }
}
