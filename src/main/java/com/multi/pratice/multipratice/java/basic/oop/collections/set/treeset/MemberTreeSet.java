package com.multi.pratice.multipratice.java.basic.oop.collections.set.treeset;





import java.util.Iterator;
import java.util.TreeSet;


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
public class MemberTreeSet {

    private TreeSet<Member> treeSet;

    public MemberTreeSet() {
        // Comparable 은 그냥 구현해도 무방하다
        // treeSet = new TreeSet<>();

        // Comparator를 사용하는 경우에는 Comparator가 구현되어 있는 객체를 지정 해주어야 한다.
        treeSet = new TreeSet<Member>(new Member());
    }

    public void addMember(Member member) {
        treeSet.add(member);
    }

    public boolean removeMember(int memberId) {
        Iterator<Member> ir = treeSet.iterator();

        while (ir.hasNext()) {
            Member member = ir.next(); // 다음 객체로로 포인터 이동

            int tempId = member.getMemberId();
            if(tempId == memberId) {
                treeSet.remove(member);
                return true;
            }
        }

        System.out.println(memberId + "가 존재하지 않습니다.");
        return false;
    }

    public void showAllMember() {
        for (Member member : treeSet) {
            System.out.println(member);
        }
        System.out.println();
    }
}