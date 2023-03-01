package com.multi.pratice.multipratice.springbasic.async.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.async.service
 * fileName : AsyncService
 * author : taeil
 * date : 2023/03/01
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/01        taeil                   최초생성
 */
@Service
@Slf4j
public class AsyncService {

    // Async로 결과를 리턴해보자 (CompletableFuture 사용)
    @Async("async-thread") //-> Config에서 정의한 bean의 이름
    public CompletableFuture run() {

        // 예제처럼 다른 스레드에서 돌린 후, 결과를 반환하기보다
        // CompletableFuture API를 다수 한꺼번에 실행해서 그것에 대한 결과를 join시켜 받을때 사용한다.

        // 현재 예제는 다른 스레드에서 돌린다고해도 어쨌든 결과는 async hello라는 스트링이 반환되기 때문에 적절하지 않은것임
        return new AsyncResult(hello()).completable();
    }

    // @Async
    public String hello() {
        for (int i = 0; i < 10; i++){
            try {
              Thread.sleep(2000);
              // method end가 호출되고 난 후 다른 task에서 출력된다.
              log.info("thread sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "async hello";
    }

}