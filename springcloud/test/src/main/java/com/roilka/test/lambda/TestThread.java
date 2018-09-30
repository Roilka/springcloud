package com.roilka.test.lambda;

public class TestThread {

	public static void main(String[] args) {
		new Thread(() -> syso("怎么会爱上了她")).start();
	}
    private static  void syso(Object obj) {
		System.out.println(obj);
	}
}

