package org.spring.controller;

import org.spring.domain.BoardDTO;
import org.spring.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@RequiredArgsConstructor
@Log4j
public class BoardController {
	
	private final BoardService boardService;
	
	//전체 게시글 목록
	// void -> list.jsp 이동
	@GetMapping("/list")
	public void listAll(Model model){
		model.addAttribute("list",boardService.listAll());
		log.info("잘들어갔니?");
	}
	
	// void -> register.jsp로 이동 
	@GetMapping("/register")
	public void registerGet(){
		log.info("register get>>>>>");
	}
	
	// 실제러 글을 등록하는 비지니스 로직 
	@PostMapping("/register")
	public String register(BoardDTO board,RedirectAttributes rttr) {
		log.info("register>>>>>");
		Integer bno = boardService.registerKey(board);
		rttr.addAttribute("result", bno);
		//url이 바뀌어야함 
		return "redirect:/board/list";
	}
	
	// 글 상세보기 ,수정  화면으로 이동
	// void -> get.jsp로 이동 
		@GetMapping({"/get" , "/modify"})
		public void read(@RequestParam("bno") Integer bno,Model model){
		log.info("read>>>>>");
		model.addAttribute("dto", boardService.get(bno));
	}
	
	// 실제로 글을 수정하는 비지니스 로직 
	@PostMapping("/modify")
	public String modify(BoardDTO board, RedirectAttributes rttr) {
		log.info("modify>>>>>");
		int row = boardService.modify(board);
		if(row ==1) {
			rttr.addAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(int bno,RedirectAttributes rttr) {
		log.info("remove>>>>>");
		int row = boardService.remove(bno);
		if(row ==1) {
			rttr.addAttribute("result","success");
		}
		return "redirect:/board/list";
	}
}
