package com.xiuye.logger;

import java.io.Serializable;
import java.util.Date;

public class Logger {

	public static boolean CLOSEINFO = false;

	private Class clazz;

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	private Logger(Class clazz) {

		this.clazz = clazz;

	}

	public static Logger getLogger(Class clazz) {

		return new Logger(clazz);

	}

	// private static Logger getDefault(){
	// return LoggerHoler.instance;
	// }
	// private static class LoggerHoler{
	// private static final Logger instance = new Logger();
	// }
	public void info(String message) {
		if (!CLOSEINFO) {

			System.out.println("INFO:" + message + " 类对象:" + clazz
					+  " 时间:"	+ new Date());
		}
	}
}
