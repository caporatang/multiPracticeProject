package com.multi.pratice.multipratice.java.basic.oop.collections.set.treeset;


import java.util.TreeSet;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.collections.list.arraylist
 * fileName : MemberArrayListTest
 * author : taeil
 * date : 2023/04/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/18        taeil                   최초생성
 */
public class MemberTreeSetTest {

    public static void main(String[] args) {

        /*
        // treeSet은 입력된 데이터들이 정렬되어 출력된다.
        TreeSet<String> set = new TreeSet<String>();

        set.add("스트링1");
        set.add("스트링2");
        set.add("스트링3");

        System.out.println(set);
        */

        // treeSet 출력 시, Comparable, Comparator 을 구현하지 않는다면 에러가 발생된다.
        MemberTreeSet memberTreeSet = new MemberTreeSet();

        Member member1 = new Member(1001, "11");
        Member member2 = new Member(2002, "22");
        Member member3 = new Member(3003, "33");

        memberTreeSet.addMember(member1);
        memberTreeSet.addMember(member2);
        memberTreeSet.addMember(member3);

        memberTreeSet.showAllMember();
    }
}