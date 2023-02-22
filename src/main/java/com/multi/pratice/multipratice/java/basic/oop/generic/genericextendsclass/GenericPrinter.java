package com.multi.pratice.multipratice.java.basic.oop.generic.genericextendsclass;

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
public class GenericPrinter<T extends Material> {
    // --> T에 무작위 클래스가 들어갈 수 없게 Material 클래스를 상속받은 클래스로 한정시킴
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