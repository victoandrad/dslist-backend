package com.victoandrad.dslist.controllers;

import com.victoandrad.dslist.dtos.GameListDTO;
import com.victoandrad.dslist.dtos.GameMinDTO;
import com.victoandrad.dslist.services.GameListService;
import com.victoandrad.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    private final GameService gameService;
    private final GameListService gameListService;

    @Autowired
    public GameListController(GameService gameService,
                              GameListService gameListService) {
        this.gameService = gameService;
        this.gameListService = gameListService;
    }

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll() {
        List<GameListDTO> games = gameListService.findAll();
        return ResponseEntity.ok().body(games);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameListDTO> findById(@PathVariable Long id) throws Exception {
        GameListDTO game = gameListService.findById(id);
        return ResponseEntity.ok().body(game);
    }

    @GetMapping(value = "/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable Long listId) {
        List<GameMinDTO> games = gameService.findByList(listId);
        return ResponseEntity.ok().body(games);
    }
}
