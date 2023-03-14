package com.multi.pratice.multipratice.algorithm.basic.sort;

/**
 * packageName : com.multi.pratice.multipratice.algorithm.basic.sort
 * fileName : Sort
 * author : taeil
 * date : 2023/03/14
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/14        taeil                   최초생성
 */
public class InsertionSort {
    // 평균 수행 시간이 O(n^2)인 알고리즘 -> n2
    // 정렬의 종류 : 버블(bubble) 정렬, 삽입(insertion) 정렬, 선택(selection) 정렬

    // 삽입 정렬 (Insertion Sort)
    // Insertion Sort의 기본 개념은 이미 정렬된 상태의 요서에 새로운 요소를 추가할 때 정렬하여 추가하는 개념이다.
    // 두 번째 요소 부터 이전 요소들과 비교하면서 insert 될 위치를 찾아가며 정렬하는 알고리즘

    public static void main(String[] args) {
        int[] arr = {80, 50, 70, 10, 60, 20, 40, 30};
        insertionSort(arr, 8);
    }

    public static void printSort(int[] value, int count)
    {
        int i = 0;
        for(i = 0; i < count; i++) {
            System.out.println(value[i] + "\t");
        }
        System.out.println();
    }

    public static void insertionSort(int[] arr, int count) {
        // 배열의 데이터가 10 60 20 40 30 일때,
        int i = 0, j = 0;
        int temp = 0;

        for(i = 1; i < count; i++) {
            temp = arr[i]; // temp -> 현재 비교할값
            j = i;

            while ((j > 0) && arr[j-1] > temp) {
                arr[j] = arr[j-1]; // -> 이전 인덱스와 비교했을떄, 이전값이 더 크다면 현재 인덱스에 이전 인덱스(j-1)의 값을 넣어줌
                j = j - 1; // -> j를 한칸 -해서 비교
            }
            arr[j] = temp;
            System.out.println("반복 -" + i);
            printSort(arr, count);
        }

    }


}