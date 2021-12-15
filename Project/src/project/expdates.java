package project;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

public class expdates {
	DefaultTableModel model = new DefaultTableModel();
    JTable tabGrid = new JTable(model);
    JScrollPane scrlPane = new JScrollPane(tabGrid);
	expdates(){
		JFrame f = new JFrame("Expiry Dates");
		f.setLocationRelativeTo(null);
		Connection c = null;
		Statement stmt = null;
		scrlPane.setBounds(0,0,500,600);
	    f.add(scrlPane);
	    tabGrid.setFont(new Font ("Times New Roman",0,15));
	    
	    model.addColumn("medid");model.addColumn("compname");model.addColumn("medname");model.addColumn("expdate");
	    int r=0;
					try {
						c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/java", "postgres", "1234");
						Statement smt = c.createStatement();
						String sql="select mid,cname,mname,expdate from medicine orderby expdates ASC";
						ResultSet rs = smt.executeQuery(sql);
						while(rs.next())
			            {
			            	model.insertRow(r++,new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});

			            }
			
						smt.close();
				        c.close();
				        
					} 
					catch (Exception we) {
						System.out.println(we);
						JOptionPane.showMessageDialog(null,"SQL Error:"+we);
					}
		f.setSize(500,320);
		f.setLayout(null);
		f.setVisible(true);
		f.setBackground(Color.BLACK);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
