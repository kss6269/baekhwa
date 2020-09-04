package baekhwa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baekhwa.domain.dto.JpaBoardRequestDto;
import baekhwa.domain.entity.JpaBoardRepository;

@Service
public class JpaBoardServiceImpl implements JpaBoardService{
	
	@Autowired
	private JpaBoardRepository repository;
	
	@Override
	public void save(JpaBoardRequestDto dto) {
		repository.save(dto.toEntity());
	}

}
