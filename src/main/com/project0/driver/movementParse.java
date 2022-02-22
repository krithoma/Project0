package com.project0.driver;

import com.project0.model.v_entity;
import com.project0.model.v_map;
import com.project0.model.v_room;

public class movementParse {

    v_map parsemap = null;

    public movementParse(v_map parsemap) {
        this.parsemap = parsemap;
    }

    public void showroom(int wherearewe, v_entity player){

        v_room checkroom = parsemap.getRoom(wherearewe);
        v_room lookroom = null;
        System.out.println(checkroom.getRoomdesc());
        //Now look at room data and show which doors exist.
        System.out.print("There is an opening to the: ");
        if(checkroom.getWhoNorthDoor() > -1){
            lookroom = parsemap.getRoom(checkroom.getWhoNorthDoor());
            if(lookroom.isLocked()){
                System.out.print("north[locked] ");
            }else {
                System.out.print("north ");
            }
        }
        if(checkroom.getWhoSouthDoor() > -1){
            lookroom = parsemap.getRoom(checkroom.getWhoSouthDoor());
            if(lookroom.isLocked()){
                System.out.print("south[locked] ");
            }else {
                System.out.print("south ");
            }
        }
        if(checkroom.getWhoEastDoor() > -1){
            lookroom = parsemap.getRoom(checkroom.getWhoEastDoor());
            if(lookroom.isLocked()){
                System.out.print("east[locked] ");
            }else {
                System.out.print("east ");
            }
        }
        if(checkroom.getWhoWestDoor() > -1){
            lookroom = parsemap.getRoom(checkroom.getWhoWestDoor());
            if(lookroom.isLocked()){
                System.out.print("west[locked] ");
            }else {
                System.out.print("west ");
            }
        }
        System.out.println(" ");

        //Now check if item exists and display those too.
        if(player.isHasKey()){
            System.out.println("You are holding a silver key.");
        }else if(player.isHasOrb()){
            System.out.println("You are holding a golden orb.");
        }else if(player.isHasSword()){
            System.out.println("You are brandishing a steel sword.");
        }

        if(checkroom.getHasOrb()){
            System.out.println("The golden orb shines from it's place on the floor.");
        }
        if(checkroom.getHasKey()){
            System.out.println("The silver glint of a key catches your eye.");
        }
        if(checkroom.getHasSword()){
            System.out.println("A sword is propped pommel down in the corner.");
        }
        if(checkroom.isHasOgre()){
            System.out.println("The ogre is here! He sees the sword and keeps his distance.");
        }
    }

    public void moveItem(String item, int whereweare, v_entity player){

        v_room checkroom = parsemap.getRoom(whereweare);

        //First we should check if the player has an item.
        if(player.hasItem()){
            if (item.equals("drop")) {
                if (player.isHasKey()) {
                    player.setHasKey(false);
                    checkroom.setHasKey(true);
                }else if(player.isHasOrb()){
                    player.setHasOrb(false);
                    checkroom.setHasOrb(true);
                }else if(player.isHasSword()){
                    player.setHasSword(false);
                    checkroom.setHasSword(true);
                }
            }else{
                System.out.println("You're already holding something. Try dropping it first.");
            }
        }else {
            if (item.equals("key")) {
                if (checkroom.getHasKey()) {
                    //Give key to player.
                    player.setHasKey(true);
                    //Remove key from room.
                    checkroom.setHasKey(false);
                } else {
                    System.out.println("There's no key here to pick up.");
                }
            } else if (item.equals("orb")) {
                if(checkroom.getHasOrb()){
                    player.setHasOrb(true);
                    checkroom.setHasOrb(false);
                }else{
                    System.out.println("There's no orb here to pick up.");
                }
            } else if (item.equals("sword")) {
                if(checkroom.getHasSword()){
                    player.setHasSword(true);
                    checkroom.setHasSword(false);
                }else{
                    System.out.println("There's no sword in this room.");
                }
            } else if(item.equals("drop")){
                System.out.println("You're not holding anything.");
            }
        }
    }

    public int movePlayer(String direction, int wherearewe, v_entity player){

        v_room checkroom = parsemap.getRoom(wherearewe);
        v_room lookroom = null;
        //Check if movement is valid and change room.
        if(direction.equals("north")){
            if(checkroom.getWhoNorthDoor() > -1){
                lookroom = parsemap.getRoom(checkroom.getWhoNorthDoor());
                if(lookroom.isLocked()){
                    if(player.isHasKey()){
                        System.out.println("You unlock the room and walk in.");
                        lookroom.setLocked(false);
                        player.setHasKey(false);
                        wherearewe = checkroom.getWhoNorthDoor();
                    }else{
                        System.out.println("The door is locked. You must find the key.");
                        return wherearewe;
                    }
                }else {
                    wherearewe = checkroom.getWhoNorthDoor();
                }
            }else{
                System.out.println("You painfully run into a stone wall!");
            }
        }else if(direction.equals("south")){
            if(checkroom.getWhoSouthDoor() > -1){
                lookroom = parsemap.getRoom(checkroom.getWhoSouthDoor());
                if(lookroom.isLocked()){
                    if(player.isHasKey()){
                        System.out.println("You unlock the room and walk in.");
                        lookroom.setLocked(false);
                        player.setHasKey(false);
                        wherearewe = checkroom.getWhoSouthDoor();
                    }else{
                        System.out.println("The door is locked. You must find the key.");
                        return wherearewe;
                    }
                }else {
                    wherearewe = checkroom.getWhoSouthDoor();
                }
            }else{
                System.out.println("You painfully run into a stone wall!");
            }
        }else if(direction.equals("east")){
            if(checkroom.getWhoEastDoor() > -1){
                lookroom = parsemap.getRoom(checkroom.getWhoEastDoor());
                if(lookroom.isLocked()){
                    if(player.isHasKey()){
                        System.out.println("You unlock the room and walk in.");
                        lookroom.setLocked(false);
                        player.setHasKey(false);
                        wherearewe = checkroom.getWhoEastDoor();
                    }else{
                        System.out.println("The door is locked. You must find the key.");
                        return wherearewe;
                    }
                }else {
                    wherearewe = checkroom.getWhoEastDoor();
                }
            }else{
                System.out.println("You painfully run into a stone wall!");
            }
        }else if(direction.equals("west")){
            if(checkroom.getWhoWestDoor() > -1){
                lookroom = parsemap.getRoom(checkroom.getWhoWestDoor());
                if(lookroom.isLocked()){
                    if(player.isHasKey()){
                        System.out.println("You unlock the room and walk in.");
                        lookroom.setLocked(false);
                        player.setHasKey(false);
                        wherearewe = checkroom.getWhoWestDoor();
                    }else{
                        System.out.println("The door is locked. You must find the key.");
                        return wherearewe;
                    }
                }else {
                    wherearewe = checkroom.getWhoWestDoor();
                }
            }else{
                System.out.println("You painfully run into a stone wall!");
            }
        }else if(direction.equals("key") || direction.equals("orb")||direction.equals("sword")||direction.equals("drop")) {
            moveItem(direction,wherearewe,player);
        }else if(direction.equals("quit")) {
            System.out.println("You run away from such a dangerous catacomb!");
        }else if(direction.equals("???")) {
            System.out.println("Commands are: [north south east west key orb sword drop ??? quit]");
        }else{
            System.out.println("Please limit responses to single word directions in lowercase.");
        }

        //Check for win condition.
        if(wherearewe == 0 && player.isHasOrb()){
            System.out.println("Congratulations. You escaped with the orb. You win!");
            int newwins = player.getNumberOfWins();
            newwins++;
            player.setNumberOfWins(newwins);
            return -1;
        }
        //Check for lose condition.
        checkroom = parsemap.getRoom(wherearewe);
        if(checkroom.isHasOgre() && !player.isHasSword()){
            System.out.println("You've walked up to the ogre! He runs up and gives you a fatal hug!");
            int newloses = player.getNumberOfLosses();
            newloses++;
            player.setNumberOfLosses(newloses);
            return -1;
        }

        //Increment number or moves for the  player
        int turns = player.getNumberOfTurns();
        turns++;
        player.setNumberOfTurns(turns);

        return wherearewe;
    }


}
