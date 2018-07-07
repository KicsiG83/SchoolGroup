package Document;

import java.io.FileOutputStream;
import java.time.LocalTime;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class CreateDocument {

	public static final String FONT = "resources/Times New Roman.ttf";

	public void createPDF(String documentum) {
		LocalTime now = LocalTime.now();
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(
					"d:/Contract_" + now.getHour() + now.getMinute() + now.getSecond() + now.getNano() + ".pdf"));
			document.open();
			document.add(new Paragraph(documentum, new Font(BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 12)));
			document.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("itext PDF program executed");
	}
}
