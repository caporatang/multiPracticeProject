package com.multi.pratice.multipratice.java.basic.oop;

/**
 * packageName : com.multi.pratice.multipratice.java.basic.oop
 * fileName : CollectionFrameWorks
 * author : taeil
 * date : 2023/04/16
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/16        taeil                   최초생성
 */
public class CollectionFrameWorks {
    // List 순서가 보장되고 중복 데이터도 허용합니다
    //ArrayList는 기본적으로 배열과 같이 데이터를 관리하고 데이터마다 인덱스가 있기 때문에 검색 속도가 빠르나, 리스트 중간중간 데이터의 삽입이나
    //   삭제가 일어나는 경우 성능이 저하 될수있습니다.
    //
    //LinkedList - 양방향 포인터 구조로 다음 순서 데이터의 주소값을 기억하고있습니다. 데이터가 추가 삭제되는 경우 포인터의 위치만 바꾸면 되기 때문에
    //   수정 삭제에 성능이 좋으나, 검색시, 첫번째 노드부터 탐색하기 떄문에 검색 속도는 느릴수있습니다.
    //
    //Map 키와 밸류의 데이터 집합입니다. 키는 중복될수없고 밸류는 중복 될수있습니다.
    //HashMap - 중복이 허용되지 않고, 순서가 보장되지 않으며, null값이 올수있다.
    //TreeMap - 트리 구조이기 떄문에 어느정도 순서가 보장됩니다. 키가 정렬되어 있기 떄문에 검색시 용이함
    //HashTable - Hash맵보다 느리지만 쓰레드 세이프하다는 특징이 있습니다.

    //Set 중복 데이터를 허용하지 않고, 순서도 보장되지 않습니다.
    //HashSet -> Hash를 통해서 중복을 체크하고 hash값이 같은 경우에 equals 메서드를 통해 중복을 체크합니다.
    //Treeset -> CompareTo() 를 통해서 중복을 체크해서 트리 구조에 저장한다.
    //LinkedHashSet -> HashSet과 같은 구조이나 내부적으로 LinkedList가 구현되어 있어 입력 순서가 저장된다.


}