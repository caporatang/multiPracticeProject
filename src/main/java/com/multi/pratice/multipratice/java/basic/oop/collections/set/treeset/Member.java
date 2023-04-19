package com.multi.pratice.multipratice.java.basic.oop.collections.set.treeset;

import lombok.*;

import java.util.Comparator;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.collections.set.treeset
 * fileName : Member
 * author : taeil
 * date : 2023/04/19
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/19        taeil                   최초생성
 */
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//public class Member implements Comparable<Member>{
public class Member implements Comparator<Member> {
    private int memberId;
    private String memberName;



    /*
    @Override
    public int compareTo(Member member) {
        // implements Comparable
        // 비교와 정렬 기준을 잡을 메서드
        // 매개변수 member는 새로 추가되는 element
        // add 가 호출될떄마다 compareTo로 비교한다

        // 기존 element 가 큰경우 양수, 작다면 음수가 반환된다. 같다면 0이 반환된다.
        // if (this.memberId > member.memberId ) return 1;
        // else if ( this.memberId < member.memberId) return -1;
        // else return 0;


        //return (this.memberId - member.memberId); // 오름차순
        return (this.memberId - member.memberId) * (-1); // 내림차순
    }
    */


    // Comparator
    @Override
    public int compare(Member member1, Member member2) {
        // 앞에것에서 뒤에것을 마이너스한 값이 더 크다
        // return (member1.memberId - member2.memberId); // 오름차순
        return (member2.memberId - member1.memberId); // 내림차순
    }
}