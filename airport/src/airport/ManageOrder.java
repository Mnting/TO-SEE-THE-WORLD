package airport;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.sql.*;
public class ManageOrder {

	static JScrollPane scrollPanee;
	static String rOrderID;
	public static JFrame frame;
	static ManageOrder window;
	public static DefaultTableModel defaultTableModel;
	static JTable table;
	static JLabel lblNewLabel,lblTel,label,label_1,label_2,label_3,label_4,label_5,label_6,label_7,label_8,label_9,label_10,label_11,lblIdnum;
	
	/**
	 * Launch the application.
	 */

	static void mngshow(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					window = new ManageOrder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManageOrder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 725, 613);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("\u4E58\u673A\u4EBA\uFF1A");
		lblNewLabel.setBounds(0, 31, 60, 18);
		frame.getContentPane().add(lblNewLabel);
		
		  lblTel = new JLabel("TEL\uFF1A");
		lblTel.setBounds(203, 31, 44, 18);
		frame.getContentPane().add(lblTel);
		
		  label = new  JLabel("");
		  label.setText(Orderwindow.account[0][0]);
		label.setBounds(74, 31, 89, 18);
		frame.getContentPane().add(label);
		
		label_1 = new  JLabel("");
		label_1.setBounds(244, 31, 112, 18);
		label_1.setText(Orderwindow.account[0][2]);
		frame.getContentPane().add(label_1);
		
		  lblIdnum = new JLabel("IDnum\uFF1A");
		lblIdnum.setBounds(387, 31, 72, 18);
		frame.getContentPane().add(lblIdnum);
		
		  label_2 = new JLabel("");
		  label_2.setText(Orderwindow.account[0][1]);
		label_2.setBounds(448, 31, 160, 18);
		frame.getContentPane().add(label_2);
		
		JButton btnNewButton = new JButton("\u6539\u7B7E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			 
			    

				try {
					
						frame.setVisible(false);
						Changeflight.main(null);
						ticketinformation.find();
						
						
					}
				 catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		});
		btnNewButton.setBounds(74, 223, 113, 27);
		frame.getContentPane().add(btnNewButton);
		  
		  JButton button = new JButton("\u9000\u7968");
		  button.addMouseListener(new MouseAdapter() {
		  	@Override
		  	public void mouseClicked(MouseEvent arg0) {
		  		

		  		/*Object[] options = { "YES", "CANCEL" }; 
		  		int flag = JOptionPane.showOptionDialog(null, "确认退票？", "Warning", 
		  		JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, 
		  		null, options, options[0]); 
		  		if(flag==1){*/
		  		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
				rOrderID = df.format(new Date());// new Date()为获取当前系统时间
		  		try {
		  			
					ticketinformation.refoundticket();
					window = new ManageOrder();
						label.setText("");
						label_1.setText("");
						label_2.setText("");
						label_3.setText("");
					    label_4.setText("");
					    label_7.setText("");
					    label_6.setText("");
					    label_5.setText("");
					    label_8.setText("");
						frame.setVisible(false);
						
						defaultTableModel.setRowCount(0);
						
						window.frame.setVisible(true);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  		
		  	}
		  	
		  });
		  button.setBounds(317, 223, 113, 27);
		  frame.getContentPane().add(button);
		
		  label_3 = new JLabel("");
		label_3.setBounds(14, 78, 108, 28);
		frame.getContentPane().add(label_3);
		
		  label_4 = new JLabel("");
		label_4.setBounds(14, 110, 166, 18);
		frame.getContentPane().add(label_4);
		
		  label_5 = new JLabel((String) null);
		label_5.setBounds(14, 172, 72, 18);
		frame.getContentPane().add(label_5);
		
		  label_6 = new JLabel();
		label_6.setText((String) null);
		label_6.setBounds(24, 141, 72, 18);
		frame.getContentPane().add(label_6);
		
		  label_7 = new JLabel();
		label_7.setText((String) null);
		label_7.setBounds(619, 142, 72, 18);
		frame.getContentPane().add(label_7);
		
		  label_8 = new JLabel((String) null);
		label_8.setBounds(619, 172, 72, 18);
		frame.getContentPane().add(label_8);
		
		  label_9 = new JLabel("\u2014\u2014\u2014\u2014>");
		label_9.setBounds(284, 172, 72, 18);
		frame.getContentPane().add(label_9);
		
		  label_10 = new JLabel((String) null);
		label_10.setBounds(14, 203, 118, 18);
		frame.getContentPane().add(label_10);
		
		  label_11 = new JLabel((String) null);
		label_11.setBounds(556, 203, 135, 18);
		frame.getContentPane().add(label_11);
		
		 	
	  
		
		
		    JPanel panel = new JPanel();
		    panel.setBounds(0, 282, 707, 284);
		    frame.getContentPane().add(panel);
		    panel.setLayout(null);
		    
		    
		    
		    Vector<String> columnNames2 = new Vector<>();
	        columnNames2.add("出发地");
	        columnNames2.add("到达地");
	        columnNames2.add("日期");
	        columnNames2.add("出发时间");
	        columnNames2.add("到达时间");
	        columnNames2.add("航班号");
	        columnNames2.add("订单号");
		    scrollPanee = new JScrollPane();
		    scrollPanee.setBounds(0, 0, 707, 284);
		    panel.add(scrollPanee);
		   
		    
		    table = new JTable();
	        defaultTableModel = new DefaultTableModel(UserInformation.ordertickets, columnNames2);        
	        table.setModel(defaultTableModel);      
	        scrollPanee.setViewportView(table);
	        
	        JButton btnNewButton_1 = new JButton("显示");
	        btnNewButton_1.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent arg0) {
	        		  
	        		 Connection con = null;
	        	     //驱动程序名
	        	     String driver = "com.mysql.jdbc.Driver";

	        	     String url = "jdbc:mysql://localhost:3306/airport";
	        	    //MySQL配置时的用户名
	        	     String user = "root";
	        	    //MySQL配置时的密码
	        	     String password = "526697";
	        	    
						try {
							Class.forName(driver);
						
				
					
						con = DriverManager.getConnection(url,user,password);
					
					
						if(!con.isClosed())
						     System.out.println("Succeeded connecting to the Database!");
	                   Statement statement = con.createStatement();
					
	                   //要执行的SQL语句
	                   String sql = "select * from airport.passengerinformation";
	                   //3.ResultSet类，用来存放获取的结果集！！
	                   
						ResultSet rs = statement.executeQuery(sql);
	                   while(rs.next()){

	                      if( rs.getString("orderID").equals(table.getValueAt(table.getSelectedRow(),6).toString()))
	                       	{
	                    	  label.setText(rs.getString("realname"));
	                    	  label_1.setText(rs.getString("TEL"));
	                    	  label_2.setText(rs.getString("IDnum"));
	                    	 
	                           }
	                       }
	                   rs.close();
	                    	  con.close();
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
   
	    	        label_3.setText(table.getValueAt(table.getSelectedRow(),0).toString()+table.getValueAt(table.getSelectedRow(),1).toString());
	    			label_7.setText(table.getValueAt(table.getSelectedRow(),2).toString());
	    			label_6.setText(table.getValueAt(table.getSelectedRow(),2).toString());
	    			 label_5.setText(table.getValueAt(table.getSelectedRow(),3).toString());
	    			 label_8.setText(table.getValueAt(table.getSelectedRow(),4).toString());
	    			  label_4.setText(table.getValueAt(table.getSelectedRow(),5).toString());   
	        	}
	        });
	        btnNewButton_1.setBounds(566, 223, 113, 27);
	        frame.getContentPane().add(btnNewButton_1);
	        
	      
	}
}
