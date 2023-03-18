package com.multi.pratice.multipratice.algorithm.basic.easyexample.bfsdfs;

import com.multi.pratice.multipratice.algorithm.basic.easyexample.bfsdfs.graph.UndirectedGraph;

import java.util.ArrayList;

/**
 * packageName : com.multi.pratice.multipratice.algorithm.basic.easyexample
 * fileName : BfsSearch
 * author : taeil
 * date : 2023/03/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/18        taeil                   최초생성
 */
public class BfsSearch {
    // 너비 우선 탐색(BFS)
    // 한 노드에 모든 인접한 노드를 탐색하는 방식
    // 큐를 활용하여 구현할 수 있음
    // BFS 탐색 순서 : 0 - 1 - 2 - 3 - 4 - 5 - 6 - 7

    int count;
    boolean[] visited;
    ArrayList<Integer> queue;
    int[][] matrix;

    public BfsSearch(int count){
        this.count = count;
        visited = new boolean[count];
        queue = new ArrayList<Integer>();
    }

    public void bfsTraversal() {

        queue.add(0);
        visited[0] = true;

        while(queue.size() != 0) {
            int node = queue.remove(0);

            System.out.print(node + "  ");

            for(int j = 0; j<count; j++) {
                if(matrix[node][j] != 0 && !visited[j] ) {
                    queue.add(j);
                    visited[j] = true;
                }
            }

        }
    }

    public static void main(String[] args) {

        int count = 8;
        UndirectedGraph graph = new UndirectedGraph(count);
        BfsSearch bfsSearch = new BfsSearch(count);

        graph.addEdges(0, 1, 1);
        graph.addEdges(0, 2, 1);
        graph.addEdges(1, 3, 1);
        graph.addEdges(1, 4, 1);
        graph.addEdges(2, 5, 1);
        graph.addEdges(2, 6, 1);
        graph.addEdges(4, 5, 1);
        graph.addEdges(3, 7, 1);

        bfsSearch.matrix = graph.getMatrix();
        bfsSearch.bfsTraversal();

    }
}