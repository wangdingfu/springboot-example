package com.fuge.example.controller;

import com.fuge.example.constants.ExampleConstants;
import com.fuge.example.pojo.dto.ExampleSaveDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ExampleConstants.Request.URL_EXAMPLE)
public class ExampleController {


    /**
     * 请求保存示例的方法
     *
     * @param exampleSaveDTO 保存示例对象
     * @return 成功
     */
    @PostMapping(ExampleConstants.Request.URL_EXAMPLE_SAVE)
    public String save(@RequestBody ExampleSaveDTO exampleSaveDTO) {
        return "success";
    }
}
