package com.multi.pratice.multipratice.algorithm.basic.easyexample;

/**
 * packageName : com.multi.pratice.multipratice.algorithm.basic
 * fileName : MinMax
 * author : taeil
 * date : 2023/03/13
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/13        taeil                   최초생성
 */
public class MinMax {
    // 문제 : 여러개의 수가 배열에 있을 때 그 중 가장 큰 값과 가장 작은 값을 찾기
    // 배열의 몇 번째 순서에 있는지 찾기
    // 반복문을 한번만 사용하기
    // 수의 예 : [10, 55, 23, 2, 79, 101, 16, 82, 30, 45]

    // 해결 : 배열에 있는 수 중 맨 처음에 있는 값을 max, min으로 가정
    // 배열의 마지막 숫자까지 비교하면서 더 큰 수나 더 작은 수가 나올때 max와 min의 값을 바꾸도록한다.

    public static void main(String[] args) {
        int[] numbers = {10, 55, 23, 2, 79, 101, 16,82, 30, 45};

        int min = numbers[0];
        int max = numbers[0];

        int minPos = 0;
        int maxPos = 0;

        for (int i = 0; i < numbers.length; i++) {
            if(min > numbers[i]) {
                min = numbers[i];
                minPos = i + 1;
            }

            if(max < numbers[i]) {
                max = numbers[i];
                maxPos = i + 1;
            }
        }
        System.out.println("가장 큰 값은 " + max + "이고, 위치는 " + maxPos + "번째 입니다.");
        System.out.println("가장 작은 값은 " + min + "이고, 위치는 " + minPos + "번째 입니다.");
    }
    // 반복문의 한번 수행으로 두 개의 원하는 값을 모두 찾을 수 있음, 이 경우 수행 속도는 나열된 수의 개수에 비례하므로 O(n)이 된다.
}