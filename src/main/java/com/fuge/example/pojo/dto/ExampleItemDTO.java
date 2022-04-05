package com.fuge.example.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 例子项对象
 */
@Getter
@Setter
public class ExampleItemDTO extends BasePageDTO implements Serializable {

    /**
     * 明细ID
     */
    private String itemId;

    /**
     * 明细项名称
     */
    private String itemName;

    /**
     * 金额
     */
    private BigDecimal amount;

    /**
     * 长度
     */
    private Integer itemLength;

    /**
     * 明细集合
     */
    private List<String> detailList;
}
