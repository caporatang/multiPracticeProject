package com.multi.pratice.multipratice.algorithm.basic.easyexample.greedy;

/**
 * packageName : com.multi.pratice.multipratice.algorithm.basic.easyexample.greedy
 * fileName : GreedyTest
 * author : taeil
 * date : 2023/07/15
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/07/15        taeil                   최초생성
 */
public class BasicGreedyTest {
    // 문제 정의 :
    // 가게에 간 철수는 8370원 어치 물건을 구매하였습니다. 철수에게는 500원짜리 20개 100원짜리 20개  50원짜리 20개 10원짜리 20개의 동전이 있습니다.
    // 철수는 금액을 지불 할 때 단위가 큰 동전부터 지불하려고 합니다.
    // 철수가 지불하게 되는 각 동전의 개수를 구하세요.

    // 문제 해결 :
    // 이러한 문제의 경우 철수는 우선 500원짜리 동전부터 사용할 것이다. 간단하게 계산을 해보면 8370 = 500 * 16 + 100 * 3 + 50 * 1 + 10 * 2 가 된다.
    // 가장 큰 동전을 이용하여 지불할 수 있는 최대 금액을 지불하고 그 다음 큰 금액의 동전을 지불하는 순서로 구현한다
    // 동전의 종류만큼 반복문이 수행된다.

    // count나 더 복잡한 Greedy도 풀어보자..~

    public static void main(String[] args) {

        int[] coins = {500, 100, 50, 10};
        int price = 8370;
        int count;

        for (int i = 0; i< coins.length; i++) {
            count = 0;
            count += price / coins[i];
            price = price % coins[i];

            System.out.println( coins[i] + "짜리 동전 " + count + "가 필요합니다.");
        }

    }

}