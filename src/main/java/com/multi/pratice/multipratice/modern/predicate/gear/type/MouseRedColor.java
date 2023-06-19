package com.multi.pratice.multipratice.modern.predicate.gear.type;

import com.multi.pratice.multipratice.modern.predicate.gear.KeyBoard;
import com.multi.pratice.multipratice.modern.predicate.gear.Mouse;
import com.multi.pratice.multipratice.modern.predicate.keyConst.KeyboardConst;
import com.multi.pratice.multipratice.modern.predicate.keyConst.MouseConst;
import com.multi.pratice.multipratice.modern.predicate.predicate.KeyboardPredicate;
import com.multi.pratice.multipratice.modern.predicate.predicate.MousePredicate;

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
public class MouseRedColor implements MousePredicate {

    @Override
    public boolean mouse(Mouse mouse) {
        return MouseConst.COLOR_RED.equals(mouse.getColor());
    }
}