package com.multi.pratice.multipratice.java.basic.oop.encapsulation;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.incapsulation
 * fileName : MakeReport
 * author : taeil
 * date : 2023/01/17
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/17        taeil                   최초생성
 */
public class MakeReport {

    StringBuffer buffer = new StringBuffer();

    private String line = "===================================\n";
    private String title = "  이름\t    주소  \t\t  전화번호    \n";

    private void makeHeader()
    {
        buffer.append(line);
        buffer.append(title);
        buffer.append(line);
    }
    private void generateBody()
    {
        buffer.append("James \t");
        buffer.append("Seoul Korea \t");
        buffer.append("010-2222-3333\n");

        buffer.append("Toman \t");
        buffer.append("NewYork \t");
        buffer.append("010-7777-0987\n");
    }

    private void makeFooter()
    {
        buffer.append(line);
    }

    public String getReport() {
        // 클라이언트에게 제공되는건 이 메서드 하나임
        makeHeader();
        generateBody();
        makeFooter();
        return buffer.toString();
    }
}