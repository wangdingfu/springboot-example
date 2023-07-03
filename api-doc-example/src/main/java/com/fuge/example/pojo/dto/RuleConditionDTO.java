package com.fuge.example.pojo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
     * 规则状态
     *
     * @see RuleStatusEnum
     */
    @JsonIgnore
    private Integer ruleStatus;

    /**
     * 条件ID
     */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;


    @NotNull(message = "条件根节点类型 不能为空", groups = {SaveGroup.class})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Integer nodeType;

    /**
     * 条件key
     */
    @JsonProperty
    private String key;

    /**
     * 条件key类型
     */
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
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
