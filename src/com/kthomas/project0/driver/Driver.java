package com.kthomas.project0.driver;

import com.kthomas.project0.dao.v_playerDAO;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.SQLException;

public class Driver {

    public static final Logger log = Logger.getLogger(Driver.class);

    public static void main(String[] args) {
        Playloop v_game = new Playloop();
        //Set up player data here.

        try {
            v_playerDAO playerdao = new v_playerDAO();
            boolean player = playerdao.checkV_player("Tester");
            System.out.println(player);
        } catch (SQLException e) {
            Driver.log.warn("Bad or missing data...",e);
        }

        v_game.Dotheloop();
    }
}
