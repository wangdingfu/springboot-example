package com.fuge.example.service;

import com.fuge.example.pojo.dto.RuleConditionDTO;
import com.fuge.example.pojo.vo.RuleConditionVO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author wangdingfu
 * @Descption 规则条件接口
 * @Date 2022-06-06 21:17:55
 */
public interface RuleConditionService {

    void saveCondition(RuleConditionDTO ruleConditionDTO);

    List<RuleConditionVO> findByRuleId(String ruleId);
}
