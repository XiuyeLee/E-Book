package com.xiuye.views;

import java.io.InputStream;

import javax.annotation.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
public class FileView {

	private StreamedContent file;

	public StreamedContent getFile() {
		System.out.println(file.getName());
		return file;
	}
	 
	public FileView(){
		
		InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/");
		
		file = new DefaultStreamedContent(stream,"application/pdf","exam.pdf");
		
	}
	
	
}
