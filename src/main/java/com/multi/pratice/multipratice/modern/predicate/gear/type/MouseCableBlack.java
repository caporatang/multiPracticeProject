package com.multi.pratice.multipratice.modern.predicate.gear.type;

import com.multi.pratice.multipratice.modern.predicate.gear.Mouse;
import com.multi.pratice.multipratice.modern.predicate.keyConst.MouseConst;
import com.multi.pratice.multipratice.modern.predicate.predicate.Predicate;

/**
 * packageName : com.multi.pratice.multipratice.modern.predicate.gear.type
 * fileName : MouseCableBlack
 * author : taeil
 * date : 2023/06/20
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/06/20        taeil                   최초생성
 */
public class MouseCableBlack implements Predicate {

    @Override
    public boolean blackCableMouse(Mouse mouse) {
        return MouseConst.COLOR_BLACK.equals(mouse.getColor())
                && MouseConst.TYPE_CABLE.equals(mouse.getType());
    }

    @Override
    public boolean another(Object o) {
        return false;
    }
}