package com.fuge.example.script;

import cn.hutool.json.JSON;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangdingfu
 * @date 2023-05-30 18:15:26
 */
@Getter
@Setter
public class FuDocContext {

    /**
     * 环境变量
     */
    private final Map<String, Object> env = new HashMap<>();

    /**
     * 响应结果
     */
    private JSON result;
}
