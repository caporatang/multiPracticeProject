package com.multi.pratice.multipratice.springbasic.junit.springjunit.controller;

import com.multi.pratice.multipratice.springbasic.junit.springjunit.component.Calculator;
import com.multi.pratice.multipratice.springbasic.junit.springjunit.component.ICalculator;
import com.multi.pratice.multipratice.springbasic.junit.springjunit.dto.Req;
import com.multi.pratice.multipratice.springbasic.junit.springjunit.dto.Res;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * packageName : com.multi.pratice.multipratice.springbasic.junit.springjunit.controller
 * fileName : CalculatorApiController
 * author : taeil
 * date : 2023/03/02
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/03/02        taeil                   최초생성
 */
@RestController
@RequestMapping("/calc")
@RequiredArgsConstructor
public class CalculatorApiController {

    private final Calculator calculator;

    @GetMapping("/sum")
    public int sum(@RequestParam int x, @RequestParam int y) {
        return calculator.sum(x, y);
    }

    @GetMapping("/minus")
    public int minus(@RequestParam int x, @RequestParam int y) {
        return calculator.minus(x, y);
    }

//    @PostMapping("/postsum")
//    public int postSum(@RequestParam int x, @RequestParam int y) {
//        return calculator.sum(x, y);
//    }

    @PostMapping("/postminus")
    public Res postMinus(@RequestBody Req req) {
        int result = calculator.minus(req.getX(), req.getY());

        Res res = new Res();
        res.setResult(result);
        res.setResponse(new Res.Body());
        return res;

    }


}