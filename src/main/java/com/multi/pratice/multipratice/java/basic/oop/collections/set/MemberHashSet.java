package com.multi.pratice.multipratice.java.basic.oop.collections.set;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;



/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.collections.list.arraylist
 * fileName : MemberArrayList
 * author : taeil
 * date : 2023/04/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/18        taeil                   최초생성
 */
public class MemberHashSet {

    private HashSet<Member> hashSet;

    public MemberHashSet() {
        hashSet = new HashSet<>();
    }

    public MemberHashSet(int size) {
        hashSet = new HashSet<>(size);
    }

    public void addMember(Member member) {
        hashSet.add(member);
    }

    public boolean removeMember(int memberId) {
        Iterator<Member> ir = hashSet.iterator();

        while (ir.hasNext()) {
            Member member = ir.next(); // 다음 객체로로 포인터 이동

            int tempId = member.getMemberId();
            if(tempId == memberId) {
                hashSet.remove(member);
                return true;
            }
        }

        System.out.println(memberId + "가 존재하지 않습니다.");
        return false;
    }

    public void showAllMember() {
        for (Member member : hashSet) {
            System.out.println(member);
        }
        System.out.println();
    }
}