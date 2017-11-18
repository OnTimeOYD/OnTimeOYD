package OnTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class List extends JPanel{
    String textContent = " \t Jakiś tekst ";
    
    public List(){
        setLayout(new GridLayout(15,1));
        
        for(int i = 0; i < 12; i++){ 
                        
            Date dat = new Date();
            //ODCZYTYWANIE Z PLIKU
            add(createDate(dat,textContent));
        }                       
    }

    
    public JPanel createDate(Date dat , String text){
       JPanel line = new JPanel();
            JCheckBox box = new JCheckBox();      
            line.add(box);

            
            JLabel content = new JLabel(
                    dat.getDay() + "-" + 
                    dat.getMonth() + "-" + 
                    (dat.getYear()+1900) + " \t " +
                    dat.getHours() + ":"+
                    dat.getMinutes()
                    + text);
            
            line.add(content);            
        return line;
    }
}