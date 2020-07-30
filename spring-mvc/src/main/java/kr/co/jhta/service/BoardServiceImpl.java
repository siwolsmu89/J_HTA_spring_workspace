package kr.co.jhta.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.jhta.dao.BoardDao;
import kr.co.jhta.vo.Board;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public void addNewBoard(Board board) {
		Board savedBoard = boardDao.selectBoard(board.getNo());
		if (savedBoard != null) {
			return;
		}
		
		boardDao.insertBoard(board);
	}
	
	@Override
	public void deleteBoard(long boardNo, String password) {
		Board board = boardDao.selectBoard(boardNo);
		if (!password.equals(board.getPassword())) {
			return;
		}
		
		board.setDeleted("Y");
		board.setDeletedDate(new Date());
		boardDao.updateBoard(board);
	}
	
	@Override
	public List<Board> getAllBoards() {
		return boardDao.selectBoards();
	}
	
	@Override
	public Board getBoardDetail(long boardNo) {
		return boardDao.selectBoard(boardNo);
	}
	
	@Override
	public void increaseBoardLikes(long boardNo) {
		Board board = boardDao.selectBoard(boardNo);
		if (board == null) {
			return;
		}
		
		board.setLikes(board.getLikes() + 1);
		boardDao.updateBoard(board);
	}
	
	@Override
	public void modifyBoardDetail(Board board) {
		long boardNo = board.getNo();
		Board savedBoard = boardDao.selectBoard(boardNo);
		
		if (savedBoard == null) {
			return;
		}
		
		boardDao.updateBoard(board);
	}
}
