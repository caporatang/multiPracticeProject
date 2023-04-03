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

    // Orphan Removal -> 고아 제거 속성
    // 연관관계를 끊을때는 setter를 통해 null을 주입함 -> update id = null

    // cascadeType.Remove 와의 차이
    // cascadeType.Remove는 상위 객체가 remove 액션을 취하면 포함 하고 있는 객체의 해당 영속성 이벤트를 전파 -> 하위 엔티티까지 remove 시키는 옵션
    // setter를 통해 null을 set해서 연관관계를 끊는 경우 remove 이벤트가 발생되지 않는다.
    // 연관관계가 끊어진 엔티티의 데이터를 살려둘것이라면 Orphan Removal = false를 주어야 하고, 끊어진 관계에서 데이터까지 삭제하려면 true를 설정해야한다

    // 실무에서는 soft delete를 많이 사용한다.



}