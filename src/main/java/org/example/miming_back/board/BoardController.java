package org.example.miming_back.board;

import org.example.miming_back.board.model.BoardDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board") // Vue.js 연동을 위해 엔드포인트 기본 경로 설정
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 게시글 등록 API
    @PostMapping
    public ResponseEntity<Void> register(@RequestBody BoardDto.Reg dto) {
        boardService.register(dto);
        return ResponseEntity.ok().build();
    }

    // 게시글 목록 조회 API
    @GetMapping
    public ResponseEntity<List<BoardDto.Res>> list() {
        return ResponseEntity.ok(boardService.list());
    }

    // 게시글 상세 조회 API
    @GetMapping("/{idx}")
    public ResponseEntity<BoardDto.Res> read(@PathVariable Long idx) {
        return ResponseEntity.ok(boardService.read(idx));
    }
}