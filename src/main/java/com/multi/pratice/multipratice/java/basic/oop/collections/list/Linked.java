package com.multi.pratice.multipratice.java.basic.oop.collections.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.collections.list
 * fileName : LinkedList
 * author : taeil
 * date : 2023/04/17
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/17        taeil                   최초생성
 */
public class Linked {

    public static void main(String[] args) {
        // 양방향 포인터 구조

        LinkedList<Integer> intList1 = new LinkedList<Integer>(); // 타입 지정
        LinkedList<Integer> intList2 = new LinkedList<>(); // 타입 생략 가능
        LinkedList<Integer> intList4 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5)); // Arrays.asList()

        // List를 구현했기 때문에 add() 메소드로 엘레멘트를 추가할 수 있고 set() 메소드로 기존에 추가된 값을 변경하는 것 또한 가능
        LinkedList<String> animalList = new LinkedList<>();
        animalList.add("나는 동물1");
        animalList.add("나는 동물2");
        animalList.add("나는 동물3");
        animalList.add("나는 동물4");

        // remove() 메소드로 값을 삭제할 수 있고 값 전체 삭제 하고 싶을 경우 clear()를 사용
        String zeroIndex = animalList.remove(0);
        System.out.println("remove된 데이터 : -> " + zeroIndex);

        // animalList.remove("나는 동물2");
        // System.out.println(animalList);

        // animalList.clear();
        // System.out.println("clear 후 리스트 : " + animalList);

        // 리스트에 있는 값 전체 출력 -> listIterator 사용
        ListIterator<String> listIterator = animalList.listIterator(animalList.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous() + " ");
        }
        System.out.println();

        // 리스트 안에 데이터 존재 유무 확인
        boolean contains = animalList.contains("나는 동물4");
        System.out.println("contains : " + contains);

        int index = animalList.indexOf("나는 동물4");
        System.out.println("index of 포함되어 있는 데이터 : " + index);

        index = animalList.indexOf("나는 없는 데이터");
        System.out.println("없는 데이터 테스트" + index);

    }






}