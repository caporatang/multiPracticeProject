package com.multi.pratice.multipratice.java.basic.oop.collections.set.treeset;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.collections.set.treeset
 * fileName : ComparatorTest
 * author : taeil
 * date : 2023/04/19
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/19        taeil                   최초생성
 */

class MyCompare implements Comparator<String> {
    // 보통 Comparable을 많이 사용하며,
    // 이미 Comparable이 구현되어 있는 경우 Comparator로 비교하는 방식을 다시 구현할때 Comparator를 사용한다
    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2) * (-1);
    }
}

public class ComparatorTest {

    public static void main(String[] args) {
        // 정렬 비교를 어떤 클래스로 할지를 설정
        TreeSet<String> treeSet = new TreeSet<>(new MyCompare());
        treeSet.add("kim");
        treeSet.add("tae");
        treeSet.add("il");

        System.out.println(treeSet);
    }


}