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
		// 1. �����ڿ��� ��ü ����
//		ExamConsole console = new InlineExamConsole(exam);
//		ExamConsole console = new GridExamConsole(exam);
		
		// 2. setter�� ���� ��ü ����
//		ExamConsole console = new InlineExamConsole();
//		console.setExam(exam);
		
		// Exam, ExamConsole ����� �ڵ� ������ �ʿ�
			// �ܺ� ���� ���Ϸ� ����
			// ���������� �����ϴ� ������� �ڵ带 ����
			// 1. setting.xml ���Ͽ� ����
			// 2. ���Ͽ��� �о�ͼ� ��ü�� ����
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring/di/setting.xml"); // xml ������ ����ϴ� ��� (ClassPathXmlApplicationContext, FileSystemXmlApplication, XmlWebApplicationContext)
		ApplicationContext context = new AnnotationConfigApplicationContext(NewlecDIConfig.class);// Annotation�� ���� �ڹ������� ����ϴ� ���
		
		// �̸����� ������ ����ϴ� ���
			// Object�������� �������Ƿ� ĳ���� �ʿ�
//		ExamConsole console = (ExamConsole)context.getBean("console");
		
		// �ڷ��������� ������
			// �ش� �ڷ������� �������Ƿ� ĳ���� ���ʿ�
//		Exam exam = context.getBean(Exam.class);
//		System.out.println(exam);
		
		
		ExamConsole console = (ExamConsole)context.getBean("console");
//		ExamConsole console = context.getBean(ExamConsole.class);
		console.print();
		
		
		// ---------------------------------------------------------
		
		
		// �÷��� ����
//		List<Exam> exams = (List<Exam>)context.getBean("exams");
////		exams.add(new NewlecExam(1, 1, 1, 1));
//		
//		for(Exam e:exams) {
//			System.out.println(e);
//		}
	}

}
