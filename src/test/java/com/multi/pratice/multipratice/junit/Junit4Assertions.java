package com.multi.pratice.multipratice.junit;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : com.multi.pratice.multipratice.junit
 * fileName : BasicAssertions
 * author : taeil
 * date : 2023/04/12
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/12        taeil                   최초생성
 */
@SpringBootTest
public class Junit4Assertions {

    @Test
    @DisplayName("Junit4 : 객체의 동일성 여부")
    public void test() {
        String expected = "taeil";
        String actual = "taeil";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Junit4 : 배열의 동일성 여부")
    public void arrayEquals() {
        char[] expected = {'J','u','n','i','t'};
        char[] actual = "Junit".toCharArray();

        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Junit4 : 객체의 null 체크 -> 5와 동일")
    public void nullTest() {
        Object nullObject = null;
        assertNull(nullObject, "null check");
    }

    @Test
    @DisplayName("Junit4 : 두 변수가 동일한 객체를 참조하는지 확인")
    public void notSame() {
        Object car = new Object();
        Object car2 = new Object();

        assertNotSame(car, car2);
    }

    @Test
    @DisplayName("Junit4 : 특정 조건이 true인지 false인지 -> assertTrue, assertFalse")
    public void trueFalse() {
        assertTrue(5 > 4, "5 is greater then 4");
        assertFalse(5 > 6, "5 is not greater then 6");
    }

    @Test
    @DisplayName("Junit4 : 실패케이스를 만드는 fail -> Junit5 도 동일")
    public void failTest() {
        // 제공된 실패 메시지와 기본 원인으로 테스트에 실패
        // 개발이 완료되지 않은 테스트를 표시하는 데 유용
        try {
            fail("Exception not thrown"); // -> 익셉션 출력
        } catch (UnsupportedOperationException e) {
            assertEquals("Operation Not Supported", e.getMessage());
        }
    }
}