package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

@Controller
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/dataTransform.do")
	@ResponseBody
	public List<BoardVO> dataTransform(BoardVO vo){
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		return boardList;
	}
	
	// �� ���
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		// ���� ���ε� ó��
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/Users/82109/Desktop/uploadFile/"+fileName));
		}
		boardService.insertBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	// �� ����
	@RequestMapping(value="/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		System.out.println("��ȣ : "+vo.getSeq());
		System.out.println("���� : "+vo.getTitle());
		System.out.println("�ۼ��� : "+vo.getWriter());
		System.out.println("���� : "+vo.getContent());
		System.out.println("����� : "+vo.getRegDate());
		System.out.println("��ȸ�� : "+vo.getCnt());
		boardService.updateBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	// �� ����
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	
	// �� �� ��ȸ
	@RequestMapping(value="/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		BoardVO board = boardService.getBoard(vo);
		model.addAttribute("board",board);
		return "getBoard.jsp";
	}
	
	@ModelAttribute("conditionMap")
	public Map<String,String> searchConditionMap(){
		Map<String,String> conditionMap = new HashMap<String,String>();
		conditionMap.put("����", "TITLE");
		conditionMap.put("����", "CONTENT");
		return conditionMap;
	}
	
	
	// �� ����Ʈ
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {
		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		model.addAttribute("boardList",boardList);
		return "getBoardList.jsp";
	}

	
	
}
