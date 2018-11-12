package com.roilka.test.design.factory.staticfactory;

import com.roilka.test.design.factory.MailSender;
import com.roilka.test.design.factory.Sender;

public class SendMailFactory implements Provider {

	@Override
	public Sender produce() {
		return new MailSender();
	}

}
