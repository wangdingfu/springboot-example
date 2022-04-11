package com.fuge.readwrite.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * @DESCPTION:
 * @AUTOHR wangdingfu
 * @DATE 2022-04-11 22:40:48
 */
@Getter
@Setter
@TableName("example_info")
public class ExampleInfo {

    @TableId
    private Integer id;

    @TableField("example_no")
    private String exampleNo;


    @TableField("example_name")
    private String exampleName;
}
