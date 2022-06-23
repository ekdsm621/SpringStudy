package com.springbook.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
@Repository
public class BoardDAOSpring{
	private final String BOARD_INSERT = "INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) "
//										+"VALUES((SELECT NVL(MAX(SEQ),0)+1 FROM BOARD),?,?,?)";
										+"VALUES(?,?,?,?)";
	private final String BOARD_UPDATE = "UPDATE BOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
	private final String BOARD_DELETE = "DELETE BOARD WHERE SEQ=?";
	private final String BOARD_GET = "SELECT * FROM BOARD WHERE SEQ=?";
	private final String BOARD_LIST = "SELECT * FROM BOARD ORDER BY SEQ DESC";
	
//	@Autowired
//	public void setSuperDataSource(DataSource dataSource) {
//		super.setDataSource(dataSource);
//	}
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		Object[] args = {vo.getSeq(), vo.getTitle(), vo.getWriter(), vo.getContent()};
		jdbcTemplate.update(BOARD_INSERT, args);
	}
	
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		Object[] args = {vo.getTitle(), vo.getContent(),vo.getSeq()};
		jdbcTemplate.update(BOARD_UPDATE, args);
	}
	
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		jdbcTemplate.update(BOARD_DELETE, vo.getSeq());
	}
	
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	public List<BoardVO> getBoardList(BoardVO vo){
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
}
