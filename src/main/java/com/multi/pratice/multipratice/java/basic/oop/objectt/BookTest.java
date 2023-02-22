package com.multi.pratice.multipratice.java.basic.oop.objectt;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.objectt
 * fileName : BookTest
 * author : taeil
 * date : 2023/02/09
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/09        taeil                   최초생성
 */
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // toString을 오버라이드해서 사용하는 경우, 주소값이 아닌 value값을 출력할수있음
    // 요지는, Object에 정의되어있는 메서드를 따로 override할수있다는것이다.
    @Override
    public String toString() {
        return title + ", " + author;
    }
}


public class BookTest {
    public static void main(String[] args) {
        // 가상 주소값 출력
        Book book = new Book("데미안", "헤르만 헤세");
        System.out.println(book);

        //value값 출력
        String str = new String("String");
        System.out.println(str);

    }

}