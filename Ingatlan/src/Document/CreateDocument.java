package Document;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.time.LocalDateTime;

public class CreateDocument {

	public static final String FONT = "Times New Roman.ttf";

//	LocalDateTime now = LocalDateTime.now();
//	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//	String formatDateTime = now.format(formatter);
//	String seller = "Kiss Géza";
//	String buyer = "Nagy Piroska";
//	String city = "Budapest";
//	String street = "Teszt utca 5";
//	int size = 70;
//	int price = 30;
//	String date = formatDateTime.toString();
//	String advance = "10%";
//	int caution = 2;
//	new CreateDocument(DocumentTemplate.SALE, seller, buyer, city, street, size, price, date, advance, now);
//	new CreateDocument(DocumentTemplate.RENTAL, seller, buyer, date, city, street, size, price, caution, date, now);
	
	
	
	public CreateDocument(String documentum, String seller, String buyer, String city, String street, int size,
			int price, String date, String advance, LocalDateTime now) {
		documentum = String.format(documentum, seller, buyer, city, street, size, price, date, advance);
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
		System.out.println("itext PDF program executed");
	}

	public CreateDocument(String documentum, String owner, String charterer, String date, String city, String street,
			int size, int price , int caution, String cause, LocalDateTime now) {
		documentum = String.format(documentum, owner, charterer, date, city, street, size, price, caution, cause);
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
		System.out.println("itext PDF program executed");
	}
}
