package com.fuge.example.service.impl;

import com.fuge.example.pojo.dto.RuleConditionDTO;
import com.fuge.example.pojo.vo.RuleConditionVO;
import com.fuge.example.service.RuleConditionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangdingfu
 * @Descption
 * @Date 2022-06-13 10:28:25
 */
@Service
public class RuleConditionServiceImpl implements RuleConditionService {
    @Override
    public void saveCondition(RuleConditionDTO ruleConditionDTO) {

    }

    @Override
    public List<RuleConditionVO> findByRuleId(String ruleId) {
        return null;
    }
}
