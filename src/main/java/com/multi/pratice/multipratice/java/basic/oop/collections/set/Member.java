package com.multi.pratice.multipratice.java.basic.oop.collections.set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.collections.list
 * fileName : UserArrayList
 * author : taeil
 * date : 2023/04/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/18        taeil                   최초생성
 */
@ToString
@Getter
@Setter
@AllArgsConstructor
public class Member {
    private int memberId;
    private String memberName;


    // 중복체크 로직
    // String은 내부적으로 스트링의 시퀸스가 같은걸로 판별
    // Integer는 int value로 같은지를 판별
    @Override
    public int hashCode() {
        return memberId;
    }

    @Override
    public boolean equals(Object obj) {

        if( obj instanceof Member) {

            Member member = (Member)obj;
            if(this.memberId == member.memberId) {
                return true;
            }
            else return false;
        }
        return false;
    }
}