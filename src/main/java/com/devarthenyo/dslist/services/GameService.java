package com.devarthenyo.dslist.services;

import com.devarthenyo.dslist.DTO.GameMinDTO;
import com.devarthenyo.dslist.entities.Game;
import com.devarthenyo.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        var result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}