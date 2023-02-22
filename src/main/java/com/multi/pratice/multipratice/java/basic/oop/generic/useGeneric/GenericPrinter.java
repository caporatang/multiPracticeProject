package com.multi.pratice.multipratice.java.basic.oop.generic.useGeneric;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.generic.noneGenericType
 * fileName : GenericPrinter
 * author : taeil
 * date : 2023/02/15
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/15        taeil                   최초생성
 */
public class GenericPrinter<T> {
    // 제네릭 타입을 사용하는 경우

    private T material;

    public T getMaterial() {
        return material;
    }

    public void setMaterial(T material) {
        this.material = material;
    }
    public String toString() {
        return material.toString();
    }

}