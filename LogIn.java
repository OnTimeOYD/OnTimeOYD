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


public class LogIn extends JFrame implements ActionListener{
    JLabel nameJLabel, passwordJLabel;
    JPanel nameJPanel, passwordJPanel,buttonJPanel,holder;
    JButton register,logIn;
    JTextField name;
    JPasswordField password;
    String usernameString, passString, correctPass;
    
    static Toolkit TK = Toolkit.getDefaultToolkit();
    static Dimension SCREEN_SIZE = TK.getScreenSize();
    public float screenHeight = SCREEN_SIZE.height;
    public float screenWidth = SCREEN_SIZE.width;
    
    public LogIn(){
        super("Log In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        holder = new JPanel();
        holder.setLayout(new BoxLayout(holder, BoxLayout.Y_AXIS));
        nameJPanel = new JPanel();
        nameJPanel.setLayout(new BoxLayout(nameJPanel, BoxLayout.Y_AXIS));
        nameJLabel = new JLabel("Username:");
        name = new JTextField(20);
        nameJPanel.add(nameJLabel);
        nameJPanel.add(name);
        
        passwordJPanel = new JPanel();
        passwordJPanel.setLayout(new BoxLayout(passwordJPanel, BoxLayout.Y_AXIS));
        passwordJLabel = new JLabel("Password:");
        password = new JPasswordField(20);
        passwordJPanel.add(passwordJLabel);
        passwordJPanel.add(password);
        
        buttonJPanel = new JPanel();
        register = new JButton("Register");
        logIn = new JButton("Log In");
        register.addActionListener(this);
        logIn.addActionListener(this);
        buttonJPanel.add(register);
        buttonJPanel.add(logIn);
        
        
        holder.add(nameJPanel);
        holder.add(passwordJPanel);
        holder.add(buttonJPanel);
        add(holder);
        setLookAndFeel();
        setResizable(false);
        setLocation((int)(screenWidth / 2.2), (int)(screenHeight / 2.5));
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        Object source = event.getSource();
        if(source == logIn){
            if(!(name.getText().equals(null) || name.getText().equals("") ||
                    password.getText().equals(null) || password.getText().equals(""))){
                DataBase db = new DataBase();
                usernameString = name.getText();
                passString = DataBase.GET_HASH(password.getText().getBytes(), "SHA-512");
                DataBase.SELECT_STATEMENT("SELECT * FROM USERS WHERE username='"+usernameString+"'");
                correctPass = DataBase.PASSWORD;
    //            System.err.println(passString);
    //            System.err.println(correctPass);
                if(correctPass.equals(passString)){
                    System.out.println("CONNECTED!");
                    mp = new MainApp();
                    mp.setMinimumSize(new Dimension(800, 500)); 
                }else{
                    System.out.println("ERROR!");
                }
            }
        }
        if(source == register){
            this.dispose();
            new Register();
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