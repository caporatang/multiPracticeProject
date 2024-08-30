package com.multi.pratice.multipratice.springbasic.synchronizedTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.synchronizedTest
 * fileName : RunCompletableFuture
 * author : taeil
 * date : 6/13/24
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 6/13/24        taeil                   최초생성
 */
public class RunCompletableFuture {



    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();


        ExecutorService executorService = Executors.newFixedThreadPool(5);
        UseSynchronized  useSynchronized = new UseSynchronized();

        AtomicInteger atomicInteger = new AtomicInteger();

        CompletableFuture[] futures = IntStream.range(0, 10)
                .mapToObj(i -> CompletableFuture.runAsync(() -> {
                    for (int j = 0; j < 300000; j++) {
                        // useSynchronized.add(j); -> 498ms
                        // UseSynchronized.addStatic(j); -> 394ms
                        // useSynchronized.addBlock(j); -> 386

                        atomicInteger.incrementAndGet();

                        if (j % 10000 == 0) {
                            System.out.println(atomicInteger);
                            System.out.println("working Thread is : " + Thread.currentThread().getName() + " add value is : " + j);
                        }
                    }
                }, executorService))
                .toArray(CompletableFuture[]::new);

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures);
        allOf.thenRun(() -> {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            System.out.println("All Futures are Done! Time taken: " + duration + " ms");
        }).join(); // main 스레드가 종료되지 않도록 대기

        // Shutdown the executor service to allow the program to terminate
        executorService.shutdown();
    }
}