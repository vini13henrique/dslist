package com.vinicius.dslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
