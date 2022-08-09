package com.fuge.example.service;

import com.fuge.example.pojo.dto.RuleConditionDTO;
import com.fuge.example.pojo.vo.RuleConditionVO;
import com.fuge.example.pojo.vo.RuleInfoVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author wangdingfu
 * @Descption 规则条件接口
 * @Date 2022-06-06 21:17:55
 */
public interface RuleConditionService {


    /**
     * 保存规定则条件
     *
     * @param ruleConditionDTO 规则条件参数
     */
    void saveCondition(RuleConditionDTO ruleConditionDTO);


    /**
     * 根据规则ID获取规则条件集合
     *
     * @param ruleId 规则ID
     * @return 规则条件集合
     */
    List<RuleConditionVO> findByRuleId(String ruleId);
}
