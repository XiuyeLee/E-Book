package com.xiuye.util;

import java.io.BufferedOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.xiuye.logger.Logger;

public class PdfOutputCustomPagesUtil {

	private static Logger log = Logger
			.getLogger(PdfOutputCustomPagesUtil.class);

	/**
	 * split pdf for my bookstore
	 * 
	 * @param pdfFilename
	 * @param startPage
	 *            not equal 0 since 1
	 * @param os
	 */
	public static void partOfPdfOutputPages(String pdfFilename, int startPage,
			HttpServletResponse response) {
		int expectEndPage = 0;
		Document doc = null;
		PdfCopy pdfCopy = null;

		PdfReader reader = null;
		try {
			reader = new PdfReader(pdfFilename);

			/**
			 * 解决Exception in thread "main" java.lang.IllegalArgumentException:
			 * PdfReader not opened with owner password
			 * 
			 * 
			 */
			java.lang.reflect.Field f = reader.getClass().getDeclaredField(
					"encrypted");
			f.setAccessible(true);
			f.set(reader, false);//重新设置false 不encrypted(加密)

			int totalPages = reader.getNumberOfPages();
			log.info("文档总页数:" + totalPages + "页");
			if (totalPages == 0) {
				return;
			} else if (totalPages > 0 && totalPages < 10) {
				expectEndPage = totalPages;
			} else if (totalPages >= 10 && totalPages <= 50) {
				expectEndPage = totalPages / 10;
			} else {
				expectEndPage = 50;
			}
			log.info("需要传送多少页:" + expectEndPage + "页");

			doc = new Document(reader.getPageSize(1));
			BufferedOutputStream bos = new BufferedOutputStream(
					response.getOutputStream());
			pdfCopy = new PdfCopy(doc, bos);

			doc.open();
			pdfCopy.open();
			for (int i = startPage; i <= expectEndPage; i++) {

				doc.newPage();
				PdfImportedPage page = pdfCopy.getImportedPage(reader, i);
				pdfCopy.addPage(page);
				pdfCopy.flush();

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} finally {
			if (doc != null && doc.isOpen()) {

				doc.close();
				doc = null;
			}
			if (pdfCopy != null) {
				pdfCopy.close();
				pdfCopy = null;
			}
			if (reader != null) {
				reader.close();
				reader = null;
			}
		}

	}

}
