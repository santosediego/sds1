package com.santosediego.dspesquisa.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santosediego.dspesquisa.dto.RecordDTO;
import com.santosediego.dspesquisa.dto.RecordInsertDTO;
import com.santosediego.dspesquisa.entities.Game;
import com.santosediego.dspesquisa.entities.Record;
import com.santosediego.dspesquisa.repositories.GameRepository;
import com.santosediego.dspesquisa.repositories.RecordRepository;

@Service // Aqui também pode o @Component
public class RecordService {

	@Autowired
	private RecordRepository repository;

	@Autowired
	private GameRepository gameRepository;

	@Transactional
	public RecordDTO insert(RecordInsertDTO dto) {
		Record entity = new Record();
		entity.setName(dto.getName());
		entity.setAge(dto.getAge());
		entity.setMoment(Instant.now());

		/*
		 * getOne vai instaciar um objeto necessário porém ele só vai buscar no banco quando
		 * for solicitado gravar oregistro
		 */
		Game game = gameRepository.getOne(dto.getGameId());
		entity.setGame(game);
		
		entity = repository.save(entity);
		return new RecordDTO(entity);
	}
}