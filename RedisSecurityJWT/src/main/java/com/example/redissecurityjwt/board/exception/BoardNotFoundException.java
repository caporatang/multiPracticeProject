package com.example.redissecurityjwt.board.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * packageName : com.example.redissecurityjwt.board.exception
 * fileName : BoardNotFoundException
 * author : taeil
 * date : 2023/04/02
 * description :
 * =======================================================
 * DATE          AUTHOR                      NOTE
 * -------------------------------------------------------
 * 2023/04/02        taeil                   최초생성
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BoardNotFoundException extends RuntimeException {

    public BoardNotFoundException(String message) {
        super(message);
    }

}