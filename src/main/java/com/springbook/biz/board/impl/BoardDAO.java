package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.common.JDBCUtil;

//@Repository("boardDAO")
public class BoardDAO {
	// JDBC 관련 변수
	private PreparedStatement pstmt = null;
	private Connection conn = null;
	private ResultSet rs = null;
	
	private final String BOARD_INSERT="INSERT INTO BOARD(SEQ, TITLE, WRITER, CONTENT) "
									  + "VALUES((SELECT NVL(MAX(SEQ),0)+1 FROM BOARD), ?,?,?)";
	private final String BOARD_UPDATE="UPDATE BOARD SET TITLE=?, CONTENT=? WHERE SEQ=?";
	private final String BOARD_DELETE="DELETE BOARD WHERE SEQ=?";
	private final String BOARD_GET="SELECT * FROM BOARD WHERE SEQ=?";
	private final String BOARD_LIST="SELECT * FROM BOARD ORDER BY SEQ DESC";
	
	public void insertBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	public void updateBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setInt(3, vo.getSeq());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	public void deleteBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, vo.getSeq());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	public BoardVO getBoard(BoardVO vo) {
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, vo.getSeq());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn, rs);
		}
		
		return board;
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> boardList = new ArrayList<BoardVO>();;
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(BOARD_LIST);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				boardList.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn, rs);
		}
		
		return boardList;
	}
}
