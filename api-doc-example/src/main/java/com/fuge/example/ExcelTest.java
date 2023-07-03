package com.fuge.example;

import com.alibaba.excel.EasyExcel;
import org.apache.commons.compress.utils.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangdingfu
 * @date 2022-10-11 17:05:38
 */
public class ExcelTest {

    public static void main(String[] args) {
        String fileName = "C:\\Users\\fuge\\Desktop\\" + "dynamicHeadWrite" + System.currentTimeMillis() + ".xlsx";
        List<String> row1 = new ArrayList<>();
        row1.add("分类一");
        row1.add("分类一(a)");


        List<String> row2 = new ArrayList<>();
        row2.add("分类一");
        row2.add("分类一(b)");

        List<String> row3 = new ArrayList<>();
        row3.add("分类一");
        row3.add("分类一(c)");

        List<List<String>> headerList = new ArrayList<>();
        headerList.add(row1);
        headerList.add(row2);
        headerList.add(row3);
        List<List<String>> data = new ArrayList<>();
        List<String> data1 = new ArrayList<>();
        data.add(data1);
        EasyExcel.write(fileName).head(headerList).sheet().doWrite(data);
    }
}
