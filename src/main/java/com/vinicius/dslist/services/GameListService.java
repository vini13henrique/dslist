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
import com.vinicius.dslist.projections.GameMinProjection;
import com.vinicius.dslist.repository.GameListRepository;
import com.vinicius.dslist.repository.GameRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository;

	@Autowired
	private GameRepository gameRepositoy;

	@Transactional(readOnly = true)
	public List<GameListDto> findAll() {
		List<GameList> result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDto(x)).toList();
	}

	@Transactional
	public void move(Long listId, int sourceIndex, int destinastionIndex) {
		List<GameMinProjection> list = gameRepositoy.searchByList(listId);

		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinastionIndex, obj);

		int min = sourceIndex < destinastionIndex ? sourceIndex : destinastionIndex;
		int max = sourceIndex < destinastionIndex ? destinastionIndex : sourceIndex;

		for (int i = min; i <= max; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}

}
