package com.roilka.test.design.singleton;

import java.util.Vector;

public class SingletonTest {

	private static SingletonTest instance = null;
	
	private Vector properties = null;
	
	private SingletonTest(){
	}
	
	private static synchronized void syncInit() {
		if (instance == null) {
			instance = new SingletonTest();
		}
	}
	public static SingletonTest  getInstance() {
		if (instance == null) {
			syncInit();
		}
		return instance;
	}
}
