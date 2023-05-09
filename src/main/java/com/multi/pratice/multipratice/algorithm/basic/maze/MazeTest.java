package com.multi.pratice.multipratice.algorithm.basic.maze;

/**
 * packageName : com.multi.pratice.multipratice.algorithm.basic.maze
 * fileName : MazeTest
 * author : taeil
 * date : 2023/05/09
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/05/09        taeil                   최초생성
 */
public class MazeTest {

    public static void main(String[] args) {

        Robot robot;
        System.out.println("출구는 입니다. (7,7)");

        robot = new Robot();

        robot.findPath( 0,0, 7,7);
        robot.showPath();

    }
}
