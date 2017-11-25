package OnTime;

import static OnTime.MainApp.mp;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


public class Register extends JFrame implements ActionListener{
    JLabel username, password, passwordConfirm, name, surname;
    JTextField usernameJText, nameJText, surnJText;
    JButton confirm, cancel;
    JPanel holder,nameJPanel,passwordJPanel,usernameJPanel,surnameJPanel,buttonJPanel;
    JPasswordField passwordField, passwordConfField;
    String passHash, passConfHash;
    
    static Toolkit TK = Toolkit.getDefaultToolkit();
    static Dimension SCREEN_SIZE = TK.getScreenSize();
    public float screenHeight = SCREEN_SIZE.height;
    public float screenWidth = SCREEN_SIZE.width;
    
    
    public Register(){
        super("Register");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        holder = new JPanel();
        holder.setLayout(new BoxLayout(holder, BoxLayout.Y_AXIS));
        
        usernameJPanel = new JPanel();
        usernameJPanel.setLayout(new BoxLayout(usernameJPanel, BoxLayout.Y_AXIS));
        username = new JLabel("Username:");
        usernameJText = new JTextField(20);
        usernameJPanel.add(username);
        usernameJPanel.add(usernameJText);
        
        passwordJPanel = new JPanel();
        passwordJPanel.setLayout(new BoxLayout(passwordJPanel, BoxLayout.Y_AXIS));
        password = new JLabel("Password: (max 20)");
        passwordField = new JPasswordField(20);
        passwordConfirm = new JLabel("Confirm password:");
        passwordConfField = new JPasswordField(20);
        passwordJPanel.add(password);
        passwordJPanel.add(passwordField);
        passwordJPanel.add(passwordConfirm);
        passwordJPanel.add(passwordConfField);
        
        nameJPanel = new JPanel();
        nameJPanel.setLayout(new BoxLayout(nameJPanel, BoxLayout.Y_AXIS));
        name = new JLabel("Name:");
        nameJText = new JTextField(20);
        nameJPanel.add(name);
        nameJPanel.add(nameJText);
        
        surnameJPanel = new JPanel();
        surnameJPanel.setLayout(new BoxLayout(surnameJPanel, BoxLayout.Y_AXIS));
        surname = new JLabel("Surname:");
        surnJText = new JTextField(20);
        surnameJPanel.add(surname);
        surnameJPanel.add(surnJText);
       
        buttonJPanel = new JPanel();
        cancel = new JButton("Cancel");
        confirm = new JButton("Confirm");
        cancel.addActionListener(this);
        confirm.addActionListener(this);
        buttonJPanel.add(cancel);
        buttonJPanel.add(confirm);
        
        holder.add(usernameJPanel);
        holder.add(passwordJPanel);
        holder.add(nameJPanel);
        holder.add(surnameJPanel);
        holder.add(buttonJPanel);
        
        add(holder);
        setLookAndFeel();
        setLocation((int)(screenWidth / 2.25), (int)(screenHeight / 2.5));
        setMinimumSize(new Dimension(300, 10));
        pack();
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if(source == confirm){
            DataBase db = new DataBase();
            passHash = DataBase.GET_HASH(passwordField.getText().getBytes(), "SHA-512");
            passConfHash = DataBase.GET_HASH(passwordConfField.getText().getBytes(), "SHA-512");
            
            if(passHash.equals(passConfHash)){
                DataBase.ADD_STATEMENT(username.getText(), nameJText.getText(),
                        surnJText.getText(), "USERS", passConfHash);
                this.dispose();
                new LogIn();
            }        
        }
        if(source == cancel){
            System.exit(0);
        }
    }
        
    public void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"
            );
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.err.println("Nie potrafię wczytać systemowego wyglądu: " 
                    + e.getMessage());
        }
    }
}