package Ticket_dbms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.mysql.cj.xdevapi.Statement;

public class ticket {
	 public static JFrame f,f1,f2;
	 public static JLabel jl2,jl3;
	 public static JTextField jt,jt18,jt1,jt2,jt3,jt4,jt5,jt6,jt7,jt8,jt9,jt10,jt11,jt12,jt13,jt14,jt15,jt16,jt17,jt19,jt20,jt21,jt22,jt23,jt24,jt25,jt26,jt27,jt28;
	 public static JPasswordField jp, jp1;
	 public static JButton jb, jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10,jb11,jb12,jb13,jb14;
	 static int flag18=0,flag=0,flag1=0,flag2=0,flag3=0,flag4=0,flag5=0,flag6=0,flag7=0,flag8=0,flag9=0,flag10=0,flag11=0,flag12=0,flag13=0,flag14=0,flag15=0,flag16=0,flag17=0,flag19=0,flag20=0,flag21=0,flag22=0,flag23,flag24,flag25=0,flag26=0,flag27=0,flag28=0,flag2a=0,flag2b=0;
	 @SuppressWarnings("rawtypes")
	public static JComboBox jcb;
	 static String user,pass,from,to,acc,train_no;
	 public static int amount_train, amount_train1,acc_amount,amounts;
	 public static JPanel panel, panel1, panel2,panel6,panel10,panel11,panel12;
	public static JDatePickerImpl datePicker;
	 public static void main(String[] args)
	 {
		 JPanel panel = new JPanel();
		 panel.setBackground(null);
		 panel.setBounds(50,50,600,600);
		 panel.setBorder(BorderFactory.createLineBorder(Color.black));
		 
		 JPanel panel1 = new JPanel();
		 panel1.setBackground(null);
		 panel1.setBounds(650,50,600,600);
		 panel1.setBorder(BorderFactory.createLineBorder(Color.black));
		 
		 JPanel panel2 = new JPanel();
		 panel2.setBackground(null);
		 panel2.setBounds(400,50,2,600);
		 panel2.setBorder(BorderFactory.createLineBorder(Color.black,3));
		 
		 JPanel panel3 = new JPanel();
		 panel3.setBackground(null);
		 panel3.setBounds(50,90,300,2);
		 panel3.setBorder(BorderFactory.createLineBorder(Color.blue,3));
		 
		 JPanel panel4 = new JPanel();
		 panel4.setBackground(null);
		 panel4.setBounds(50,505,300,2);
		 panel4.setBorder(BorderFactory.createLineBorder(Color.blue,3));
		 
		 JPanel panel5 = new JPanel();
		 panel5.setBackground(null);
		 panel5.setBounds(50,610,300,2);
		 panel5.setBorder(BorderFactory.createLineBorder(Color.blue,3));
		 
		 panel6 = new JPanel();
		 panel6.setBackground(null);
		 panel6.setBounds(415,120,355,300);
		 
		 JPanel panel7 = new JPanel();
		 panel7.setBackground(null);
		 panel7.setBounds(425,99,345,2);
		 panel7.setBorder(BorderFactory.createLineBorder(Color.blue,3));
		 
		 JPanel panel8 = new JPanel();
		 panel8.setBackground(null);
		 panel8.setBounds(50,220,300,2);
		 panel8.setBorder(BorderFactory.createLineBorder(Color.blue,3));
		 
		 JPanel panel9 = new JPanel();
		 panel9.setBackground(null);
		 panel9.setBounds(400,50,2,600);
		 panel9.setBorder(BorderFactory.createLineBorder(Color.black,3));
		 
		 panel10 = new JPanel();
		 panel10.setBackground(null);
		 panel10.setBounds(415,120,355,300);

		 JPanel panel11 = new JPanel();
		 panel11.setBackground(null);
		 panel11.setBounds(30,115,350,2);
		 panel11.setBorder(BorderFactory.createLineBorder(Color.blue,3));
		 panel11.setVisible(false);
		 
		 panel12 = new JPanel();
		 panel12.setBackground(null);
		 panel12.setBounds(30,410,350,2);
		 panel12.setBorder(BorderFactory.createLineBorder(Color.blue,3));
		 panel12.setVisible(false);
		 
		 f = new JFrame("Ticket Reservation Counter");
	     f.setSize(1920,1080);
	     f.setLayout(null);
	     
	     f1 = new JFrame("Book Tickets");
	     f1.setSize(800,800);
	     f1.setLayout(null);
	     
	     f2 = new JFrame("Admin Login");
	     f2.setSize(800,800);
	     f2.setLayout(null);
	     
	     Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	     //f.setLocation(1920/2-f.getSize().width/2, 1000/2-f.getSize().height/2);
	     f1.setLocation(dim.width/2-f1.getSize().width/2, dim.height/2-f1.getSize().height/2);
	     f2.setLocation(dim.width/2-f2.getSize().width/2, dim.height/2-f2.getSize().height/2);

	          
	     jt = new JTextField("Username");
	     jt.setBounds(245,350,200,40);
	     jt.setForeground(Color.gray);
	     f.add(jt);
	     UserHandler user= new UserHandler();
	     jt.addKeyListener(user);
	     
	     jt1 = new JTextField("Username");
	     jt1.setBounds(845,150,200,40);
	     jt1.setForeground(Color.gray);
	     f.add(jt1);
	     User1Handler user1= new User1Handler();
	     jt1.addKeyListener(user1);
	     
	     jt2 = new JTextField("New Password");
	     jt2.setBounds(845,220,200,40);
	     jt2.setForeground(Color.gray);
	     f.add(jt2);
	     User2Handler user2= new User2Handler();
	     jt2.addKeyListener(user2);
	     
	     jt3 = new JTextField("Aadhar Number");
	     jt3.setBounds(845,290,200,40);
	     jt3.setForeground(Color.gray);
	     f.add(jt3);
	     User3Handler user3= new User3Handler();
	     jt3.addKeyListener(user3);
	     
	     jt4 = new JTextField("Bank A/c Number");
	     jt4.setBounds(845,360,200,40);
	     jt4.setForeground(Color.gray);
	     f.add(jt4);
	     User4Handler user4= new User4Handler();
	     jt4.addKeyListener(user4);
	     
	     jt5 = new JTextField("Initial Amount");
	     jt5.setBounds(845,430,200,40);
	     jt5.setForeground(Color.gray);
	     f.add(jt5);
	     User5Handler user5= new User5Handler();
	     jt5.addKeyListener(user5);
	     
	     jt6 = new JTextField("From Place");
	     jt6.setBounds(50,120,140,30);
	     jt6.setForeground(Color.gray);
	     f1.add(jt6);
	     User6Handler user6= new User6Handler();
	     jt6.addKeyListener(user6);
	     
	     jt7 = new JTextField("To Place");
	     jt7.setBounds(210,120,140,30);
	     jt7.setForeground(Color.gray);
	     f1.add(jt7);
	     User7Handler user7= new User7Handler();
	     jt7.addKeyListener(user7);
	     
	     jt8 = new JTextField("Passenger 1");
	     jt8.setBounds(100,305,150,30);
	     jt8.setForeground(Color.gray);
	     f1.add(jt8);
	     User8Handler user8= new User8Handler();
	     jt8.addKeyListener(user8);
	     
	     jt9 = new JTextField("Age");
	     jt9.setBounds(270,305,30,30);
	     jt9.setForeground(Color.gray);
	     f1.add(jt9);
	     User9Handler user9= new User9Handler();
	     jt9.addKeyListener(user9);
	     
	     jt10 = new JTextField("Passenger 2");
	     jt10.setBounds(100,355,150,30);
	     jt10.setForeground(Color.gray);
	     f1.add(jt10);
	     User10Handler user10= new User10Handler();
	     jt10.addKeyListener(user10);
	     jt10.setVisible(false);
	     
	     jt11 = new JTextField("Passenger 3");
	     jt11.setBounds(100,405,150,30);
	     jt11.setForeground(Color.gray);
	     f1.add(jt11);
	     User11Handler user11= new User11Handler();
	     jt11.addKeyListener(user11);
	     jt11.setVisible(false);
	     
	     jt12 = new JTextField("Passenger 4");
	     jt12.setBounds(100,455,150,30);
	     jt12.setForeground(Color.gray);
	     f1.add(jt12);
	     User12Handler user12= new User12Handler();
	     jt12.addKeyListener(user12);
	     jt12.setVisible(false);
	     
	     jt13 = new JTextField("Age");
	     jt13.setBounds(270,355,30,30);
	     jt13.setForeground(Color.gray);
	     f1.add(jt13);
	     User13Handler user13= new User13Handler();
	     jt13.addKeyListener(user13);
	     jt13.setVisible(false);
	     
	     jt14 = new JTextField("Age");
	     jt14.setBounds(270,405,30,30);
	     jt14.setForeground(Color.gray);
	     f1.add(jt14);
	     User14Handler user14= new User14Handler();
	     jt14.addKeyListener(user14);
	     jt14.setVisible(false);
	     
	     jt15 = new JTextField("Age");
	     jt15.setBounds(270,455,30,30);
	     jt15.setForeground(Color.gray);
	     f1.add(jt15);
	     User15Handler user15= new User15Handler();
	     jt15.addKeyListener(user15);
	     jt15.setVisible(false);
	     
	     jt16 = new JTextField("Account Number");
	     jt16.setBounds(100,520,200,30);
	     jt16.setForeground(Color.gray);
	     f1.add(jt16);
	     User16Handler user16= new User16Handler();
	     jt16.addKeyListener(user16);
	     
	     jt17 = new JTextField("Amount");
	     jt17.setBounds(100,570,200,30);
	     jt17.setEditable(false);
	     jt17.setForeground(Color.black);
	     f1.add(jt17);
	     User17Handler user17= new User17Handler();
	     jt17.addKeyListener(user17);
	     
	     jt18 = new JTextField("");
	     jt18.setBounds(510,650,150,30);
	     jt18.setEditable(false);
	     jt18.setForeground(Color.black);
	     f1.add(jt18);
	     User18Handler user18= new User18Handler();
	     jt18.addKeyListener(user18);
	     
	     jt19 = new JTextField("Enter Ticket No.");
	     jt19.setBounds(435,450,150,30);
	     jt19.setForeground(Color.black);
	     f1.add(jt19);
	     User19Handler user19= new User19Handler();
	     jt19.addKeyListener(user19);
	     
	     jt20 = new JTextField("Admin Username");
	     jt20.setBounds(100,350,200,40);
	     jt20.setForeground(Color.gray);
	     f2.add(jt20);
	     User20Handler user20= new User20Handler();
	     jt20.addKeyListener(user20);
	     
	     jt21 = new JTextField("From Place");
	     jt21.setBounds(70,140,130,30);
	     jt21.setForeground(Color.gray);
	     f2.add(jt21);
	     User21Handler user21= new User21Handler();
	     jt21.addKeyListener(user21);
	     jt21.setVisible(false);
	     
	     jt22 = new JTextField("To Place");
	     jt22.setBounds(210,140,130,30);
	     jt22.setForeground(Color.gray);
	     f2.add(jt22);
	     User22Handler user22= new User22Handler();
	     jt22.addKeyListener(user22);
	     jt22.setVisible(false);
	     
	     jt23 = new JTextField("Train Number");
	     jt23.setBounds(70,190,130,30);
	     jt23.setForeground(Color.gray);
	     f2.add(jt23);
	     User23Handler user23= new User23Handler();
	     jt23.addKeyListener(user23);
	     jt23.setVisible(false);
	     
	     jt24 = new JTextField("Current Status");
	     jt24.setBounds(210,190,130,30);
	     jt24.setForeground(Color.gray);
	     f2.add(jt24);
	     User24Handler user24= new User24Handler();
	     jt24.addKeyListener(user24);
	     jt24.setVisible(false);
	     
	     jt25 = new JTextField("Days For-eg(Mon,Tue,Wed,Thu,Fri,Sat)");
	     jt25.setBounds(100,240,210,30);
	     jt25.setForeground(Color.gray);
	     f2.add(jt25);
	     User25Handler user25= new User25Handler();
	     jt25.addKeyListener(user25);
	     jt25.setVisible(false);
	     
	     jt26 = new JTextField("Amount");
	     jt26.setBounds(70,290,130,30);
	     jt26.setForeground(Color.gray);
	     f2.add(jt26);
	     User26Handler user26= new User26Handler();
	     jt26.addKeyListener(user26);
	     jt26.setVisible(false);
	     
	     jt27 = new JTextField("Enter Train No.");
	     jt27.setBounds(70,420,130,30);
	     jt27.setForeground(Color.gray);
	     f2.add(jt27);
	     User27Handler user27= new User27Handler();
	     jt27.addKeyListener(user27);
	     jt27.setVisible(false);
	     
	     /*jt20 = new JTextField("Admin Username");
	     jt20.setBounds(100,350,200,40);
	     jt20.setForeground(Color.gray);
	     f2.add(jt20);
	     User20Handler user20= new User20Handler();
	     jt20.addKeyListener(user20);
	     
	     jt20 = new JTextField("Admin Username");
	     jt20.setBounds(100,350,200,40);
	     jt20.setForeground(Color.gray);
	     f2.add(jt20);
	     User20Handler user20= new User20Handler();
	     jt20.addKeyListener(user20);
	     */
	     jp = new JPasswordField("Password");
	     jp.setBounds(245,400,200,40);
	     jp.setForeground(Color.gray);
	     f.add(jp);
	     PassHandler pass= new PassHandler();
	     jp.addKeyListener(pass);
	     
	     jp1 = new JPasswordField("Password");
	     jp1.setBounds(100,405,200,40);
	     jp1.setForeground(Color.gray);
	     f2.add(jp1);
	     Pass1Handler pass1= new Pass1Handler();
	     jp1.addKeyListener(pass1);
	     
	     jb= new JButton("Login");
	     jb.setBounds(290,460,100,30);
	     jb.setBackground(new java.awt.Color(107, 210, 129));
	     LoginHandler log = new LoginHandler();
	     jb.addActionListener(log);
	     f.add(jb);
	     
	     jb1= new JButton("Sign Up");
	     jb1.setBounds(890,490,100,30);
	     jb1.setBackground(new java.awt.Color(107, 210, 129));
	     LoginHandler1 log1 = new LoginHandler1();
	     jb1.addActionListener(log1);
	     f.add(jb1);
	     
	     jb2= new JButton("Book Ticket");
	     jb2.setBounds(130,630,130,30);
	     jb2.setBackground(new java.awt.Color(107, 210, 129));
	     LoginHandler2 log2 = new LoginHandler2();
	     jb2.addActionListener(log2);
	     f1.add(jb2);
	     
	     jb3= new JButton("+");
	     jb3.setBounds(310,305,50,30);
	     LoginHandler3 log3 = new LoginHandler3();
	     jb3.addActionListener(log3);
	     f1.add(jb3);
	     
	     jb4= new JButton("+");
	     jb4.setBounds(310,355,50,30);
	     jb4.setVisible(false);
	     LoginHandler4 log4 = new LoginHandler4();
	     jb4.addActionListener(log4);
	     f1.add(jb4);
	     
	     jb5= new JButton("+");
	     jb5.setBounds(310,405,50,30);
	     jb5.setVisible(false);
	     LoginHandler5 log5 = new LoginHandler5();
	     jb5.addActionListener(log5);
	     f1.add(jb5);
	     
	     
	     jb6= new JButton("Search");
	     jb6.setBounds(230,170,100,30);
	     jb6.setBackground(new java.awt.Color(107, 210, 129));
	     LoginHandler6 log6 = new LoginHandler6();
	     jb6.addActionListener(log6);
	     f1.add(jb6);
	     
	     jb7= new JButton("Logout");
	     jb7.setBounds(650,20,100,20);
	     jb7.setBackground(new java.awt.Color(107, 210, 129));
	     LoginHandler7 log7 = new LoginHandler7();
	     jb7.addActionListener(log7);
	     f1.add(jb7);
	     
	     jb8= new JButton("View Current Balance");
	     jb8.setBounds(460,600,250,30);
	     jb8.setBackground(new java.awt.Color(107, 210, 129));
	     LoginHandler8 log8 = new LoginHandler8();
	     jb8.addActionListener(log8);
	     f1.add(jb8);
	     
	     jb9= new JButton("Cancel Ticket");
	     jb9.setBounds(590,450,150,30);
	     jb9.setBackground(new java.awt.Color(107, 210, 129));
	     LoginHandler9 log9 = new LoginHandler9();
	     jb9.addActionListener(log9);
	     f1.add(jb9);
	     
	     jb10= new JButton("Admin Login");
	     jb10.setBounds(485,60,120,30);
	     jb10.setBackground(new java.awt.Color(107, 210, 129));
	     LoginHandler10 log10 = new LoginHandler10();
	     jb10.addActionListener(log10);
	     f.add(jb10);
	     
	     jb11= new JButton("Login");
	     jb11.setBounds(140,465,120,30);
	     jb11.setBackground(new java.awt.Color(107, 210, 129));
	     LoginHandler11 log11 = new LoginHandler11();
	     jb11.addActionListener(log11);
	     f2.add(jb11);
	     
	     jb12= new JButton("Go");
	     jb12.setBounds(250,290,60,30);
	     jb12.setBackground(new java.awt.Color(107, 210, 129));
	     LoginHandler12 log12 = new LoginHandler12();
	     jb12.addActionListener(log12);
	     f2.add(jb12);
	     jb12.setVisible(false);
	     
	     jb13= new JButton("Cancel");
	     jb13.setBounds(220,420,120,30);
	     jb13.setBackground(new java.awt.Color(107, 210, 129));
	     LoginHandler13 log13 = new LoginHandler13();
	     jb13.addActionListener(log13);
	     f2.add(jb13);
	     jb13.setVisible(false);
	     
	     jb14= new JButton("Logout");
	     jb14.setBounds(650,20,100,20);
	     jb14.setBackground(new java.awt.Color(107, 210, 129));
	     LoginHandler14 log14 = new LoginHandler14();
	     jb14.addActionListener(log14);
	     f2.add(jb14);
	     jb14.setVisible(false);
	     
	     JLabel jl = new JLabel();
	     jl.setText("Plan Your Journey");
	     jl.setFont(new Font("Serif", Font.PLAIN, 20));
	     jl.setBounds(130,20,150,100);
	     f1.add(jl);
	     
	     JLabel jl1 = new JLabel();
	     jl1.setText("Previous Bookings/Cancellations");
	     jl1.setFont(new Font("Serif", Font.PLAIN, 20));
	     jl1.setBounds(465,20,300,100);
	     f1.add(jl1);
	     //f1.add(jl1);
	     
	     jl2 = new JLabel();
	     jl2.setText("Add a New Train");
	     jl2.setFont(new Font("Serif", Font.PLAIN, 20));
	     jl2.setBounds(120,45,300,100);
	     f2.add(jl2);
	     jl2.setVisible(false);
	     
	     jl3 = new JLabel();
	     jl3.setText("Cancel a Train");
	     jl3.setFont(new Font("Serif", Font.PLAIN, 20));
	     jl3.setBounds(140,320,300,100);
	     f2.add(jl3);
	     jl3.setVisible(false);
	     
	     jcb= new JComboBox();
	     jcb.setBounds(100,250,200,30);
	     jcb.setBackground(Color.white);
	     jcb.addItem("Select");
	     jcbHandler jcb1 =new jcbHandler();
	     jcb.addItemListener(jcb1);
	     f1.add(jcb);
	     
	     /*JTable table = new JTable();
	     JScrollPane tableContainer = new JScrollPane(table);
	     tableContainer.setBounds(415,120,355,450);
	     f1.add(tableContainer);*/
	     
	     UtilDateModel model = new UtilDateModel();
	     Properties p = new Properties();
	     p.put("text.today", "Today");
	     p.put("text.month", "Month");
	     p.put("text.year", "Year");
	     JDatePanelImpl datePanel = new JDatePanelImpl(model,p);
	    
	      datePicker = new JDatePickerImpl(datePanel,new DateLabelFormatter());
	     datePicker.setBounds(50,170,140,30);
	    // panel8.add(datePicker);
	     f1.add(datePicker);
	        
	     f.setVisible(true);
	     f.add(panel);
	     f.add(panel1);
	     f1.add(panel2); 
	     f1.add(panel3);
	     f1.add(panel4);
	     f1.add(panel5);
	     f1.add(panel6);
	     f1.add(panel7);
	     f1.add(panel8);
	     f2.add(panel9);
	     f2.add(panel10);
	     f2.add(panel11);
	     f2.add(panel12);
	     
	 }
	   private static class UserHandler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag==0))
	        {
	          jt.setText("");
	          jt.setForeground(Color.black);
	          flag=1;
	          
	        }       
	     }
	   }
	   private static class User5Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag5==0))
	        {
	          jt5.setText("");
	          jt5.setForeground(Color.black);
	          flag5=1;
	          
	        }       
	     }
	   }
	   private static class User4Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag4==0))
	        {
	          jt4.setText("");
	          jt4.setForeground(Color.black);
	          flag4=1;
	          
	        }       
	     }
	   }
	   private static class User1Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag1==0))
	        {
	          jt1.setText("");
	          jt1.setForeground(Color.black);
	          flag1=1;
	          
	        }       
	     }
	   }
	   private static class User2Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag2==0))
	        {
	          jt2.setText("");
	          jt2.setForeground(Color.black);
	          flag2=1;
	          
	        }       
	     }
	   }
	   private static class User3Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag3==0))
	        {
	          jt3.setText("");
	          jt3.setForeground(Color.black);
	          flag3=1;
	          
	        }       
	     }
	   }
	   private static class User6Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag6==0))
	        {
	          jt6.setText("");
	          jt6.setForeground(Color.black);
	          flag6=1;
	          
	        }       
	     }
	   }
	   private static class User7Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag7==0))
	        {
	          jt7.setText("");
	          jt7.setForeground(Color.black);
	          flag7=1;
	          
	        }       
	     }
	   }
	   private static class User8Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag8==0))
	        {
	          jt8.setText("");
	          jt8.setForeground(Color.black);
	          flag8=1;
	          
	        }       
	     }
	   }
	   private static class User9Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag9==0))
	        {
	          jt9.setText("");
	          jt9.setForeground(Color.black);
	          flag9=1;
	          
	        }       
	     }
	   }
	   private static class User10Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag10==0))
	        {
	          jt10.setText("");
	          jt10.setForeground(Color.black);
	          flag10=1;
	          
	        }       
	     }
	   }
	   private static class User11Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag11==0))
	        {
	          jt11.setText("");
	          jt11.setForeground(Color.black);
	          flag11=1;
	          
	        }       
	     }
	   }
	   private static class User12Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag12==0))
	        {
	          jt12.setText("");
	          jt12.setForeground(Color.black);
	          flag12=1;
	          
	        }       
	     }
	   }
	   private static class User13Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag13==0))
	        {
	          jt13.setText("");
	          jt13.setForeground(Color.black);
	          flag13=1;
	          
	        }       
	     }
	   }
	   private static class User14Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag14==0))
	        {
	          jt14.setText("");
	          jt14.setForeground(Color.black);
	          flag14=1;
	          
	        }       
	     }
	   }
	   private static class User15Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag15==0))
	        {
	          jt15.setText("");
	          jt15.setForeground(Color.black);
	          flag15=1;
	          
	        }       
	     }
	   }
	   private static class User16Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag16==0))
	        {
	          jt16.setText("");
	          jt16.setForeground(Color.black);
	          flag16=1;
	          
	        }       
	     }
	   }
	   private static class User17Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag17==0))
	        {
	          jt17.setText("");
	          jt17.setForeground(Color.black);
	          flag17=1;
	          
	        }       
	     }
	   }
	   private static class User18Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag18==0))
	        {
	          jt18.setText("");
	          jt18.setForeground(Color.black);
	          flag18=1;
	          
	        }       
	     }
	   }
	   private static class User19Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag19==0))
	        {
	          jt19.setText("");
	          jt19.setForeground(Color.black);
	          flag19=1;
	          
	        }       
	     }
	   }
	   private static class User20Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag20==0))
	        {
	          jt20.setText("");
	          jt20.setForeground(Color.black);
	          flag20=1;
	          
	        }       
	     }
	   }
	   private static class User21Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag21==0))
	        {
	          jt21.setText("");
	          jt21.setForeground(Color.black);
	          flag21=1;
	          
	        }       
	     }
	   }
	   private static class User22Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag22==0))
	        {
	          jt22.setText("");
	          jt22.setForeground(Color.black);
	          flag22=1;
	          
	        }       
	     }
	   }
	   private static class User23Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag23==0))
	        {
	          jt23.setText("");
	          jt23.setForeground(Color.black);
	          flag23=1;
	          
	        }       
	     }
	   }
	   private static class User24Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag24==0))
	        {
	          jt24.setText("");
	          jt24.setForeground(Color.black);
	          flag24=1;
	          
	        }       
	     }
	   }
	   private static class User25Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag25==0))
	        {
	          jt25.setText("");
	          jt25.setForeground(Color.black);
	          flag25=1;
	          
	        }       
	     }
	   }
	   private static class User26Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag26==0))
	        {
	          jt26.setText("");
	          jt26.setForeground(Color.black);
	          flag26=1;
	          
	        }       
	     }
	   }
	   private static class User27Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag27==0))
	        {
	          jt27.setText("");
	          jt27.setForeground(Color.black);
	          flag27=1;
	          
	        }       
	     }
	   }
	   private static class PassHandler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag2a==0))
	        {
	          jp.setText("");
	          jp.setForeground(Color.black);
	          flag2a=1;
	          
	        }       
	     }
	   }
	   private static class Pass1Handler extends KeyAdapter
	   {
	     public void keyPressed(KeyEvent e)
	     {
	        if(( e.getKeyCode()>0) &(flag2b==0))
	        {
	          jp1.setText("");
	          jp1.setForeground(Color.black);
	          flag2b=1;
	          
	        }       
	     }
	   }
	   private static class LoginHandler implements ActionListener
	   {
	     @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
	     {
	       String ramu =e.getActionCommand();
	       if(ramu.equalsIgnoreCase("Login"))      
	       {
	    	   f1.repaint();
	    	   try {
	         CallConn c=new CallConn();
             Connection conn=(Connection) c.call();
             user=jt.getText();
             pass=jp.getText();
             
             String sql="select * from signup where user=? and password=?";
             PreparedStatement pst=(PreparedStatement) conn.prepareStatement(sql);
             pst.setString(1, user);
             pst.setString(2, pass);
             ResultSet rs=(ResultSet) pst.executeQuery();
             if(rs.next())
             {
            	 acc=rs.getString(4);
            	 acc_amount=rs.getInt(5);
            	 f.setVisible(false);
            	 f1.setVisible(true);
             }
	         else 
	         {
	           JOptionPane.showMessageDialog(null,"Invalid User ID or Password");
	         }
             conn.close();
	    	   }
	    	   catch(Exception e1)
               {
                   e1.printStackTrace();
               }    
	       }
	       CallConn cx=new CallConn();
           Connection connx=(Connection) cx.call();
           try
           {
        	   String sql="select * from passenger where user=?";
               PreparedStatement pst=(PreparedStatement) connx.prepareStatement(sql);
               pst.setString(1, user);
               ResultSet rs=(ResultSet) pst.executeQuery();
               while(rs.next())
               {
              
              	  String sqlx = "insert into print(no,train,date,amount,status) values(?,?,?,?,?)";
                  PreparedStatement pst1=(PreparedStatement) connx.prepareStatement(sqlx);
                  pst1.setString(1, rs.getString(1));
                  pst1.setString(2, rs.getString(5));
                  pst1.setString(3, rs.getString(15));
                  pst1.setString(4, rs.getString(14));
                  pst1.setString(5, rs.getString(17));
                  pst1.executeUpdate();
               }
               connx.close();
           }
           catch(Exception e1)
           {
               e1.printStackTrace();
           } 
           panel6.removeAll();
           panel6.revalidate();
           panel6.repaint();
	       JTable t1;
           ResultSet rss;
           String[] col= {"#No","Train","Date", "Amount","Status"};
           try
           {
               CallConn trans=new CallConn();
               Connection trans123=(Connection) trans.call();
               String sqlm="select * from print";
               PreparedStatement pstx=(PreparedStatement) trans123.prepareStatement(sqlm);
               //pstx.setString(1,user);
               ResultSet rsz=(ResultSet) pstx.executeQuery();
               int rowCount=0;
               while (rsz.next())
               {
                   rowCount++;
               }
               Object[][] data= new Object[rowCount][5];
               PreparedStatement stmtjcb= (PreparedStatement) trans123.prepareStatement(sqlm);
               rss=stmtjcb.executeQuery(sqlm);
               int i=0;
               while (rss.next())
               {
                   data[i][0]=rss.getString("no");
                   data[i][1]=rss.getString("train");
                   data[i][2]=rss.getString("date");
                   data[i][3]=rss.getString("amount");
                   data[i][4]=rss.getString("status");
                   i++;
               }
              
               t1=new JTable(data,col);
               TableColumnModel columnModel = t1.getColumnModel();
               columnModel.getColumn(0).setPreferredWidth(3);
               columnModel.getColumn(1).setPreferredWidth(3);
               columnModel.getColumn(2).setPreferredWidth(35);
               columnModel.getColumn(3).setPreferredWidth(5);
               columnModel.getColumn(4).setPreferredWidth(5);
               JScrollPane scrollPane= new JScrollPane(t1);
               scrollPane.setPreferredSize(new Dimension(350, 450));
               //scrollPane.setBounds(455,120,300,450);
               //st1.setFillsViewportHeight(true);
               
               //f12.setSize(1368, 900);
               //f12.getContentPane().add(scrollPane);
               //f12.setVisible(true);
               trans123.close();
               panel6.add(scrollPane);
         }
   
       catch (Exception e_repo_tran)
       {
           e_repo_tran.printStackTrace();
       }
           
	       		jt.setForeground(Color.gray);
	       		jp.setForeground(Color.gray);
	       		jt.setText("Username");
	       		jp.setText("Password");
	       		flag=flag2a=0;
	       		
	           
	     }     
	    }  
	   private static class LoginHandler1 implements ActionListener
	   {
	     @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
	     {
	       String ramu1 =e.getActionCommand();
	       if(ramu1.equalsIgnoreCase("Sign Up"))      
	       {
	          if ((jt1.getText().equals("")) || (jt2.getText().equals("")) || (jt3.getText().equals("")) || (jt4.getText().equals("")) || (jt5.getText().equals(""))) 
	         { 
	        	  JOptionPane.showMessageDialog(null,"All Fields are Mandatory");
	         }
	         else 
	         {
	        	 CallConn cx=new CallConn();
                 Connection connx=(Connection) cx.call();
                 String user=jt1.getText();
                 String pass=jt2.getText();
                 String aadhar=jt3.getText();
                 String account=jt4.getText();
                 String amount=jt5.getText();

                 try
                 {
                     String sqlx = "insert into signup(user,password,aadhar,bank,amount) values(?,?,?,?,?)";
                     PreparedStatement pst=(PreparedStatement) connx.prepareStatement(sqlx);
                     pst.setString(1, user);
                     pst.setString(2, pass);
                     pst.setString(3, aadhar);
                     pst.setString(4, account);
                     pst.setString(5, amount);
                     pst.executeUpdate();
                     connx.close();
                 }
                 catch(Exception e1)
                 {
                     e1.printStackTrace();
                 } 
	           JOptionPane.showMessageDialog(null,"Successfully Registered.");
	           jt1.setForeground(Color.gray);
	           jt2.setForeground(Color.gray);
	           jt3.setForeground(Color.gray);
	           jt4.setForeground(Color.gray);
	           jt5.setForeground(Color.gray);
	           jt1.setText("Username");
	           jt2.setText("New Password");
	           jt3.setText("Aadhar Number");
	           jt4.setText("Bank A/c number");
	           jt5.setText("Initial amount");
	           flag1=flag2=flag3=flag4=flag5=0;
	         }
	       }
	     }     
	    }
	   private static class LoginHandler2 implements ActionListener
	   {
	     @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
	     {
	       String ramu1 =e.getActionCommand();
	       if(ramu1.equalsIgnoreCase("Book Ticket"))      
	       {
	          if ((jt6.getText().equals("")) || (jt7.getText().equals("")) || (jt8.getText().equals("")) || (jt9.getText().equals("")) || (jt10.getText().equals("")) || (jt11.getText().equals("")) || (jt12.getText().equals("")) || (jt13.getText().equals("")) || (jt14.getText().equals("")) || (jt15.getText().equals("")) || (jt16.getText().equals(""))) 
	         { 
	        	  JOptionPane.showMessageDialog(null,"All Fields are Mandatory");
	         }
	         else 
	         {
	        	 if (amount_train1<acc_amount)
	        	 {
		        	 CallConn cx=new CallConn();
	                 Connection connx=(Connection) cx.call();
	                 Date selectedDate = (Date) datePicker.getModel().getValue();
		             SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd"); 
		             String strDate1 = formatter.format(selectedDate);
	                 String trainno=(String) jcb.getSelectedItem();
	                 String name1=jt8.getText();
	                 String name2=jt10.getText();
	                 String name3=jt11.getText();
	                 String name4=jt12.getText();
	                 String age1=jt9.getText();
	                 String age2=jt13.getText();
	                 String age3=jt14.getText();
	                 String age4=jt15.getText();
	                 try
	                 {
	                     String sqlx = "insert into passenger(user,froms,tos,trainno,name1,age1,name2,age2,name3,age3,name4,age4,amount,date,account) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	                     PreparedStatement pst=(PreparedStatement) connx.prepareStatement(sqlx);
	                     pst.setString(1, user);
	                     pst.setString(2, from);
	                     pst.setString(3, to);
	                     pst.setString(4, trainno);
	                     pst.setString(5, name1);
	                     pst.setString(6, age1);
	                     pst.setString(7, name2);
	                     pst.setString(8, age2);
	                     pst.setString(9, name3);
	                     pst.setString(10, age3);
	                     pst.setString(11, name4);
	                     pst.setString(12, age4);
	                     pst.setInt(13, amount_train1);
	                     pst.setString(14, strDate1);
	                     pst.setString(15, acc);
	                     pst.executeUpdate();
	                     connx.close();
	                 }
	                 catch(Exception e1)
	                 {
	                     e1.printStackTrace();
	                 } 
	                 JOptionPane.showMessageDialog(null,"Successfully Booked.");
	                 jt6.setForeground(Color.gray);
	                 jt7.setForeground(Color.gray);
	                 jt8.setForeground(Color.gray);
	                 jt9.setForeground(Color.gray);
	                 jt10.setForeground(Color.gray);
	                 jt11.setForeground(Color.gray);
	                 jt12.setForeground(Color.gray);
	                 jt13.setForeground(Color.gray);
			           jt14.setForeground(Color.gray);
			           jt15.setForeground(Color.gray);
			           jt16.setForeground(Color.gray);
			           jt17.setForeground(Color.gray);
			           jt6.setText("From Place");
			           jt7.setText("To Place");
			           jt8.setText("Passenger 1");
			           jt9.setText("Age");
			           jt10.setVisible(false);
			           jt11.setVisible(false);
			           jt12.setVisible(false);
			           jt13.setVisible(false);
			           jt14.setVisible(false);
			           jt15.setVisible(false);
			           jb3.setVisible(true);
			           jb4.setVisible(false);
			           jb5.setVisible(false);
			           jt10.setText("Passenger 2");
			           jt11.setText("Passenger 3");
			           jt12.setText("Passenger 4");
			           jt13.setText("Age");
			           jt14.setText("Age");
			           jt15.setText("Age");
			           jt16.setText("Account Number");
			           jt17.setText("Amount");
			           jcb.removeAllItems();
			           jcb.addItem("Select");
			           acc_amount=acc_amount-amount_train1;
			           try {
			           CallConn cx1=new CallConn();
		               Connection connx1=(Connection) cx1.call();
			           String sql="update signup SET amount=? where user=?";
                       PreparedStatement pst=(PreparedStatement) connx1.prepareStatement(sql);
                       pst.setInt(1, acc_amount);
                       pst.setString(2, user);
                       pst.executeUpdate();
                       connx1.close();
			           }
			           catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
			           }
			           flag6=flag7=flag8=flag9=flag10=flag11=flag12=flag13=flag14=flag15=flag16=flag17=0;
	        	 	}
	        	 	else {
		        	  JOptionPane.showMessageDialog(null,"Insufficient Funds");
	        	 	}
	        	 try{
		               CallConn trans=new CallConn();
		               Connection trans123=(Connection) trans.call();
		               String sqlm="delete from print";
		               PreparedStatement pstx=(PreparedStatement) trans123.prepareStatement(sqlm);
		               pstx.executeUpdate();
		               trans123.close();
		               }
		               catch (Exception e_repo_tran)
		               {
		                   e_repo_tran.printStackTrace();
		               }
		    	   CallConn cx=new CallConn();
		           Connection connx=(Connection) cx.call();
		           try
		           {
		        	   String sql="select * from passenger where user=?";
		               PreparedStatement pst=(PreparedStatement) connx.prepareStatement(sql);
		               pst.setString(1, user);
		               ResultSet rs=(ResultSet) pst.executeQuery();
		               while(rs.next())
		               {
		              	  String sqlx = "insert into print(no,train,date,amount,status) values(?,?,?,?,?)";
		                  PreparedStatement pst1=(PreparedStatement) connx.prepareStatement(sqlx);
		                  pst1.setString(1, rs.getString(1));
		                  pst1.setString(2, rs.getString(5));
		                  pst1.setString(3, rs.getString(15));
		                  pst1.setString(4, rs.getString(14));
		                  pst1.setString(5, rs.getString(17));
		                  pst1.executeUpdate();
		               }
		               connx.close();
		           }
		           catch(Exception e1)
		           {
		               e1.printStackTrace();
		           } 
			       JTable t1;
		           ResultSet rss;
		           String[] col= {"#No","Train","Date", "Amount","Status"};
		           try
		           {
		        	   f1.repaint();
		               CallConn trans=new CallConn();
		               Connection trans123=(Connection) trans.call();
		               String sqlm="select * from print";
		               PreparedStatement pstx=(PreparedStatement) trans123.prepareStatement(sqlm);
		               //pstx.setString(1,user);
		               ResultSet rsz=(ResultSet) pstx.executeQuery();
		               int rowCount=0;
		               while (rsz.next())
		               {
		                   rowCount++;
		               }
	                   panel6.removeAll();
	    	           panel6.revalidate();
	    	           panel6.repaint();
		               Object[][] data= new Object[rowCount][5];
		               PreparedStatement stmtjcb= (PreparedStatement) trans123.prepareStatement(sqlm);
		               rss=stmtjcb.executeQuery(sqlm);
		               int i=0;
		               while (rss.next())
		               {
		                   data[i][0]=rss.getString("no");
		                   data[i][1]=rss.getString("train");
		                   data[i][2]=rss.getString("date");
		                   data[i][3]=rss.getString("amount");
		                   data[i][4]=rss.getString("status");
		                   i++;
		               }
		              
		               t1=new JTable(data,col);
		               TableColumnModel columnModel = t1.getColumnModel();
		               columnModel.getColumn(0).setPreferredWidth(3);
		               columnModel.getColumn(1).setPreferredWidth(3);
		               columnModel.getColumn(2).setPreferredWidth(35);
		               columnModel.getColumn(3).setPreferredWidth(5);
		               columnModel.getColumn(4).setPreferredWidth(5);
		               JScrollPane scrollPane= new JScrollPane(t1);
		               scrollPane.setPreferredSize(new Dimension(350, 450));
		               //scrollPane.setBounds(455,120,300,450);
		               //st1.setFillsViewportHeight(true);
		               
		               //f12.setSize(1368, 900);
		               //f12.getContentPane().add(scrollPane);
		               //f12.setVisible(true);
		               trans123.close();
		               panel6.add(scrollPane);
		               jt19.setText("");
		       }
		           catch(Exception e1)
		           {
		               e1.printStackTrace();
		           } 
			        
	         }
	       }
	     }     
	    }
	   private static class LoginHandler3 implements ActionListener
	   {
	     @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
	     {
	       String ramu1 =e.getActionCommand();
	       if(ramu1.equalsIgnoreCase("+"))      
	       {
	    	  
	          jt10.setVisible(true);
	          jt13.setVisible(true);
	          jb4.setVisible(true);
	          jb3.setVisible(false);
	          amount_train1=amount_train*2; 
	          String k= Integer.toString(amount_train1);
              jt17.setText(k);
	         
	       }
	     }     
	    }
	   private static class LoginHandler4 implements ActionListener
	   {
	     @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
	     {
	       String ramu1 =e.getActionCommand();
	       if(ramu1.equalsIgnoreCase("+"))      
	       {
	          jt11.setVisible(true);
	          jt14.setVisible(true);
	          jb5.setVisible(true);
	          jb4.setVisible(false);
	          amount_train1=amount_train*3; 
	          String k= Integer.toString(amount_train1);
              jt17.setText(k);
	         
	       }
	     }     
	    }
	   private static class LoginHandler5 implements ActionListener
	   {
	     @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
	     {
	       String ramu1 =e.getActionCommand();
	       if(ramu1.equalsIgnoreCase("+"))      
	       {
	          jt12.setVisible(true);
	          jt15.setVisible(true);
	          jb5.setVisible(false);
	          amount_train1=amount_train*4; 
	          String k= Integer.toString(amount_train1);
              jt17.setText(k);
	       }
	     }     
	    }
	   private static class LoginHandler6 implements ActionListener
	   {
	     @SuppressWarnings({ "deprecation", "unchecked" })
		public void actionPerformed(ActionEvent e)
	     {
	       String ramu1 =e.getActionCommand();
	       if(ramu1.equalsIgnoreCase("Search"))      
	       {
	    	   try {
	    		   int co=0;
	  	         CallConn c=new CallConn();
	               Connection conn=(Connection) c.call();
	               from=jt6.getText();
	               to=jt7.getText();
	               jcb.removeAllItems();
	               jcb.addItem("Select");
	               Date selectedDate = (Date) datePicker.getModel().getValue();
	               SimpleDateFormat formatter = new SimpleDateFormat("E"); 
	               String strDate = formatter.format(selectedDate);
	               String sql="select * from train where froms=? and tos=? and days LIKE '%"+ strDate +"%'";
	               PreparedStatement pst=(PreparedStatement) conn.prepareStatement(sql);
	               pst.setString(1, from);
	               pst.setString(2, to);
	               
	               ResultSet rs=(ResultSet) pst.executeQuery();
	               while(rs.next())
	               {
	            	   
		  	           jcb.addItem(rs.getString("trainno"));

	               }
	               jcb.setSelectedIndex(0);
	               
	  	         conn.close();
	  	    	   }
	  	    	   catch(Exception e1)
	                 {
	                     e1.printStackTrace();
	                 }    
	  	       
	  	       		
	       }
	     }

		private int CHARINDEX(String strDate, String v) {
			// TODO Auto-generated method stub
			return 0;
		}     
	    }
	   private static class LoginHandler7 implements ActionListener
	   {
	     @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
	     {
	       String ramu1 =e.getActionCommand();
	       if(ramu1.equalsIgnoreCase("Logout"))      
	       {
	    	   try{
	               CallConn trans=new CallConn();
	               Connection trans123=(Connection) trans.call();
	               String sqlm="delete from print";
	               PreparedStatement pstx=(PreparedStatement) trans123.prepareStatement(sqlm);
	               pstx.executeUpdate();
	               trans123.close();
	               }
	               catch (Exception e_repo_tran)
	               {
	                   e_repo_tran.printStackTrace();
	               }
	    	   
	    	   f1.setVisible(false);
	    	   f.setVisible(true);
	    	   jt18.setText("");
	    	   jt19.setText("");
	    	   jb4.setVisible(false);
	           jb5.setVisible(false);
	       }
	     }     
	    }
	   private static class LoginHandler8 implements ActionListener
	   {
	     @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
	     {
	       String ramu1 =e.getActionCommand();
	       if(ramu1.equalsIgnoreCase("View Current Balance"))      
	       {
	                  String k= Integer.toString(acc_amount);
	                   jt18.setForeground(Color.black);
	                   jt18.setText(k);
	             }
		        
		       }
		       		
		     }     
	       
	   private static class LoginHandler9 implements ActionListener
	   {
	     @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
	     {
	       String ramu1 =e.getActionCommand();
	       if(ramu1.equalsIgnoreCase("Cancel Ticket"))      
	       {
	    	  f1.repaint();
	    	   try {
	  	           CallConn c=new CallConn();
	               Connection conn=(Connection) c.call();
	               String ticket_no=jt19.getText();
                   String sql="update passenger SET status=? where user=? and ticket_no=?";
	               PreparedStatement pst=(PreparedStatement) conn.prepareStatement(sql);
	               pst.setString(1, "Cancelled");
	               pst.setString(2, user);
	               pst.setString(3, ticket_no);
	               pst.executeUpdate();
	  	         conn.close();
	  	    	   }
	  	    	   catch(Exception e1)
	                 {
	                     e1.printStackTrace();
	                 }  
	    	   try {
	  	           CallConn c=new CallConn();
	               Connection conn=(Connection) c.call();
	               acc_amount=amount_train1+acc_amount;
                   String sql="update signup SET amount=? where user=?";
	               PreparedStatement pst=(PreparedStatement) conn.prepareStatement(sql);
	               pst.setInt(1, acc_amount);
	               pst.setString(2, user);
	               pst.executeUpdate();
	  	         conn.close();
	  	    	   }
	  	    	   catch(Exception e1)
	                 {
	                     e1.printStackTrace();
	                 } 
               try{
	               CallConn trans=new CallConn();
	               Connection trans123=(Connection) trans.call();
	               String sqlm="delete from print";
	               PreparedStatement pstx=(PreparedStatement) trans123.prepareStatement(sqlm);
	               pstx.executeUpdate();
	               trans123.close();
	               }
	               catch (Exception e_repo_tran)
	               {
	                   e_repo_tran.printStackTrace();
	               }
	    	   CallConn cx=new CallConn();
	           Connection connx=(Connection) cx.call();
	           try
	           {
	        	   String sql="select * from passenger where user=?";
	               PreparedStatement pst=(PreparedStatement) connx.prepareStatement(sql);
	               pst.setString(1, user);
	               ResultSet rs=(ResultSet) pst.executeQuery();
	               while(rs.next())
	               {
	              	  String sqlx = "insert into print(no,train,date,amount,status) values(?,?,?,?,?)";
	                  PreparedStatement pst1=(PreparedStatement) connx.prepareStatement(sqlx);
	                  pst1.setString(1, rs.getString(1));
	                  pst1.setString(2, rs.getString(5));
	                  pst1.setString(3, rs.getString(15));
	                  pst1.setString(4, rs.getString(14));
	                  pst1.setString(5, rs.getString(17));
	                  pst1.executeUpdate();
	               }
	               connx.close();
	           }
	           catch(Exception e1)
	           {
	               e1.printStackTrace();
	           } 
		       JTable t1;
	           ResultSet rss;
	           String[] col= {"#No","Train","Date", "Amount","Status"};
	           try
	           {
	        	   f1.repaint();
	               CallConn trans=new CallConn();
	               Connection trans123=(Connection) trans.call();
	               String sqlm="select * from print";
	               PreparedStatement pstx=(PreparedStatement) trans123.prepareStatement(sqlm);
	               //pstx.setString(1,user);
	               ResultSet rsz=(ResultSet) pstx.executeQuery();
	               int rowCount=0;
	               while (rsz.next())
	               {
	                   rowCount++;
	               }
                   panel6.removeAll();
    	           panel6.revalidate();
    	           panel6.repaint();
	               Object[][] data= new Object[rowCount][5];
	               PreparedStatement stmtjcb= (PreparedStatement) trans123.prepareStatement(sqlm);
	               rss=stmtjcb.executeQuery(sqlm);
	               int i=0;
	               while (rss.next())
	               {
	                   data[i][0]=rss.getString("no");
	                   data[i][1]=rss.getString("train");
	                   data[i][2]=rss.getString("date");
	                   data[i][3]=rss.getString("amount");
	                   data[i][4]=rss.getString("status");
	                   i++;
	               }
	              
	               t1=new JTable(data,col);
	               TableColumnModel columnModel = t1.getColumnModel();
	               columnModel.getColumn(0).setPreferredWidth(3);
	               columnModel.getColumn(1).setPreferredWidth(3);
	               columnModel.getColumn(2).setPreferredWidth(35);
	               columnModel.getColumn(3).setPreferredWidth(5);
	               columnModel.getColumn(4).setPreferredWidth(5);
	               JScrollPane scrollPane= new JScrollPane(t1);
	               scrollPane.setPreferredSize(new Dimension(350, 450));
	               //scrollPane.setBounds(455,120,300,450);
	               //st1.setFillsViewportHeight(true);
	               
	               //f12.setSize(1368, 900);
	               //f12.getContentPane().add(scrollPane);
	               //f12.setVisible(true);
	               trans123.close();
	               panel6.add(scrollPane);
	               jt19.setText("");
                   JOptionPane.showMessageDialog(null,"Ticket has been Cancelled and amount is refunded back!!");

	               
	       }
	           catch(Exception e1)
	           {
	               e1.printStackTrace();
	           } 
		        
		 }
		       		
	   }     
	   }
	   private static class LoginHandler10 implements ActionListener
	   {
	     @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
	     {
	       String ramu1 =e.getActionCommand();
	       if(ramu1.equalsIgnoreCase("Admin Login"))      
	       {
	          f2.setVisible(true);
              f.setVisible(false);
              
	       }
	     }     
	    }
	   private static class LoginHandler11 implements ActionListener
	   {
	     @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
	     {
	       String ramu1 =e.getActionCommand();
	       if(ramu1.equalsIgnoreCase("Login"))      
	       {

	    	   if (jt20.getText().equals("pratik") && jp1.getText().equals("pratik"))
	    	   {	f2.repaint();
	    		   panel10.removeAll();
	               panel10.revalidate();
	               panel10.repaint();
	    		   JTable t1;
		           ResultSet rss;
		           String[] col= {"#No","from","To", "Days","Status"};
		           try
		           {
		               CallConn trans=new CallConn();
		               Connection trans123=(Connection) trans.call();
		               String sqlm="select * from train";
		               PreparedStatement pstx=(PreparedStatement) trans123.prepareStatement(sqlm);
		               //pstx.setString(1,user);
		               ResultSet rsz=(ResultSet) pstx.executeQuery();
		               int rowCount=0;
		               while (rsz.next())
		               {
		                   rowCount++;
		               }
		               Object[][] data= new Object[rowCount][5];
		               PreparedStatement stmtjcb= (PreparedStatement) trans123.prepareStatement(sqlm);
		               rss=stmtjcb.executeQuery(sqlm);
		               int i=0;
		               while (rss.next())
		               {
		                   data[i][0]=rss.getString("trainno");
		                   data[i][1]=rss.getString("froms");
		                   data[i][2]=rss.getString("tos");
		                   data[i][3]=rss.getString("days");
		                   data[i][4]=rss.getString("status");
		                   i++;
		               }
		              
		               t1=new JTable(data,col);
		               TableColumnModel columnModel = t1.getColumnModel();
		               columnModel.getColumn(0).setPreferredWidth(3);
		               columnModel.getColumn(1).setPreferredWidth(3);
		               columnModel.getColumn(2).setPreferredWidth(35);
		               columnModel.getColumn(3).setPreferredWidth(5);
		               columnModel.getColumn(4).setPreferredWidth(5);
		               JScrollPane scrollPane= new JScrollPane(t1);
		               scrollPane.setPreferredSize(new Dimension(350, 450));
		               //scrollPane.setBounds(455,120,300,450);
		               //st1.setFillsViewportHeight(true);
		               
		               //f12.setSize(1368, 900);
		               //f12.getContentPane().add(scrollPane);
		               //f12.setVisible(true);
		               trans123.close();
		               panel10.add(scrollPane);
		               jt20.setVisible(false);
		               jp1.setVisible(false);
		               jb11.setVisible(false);
		               jt21.setVisible(true);
		               jt22.setVisible(true);
		               jt23.setVisible(true);
		               jt24.setVisible(true);
		               jt25.setVisible(true);
		               jt26.setVisible(true);
		               jt27.setVisible(true);
		               jb12.setVisible(true);
		               jb13.setVisible(true);
		               jl2.setVisible(true);
		               jl3.setVisible(true);
		               panel12.setVisible(true);
		               jb14.setVisible(true);
		               
		       }
		           catch(Exception e1)
		           {
		               e1.printStackTrace();
		           } 
			        
	    	   }
	    	   else
	    	   {
                   JOptionPane.showMessageDialog(null,"Invalid userid or Password");

	    	   }
	    		   
	       }
	     }     
	    }
	   private static class LoginHandler12 implements ActionListener
	   {
	     @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
	     {
	       String ramu1 =e.getActionCommand();
	       if(ramu1.equalsIgnoreCase("Go"))      
	       {
	           f2.repaint();

	    	   CallConn cx=new CallConn();
	           Connection connx=(Connection) cx.call();
	           try
	           {
	        	   
	              	  String sqlx = "insert into train(trainno,froms,tos,amount,days,status) values(?,?,?,?,?,?)";
	                  PreparedStatement pst1=(PreparedStatement) connx.prepareStatement(sqlx);
	                  pst1.setString(1, jt23.getText());
	                  pst1.setString(2, jt21.getText());
	                  pst1.setString(3, jt22.getText());
	                  pst1.setString(4, jt26.getText());
	                  pst1.setString(5, jt25.getText());
	                  pst1.setString(6, jt24.getText());
	                  pst1.executeUpdate();
	                   JOptionPane.showMessageDialog(null,"Successfully added");

	               connx.close();
	               jt21.setText("From Place");
	  	  	     jt22.setText("To Place");
	  	  	     jt23.setText("Train Number");
	  	  	     jt24.setText("Current Status");
	  	  	     jt25.setText("Days For-eg(Mon,Tue,Wed,Thu,Fri,Sat)");
	  	  	     jt26.setText("Amount");
	  	  	     jt27.setText("Enter Train No.");
	           }
	           catch(Exception e1)
	           {
	               e1.printStackTrace();
	           } 
    		 
    		   JTable t1;
	           ResultSet rss;
	           String[] col= {"#No","from","To", "Days","Status"};
	           try
	           {
		           f2.repaint();

	               CallConn trans=new CallConn();
	               Connection trans123=(Connection) trans.call();
	               String sqlm="select * from train";
	               PreparedStatement pstx=(PreparedStatement) trans123.prepareStatement(sqlm);
	               //pstx.setString(1,user);
	               ResultSet rsz=(ResultSet) pstx.executeQuery();
	               int rowCount=0;
	               while (rsz.next())
	               {
	                   rowCount++;
	               }
	               panel10.removeAll();
	               panel10.revalidate();
	               panel10.repaint();
	               Object[][] data= new Object[rowCount][5];
	               PreparedStatement stmtjcb= (PreparedStatement) trans123.prepareStatement(sqlm);
	               rss=stmtjcb.executeQuery(sqlm);
	               int i=0;
	               while (rss.next())
	               {
	                   data[i][0]=rss.getString("trainno");
	                   data[i][1]=rss.getString("froms");
	                   data[i][2]=rss.getString("tos");
	                   data[i][3]=rss.getString("days");
	                   data[i][4]=rss.getString("status");
	                   i++;
	               }
	              
	               t1=new JTable(data,col);
	               TableColumnModel columnModel = t1.getColumnModel();
	               columnModel.getColumn(0).setPreferredWidth(3);
	               columnModel.getColumn(1).setPreferredWidth(3);
	               columnModel.getColumn(2).setPreferredWidth(35);
	               columnModel.getColumn(3).setPreferredWidth(5);
	               columnModel.getColumn(4).setPreferredWidth(5);
	               JScrollPane scrollPane= new JScrollPane(t1);
	               scrollPane.setPreferredSize(new Dimension(350, 450));
	               //scrollPane.setBounds(455,120,300,450);
	               //st1.setFillsViewportHeight(true);
	               
	               //f12.setSize(1368, 900);
	               //f12.getContentPane().add(scrollPane);
	               //f12.setVisible(true);
	               trans123.close();  
	               panel10.add(scrollPane);

	       }
	           catch(Exception e1)
	           {
	               e1.printStackTrace();
	           } 
	         
	       }
	     }     
	    }
	   private static class LoginHandler13 implements ActionListener
	   {
	     @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
	     {	    	  

	       String ramu1 =e.getActionCommand();
	       if(ramu1.equalsIgnoreCase("Cancel"))      
	       {
	    	   f1.repaint();
	    	   String num=jt27.getText();
	    	   try {
	  	           CallConn c=new CallConn();
	               Connection conn=(Connection) c.call();
	               train_no=jt27.getText();
                   String sql="update train SET status=? where trainno=?";
	               PreparedStatement pst=(PreparedStatement) conn.prepareStatement(sql);
	               pst.setString(1, "Cancelled");
	               pst.setString(2, train_no);
	               pst.executeUpdate();
	  	         conn.close();
	  	    	   }
	  	    	   catch(Exception e1)
	                 {
	                     e1.printStackTrace();
	                 }  
	    	   JTable t1;
	           ResultSet rss;
	           String[] col= {"#No","from","To", "Days","Status"};
	           try
	           {
		           f2.repaint();

	               CallConn trans=new CallConn();
	               Connection trans123=(Connection) trans.call();
	               String sqlm="select * from train";
	               PreparedStatement pstx=(PreparedStatement) trans123.prepareStatement(sqlm);
	               //pstx.setString(1,user);
	               ResultSet rsz=(ResultSet) pstx.executeQuery();
	               int rowCount=0;
	               while (rsz.next())
	               {
	                   rowCount++;
	               }
	               panel10.removeAll();
	               panel10.revalidate();
	               panel10.repaint();
	               Object[][] data= new Object[rowCount][5];
	               PreparedStatement stmtjcb= (PreparedStatement) trans123.prepareStatement(sqlm);
	               rss=stmtjcb.executeQuery(sqlm);
	               int i=0;
	               while (rss.next())
	               {
	                   data[i][0]=rss.getString("trainno");
	                   data[i][1]=rss.getString("froms");
	                   data[i][2]=rss.getString("tos");
	                   data[i][3]=rss.getString("days");
	                   data[i][4]=rss.getString("status");
	                   i++;
	               }
	              
	               t1=new JTable(data,col);
	               TableColumnModel columnModel = t1.getColumnModel();
	               columnModel.getColumn(0).setPreferredWidth(3);
	               columnModel.getColumn(1).setPreferredWidth(3);
	               columnModel.getColumn(2).setPreferredWidth(35);
	               columnModel.getColumn(3).setPreferredWidth(5);
	               columnModel.getColumn(4).setPreferredWidth(5);
	               JScrollPane scrollPane= new JScrollPane(t1);
	               scrollPane.setPreferredSize(new Dimension(350, 450));
	               //scrollPane.setBounds(455,120,300,450);
	               //st1.setFillsViewportHeight(true);
	               
	               //f12.setSize(1368, 900);
	               //f12.getContentPane().add(scrollPane);
	               //f12.setVisible(true);
	               trans123.close();  
	               panel10.add(scrollPane);
                   JOptionPane.showMessageDialog(null,"Train has been Cancelled and Money has been refunded to Customers");
	           }
	           catch(Exception e1)
	           {
	               e1.printStackTrace();
	           }  
	           jt27.setText("Enter Train No.");
	           flag27=0;
	           jt27.setForeground(Color.gray);
	           CallConn cx=new CallConn();
	           Connection connx=(Connection) cx.call();
	           try
	           {
                   String sql="update passenger SET status=? where trainno=?";
	               PreparedStatement pst=(PreparedStatement) connx.prepareStatement(sql);
	               pst.setString(1,"Cancelled");
	               pst.setString(2,num);
	               pst.executeUpdate();
		           connx.close();
	           }
	               catch(Exception e1)
		           {
		               e1.printStackTrace();
		           } 
	           CallConn c=new CallConn();
               Connection conn=(Connection) c.call();
	           try {
	               String sql2="select * from passenger where trainno=? and status=?";
	               PreparedStatement pst2=(PreparedStatement) conn.prepareStatement(sql2);
	               pst2.setString(1,num);
	               pst2.setString(2,"Booked");
	               ResultSet rs1=(ResultSet) pst2.executeQuery();
	               while(rs1.next())
	                 {
	                   	int amo=rs1.getInt(14);
	                   	String us=rs1.getString(2);
	                   	try
		    	           {
		                       String sql="update signup SET amount=? where user=?";
		    	               PreparedStatement pst=(PreparedStatement) conn.prepareStatement(sql);
		    	               pst.setInt(1,acc_amount+amo);
		    	               pst.setString(2,user);
		    	               pst.executeUpdate();
		    	               conn.close();
		    	           }
		    	               catch(Exception e1)
		    		           {
		    		               e1.printStackTrace();
		    		           } 
	                 }
	               conn.close();
	           }
	               catch(Exception e1)
		           {
		               e1.printStackTrace();
		           } 
	       }
	     }     
	    }
	   private static class LoginHandler14 implements ActionListener
	   {
	     @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
	     {
	       String ramu1 =e.getActionCommand();
	       if(ramu1.equalsIgnoreCase("Logout"))      
	       {
	    	   f2.setVisible(false);
	    	   f.setVisible(true);
	       }
	     }
	   }
	   public static class jcbHandler implements ItemListener
       {
         public void itemStateChanged(ItemEvent e)
         {
                this.select();
         }
         public void select()
         {
             if (jcb.getSelectedIndex()!=0)
             {
             try
             {
               CallConn c=new CallConn();
               Connection conn=(Connection) c.call();
               String sql8="select amount from train where trainno=? ";
      
               PreparedStatement stmt1= (PreparedStatement) conn.prepareStatement(sql8);
               stmt1.setString(1,(String)jcb.getSelectedItem());
      
               ResultSet rs1=(ResultSet) stmt1.executeQuery();
               while(rs1.next())
                 {
                   amount_train=rs1.getInt("amount");
                   String k= Integer.toString(amount_train);
                   jt17.setText(k);
                   jt16.setText(acc);
                   amount_train1=amount_train;
                 }
               conn.close();
             }
              catch(Exception e1)
              {
                   JOptionPane.showMessageDialog(null,"Error");
              }
         }
         }
        }
	   }

	    
	  

