package OnTime;


import java.awt.event.FocusAdapter;
import java.io.IOException;
import java.util.Date;
import javax.swing.*;
import java.io.*;
import java.util.concurrent.TimeUnit;
import jdk.nashorn.internal.codegen.CompilerConstants;
import sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl;

public class AlertClass extends JFrame{
    static Date DATE;
    private int var;
    
    public AlertClass(){
        MyRunnable myRunnable = new MyRunnable(10);
        Thread t = new Thread(myRunnable);
        t.start();
    }
    
    public static void main(String[] arguments){
        new AlertClass();
        DATE = new Date();
        
    }
    
    private static void CHECK_DATES(){
        while(true){
            DATE = new Date();
            int block = 0;
            int length = File.TABLE_LENGTH();
            for(int i = 0; i<length;i++){                
                if(File.GET_DAY(i) == DATE.getDate() && 
                   File.GET_MONTH(i)-1 == DATE.getMonth() &&
                   File.GET_YEAR(i) == DATE.getYear()+1900 &&
                   File.GET_HOUR(i) == DATE.getHours() &&
                   File.GET_MINUTE(i) == DATE.getMinutes() &&
                   0 == DATE.getSeconds() && block == 0){
                   INFO_BOX("You have an Event!"
                           + "\nTitle: "+File.GET_TITLE(i),
                           "EVENT"); 
                    block++;
                }
            }
          
            try{
                TimeUnit.SECONDS.sleep(1);
            } catch(InterruptedException e){
                System.err.println(e.getMessage());
            }
        
        }
    }
    
    

   public class MyRunnable implements Runnable {

    private int var;

    public MyRunnable(int var) {
        this.var = var;
    }

    public void run() {
        CHECK_DATES();
    }
}
    

   static void STOP(){
       System.exit(0);
   }
    
    
    
    
    public static void INFO_BOX(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.WARNING_MESSAGE);
    }
    
}