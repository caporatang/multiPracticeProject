package com.multi.pratice.multipratice.java.basic.oop.objectt;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.objectt
 * fileName : StudentOverride
 * author : taeil
 * date : 2023/02/10
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/10        taeil                   최초생성
 */
public class Student implements Cloneable{
    private int studentNum;
    private String studentName;

    public Student(int studentNum, String studentName) {
        this.studentName = studentName;
        this.studentNum = studentNum;
    }

    public void setStudentName(String name) {
        this.studentName = name;
    }

    public String toString() {
        return studentNum + ", " + studentName;
    }

    @Override
    public int hashCode() {
        return studentNum;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student) {
            // 다운캐스팅
            Student std = (Student) obj;
            if(this.studentNum == std.studentNum) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}