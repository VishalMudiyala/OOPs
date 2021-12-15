package project;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class compman{
	JFrame f;JPanel p;JLabel l1,l2;JMenuBar mb;
	
	JMenu b1,m,ms,b4,b5,b6;
	JMenuItem i1,i2,i3,s1,s2,s3,bs1,bs2,be1;
	
	compman(){
		
		f = new JFrame("PMS");
		//f.getContentPane().setBackground(Color.PINK);
		f.getContentPane().setBackground(Color.decode("#50C878"));
		p = new JPanel();
		ImageIcon e = new ImageIcon(this.getClass().getResource("/3.jpg"));
		JLabel l = new JLabel(e);
		l.setSize(1070,450);
		p.setLayout(null);
	    p.setBounds(120,160,1070,450);
	    p.setBackground(Color.decode("#B5EAAA"));
	    f.add(p);
	    p.add(l);
	    
	    JLabel l3 = new JLabel("Welcome,");
		l3.setBounds(40, 10, 900, 60);
		l3.setFont(new Font("Lucida Console", Font.BOLD, 30));
		l3.setForeground(Color.black);
		l.add(l3);
		JLabel l4 = new JLabel("Company Manager");
		l4.setBounds(80, 50, 900, 60);
		l4.setFont(new Font("Lucida Console", Font.BOLD, 40));
		l4.setForeground(Color.black);
		l.add(l4);
	    
		l1 = new JLabel("Pharmacy Management System");
		l1.setBounds(200, 0, 900, 60);
		l1.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 49));
		l1.setOpaque(true);
		l1.setForeground(Color.decode("#FF2400"));
		l1.setBackground(Color.decode("#4B5320"));
		
		l2 = new JLabel("Company Manager");
		l2.setBounds(15,60,500,40);
		l2.setVerticalAlignment(JLabel.TOP);
	    l2.setFont(new Font("Eras Bold ITC", Font.BOLD, 30));
		l2.setPreferredSize(new Dimension(500, 400));
	    l2.setForeground(Color.decode("#862323"));
		
	    b1 = new JMenu("Dashboard");
	    b1.setBounds(130, 110, 180, 40);
	    b1.setFont(new Font("Segoe Print", Font.BOLD, 20));
		b1.setPreferredSize(new Dimension(190, 400));
		b1.setForeground(new Color(225, 225, 0));
	    
	    mb = new JMenuBar();
	    m = new JMenu("Manage Details");
	    i1 = new JMenuItem("Add Medicine");
	    i1.setFont(new Font("Segoe Print", Font.BOLD, 15));
	    i1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addmedi a = new addmedi();
			}
	    	
	    });
	    i2 = new JMenuItem("Delete Medicine");
	    i2.setFont(new Font("Segoe Print", Font.BOLD, 15));
	    i2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				delmedi a = new delmedi();
			}
	    	
	    });
	    i3 = new JMenuItem("Update Medicine");
	    i3.setFont(new Font("Segoe Print", Font.BOLD, 15));
	    i3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				updmedi a = new updmedi();
			}
	    	
	    });
	    
	    m.add(i1);m.add(i2);m.add(i3);
	    m.setFont(new Font("Segoe Print", Font.BOLD, 20));
		m.setPreferredSize(new Dimension(250, 400));
	    m.setForeground(new Color(225, 225, 0));
	    mb.setBackground(Color.decode("#6200ad"));///////////////---)))----))))
	    mb.setBounds(130, 110, 1060, 40);
	    
	    ms = new JMenu("Search");
	    s1 = new JMenuItem("By Company Name ");
	    s1.setFont(new Font("Segoe Print", Font.BOLD, 15));
	    s1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new search(1);
			}
	    	
	    });
	    s2 = new JMenuItem("By Medicine Name ");
	    s2.setFont(new Font("Segoe Print", Font.BOLD, 15));
	    s2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new search(2);
			}
	    	
	    });
	    s3 = new JMenuItem("By Medicine ID");
	    s3.setFont(new Font("Segoe Print", Font.BOLD, 15));
	    s3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new search(3);
			}
	    	
	    });
	    ms.add(s1);ms.add(s2);ms.add(s3);
	    ms.setFont(new Font("Segoe Print", Font.BOLD, 20));
		ms.setPreferredSize(new Dimension(150, 400));
	    ms.setForeground(new Color(225, 225, 0));
	    
	    
	    b4 = new JMenu("Expiry Dates");
	    b4.setBounds(710, 110, 210, 40);
	    b4.setFont(new Font("Segoe Print", Font.BOLD, 20));
		b4.setPreferredSize(new Dimension(210, 400));
	    b4.setForeground(new Color(225, 225, 0));
	    be1 = new JMenuItem("Expiring Soon");
	    be1.setFont(new Font("Segoe Print", Font.BOLD, 15));
	    be1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				expdates o = new expdates();
			}
	    });
	    b4.add(be1);
	    
	    b5 = new JMenu("Bills");
	    b5.setBounds(940, 110, 100, 40);
	    b5.setFont(new Font("Segoe Print", Font.BOLD, 20));
		b5.setPreferredSize(new Dimension(120, 400));
	    b5.setForeground(new Color(225, 225, 0));
	    
	    b6 = new JMenu("LogOut");
	    bs1 = new JMenuItem("Yes");
	    bs1.setFont(new Font("Segoe Print", Font.BOLD, 15));
	    bs2 = new JMenuItem("NO");
	    bs2.setFont(new Font("Segoe Print", Font.BOLD, 15));
	    b6.setBounds(1060, 110, 120, 40);
	    b6.setFont(new Font("Segoe Print", Font.BOLD, 20));
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
	    mb.add(b1);mb.add(m);mb.add(ms);mb.add(b4);mb.add(b5);mb.add(b6);
		f.add(l1);f.add(l2);f.add(mb);
		
		f.setSize(2000,670);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new compman();
	}
}
