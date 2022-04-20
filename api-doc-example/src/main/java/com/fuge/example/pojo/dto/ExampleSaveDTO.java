package com.fuge.example.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


/**
 * 保存示例对象
 */
@Getter
@Setter
public class ExampleSaveDTO<T> extends BasePageDTO implements Serializable {

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
    private List<ExampleItemDTO> itemList;

    /**
     * 扩展信息集合
     */
    private List<T> extInfoList;
}
