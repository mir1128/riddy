package com.loobo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("riddy")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET)
    public String getSchedulers() {
        return "hello world";
    }

}

