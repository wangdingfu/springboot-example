package com.fuge.example.pdf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
 
import javax.imageio.ImageIO;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class demo {
	private static int blank = 5;
//
//	public static void main(String[] args) {
//		try {
//			String basePath = "C:\\Users\\fuge\\Desktop\\";
//
//			// 获取所有图片
//			List<String> list = new ArrayList<>();
//			list.add(basePath+"1.jpg");
//			list.add(basePath+"2.png");
//			addPdfMark(basePath+"测试4.pdf", basePath+"测试5.pdf", list);
//		} catch (Exception e) {
//			System.out.println("失败");
//			e.printStackTrace();
//		}
//		System.out.println("成功");
//	}
 
	public static void addPdfMark(String InPdfFile, String outPdfFile, List<String> imgList) throws Exception {
		try {
			// 获取PDF文档信息
			Map<String, Object> pdfMsg = getPdfMsg(InPdfFile);
			// 开始计算图片起始位置 * PDF文档宽度 - （所有图片的宽度 + 每张图片右侧加5 个单位的空白 ）
			float startAddress = Float.valueOf(pdfMsg.get("width").toString());
			for (String imgPath : imgList) {
				startAddress -= (Double.valueOf(getImgMsg(imgPath).get("width").toString()) + blank);
			}
 
			PdfReader reader = new PdfReader(InPdfFile, "PDF".getBytes());
			PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(outPdfFile));
 
			for (String imgPath : imgList) {
				Image img = Image.getInstance(imgPath);// 插入水印   
				// 设置图片水印的位置。
				img.setAbsolutePosition(startAddress, 400);
				// 开始水印 如果需要每一页都加图片，这里添加循环即可
				PdfContentByte under = stamp.getUnderContent(Integer.valueOf(pdfMsg.get("pageSize").toString()));
				under.addImage(img);
				startAddress += Float.valueOf(Float.valueOf(getImgMsg(imgPath).get("width").toString()) + blank);
			}
 
			stamp.close();// 关闭          
			File tempfile = new File(InPdfFile);
 
			if (tempfile.exists()) {
				tempfile.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	public static Map<String, Object> getPdfMsg(String filePath) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			// 获取PDF共有几页
			PdfReader pdfReader = new PdfReader(new FileInputStream(filePath));
			int pages = pdfReader.getNumberOfPages();
			// System.err.println(pages);
			map.put("pageSize", pages);
 
			// 获取PDF 的宽高
			PdfReader pdfreader = new PdfReader(filePath);
			Document document = new Document(pdfreader.getPageSize(pages));
			float widths = document.getPageSize().getWidth();
			// 获取页面高度
			float heights = document.getPageSize().getHeight();
			// System.out.println("widths = " + widths + ", heights = " + heights);
			map.put("width", widths);
			map.put("height", heights);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
 
	public static Map<String, Object> getImgMsg(String imgPath) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		try {
			File picture = new File(imgPath);
			BufferedImage sourceImg = ImageIO.read(new FileInputStream(picture));
			// System.out.println("=源图宽度===>"+sourceImg.getWidth()); // 源图宽度
			// System.out.println("=源图高度===>"+sourceImg.getHeight()); // 源图高度
			map.put("width", sourceImg.getWidth());
			map.put("height", sourceImg.getHeight());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public static void main(String[] args) throws DocumentException, FileNotFoundException {
		createTable();
	}

	public static void createTable() throws FileNotFoundException, DocumentException {
		String path = "E:/demo/pdfCreat/"+System.currentTimeMillis()+".pdf";//输出pdf的路径
		Document doc = new Document();
		PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(path));
		doc.open();
		PdfPTable table = new PdfPTable(4);
		//设置控制
		table.setSpacingBefore(40);//表格前间距
		table.setSpacingAfter(100);//表格后间距
		table.setWidthPercentage(80);//表格宽占page比例
		table.setHorizontalAlignment(Element.ALIGN_LEFT);//表格水平对齐方式
		/*
		 *      设置构成标题的顶部行数。只有当表被添加到文档并且表跨页时，这个header才有意义。
		 */

		table.setHeaderRows(2);
		/*
		 *     设置页脚要使用的行数。页脚的数量从页眉行中减去。例如，对于一个有两个页眉行和一个页脚行的表，代码应该是:
		 *    table.setHeaderRows (3);
		 *    table.setFooterRows (1);
		 *    第0行和第1行是页眉行，第2行是页脚行。
		 */
		table.setFooterRows(1);
		table.setPaddingTop(10f);//设置表格顶部padding
		//设置单元格
		/**
		 * getDefaultCell()得到的Cell代表所有不是table.add(PdfPCell)的Cell。例：table.add(new Paragraph("test")).
		 */
		table.getDefaultCell().setVerticalAlignment(Element.ALIGN_TOP);//单元格中文字垂直对齐方式
		table.getDefaultCell().setBorderColor(BaseColor.BLACK);//单元格线条颜色
		table.getDefaultCell().setMinimumHeight(30);//单元格最小高度
		table.getDefaultCell().setExtraParagraphSpace(5);//段落文字与表格之间的距离,底部距离
		table.getDefaultCell().setLeading(15, 0);//设置行间距
//        table.getDefaultCell().setFixedHeight(20f);//表格固定高度
		for(int i=0;i<16;i++) {
			table.addCell(new Paragraph("test"));
		}
		doc.add(table);
		PdfContentByte cb = writer.getDirectContent();
		cb.fill();
		cb.sanityCheck();
		doc.close();

	}
 
}
