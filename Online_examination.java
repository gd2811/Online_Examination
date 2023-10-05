import javax.swing.*;
import java.awt.event.*;
import java.awt.*;     
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;



public class exam_login
{
   public static int c=0;
   public static void main(String[] args) {
   JFrame frame=new JFrame("LOGIN PAGE");
   final JLabel label = new JLabel();
   label.setBounds(20,150, 200,50);
   final JPasswordField password = new JPasswordField();
   password.setBounds(100,75,100,30);
   JLabel lable1=new JLabel("Username:");
   lable1.setBounds(20,20, 80,30);
   JLabel lable2=new JLabel("Password:");
   lable2.setBounds(20,75, 80,30);
   JButton b = new JButton("Login");
   b.setBounds(100,120, 80,30);
   final JTextField text = new JTextField();
   text.setBounds(100,20, 100,30);
   frame.add(password); frame.add(lable1); frame.add(label); frame.add(lable2); frame.add(b); frame.add(text);
   frame.setSize(300,300);
   frame.setLayout(null);
   frame.setVisible(true);
   b.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e)
   {
      
      String data,x=text.getText();
      data=( !(x).isEmpty() && !(new String(password.getPassword())).isEmpty() ) ? ("sucessfully registered "+x):("");
      
      String command = e.getActionCommand();
      if(command=="Login" && !data.isEmpty())
      {     

        new OnlineTest("Online Test Of Java");
      }
      else{label.setText("*Enter valid login credentials*");}
   }});

}
}

class OnlineTest extends JFrame implements ActionListener  
{  
    JLabel l,time;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2;  
    ButtonGroup bg; 
    private Timer timer;
    private int timeRemaining = 60; 
    private long startTime;
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    OnlineTest(String s)  
    {  
        super(s);  
        l=new JLabel();  
        add(l);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton(); 
            add(jb[i]);  
            bg.add(jb[i]);  
        } 
        b1=new JButton("Next");  
        b2=new JButton(""); 
        b1.addActionListener(this);  
        b2.addActionListener(this); 
        //timer
        time = new JLabel("");
        time.setFont(new Font("Segoe UI Historic", Font.BOLD, 20));
        time.setBounds(478, 10, 181, 27);

        add(time);add(b1);
        add(b2);
        set();  
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(250,100);  
        setVisible(true);  
        setSize(600,350);
        startTimer();

     }  



    public void actionPerformed(ActionEvent e)  
    {  
            
                
                if(e.getSource()==b1 )  
                {  
                    if(check())  
                        count=count+1;  
                    current++;  
                    set();  
                
                    if(current==9)  
                    {  
                        timer.stop();
                    //b1.setEnabled(false);
                    b1.setText("logout");  
                    b2.setText("Result");  
                    
                    }  
                }  

        
      
        if(e.getActionCommand().equals("Result") )  
        {  
            if(check())  
                count=count+1;  
            current++;  
            System.out.println("correct ans="+count);  
            JOptionPane.showMessageDialog(this,"correct ans="+count);  
            
        }  
        if(e.getActionCommand().equals("logout"))
        {
            System.exit(0);  
        }
        
        
    
    }
    public void startTimer() {
        startTime = System.currentTimeMillis();
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timeRemaining--;
                time.setText("Time Left: " +timeRemaining + "sec");
                if (timeRemaining == 0) {
                    timer.stop();
                    //b1.setEnabled(false);  
                    b1.setText("logout");
                    b2.setText("Result");

                }
            }
        });
        timer.start();
        
    }
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Quesion1:Number of primitive data types in Java are?");  
            jb[0].setText("6");jb[1].setText("7");jb[2].setText("8");jb[3].setText("9");   
        }  
        if(current==1)  
        {  
            l.setText("Question2: Automatic type conversion is possible in which of the possible cases?");  
            jb[0].setText("Byte to Int");jb[1].setText("Int to long");jb[2].setText("long to int");jb[3].setText("Short to int");  
        }  
        if(current==2)  
        {  
            l.setText("Question3:Select the valid statement.");  
            jb[0].setText("char[] ch=new char(5)");jb[1].setText("char[] ch=new char[5]");jb[2].setText("char[] ch=new char()");jb[3].setText("char[] ch=new char[]");  
        }  
        if(current==3)  
        {  
            l.setText("Question4:When an array is passed to a method, what does the method receive?");  
            jb[0].setText("The reference of the Array");jb[1].setText("The copy of the array");jb[2].setText("Length of the array");jb[3].setText("Copy of first element");  
        }  
        if(current==4)  
        {  
            l.setText("Question5:When is the object created with new keyword?");  
            jb[0].setText("At runtime");jb[1].setText("At compiletime");jb[2].setText("depends on the code");jb[3].setText("none");  
        }  
        if(current==5)  
        {  
            l.setText("Question6:To which of the following does the class string belong to. ");  
            jb[0].setText("java.lang");jb[1].setText("java.awt");jb[2].setText("java.applet");jb[3].setText("java.String");  
        }  
        if(current==6)  
        {  
            l.setText("Question7:Output of Math.floor(3.6)?");  
            jb[0].setText("3");jb[1].setText("3.0");jb[2].setText("4");  
                        jb[3].setText("4.0");  
        }  
        if(current==7)  
        {  
            l.setText("Question8: When is the finalize() method called? ");  
            jb[0].setText("Before garbage collection");jb[1].setText("Before an object goes out of scope");jb[2].setText("before a variable goes out of scope");  
                        jb[3].setText("None");         
        }  
        if(current==8)  
        {  
            l.setText("Question9: Identify the infinite loop.");  
            jb[0].setText("for(;;)");jb[1].setText("for(int i=0;i<1;i--)");jb[2].setText("for(int i=0;;i++)");jb[3].setText("All of the above");  
        }  
        if(current==9)  
        {  
            l.setText("Question10: Which of the following exception is thrown when divided by zero statement is executed?");  
            jb[0].setText("NullPointerexception");jb[1].setText("NumberFormatException");jb[2].setText("ArithmeticException");  
                        jb[3].setText("None");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[2].isSelected());  
        if(current==1)  
            return(jb[1].isSelected());  
        if(current==2)  
            return(jb[1].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[0].isSelected());  
        if(current==5)  
            return(jb[0].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[0].isSelected());  
        if(current==8)  
            return(jb[3].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    }  
       
      
}
