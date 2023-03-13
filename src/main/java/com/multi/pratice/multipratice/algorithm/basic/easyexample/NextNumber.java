package com.multi.pratice.multipratice.algorithm.basic.easyexample;

/**
 * packageName : com.multi.pratice.multipratice.algorithm.basic.easyexample
 * fileName : Test
 * author : taeil
 * date : 2023/03/13
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/13        taeil                   최초생성
 */
public class NextNumber {
    public static void main(String[] args) {
        int[] common = {1,2,3,4};
        int test = solution(common);
        System.out.println(common.length -1 );
        System.out.println(common.length);

    }

    public static int solution(int[] common) {
        int answer = 0;

        if(dngCha(common)) {
            answer = common[common.length -1] + common[2]-common[1];
        } else {

            answer = common[common.length -1] * (common[2]/common[1]);
        }
        return answer;
    }

    private static boolean dngCha(int[] common) {
        //           3          2             2            1
        return common[2] - common[1] == common[1] - common[0];
    }
    }


