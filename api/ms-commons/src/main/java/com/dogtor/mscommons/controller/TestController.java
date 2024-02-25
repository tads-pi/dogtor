package com.dogtor.mscommons.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/service")
@RequiredArgsConstructor
@RestController
public class TestController {

    @GetMapping
    public String a(){
        return "funcionou";
    }
}
