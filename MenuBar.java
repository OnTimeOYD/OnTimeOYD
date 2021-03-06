package OnTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuBar extends JPanel implements ActionListener,MouseListener{
     JMenuBar menubar = new JMenuBar();
     JMenuItem neew,edit,load,save,share,delete,
               style,options,instruction,license,
               authors,exit;
     JMenu bug;
     ImageIcon newFile = new ImageIcon("new.gif");
     ImageIcon shareFile = new ImageIcon("share.gif");  
     ImageIcon editFile = new ImageIcon("edit.gif");     
             
    public MenuBar(){
       /////////////////////////////////////////////
       JMenu file = new JMenu("File");
       neew = new JMenuItem("New", newFile);
       edit = new JMenuItem("Edit",editFile);
       exit = new JMenuItem("Exit");
       edit.setAccelerator(KeyStroke.getKeyStroke
        ('E', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
       neew.setAccelerator(KeyStroke.getKeyStroke
        ('N', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));  
       exit.setAccelerator(KeyStroke.getKeyStroke
        ('Q', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask())); 
       share = new JMenuItem("Share",shareFile);
      
       neew.addActionListener(this);
       edit.addActionListener(this);
       exit.addActionListener(this);
       file.add(neew);
       file.add(edit);
       file.addSeparator();
       file.add(share);
       file.add(exit);
       /////////////////////////////////////////////
       JMenu tools = new JMenu("Tools");
       style = new JMenuItem("Style");
       options = new JMenuItem("Options");
       
       tools.add(style);
       tools.addSeparator();
       tools.add(options);
       /////////////////////////////////////////////
       JMenu help = new JMenu("Help");
       authors = new JMenuItem("Authors");
       instruction = new JMenuItem("Instruction");
       license = new JMenuItem("License");
       authors.addActionListener(this);
       license.addActionListener(this);
       instruction.addActionListener(this);
       
       help.add(instruction);
       help.addSeparator();
       help.add(license);
       help.add(authors);
       /////////////////////////////////////////////
       JMenu sync = new JMenu("Sync");
       //...
       /////////////////////////////////////////////
       bug = new JMenu("Report a bug");
       bug.addMouseListener(this);
       /////////////////////////////////////////////
       menubar.add(file);
       menubar.add(tools);
       menubar.add(help);
       menubar.add(sync);
       menubar.add(bug);
       }
    
    
    
    public void actionPerformed(ActionEvent event){
        Object source = event.getSource();
        
        if(source == neew){
            NewFile.DAY = 0;
            NewFile.MONTH = 0;
            NewFile.YEAR = 0;
            new NewFile();
        }
        if(source == edit)new Editor();
        if(source == authors)new Authors();
        if(source == license)new License();
        if(source == instruction)new Instruction();
        if(source == exit) System.exit(0);
    }
    
    public void mouseClicked(MouseEvent event){
        Object source = event.getSource();
        
        if(source == bug)new BugReport();
    }
    public void mouseEntered(MouseEvent event){}
    public void mouseExited(MouseEvent event){}
    public void mousePressed(MouseEvent event){}
    public void mouseReleased(MouseEvent event){}   
}