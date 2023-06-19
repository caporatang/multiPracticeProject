package com.multi.pratice.multipratice.modern.predicate.gear.type;

import com.multi.pratice.multipratice.modern.predicate.keyConst.KeyboardConst;
import com.multi.pratice.multipratice.modern.predicate.gear.KeyBoard;
import com.multi.pratice.multipratice.modern.predicate.predicate.KeyboardPredicate;

/**
 * packageName : com.multi.pratice.multipratice.modern.predicate
 * fileName : KeyboardWhiteAndTopre
 * author : taeil
 * date : 2023/06/20
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/06/20        taeil                   최초생성
 */
public class KeyboardWhiteAndTopre implements KeyboardPredicate {
    @Override
    public boolean keyboard(KeyBoard keyBoard) {
        return KeyboardConst.COLOR_WHITE.equals(keyBoard.getColor())
                && KeyboardConst.TYPE_TOPRE.equals(keyBoard.getType());
    }
}