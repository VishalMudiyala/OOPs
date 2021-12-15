package project;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class addmedi{
	addmedi(){
		JFrame f = new JFrame("Add Medicine");
		JLabel l2,l3,l4,l5,l6,l7,l8;
		JTextField t1,t2,d1,m1,y1,d2,m2,y2,t4,t5,t6;
		JPanel p = new JPanel();
		p.setLayout(null);
	    p.setBounds(0,0,1070,580);
	    p.setBackground(Color.decode("#B5EAAA"));
	    f.add(p);
	    
	    l2 = new JLabel("Company Name :");
		l2.setFont(new Font("Verdana", Font.ITALIC, 20));
		l2.setBounds(160,65,500,20);
		t6 = new JTextField();
		t6.setBounds(380, 60, 200, 30);
	    
		l3 = new JLabel("Medicine Id:");
		l3.setFont(new Font("Verdana", Font.ITALIC, 20));
		l3.setBounds(160,115,500,20);
		t1 = new JTextField();
		t1.setBounds(380, 110, 200, 30);
		
		l4 = new JLabel("Medicine Name :");
		l4.setFont(new Font("Verdana", Font.ITALIC, 20));
		l4.setBounds(160,165,500,20);
		t2 = new JTextField();
		t2.setBounds(380, 160, 200, 30);
		
		l5 = new JLabel("MFG date:");
		l5.setFont(new Font("Verdana", Font.ITALIC, 20));
		l5.setBounds(160,215,500,20);
		d1 = new JTextField();d1.setBounds(380, 210, 30, 30);
		m1 = new JTextField();m1.setBounds(420, 210, 30, 30);
		y1 = new JTextField();y1.setBounds(460, 210, 60, 30);

		l6 = new JLabel("Expiry date:");
		l6.setFont(new Font("Verdana", Font.ITALIC, 20));
		l6.setBounds(160,265,500,20);
		d2 = new JTextField();d2.setBounds(380, 260, 30, 30);
		m2 = new JTextField();m2.setBounds(420, 260, 30, 30);
		y2 = new JTextField();y2.setBounds(460, 260, 60, 30);
		
		l7 = new JLabel("M R P:");
		l7.setFont(new Font("Verdana", Font.ITALIC, 20));
		l7.setBounds(160,315,500,20);
		t4 = new JTextField();
		t4.setBounds(380, 310, 200, 30);
		
		l8 = new JLabel("	Quantity:");
		l8.setFont(new Font("Verdana", Font.ITALIC, 20));
		l8.setBounds(160,365,500,20);
		t5 = new JTextField();
		t5.setBounds(380, 360, 200, 30);
		
		String ar[]= {"Tablet","Capsule","Syrup","Insulin","ointment","Balm","Drop","Granul","Oil","Powder"};
		JLabel l9 = new JLabel("Med Type:");
		l9.setFont(new Font("Verdana", Font.ITALIC, 20));
		l9.setBounds(160,415,500,20);
		JComboBox<String> l = new JComboBox<>(ar);
		l.setBounds(380, 410, 110, 30);
		
		JButton a = new JButton("Add");
		a.setBounds(270, 470, 80, 30);
		JButton b = new JButton("Cancel");
		b.setBounds(515, 470, 80, 30);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});


		a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection c = null;
				Statement stmt = null;
				if (e.getSource() == a) {
					JOptionPane.showMessageDialog(null,"Added new Medicine", "add",JOptionPane.INFORMATION_MESSAGE);
					try {
						String dt1 = y1.getText() + m1.getText() + d1.getText();
						String dt2 = y2.getText() + m2.getText() + d2.getText();
						c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres", "1234");
						Statement smt = c.createStatement();
						String sql="insert into  medicine values('"+t6.getText()+"',"+ Integer.parseInt(t1.getText()) +",'" + t2.getText() + "','" + dt1 + "','" + dt2
								+ "'," + Double.parseDouble(t4.getText()) + "," + Integer.parseInt(t5.getText()) + ",'"+l.getSelectedItem()+"')";
						ResultSet rs = smt.executeQuery(sql);
						
			
						smt.close();
				        c.close();
				        
					} 
					catch (Exception we) {
						System.out.println(we);
						JOptionPane.showMessageDialog(null,"SQL Error:"+we);
					}
				}
			}
		});
		
		p.add(a);p.add(b);p.add(l9);p.add(l);
		p.add(l2);p.add(l3);p.add(l4);p.add(l5);p.add(l6);p.add(l7);p.add(l8);p.add(t1);p.add(t2);
		p.add(d1);p.add(m1);p.add(y1);p.add(d2);p.add(m2);p.add(y2);p.add(t4);p.add(t5);p.add(t6);
		f.setSize(800,600);
		f.setLayout(null);
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setBackground(Color.BLACK);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new addmedi();
	}

}