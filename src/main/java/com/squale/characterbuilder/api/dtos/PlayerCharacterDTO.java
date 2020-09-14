package com.squale.characterbuilder.api.dtos;

import java.util.List;
import java.util.UUID;

/**
 * A data transfer object representing a character to be sent across services to
 * the API layer.
 * @author Squale
 */
public class PlayerCharacterDTO {
    private final UUID id;
    private final String name;
    private final int currentHitPoints;
    private final List<ItemDTO> inventory;

    public PlayerCharacterDTO(UUID id, String name, int currentHitPoints, List<ItemDTO> inventory) {
        this.id = id;
        this.name = name;
        this.currentHitPoints = currentHitPoints;
        this.inventory = inventory;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public List<ItemDTO> getInventory() {
        return inventory;
    }
}
