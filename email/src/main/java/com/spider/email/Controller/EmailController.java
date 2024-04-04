package com.spider.email.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

    @GetMapping
    public ResponseEntity<String> sendMail(){

        return  new ResponseEntity<>("welcome OnBoard", HttpStatus.OK);
    }
}
