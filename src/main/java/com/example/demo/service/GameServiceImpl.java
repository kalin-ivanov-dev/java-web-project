package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Game;
import com.example.demo.repository.GameRepository;


@Service
@Transactional
public class GameServiceImpl implements GameService{

	@Autowired
	private GameRepository gameRepository;
	
	@Override
	public List<Game> getAllGames() {
		return gameRepository.findAll();
	}

	@Override
	public void saveGame(Game game) {
		this.gameRepository.save(game);
		
	}

	@Override
	public Game getGameById(long id) {
		Optional<Game> optional = this.gameRepository.findById(id);
		Game game = null;
		if(optional.isPresent())
		{
			game = optional.get();
		}else
		{
			throw new RuntimeException("Game not found for id :: " + id);
		}
		return game;
	}

	@Override
	public void deleteGameById(long id) {
		this.gameRepository.deleteById(id);
		
	}

	@Override
	public List<Game> getAllGamesByName(String keyword) {
		
		return gameRepository.search(keyword);
	}

	
	


}
