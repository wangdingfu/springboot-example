package com.fuge.example.pdf;

import cn.hutool.core.io.FileUtil;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: YSL
 * @date: 2022/8/2 16:16
 */
public class MergePdfFiles {

    private static final Logger logger = LoggerFactory.getLogger(MergePdfFiles.class);

    public static void main(String[] args) {
        String basePath = "C:\\Users\\fuge\\Desktop\\";
        List<String> pdfList = new ArrayList<>();
        pdfList.add(basePath + "1.pdf");
        pdfList.add(basePath + "2.pdf");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        morePdfTopdf(pdfList, outputStream);

        File file = new File(basePath + "3.pdf");
        FileUtil.writeBytes(outputStream.toByteArray(), file);
    }

    /**
     * 输出多个pdf合并出来的pdf, 这个方法未经改良
     *
     * @param fileList 文件地址列表, 是指硬盘目录
     * @param output   输出的目标流
     * @see <a href="https://www.cnblogs.com/whatlonelytear/p/9040600.html">用itext合并多个pdf文件【转】【补】</a>
     */


    public static void morePdfTopdf(List<String> fileList, OutputStream output) {
        Document document = null;
        try {
            document = new Document(new PdfReader(fileList.get(0)).getPageSize(1));
            PdfCopy copy = new PdfCopy(document, output);
            document.open();
            for (int i = 0; i < fileList.size(); i++) {
                PdfReader reader = new PdfReader(fileList.get(i));
                int n = reader.getNumberOfPages();// 获得总页码
                for (int j = 1; j <= n; j++) {
                    document.newPage();
                    PdfImportedPage page = copy.getImportedPage(reader, j);// 从当前Pdf,获取第j页
                    copy.addPage(page);
                }
                System.out.println(i);
            }
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                document.close();
            }
        }
    }



}