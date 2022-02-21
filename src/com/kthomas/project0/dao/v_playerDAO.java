package com.kthomas.project0.dao;

import com.kthomas.project0.driver.Driver;
import com.kthomas.project0.model.v_entity;
import org.apache.log4j.Level;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.kthomas.project0.driver.Playloop.conn;

public class v_playerDAO {
    Statement statement = conn.createStatement();

    public v_playerDAO() throws SQLException {
    }

    public boolean checkV_player(String v_playerid){
        try {
            String sqlstatement = "SELECT COUNT(1) FROM vplayerdata WHERE player_id = '" + v_playerid + "'";
            ResultSet rs = statement.executeQuery(sqlstatement);
            rs.next();
            if(rs.toString().equals("SQLServerResultSet:2")){
                return true;
            }
        }catch(SQLException e){
            Driver.log.warn("Still haven't found...", e);
        }
        return false;
    }

    public v_entity getV_player(String v_playerid){
        v_entity player = new v_entity("v_playerid");

        try {
            String sqlstatement = "Select * From vplayerdata WHERE player_id = '" + v_playerid + "'";
            ResultSet rs = statement.executeQuery(sqlstatement);
            rs.next();
            System.out.println(rs.toString());
            player.setV_entityID(rs.getString("player_id"));
            player.setNumberOfWins(rs.getInt("wins"));
            player.setNumberOfLosses(rs.getInt("loses"));
            player.setMinTurns(rs.getInt("minnumturns"));
            player.setMaxTurns(rs.getInt("maxnumturns"));
            player.setAvgTurns(rs.getInt("avernumturns"));
        }catch(SQLException e){
            //We could catch if no record exists and start one.
            Driver.log.warn("Still haven't found...", e);
        }

        return player;
    }

    public void setV_player(v_entity player){
        try {
            //Need to build string before firing.
            String sqlstatement = "INSERT INTO vplayerdata (player_id,wins,loses,minnumturns,maxnumturns,avernumturns) VALUES (values)";
            ResultSet rs = statement.executeQuery(sqlstatement);
        }catch(SQLException e){
            Driver.log.warn("Still haven't found...", e);
        }
    }
}
