package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository ;
	

//	public List<Game> findAll() {
//		List<Game> result =  gameRepository.findAll();
//		return result;
//	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		return new GameDTO(result);		
	}
	
	public List<GameMinDTO> findAll() {
		List<Game> result =  gameRepository.findAll();
		return result.stream().map(g -> new GameMinDTO(g)).toList();		
	}
	

}
