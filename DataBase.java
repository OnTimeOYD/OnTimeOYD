package OnTime;

import java.sql.*;
import java.security.*;
import javax.xml.bind.*;

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
  
    
    public DataBase(){
        try{
        conn = DriverManager.getConnection(ADRESS, USERNAME_DB, PASSWORD_DB);

        //AlertClass.INFO_BOX("CONNECTED", "CONNECTED");
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
 public static String get_SHA_512_SecurePassword(String passwordToHash){
String generatedPassword = null;
    try {
         MessageDigest md = MessageDigest.getInstance("SHA-512");
         byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
         StringBuilder sb = new StringBuilder();
         for(int i=0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
         }
         generatedPassword = sb.toString();
        } 
       catch (Exception e){
        e.printStackTrace();
       }
    return generatedPassword;
}

}