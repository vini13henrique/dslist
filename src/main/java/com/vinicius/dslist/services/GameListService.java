package com.vinicius.dslist.services;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.vinicius.dslist.dto.GameDto;
import com.vinicius.dslist.dto.GameListDto;
import com.vinicius.dslist.dto.GameMinDto;
import com.vinicius.dslist.entities.Game;
import com.vinicius.dslist.entities.GameList;
import com.vinicius.dslist.repository.GameListRepository;
import com.vinicius.dslist.repository.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;


	@Transactional(readOnly = true)
	public List<GameListDto> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDto(x)).toList();
	
	}

}
