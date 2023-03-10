package com.multi.pratice.multipratice.springbasic.resttemplate.controller;

import com.multi.pratice.multipratice.springbasic.resttemplate.dto.Req;
import com.multi.pratice.multipratice.springbasic.resttemplate.dto.UserResponse;
import com.multi.pratice.multipratice.springbasic.resttemplate.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.resttemplate.controller
 * fileName : RestTemplateController
 * author : taeil
 * date : 2023/03/03
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/03        taeil                   최초생성
 */
@RestController
@RequestMapping("/rest/client")
public class RestTemplateController {

    private final RestTemplateService restTemplateService;

    public RestTemplateController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }


    @GetMapping("/hello")
    public UserResponse getHello() {
        return restTemplateService.hello();
    }

    @PostMapping("/posthello")
    public UserResponse getPostHello() {
        return restTemplateService.post();
    }

    @PostMapping("/exchange")
    public UserResponse exchangeTest() {
        System.out.println("exchageController");
        return restTemplateService.exchange();
    }

    @PostMapping("/genericexchange")
    public Req<UserResponse> genericExchange() {
        return restTemplateService.genericExchange();
    }

}