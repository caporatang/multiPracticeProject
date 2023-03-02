import com.multi.pratice.multipratice.springbasic.junit.basicjavajunit.Calculator;
import com.multi.pratice.multipratice.springbasic.junit.basicjavajunit.DollarCalculator;
import com.multi.pratice.multipratice.springbasic.junit.basicjavajunit.MarketApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * packageName : com.multi.pratice.multipratice
 * fileName : DollarCalculatorTest
 * author : taeil
 * date : 2023/03/02
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/02        taeil                   최초생성
 */

@ExtendWith(MockitoExtension.class) // -> Mock처리
public class DollarCalculatorTest {

    @Mock
    public MarketApi marketApi;

    @BeforeEach // -> 테스트가 실행되기 이전에
    public void init() {
        // marketApi에 connect가 호출될때 3000원 리턴
        Mockito.lenient().when(marketApi.connect()).thenReturn(3000);
    }


    @Test
    public void testHello() {
        System.out.println("hello");
    }

    @Test
    public void dollarTest() {
        MarketApi marketApi = new MarketApi();
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        Calculator calculator = new Calculator(dollarCalculator);

        System.out.println(calculator.sum(10,10));

        Assertions.assertEquals(22000, calculator.sum(10,10));
        Assertions.assertEquals(0, calculator.minus(10,10));

    }

    @Test
    public void mockTest() {

        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        Calculator calculator = new Calculator(dollarCalculator);

        System.out.println(calculator.sum(10,10));

        Assertions.assertEquals(60000, calculator.sum(10,10));
        Assertions.assertEquals(0, calculator.minus(10,10));

    }


}