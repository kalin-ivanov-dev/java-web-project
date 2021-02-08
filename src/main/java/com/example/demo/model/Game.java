package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "games")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name ="game_name")
	private String gameName;
	
	@Column(name ="game_developer")
	private String gameDeveloper;
	
	@Column(name ="game_publisher")
	private String gamePublisher;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getGameDeveloper() {
		return gameDeveloper;
	}
	public void setGameDeveloper(String gameDeveloper) {
		this.gameDeveloper = gameDeveloper;
	}
	public String getGamePublisher() {
		return gamePublisher;
	}
	public void setGamePublisher(String gamePublisher) {
		this.gamePublisher = gamePublisher;
	}
	
	
}
