package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.demo.model.Game;
import com.example.demo.service.GameService;

@Controller
public class GameController {

	@Autowired
	private GameService gameService;
	
	@GetMapping("/")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listGames",gameService.getAllGames());
		return "index";
	}
	
	@GetMapping("/showNewGameForm")
	public String showNewGameForm(Model model)
	{
		Game game = new Game();
		model.addAttribute("game"  , game);
		return "new_game";
	}
	
	@PostMapping("/saveGame")
	public String saveGame(@ModelAttribute("game") Game game)
	{
		gameService.saveGame(game);
		return "redirect:/";
	}
	
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") long id,Model model)
	{
		Game game = gameService.getGameById(id);
		model.addAttribute("game",game);
		return "update_game";
	}
	
	@GetMapping("/deleteGame/{id}")
	public String   deleteGame(@PathVariable (value = "id") long id,Model model)
	{
		gameService.getGameById(id);
		this.gameService.deleteGameById(id);
		return "redirect:/";
	}
	
	@GetMapping("/search")
	public String search(@Param("keyword") String keyword,Model model)
	{
		List<Game> listGame = gameService.getAllGamesByName(keyword);
		model.addAttribute("listGames",listGame);
		model.addAttribute("keywprd",keyword);
		return "index";
	}
}
