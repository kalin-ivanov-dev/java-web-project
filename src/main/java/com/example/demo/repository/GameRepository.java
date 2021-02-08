package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game,Long>{
	@Query("SELECT g FROM Game g WHERE CONCAT(g.gameName,' ', g.gameDeveloper,' ',g.gamePublisher) LIKE %?1%")
	List<Game> search(String keyword);
	
}

