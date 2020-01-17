package edu.bit.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.bit.board.board.vo.BoardVO;
import edu.bit.board.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService; 
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
	
		model.addAttribute("list", boardService.selectBoardList());
		
		return "list";
	}
	@RequestMapping("/write_view")
	public String write_view() {
		System.out.println("write_view");

		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(BoardVO boardVO , Model model) throws Exception {
		System.out.println("write()");
		
		boardService.insertBoard(boardVO);

		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(BoardVO boardVO , Model model) throws Exception {
		System.out.println("content_view()");
	
		model.addAttribute("content_view", boardService.selectBoardOne(boardVO.getbId()));
	
		return "content_view";
	}
	
	@RequestMapping("/delete")
	public String delete(BoardVO boardVO , Model model) throws Exception {
		System.out.println("delete()");

		boardService.deleteBoard(boardVO.getbId());
		
	
		return "redirect:list";
	}
	
	@RequestMapping("/modify")
	public String modify(BoardVO boardVO , Model model) throws Exception {
		System.out.println("modify()");

		boardService.updateBoard(boardVO);
		
	
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(BoardVO boardVO , Model model) throws Exception {
		System.out.println("reply_view()");

		 
		model.addAttribute("reply_view", boardService.boardReplyView(boardVO.getbId()));
	
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(BoardVO boardVO , Model model) throws Exception {
		System.out.println("reply()");

		boardService.writeReply(boardVO);
	

		return "redirect:list";
	}


}
