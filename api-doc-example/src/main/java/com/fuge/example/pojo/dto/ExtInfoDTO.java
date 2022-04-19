package com.fuge.example.pojo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 扩展数据对象
 */
@Getter
@Setter
public class ExtInfoDTO {

    /**
     * 扩展信息ID
     */
    private Integer extInfoId;

    /**
     * 扩展信息内容
     */
    private String extInfoContent;
}
