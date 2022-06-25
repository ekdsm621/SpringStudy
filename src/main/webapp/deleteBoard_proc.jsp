<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@ page import="com.springbook.biz.board.BoardVO" %>

<%
	String seq = request.getParameter("seq");
	BoardVO vo = new BoardVO();
	BoardDAO dao = new BoardDAO();
	
	vo.setSeq(Integer.parseInt(seq));
	dao.deleteBoard(vo);
	
	response.sendRedirect("getBoardList.jsp");
%>