package com.multi.pratice.multipratice.algorithm.basic.easyexample.bfsdfs;

import com.multi.pratice.multipratice.algorithm.basic.easyexample.bfsdfs.graph.UndirectedGraph;

import java.util.Stack;

/**
 * packageName : com.multi.pratice.multipratice.algorithm.basic.easyexample
 * fileName : DfsSearch
 * author : taeil
 * date : 2023/03/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/18        taeil                   최초생성
 */
public class DfsSearch {
    // 깊이 우선 탐색(DFS)
    // 인접한 노드를 우선 탐색 하는 방식
    // 스택을 활용하여 구현할 수 있음
    // DFS 탐색 순서 :
    // 0 - 1 - 3 - 7 - 4 - 5 - 2 - 6
    // 0 - 2 - 6 - 5 - 4 - 1 - 3 - 7
    int count;
    boolean[] visited;
    Stack<Integer> stack;
    int[][] matrix;

    public DfsSearch(int count){
        this.count = count;
        visited = new boolean[count];
        stack = new Stack<Integer>();
    }

    public void bfsTraversal() {

        stack.push(0);
        visited[0] = true;

        while(stack.size() != 0) {
            int node = stack.pop();

            System.out.print(node + "  ");

            for(int j = 0; j<count; j++) {
                if(matrix[node][j] != 0 && !visited[j] ) {
                    stack.push(j);
                    visited[j] = true;
                }
            }

        }
    }

    public static void main(String[] args) {

        int count = 8;
        UndirectedGraph graph = new UndirectedGraph(count);
        DfsSearch dfsSearch = new DfsSearch(count);

        graph.addEdges(0, 1, 1);
        graph.addEdges(0, 2, 1);
        graph.addEdges(1, 3, 1);
        graph.addEdges(1, 4, 1);
        graph.addEdges(2, 5, 1);
        graph.addEdges(2, 6, 1);
        graph.addEdges(4, 5, 1);
        graph.addEdges(3, 7, 1);

        dfsSearch.matrix = graph.getMatrix();
        dfsSearch.bfsTraversal();

    }

}