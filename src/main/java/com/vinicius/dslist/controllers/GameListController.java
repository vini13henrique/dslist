package com.vinicius.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.dslist.dto.GameDto;
import com.vinicius.dslist.dto.GameListDto;
import com.vinicius.dslist.dto.GameMinDto;
import com.vinicius.dslist.entities.Game;
import com.vinicius.dslist.services.GameListService;
import com.vinicius.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	
	
	@GetMapping
	public List<GameListDto> findAll(){
		List<GameListDto> result = gameListService.findAll();
		return result;
	}

}
