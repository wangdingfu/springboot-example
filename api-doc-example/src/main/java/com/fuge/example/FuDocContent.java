package com.fuge.example;

import cn.hutool.json.JSON;
import com.fuge.example.script.Env;
import com.fuge.example.script.Result;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangdingfu
 * @date 2023-05-30 13:35:45
 */
@Getter
@Setter
public class FuDocContent {

    private Env env;

    private Result result;

    private JSON data;
}
