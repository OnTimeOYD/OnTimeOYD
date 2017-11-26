package OnTime;

import java.sql.*;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class DataBase{

    static String ADRESS="jdbc:mysql://217.61.1.61:3306/miki_OnTimeOYD";
    private static String USERNAME_DB = "miki_root";
    private static String PASSWORD_DB = "MikiPati123";
    static Connection conn = null;
    static Statement ADD = null;
    static Statement SELECT = null;
    static String STATEMENT_ADD = null;
    static String STATEMENT_SELECT = null;
    static ResultSet result;
    static String USER, PASSWORD;
    
   /* public static void main(String[] args){    
        try{
            conn = DriverManager.getConnection(ADRESS, USERNAME_DB, PASSWORD_DB);
            //System.out.println("Connected!");
            //ADD_STATEMENT("TEST","TEST","TEST","USERS",GET_HASH("TEST".getBytes(),"SHA-512"));
           // System.out.println(GET_HASH("TEST".getBytes(),"SHA-512"));
            //SELECT_STATEMENT("USERS", "*");
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }*/
    
    public DataBase(){
        try{
        conn = DriverManager.getConnection(ADRESS, USERNAME_DB, PASSWORD_DB);
        //System.out.println("Connected!");
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
    
    public static void ADD_STATEMENT(String username,String name, String surname,
                                    String dbName,String password){
        
        try{
            ADD = (Statement) conn.createStatement();
            STATEMENT_ADD = "INSERT INTO "+dbName+"(username,name,surname,password) "
                    + "VALUES ('"+username+"','"+name+"','"+surname+"','"+password+"')";
            ADD.executeUpdate(STATEMENT_ADD); 
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    
    public static void SELECT_STATEMENT(String dbName, String content){
        try{
            SELECT = (Statement) conn.createStatement();
            STATEMENT_SELECT = "SELECT"+content+"FROM "+dbName;
            result = SELECT.executeQuery(STATEMENT_SELECT); 
            //ArrayList<String> array = new ArrayList<>();
            while(result.next()){
               USER = result.getString("username");
               PASSWORD = result.getString("password");
            }
            
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    public static void SELECT_STATEMENT(String statement){
        try{
            SELECT = (Statement) conn.createStatement();
            STATEMENT_SELECT = statement;
            result = SELECT.executeQuery(STATEMENT_SELECT);
            while(result.next()){
               USER = result.getString("username");
               PASSWORD = result.getString("password");
            }
        }catch(SQLException e){
            System.err.println(e);
        }
    }
    //MD2,MD5,SHA-1,SHA-224,SHA-256,SHA-384,SHA-512
    public static String GET_HASH(byte [] inputBytes, String algorithm){
        String hashValue = "";
        
        try{
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(inputBytes);
            byte[] digestedBytes = messageDigest.digest();
            hashValue = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();
        } catch(Exception e){
            
        }      
        return hashValue;
    }

}