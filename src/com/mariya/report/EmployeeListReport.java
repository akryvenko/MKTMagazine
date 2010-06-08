package com.mariya.report;

import com.itextpdf.text.*;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mariya.entity.Employer;
import com.mariya.entity.Office;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Collection;


public class EmployeeListReport {

    private File reportFile;


    public EmployeeListReport(File filepath){
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

    public void generate(Office office,  Collection<Employer> employees) throws Exception {

        Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(reportFile));
		document.open();

        document.add(getTextParagraph("Організація: " + office.getName()));
        document.add(getTextParagraph("Телефон: " + office.getPhone()));
        document.add(getTextParagraph("Електронна пошта: " + office.getMail()));
        document.add(getTextParagraph("Адреса: " + office.getAddress()));
        document.add(new Paragraph(" "));


		float[] colsWidth = {10f, 100f, 100f, 100f}; // Code 1
		PdfPTable table = new PdfPTable(colsWidth);

		table.setWidthPercentage(100); // Code 2
		table.setHorizontalAlignment(Element.ALIGN_LEFT);//Code 3

        // header

        table.addCell(createCell("п/н", BaseColor.GRAY, Element.ALIGN_CENTER));
		table.addCell(createCell("Імя/Фамілія", BaseColor.GRAY, Element.ALIGN_CENTER));
		table.addCell(createCell("Телефон", BaseColor.GRAY, Element.ALIGN_CENTER));
		table.addCell(createCell("Поштова Адреса", BaseColor.GRAY, Element.ALIGN_CENTER));

        // data
        int i = 1;
        for (Employer employer : employees) {
            table.addCell(createCell(i + "", BaseColor.WHITE, Element.ALIGN_LEFT));
		    table.addCell(createCell(employer.getFullName(), BaseColor.WHITE, Element.ALIGN_LEFT));
		    table.addCell(createCell(employer.getPhone(), BaseColor.WHITE, Element.ALIGN_LEFT));
		    table.addCell(createCell(employer.getMail(), BaseColor.WHITE, Element.ALIGN_LEFT));
            i++;
        }

		document.add(table);
		document.close();
    }

}
