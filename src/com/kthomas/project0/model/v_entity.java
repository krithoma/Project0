package com.kthomas.project0.model;

public class v_entity {
    //This is the class for the player and the ogre.
    String v_entityID;
    boolean hasKey = false;
    boolean hasOrb = false;
    boolean hasSword = false;
    int numberOfTurns = 0;
    int numberOfWins = 0;
    int numberOfLosses = 0;
    int wherePlayer = 0;

    public v_entity(String v_entityID) {
        this.v_entityID = v_entityID;
    }

    public String getV_entityID() {
        return v_entityID;
    }

    public void setV_entityID(String v_entityID) {
        this.v_entityID = v_entityID;
    }

    public boolean isHasKey() {
        return hasKey;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
    }

    public boolean isHasOrb() {
        return hasOrb;
    }

    public void setHasOrb(boolean hasOrb) {
        this.hasOrb = hasOrb;
    }

    public boolean isHasSword() {
        return hasSword;
    }

    public void setHasSword(boolean hasSword) {
        this.hasSword = hasSword;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public int getNumberOfLosses() {
        return numberOfLosses;
    }

    public void setNumberOfLosses(int numberOfLosses) {
        this.numberOfLosses = numberOfLosses;
    }

    public int getWherePlayer() {
        return wherePlayer;
    }

    public void setWherePlayer(int wherePlayer) {
        this.wherePlayer = wherePlayer;
    }

    public boolean hasItem(){
        return hasOrb || hasSword || hasKey;
    }
}
