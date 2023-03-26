package com.multi.pratice.multipratice.java.basic.oop.exception.logger;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.exception.logger
 * fileName : Logging
 * author : taeil
 * date : 2023/03/26
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/26        taeil                   최초생성
 */
public class Logging {
    // 시스템 운영에 대한 기록
    // 오류가 발생 했을 때 그 오류에 대한 기록을 남겨 디버깅을 용이하게 함
    // 로그 파일에 기록하는 코드를 추가하여 필요한 정보가 로그로 남을 수 있도록 한다.
    // 디버깅, 시스템 에러 추적, 성능, 문제점 향상들을 위해 사용
    // 어느정도까지 로그를 남길 것인가?
    // -> 너무 적은 로그 : 정확한 시스템의 상황을 파악하기 어렵다.
    // -> 너무 많은 로그 : 빈번한 file I/O의 오버헤드와 로그 파일의 백업 문제 등 ...

    // java.util.logging
    // 자바에서 기본적으로 제공되는 log package
    // 파일이나 콘솔에 로그 내용을 출력할 수 있음
    // jre/lib/logging.properties 파일을 편집하여 로그의 출력방식 로그 레벨을 변경 할 수 있음
    // logging 패키지에서 제공하는 로그 레벨은 severe, warning, info, config, fine, finer, finest

}