package com.multi.pratice.multipratice.java.basic.oop.generic.noneGenericType;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.generic.noneGenericType
 * fileName : ThreeDPrinter1
 * author : taeil
 * date : 2023/02/15
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/15        taeil                   최초생성
 */
public class ThreeDPrinter1 {
    // 제네릭을 사용하지 않는 프로그래밍

    // 재료가 파우더인 프린터를 만들었다고 가정해보자~
    private Powder material;

    public Powder getMaterial() {
        return material;
    }

    public void setMaterial(Powder material) {
        this.material = material;
    }
}