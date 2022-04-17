package com.fuge.readwrite.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.fuge.readwrite.entity.ExampleInfo;
import com.fuge.readwrite.mapper.ExampleInfoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @DESCPTION:
 * @AUTOHR wangdingfu
 * @DATE 2022-04-11 23:05:30
 */
@RestController
@RequestMapping("example")
public class ExampleInfoController {

    @Resource
    private ExampleInfoMapper exampleInfoMapper;

    @GetMapping("save")
    public Integer save(){
        ExampleInfo exampleInfo = new ExampleInfo();
        exampleInfo.setExampleNo("001");
        exampleInfo.setExampleName("示例1");
        int insert = exampleInfoMapper.insert(exampleInfo);
        ExampleInfo exampleInfo1 = select(exampleInfo.getId());
        System.out.println(exampleInfo1);
        return exampleInfo.getId();
    }


    @DS("slave")
    @GetMapping("select")
    public ExampleInfo select(Integer id){
       return exampleInfoMapper.selectById(id);
    }
}
