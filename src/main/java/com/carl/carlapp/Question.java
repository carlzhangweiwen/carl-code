package com.carl.carlapp;

import java.lang.reflect.Field;

public class Question {
	public static void main(String[] args) throws Exception {
		String str = "bbc";
		Field field = str.getClass().getDeclaredField("value");
		field.setAccessible(true);
		char[] value = (char[])field.get(str);
		value[1]= '2';
		System.out.println(str);
		
		final int[] a ={1,2,3};
		a[1]=22;
		for(int r : a){
			System.out.print("["+r+"]");
		}
	}
}
