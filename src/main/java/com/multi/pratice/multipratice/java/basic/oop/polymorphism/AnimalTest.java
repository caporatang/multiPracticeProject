package com.multi.pratice.multipratice.java.basic.oop.polymorphism;

import java.util.ArrayList;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.polymorphism
 * fileName : AnimalTest
 * author : taeil
 * date : 2023/01/29
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/29        taeil                   최초생성
 */

class Aniaml {
    public void move() {
        System.out.println("동물이 움직임");
    }

    public void eating() {

    }

}

class Human extends Aniaml {
    @Override
    public void move() {
        System.out.println("사람이 두 발로 걷습니다");
    }

    public void readBook() {
        System.out.println("사람이 책을 읽음");
    }

}

class Tiger extends Aniaml {
    @Override
    public void move() {
        System.out.println("네 발로 걷습니당");
    }

    public void hunting() {
        System.out.println("사냥함");
    }
}

class Eagle extends Aniaml {
    @Override
    public void move() {
        System.out.println("독수리가 하늘을 날아다님");
    }

    public void flying() {
        System.out.println("독수리가 양날개를 펴고 날아다님");
    }

}

public class AnimalTest {

    public static void main(String[] args) {
        Aniaml hAnimal = new Human();
        Aniaml tAnimal = new Tiger();
        Aniaml eAnimal = new Eagle();

        AnimalTest test = new AnimalTest();
//        test.moveAnimal(hAnimal);
//        test.moveAnimal(tAnimal);
//        test.moveAnimal(eAnimal);

        ArrayList<Aniaml> animalList = new ArrayList<>();
        animalList.add(hAnimal);
        animalList.add(tAnimal);
        animalList.add(eAnimal);

        for(Aniaml animal : animalList) {
            animal.move();
        }

    }

    public void moveAnimal(Aniaml animal) {
        animal.move();

    }


}