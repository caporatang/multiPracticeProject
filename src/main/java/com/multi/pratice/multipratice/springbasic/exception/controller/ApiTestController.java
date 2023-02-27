package com.multi.pratice.multipratice.springbasic.exception.controller;

import com.multi.pratice.multipratice.springbasic.exception.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.exception.controller
 * fileName : ApiController
 * author : taeil
 * date : 2023/02/27
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/02/27        taeil                   최초생성
 */
@RestController
@RequestMapping("/api")
public class ApiTestController {

    @GetMapping("")
    public User get(@RequestParam(required = false) String name,
                    @RequestParam(required = false) Integer age)
    {
        User user = new User();
        user.setName(name);
        user.setAge(age);

        // NPE 발생
        int a = 10 + age;

        return user;
    }

    @PostMapping("")
    public User post(@Valid @RequestBody User user) {
        System.out.println(user);

        return user;
    }

    // 컨트롤러 안에 직접 작성 시, 해당 클래스 내부에서만 발생되는 exception에만 관여함
    // @ExceptionHandler(value = MethodArgumentNotValidException.class)
    // public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {

        // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    // }
}