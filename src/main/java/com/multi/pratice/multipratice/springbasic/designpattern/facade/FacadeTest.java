package com.multi.pratice.multipratice.springbasic.designpattern.facade;



/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.facade
 * fileName : FacadePattern
 * author : taeil
 * date : 2023/02/20
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/20        taeil                   최초생성
 */
public class FacadeTest {


    public static void main(String[] args) {
        // ex) FTP클라이언트 연결 -> 연결을 해당 디렉토리로 이동 -> 해당 파일에 연결 -> 파일 작성 -> 파일 연결 -> reader를 가지고 파일을 read
        // disconnect는 반대로

        /*
        --> facade 패턴 적용 이전 코드
        Ftp ftpClient = new Ftp("www.taeil.co", 22, "/path/test");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisConnect();
        ftpClient.disConnect();
        */

        // 위 코드들과 동일한 결과.
        // 가져다가 사용하는 경우 코드를 줄이고 간결하게 사용할수있음 --> 결과적으로 sftpClient가 모든 기능을 제공하게 만들수있다.!
        SftpClient sftpClient = new SftpClient("www.taeil.co", 22, "/home/etc", "text.tmp");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();
    }












}