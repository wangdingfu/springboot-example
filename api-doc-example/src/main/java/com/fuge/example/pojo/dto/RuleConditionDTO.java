package com.fuge.example.pojo.dto;

import com.alibaba.fastjson.JSONObject;
import com.fuge.example.enumtype.RuleStatusEnum;
import com.fuge.example.pojo.group.SaveGroup;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author onemo
 * @Descption 规则条件对象
 * @Date 2022-03-06 11:07:23
 */
@Getter
@Setter
public class RuleConditionDTO {


    /**
     * 测试枚举
     *
     * @see RuleStatusEnum
     */
    private Integer ruleStatus;

    /**
     * 条件ID
     */
    private String id;


    private JSONObject jsonObject;

    /**
     * 节点类型
     */
    @NotNull(message = "条件根节点类型不能为空", groups = {SaveGroup.class})
    private Integer nodeType;

    /**
     * 条件key
     */
    private String key;

    /**
     * 条件key类型
     */
    private String keyType;

    /**
     * 操作符
     */
    private String operate;

    /**
     * 条件值
     */
    private String value;

    /**
     * 条件值类型
     */
    private String valueType;

    /**
     * 子条件
     */
    @Valid
    @NotEmpty(message = "条件列表不能为空", groups = {SaveGroup.class})
    private List<RuleConditionDTO> children;
}
