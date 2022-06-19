package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV {
	@Autowired
	@Qualifier("sony")
	Speaker speaker;
	int price;

	public SamsungTV() {
	}

	public SamsungTV(Speaker speaker) {
		this.speaker = speaker;
	}

	public void initMethod() {

	}

	public void destroyMethod() {

	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void powerOn() {
		System.out.println("powerOn");
	}
	
	public void volumeUp() {
		speaker.volumeUp();
	}

}
