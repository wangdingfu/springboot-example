package com.fuge.example.util;

import com.github.jsonzou.jmockdata.JMockData;
import com.github.jsonzou.jmockdata.TypeReference;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author wangdingfu
 * @Descption
 * @Date 2022-05-20 10:38:58
 */
public class TestUtils {


    public static void main(String[] args) {
        System.out.println(JMockData.mock(int[].class));
        System.out.println(JMockData.mock(new TypeReference<List<Integer>>() {}));
    }

}
