package com.multi.pratice.multipratice.java.basic.oop.statickeyword;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.statickeyword
 * fileName : Employee
 * author : taeil
 * date : 2023/01/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/18        taeil                   최초생성
 */
public class Employee {

    private static int serialNum = 1000;
    private int employeeId;
    private String employeeName;
    private String department;

    public Employee() {
        serialNum++;
        employeeId = serialNum;
    }

    // static method
    public static int getSerialNum() {
        int i =0;

        // 스태틱 메서드 안에서는 인스터턴스 변수(일반 맴버변수는 사용할수없음) --> 인스턴스를 생성하지 않고 바로 접근 가능하기 때문에 맴버변수는 인스턴스를 생성할때 할당이 되기 떄문
        // 스태틱변수를 사용할수있는 이유는 이미 프로그램이 실행될때 메모리에 올라가있기 떄문이다
        // employeeName = "LEE";

        return serialNum;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}