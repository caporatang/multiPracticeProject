package com.multi.pratice.multipratice.modern.predicate.gear.type;

import com.multi.pratice.multipratice.modern.predicate.keyConst.KeyboardConst;
import com.multi.pratice.multipratice.modern.predicate.gear.KeyBoard;
import com.multi.pratice.multipratice.modern.predicate.predicate.KeyboardPredicate;

/**
 * packageName : com.multi.pratice.multipratice.modern.predicate.predicate
 * fileName : KeyboardRedColor
 * author : taeil
 * date : 2023/06/19
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/06/19        taeil                   최초생성
 */
public class KeyboardRedColor implements KeyboardPredicate {

    @Override
    public boolean keyboard(KeyBoard keyBoard) {
        return KeyboardConst.COLOR_RED.equals(keyBoard.getColor());
    }
}