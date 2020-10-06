package baekhwa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import baekhwa.domain.dto.BoardDto;

@Mapper
public interface BoardMapper {


	void insert(BoardDto dto);

	List<BoardDto> select(BoardDto dto);

	BoardDto selectByid(int no);

	void update(BoardDto dto);

	void delete(int no);




}
