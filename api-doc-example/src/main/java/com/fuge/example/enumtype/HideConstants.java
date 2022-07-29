package com.fuge.example.enumtype;

/**
 * @author wangdingfu
 * @date 2022-07-18 17:31:05
 */
public interface HideConstants {

    /**
     * 项目审核时去掉需校验“是否已初评分”的逻辑
     */
    String HIDE_EXCEPTION_SCORE = "hide.exception.score";

    /**
     * 结项保存或编辑时 去掉 “项目无确认得分，请在PO分配积分后再结项” 的异常
     */
    String HIDE_EXCEPTION_CONFIRM_SCORE = "hide.exception.no.confirm.score";


    /**
     * 隐藏  项目未分配积分，业务不可结项 异常
     */
    String HIDE_EXCEPTION_BUSINESS_ACHIEVE = "hide.exception.business.no.achieve";

    /**
     * 隐藏 结项项目不存在 异常
     */
    String HIDE_EXCEPTION_DEV_ACHIEVE = "hide.exception.dev.no.achieve";

    /**
     * 归档逻辑更新为强制归档
     */
    String HIDE_COMPULSORY_MOTHBALL = "hide.update.compulsory.mothball";

    /**
     * 隐藏按钮权限key
     */
    String HIDE_PERMISSION = "hide.permission";

    /**
     * 新增自动分配积分
     */
    String HIDE_ADD_AUTO_DISTRIBUTE = "hide.add.auto.distribute";


}
