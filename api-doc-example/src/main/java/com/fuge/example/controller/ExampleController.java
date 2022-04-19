package com.fuge.example.controller;

import com.fuge.example.base.CommonResult;
import com.fuge.example.constants.ExampleConstants;
import com.fuge.example.pojo.dto.ExampleSaveDTO;
import com.fuge.example.pojo.dto.ExtInfoDTO;
import com.fuge.example.pojo.vo.ExampleDetailVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 示例访问控制器
 */
@RestController
@RequestMapping(ExampleConstants.Request.URL_EXAMPLE)
public class ExampleController {

    /**
     * 请求保存示例的方法
     *
     * @param exampleSaveDTO 保存示例对象
     * @return 成功
     */
    @PostMapping(ExampleConstants.Request.URL_EXAMPLE_SAVE)
    public CommonResult<String> save(@RequestBody ExampleSaveDTO<ExtInfoDTO> exampleSaveDTO) {
        return CommonResult.success("保存成功");
    }


    /**
     * 请求保存示例的方法
     *
     * @param exampleSaveDTO 保存示例对象
     * @return 成功
     */
    @PostMapping(ExampleConstants.Request.URL_EXAMPLE_BATCH_SAVE)
    public CommonResult<String> batchSave(@RequestBody List<ExampleSaveDTO> exampleSaveDTO) {
        return CommonResult.success("保存成功");
    }




    /**
     * 删除数据
     *
     * @param id 主健ID
     * @return 删除结果
     */
    @DeleteMapping(ExampleConstants.Request.URL_EXAMPLE_DELETE)
    public CommonResult<String> delete(int id, int subId) {
        return CommonResult.success("删除成功");
    }


    /**
     * 详情接口
     *
     * @param id 主健ID
     * @return 详情对象
     */
    @GetMapping(ExampleConstants.Request.URL_EXAMPLE_DETAIL)
    public CommonResult<ExampleDetailVO> detail(@PathVariable String id, int subId) {
        return CommonResult.success(new ExampleDetailVO());
    }

}
