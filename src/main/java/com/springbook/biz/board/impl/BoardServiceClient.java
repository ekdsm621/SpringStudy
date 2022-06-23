package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {

		// Spring 컨테이너 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		// Spring 컨테이너에서 boardService 가져오기
		BoardService boardService = (BoardService)container.getBean("boardService");
		
		// 글 등록기능 테스트
		BoardVO vo = new BoardVO();
//		vo.setSeq(0);
		vo.setTitle("임시제목1234");
		vo.setWriter("홍길동");
		vo.setContent("임시내용1234...");
		boardService.insertBoard(vo);
		
		// 글 목록 검색 기능
		List<BoardVO> boardList = boardService.getBoardList(vo);
		if(boardList == null) {
		}
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		
		// 컨테이너 종료
		container.close();
	}

}
