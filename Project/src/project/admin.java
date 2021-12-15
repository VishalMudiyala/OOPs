package project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class admin {
	
	JMenuBar mb;
	JMenu b1,b2,b3,b6;
	JMenuItem i1,i2,i3,s1,s2,s3,bs1,bs2,be1;
	admin(){
		 
		JFrame f = new JFrame("PMS");
		f.getContentPane().setBackground(Color.decode("#50C878"));
		
		JPanel p = new JPanel();
		ImageIcon e = new ImageIcon(this.getClass().getResource("/3.jpg"));
		JLabel l = new JLabel(e);
		l.setSize(1070,450);
	    p.setBounds(120,160,1020,450);
	    p.setBackground(Color.LIGHT_GRAY);
	    p.setLayout(null);
	    p.setBackground(Color.decode("#B5EAAA"));
	    
	    JLabel l3 = new JLabel("Welcome,");
		l3.setBounds(40, 10, 900, 60);
		l3.setFont(new Font("Lucida Calligraphy", Font.BOLD, 30));
		l3.setForeground(Color.black);
		l.add(l3);
		JLabel l4 = new JLabel("Admin");
		l4.setBounds(180, 50, 900, 60);
		l4.setFont(new Font("Lucida Calligraphy", Font.BOLD, 40));
		l4.setForeground(Color.black);
		l.add(l4);
		p.add(l);
		
		JLabel l1 = new JLabel("Pharmacy Management System");
		l1.setBounds(200, 0, 900, 60);
		l1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 49));
		l1.setOpaque(true);
		l1.setForeground(Color.decode("#FF2400"));
		l1.setBackground(Color.decode("#4B5320"));
		
		JLabel l2 = new JLabel("Admin");
		l2.setBounds(15,60,200,40);
		l2.setVerticalAlignment(JLabel.TOP);
	    l2.setFont(new Font("Eras Bold ITC", Font.BOLD, 30));
		l2.setPreferredSize(new Dimension(500, 400));
		l2.setForeground(Color.decode("#862323"));
		
	    b1 = new JMenu("     Dashboard");
	    b1.setFont(new Font("Segoe Print", Font.BOLD, 30));
		b1.setPreferredSize(new Dimension(260, 400));
	    b1.setForeground(new Color(225, 225, 0));
	    
	    b2 = new JMenu("     Manage CM");
	    b2.setFont(new Font("Segoe Print", Font.BOLD, 30));
		b2.setPreferredSize(new Dimension(260, 400));
	    b2.setForeground(new Color(225, 225, 0));
	    
	    b3 = new JMenu("     Manage D  ");
	    b3.setPreferredSize(new Dimension(150, 400));
	    b3.setFont(new Font("Segoe Print", Font.BOLD, 30));
		b3.setPreferredSize(new Dimension(290, 400));
	    b3.setForeground(new Color(225, 225, 0));
	    
	    b6 = new JMenu("  LogOut  ");
	    bs1 = new JMenuItem("Yes");
	    bs1.setFont(new Font("Segoe Print", Font.BOLD, 20));
	    bs2 = new JMenuItem("NO");
	    bs2.setFont(new Font("Segoe Print", Font.BOLD, 20));
	    b6.setFont(new Font("Segoe Print", Font.BOLD, 30));
		b6.setPreferredSize(new Dimension(200, 400));
	    b6.setForeground(new Color(225, 225, 0));
	    b6.add(bs1);b6.add(bs2);
	    bs1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				login o = new login();
				f.dispose();
			}
	    	
	    });
	    
	    mb = new JMenuBar();
	    mb.add(b1);mb.add(b2);mb.add(b3);mb.add(b6);
	    mb.setBackground(Color.decode("#6200ad"));///////////////---)))----))))
	    mb.setBounds(130, 110, 1010, 40);
	    
	    
	    
	    String data[][]={ {"101","Amit","670000"},    
                {"102","Jai","780000"},    
                {"101","Sachin","700000"}};    
		 String column[]={"ID","NAME","SALARY"};  
		JTable t = new JTable(data,column);
		t.setBounds(10,40,500,300);          
		JScrollPane scroll = new JScrollPane(t);
		
	    
	    b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JLabel l3;
				JLabel l4;
				String st = "Company Manager";
				Connection c = null;
				Statement stmt = null;
			      try {
			         Class.forName("org.postgresql.Driver");
			         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres", "1234");
			         stmt = c.createStatement();
			         String sql = "select count(distinct role) as nocm from register where role='"+st+"'";
			         
			         stmt.addBatch("");
			         ResultSet rs = stmt.executeQuery(sql);
			         
			         if(rs.next()) {
			        	 int noCM = rs.getInt("nocm");
			        	 l3=new JLabel("No of Company Managers = "+noCM);
			        	 l3.setBounds(10,10,500,35);
			        	 l3.setFont(new Font("Verdana", Font.BOLD, 30));
			     		 l3.setPreferredSize(new Dimension(500, 400));
			        	 p.add(l3);
			        	 f.setSize(2000,675);
			         }
			         
			         stmt.close();
			         c.close();
			         
			        
			      
			      } catch (Exception e1) {
			         e1.printStackTrace();
			         System.err.println(e1.getClass().getName()+": "+e1.getMessage());
			         System.exit(0);
			      }
			}
		});
	    f.add(mb);
		f.add(l1);f.add(l2);
		f.add(p);
		f.setSize(2000,670);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new admin();
	}
}
