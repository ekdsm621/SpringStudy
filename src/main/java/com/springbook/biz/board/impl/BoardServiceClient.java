package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {

		// Spring �����̳� ����
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// Spring �����̳ʿ��� boardService ��������
		BoardService boardService = (BoardService)container.getBean("boardService");
		
		// �� ��ϱ�� �׽�Ʈ
		BoardVO vo = new BoardVO();
//		vo.setSeq(0);
		vo.setTitle("�ӽ�����1234");
		vo.setWriter("ȫ�浿");
		vo.setContent("�ӽó���1234...");
		boardService.insertBoard(vo);
		
		// �� ��� �˻� ���
		List<BoardVO> boardList = boardService.getBoardList(vo);
		if(boardList == null) {
		}
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
		// �����̳� ����
		container.close();
	}

}
