package baekhwa.service;

import java.util.List;
import java.util.Vector;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baekhwa.domain.dto.ReplyDto;
import baekhwa.domain.dto.ReplyResponseDto;
import baekhwa.domain.entity.Reply;
import baekhwa.domain.entity.ReplyRepository;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	private ReplyRepository repository;

	@Override
	public void reg(ReplyDto dto) {
		repository.save(dto.toEntity());
		
	}

	@Override
	public List<ReplyResponseDto> findAllByB_no(long bno) {
		List<Reply> result = repository.findAllByBNo(bno);
		
		List<ReplyResponseDto> list=new Vector<>();
		for(Reply reply:result) {
			ReplyResponseDto dto = new ReplyResponseDto(reply);
			list.add(dto);
		}
		
		return list;
	}

	@Override
	public void delete(long rno) {
		repository.deleteById(rno);
		
	}

	@Transactional
	@Override
	public void update(long rno, String content) {
		//먼저 글이 존재하는 지 확인..
		Reply result = repository.findById(rno)
				.map(e->e.update(content))
				.orElse(null);
		
	}

}
