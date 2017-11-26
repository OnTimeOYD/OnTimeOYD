package OnTime;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;

public class DisplayTrayIcon extends JFrame{
    
    
    static TrayIcon TRAY_ICON;
    
    
    public DisplayTrayIcon(){
        SHOW_TRAY_ICON();
    }
    
    private static void SHOW_TRAY_ICON(){
        final SystemTray tray = SystemTray.getSystemTray();
        final PopupMenu popup = new PopupMenu();
       
        if(!SystemTray.isSupported()){
            System.err.println("Error, TrayIcon not supported!");
            System.exit(0);
        }
        
        TRAY_ICON = new TrayIcon(CREATE_ICON("LogoOnTime.png","Tray Icon"));
        TRAY_ICON.setToolTip("OnTime Ver. 0.0.6");
        
        //Add components/menu
        MenuItem showItem = new MenuItem("Show");
        MenuItem exitItem = new MenuItem("Exit");
        
        showItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainApp.mp = new MainApp();
            }
        });
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        popup.add(showItem);
        popup.addSeparator();
        popup.add(exitItem);
        
        TRAY_ICON.setPopupMenu(popup);
        
        
        
        try{
            tray.add(TRAY_ICON);
        }catch(AWTException e){
            
        }
    }
    
    public static void main(String[] args) {
        new DisplayTrayIcon();
    }
    
    protected static Image CREATE_ICON(String path, String desc){
        URL ImageURL = DisplayTrayIcon.class.getResource(path);
        return (new ImageIcon(ImageURL, desc)).getImage();
    }
}