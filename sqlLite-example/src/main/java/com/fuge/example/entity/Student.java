package com.fuge.example.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * @author wangdingfu
 * @date 2023-07-18 17:39:51
 */
@Getter
@Setter
@TableName("test")
public class Student {
    private Long id;

    private String name;

    private int age;

}
