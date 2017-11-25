package OnTime;

import java.sql.*;

public class ConnectionTEST{

    static String ADRESS="jdbc:mysql://217.61.1.61:3306/miki_OnTimeOYD";
    private static String USERNAME_DB = "";
    private static String PASSWORD_DB = "";
    static Connection conn = null;

    public static void main(String[] args){    
        try{
            conn = DriverManager.getConnection(ADRESS, USERNAME_DB, PASSWORD_DB);
            System.out.println("Connected!");
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public ConnectionTEST(){
        try{
        conn = DriverManager.getConnection(ADRESS, USERNAME_DB, PASSWORD_DB);
        System.out.println("Connected!");
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }


}