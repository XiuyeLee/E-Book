package com.xiuye.test;

public class Period {

	public static void main(String[] args) {

		String str = "eewr。认为。二位二位。娃儿wer。erwer";
	
		String []s = str.split("。");
		for(String d : s){
			System.out.println(d);
		}
		System.out.println(s);
		
	}

}
