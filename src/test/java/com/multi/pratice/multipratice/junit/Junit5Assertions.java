package com.multi.pratice.multipratice.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.BooleanSupplier;

import static java.time.Duration.ofSeconds;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : com.multi.pratice.multipratice.junit
 * fileName : Junit5Assertions
 * author : taeil
 * date : 2023/04/12
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/12        taeil                   최초생성
 */
@SpringBootTest
public class Junit5Assertions {

    @Test
    @DisplayName("assertArrayEquals")
    public void unitFiveArrayTest() {
        // 예상 배열과 실제 배열이 동일한지 확인
        // 배열이 같지 않으면 마지막 인자로 들어간 메세지가 출력됨
        char[] expected = { 'J', 'u', 'p', 'i', 't', 'e', 'r' };
        char[] actual = "Jupiter".toCharArray();

        assertArrayEquals(expected, actual, "Arrays should be equal");
    }

    @Test
    @DisplayName("assertEquals")
    public void unitFiveAssertEquals() {
        // 두 값을 비교하여 일치 여부 판단
        float square = 2 * 2;
        float rectangle = 2 * 2;

        assertEquals(square, rectangle);
    }

    @Test
    @DisplayName("assertTrue, false -> junit4와 동일")
    public void unitFiveTrueFalse() {
        BooleanSupplier condition = () -> 5 > 6;

        assertFalse(condition, "5 is not greater then 6");
    }

    @Test
    @DisplayName("assertSame")
    public void nullCheck() {
        // 예상되는 값과 실제 값이 동일한 객체를 참조하는지 확인-> JUnit4 버전과 동일
        String language = "Java";
        Optional<String> optional = Optional.of(language);

        assertSame(language, optional.get());
    }

    @Test
    @DisplayName("fail -> 제공된 실패 메시지와 기본 원인으로 테스트 실패, 개발이 완료되지 않은 테스트를 표시하는데 유용")
    public void failTest() {
        // Test not completed
        fail("FAIL - test not completed");
    }

    @Test
    @DisplayName("assertAll")
    public void assertAllTest() {
        // 모든 Assertion이 실행되고 실패가 함께 보고되는 그룹화된 Assertion
        // MultipleFailureError에 대한 메시지 문자열에 포함될 제목과 실행 가능한 스트림을 허용
        // 실행 파일 중 하나에서 OutOfMemoryError가 발생한 경우에만 중단됨
        assertAll(
                "heading",
                () -> assertEquals(4, 2 * 2, "4 is 2 times 2"),
                () -> assertEquals("java", "JAVA".toLowerCase())
        );
    }

    @Test
    @DisplayName("assertIterableEquals")
    public void iterableTest() {
        // 예상 반복 가능 항목과 실제 반복 가능 항목이 동일한지 확인
        // 두 Iterable은 동일한 순서로 동일한 요소를 반환해야 함
        // 두 Iterable이 동일한 유형일 필요는 없음
        // 아래에서 서로 다른 유형의 두 목록(LinkedList 및 ArrayList)이 동일한지 확인
        Iterable<String> al = new ArrayList<>(asList("Java", "Junit", "Test"));
        Iterable<String> ll = new LinkedList<>(asList("Java", "Junit", "Test"));

        assertIterableEquals(al, ll);
    }

    @Test
    @DisplayName("assertNotEquals")
    public void notEqualsTest() {
        // 예상 값과 실제 값이 다름을 확인
        Integer value = 5;
        assertNotEquals(0, value, "The result cannot be 0");
    }

    @Test
    @DisplayName("assertThrows")
    void assertThrowsTest() {
        // 특정 예외가 발생하였는지 확인
        // 첫 번째 인자는 확인할 예외 클래스
        // 두 번째 인자는 테스트하려는 코드
        Throwable exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    throw new IllegalArgumentException("Exception message");
                }
        );
        assertEquals("Exception message", exception.getMessage());
    }

    @Test
    @DisplayName("assertTimeout")
    public void timeoutTest() {
        // 특정 시간 안에 실행이 끝나는지 확인
        //시간 내 실행이 끝나는지 여부 확인 시 : assertTimeout
        //지정한 시간 내 끝나지 않으면 바로 종료 : assertTimeoutPreemptively
        assertTimeout(
                ofSeconds(2),
                () -> {
                    Thread.sleep(1000);
                }
        );
    }
}