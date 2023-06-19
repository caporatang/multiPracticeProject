package com.multi.pratice.multipratice.modern.predicate.gear.type;

import com.multi.pratice.multipratice.modern.predicate.gear.Mouse;
import com.multi.pratice.multipratice.modern.predicate.keyConst.MouseConst;
import com.multi.pratice.multipratice.modern.predicate.predicate.MousePredicate;

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
public class MouseWhiteAndWireless implements MousePredicate {
    @Override
    public boolean mouse(Mouse mouse) {
        return MouseConst.COLOR_WHITE.equals(mouse.getColor())
                && MouseConst.TYPE_WIRELESS.equals(mouse.getType());
    }
}