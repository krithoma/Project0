package com.kthomas.project0.driver;

import org.apache.log4j.Logger;

public class Driver {

    public static final Logger log = Logger.getLogger(Driver.class);

    public static void main(String[] args) {
        Playloop v_game = new Playloop();
        v_game.Dotheloop();
    }
}
