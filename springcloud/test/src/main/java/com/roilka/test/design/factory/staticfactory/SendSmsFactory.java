package com.roilka.test.design.factory.staticfactory;

import com.roilka.test.design.factory.Sender;
import com.roilka.test.design.factory.SmsSender;

public class SendSmsFactory implements Provider {

	@Override
	public Sender produce() {
		return new SmsSender();
	}

}
