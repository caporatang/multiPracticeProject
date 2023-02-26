package com.multi.pratice.multipratice.springbasic.validation.controller;

import com.multi.pratice.multipratice.springbasic.validation.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.validation.controller
 * fileName : ApiController
 * author : taeil
 * date : 2023/02/26
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/26        taeil                   최초생성
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult) {

        // validtion을 이용해서 에러가 발생될 경우 BindingResult객체를 이용해서 에러 유무를 확인할수있고, 메세지를 설정할수있음
        if(bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                // 어떤 필드에서 에러 났는지 가져오기
                FieldError field = (FieldError) objectError;

                String message = objectError.getDefaultMessage();

                System.out.println("field : " + field.getField());
                System.out.println(message);

                sb.append("field : " + field.getField());
                sb.append("message : " + message);
            });
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }

        // logic


        System.out.println(user);
        // 일반적인 validation check --> 받아야될 값이 100개 200개라면 힘들어짐
        // if(user.getAge() >= 90) {
        //    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        // }

        return ResponseEntity.ok(user);
    }
}