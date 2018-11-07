package com.roilka.test.design.factory;

public class FactoryTest {

	public static void main(String[] args) {
		SendFactory factory = new SendFactory();
		Sender sender = factory.produce(SendTypeEnum.MAIL);
		sender.send();
	}
}
