package com.victoandrad.dslist.services;

import com.victoandrad.dslist.dtos.GameListDTO;
import com.victoandrad.dslist.models.GameList;
import com.victoandrad.dslist.repositories.GameListRepository;
import com.victoandrad.dslist.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameListService {

    private final GameListRepository gameListRepository;

    @Autowired
    public GameListService(GameListRepository gameListRepository) {
        this.gameListRepository = gameListRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        return gameListRepository.findAll()
                .stream()
                .map(GameListDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) throws Exception {
        Optional<GameList> game = this.gameListRepository.findById(id);
        if (game.isPresent()) {
            return new GameListDTO(game.get());
        }
        throw new ResourceNotFoundException(id);
    }

}
