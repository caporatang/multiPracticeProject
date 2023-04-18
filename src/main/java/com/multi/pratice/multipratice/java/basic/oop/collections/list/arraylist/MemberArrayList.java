package com.multi.pratice.multipratice.java.basic.oop.collections.list.arraylist;

import java.sql.SQLOutput;
import java.util.ArrayList;

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
public class MemberArrayList {

    private ArrayList<Member> arrayList;

    public MemberArrayList() {
        arrayList = new ArrayList<>();
    }

    public MemberArrayList(int size) {
        arrayList = new ArrayList<>(size);
    }

    public void addMember(Member member) {
        arrayList.add(member);
    }

    public boolean removeMember(int memberId) {
        for(int i = 0; i < arrayList.size(); i++) {
            Member member = arrayList.get(i);

            int tempId = member.getMemberId();
            if(tempId == memberId) {
                arrayList.remove(i);
                return true;
            }
        }
        System.out.println(memberId + "가 존재하지 않습니다.");
        return false;
    }

    public void showAllMember() {
        for (Member member : arrayList) {
            System.out.println(member);
        }
        System.out.println();
    }
}