package com.kthomas.project0.driver;

import com.kthomas.project0.dao.v_roomDAO;
import com.kthomas.project0.model.v_entity;
import com.kthomas.project0.model.v_map;
import com.kthomas.project0.model.v_room;
import com.kthomas.project0.util.KTConnectionUtil;
import org.apache.log4j.Level;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Playloop {

    public static Connection conn = KTConnectionUtil.getConnection();

    static v_map catacomb = null;
    static v_entity playerOne = new v_entity("Player");
    static v_entity ogre = new v_entity("Ogre");
    static int wherePlayer = 0;

    public Playloop() {
        Random v_rand = new Random();

        try {
            v_roomDAO catacombdao = new v_roomDAO();
            catacomb = catacombdao.getV_room();
        } catch (SQLException e) {
            Driver.log.log(Level.WARN, "Bad or missing data...", e);
        }

        //Now setup where the items are located, one to a room.
        int randRoom = -1;
        int randRoom2 = -1;
        int randRoom3 = -1;

        do {
            randRoom = v_rand.nextInt((9 - 2) + 1) + 2;
        }while(randRoom == 2);
        v_room checkroom = catacomb.getRoom(randRoom);
        checkroom.setHasOrb(true);

        do {
            randRoom2 = v_rand.nextInt((9 - 1) + 1) + 1;
        }while(randRoom == randRoom2 || randRoom2 == 2);
        checkroom = catacomb.getRoom(randRoom2);
        checkroom.setHasKey(true);

        do{
            randRoom3 = v_rand.nextInt((9 - 1) + 1) + 1;
        }while(randRoom3 == randRoom2 || randRoom3 == randRoom || randRoom3 == 2);
        checkroom = catacomb.getRoom(randRoom3);
        checkroom.setHasSword(true);
    }

    public static void Dotheloop(){
        Scanner playerinput = new Scanner(System.in);
        boolean quitflag = false;
        movementParse v_parse = new movementParse(catacomb);

       do {
            v_parse.showroom(wherePlayer);

            System.out.println("Which way do you go?");
            String whattyped = playerinput.nextLine();
            if(whattyped.equals("quit")){quitflag = true;}

            wherePlayer = v_parse.movePlayer(whattyped, wherePlayer);
        } while(quitflag == false);

        playerinput.close();
    }
}
