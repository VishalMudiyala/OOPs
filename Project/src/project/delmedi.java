package project;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class delmedi {
	delmedi(){
		JFrame f = new JFrame("Delete Medicine");
		JLabel l2,l3,l4,l5,l6,l7,l8;
		JTextField t1,t2,t3;
		JPanel p = new JPanel();
		p.setLayout(null);
	    p.setBounds(0,0,1070,420);
	    p.setBackground(Color.decode("#B5EAAA"));
	    
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		f.setSize(500, height-400);
	    
	    f.setLocationRelativeTo(null);
	    f.add(p);
	    
	    l2 = new JLabel("Company Name :");
		l2.setFont(new Font("Verdana", Font.ITALIC, 20));
		l2.setBounds(20,60,500,20);
		t1 = new JTextField();
		t1.setBounds(240, 60, 200, 30);
		
		l3 = new JLabel("Medicine Id:");
		l3.setFont(new Font("Verdana", Font.ITALIC, 20));
		l3.setBounds(20,115,500,20);
		t2 = new JTextField();
		t2.setBounds(240, 110, 200, 30);
		
		l4 = new JLabel("Medicine Name :");
		l4.setFont(new Font("Verdana", Font.ITALIC, 20));
		l4.setBounds(20,165,500,20);
		t3 = new JTextField();
		t3.setBounds(240, 160, 200, 30);
		p.add(l4);p.add(l2);p.add(l3);
		p.add(t1);p.add(t2);p.add(t3);
		
		JButton a = new JButton("Delete");
		a.setBounds(180, 230, 80, 30);
		a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection c = null;
				Statement stmt = null;
				int te=0;
					String s1 = t1.getText();
					String s2 = t2.getText();
					String s3 = t3.getText();
					int r = 0;
					try {
						c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres", "1234");
						Statement smt = c.createStatement();
						String sql="delete from medicine where cname='"+s1+"' and mid='"+Integer.parseInt(s2)+"' and mname='"+s3+"'";
						smt.executeUpdate(sql);
						JOptionPane.showMessageDialog(null,"Record is deleted.");
						smt.close();
				        c.close();
				        
					} 
					catch (Exception we) {
						System.out.println(we);
						JOptionPane.showMessageDialog(null,"SQL Error:"+we);
					}
			}
		});
		
		JButton b = new JButton("Cancel");
		b.setBounds(380, 230, 80, 30);
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		
		p.add(a);p.add(b);
		//f.setSize(500,320);
		f.setLayout(null);
		f.setVisible(true);
		f.setBackground(Color.BLACK);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
