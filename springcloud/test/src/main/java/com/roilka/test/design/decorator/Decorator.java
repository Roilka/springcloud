package com.roilka.test.design.decorator;

import com.roilka.test.design.adapter.Sourceable;

public class Decorator implements Sourceable {

	private Sourceable sourceable;
	
	public Decorator(Sourceable sourceable) {
		super();
		this.sourceable = sourceable;
	}
	@Override
	public void method1() {
        System.out.println("before decorator!"); 
        sourceable.method1();
        System.out.println("after decorator!"); 
	}

	@Override
	public void method2() {
		// 这里需要个解释 Auto-generated method stub

	}

}
