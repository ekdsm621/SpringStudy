package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		SamsungTV tv = (SamsungTV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		factory.close();
	}
}
