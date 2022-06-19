package spring.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;

public class Program {

	public static void main(String[] args) {
		
//		Exam exam = new NewlecExam(); 
		
		// Injection
		// 1. 생성자에서 객체 주입
//		ExamConsole console = new InlineExamConsole(exam);
//		ExamConsole console = new GridExamConsole(exam);
		
		// 2. setter를 통해 객체 주입
//		ExamConsole console = new InlineExamConsole();
//		console.setExam(exam);
		
		// Exam, ExamConsole 변경시 코드 수정이 필요
			// 외부 설정 파일로 뺀다
			// 스프링에게 지시하는 방법으로 코드를 변경
			// 1. setting.xml 파일에 설정
			// 2. 파일에서 읽어와서 객체를 생성
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring/di/setting.xml"); // xml 파일을 사용하는 경우 (ClassPathXmlApplicationContext, FileSystemXmlApplication, XmlWebApplicationContext)
		ApplicationContext context = new AnnotationConfigApplicationContext(NewlecDIConfig.class);// Annotation을 가진 자바파일을 사용하는 경우
		
		// 이름으로 꺼내서 사용하는 방법
			// Object형식으로 꺼내지므로 캐스팅 필요
//		ExamConsole console = (ExamConsole)context.getBean("console");
		
		// 자료형명으로 꺼내기
			// 해당 자료형으로 꺼내지므로 캐스팅 불필요
//		Exam exam = context.getBean(Exam.class);
//		System.out.println(exam);
		
		
		ExamConsole console = (ExamConsole)context.getBean("console");
//		ExamConsole console = context.getBean(ExamConsole.class);
		console.print();
		
		
		// ---------------------------------------------------------
		
		
		// 컬렉션 생성
//		List<Exam> exams = (List<Exam>)context.getBean("exams");
////		exams.add(new NewlecExam(1, 1, 1, 1));
//		
//		for(Exam e:exams) {
//			System.out.println(e);
//		}
	}

}
