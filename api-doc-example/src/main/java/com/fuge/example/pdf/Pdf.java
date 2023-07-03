package com.fuge.example.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


public class Pdf {

    private PdfPTable table;

    private PdfWriter writer;

    private BaseFont bf;

    private final Integer title1Hight = 38;
    private final static Integer resultHight = 20;
    private final static Integer colNum = 2;

    public static void main(String[] args) throws Exception {
        new Pdf().genTable();
    }


    public void genTable() throws Exception {
        // 每种尺寸的具体数值设置去com.itextpdf.text.PageSize中查看，横板就原数值顺序反过来
        Document document = new Document(PageSize.A4);
        String newFilename = "E:\\excel\\" + System.currentTimeMillis() + ".pdf";
        this.writer = PdfWriter.getInstance(document, new FileOutputStream(newFilename));


        //创建BaseFont对象，指明字体，编码方式,是否嵌入
        bf = BaseFont.createFont("E:\\simsun.ttf", BaseFont.IDENTITY_H, false);
        //创建Font对象，将基础字体对象，字体大小，字体风格
        final Font title1Font = new Font(bf, 15, Font.BOLD);
        final Font headerFont = new Font(bf, 10, Font.BOLD);
        final Font resultFont = new Font(bf, 10, Font.NORMAL);

        try {
            table = new PdfPTable(colNum);



            PdfPCell cellPdf = mergeCol("主播收益对账单", title1Font, colNum, title1Hight);
            table.addCell(cellPdf);


            createTableHeaderRow(headerFont, "月份", "金额(含税)");
            for (int i = 0; i < 10; i++) {
                createResultRow(resultFont, i + "月", i + ".00");
            }
            document.open();
            document.add(table);
            document.close();
            writer.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public void createResultRow(Font font, String colv1, String colv2) {
        //项目名称
        table.addCell(getResultCell(colv1, font));
        //项目简称
        table.addCell(getResultCell(colv2, font));
    }

    public void createTableHeaderRow(Font font, String colv1, String colv2) {
        table.addCell(getTableHeaderCell(colv1, font));
        table.addCell(getTableHeaderCell(colv2, font));
    }


    //合并列的静态函数指定
    public static PdfPCell mergeCol(String str, Font font, int i, int minimumHeight) {
        PdfPCell cell = new PdfPCell(new Paragraph(str, font));
        cell.disableBorderSide(15);
        cell.setMinimumHeight(minimumHeight);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        //将该单元格所在行包括该单元格在内的i列单元格合并为一个单元格    
        cell.setColspan(i);
        return cell;
    }

    //获取结果列表标题 
    public static PdfPCell getTableHeaderCell(String string, Font font) {
        //创建单元格对象，将内容与字体放入段落中作为单元格内容
        PdfPCell cell = new PdfPCell(new Paragraph(string, font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        //设置最小单元格高度
        cell.setMinimumHeight(resultHight);
        return cell;
    }

    //获取结果列表单元格
    public static PdfPCell getResultCell(String string, Font font) {
        //创建单元格对象，将内容与字体放入段落中作为单元格内容    
        PdfPCell cell = new PdfPCell(new Paragraph(string, font));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        //设置最小单元格高度
        cell.setMinimumHeight(resultHight);
        return cell;
    }




}