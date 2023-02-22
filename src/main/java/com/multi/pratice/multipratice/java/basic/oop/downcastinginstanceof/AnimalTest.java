package com.multi.pratice.multipratice.java.basic.oop.downcastinginstanceof;

import com.multi.pratice.multipratice.java.basic.oop.downcastinginstanceof.Animal;

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

class Animal {
    public void move() {
        System.out.println("동물이 움직임");
    }

    public void eating() {

    }

}

class Human extends Animal {
    @Override
    public void move() {
        System.out.println("사람이 두 발로 걷습니다");
    }

    public void readBook() {
        System.out.println("사람이 책을 읽음");
    }

}

class Tiger extends Animal {
    @Override
    public void move() {
        System.out.println("네 발로 걷습니당");
    }

    public void hunting() {
        System.out.println("사냥함");
    }
}

class Eagle extends Animal {
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
        Animal hAnimal = new Human();
        Animal tAnimal = new Tiger();
        Animal eAnimal = new Eagle();

        AnimalTest test = new AnimalTest();
//        test.moveAnimal(hAnimal);
//        test.moveAnimal(tAnimal);
//        test.moveAnimal(eAnimal);

        ArrayList<Animal> animalList = new ArrayList<>();
        animalList.add(hAnimal);
        animalList.add(tAnimal);
        animalList.add(eAnimal);

        for(Animal animal : animalList) {
            animal.move();
        }
        test.testDownCasting(animalList);

    }

    public void testDownCasting(ArrayList<Animal> list) {
        for(int i =0; i < list.size(); i++) {
            Animal animal = list.get(i);

            if(animal instanceof Tiger) {
                Tiger tiger = (Tiger) animal;
                tiger.hunting();

            } else if(animal instanceof Eagle) {
                Eagle eagle = (Eagle)animal;
                eagle.flying();

            } else if(animal instanceof Human) {
                Human human = (Human) animal;
                human.readBook();

            } else {
                System.out.println("unsupported Type instance");
            }
        }
    }
    public void moveAnimal(Animal animal) {
        animal.move();
    }
}