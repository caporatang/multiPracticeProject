package com.multi.pratice.multipratice.java.basic.oop.iostream;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.iostream
 * fileName : IoStream
 * author : taeil
 * date : 2023/03/27
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/27        taeil                   최초생성
 */
public class IoStream {
    // 입출력 스트림
    // 자바는 다양한 입출력 장치에 독립적으로 일관성있는 입출력 스트림을 통해 제공

    // 입출력 스트림의 구분
    // 대상 기준 : 입력 스트림 / 출력 스트림
    // 자료의 종류 : 바이트 스트림 / 문자 스트림
    // 기능 : 기반 스트림 / 보조 스트림

    // 입력 스트림과 출력 스트림 --> 입력과 출력은 다른 스트림을 탄다
    // 입력 스트림 : 대상으로부터 자료를 읽어 들이는 스트림
    // 출력 스트림 : 대상으로 자료를 출력하는 스트림
    // 스트림의 종류
    // 입력 스트림 : FileInputStream, FileReader, BufferedInputStream, BufferedReader ..등
    // 출력 스트림 : FileOutputStream, FileWriter, BufferedOutputStream, BufferedWriter ..등

    // 바이트 단위 스트림과 문자 단위 스트림
    // 바이트 단위 스트림 : 동영상, 음악 파일, 실행 파일등의 자료를 읽고 쓸 때 사용
    // 문자 단위 스트림 : 바이트 단위로 자료를 처리하면 문자는 깨짐, 인코딩에 맞게 2바이트 이상으로 처리하도록 구현된 스트림
    // 스트림의 종류 --> input, output이 붙으면 바이트 <--> Reader Writer가 붙으면 문자
    // 바이트 스트림 : FileInputStream, FileOutputStream, BufferedInputStream, BufferedOutputStream
    // 문자 스트림 : FileReader, FileWriter, BufferedReader, BufferedWriter

    // 기반 스트림과 보조 스트림
    // 기반 스트림 : 대상에 직접 자료를 읽고 쓰는 기능의 스트림
    // 보조 스트림 : 직접 읽고 쓰는 기능은 ㅇ벗이 추가적인 기능을 더해주는 스트림
    // 보조 스트림은 직접 읽고 쓰는 기능은 없으므로 항상 기반 스트림이나 또 다른 보조 스트림을 생성자의 매개 변수로 포함한다.








}