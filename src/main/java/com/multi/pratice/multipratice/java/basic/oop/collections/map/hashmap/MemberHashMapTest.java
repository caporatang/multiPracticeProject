package com.multi.pratice.multipratice.java.basic.oop.collections.map.hashmap;


import java.util.HashMap;

/**
 * packageName :
 * fileName : MemberHashMapTest
 * author : taeil
 * date : 2023/04/20
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/18        taeil                   최초생성
 */
public class MemberHashMapTest {

    public static void main(String[] args) {
        MemberHashMap memberHashMap = new MemberHashMap();

        Member member1 = new Member(1001, "11");
        Member member2 = new Member(2002, "22");
        Member member3 = new Member(3003, "33");

        memberHashMap.addMember(member1);
        memberHashMap.addMember(member2);
        memberHashMap.addMember(member3);

        memberHashMap.showAllMember();
    }
}