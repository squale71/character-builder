package com.squale.characterbuilder.model;

import com.squale.characterbuilder.service.ItemRarity;
import java.util.List;

/**
 * A class representing an item.
 * @author Squale
 */
public class Item {
    private final String name;
    private final List<ItemModifier> modifiers;
    private final ItemRarity rarity;

    public Item(String name, List<ItemModifier> modifiers, ItemRarity rarity) {
        this.name = name;
        this.modifiers = modifiers;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public List<ItemModifier> getModifiers() {
        return modifiers;
    }

    public ItemRarity getRarity() {
        return rarity;
    }
}
