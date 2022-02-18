package com.kthomas.project0.model;

public class v_room {
    //Room objects instantiated here.

    int roomID;
    boolean isSpawnable;
    int whoNorthDoor;
    int whoSouthDoor;
    int whoEastDoor;
    int whoWestDoor;
    boolean hasOrb;
    boolean hasKey;
    boolean hasSword;
    String roomdesc;

    //Will need handles to objects stored, if present.
    //Will need handles to entities stored, if present.

    public v_room(int id, boolean spawn, int north, int south, int east, int west, String desc) {

        roomID = id;
        isSpawnable = spawn;
        whoNorthDoor = north;
        whoSouthDoor = south;
        whoEastDoor = east;
        whoWestDoor = west;
        roomdesc = desc;

    }

    public int getRoomID() {
        return roomID;
    }

    public boolean isSpawnable() {
        return isSpawnable;
    }

    public int getWhoNorthDoor() {
        return whoNorthDoor;
    }

    public int getWhoSouthDoor() {
        return whoSouthDoor;
    }

    public int getWhoEastDoor() {
        return whoEastDoor;
    }

    public int getWhoWestDoor() {
        return whoWestDoor;
    }

    public String getRoomdesc() {
        return roomdesc;
    }

    public boolean getHasOrb(){ return hasOrb;}

    public boolean getHasKey(){ return hasKey;}

    public boolean getHasSword(){ return hasSword;}

    public void setHasOrb(boolean v_set){hasOrb = v_set;}

    public void setHasKey(boolean v_set){hasKey = v_set;}

    public void setHasSword(boolean v_set){hasSword = v_set;}

    public boolean checkItems(){
        if(hasOrb || hasKey || hasSword){
            return true;
        }
        return false;
    }
}
