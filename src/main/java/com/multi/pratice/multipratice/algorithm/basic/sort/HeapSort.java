package com.multi.pratice.multipratice.algorithm.basic.sort;

/**
 * packageName : com.multi.pratice.multipratice.algorithm.basic.sort
 * fileName : HeapSort
 * author : taeil
 * date : 2023/03/15
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/15        taeil                   최초생성
 */
public class HeapSort {
    // 평균 수행 시간이 O(logN)인 알고리즘
    // 퀵 정렬(Quick Sort), 병합 정렬(Merge Sort), 힙 정렬(Heap Sort)
    // 한번 수행될 때마다 정렬되어야 하는 수의 범위가 1/2로 줄어드는 경우
    // 퀵 정렬 이외의 다른 알고리즘은 추가적인 메모리가 필요함

    // Heap은 tree임, 대부분 배열로 표현을 많이함
    // 기준이 가장 작인 경우 = minHeap, 가장 큰 경우 = maxHeap

    // heapSort는 0번 인덱스를 사용하면 안된다. -> 새로운 값을 넣는다고 가정했을때, parent의 위치는 본인 위치에 1/2이기 떄문에 0은 될수가없다.

    private int SIZE;
    private int heapArr[];

    public HeapSort()
    {
        SIZE = 0;
        heapArr = new int [50];
    }

    public void insertHeap(int input)
    {
        int i = ++SIZE;
        //while(( i != 1) && ( input > heapArr[i/2])){ //max heap
        while(( i != 1) && ( input < heapArr[i/2])){ //min heap
            heapArr[i] = heapArr[i/2];
            i = i/2;
        }
        heapArr[i] = input;
    }

    public int getHeapSize()
    {
        return SIZE;
    }

    public int deleteHeap()
    {
        int parent, child;
        int data, temp;
        data = heapArr[1];

        temp = heapArr[SIZE];
        SIZE -= 1;
        parent =1; child = 2;

        while(child <= SIZE){
            //if((child < HEAP_SIZE) && (heapArr[child] < heapArr[child+1])){ //max heap
            if((child < SIZE) && (heapArr[child] > heapArr[child+1])){ //min heap
                child++;
            }
            //if(temp >= heapArr[child]) break; //max heap
            if(temp <= heapArr[child]) break;   //min heap
            heapArr[parent] = heapArr[child];
            parent = child;
            child *= 2;
        }

        heapArr[parent] = temp;
        return data;
    }

    public void printHeap(){
        //System.out.printf("\n Max Heap : ");
        System.out.printf("\n Min Heap : ");
        for(int i=1; i<=SIZE; i++)
            System.out.printf("[%d] ", heapArr[i]);
    }
    public static void main(String[] args) {
        HeapSort h = new HeapSort();
        h.insertHeap(80);
        h.insertHeap(50);
        h.insertHeap(70);
        h.insertHeap(10);
        h.insertHeap(60);
        h.insertHeap(20);

        h.printHeap();

        int n, data;
        n = h.getHeapSize();
        for(int i=1; i<=n; i++){
            data = h.deleteHeap();
            System.out.printf("\n 출력 : [%d]", data);
        }
    }


}