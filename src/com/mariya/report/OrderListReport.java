package com.mariya.report;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mariya.entity.Employer;
import com.mariya.entity.Office;
import com.mariya.entity.Order;
import com.mariya.enums.OrderStatus;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;


public class OrderListReport {

    private File reportFile;


    public OrderListReport(File filepath){
        reportFile = filepath;
	}

    private PdfPCell createCell(String text, BaseColor color, int aligment) {
        Paragraph paragraph = getTextParagraph(text);
        PdfPCell cell = new PdfPCell(paragraph);
        cell.setHorizontalAlignment(aligment);
        cell.setBackgroundColor(color);
        return cell;
    }

    private Paragraph getTextParagraph(String text) {
        Font norm = FontFactory.getFont("C:\\Windows\\Fonts\\Times.ttf","CP1251", 9, Font.NORMAL);               
        Paragraph paragraph = new Paragraph(text, norm);
        return paragraph;
    }

    public void generate(Office office,  Collection<Order> employees) throws Exception {

        Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(reportFile));
		document.open();

        document.add(getTextParagraph("Організація: " + office.getName()));
        document.add(getTextParagraph("Телефон: " + office.getPhone()));
        document.add(getTextParagraph("Електронна пошта: " + office.getMail()));
        document.add(getTextParagraph("Адреса: " + office.getAddress()));
        document.add(new Paragraph(" "));


		float[] colsWidth = {20f, 50f, 100f, 100f, 60f, 60f, 60f, 60f}; // Code 1
		PdfPTable table = new PdfPTable(colsWidth);

		table.setWidthPercentage(100); // Code 2
		table.setHorizontalAlignment(Element.ALIGN_LEFT);//Code 3

        // header

        table.addCell(createCell("п/н", BaseColor.GRAY, Element.ALIGN_CENTER));
		table.addCell(createCell("Дата Замовлення", BaseColor.GRAY, Element.ALIGN_CENTER));
		table.addCell(createCell("Менеджер", BaseColor.GRAY, Element.ALIGN_CENTER));
		table.addCell(createCell("Продукт", BaseColor.GRAY, Element.ALIGN_CENTER));
        table.addCell(createCell("Ціна Продукту (грн)", BaseColor.GRAY, Element.ALIGN_CENTER));
        table.addCell(createCell("Замовлена Кількість (шт)", BaseColor.GRAY, Element.ALIGN_CENTER));
        table.addCell(createCell("Загальна Сума", BaseColor.GRAY, Element.ALIGN_CENTER));
        table.addCell(createCell("Статус", BaseColor.GRAY, Element.ALIGN_CENTER));

        // data
        int i = 1;
        for (Order order : employees) {
            table.addCell(createCell(i + "", BaseColor.WHITE, Element.ALIGN_LEFT));

            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

		    table.addCell(createCell(format.format(order.getDate()), BaseColor.WHITE, Element.ALIGN_LEFT));
		    table.addCell(createCell(order.getEmployee().getFullName(), BaseColor.WHITE, Element.ALIGN_LEFT));
		    table.addCell(createCell(order.getProduct().getName(), BaseColor.WHITE, Element.ALIGN_LEFT));
		    table.addCell(createCell(order.getProduct().getPrice().floatValue() + "" , BaseColor.WHITE, Element.ALIGN_LEFT));
            table.addCell(createCell(order.getProductCount() + "" , BaseColor.WHITE, Element.ALIGN_LEFT));
            table.addCell(createCell(order.getAmount() + "" , BaseColor.WHITE, Element.ALIGN_LEFT));
            if (order.getStatus() == OrderStatus.InProgress.getStatusValue()) {
                table.addCell(createCell("В процесі" , BaseColor.WHITE, Element.ALIGN_LEFT));
            } else if (order.getStatus() == OrderStatus.Finished.getStatusValue()) {
                table.addCell(createCell("Закритий" , BaseColor.WHITE, Element.ALIGN_LEFT));
            } else if (order.getStatus() == OrderStatus.Canceled.getStatusValue()) {
                table.addCell(createCell("Відмінений" , BaseColor.WHITE, Element.ALIGN_LEFT));
            }

            i++;
        }

		document.add(table);
		document.close();
    }

}