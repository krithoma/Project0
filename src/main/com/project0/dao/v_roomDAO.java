package com.project0.dao;

import com.project0.driver.Playloop;
import com.project0.model.v_map;
import com.project0.model.v_room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class v_roomDAO {

    Statement statement = Playloop.conn.createStatement();
    ResultSet rs = statement.executeQuery("Select * From catacomb");

    public v_roomDAO() throws SQLException {
    }

    public v_map getV_room() throws SQLException {

        v_map daomap = new v_map();

        while(rs.next()) {
            int id = rs.getInt("room_id");
            boolean spawn = rs.getBoolean("isspawn");
            int north = rs.getInt("whonorth");
            int south = rs.getInt("whosouth");
            int east = rs.getInt("whoeast");
            int west = rs.getInt("whowest");
            String desc = rs.getString("roomdesc");
            v_room room = new v_room(id, spawn, north, south, east, west, desc);
            daomap.addRoom(id, room);
        }
        return daomap;
    }
}
