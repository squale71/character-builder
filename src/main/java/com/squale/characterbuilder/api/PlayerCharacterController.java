package com.squale.characterbuilder.api;

import com.squale.characterbuilder.api.dtos.PlayerCharacterDTO;
import com.squale.characterbuilder.api.requestmodels.PlayerCharacterRequestModel;
import com.squale.characterbuilder.service.PlayerCharacterService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * API related to interacting with characters
 * @author Squale
 */
@RequestMapping("api/character")
@RestController
public class PlayerCharacterController {
    private final PlayerCharacterService playerCharacterService;

    @Autowired
    public PlayerCharacterController(PlayerCharacterService playerCharacterService) {
        this.playerCharacterService = playerCharacterService;
    }
    
    @GetMapping
    public PlayerCharacterDTO getCharacter(@RequestParam UUID id) {   
        PlayerCharacterDTO result =  playerCharacterService.getCharacter(id);
        
        if (result == null) {
            throw new ResponseStatusException(NOT_FOUND, "Unable to find character");
        }
        
        return result;
    }
    @GetMapping("collection")
    public List<PlayerCharacterDTO> getCharacters()
    {
        return playerCharacterService.getCharacters();
    }
    
    @PostMapping
    public void addCharacter(@RequestBody PlayerCharacterRequestModel character) {
        playerCharacterService.addCharacter(character);
    }
    
    @PostMapping("item")
    public void addRandomLootToCharacter(@RequestBody UUID id) {
        playerCharacterService.findRandomLoot(id);
    }
}
