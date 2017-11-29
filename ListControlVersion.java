package OnTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListControlVersion extends JPanel implements MouseListener,ItemListener {
    String textContent = " \t Jakiś tekst ";
    JLabel[] lineLabel = new JLabel[12];
    static int TABLE_LENGTH = 0; 
    String font = "Courier New";
    
    public ListControlVersion(){
        File.READ("calendar.txt"); 
        TABLE_LENGTH =File.TABLE_LENGTH();
        setLayout(new GridLayout(12,1));
       
       
        for(int i = 0; i < TABLE_LENGTH && i < 12; i++){ 
            add(createEmptyList(i));
        }
        for(int i = 0; i < TABLE_LENGTH && i < 12; i++){ 
            createDate(File.GET_DAY(i),
                       File.GET_MONTH(i),
                       File.GET_YEAR(i),
                       File.GET_HOUR(i),
                       File.GET_MINUTE(i),
                       File.GET_TITLE(i),
                       i);
        }
    }
    
    public JLabel createEmptyList(int pos){
        lineLabel[pos] = new JLabel(" ");
        return lineLabel[pos];
    }
   
    
    public void createDate(int day, int month, int year, int hour, int minute,
                            String text, int value){
        String textLabel = "";
        
        if(day < 10)textLabel = "0"+day;
        else textLabel = ""+day;

        if(month<10)textLabel += "-0"+month;
            else textLabel += "-"+month;

        textLabel += "-"+year;

        if(hour <10)textLabel += "  0"+hour;
            else textLabel += "  "+hour;

        if(minute<10)textLabel += ":0"+minute;
            else textLabel += ":"+minute;

        if(text.length()<=19)
            for(int i=text.length();i<19;i++)text+=" ";

        if(text.length()>19)text = text.substring(0, 15)+" ...";

        textLabel += "  "+text;
        
        lineLabel[value].setText(textLabel);
        lineLabel[value].setFont(new Font(font,Font.PLAIN,12));
        lineLabel[value].addMouseListener(this);
        
    }
    
    public void mouseClicked(MouseEvent event){
        Object source = event.getSource();
        int length = File.TABLE_LENGTH();
        for(int i=0;i<length && i < 12;i++){
            if(source == lineLabel[i]){
                MainApp.CC.setVisible(true);
                CenterContent.SET_LINE(i);
                MainApp.REPAINT(0);
            }
        }
    }
    public void mouseEntered(MouseEvent event){
    Object source = event.getSource();
    int length = File.TABLE_LENGTH();
    
            for(int i=0;i<12 && i<length;i++){
                if(source == lineLabel[i]){
                    lineLabel[i].setBackground(new Color(165,172,182));
                    lineLabel[i].setOpaque(true);
                }     
            }
    }
    public void mouseExited(MouseEvent event){
    Object source = event.getSource();
    int length = File.TABLE_LENGTH();
    
        for(int i=0;i<12 && i<length;i++){
            if(source == lineLabel[i]){
                lineLabel[i].setBackground(null);
                lineLabel[i].setOpaque(true);
            }     
        }
    }
    public void mousePressed(MouseEvent event){}
    public void mouseReleased(MouseEvent event){}
    public void itemStateChanged(ItemEvent event){}
}