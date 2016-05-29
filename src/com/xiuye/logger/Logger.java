package com.xiuye.logger;

import java.util.Date;

public class Logger {

	private Class clazz;
	
	public Class getClazz() {
		return clazz;
	}


	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}


	private Logger(){
	
		
		
		
	}
	
	
	public static Logger getLogger(Class clazz){
		
		Logger log = new Logger();
		log.setClazz(clazz);
		
		return log;
		
		
	}
	
//	private static Logger getDefault(){
//		return LoggerHoler.instance;
//	}
//	private static class LoggerHoler{
//		private static final Logger instance = new Logger();
//	}
	public void info(String message){
		
		System.out.println("INFO: 时间:"+new Date(System.currentTimeMillis())+" 类对象:"+clazz+" 内容:"+message);
		
	}
}
