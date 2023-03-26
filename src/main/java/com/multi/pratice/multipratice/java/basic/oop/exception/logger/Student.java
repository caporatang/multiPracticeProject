package com.multi.pratice.multipratice.java.basic.oop.exception.logger;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.exception.logger
 * fileName : Student
 * author : taeil
 * date : 2023/03/26
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/26        taeil                   최초생성
 */
public class Student {

    private String studentName;
    MyLogger myLogger = MyLogger.getLogger();

    public Student(String studentName){

        if(studentName == null){

            throw new StudentNameFormatException("name must not be null");
        }
        if( studentName.split(" ").length > 3)
            throw new StudentNameFormatException("이름이 너무 길어요");

        this.studentName = studentName;
    }


    public String getStudentName() {

        myLogger.fine("begin getStudentName()");

        return studentName;
    }
}