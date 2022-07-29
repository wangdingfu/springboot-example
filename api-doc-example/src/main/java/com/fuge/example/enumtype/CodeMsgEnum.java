package com.fuge.example.enumtype;

import lombok.Getter;

/**
 * 隐藏类型枚举
 */
@Getter
public enum CodeMsgEnum {
    TEST1(HideConstants.HIDE_ADD_AUTO_DISTRIBUTE,"自动分配积分"),
    TEST2(HideConstants.HIDE_COMPULSORY_MOTHBALL+HideConstants.HIDE_EXCEPTION_CONFIRM_SCORE,"隐藏强制归档逻辑"),
    TEST3(HideConstants.HIDE_EXCEPTION_SCORE,"隐藏评分异常"),
    TEST4(HideConstants.HIDE_PERMISSION,"隐藏权限"),
    TEST5(HideConstants.HIDE_EXCEPTION_CONFIRM_SCORE,"隐藏项目无确认得分异常"),
    ;

    private final String code;

    private final String msg;

    CodeMsgEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
