package com.project0.dao;

import com.project0.driver.Driver;
import com.project0.driver.Playloop;
import com.project0.model.v_entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class v_playerDAO {
    Statement statement = Playloop.conn.createStatement();

    public v_playerDAO() throws SQLException {
    }

    public boolean checkV_player(String v_playerid){
        try {
            String sqlstatement = "SELECT * FROM vplayerdata WHERE player_id = '" + v_playerid + "'";
            ResultSet rs = statement.executeQuery(sqlstatement);

            if(rs.next()){
                return true;
            }
        }catch(SQLException e){
            Driver.log.warn("Still haven't found...check", e);
        }
        return false;
    }

    public v_entity getV_player(String v_playerid){
        v_entity player = new v_entity("v_playerid");

        try {
            String sqlstatement = "Select * From vplayerdata WHERE player_id = '" + v_playerid + "'";
            ResultSet rs = statement.executeQuery(sqlstatement);
            if(rs.next()){
                player.setV_entityID(rs.getString("player_id"));
                player.setNumberOfWins(rs.getInt("wins"));
                player.setNumberOfLosses(rs.getInt("loses"));
                player.setMinTurns(rs.getInt("minnumturns"));
                player.setMaxTurns(rs.getInt("maxnumturns"));
                player.setAvgTurns(rs.getInt("avernumturns"));
            }else{
                Driver.log.warn("Not finding data even after checking for it...");
            }
        }catch(SQLException e){
            //We could catch if no record exists and start one.
            Driver.log.warn("Still haven't found...get", e);
        }

        return player;
    }

    public void setV_player(v_entity player){

        //We need to check if this is a new record before we send update.
        try {
            //Need to build string before firing.
            String v_name = player.getV_entityID();
            int win = player.getNumberOfWins();
            int lose = player.getNumberOfLosses();
            int minturn = player.getMinTurns();
            //int minturn = 0;
            int maxturn = player.getMaxTurns();
            //int maxturn = 0;
            int avgturn = player.getAvgTurns();
            //int avgturn = 0;

            if(!checkV_player(v_name)) {
                String sqlstatement = "INSERT INTO vplayerdata (player_id,wins,loses,minnumturns,maxnumturns,avernumturns) ";
                String sqlstatement2 = "VALUES ('" + v_name + "'," + win + "," + lose + "," + minturn + "," + maxturn + "," + avgturn + ")";
                sqlstatement = sqlstatement + sqlstatement2;
                int result = statement.executeUpdate(sqlstatement);
            }else{
                String sqlstatement = "UPDATE vplayerdata SET wins=" + win + ", loses=" + lose + " WHERE player_id='" + v_name + "'";

                int result = statement.executeUpdate(sqlstatement);
            }


        }catch(SQLException e){
            Driver.log.warn("Still haven't found...set", e);
        }
    }
}
