package com.fuge.example.controller;

import com.fuge.example.base.CommonResult;
import com.fuge.example.enumtype.PmsKey;
import com.fuge.example.pojo.dto.RuleConditionDTO;
import com.fuge.example.pojo.group.SaveGroup;
import com.fuge.example.pojo.vo.RuleConditionVO;
import com.fuge.example.service.RuleConditionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.oas.annotations.EnableOpenApi;

import javax.annotation.Resource;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author onemo
 * @Descption 规则管理控制器
 * @Date 2022-03-06 11:05:47
 */
@RestController
@RequestMapping("/rule/")
public class RuleManagerController {

    @Resource
    private RuleConditionService ruleConditionService;


    /**
     * 保存条件
     * @exportType ruleConditionExport
     * @param ruleConditionDTO 规则条件对象
     * @return 保存成功
     */
    @PmsKey("root.wdf.rule.save")
    @PostMapping("condition/save")
    public CommonResult<String> saveCondition(@Validated(SaveGroup.class) @RequestBody RuleConditionDTO ruleConditionDTO) {
        ruleConditionService.saveCondition(ruleConditionDTO);
        return CommonResult.success("条件保存成功");
    }


    /**
     * 根据规则ID获取规则条件集合
     *
     * @param ruleId 规则ID
     * @return 规则的条件集合
     */
    @PmsKey("root.wdf.rule.find")
    @PostMapping("condition/findByRuleId")
    public CommonResult<List<RuleConditionVO>> findCondition(@NotBlank(message = "规则ID不能为空") String ruleId) {
        return CommonResult.success(ruleConditionService.findByRuleId(ruleId));
    }
}
