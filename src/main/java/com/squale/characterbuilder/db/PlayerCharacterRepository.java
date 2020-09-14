package com.squale.characterbuilder.db;

import com.squale.characterbuilder.model.Item;
import com.squale.characterbuilder.model.PlayerCharacter;
import java.util.List;
import java.util.UUID;

/**
 * Abstraction for a repository that does database operations on a character
 * @author Squale
 */
public interface PlayerCharacterRepository {
    void insertCharacter(PlayerCharacter character);
    
    void addItemToCharacter(UUID id, Item item);
    
    PlayerCharacter getCharacter(UUID id);
    
    List<PlayerCharacter> getCharacters();
    
    String getRandomLootableItem();
}
