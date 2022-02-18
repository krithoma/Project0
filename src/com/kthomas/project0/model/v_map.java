package com.kthomas.project0.model;

public class v_map {

    v_room[] mapofrooms = new v_room[10];

    public v_map() {

    }

    public void addRoom(int v_roomID, v_room vroom){
        mapofrooms[v_roomID] = vroom;
    }

    public v_room getRoom(int v_roomID){
        return mapofrooms[v_roomID];
    }


}
