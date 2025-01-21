package com.victoandrad.dslist.services;

import com.victoandrad.dslist.dtos.GameMinDTO;
import com.victoandrad.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameMinDTO> findAll() {
        return gameRepository.findAll()
                .stream()
                .map(GameMinDTO::new)
                .toList();
    }

}
