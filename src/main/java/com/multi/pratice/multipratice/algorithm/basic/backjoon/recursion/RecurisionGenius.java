package com.multi.pratice.multipratice.algorithm.basic.backjoon.recursion;

import java.util.Scanner;

/**
 * packageName : com.multi.pratice.multipratice.algorithm.basic.backjoon.recursion
 * fileName : RecurisionGenius
 * author : taeil
 * date : 2023/01/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/23        taeil                   최초생성
 */
public class RecurisionGenius {
    // 백준 25501번

    // 입력
    // 첫째 줄에 테스트케이스의 개수 $T$가 주어진다. (1 < T < 1000)
    // 둘째 줄부터 T개의 줄에 알파벳 대문자로 구성된 문자열 S가 주어진다. (1 < |S| < 1000)

    // 각 테스트케이스마다, isPallindrome  함수의 반환값과 recursion함수의 호출 횟수를 한 줄에 공백으로 구분하여 출력한다.

    //문제에서 예제로 주어진 힌트코드를 보고 참고해서 풀어보도록하자 ..
    static int cnt;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i =0; i < T; i++) {
            cnt =0;
            System.out.println(isPalindrome(sc.next()) + " " + cnt);
        }
        sc.close();
    }
    public static int recursion(String s, int l, int r){
        cnt++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }

}