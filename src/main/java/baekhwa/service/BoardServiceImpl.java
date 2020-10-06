package baekhwa.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baekhwa.domain.dto.BoardDto;
import baekhwa.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper boardmapper;
	
	@Override
	public void insert(BoardDto dto) {
		boardmapper.insert(dto);
		
	}

	@Override
	public List<BoardDto> list(BoardDto dto) {
		
		return boardmapper.select(dto);
	}

	@Override
	public BoardDto detail(int no) {
		
		return boardmapper.selectByid(no);
		
	}


	@Override
	public void update(BoardDto dto) {
		boardmapper.update(dto);
		
	}

	@Override
	public void delete(int no) {
		boardmapper.delete(no);
		
	}


	

}
