package Document;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import Property.Property;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CreateDocument {

	public static final String FONT = "Times New Roman.ttf";

	LocalDateTime now = LocalDateTime.now();

	public CreateDocument(Property property, String buyerName, String documentum, String sellerName, int index) {
		String advance = "10%";
		int caution = 2;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
		String formatDateTime = now.format(formatter);
		if (index == 1) {
			documentum = String.format(documentum, sellerName, buyerName, property.getCity(),
					property.getStreetAndNumber(), property.getSize(), property.getPrice(), formatDateTime, advance);
		} else {
			documentum = String.format(documentum, sellerName, buyerName, formatDateTime, property.getCity(),
					property.getStreetAndNumber(), property.getSize(), property.getPrice(), caution, formatDateTime);
		}
		try {
			Document document = new Document();
			Paragraph p = new Paragraph(documentum,
					new Font(BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 12));
			PdfWriter.getInstance(document, new FileOutputStream(
					"d:/Contract_" + now.getHour() + now.getMinute() + now.getSecond() + now.getNano() + ".pdf"));
			document.open();
			document.add(p);
			document.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("PDF generálás sikeres.");
	}
}
