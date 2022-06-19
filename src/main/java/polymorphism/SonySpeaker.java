package polymorphism;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements Speaker {
	public void volumeUp() {
		System.out.println("sony VolumeUp");
	}
}
