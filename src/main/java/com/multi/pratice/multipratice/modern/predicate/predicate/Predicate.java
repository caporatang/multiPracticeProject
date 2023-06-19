package com.multi.pratice.multipratice.modern.predicate.predicate;

import com.multi.pratice.multipratice.modern.predicate.gear.Mouse;

/**
 * packageName : com.multi.pratice.multipratice.modern.predicate.predicate
 * fileName : Predicate
 * author : taeil
 * date : 2023/06/20
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/06/20        taeil                   최초생성
 */
public interface Predicate<T> {
    boolean another(T t);

    boolean blackCableMouse(Mouse mouse);

}