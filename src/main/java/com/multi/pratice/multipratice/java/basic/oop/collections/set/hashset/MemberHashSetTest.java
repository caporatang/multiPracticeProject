package com.multi.pratice.multipratice.java.basic.oop.collections.set.hashset;


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
public class MemberHashSetTest {

    public static void main(String[] args) {
        // 순서x 중복x

        MemberHashSet memberHashSet = new MemberHashSet();

        Member member1 = new Member(1001, "11");
        Member member2 = new Member(2002, "22");
        Member member3 = new Member(3003, "33");

        memberHashSet.addMember(member1);
        memberHashSet.addMember(member2);
        memberHashSet.addMember(member3);

        memberHashSet.showAllMember();

        Member member4 = new Member(3003, "33");
        memberHashSet.addMember(member4);
        memberHashSet.showAllMember();
    }
}