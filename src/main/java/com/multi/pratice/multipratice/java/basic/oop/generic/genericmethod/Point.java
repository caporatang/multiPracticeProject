package com.multi.pratice.multipratice.java.basic.oop.generic.genericmethod;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.generic.genericmethod
 * fileName : Point
 * author : taeil
 * date : 2023/02/15
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/15        taeil                   최초생성
 */
public class Point<T, V> {
    // 제네릭메서드를 활용해서 좌표를 받아 사각형의 면적을 구해보자!
    T x;
    V y;

    Point(T x, V y) {
        this.x = x;
        this.y = y;
    }
    public T getX() {
        return x;
    }
    public V getY() {
        return y;
    }
}