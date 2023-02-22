package com.multi.pratice.multipratice.java.basic.oop.generic.genericmethod;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop.generic.genericmethod
 * fileName : GenericMethodTest
 * author : taeil
 * date : 2023/02/15
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/15        taeil                   최초생성
 */
public class GenericMethodTest {
    // 제네릭메서드를 활용해서 좌표를 받아 사각형의 면적을 구해보자!

    public static < T, V > double makeRectangle(Point<T,V> p1, Point<T,V> p2) {

        double left = ((Number) p1.getX()).doubleValue();
        double right = ((Number) p2.getX()).doubleValue();

        double top = ((Number) p1.getY()).doubleValue();
        double bottom = ((Number) p2.getY()).doubleValue();

        double width = right - left;
        double height = bottom - top;

        return width * height;
    }

    public static void main(String[] args) {
        Point<Integer, Double> p1 = new Point<Integer, Double>(0, 0.0);
        Point<Integer, Double> p2 = new Point<>(10, 10.0);

        double size = GenericMethodTest.<Integer, Double>makeRectangle(p1, p2);
        System.out.println(size);
    }

}