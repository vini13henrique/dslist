package com.vinicius.dslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
