package com.example.redissecurityjwt.redis;

/**
 * packageName : com.example.redissecurityjwt.redis
 * fileName : Redis
 * author : taeil
 * date : 2023/03/30
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/30        taeil                   최초생성
 */
public class Redis {
    // Key, value 구조의 비정형 데이터를 저장하고 관리하기 위한 오픈 소스 기반의 비관계형 데이터 베이스 관리 시스템.
    // DB, cache, message broker로 사용되고 인메모리 구조로 이루어져있음
    // 싱글 스레드 구조로 되어있음

    // 캐시 서버는 Look aside cache 패턴과 Write Back 패턴이 존재
    // Look aside cache
    // 1. 클라이언트가 데이터를 요청
    // 2. 웹서버는 데이터가 존재하는지 Cache 서버에 먼저 확인
    // 3. Cache 서버에 데이터가 있으면 DB에 데이터를 조회하지 않고 Cache 서버에 있는 결과값을 클라이언트에게 바로 반환 (Cache Hit)
    // 4. Cache 서버에 데이터가 없으면 DB에 데이터를 조회하여 Cache 서버에 저장하고 결과값을 클라이언트에게 반환 (Cache Miss)

    // Write Back
    // 1. 웹서버는 모든 데이터를 Cache 서버에 저장
    // 2. Cache 서버에 특정 시간 동안 데이터가 저장됨
    // 3. Cache 서버에 있는 데이터를 DB에 저장
    // 4. DB에 저장된 Cache 서버의 데이터를 삭제

    // ---------------- 지원되는 자료구조 -----------------
    // List
    // Last, First에 삽입과 삭제가 가능한 자료구조로 Quick List를 사용
    // 기본 명령어 ⇒ lpush, rpush, lpop, rpop, lrange
    // lpush [Key] [Value] → key의 List 처음에 [Value] 삽입
    // 시간 복잡도 ⇒ O(1)
    // rpush [Key] [Value] → key의 List 마지막에 [Value] 삽입
    // 시간 복잡도 ⇒ O(1)
    // lpop [Key] → key의 List 처음 데이터 삭제
    // 시간 복잡도 ⇒ O(1)
    // rpop [Key] → key의 List 마지막 데이터 삭제
    // 시간 복잡도 ⇒ O(1)
    // lrange key start end → List의 start ~ end까지의 데이터 반환 음수인 경우에는 마지막 값을 의미
    // -1 → 마지막 값, -2 → 마지막 값의 전 값, -3 →...
    // lpushx, rpushx [Key] [Value] → List가 이미 있는 경우에만 데이터 삽입
    // 시간 복잡도 ⇒ O(1)
    // lset [Key] index [Value] → 리스트 index 원소의 값을 [Value] 값으로 변경
    // 시간 복잡도 ⇒ O(N)
    // ltrim [Key] start end → 리스트의 start부터 end만큼 보존하고 나머진 삭제
    // 시간 복잡도 ⇒ O(N)

    // String
    // 1 : 1 방식의 Key - Value 형식
    // 기본 명령어 ⇒ get, set, del
    // set [Key] [Value] → key에 value 저장
    // get [Key] → key 값의 데이터 조회
    // del [Key] → Key 삭제

    // Set
    // 명령어 [Key] [Value] 는 Key 값이 [Key], Value 값이 [Value]임을 나타냅니다.
    // 기본 명령어
    // 1. sadd [Key] [Value] ⇒ set에 value 추가
    // 시간복잡도 ⇒ O(1)
    // 2. srem [key] [Value] ⇒ set의 value가 키인 값 삭제
    // 시간복잡도 ⇒ O(1)
    // 3. smembers [Key] ⇒ set의 모든 원소 조회
    // 시간복잡도 ⇒ O(1)
    // 4. scard [Key] ⇒ set의 원소 갯수 조회
    // 시간복잡도 ⇒ O(1)
    // 5. spop [Key] ⇒ set의 원소 중 아무거나 삭제 후 조회
    // 시간복잡도 ⇒ O(1)

}