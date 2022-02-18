package com.kthomas.project0.driver;

import com.kthomas.project0.dao.v_roomDAO;
import com.kthomas.project0.model.v_map;
import com.kthomas.project0.util.KTConnectionUtil;
import org.apache.log4j.Level;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Playloop {

    public static Connection conn = KTConnectionUtil.getConnection();

    static v_map catacomb = null;
    static int wherePlayer = 0;

    public Playloop() {
        try {
            v_roomDAO catacombdao = new v_roomDAO();
            catacomb = catacombdao.getV_room();
        } catch (SQLException e) {
            Driver.log.log(Level.WARN, "Bad or missing data...", e);
        }

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
