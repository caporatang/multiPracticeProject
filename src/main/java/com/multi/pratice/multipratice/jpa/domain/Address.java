package com.multi.pratice.multipratice.jpa.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {
    // 공식문서에 ebmed 사용하면 좋은 케이스를 설명해주고 있음
    // ex) 근로기간, 전화번호(지역번호 국가번호 통신사 등..), 주소

    private String city;        // 시

    private String district;    // 구

    @Column(name = "address_detail") // -> entity객체가 아니여도 사용 가능
    private String detail;      // 상세주소

    private String zipCode;     // 우편번호
}
