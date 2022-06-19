package polymorphism;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker {
	@Override
	public void volumeUp() {
		System.out.println("apple VolumeUp");
	}

}
