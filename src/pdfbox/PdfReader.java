package pdfbox;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfReader {
	public static void main(String[] args) {
		String path = "C:\\Users\\lenovo\\Desktop\\聘用人员行为规范.pdf";  
	     File file = new File(path);  
	     InputStream is = null;  
	     PDDocument document = null;  
	     try {  
	         if (path.endsWith(".pdf")) {  
	             document = PDDocument.load(file);  
	             document.setAllSecurityToBeRemoved(true);
	             int pageSize = document.getNumberOfPages();  
	             // 一页一页读取  
	             for (int i = 0; i < pageSize; i++) {  
	                 // 文本内容  
	                 PDFTextStripper stripper = new PDFTextStripper();  
	                 // 设置按顺序输出  
	                 stripper.setSortByPosition(true);  
	                 stripper.setStartPage(i + 1);  
	                 stripper.setEndPage(i + 1);  
	                 String text = stripper.getText(document);  
	                 System.out.println(text.trim());  
	             }  
	         }  
	         document.close();
	     } catch (InvalidPasswordException e1) {  
	     } catch (IOException e) {  
	     } finally {  
	         try {  
	             if (document != null) {  
	                 document.close();  
	             }  
	             if (is != null) {  
	                 is.close();  
	             }  
	         } catch (IOException e) {  
	         }  
	     } 
	}   
}
