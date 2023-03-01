package com.multi.pratice.multipratice.springbasic.async.controller;

import com.multi.pratice.multipratice.springbasic.async.service.AsyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.async.controller
 * fileName : AsyncController
 * author : taeil
 * date : 2023/03/01
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/01        taeil                   최초생성
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class AsyncController {

    private final AsyncService asyncService;

    @GetMapping("/hello")
    public CompletableFuture hello() {

        log.info("completable future init");

        return asyncService.run();
    }


}