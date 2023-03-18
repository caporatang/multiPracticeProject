package com.multi.pratice.multipratice.algorithm.basic.easyexample.bfsdfs.graph;

/**
 * packageName : com.multi.pratice.multipratice.algorithm.basic.easyexample.bfsdfs.graph
 * fileName : UndirectedGraph
 * author : taeil
 * date : 2023/03/18
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/18        taeil                   최초생성
 */
public class UndirectedGraph {
    private int count;   //노드 수
    private int[][] vertexMatrix;  // matrix로 그래프 표시


    public UndirectedGraph(int count){
        this.count = count;
        vertexMatrix = new int[count][count];
    }

    public void addEdges(int from, int to, int weight){
        vertexMatrix[from][to] = weight;
        vertexMatrix[to][from] = weight;
    }

    public int[][] getMatrix(){
        return vertexMatrix;
    }
}