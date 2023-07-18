package com.fuge.example;

import cn.hutool.json.JSONUtil;
import com.fuge.example.config.MybatisPlusConfig;
import com.fuge.example.entity.Student;
import com.fuge.example.mapper.StudentMapper;
import org.junit.Test;

/**
 * @author wangdingfu
 * @date 2023-07-18 17:42:24
 */
public class MybatisPlusTest {


    @Test
    public void test1() {
        MybatisPlusConfig.execute(StudentMapper.class, studentMapper -> {
            Student student = studentMapper.selectById(1);
            System.out.println(JSONUtil.toJsonPrettyStr(student));
        });
    }
}
