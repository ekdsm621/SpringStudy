package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.Log4jAdvice;
import com.springbook.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAOSpring boardDAO;
//	private LogAdvice log;
//	private Log4jAdvice log;
	public BoardServiceImpl() {
		// 생성자에서 LogAdvice 객체 생성
//		log = new Log4jAdvice();
		// 만약 LogAdvice 클래스가 Log4jAdvice로 변경,
		// 메서드도 printLogging()으로 변경 된다면
		// 하나하나 변경해주어야하는 불편함 -> AOP 로 수정
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		// 각 메서드마다 수행되어야 하므로,
		// 각 메서드 위에 넣어줌
		// printLog() 수정 필요시 한번만 수정하면돼서 편리
		// but, LogAdvice 클래스를 다른 클래스로 변경 -> 모두 수정해야함
//		log.printLog();
//		log.printLogging();
//		if(vo.getSeq() == 0) {
//			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다");
//		}
		boardDAO.insertBoard(vo); // 100번 글 등록
//		boardDAO.insertBoard(vo); // 고의적 에러
	}

	@Override
	public void updateBoard(BoardVO vo) {
//		log.printLog();
//		log.printLogging();
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
//		log.printLog();
//		log.printLogging();
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
//		log.printLog();
//		log.printLogging();
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
//		log.printLog();
//		log.printLogging();
		return boardDAO.getBoardList(vo);
	}

	
}
