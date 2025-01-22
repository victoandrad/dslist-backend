package com.victoandrad.dslist.services;

import com.victoandrad.dslist.dtos.GameDTO;
import com.victoandrad.dslist.dtos.GameMinDTO;
import com.victoandrad.dslist.models.Game;
import com.victoandrad.dslist.repositories.GameRepository;
import com.victoandrad.dslist.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll()
                .stream()
                .map(GameMinDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) throws Exception {
        Optional<Game> game = this.gameRepository.findById(id);
        if (game.isPresent()) {
            return new GameDTO(game.get());
        }
        throw new ResourceNotFoundException(id);
    }

}
