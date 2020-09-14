package com.squale.characterbuilder.db;

import com.squale.characterbuilder.model.Item;
import com.squale.characterbuilder.model.PlayerCharacter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.springframework.stereotype.Repository;

/**
 * In memory database for persisting player characters.
 * @author Squale
 */
@Repository("inMemoryRepository")
public class InMemoryPlayerCharacterRepository implements PlayerCharacterRepository {

    private static List<PlayerCharacter> DB = new ArrayList<>();
    
    // Small in memory collection of possible item names to loot.
    private static ArrayList<String> LOOTABLE_ITEMS = new ArrayList<String>(Arrays.asList("Leather Armor", "Chainmail Armor", "Steel Armor", "Feathered Hat"));
            
    @Override
    public void insertCharacter(PlayerCharacter character) {
        DB.add(new PlayerCharacter(character.getName()));
    }
    
    @Override
    public PlayerCharacter getCharacter(UUID id) {
        return DB.stream()
                .filter(x -> x.getId().equals(id))
                .findAny()
                .orElse(null);
    }   

    @Override
    public List<PlayerCharacter> getCharacters() {
        return DB;
    }  

    // Probably more intended for the business logic layer.
    @Override
    public String getRandomLootableItem() {
        Random rand = new Random();
        return LOOTABLE_ITEMS.get(rand.nextInt(LOOTABLE_ITEMS.size()));
    }

    @Override
    public void addItemToCharacter(UUID id, Item item) {
        PlayerCharacter character = DB.stream()
                .filter(x -> x.getId().equals(id))
                .findAny()
                .orElse(null);
        
        if (character != null) {
            character.addItemToInventory(item);
        }
    }
}
