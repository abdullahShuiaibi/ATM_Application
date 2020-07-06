/**********************************************************
 * Date: 7/7/202                                          * 
 * Name: Abdullah Shuiaibi                                *
 * program: ATM Appliaction                               *
 * program purpose: This program is an ATM simulation.    * 
 * It lets the user create an account than the user       *
 * can log into use one of the many features.             *
 *                                                        *
 *********************************************************/




import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

public class ATM_code
{
 
 private static double last_deposit;
 private static double last_withdraw;
 private static String name;
 private static int saved_pin ;
 private static double saved_balance = 0;
 private static JButton button;
 private static JButton button1;
 private static JButton button2;
 private static JButton button3;
 private static JButton button4;
 private static JPanel panel;
 private static JLabel message;
 private static JLabel message2;
 private static JLabel message3;
 private static JLabel message4;
 private static JLabel message5;
 private static JLabel message6;
 private static JLabel message7;
 private static JLabel message8;
 private static JLabel message9;
 private static JLabel message10;
 private static JLabel message11;
 private static JLabel message12;
 private static JLabel message13;
 private static JLabel message14;
 private static JLabel message15;








 
 

 
 public static void main(String [] arg)
 { 
    startup_page();
  
 }
 
 
 
 public static void Withdrawl()
 {
  String with = JOptionPane.showInputDialog("Welcome to the withdraw page\nHere you can withdraw up to $2000\n\nHow much would you like to withdraw today: ","Enter amount");
  double with_amount = Double.parseDouble(with);
  int count = 1;
  while (with_amount > saved_balance )
  {  
     JOptionPane.showMessageDialog(null,"failed\nYou do not have enought funds to withdraw $"+with_amount+" Please try again");
     with = JOptionPane.showInputDialog("Welcome to the withdraw page\nHere you can withdraw up to $2000\n\nHow much would you like to withdraw today: ","Enter amount");
     with_amount = Double.parseDouble(with);
     count++;
      while (with_amount > 2000)
         {
            JOptionPane.showMessageDialog(null,"Failed\nAmount over the limited amount");
            with = JOptionPane.showInputDialog("Enter valid amount\n\nEnter amount: ","Enter amount");
            with_amount = Double.parseDouble(with);


         }

     if (count == 3)
     {
        JOptionPane.showMessageDialog(null,"failed\nYou do not have enought funds to withdraw $"+with_amount);
        JOptionPane.showMessageDialog(null,"Deposit First\nYou will be sent to the Deposit page\nAfter that you can withdrawl");
        Deposit();
        with = JOptionPane.showInputDialog("Welcome to the withdraw page\nHere you can withdraw up to $2000\n\nHow much would you like to withdraw today: ","Enter amount");
        with_amount = Double.parseDouble(with);
        


     }
     while (with_amount > 2000)
         {
            JOptionPane.showMessageDialog(null,"Failed\nAmount over the limited amount");
            with = JOptionPane.showInputDialog("Enter valid amount\n\nEnter amount: ","Enter amount");
            with_amount = Double.parseDouble(with);


         }

     
     
   }
  while (with_amount < 0)
  {
     
     JOptionPane.showMessageDialog(null,"Failed\nInvalid Amount");
     with = JOptionPane.showInputDialog("Welcome to the withdraw page\nHere you can withdraw up to $2000\n\nHow much would you like to withdraw today: ","Enter amount");
     with_amount = Double.parseDouble(with);
     
  }
 
  saved_balance = saved_balance - with_amount ;
  JOptionPane.showMessageDialog(null,"Sucessfull withdraw\nYou took out: $"+with_amount+"\n---------------------------------------------------\nYour balance: $"+saved_balance);
  last_withdraw = with_amount;
  
 
 
 
 }
 
 public static void Deposit()
 {
  String dep = JOptionPane.showInputDialog("Welcome to the deposit page\nHere you can deposit any amount you want\n\nHow much would youy like to deposit","Enter amount");
  double dep_amount = Double.parseDouble(dep);
 
  while(dep_amount < 0)
  {
   JOptionPane.showMessageDialog(null,"Failed\nInvalid Amount");
   dep = JOptionPane.showInputDialog("Welcome to the deposit page\nHere you can deposit any amount you want\n\nHow much would youy like to deposit","Enter amount");
   dep_amount = Double.parseDouble(dep);
   

  }
   saved_balance = saved_balance + dep_amount;
  JOptionPane.showMessageDialog(null,"Sucessfull Deposit\nYou deposited: $"+dep_amount+"\n---------------------------------------------------\nYour balance: $"+saved_balance);
  last_deposit = dep_amount;
 }
 
 
 
 
 public static void Balance()
 {
  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
  LocalDateTime now = LocalDateTime.now();  
  JOptionPane.showMessageDialog(null,"Helllo: "+name+"\nDate: "+dtf.format(now)+"\nBalance: $"+saved_balance+"\nLast Deposit: $"+last_deposit+"\nLast withdrawl: $"+last_withdraw+
  "\n\n-------------------------------------------\nFounder and ceo: Abdullah shuiaibi");
 
 }
 
 
 
 
 
 public static void Recipt()
 {
  int choice = JOptionPane.showConfirmDialog(null,"Would you like a recipt","Recipt",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
  if (choice == 0)
    {
      JOptionPane.showMessageDialog(null,"Name: "+name+"\nBalance: $"+saved_balance+"\n\nThank you for choosing Tron bank. We are thankfull for your service\n\nThank you ");
    }

 }
 
 
 
 
 
 public static String Valdate_pin(int pin)
 {
  String valid = "no";
  
  if (saved_pin == pin )
  {
   valid = "yes";
  }
  return valid ;
 }
 
 
 
 
 
 public static void menu()
 {
   
   JOptionPane.showMessageDialog(null,"Hello "+name+"\n\nWelcome to the menu page\nHere you can :\nDeposit\nWithdraw\nget the balance\n\nClick ok to see the options");
 
   {

   JFrame frame = new JFrame("Menu");
   
   message = new JLabel("");
     
   panel = new JPanel();
   
   Icon dep = new ImageIcon("depositPic.jpg");
   button1 = new JButton(dep);
   button1.setPreferredSize(new Dimension(400, 120));
   button1.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e)
      {  
           Deposit();  
      }  
         });    
  
   Icon with = new ImageIcon("withdrawPic.jpg");
   button2 = new JButton(with);
   button2.setPreferredSize(new Dimension(400, 120));
   button2.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e)
      {  
           Withdrawl();  
      }  
         });  
   
   
   Icon balance = new ImageIcon("balancePic.jpg");
   button3 = new JButton(balance);
   button3.setPreferredSize(new Dimension(400, 120));
   button3.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e)
      {  
           Balance();  
      }  
         });  
   
   Icon done = new ImageIcon("donePic.jpg");
   button4 = new JButton(done);
   button4.setPreferredSize(new Dimension(400, 120));
   button4.addActionListener(new ActionListener(){  
     public void actionPerformed(ActionEvent e)
      {  
           
           Recipt(); 
           JOptionPane.showMessageDialog(null,"GoodBy "+name);
           frame.dispose();
           startup_page();
           
            
      }  
         });  



   panel.add(message);
   panel.add(button1);
   panel.add(message);
   panel.add(button2);
   panel.add(message);
   panel.add(button3);
   panel.add(message);
   panel.add(button4);

   

   
   frame.add(panel);
   frame.setBackground(Color.YELLOW);
   frame.pack();
   
   frame.setVisible(true);
   frame.setSize(500,600);
   
   
  
   
 }
 
 
 }
 
 
 public static void new_user()
 {
   name = JOptionPane.showInputDialog("Enter your name: ");
   int pin1 = 0 , pin2 = 1;
   
   
    int length = String.valueOf(pin1).length();
    int length2 = String.valueOf(pin2).length();

    
  
     while(pin1 != pin2 || length != 4 && length2 !=4 )
     {
       String pin = JOptionPane.showInputDialog("Enter your pin [Must be 4 digits]: ");
       pin1 = Integer.parseInt(pin);
       String pinSecond = JOptionPane.showInputDialog("Enter your pin again [ Must match the first entry ]: ");
       pin2 = Integer.parseInt(pinSecond);
       length = String.valueOf(pin1).length();
       length2 = String.valueOf(pin2).length();
      }

    
    
   
   int choice = JOptionPane.showConfirmDialog(null,"Would you like to deposit any money today","User",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
   if (choice == 0)
    {
        String balance = JOptionPane.showInputDialog("How much would you like to deposit today: ");
        saved_balance = Double.parseDouble(balance);
    }
   saved_pin = pin1 ;
   JOptionPane.showMessageDialog(null,"You have successfuly created an account\nYour account balance is: $"+saved_balance+"\n\nThank you for working with tron bank"+
   "\n--------------------------------------------------------\nFounder and Ceo: Abdullah Shuiaibi");

 }
 public static void startup_page()
 {
  //JOptionPane.showMessageDialog(null,"\tWelcome to Tron Bank\n\nTron bank is the first commercial bank that does\n not deal in intrest. We have over 148 loactions in the united state\nand over 23,000 ATMs across america.\n\n---------------------------------------------------------------------------------\nFounder and CEO: Abdullah Shuiaibi");
   
   JFrame frame = new JFrame("Welcome to Tron Bank");
   
   message2 = new JLabel("                       Tron Bank                                          ");
   message3 = new JLabel("--------------------------------------------------------------------------");
   message4 = new JLabel("                  Welcome to Tron Bank                                    ");
   message4 = new JLabel("Tron bank is the first commercial bank that does\n not deal in            ");
   message5 = new JLabel("in intrest. We have over 148 loactions in the united state and            ");
   message6 = new JLabel("               over 23,000 ATMs across america.                           ");
   message7 = new JLabel("                                                                          ");
   message14 = new JLabel("                                                                         ");
   message15 = new JLabel("                                                                         ");
   message8 = new JLabel("          If you are new please creat an account                          ");
   message9 = new JLabel("          If you are a returning user just log in                         ");
   message10 = new JLabel("-------------------------------------------------------------------------");
   message11 = new JLabel("          Founder and ceo: Abdullah Shuiaibi                             ");
   message12 = new JLabel("                                                                         ");
   message13 = new JLabel(" All right resverd for Tron LLC and founder Abdullah Shuiaibi            ");
   
    



   




     
   panel = new JPanel();
   
   
   
   button = new JButton("Continue");
   button.setPreferredSize(new Dimension(200, 30));
   button.addActionListener(new ActionListener(){  
      public void actionPerformed(ActionEvent e)
      {  
            frame.dispose();
            ATM_main();
            
      }  
         });  
   
   panel.add(message2);
   panel.add(message3);
   panel.add(message3);
   panel.add(message4);
   panel.add(message5);
   panel.add(message6);
   panel.add(message7);
   panel.add(message8);
   panel.add(message9);
   panel.add(message14);
   panel.add(message15);
   panel.add(button);
   panel.add(message10);
   panel.add(message11);
   panel.add(message12);
   panel.add(message13);
   





   frame.add(panel);
   frame.setBackground(Color.RED);
   frame.pack();
   
   frame.setVisible(true);
   frame.setSize(400,400);
   
   
   


 }
 
 
 public static void ATM_main()
 {
    while(true)
  {
  
  int choice = JOptionPane.showConfirmDialog(null,"Are you a new user","User",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
  if (choice == 0)
    {
     new_user();
    }
    String user_pin = JOptionPane.showInputDialog("Please insert in your card\n\n\nPlease enter your pin: ");
    int pin = Integer.parseInt(user_pin);
    int pin_counter = 1 ;
    
    while(Valdate_pin(pin).equals("no") && pin_counter < 4 )
    {
       user_pin = JOptionPane.showInputDialog("Wrong pin\n\n\nPlease enter your pin: ");
       pin = Integer.parseInt(user_pin);
       pin_counter++;

    }
    if (pin_counter > 2)
    {
     JOptionPane.showMessageDialog(null,"You have enterd the wrong pin to many times\nPlease create an account if you have not done so\n\nIf it still does not work please contact "+
     "the bank\n\nPhone: 1-(919)-212-313");
     continue;
     
     
    }
    else
    {
     
     menu();
     break;
     

     
   }
   
   }
  


 }
 
 
 
}



