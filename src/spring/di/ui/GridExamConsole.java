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
	// �ʵ� ���� ������̼� ����Ͽ� �����ϴ� ���, �⺻ �����ڸ� ȣ���ϹǷ�
	// �⺻ �����ڸ� �����ϸ� ���ܰ� �߻��Ѵ�
	
	public GridExamConsole() {
		System.out.println("constructor");
	}
	
	// @Qualifier("exam2") ����: �����ε��� �������� ��� exam�� �ΰ� �̻� �� �� �ִ� -> ���� �Ʒ��� ���� �Ķ���Ϳ� �������־����
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
