package com.multi.pratice.multipratice.modern.predicate;

import com.multi.pratice.multipratice.modern.predicate.gear.Mouse;
import com.multi.pratice.multipratice.modern.predicate.gear.type.KeyboardRedColor;
import com.multi.pratice.multipratice.modern.predicate.gear.type.KeyboardWhiteAndTopre;
import com.multi.pratice.multipratice.modern.predicate.gear.type.MouseWhiteAndWireless;
import com.multi.pratice.multipratice.modern.predicate.keyConst.KeyboardConst;
import com.multi.pratice.multipratice.modern.predicate.gear.KeyBoard;
import com.multi.pratice.multipratice.modern.predicate.keyConst.MouseConst;
import com.multi.pratice.multipratice.modern.predicate.predicate.KeyboardPredicate;
import com.multi.pratice.multipratice.modern.predicate.predicate.MousePredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * packageName : com.multi.pratice.multipratice.modern.predicate
 * fileName : KeyboardTest
 * author : taeil
 * date : 2023/06/20
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/06/20        taeil                   최초생성
 */
public class GearTest {
    public static void main(String[] args) {

        List<KeyBoard> keyBoardList = Arrays.asList(
                new KeyBoard(KeyboardConst.COLOR_WHITE, KeyboardConst.TYPE_TOPRE),
                new KeyBoard(KeyboardConst.COLOR_BLACK, KeyboardConst.TYPE_NOPPOO),
                new KeyBoard(KeyboardConst.COLOR_RED, KeyboardConst.TYPE_TOPRE)
        );

        List<KeyBoard> redKeyboard = filterKeyboard(keyBoardList, new KeyboardRedColor());
        System.out.println("redKeyboard = " + redKeyboard);

        List<KeyBoard> whiteTopre = filterKeyboard(keyBoardList, new KeyboardWhiteAndTopre());
        System.out.println("whiteTopre = " + whiteTopre);


        List<Mouse> mouseList = Arrays.asList(
                new Mouse(MouseConst.COLOR_WHITE, MouseConst.TYPE_WIRELESS),
                new Mouse(MouseConst.COLOR_BLACK, MouseConst.TYPE_CABLE),
                new Mouse(MouseConst.COLOR_RED, MouseConst.TYPE_WIRELESS)
        );

        List<Mouse> whiteWire = filterMouse(mouseList, new MouseWhiteAndWireless());
        System.out.println("whiteWire = " + whiteWire);

        List<Mouse> lambdaMouse = filterMouse(mouseList, (Mouse mouse)
                -> MouseConst.COLOR_WHITE.equals(mouse.getColor())
                && MouseConst.TYPE_WIRELESS.equals(mouse.getType())
        );
        System.out.println("lambdaMouse = " + lambdaMouse);

    }


    public static List<KeyBoard> filterKeyboard(List<KeyBoard> keyBoards, KeyboardPredicate k) {
        List<KeyBoard> result = new ArrayList<>();

        for (KeyBoard keyBoard : keyBoards) {
            if(k.keyboard(keyBoard)) {
                result.add(keyBoard);
            }
        }
        return result;
    }

    public static List<Mouse> filterMouse(List<Mouse> mouseList, MousePredicate m) {
        List<Mouse> result = new ArrayList<>();

        for (Mouse mouse : mouseList) {
            if(m.mouse(mouse)) {
                result.add(mouse);
            }
        }
        return result;
    }

    // 리스트를 추상화 !
    // public static <T> List<T> filter(List<T> list, Predicate<T> gear) {
        // 동작파라미터 -> Predicate 자체를 파라메터로 받아서 처리하자
    //    List<T> result = new ArrayList<>();

    //    for (T e : list) {
    //        if(gear.another(e)) {
    //            result.add(e);
    //        }
    //    }
    //    return result;
    //}
}