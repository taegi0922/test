package org.spring.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.domain.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTests {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testAllBoard() {
		log.info(boardMapper.selectAll());
	}
	
	@Test
	public void testSelect() {
		// bno가 7인 글을 조회
		BoardDTO dto = boardMapper.select(7);
		log.info(dto);
	}
	
	@Test
	public void testUpdate() {
		// bno가 7인 글을 수정테스트
		BoardDTO board = new BoardDTO(7,"수정한제목","수정한 글내용");
		boardMapper.update(board);
	}
	
	@Test
	public void testInsert() {
		// bno가  글을 등록테스트
		BoardDTO board = new BoardDTO("새로등록한제목","새로등록한 글내용","뉴비");
		boardMapper.insert(board);
	}
	
	@Test
	public void testDelete() {
		// bno가  글을 삭제테스트
		int count = boardMapper.delete(12);
		log.info("삭제된 행의 갯수:"+count);
	}
	
	@Test
	public void testInSertBno() {
		BoardDTO board = new BoardDTO("새로등록한제목","새로등록한 글내용","뉴비");
		boardMapper.insertSelectBno(board);
		log.info("새로등록한 글 번호"+board);
	}
	
}
