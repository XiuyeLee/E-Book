package com.xiuye.util;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * spring 工具类
 * 
 * @author xiuye
 *
 */
public class SpringUtil {
	
	private static AbstractApplicationContext ac = null;
	/**
	 * 必须的配置文件，供spring类使用
	 * 
	 */
	static{
		String  []configs = {"applicationContext.xml"};
		ac = new ClassPathXmlApplicationContext(configs);
	}
	/**
	 * 根据mapper的接口名和mapper的class
	 * 获取mapper接口的实例对象
	 * 
	 * @param mapperName
	 * @param clazz
	 * @return
	 */
	public static<DAO> DAO getDao(String mapperName,Class<DAO> clazz){
		
		return ac.getBean(mapperName, clazz);
		
	}
	/**
	 * 由mapper的名字获取实例对象
	 * @param mapperName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static<DAO> DAO getDao(String mapperName){
	
		return (DAO) ac.getBean(mapperName);
		
	}
	/**
	 * 由mapper的class获取实例对象
	 * 
	 * @param clazz
	 * @return
	 */
	public static<DAO> DAO getDao(Class<DAO> clazz){
		
		return ac.getBean(clazz);
	}
	/**
	 * 关闭spring类
	 * 
	 */
	public static void close(){
		ac.close();
	}
	/**
	 * 
	 * 根据task类的名字和构造方法的参数获取task的实例对象
	 * 
	 * @param name
	 * @param args
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static<TASK> TASK getTask(String name,Object...args){
	
		return (TASK) ac.getBean(name, args);
		
	}
	/**
	 * 由任何拥有无参构造函数的java类的class属性获取实例对象
	 * @param clazz
	 * @return
	 */
	public static<Bean> Bean getBean(Class<Bean> clazz){
		return ac.getBean(clazz);
	}
}
