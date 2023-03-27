package com.multi.pratice.multipratice.java.basic.oop.iostream.inputstream;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.iostream.bytestream
 * fileName : InputStream
 * author : taeil
 * date : 2023/03/27
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/27        taeil                   최초생성
 */
public class InputStream {
    // 바이트 단위 입력 스트림 최상위 추상 클래스
    // 많은 추상 메서드가 선언되어 있고 이를 하위 스트림이 상속받아 구현한다.

    // IO를 할때는, 제공되는 메서드와 클래스의 매개 변수 및 반환값을 잘 확인하자

    // 주요 하위 클래스
    // FileInputStream : 파일에서 바이트 단위로 자료를 읽습니다.
    // ByteArrayInputStream : byte 배열 메모리에서 바이트 단위로 자료를 읽습니다.
    // FilterInputStream : 기반 스트림에서 자료를 읽을 때 추가 기능을 제공하는 보조 스트림의 상위 클래스

    // 주요 메서드
    // int read : 입력 스트림으로부터 한 바이트의 자료를 읽습니다. 읽은 자료의 바이트 수를 반환합니다.
    // int read(byte b[]) 입력 스트림으로 부터 b[] 크기의 자료를 b[]에 읽는다. 읽은 자료의 바이트 수를 반환
    // int read(byte b[], int off, int len)
    // -> 입력 스트림으로 부터 b[] 크기의 자료를 b[] off변수 위치부터 저장하면 len 만큼 읽는다. 읽은 자료의 바이트 수를 반환
    // void close() : 입력 스트림과 연결된 대상 리소스를 닫음


}