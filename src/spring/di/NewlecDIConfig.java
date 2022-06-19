package spring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;

@ComponentScan("spring.di") // 어노테이션을 스캔해서 객체를 만들겠다 -> 여러 패키지를 스캔할 경우({"",""})
@Configuration // 설정을 위한 파일임을 나타냄
public class NewlecDIConfig {
	
	@Bean // 객체를 만들어서 컨테이너에 넣겠다
	public Exam exam() { // exam: 컨테이너 안에 객체를 넣을 때 그 객체의 이름
		return new NewlecExam();
	}
	
}
