package com.spider.humanresourcemanagementsystem.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hrms")
public class HrmsController {
@GetMapping("/checkin")
    public ResponseEntity<String>checkin(){
        return new ResponseEntity<>("Checked in successfully", HttpStatus.ACCEPTED);
    }
}
