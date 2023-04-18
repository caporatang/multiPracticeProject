package com.multi.pratice.multipratice.java.basic.oop.collections.list.arraylist;

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
public class MemberArrayListTest {

    public static void main(String[] args) {
        MemberArrayList memberArrayList = new MemberArrayList();

        Member member1 = new Member(1001, "11");
        Member member2 = new Member(2002, "22");
        Member member3 = new Member(3003, "33");
        Member member4 = new Member(4004, "44");

        memberArrayList.addMember(member1);
        memberArrayList.addMember(member2);
        memberArrayList.addMember(member3);
        memberArrayList.addMember(member4);

        memberArrayList.showAllMember();
        memberArrayList.removeMember(member1.getMemberId());
        memberArrayList.showAllMember();
    }
}