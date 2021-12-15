package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class register {
	register(){
		String[] ar = {"select","Company Manager","Distributer"};
		JPanel pan = new JPanel();
		pan.setLayout(null);
		pan.setBounds(340, 60, 570, 480);
		pan.setBackground(Color.decode("#B5EAAA"));
		
		JFrame f = new JFrame("register");
		f.getContentPane().setBackground(Color.decode("#50C878"));
		JLabel l1 = new JLabel("Pharmacy Management System");
		l1.setBounds(50, 0, 500, 50);
		l1.setFont(new Font("Verdana", Font.BOLD, 27));
		l1.setForeground(new Color(0,0,255));
		
		JLabel l2 = new JLabel("REGISTER");
		l2.setBounds(230, 60, 200, 50);
		l2.setFont(new Font("Verdana", Font.BOLD, 20));
		l2.setForeground(new Color(255,0,0));
		
		JLabel l3 = new JLabel("First Name");
		l3.setBounds(80, 100, 200, 50);
		l3.setFont(new Font("Verdana", Font.ITALIC, 20));
		
		JLabel l4 = new JLabel("Last Name");
		l4.setBounds(80, 160, 200, 50);
		l4.setFont(new Font("Verdana", Font.ITALIC, 20));
		
		JLabel l5 = new JLabel("E-Mail");
		l5.setBounds(80, 220, 200, 50);
		l5.setFont(new Font("Verdana", Font.ITALIC, 20));
		
		JLabel l6 = new JLabel("Password");
		l6.setBounds(80, 280, 200, 50);
		l6.setFont(new Font("Verdana", Font.ITALIC, 20));
		
		JLabel l7 = new JLabel("Role:");
		l7.setBounds(80, 340, 200, 50);
		l7.setFont(new Font("Verdana", Font.ITALIC, 20));
		
		JTextField t1 = new JTextField();
		t1.setBounds(210, 110, 200, 30);
		JTextField t2 = new JTextField();
		t2.setBounds(210, 170, 200, 30);
		JTextField t3 = new JTextField();
		t3.setBounds(210, 230, 200, 30);
		JPasswordField p = new JPasswordField();
		p.setBounds(210, 290, 200, 30);
		
		JComboBox<String> l = new JComboBox<>(ar);
		l.setBounds(210, 350, 110, 30);
		
		JButton b1 = new JButton("Register");
		b1.setBounds(380, 400, 100, 30);
		b1.setFont(new Font("Verdana", Font.PLAIN, 15));
		b1.setBackground(Color.yellow);
		
		f.add(pan);
		pan.add(l1);pan.add(l2);pan.add(l3);pan.add(l4);pan.add(l5);pan.add(l6);pan.add(l7);
		pan.add(t1);pan.add(t2);pan.add(t3);pan.add(p);pan.add(l);pan.add(b1);
		
		f.setSize(2000,675);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String firstname = t1.getText();
				String lastname = t2.getText();
				String email = t3.getText();
				String password = new String(p.getPassword());
				String role = (String) l.getSelectedItem();
				Connection c = null;
				Statement stmt = null;
				
			      try {
			    	  if((firstname.equals(""))||(lastname.equals(""))||(email.equals(""))||(password.equals(""))||(role.equals(""))) {
			    		  JOptionPane.showMessageDialog(null,"* Details are Missing !","Warning!!!",JOptionPane.WARNING_MESSAGE);
			    	  }
			    	  else {
			    		  Class.forName("org.postgresql.Driver");
			    		  JOptionPane.showMessageDialog(null,"Registered Succesfully...!");
			    		  login o = new login();
					         c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres", "1234");
					         stmt = c.createStatement();
					         String sql = "insert into register values('"+firstname+"','"+lastname+"','"+email+"','"+password+"','"+role+"')";
					         stmt.executeQuery(sql);
					         f.dispose();
			    	  }
			         
			      
			      } catch (Exception e1) {
			         e1.printStackTrace();
			         System.err.println(e1.getClass().getName()+": "+e1.getMessage());
			         System.exit(0);
			      }
			}
		});
	}
}