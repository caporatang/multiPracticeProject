package com.multi.pratice.multipratice.springbasic.designpattern.facade;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.facade
 * fileName : SftpClient
 * author : taeil
 * date : 2023/02/20
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/20        taeil                   최초생성
 */
public class SftpClient {
    // 이 클래스가 Facade패턴의 주된 객체임
    // 얘가 제공해주는 인터페이스를 가져다가 구현해야함

    private Ftp ftp;
    private Reader reader;
    private Writer writer;

    public SftpClient(Ftp ftp, Reader reader, Writer writer) {
        this.ftp = ftp;
        this.reader = reader;
        this.writer = writer;
    }

    // 오버로딩을 활용하자
    public SftpClient(String host, int port, String path, String fileName) {
        this.ftp = new Ftp(host, port, path);
        this.reader = new Reader(fileName);
        this.writer = new Writer(fileName);
    }

    public void connect() {
        ftp.connect();
        ftp.moveDirectory();
        writer.fileConnect();
        reader.fileConnect();
    }

    public void disConnect() {
        writer.fileDisConnect();
        reader.fileDisconnect();
        ftp.disConnect();
    }

    public void read() {
        reader.fileRead();
    }

    public void write() {
        writer.write();
    }
}