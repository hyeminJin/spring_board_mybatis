package edu.bit.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.bit.board.board.vo.BoardVO;
import edu.bit.board.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	BoardMapper boardMapper;
	
	//비지니스로직  게시판List를 출력하는 로직
	public List<BoardVO> selectBoardList(){
		return boardMapper.selectBoardList();
	}
	
	//게시판에서 리플을 쓰는 로직
	public void writeReply(BoardVO boardVO) {
		boardMapper.updateShape(boardVO);
		boardMapper.insertReply(boardVO);
	}

	public BoardVO boardReplyView(int bId) {
		
		return boardMapper.selectBoardOne(bId);
	}

	public BoardVO selectBoardOne(int bId) {
		boardMapper.updateHit(bId);
		return boardMapper.selectBoardOne(bId);
	}

	public void insertBoard(BoardVO boardVO) {
	
		boardMapper.insertBoard(boardVO);
	}

	public void deleteBoard(int bId) {
		boardMapper.deleteBoard(bId);
		
	}

	public void updateBoard(BoardVO boardVO) {
		boardMapper.updateBoard(boardVO);
		
	}
}
