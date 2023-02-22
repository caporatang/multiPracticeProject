package com.multi.pratice.multipratice.springbasic.designpattern.decorator;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.decorator
 * fileName : A3
 * author : taeil
 * date : 2023/02/19
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/19        taeil                   최초생성
 */
public class A5 extends AudiDecorator {

    public A5(ICar audi, String modelName) {
        super(audi, modelName, 3000);
    }
}