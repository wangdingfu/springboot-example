package com.fuge.example.pojo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 批量保存扩展信息对象
 */
@Getter
@Setter
public class BatchExtInfoDTO {

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 批次扩展内容
     */
    private String batchExtInfo;

}
