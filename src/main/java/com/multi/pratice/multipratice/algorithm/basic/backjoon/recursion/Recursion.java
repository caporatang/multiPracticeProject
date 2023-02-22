package com.multi.pratice.multipratice.algorithm.basic.backjoon.recursion;



import java.util.Scanner;

/**
 * packageName : com.multi.pratice.multipratice.algorithm.basic.backjoon.recursion
 * fileName : Recursion
 * author : taeil
 * date : 2023/01/22
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/22        taeil                   최초생성
 */
public class Recursion {

    // 재귀함수
    // 재귀함수란 자기 자신을 재참조하는 방법을 뜻함.. 이를 이용하여 알고리즘이나 프로그래밍에서 재귀호출을 사용함
    // 단순하게 곱하기를 하여 출력하는 문제라던지, 배열에 있는 숫자들을 가져오는 경우에는 일반적인 for문으로 구현해도 되지만 배열안에 배열, 혹은 문자열 등이 포함되어 있는 경우에는 재귀함수가 훨씬 효과적임

    // 재귀호출 예제 backjoon10872(팩토리얼)
    public static void main(String[] args) {
        // 팩토리얼 -> ex) 5가 주어지는 경우 -> 5x4x3x2x1 => 120이 출력되게 해야하는 문제
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = Faction(n);
        System.out.println(sum);
    }
    public static int Faction(int n) {
        // 함수 종료
        if(n==1) {
            return 1;
        } else {
            // 5*4 = 20
            // 20*3 = 60
            // 60*2 = 120
            // 120 * 1 = 120
            return n * Faction(n-1);
        }
    }

    //  배열의 값을 뽑아와서 일반 for문으로 돌리는 경우
//    public static void main(String[] args) {
//        int[] beer = {6,7,8,9,10};
//        int sum = 1;
//        for (int i = 0; i < beer.length; i++) {
//            if(i != beer.length) {
//                sum *= beer[i];
//            }
//            System.out.println("배열" + beer[i]);
//            System.out.println(i + "번째를 곱했어요, 값은 : " + sum);
//        }
//    }



}