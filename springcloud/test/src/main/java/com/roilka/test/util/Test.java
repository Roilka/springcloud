package com.roilka.test.util;

public class Test {

	public static void main(String[] args) {
		boolean flag = !(String.valueOf(null)+"" == null || "".equals(String.valueOf(null)));
		System.out.println(flag);
	}
}
