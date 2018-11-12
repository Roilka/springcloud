package com.roilka.test.design.factory.staticfactory;

import com.roilka.test.design.factory.Sender;

public class ProvideTest {

	public static void main(String[] args) {
		Provider provider = new SendSmsFactory();
		Sender sender = provider.produce();
		sender.send();
	}
}
