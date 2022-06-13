package com.fuge.example.controller;

import com.fuge.example.base.CommonResult;
import com.fuge.example.pojo.dto.RuleInfoQueryDTO;
import com.fuge.example.service.RuleInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangdingfu
 * @Descption 规则信息控制器
 * @Date 2022-06-13 10:18:01
 */
@RestController
@RequestMapping("/rule/")
public class RuleInfoController {

    @Resource
    private RuleInfoService ruleInfoService;

    /**
     * 保存条件
     *
     * @param ruleInfoQueryDTO 规则ID
     * @return 规则对象
     */
    @PostMapping("/findRule")
    public CommonResult<String> findRule(RuleInfoQueryDTO ruleInfoQueryDTO) {
        ruleInfoService.findRule(ruleInfoQueryDTO.getRuleId());
        return CommonResult.success("条件保存成功");
    }

}
