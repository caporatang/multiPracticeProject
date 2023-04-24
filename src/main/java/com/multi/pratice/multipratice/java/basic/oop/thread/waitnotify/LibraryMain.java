package com.multi.pratice.multipratice.java.basic.oop.thread.waitnotify;

import java.util.ArrayList;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.thread.waitnotify
 * fileName : LibraryMain
 * author : taeil
 * date : 2023/04/24
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/24        taeil                   최초생성
 */

class Library {
    public ArrayList<String> shelf = new ArrayList<>();

    public Library() {
        shelf.add("책1");
        shelf.add("책2");
        shelf.add("책3");
    }

    public synchronized String lendBook() throws InterruptedException {

        Thread t = Thread.currentThread();

        if( shelf.size() == 0) { // 리소스가 없을때. 리소스는 shelf.

            System.out.println( t.getName() + "wating start");
            // 이 메서드가 수행되는 스레드를 notRunnable 상태로 만듬 -> wait은 Object의 메서드.
            // 코드는 책이 현재 3권이 있다. 스레드 6개가 동시에 책을 빌린다.
            // 책은 세권이기 때문에 3개의 스레드는 책을 빌리지만, 나머지 세개는 빌리지 못한다.
            // 책 3권이 다 나가게 되면, 대기 상태로 만든다. -> wait()
            wait();
            System.out.println( t.getName() + "wating end");

        }

        if(shelf.size() > 0) {
            String book = shelf.remove(0);
            System.out.println(t.getName() + " : " + book + " lend ");
            return book;
        }
        else return null;

    }

    public synchronized void returnBook(String book) {
        Thread t = Thread.currentThread();

        shelf.add(book);
        // 위에서 wait() 상태인 스레드들을 책이 추가되어 4권 이상이 되었을 때, notify를 사용해 runnable 상태로 만듬
        notify(); // object의 메서드
        System.out.println(t.getName() + " : " + book + "return");
    }
}

class Student extends Thread {
    public Student(String name) {
        super(name);
    }

    public void run() {
        try {
            String title = LibraryMain.library.lendBook();

            if(title == null) {
                System.out.println(getName() + " 빌리지 못했음" );
                return;
            }
            sleep(5000);
            LibraryMain.library.returnBook(title); // 리소스를 반환
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}


public class LibraryMain {

    public static Library library = new Library();

    public static void main(String[] args) {
        Student std1 = new Student("std1 ");
        Student std2 = new Student("std2 ");
        Student std3 = new Student("std3 ");
        Student std4 = new Student("std4 ");
        Student std5 = new Student("std5 ");
        Student std6 = new Student("std6 ");

        std1.start();
        std2.start();
        std3.start();
        std4.start();
        std5.start();
        std6.start();

    }
}