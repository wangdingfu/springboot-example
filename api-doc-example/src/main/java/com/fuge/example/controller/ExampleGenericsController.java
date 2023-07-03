package com.fuge.example.controller;

import com.fuge.example.base.CommonResult;
import com.fuge.example.constants.ExampleConstants;
import com.fuge.example.pojo.dto.ExampleGenDTO;
import com.fuge.example.pojo.dto.ExampleGenSaveDTO;
import com.fuge.example.pojo.dto.ExampleSaveDTO;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.List;

/**
 * @author wangdingfu
 * @Descption 示例泛型控制器
 * @Date 2022-04-19 17:07:31
 */
@RestController
@RequestMapping(ExampleConstants.Request.URL_EXAMPLE)
public class ExampleGenericsController {

    /**
     * 请求保存示例的方法请求保存示例的方法请求保存示例的方法请求保存示例的方法请求保存示例的方法
     *请求保存示例的方法请求保存示例的方法请求保存示例的方法
     * @param dataList 保存示例对象
     * @return 成功
     */
    @PostMapping(ExampleConstants.Request.URL_EXAMPLE_SAVE1)
    public CommonResult<String> batchSave(@RequestBody List<ExampleGenSaveDTO> dataList) {
        return CommonResult.success("保存成功");
    }


    /**
     * 请求保存示例的方法
     *
     * @param data 保存示例对象
     * @return 成功
     */
    @PostMapping(ExampleConstants.Request.URL_EXAMPLE_SAVE2)
    public CommonResult<String> save(@RequestBody ExampleGenDTO<ExampleSaveDTO> data) {
        return CommonResult.success("保存成功");
    }
}
