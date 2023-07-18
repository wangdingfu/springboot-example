package com.fuge.example.controller;

import cn.hutool.core.io.FileUtil;
import com.fuge.example.base.CommonResult;
import com.fuge.example.pojo.dto.FuDocAnchor;
import com.fuge.example.pojo.dto.RuleInfoQueryDTO;
import com.fuge.example.pojo.vo.RuleInfoVO;
import com.fuge.example.service.RuleInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author wangdingfu
 * @Descption 规则信息控制器
 * @Date 2022-06-13 10:18:01
 */
@Api(value = "规则信息控制器")
@RestController
@RequestMapping("/rule/")
public class RuleInfoController {

    @Resource
    private RuleInfoService ruleInfoService;

    /**
     * 查询规则
     *
     * @param ruleId   规则ID
     * @param ruleCode 规则code
     * @param bizId    业务ID
     * @param bizNo    业务编号
     * @return 规则信息对象
     */
    @GetMapping(value = {"/findRule/{ruleId}", "/findRule/{ruleCode}", "/findRule/{bizId}"})
    public CommonResult<RuleInfoVO> aa(@PathVariable(required = false) Integer ruleId,
                                             @PathVariable(required = false) String ruleCode,
                                             @PathVariable(required = false) Integer bizId,
                                             Integer bizNo,
                                             HttpServletRequest request) {
        return CommonResult.success(ruleInfoService.findRule(ruleId, ruleCode, bizId));
    }

    /**
     * 查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则查询规则
     *
     * @param ruleId   规则ID
     * @param ruleCode 规则编码
     * @param bizId    业务ID
     * @return 规则信息
     */
    @GetMapping("/findRule")
    public CommonResult<RuleInfoVO> findRule1(@RequestParam Integer ruleId, String ruleCode, Integer bizId, HttpServletRequest request) {
        return CommonResult.success(ruleInfoService.findRule(ruleId, ruleCode, bizId));
    }

    /**
     * 上传规则
     *
     * @param file     规则文件
     * @param queryDTO 查询参数
     * @return 上传结果
     */
    @PostMapping("uploadRule")
    public CommonResult<String> uploadRule(MultipartFile file, RuleInfoQueryDTO queryDTO, HttpServletRequest request) {
        return CommonResult.success("上传成功");
    }


    @PostMapping("test")
    public CommonResult<String> test(FuDocAnchor fuDocAnchor) {
        return CommonResult.success("上传成功");
    }

    /**
     * 下载文件
     * @param request
     * @return
     */
    @GetMapping("downloadFile")
    public void downloadFile2(HttpServletResponse response) {
        OutputStream out = null;
        try {
            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename=" + "斗鱼-工时单-202304-王定福3.xls");
            out = response.getOutputStream();
            out.write(FileUtil.readBytes("C:\\Users\\fuge\\Desktop\\斗鱼-工时单-202304-王定福.xls"));
            out.flush();
        } catch (IOException e) {

        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
