package com.squale.characterbuilder.api.requestmodels;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request model for sending data up from the client to the server for a player character
 * @author Squale
 */
public class PlayerCharacterRequestModel {
    private final String name;

    public PlayerCharacterRequestModel(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
