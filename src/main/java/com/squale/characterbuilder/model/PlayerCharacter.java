package com.squale.characterbuilder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Character model representing data about a character
 * @author Squale
 */
public class PlayerCharacter {
    private final UUID id;
    private final String name;
    private int currentHitPoints;
    private final ArrayList<Item> inventory;
    
    public PlayerCharacter(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.currentHitPoints = getMaximumHitPoints();
        this.inventory = new ArrayList<Item>();
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

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    public int getMaximumHitPoints() {
        return 50;
    }

    public List<Item> getInventory() {
        return inventory;
    }
    
    public void addItemToInventory(Item item) {
        inventory.add(item);
    }
}
