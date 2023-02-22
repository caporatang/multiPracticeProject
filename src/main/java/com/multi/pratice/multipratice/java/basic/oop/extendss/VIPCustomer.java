package com.multi.pratice.multipratice.java.basic.oop.extendss;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.extendss
 * fileName : VIPCustomer
 * author : taeil
 * date : 2023/01/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/01/18        taeil                   최초생성
 */
public class VIPCustomer  extends Customer{

    private String agentId;
    double salesRatio;

    public VIPCustomer() {
        salesRatio = 0.1;
        bonusRatio = 0.05;
        customerGrade = "VIP";
    }

    public String getAgentId() {
        return agentId;
    }


}