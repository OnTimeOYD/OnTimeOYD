package OnTime;
//blabla
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Editor extends JFrame implements ActionListener{
    private JPanel editorPanel;
    private static DefaultListModel EDIT_LIST_MODEL;
    private static JList EDIT_LIST;
    private JLabel editLabel;
    private JButton chooseButton;
    
    
    static Toolkit TK = Toolkit.getDefaultToolkit();
    static Dimension SCREEN_SIZE = TK.getScreenSize();
    public float screenHeight = SCREEN_SIZE.height;
    public float screenWidth = SCREEN_SIZE.width;
    
    public Editor(){
        super("Edit event");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editorPanel = new JPanel();
        editorPanel.setLayout(new BorderLayout());
        editLabel = new JLabel("Choose event:");
        //editLabel.setAlignmentX(TOP_ALIGNMENT);    trzeba wysrodkowac
        chooseButton = new JButton("Choose");
        chooseButton.addActionListener(this);
        ADD_LIST();
        JScrollPane scroller = new JScrollPane(EDIT_LIST);
        EDIT_LIST.setVisibleRowCount(7);
        
        setLocation((int)(screenWidth / 2.9), (int)(screenHeight / 3.8));
               
        add(editLabel, BorderLayout.NORTH);
        editorPanel.add(scroller);
        add(editorPanel, BorderLayout.CENTER);
        add(chooseButton, BorderLayout.SOUTH);
       
        
        setSize(500,300);
        setVisible(true);
        //setIconImage(MainApp.img);
    }
    
    public Editor(int day, int month, int year){
        super("Edit event");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editorPanel = new JPanel();
        editorPanel.setLayout(new BorderLayout());
        editLabel = new JLabel("Choose event:");
        //editLabel.setAlignmentX(TOP_ALIGNMENT);    trzeba wysrodkowac
        chooseButton = new JButton("Choose");
        chooseButton.addActionListener(this);
        Editor.this.ADD_LIST(day, month, year);
        JScrollPane scroller = new JScrollPane(EDIT_LIST);
        //editList.setVisibleRowCount(7); 

        setLocation((int)(screenWidth / 2.9), (int)(screenHeight / 3.8));
        
        add(editLabel, BorderLayout.NORTH);
        editorPanel.add(scroller);
        add(editorPanel, BorderLayout.CENTER);
        add(chooseButton, BorderLayout.SOUTH);
       
        
        setSize(500,300);
        setVisible(true);
        //setIconImage(MainApp.img);
    }
    
    public static void ADD_LIST(){
        EDIT_LIST_MODEL = new DefaultListModel();
        for(int i = 0; i < File.TABLE_LENGTH(); i++){
            EDIT_LIST_MODEL.addElement(INSERT(File.GET_DAY(i),
                           File.GET_MONTH(i),
                           File.GET_YEAR(i),
                           File.GET_HOUR(i),
                           File.GET_MINUTE(i),
                           File.GET_TITLE(i)));
        }
        EDIT_LIST = new JList(EDIT_LIST_MODEL);
        EDIT_LIST.setFont(new Font("Courier New", Font.PLAIN, 14));
    }
    
    public static void ADD_LIST(int day, int month, int year){
        EDIT_LIST_MODEL = new DefaultListModel();
        for(int i = 0; i < File.TABLE_LENGTH(); i++){
            if(File.GET_DAY(i) == day && File.GET_MONTH(i)== month&&
                                File.GET_YEAR(i) == year){
            EDIT_LIST_MODEL.addElement(INSERT(day,
                           month,
                           year,
                           File.GET_HOUR(i),
                           File.GET_MINUTE(i),
                           File.GET_TITLE(i)));
            }
        }
        EDIT_LIST = new JList(EDIT_LIST_MODEL);
        
        EDIT_LIST.setFont(new Font("Courier New", Font.PLAIN, 14));
    }
    
    public static int SAME_DATE_LIST_COUNTER(int day, int month, int year) {
        ADD_LIST(day, month, year);
        return EDIT_LIST_MODEL.getSize();
    }
    
    public static String INSERT(int day, int month, int year, 
                                int hour, int minute, String title) {
        String textLabel = "";
        
        if(day < 10){
                textLabel = "0"+day;
            } else {
                textLabel = ""+day;
            }
            if(month<10){
                textLabel += "-0"+month;
            } else{
                textLabel += "-"+month;
            }
            textLabel += "-"+year;
            if(hour <10){
                textLabel += "  0"+hour;
            } else {
                textLabel += "  "+hour;
            }
            if(minute<10){
                textLabel += ":0"+minute;
            } else {
                textLabel += ":"+minute;
            }
            textLabel += ", " + title;
        return textLabel;
    }
    
    public void actionPerformed(ActionEvent event){
        Object source = event.getSource();
        
        if(source == chooseButton){
            System.out.print(EDIT_LIST.getSelectedIndex());
            int index = EDIT_LIST.getSelectedIndex();
            if (index == -1){
               this.dispose(); 
            } else {
            MainApp.CC.setVisible(true);
            CenterContent.SET_LINE(index);
            this.setVisible(false);
            MainApp.REPAINT(0);
            this.dispose();
            }
        }
    }
}
