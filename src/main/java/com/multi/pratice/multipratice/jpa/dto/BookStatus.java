package com.multi.pratice.multipratice.jpa.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName : com.multi.pratice.multipratice.jpa.dto
 * fileName : BookStatus
 * author : taeil
 * date : 2023/04/07
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/07        taeil                   최초생성
 */
@Getter
@Setter
@ToString
public class BookStatus {
    private int code;
    private String description;

    public BookStatus(int code) {
        this.code = code;
        this.description = parseDescription(code);
    }

    public boolean isDisplayed() {
        return code == 200;
    }

    public String parseDescription(int code) {
        // Converter에서 받아온 코드 값에 따른 스트링 분기 처리
        // DB에 저장된 code라는 컬럼의 데이터가 100 이라면 -> "판매종료", 200 이라면 판매중 이라는 값으로 description 으로 조회된다.
        // 로그나 System.out.println으로 데이터를 출력하면 status=BookStatus(code=100, description=판매종료)로 출력된다.
        switch (code) {
            case 100:
                return "판매종료";
            case 200:
                return "판매중";
            case 300:
                return "판매보류";
            default:
                return "미지원";
        }
    }
}