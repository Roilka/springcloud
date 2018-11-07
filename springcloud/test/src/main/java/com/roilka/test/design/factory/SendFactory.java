package com.roilka.test.design.factory;

/**
 * 
* 类名: SendFactory.java
* 包名 : com.roilka.test.design.factory
* 详细描述: 这里需要个解释(用一句话描述该文件做什么)
* 开发人员： zhanghui1
* 开发日期：2018年11月7日 上午11:44:53
*
 */
public class SendFactory {

	public Sender produce(SendTypeEnum type) {
		
		if (SendTypeEnum.MAIL.equals(type)) {
			return new MailSender();
		}else if (SendTypeEnum.SMS.equals(type)) {
			return new SmsSender();
		}else {
			System.out.println("请输入正确的类型!");  
            return null; 
		}
		
	}
	public static Sender produceMail(){  
        return new MailSender();  
    }  
      
    public static Sender produceSms(){  
        return new SmsSender();  
    }  
}
