package com.squale.characterbuilder.api.dtos;

import com.squale.characterbuilder.service.ItemRarity;
import java.util.List;

/**
 * A class representing an item.
 * @author Squale
 */
public class ItemDTO {
    private final String name;
    private final List<ItemModifierDTO> modifiers;
    private final ItemRarity rarity;

    public ItemDTO(String name, List<ItemModifierDTO> modifiers, ItemRarity rarity) {
        this.name = name;
        this.modifiers = modifiers;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public List<ItemModifierDTO> getModifiers() {
        return modifiers;
    }

    public ItemRarity getRarity() {
        return rarity;
    }
}
