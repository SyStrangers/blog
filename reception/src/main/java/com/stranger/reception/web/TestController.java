package com.stranger.reception.web;

import com.stranger.reception.service.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private TestServiceImpl testService;

    @GetMapping("/test")
    public String test(){
        return "index";
    }

    @ResponseBody
    @GetMapping("/json")
    public String json(){
        return testService.test().toString();
    }

}
