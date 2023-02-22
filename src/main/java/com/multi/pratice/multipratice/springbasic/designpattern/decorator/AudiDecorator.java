package com.multi.pratice.multipratice.springbasic.designpattern.decorator;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.designpattern.decorator
 * fileName : AudiDecorator
 * author : taeil
 * date : 2023/02/19
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/19        taeil                   최초생성
 */
public class AudiDecorator implements ICar {

    protected ICar audi;
    protected String modelName;
    protected int modelPrice;

    public AudiDecorator(ICar audi, String modelName, int modelPrice) {
        this.audi = audi;
        this.modelName = modelName;
        this.modelPrice = modelPrice;
    }

    @Override
    public int getPrice() {
        return audi.getPrice() + modelPrice;
    }

    @Override
    public void showPrice() {
        System.out.println(modelName + "의 가격은 " + getPrice() + "원 입니다");
    }
}