package com.project0.driver;

import com.project0.dao.v_playerDAO;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Scanner;

public class Driver {

    public static final Logger log = Logger.getLogger(Driver.class);

    public static void main(String[] args) {
        Playloop v_game = new Playloop();

        Scanner playerinput = new Scanner(System.in);
        //Ask user for player name.
        System.out.println("What is your name, player?");
        String whattyped = playerinput.nextLine();

        try {
            v_playerDAO playerdao = new v_playerDAO();
            boolean player = playerdao.checkV_player(whattyped);
            if(player){
                v_game.playerOne = playerdao.getV_player(whattyped);
                //Print out player stats.
                System.out.println(whattyped + ", here are your stats so far...");
                System.out.println(v_game.playerOne.getNumberOfWins() + " wins. " + v_game.playerOne.getNumberOfLosses() + " loses.");
            }else{
                v_game.playerOne.setV_entityID(whattyped);
            }
        } catch (SQLException e) {
            log.warn("Bad or missing data in check...",e);
        }

        System.out.println("Are you ready to begin?");
        whattyped = playerinput.nextLine();
        System.out.println("Whatever you say. We start the game anyway...");

        v_game.Dotheloop();
    }
}
