package OnTime;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class License extends JFrame implements ActionListener {
    
    JButton exit;
    JTextArea license;
    //licencja odczytywana z pliku
    
    public License(){
        super("License");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        license = new JTextArea(licenseContent);
        license.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(license);
        license.setEditable(false);
        license.setFont(new Font("Arial",Font.PLAIN,18));
        
        exit = new JButton("Exit");
        exit.addActionListener(this);
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        float screenHeight = screenSize.height;
        float screenWidth = screenSize.width;
        setLocation((int)(screenWidth / 2.9), (int)(screenHeight / 3.8));
        
        add(scroll,BorderLayout.CENTER);
        add(exit, BorderLayout.SOUTH);
        setSize(800,700);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event){
        Object source = event.getSource();
        if(source == exit) this.setVisible(false);
    }
    
    //CAŁKOWICIE PRZYPADKOWA LICENCJA   
   String licenseContent = "empty";
}