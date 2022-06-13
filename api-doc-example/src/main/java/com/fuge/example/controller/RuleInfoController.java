package com.fuge.example.controller;

import com.fuge.example.base.CommonResult;
import com.fuge.example.pojo.dto.RuleInfoQueryDTO;
import com.fuge.example.pojo.vo.RuleInfoVO;
import com.fuge.example.service.RuleInfoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
     * 查询规则
     *
     * @param ruleId   规则ID
     * @param ruleCode 规则code
     * @param bizId    业务ID
     * @param bizNo    业务编号
     * @return 规则信息对象
     */
    @PostMapping(value = {"/findRule/{ruleId}", "/findRule/{ruleCode}", "/findRule/{bizId}"})
    public CommonResult<RuleInfoVO> findRule(@PathVariable(required = false) Integer ruleId,
                                             @PathVariable(required = false) String ruleCode,
                                             @PathVariable(required = false) Integer bizId,
                                             Integer bizNo,
                                             HttpServletRequest request) {
        return CommonResult.success(ruleInfoService.findRule(ruleId, ruleCode, bizId));
    }


    /**
     * 上传规则
     *
     * @param file     规则文件
     * @param queryDTO 查询参数
     * @return 上传结果
     */
    @PostMapping("uploadRule")
    public CommonResult<String> uploadRule(MultipartFile file, RuleInfoQueryDTO queryDTO) {
        return CommonResult.success("上传成功");
    }
}
