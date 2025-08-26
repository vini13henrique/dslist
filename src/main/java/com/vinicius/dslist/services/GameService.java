package com.vinicius.dslist.services;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.vinicius.dslist.dto.GameDto;
import com.vinicius.dslist.dto.GameMinDto;
import com.vinicius.dslist.entities.Game;
import com.vinicius.dslist.projections.GameMinProjection;
import com.vinicius.dslist.repository.GameRepository;

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	@Transactional(readOnly = true)
	public GameDto findById(Long id) {
		Game result = gameRepository.findById(id).get();
		return new GameDto(result);
	}
	@Transactional(readOnly = true)
	public List<GameMinDto> findAll() {
		List<Game> result = gameRepository.findAll();
		List<GameMinDto> dto = result.stream().map(x -> new GameMinDto(x)).toList();
		return dto;
	}

	@Transactional(readOnly = true)
	public List<GameMinDto> findByList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDto(x)).toList();
		 
	}
}
