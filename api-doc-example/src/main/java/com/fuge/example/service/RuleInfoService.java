package com.fuge.example.service;

import com.fuge.example.pojo.vo.RuleInfoVO;

/**
 * @author wangdingfu
 * @Descption 规则信息接口
 * @Date 2022-06-13 10:17:43
 */
public interface RuleInfoService {


    RuleInfoVO findRule(Integer ruleId);
}
