package com.fuge.example.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * 保存示例对象
 */
@Getter
@Setter
public class ExampleSaveDTO<T> extends BasePageDTO implements Serializable {

    private static final long serialVersionUID = 7539751867062907086L;
    /**
     * 示例名称
     */
    private String exampleName;

    /**
     * 示例编号
     */
    private String exampleNo;

    /**
     * id集合
     */
    private List<List<Integer>> exampleIdList;

    /**
     * 例子项
     */
    private List<ExampleItemDTO> itemList;

    /**
     * 扩展信息集合
     */
    private List<T> extInfoList;
}
