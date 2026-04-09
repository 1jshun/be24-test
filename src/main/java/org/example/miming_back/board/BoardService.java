package org.example.miming_back.board;

import org.example.miming_back.board.model.Board;
import org.example.miming_back.board.model.BoardDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public void register(BoardDto.Reg dto) {
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Board board = dto.toEntity(today);
        boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public List<BoardDto.Res> list() {
        return boardRepository.findAll().stream()
                .map(BoardDto.Res::from)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BoardDto.Res read(Long idx) {
        Board board = boardRepository.findById(idx)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
        return BoardDto.Res.from(board);
    }
}