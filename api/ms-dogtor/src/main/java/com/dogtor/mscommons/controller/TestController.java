package com.dogtor.mscommons.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Endpoint teste", description = "Endpoint para teste de funcionamento.")
@RequestMapping("/service")
@RequiredArgsConstructor
@RestController
public class TestController {

    @GetMapping
    public String a(){
        return "funcionou";
    }
}
