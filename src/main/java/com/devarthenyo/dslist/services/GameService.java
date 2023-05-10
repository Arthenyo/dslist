package com.devarthenyo.dslist.services;

import com.devarthenyo.dslist.DTO.GameDTO;
import com.devarthenyo.dslist.DTO.GameMinDTO;
import com.devarthenyo.dslist.entities.Game;
import com.devarthenyo.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        var result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }
    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId){
        var result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
