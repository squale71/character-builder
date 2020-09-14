package com.squale.characterbuilder.api.dtos;

import com.squale.characterbuilder.service.ItemModifierType;

/**
 * A class representing a modifier that changes the characteristics of an item.
 * @author Squale
 */
public class ItemModifierDTO {
    private final ItemModifierType type;
    private final int value;

    public ItemModifierDTO(ItemModifierType type, int value) {
        this.type = type;
        this.value = value;
    }

    public ItemModifierType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
