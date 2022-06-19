package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("console")
public class GridExamConsole implements ExamConsole {
	
	@Autowired(required = false)
	@Qualifier("exam2")
	private Exam exam;
	// 필드 위에 어노테이션 사용하여 주입하는 경우, 기본 생성자를 호출하므로
	// 기본 생성자를 삭제하면 예외가 발생한다
	
	public GridExamConsole() {
		System.out.println("constructor");
	}
	
	// @Qualifier("exam2") 에러: 오버로딩된 생성자의 경우 exam이 두개 이상 들어갈 수 있다 -> 따라서 아래와 같이 파라미터에 지정해주어야함
	// public GridExamConsole(@Qualifier("exam2") Exam exam)
	public GridExamConsole(Exam exam) {
		System.out.println("overloaded constructor");
		this.exam = exam;
	}

	@Override
	public void print() {
		if(exam == null) {
			System.out.println("total  avg");
			System.out.printf("   %d    %f ",0,0.0);			
		}else {
			System.out.println("total  avg");
			System.out.printf("   %d    %f ",exam.total(),exam.avg());			
			
		}
	}
	
	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
		System.out.println("setter");
	}

}
