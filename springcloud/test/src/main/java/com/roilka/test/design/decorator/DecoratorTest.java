package com.roilka.test.design.decorator;

import com.roilka.test.design.adapter.Source;
import com.roilka.test.design.adapter.Sourceable;

public class DecoratorTest {

	public static void main(String[] args) {
		Sourceable sourceable = new Source();
		Sourceable obj = new Decorator(sourceable);
		obj.method1();
	}
}
