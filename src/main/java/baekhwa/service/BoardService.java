package baekhwa.service;

import java.util.List;

import baekhwa.domain.dto.BoardDto;

public interface BoardService {

	void insert(BoardDto dto);

	List<BoardDto> list(BoardDto dto);

	BoardDto detail(int no);

	void update(BoardDto dto);

	void delete(int no);



}
