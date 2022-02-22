package com.project0.util;

import com.project0.driver.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class KTConnectionUtil {
    private static Connection conn;
    public KTConnectionUtil() {
    }

    public static Connection getConnection(){
        try{
          FileInputStream ktpropertiesInput = new FileInputStream("C:\\Users\\necsk\\Documents\\Revature\\KTSQL.properties");

          Properties propers = new Properties();
          propers.load(ktpropertiesInput);

          String url = (String) propers.get("url");
          String username = (String) propers.get("username");
          String password = (String) propers.get("password");

          if(conn == null){
              try{
                  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                  conn = java.sql.DriverManager.getConnection(url, username, password);
              }catch(SQLException e){
                  Driver.log.warn("Difficulty connecting...", e);
              } catch (ClassNotFoundException e) {
                  Driver.log.warn("Difficulty connecting...", e);
              }
          }
        } catch(FileNotFoundException e){
            Driver.log.warn("No file...", e);
        } catch(IOException e){
            Driver.log.warn("No file...", e);
        }
        return conn;
    }
}
