package com.xiuye.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLcodingTest {

	public static void main(String[] args) throws UnsupportedEncodingException {

//		GIMV Cover:编码前:F:\\ComputerScience_and_TechnologyDocument\\Cover\\Cpp11.PNG
//		GIMV Cover:编码后:F%3A%5CComputerScience_and_TechnologyDocument%5CCover%5CCpp11.
//		PNG
//		GIMV Cover:编码前:F:\\ComputerScience_and_TechnologyDocument\\Cover\\Unity.3D游戏开
//		发.png
			
		System.out.println(URLEncoder.encode("F:\\ComputerScience_and_TechnologyDocument\\Cover\\Unity.3D游戏开发.png","GBK"));
		System.out.println(URLEncoder.encode("F:\\ComputerScience_and_TechnologyDocument\\Cover\\Unity.3D游戏开发.png","UTF-8"));
		
//		GIMV Cover:编码前:F:\\ComputerScience_and_TechnologyDocument\\Cover\\Unity.3D游戏开发.png
//		GIMV Cover:编码后:F%3A%5CComputerScience_and_TechnologyDocument%5CCover%5CUnity.3D%D3%CE%CF%B7%BF%AA%B7%A2.png
//		GIMV Cover:编码后:F%3A%5CComputerScience_and_TechnologyDocument%5CCover%5CUnity.3D%E6%B8%B8%E6%88%8F%E5%BC%80%E5%8F%91.png
		String s = null;
		try {
			s = URLEncoder.encode("大法师的法师打发斯蒂芬","UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		System.out.println(s);
		try {
			s = new String(s.getBytes("ISO-8859-1"),"UTF-8");
			System.out.println(s);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		try {
			s = URLDecoder.decode(s,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(s);
		
		try {
			System.out.println(URLDecoder.decode("GIMV Cover:编码后:F%3A%5CComputerScience_and_TechnologyDocument%5CCover%5CGNU_makefile%D6%D0%CE%C4%CA%D6%B2%E1.jpg","GBK"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(System.getProperty("file.encoding"));
		
	}

}
