package com.multi.pratice.multipratice.java.basic.oop.collections.map.hashmap;

import java.util.HashMap;
import java.util.Iterator;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.collections.map.hashmap
 * fileName : MemberHashMap
 * author : taeil
 * date : 2023/04/20
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/20        taeil                   최초생성
 */
public class MemberHashMap {
    private HashMap<Integer, Member> hashMap;

    public MemberHashMap() {
        hashMap = new HashMap<>();
    }

    public void addMember(Member member) {
        hashMap.put(member.getMemberId(), member);
    }

    public boolean removeMember(int memberId) {
        // containsKey -> key값을 기준으로 요소의 포함여부를 boolean으로 리턴
        if(hashMap.containsKey(memberId)) {
            hashMap.remove(memberId);
        }
        System.out.println("no element");
        return false;
    }

    public void showAllMember() {
        //System.out.println(hashMap);
        Iterator<Integer> ir = hashMap.keySet().iterator(); // -> key값들을 반환
        while (ir.hasNext()) {
            int key = ir.next();
            Member member = hashMap.get(key);
            System.out.println(member);
        }
    }
}