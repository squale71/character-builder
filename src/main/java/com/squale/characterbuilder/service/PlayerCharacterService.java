package com.squale.characterbuilder.service;

import com.squale.characterbuilder.api.dtos.ItemDTO;
import com.squale.characterbuilder.api.dtos.ItemModifierDTO;
import com.squale.characterbuilder.api.dtos.PlayerCharacterDTO;
import com.squale.characterbuilder.api.requestmodels.PlayerCharacterRequestModel;
import com.squale.characterbuilder.db.PlayerCharacterRepository;
import com.squale.characterbuilder.model.Item;
import com.squale.characterbuilder.model.ItemModifier;
import com.squale.characterbuilder.model.PlayerCharacter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Service layer (for business logic) for interacting with a player character
 * @author Squale
 */
@Service
public class PlayerCharacterService {
    private final PlayerCharacterRepository characterRepository;
    
    @Autowired
    public PlayerCharacterService(@Qualifier("inMemoryRepository")PlayerCharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }
    
    public PlayerCharacterDTO getCharacter(UUID id) {        
        PlayerCharacter character = characterRepository.getCharacter(id);
        
        if (character != null) {
            return hydrateCharacterDTOFromModel(character);
        }
        
        return null;
    }
    
    public List<PlayerCharacterDTO> getCharacters() {
        List<PlayerCharacterDTO> result = new ArrayList<PlayerCharacterDTO>();
        
        List<PlayerCharacter> characters = characterRepository.getCharacters();
        
        characters.forEach(character -> {
            result.add(hydrateCharacterDTOFromModel(character));
        });
        
        return result;
    }
    
    public void addCharacter(PlayerCharacterRequestModel character) {
        PlayerCharacter newCharacter = new PlayerCharacter(character.getName());
        
        characterRepository.insertCharacter(newCharacter);
    }
    
    public void findRandomLoot(UUID characterId) {
        String itemName = characterRepository.getRandomLootableItem();
        
        ItemRarity rarity = randomEnum(ItemRarity.class);
        ItemModifierType modifierType = randomEnum(ItemModifierType.class);
        
        ArrayList<ItemModifier> modifiers = new ArrayList<ItemModifier>();
        
        int fixedValue = 0;
        switch (rarity) {
            case COMMON:
                fixedValue = getRandomNumber(1, 2);
                break;
            case UNCOMMON:    
                fixedValue = getRandomNumber(3, 4);
                break;
            case RARE:
                fixedValue = getRandomNumber(5, 6);
                break;
            case EPIC:
                fixedValue = getRandomNumber(7, 8);
                break;
            case LEGENDARY:
                fixedValue = getRandomNumber(9, 10);
                break;
        }
        
        modifiers.add(new ItemModifier(modifierType, fixedValue));
        
        Item newItem = new Item(itemName, modifiers, rarity);
        
        characterRepository.addItemToCharacter(characterId, newItem);
    }
    
    private <T extends Enum<?>> T randomEnum(Class<T> enumType){
        Random random = new Random();
        
        int x = random.nextInt(enumType.getEnumConstants().length);
        return enumType.getEnumConstants()[x];
    }
    
    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    
    private PlayerCharacterDTO hydrateCharacterDTOFromModel(PlayerCharacter characterModel) {
        ArrayList<ItemDTO> itemDTOs = new ArrayList<ItemDTO>();
        
        characterModel.getInventory().forEach(item -> {
            ArrayList<ItemModifierDTO> modifierDTOs = new ArrayList<ItemModifierDTO>();
            item.getModifiers().forEach(modifier -> {
                modifierDTOs.add(new ItemModifierDTO(modifier.getType(), modifier.getValue()));
            });
            
           
            itemDTOs.add(new ItemDTO(item.getName(), modifierDTOs, item.getRarity()));
        });
                
        return new PlayerCharacterDTO(characterModel.getId(), characterModel.getName(), characterModel.getCurrentHitPoints(), itemDTOs);
    }
}
