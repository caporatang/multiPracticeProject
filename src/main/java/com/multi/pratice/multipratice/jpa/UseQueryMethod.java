package com.multi.pratice.multipratice.jpa;

/**
 * packageName : com.multi.pratice.multipratice.jpa
 * fileName : UseQueryMethod
 * author : taeil
 * date : 2023/04/05
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/05        taeil                   최초생성
 */
public class UseQueryMethod {
    // @Query --> 2가지 상황에서 주로 사용된다.
    // 1. 메서드 이름이 길어지는 경우 -> 가독성이 매우 떨어짐
    // 2. Entity에 연결되지 않아도 쿼리를 사용 할 수있음 -> 수많은 컬럼들 중 추려서 조회가 가능함

    // Native Query
    // DB에서 사용하는 sql을 그대로 사용하게 된다. -> 기존에 Entity에 걸어둔 옵션 같은 것들을 무시함.
    // 특정 데이터베이스에 의존적인 쿼리를 작성하게 된다.

    // 성능적인 이슈를 해결하기 위해 사용함 -> ex) 업데이트 같은 경우, jpa에서 제공하는 메서드는 조회를 하고 실행하기 때문에 성능 이슈가 발생할수있음



}