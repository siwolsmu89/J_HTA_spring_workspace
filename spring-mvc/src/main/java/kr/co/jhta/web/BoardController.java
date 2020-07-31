package kr.co.jhta.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.jhta.form.BoardForm;
import kr.co.jhta.service.BoardService;
import kr.co.jhta.vo.Board;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/list.do")
	public String boardList(Model model) {
		// 게시글 전체 조회
		List<Board> allBoards = boardService.getAllBoards();
		// 조회된 게시글을 Model에 담아서 View page에 전달하기
		// Model 객체는 파라미터로 지정해놓기만 하면 HandlerAdapter가 확인 후 생성해서 전달해준다.
		model.addAttribute("boards", allBoards);
		
		// 내부이동할 JSP 페이지의 경로 및 이름 반환
		return "board/list";
	}
	
	@RequestMapping("/form.do")
	public String form() {
		
		return "board/form";
	}
	
	@RequestMapping("/add.do")
	public String addBoard(BoardForm boardForm) {
		Board board = new Board();
		// BoardForm의 값들을 Board로 복사
		BeanUtils.copyProperties(boardForm, board);
		boardService.addNewBoard(board);
		
		return "redirect:list.do";
	}
	
	@RequestMapping("/likes.do")
	public String likesBoard(@RequestParam("no") long boardNo, RedirectAttributes redirectAttributes) {
		boardService.increaseBoardLikes(boardNo);
		// 리다이렉트 할 때 보내주는 경로 뒤에 붙을 요청파라미터 이름과 값 설정
		redirectAttributes.addAttribute("no", boardNo);
		
		return "redirect:detail.do";
	}
	
	@RequestMapping("/detail.do")
	public String boardDetail(@RequestParam("no") long boardNo) {
		
		return "board/detail";
	}
}
