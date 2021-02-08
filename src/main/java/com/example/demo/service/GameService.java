package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Game;

public interface GameService {

	List<Game> getAllGames();
	List<Game> getAllGamesByName(String keyword);
	void saveGame(Game game);
	Game getGameById(long id);
	void deleteGameById(long id);

}
