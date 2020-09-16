package com.santosediego.dspesquisa.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santosediego.dspesquisa.dto.GameDTO;
import com.santosediego.dspesquisa.entities.Game;
import com.santosediego.dspesquisa.repositories.GameRepository;

@Service // Aqui também pode o @Component
public class GamesServices {

	@Autowired
	private GameRepository repository;

	@Transactional(readOnly = true)//Evitar lokin no BD;
	public List<GameDTO> findAll() {
		List<Game> list = repository.findAll();

		/*
		 * Transforma para strem/ -> Aplica a tranformação em cada elemento para DTO e
		 * colletct tranforma de volta em uma lista;
		 */
		return list.stream().map(x -> new GameDTO(x)).collect(Collectors.toList());
	}
}