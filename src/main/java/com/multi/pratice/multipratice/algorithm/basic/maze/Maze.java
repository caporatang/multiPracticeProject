package com.multi.pratice.multipratice.algorithm.basic.maze;

/**
 * packageName : com.multi.pratice.multipratice.algorithm.basic
 * fileName : FindMaze
 * author : taeil
 * date : 2023/05/09
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/05/09        taeil                   최초생성
 */
public class Maze {
    // 미로 찾기 문제!
    // 입구에서 출구로 통하는 길을 찾는 미로 찾기 문제
    // 스택을 활용하여 문제를 해결할 수 있음
    // 출구 탐색을 위해 BFS나 DFS로 해결할 수 있다.

    public int[][] myMaze ={
            {0, 0, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 0}

    };
}