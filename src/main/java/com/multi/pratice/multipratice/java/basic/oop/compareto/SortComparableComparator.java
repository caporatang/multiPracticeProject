package com.multi.pratice.multipratice.java.basic.oop.compareto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.compareto
 * fileName : SortComparableComparator
 * author : taeil
 * date : 2023/06/28
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/06/28        taeil                   최초생성
 */
public class SortComparableComparator {
    // Comparable, Comparator, 배열을 정렬하는 여러가지 방법 JAVA에서 배열을 정렬을 하는 방법은 여러가지가 있다.
    // 먼저 기본 자료형인 int, double, String 등의 배열은 Arrays.sort() 메서드를 호출하면 된다.

    public static void main(String[] args) {
        // 기본적인 배열 정렬
        int[] intArray = {5,2,1,4,3};

        // 1,2,3,4,5 로 정렬
        Arrays.sort(intArray);

        // 동적인 배열은 Collections sort
        List<Integer> intList = Arrays.asList(5, 2, 4, 1, 3);
        // 1, 2, 3, 4, 5로 정렬된다.
        Collections.sort(intList);

    }

    // Arrays.sort()는 파라미터로 T [] 인 기본 배열을 받고 Collections.sort() 파라미터로 List인 List를 받는다.
    // sort 메서드의 기본 자료형들은 어떻게 비교해서 정렬할 수 있는 이유는 Comparable 인터페이스를 구현했기 때문이다.
    // 즉, Comparable 인터페이스를 구현해서 compareTo 메서드를 오버라이딩한 클래스는 sort() 메서드를 통해 비교가 가능한 것이다.





}