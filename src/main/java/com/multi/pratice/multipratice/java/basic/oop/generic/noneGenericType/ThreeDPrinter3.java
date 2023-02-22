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
public class ThreeDPrinter3 {
    // 제네릭을 사용하지 않는 프로그래밍

    // 모든 재료를 담을수 있게 오브젝트 타입을 재료료 프린터를 만들었다고 가정.
    private Object material;

    public Object getMaterial() {
        return material;
    }

    public void setMaterial(Object material) {
        this.material = material;
    }
}