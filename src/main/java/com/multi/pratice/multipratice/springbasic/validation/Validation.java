package com.multi.pratice.multipratice.springbasic.validation;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.validation
 * fileName : Validation
 * author : taeil
 * date : 2023/02/26
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/26        taeil                   최초생성
 */
public class Validation {
    // validation이란 다양한 exception,
    // 특히 java에서는 null값에 대해서 접근하려고 할때, npe가 발생함으로 이러한 부분들을 미리 검증하는 과정을 Validation이라고함

    // ex)
    // public void run(String account, Spring pw, int age) {
    //    if(account == null || pw == null) {
    //       return;
    //    }
    //    if(age == 0 ) {
    //        return
    //    }
    //}
    // 위 코드 처럼 작성을 자주 많이 하게 되는 경우 문제점
    // 1. 검증해야 할 값이 많은 경우 코드의 길이가 길어짐
    // 2. 구현에 따라서 달라 질 수 있지만 Service Logic과의 분리가 필요함
    // 3. 흩어져 있는 경우 어디에서 검증을 하는지 알기 어려우며, 재사용의 한계가 있음
    // 4. 구현에 따라 달라 질 수 있지만, 검증 Logic이 변경 되는 경우 테스트 코드 등 참조하는 클래스에서 Logic이 변경되어야 하는 부분이 발생 할 수 있음

    // 대표적인 Annotation
    // @Size : 문자 길이 측정 (int 타입 불가)
    // @NotNull : null 불가
    // @NotEmpty : null불가, "" 불가
    // @NotBlank : null, "", " " 불가
    // @Past : 과거 날짜
    // @PastOrPresent : 오늘이거나 과거 날짜
    // @Future : 미래 날짜
    // @FutureOrPresent : 오늘이거나 미래 날짜
    // @Pattern : 정규식 적용
    // @Max : 최대값
    // @Min : 최소값
    // @AssertTrue / False : 별도 Logic적용
    // @Valid : 해당 object validation 실행

    // 간단한 핸드폰번호 체크 정규식 : "^\\d{2,3}-\\d{3,4}-\\d{4}\$"






}