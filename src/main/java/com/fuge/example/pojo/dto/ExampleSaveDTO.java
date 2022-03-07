package com.fuge.example.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


/**
 * 保存示例对象
 */
@Getter
@Setter
public class ExampleSaveDTO implements Serializable {

    /**
     * 示例名称
     */
    private String exampleName;

    /**
     * 示例编号
     */
    private String exampleNo;

    /**
     * 例子项
     */
    private ExampleItemDTO item;
}
