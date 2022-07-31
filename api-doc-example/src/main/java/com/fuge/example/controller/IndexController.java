package com.fuge.example.controller;

import com.fuge.example.base.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wangdingfu
 * @Description
 * @Date 2022-06-25 21:54:42
 */
@RestController
public class IndexController {


    @GetMapping("/")
    public String index() {
        return "<h1>welcome to wangdingfu</h1>";
    }
}
