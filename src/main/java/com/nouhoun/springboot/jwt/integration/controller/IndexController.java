package com.nouhoun.springboot.jwt.integration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/upload3")
    public String index() {
        return "upload";
    }

}