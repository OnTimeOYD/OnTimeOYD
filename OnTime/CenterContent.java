package OnTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CenterContent extends JPanel implements ActionListener{
    public int day=1, month=1, year=2, hour=12, minute=12;
    public String title, content = "Brak zawartości";
    static Integer[] DAYS = new Integer[31];
    static Integer[] MONTHS = new Integer[12];
    static Integer[] YEARS = new Integer[100];
    static Integer[] HOURS = new Integer[24];
    static Integer[] MINUTES = new Integer[59];
    JComboBox dayDate,monthDate,yearDate,hourDate,minuteDate;
    JTextArea contentArea;
    JButton save;
    
    public CenterContent(){
        JPanel handler = new JPanel();
        handler.setLayout(new GridLayout(6,1));
        
        JPanel titlePanel = new JPanel(new GridLayout(1,1));
        JTextField titleLabel = new JTextField(title);
        titlePanel.add(titleLabel);
        
        ////////////////////////////////////////////////////////////////////////
        JPanel datePanel = new JPanel();
        JLabel dateLabel = new JLabel("Date: ");
        for(int i=1;i<=YEARS.length;i++){
            if(i<=31){
                DAYS[i-1] = i; 
            }
            if(i<=12){
                MONTHS[i-1] = i;
            }
            YEARS[i-1] = 2016+i;
            if(i<=23){
                HOURS[i-1] = i;
            }
            if(i<=59){
                MINUTES[i-1] = i;
            }
        }
        dayDate = new JComboBox(DAYS);
        dayDate.setSelectedItem(day);
        monthDate = new JComboBox(MONTHS);
        monthDate.setSelectedIndex(month);
        yearDate = new JComboBox(YEARS);  
        yearDate.setSelectedIndex(year);
        hourDate = new JComboBox(HOURS);
        hourDate.setSelectedIndex(hour);
        minuteDate = new JComboBox(MINUTES);
        minuteDate.setSelectedItem(minute);
        datePanel.add(dateLabel);
        datePanel.add(dayDate);
        datePanel.add(monthDate);
        datePanel.add(yearDate);
        
        JPanel timePanel = new JPanel();
        JLabel time = new JLabel("Time: ");
        timePanel.add(time);
        timePanel.add(hourDate);
        timePanel.add(minuteDate);
        ////////////////////////////////////////////////////////////////////////
        
        JPanel contentLabelPanel = new JPanel();
        JLabel contentLabel = new JLabel("Content: ");
        contentLabelPanel.add(contentLabel);
       
        ////////////////////////////////////////////////////////////////////////
        JPanel contentPanel = new JPanel(new GridLayout());
        contentArea = new JTextArea(content);
        contentArea.setFont(new Font("Arial",Font.PLAIN,15));
        contentPanel.add(contentArea);
        ////////////////////////////////////////////////////////////////////////
        
        JPanel buttonPanel = new JPanel();
        save = new JButton("SAVE");
        save.addActionListener(this);
        buttonPanel.add(save);
        
        ////////////////////////////////////////////////////////////////////////
        
        handler.add(titlePanel);
        handler.add(datePanel);
        handler.add(timePanel);
        handler.add(contentLabelPanel);
        handler.add(contentPanel);
        handler.add(buttonPanel);
        handler.setBorder(BorderFactory.createLineBorder(Color.black));
        add(handler);
        setVisible(true);
    }
    
        public void actionPerformed(ActionEvent event){
        Object source = event.getSource();
        
        if(source == save){
        }
    }
}