package com.fuge.example.enumtype;

import lombok.Getter;

/**
 * @author wangdingfu
 * @date 2022-07-18 17:31:05
 */
@Getter
public enum RuleStatusEnum {

    ENABLE(1, "启用"), DISABLE(2, "禁用"), LOADING(3, "加载中"),
    ;

    private final int code;

    private final String msg;

    RuleStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
