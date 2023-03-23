package com.multi.pratice.multipratice.java.basic.oop.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.stream
 * fileName : IntArrayStreamTest
 * author : taeil
 * date : 2023/03/23
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/23        taeil                   최초생성
 */
public class IntArrayStreamTest {
    public static <ArrayList> void main(String[] args) {

        int[] arr = {1,2,3,4,5};

        for(int num : arr) {
            System.out.println(num);
        }

        // -> int stream을 반환
        //Arrays.stream(arr);
        // -> 인트 스트림을 반복문으로 하나씩 꺼내기 -> n이라는 요소가 들어왔을때, n을 출력
        // Arrays.stream(arr).forEach(n -> System.out.println(n));
        Arrays.stream(arr).forEach(System.out::println);

        // 생성된 스트림을 따로 빼서 구현할수도있음 -> is라는 스트림을 한번 사용하고 나서 아래에서는 재활용할수없음
        // IntStream is = Arrays.stream(arr);
        // is.forEach(n -> System.out.println(n));

        int sum = Arrays.stream(arr).sum();
        System.out.println("나는 sum의 연산 결과 : " + sum);

        // 스트림은 최종연산이 호출되어야 중간 연산에 대한 수행이 이루어진다. -> 중간에 값들을 변경할수없다 --> 중간에 내부적으로 처리되는 일들을 확인할수없다
        // 중간 연산의 예 : filter(), map(), sorted() 등....
        // 조건에 맞는 요소를 추출(filter) 하거나 요소를 반환한다(map) -> 최종 연산이 호출될 때 중간 연산이 수행되고 결과가 생성 됨
        List<String> stringList = new java.util.ArrayList<>() {
            {
                add("testtest");
                add("12314");
                add("1");
                add("2");
            }
        };
        // 문자열 리스트에서 문자열의 길이가 5 이상인 요소만 출력하기 --> filter 중간 연산 , forEach() 는 최종 연산
        stringList.stream().filter(s -> s.length() >= 5).forEach(s -> System.out.println("나는 필터 예제 --> " + s));

        Stream<String> stream = stringList.stream();
        stream.forEach(System.out::println);
        stringList.stream().sorted().forEach(s -> System.out.print( s + "\t"));
        System.out.println();
        stringList.stream().map(s -> s.length()).forEach(n -> System.out.print( n + "\t"));
    }








} // class end