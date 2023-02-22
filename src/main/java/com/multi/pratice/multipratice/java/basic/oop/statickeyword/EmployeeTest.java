package com.multi.pratice.multipratice.java.basic.oop.statickeyword;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.statickeyword
 * fileName : EmployeeTest
 * author : taeil
 * date : 2023/01/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/18        taeil                   최초생성
 */
public class EmployeeTest {

    public static void main(String[] args) {
        // employeeLee --> 지역변수 --> 스택 메모리에 생성
        Employee employeeLee = new Employee();
        // 이 스택메모리에 생성된 지역변수를 참조하는 인스턴스는 힙 메모리에 생성
        employeeLee.setEmployeeName("리태일");

        System.out.println(Employee.getSerialNum());

        Employee employeeKim = new Employee();
        employeeKim.setEmployeeName("김태일");

        System.out.println(employeeLee.getEmployeeName() + "님의 사번은" + employeeLee.getEmployeeId());
        System.out.println(employeeKim.getEmployeeName() + "님의 사번은" + employeeKim.getEmployeeId());
        System.out.println(Employee.getSerialNum());





    }

}