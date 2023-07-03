package com.fuge.example.pdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.*;
 
import java.io.FileOutputStream;
 
//import org.junit.Test;
 
public class PdfWaterMark {
 
	public static void addWaterMark(String srcPdfPath,String tarPdfPath,String WaterMarkContent)throws Exception {
        PdfReader reader = new PdfReader(srcPdfPath);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(tarPdfPath));
        //创建字体，第一个参数是字体路径
        BaseFont base = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);

        PdfGState gs = new PdfGState();
        gs.setFillOpacity(0.2f);//图片水印透明度
        //gs.setStrokeOpacity(0.4f);//设置笔触字体不透明度
        PdfContentByte content = null;

        int total = reader.getNumberOfPages();//pdf文件页数
        for (int i=0; i<total; i++) {
            float x =  reader.getPageSize(i+1).getWidth();//页宽度
            float y = reader.getPageSize(i+1).getHeight();//页高度
            content = stamper.getOverContent(i+1);
            content.setGState(gs);
            content.beginText();//开始写入
            content.setFontAndSize(base, 20);//字体大小
            //每页7行，一行3个
            for (int j=0; j<3; j++) {
                for (int k=0; k<7; k++) {
                    //showTextAligned 方法的参数（文字对齐方式，位置内容，输出水印X轴位置，Y轴位置，旋转角度）
                    content.showTextAligned(Element.ALIGN_CENTER, WaterMarkContent, x/3*j+90, y/7*k, 25);
                }
            }
            content.endText();//结束写入
        }
        //关闭流
        stamper.close();
        reader.close();
    }

    public static void main(String[] args) throws Exception {
        String basePath = "C:\\Users\\fuge\\Desktop";
        addWaterMark(basePath+"\\测试1.pdf",basePath+"\\测试4.pdf","我是一个水印");
    }

}