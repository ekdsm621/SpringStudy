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
		// �����ڿ��� LogAdvice ��ü ����
//		log = new Log4jAdvice();
		// ���� LogAdvice Ŭ������ Log4jAdvice�� ����,
		// �޼��嵵 printLogging()���� ���� �ȴٸ�
		// �ϳ��ϳ� �������־���ϴ� ������ -> AOP �� ����
	}
	
	@Override
	public void insertBoard(BoardVO vo) {
		// �� �޼��帶�� ����Ǿ�� �ϹǷ�,
		// �� �޼��� ���� �־���
		// printLog() ���� �ʿ�� �ѹ��� �����ϸ�ż� ��
		// but, LogAdvice Ŭ������ �ٸ� Ŭ������ ���� -> ��� �����ؾ���
//		log.printLog();
//		log.printLogging();
//		if(vo.getSeq() == 0) {
//			throw new IllegalArgumentException("0�� ���� ����� �� �����ϴ�");
//		}
		boardDAO.insertBoard(vo); // 100�� �� ���
//		boardDAO.insertBoard(vo); // ������ ����
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
