package com.multi.pratice.multipratice.java.basic.oop.generic.noneGenericType;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.generic.noneGenericType
 * fileName : ThreeDPrinter2
 * author : taeil
 * date : 2023/02/15
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/15        taeil                   최초생성
 */
public class ThreeDPrinter2 {
    // 제네릭을 사용하지 않는 프로그래밍

    // 재료가 플라스틱인 프린터를 만들었다고 가정해보자~
    private Plastic material;

    public Plastic getMaterial() {
        return material;
    }

    public void setMaterial(Plastic material) {
        this.material = material;
    }
}