package com.xiuye.util;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.servlet.http.HttpServletResponse;
import com.sun.image.codec.jpeg.*;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;

public class PdfToImageUtil {

	public static void outPutCover(String path,HttpServletResponse response){
		BufferedInputStream bis = null;
		try {
			FileInputStream fis = new FileInputStream(path);
			
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			FileChannel fc = fis.getChannel();
					
			ByteBuffer buffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
			
			PDFFile pdfFile = new PDFFile(buffer);
			
			if(pdfFile.getNumPages()<1)
			{
				bis = new BufferedInputStream(new FileInputStream("F:/ComputerScience_and_TechnologyDocument/Cover/book.png"));
				int length = bis.available();
				response.setContentLength(length);
				

				byte[] data = new byte[1024];

				while (bis.read(data) > -1) {

					bos.write(data);
					bos.flush();

				}
			}
			else{
				PDFPage page = pdfFile.getPage(1);
				
				Rectangle rect = new Rectangle(0, 0,(int)page.getBBox().getWidth(),(int)page.getBBox().getHeight());
				
				Image img = page.getImage(rect.width,rect.height, rect, null);
				
				img = img.getScaledInstance(160, 210, Image.SCALE_DEFAULT);
				
				BufferedImage bi = new BufferedImage(160, 210, BufferedImage.TYPE_INT_RGB);
				
				bi.getGraphics().drawImage(img, 0, 0, null);
				
				
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(response.getOutputStream());
				encoder.encode(bi);
				
				
			}
			
			
			return;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (bis != null)
			try {
				bis.close();
			} catch (IOException e) {
			}
		try {
			bis = new BufferedInputStream(new FileInputStream("F:/ComputerScience_and_TechnologyDocument/Cover/book.png"));
			int length = bis.available();
			response.setContentLength(length);
			BufferedOutputStream bos = new BufferedOutputStream(
					response.getOutputStream());

			byte[] data = new byte[1024];

			while (bis.read(data) > -1) {

				bos.write(data);
				bos.flush();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null)
				try {
					bis.close();
				} catch (IOException e) {
				}

		}
		
	}
	
}
