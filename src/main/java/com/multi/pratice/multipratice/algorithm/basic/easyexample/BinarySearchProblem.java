package com.multi.pratice.multipratice.algorithm.basic.easyexample;

/**
 * packageName : com.multi.pratice.multipratice.algorithm.basic.easyexample
 * fileName : FindSortedNumber
 * author : taeil
 * date : 2023/03/13
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/13        taeil                   최초생성
 */
public class BinarySearchProblem {

    // 이진 탐색(binary search)

    // 여러 개의 수가 정렬된 순서로 있을 때 특정한 수를 찾는 방법
    // 단순 반복문을 이용하면 수의 개수에 따라 비교 횟수가 증가하는 O(n)의 수행이 이루어짐
    // 수가 정렬된 상태에서는 이진 탐색(binary search)을 활용하면 매번 비교되는 요소의 수가 절반으로 감소될 수 있으므로 O(logN)의 수행으로 원하는 수를 ㅊ자을 수 있음
    // 수의 예 {12, 25, 31, 48, 54, 66, 70, 83, 95, 108}
    // 83의 위치를 찾아보세요
    // 88의 위치를 찾아보세요 --> 없으면 없음 출력

    // 해결 방법
    // 수가 정렬된 상태이므로 중간의 값을 하나 선택한다. 찾으려는 값이 그보다 크면 범위를 오른쪽으로 그보다 작으면 범위를 왼쪽으로 좁힐수 있다.
    // 한번 비교 할때 마다 1/2씩 범위가 좁혀진다.

    public static void main(String[] args) {
        int[] numbers = {12, 25, 31, 48, 54, 66, 70, 83, 95, 108};
        int target = 83; // --> 찾을 타겟 값

        int left = 0; // -> 제일 왼쪽 기준
        int right = numbers.length - 1; // -> 제일 오른쪽 기준

        int mid = (left + right) / 2; // --> 이진 탐색의 기준이 될 중간 가져오기

        int temp = numbers[mid]; // -> 위에서 가져온 중간 인덱스 -> 비교해줄 중간값을 배열에서 가져옴
        boolean find = false; //-> 결과를 출력할지 안할지 결정할 플래그 값

        while (left <= right) {

            System.out.println("나는 비교 중간값이야 >> " + mid);
            if(target == temp) {
                // 찾을값(target) 과 중간값(temp)이 같으면 !
                find = true;
                break;
            }
            else if( target < temp) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
            mid = (left + right) /2;
            temp = numbers[mid];

        }
        if(find == true) {
            mid++; // 0번째 있습니다. 를 방지..
            System.out.println("찾는 수는 " + mid + "번째 있습니다.");
        }
        else System.out.println("찾는 수가 없습니다.");
    }





}