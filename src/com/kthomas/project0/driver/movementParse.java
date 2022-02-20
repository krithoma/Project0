package com.kthomas.project0.driver;

import com.kthomas.project0.model.v_map;
import com.kthomas.project0.model.v_room;

public class movementParse {

    v_map parsemap = null;

    public movementParse(v_map parsemap) {
        this.parsemap = parsemap;
    }

    public void showroom(int wherearewe){

        v_room checkroom = parsemap.getRoom(wherearewe);
        System.out.println(checkroom.getRoomdesc());
        //Now look at room data and show which doors exist.
        System.out.print("There is an opening to the: ");
        if(checkroom.getWhoNorthDoor() > -1){
            System.out.print("north ");
        }
        if(checkroom.getWhoSouthDoor() > -1){
            System.out.print("south ");
        }
        if(checkroom.getWhoEastDoor() > -1){
            System.out.print("east ");
        }
        if(checkroom.getWhoWestDoor() > -1){
            System.out.print("west ");
        }
        System.out.println(" ");

        //Now check if item exists and display those too.
        if(checkroom.getHasOrb()){
            System.out.println("The golden orb shines from it's place on the floor.");
        }
        if(checkroom.getHasKey()){
            System.out.println("The silver glint of a key catches your eye.");
        }
        if(checkroom.getHasSword()){
            System.out.println("A sword is propped pommel down in the corner.");
        }
    }

    public int movePlayer(String direction, int wherearewe){

        v_room checkroom = parsemap.getRoom(wherearewe);
        //Check if movement is valid and change room.
        if(direction.equals("north")){
            if(checkroom.getWhoNorthDoor() > -1){
                wherearewe = checkroom.getWhoNorthDoor();
            }else{
                System.out.println("You painfully run into a stone wall!");
            }
        }else if(direction.equals("south")){
            if(checkroom.getWhoSouthDoor() > -1){
                wherearewe = checkroom.getWhoSouthDoor();
            }else{
                System.out.println("You painfully run into a stone wall!");
            }
        }else if(direction.equals("east")){
            if(checkroom.getWhoEastDoor() > -1){
                wherearewe = checkroom.getWhoEastDoor();
            }else{
                System.out.println("You painfully run into a stone wall!");
            }
        }else if(direction.equals("west")){
            if(checkroom.getWhoWestDoor() > -1){
                wherearewe = checkroom.getWhoWestDoor();
            }else{
                System.out.println("You painfully run into a stone wall!");
            }
        }else if(direction.equals("quit")) {
            System.out.println("You run away from such a dangerous catacomb!");
        }else{
            System.out.println("Please limit responses to single word directions in lowercase.");
        }

        return wherearewe;
    }

}
