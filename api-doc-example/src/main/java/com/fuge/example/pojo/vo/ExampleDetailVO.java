package com.fuge.example.pojo.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @DESCPTION: 示例详情结果对象
 * @AUTOHR wangdingfu
 * @DATE 2022-04-05 22:53:36
 */
@Getter
@Setter
public class ExampleDetailVO implements Serializable {

    /**
     * 主健ID
     */
    private Integer id;

    /**
     * 示例编号
     */
    private String exampleNo;

    /**
     * 示例名称
     */
    private String exampleName;

    /**
     * 示例子项集合
     */
    private List<ExampleItemVO> itemList;


    @Getter
    @Setter
    public static class ExampleItemVO{
        private Integer itemId;

        private String itemName;
    }
}
