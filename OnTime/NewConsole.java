package OnTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewConsole extends JFrame implements ActionListener{
    JLabel title, date, content;
    JButton exit, save;
    JTextField textTitle;
    JComboBox dayDate,monthDate,yearDate,hourDate,minuteDate;
    JTextArea textContent;
    Integer[] days = new Integer[31];
    Integer[] months = new Integer[12];
    Integer[] years = new Integer[100];
    Integer[] hours = new Integer[24];
    Integer[] minutes = new Integer[59];
    
    
    public NewConsole(){
        super("Add new event");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(6,1));
        ////////////////////////////////////////////////////////////////////////
        JPanel logo = new JPanel();
        JLabel logoText = new JLabel("Tu będzie logo");
        logo.add(logoText);
        ////////////////////////////////////////////////////////////////////////
        JPanel titleLine = new JPanel();
        title = new JLabel("Title: ");
        textTitle = new JTextField("Type your title here...",15);
        titleLine.add(title);
        titleLine.add(textTitle);
        ////////////////////////////////////////////////////////////////////////
        for(int i=1;i<=years.length;i++){
            if(i<=31){
                days[i-1] = i; 
            }
            if(i<=12){
                months[i-1] = i;
            }
            years[i-1] = 2016+i;
            if(i<=23){
                hours[i-1] = i;
            }
            if(i<=59){
                minutes[i-1] = i;
            }
        }
        dayDate = new JComboBox(days);
        monthDate = new JComboBox(months);
        yearDate = new JComboBox(years);
        hourDate = new JComboBox(hours);
        minuteDate = new JComboBox(minutes);
        
        JPanel dateLine = new JPanel();
        date = new JLabel("Date: ");
        
        dateLine.add(date);
        dateLine.add(dayDate);
        dateLine.add(monthDate);
        dateLine.add(yearDate);
        ////////////////////////////////////////////////////////////////////////
        JPanel timeLine = new JPanel();
        JLabel time = new JLabel("Time: ");
        timeLine.add(time);
        timeLine.add(hourDate);
        timeLine.add(minuteDate);
        ////////////////////////////////////////////////////////////////////////
        JPanel contentLine = new JPanel();
        content = new JLabel("Content: ");
        textContent = new JTextArea(5,15);
        
        contentLine.add(content);
        contentLine.add(textContent);
        ////////////////////////////////////////////////////////////////////////
        JPanel buttonLine = new JPanel();
        exit = new JButton("Exit");
        save = new JButton("Save");
        exit.addActionListener(this);
        save.addActionListener(this);
        buttonLine.add(exit);
        buttonLine.add(save);
        ////////////////////////////////////////////////////////////////////////
           
        add(logo);
        add(titleLine);
        add(dateLine);
        add(timeLine);
        add(contentLine);
        add(buttonLine);
        
        setSize(300,400);
        ////////////////////////////////////////////////////////////////////////
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        float screenHeight = screenSize.height;
        float screenWidth = screenSize.width;
        setLocation((int)(screenWidth / 2.2), (int)(screenHeight / 3.5));
        ////////////////////////////////////////////////////////////////////////
        setResizable(false);
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent event){
        Object source = event.getSource();
        
        if(source == save){
            this.dispose();
        }
        if(source == exit){
            this.dispose();
        }
    }
}