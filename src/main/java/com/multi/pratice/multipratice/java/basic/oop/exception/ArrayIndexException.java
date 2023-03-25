package com.multi.pratice.multipratice.java.basic.oop.exception;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.exception
 * fileName : ArrayIndexException
 * author : taeil
 * date : 2023/03/25
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/25        taeil                   최초생성
 */
public class ArrayIndexException {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        try {
            for(int i =0; i <= 5; i++) {
                // index out of bounds~
                System.out.println(arr[i]);
            }
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("나는 getMessage : " + e.getMessage());
            System.out.println("나는 toString : " +e.toString());
        }
        System.out.println("here!!!");
    }


}