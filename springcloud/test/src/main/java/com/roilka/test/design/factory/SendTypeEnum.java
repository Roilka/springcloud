package com.roilka.test.design.factory;

public enum SendTypeEnum {

	SMS("sms"),
	MAIL("mail");
	SendTypeEnum(String desc){
		this.desc = desc;
	}

	private String desc;

	public String getDesc() {
		return desc;
	}

}
