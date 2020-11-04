package com.xignitex.demoservice.gateway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@Slf4j
public class HealthController {

    @GetMapping
    public String getHealth(){
        log.info("Called the health controller");
        return "OK";
    }
}
