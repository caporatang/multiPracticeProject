package org.example.securitystudy.chapter1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName : org.example.securitystudy.chapter1
 * fileName : IndexController
 * author : taeil
 * date : 2024. 12. 28.
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2024. 12. 28.        taeil                   최초생성
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
}