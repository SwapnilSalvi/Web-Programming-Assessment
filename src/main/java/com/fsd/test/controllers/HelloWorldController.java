package com.fsd.test.controllers;

import com.fsd.test.beans.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @GetMapping("/hello")
    public ResponseEntity<Object> displayHelloWorld() {
        return ResponseHandler.generateResponse("Hello, World!", HttpStatus.OK, null);
    }
}
