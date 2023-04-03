package com.multi.pratice.multipratice.jpa;

/**
 * packageName : com.multi.pratice.multipratice.jpa
 * fileName : CascadeType
 * author : taeil
 * date : 2023/04/03
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/03        taeil                   최초생성
 */
public class CascadeType {
    // 영속성 전이
    // ALL -> 모든 옵션을 전부 다 적용
    // PERSIST -> insert -> 관련된 엔티티에 insert가 일어나면 같이 insert
    // MERGE -> update
    // REMOVE -> 관련있는 엔티티를 삭제
    // REFRESH -> 엔티티를 로딩 했을때, 관련있는 엔티티를 재로딩
    // DETACH -> 관련있는 엔티티들을 영속성 분리 시킴
}