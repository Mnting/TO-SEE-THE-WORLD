package airport;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class Changeflight {
	JTextField textField_2;
	JTable table_2;
	static public JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Changeflight window = new Changeflight();
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
	public Changeflight() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 723, 576);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 705, 526);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		

		JLabel lblNewLabel = new JLabel(UserInformation.departurecity);
		lblNewLabel.setBounds(14, 81, 72, 18);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(UserInformation.arrivalcity);
		lblNewLabel_1.setBounds(198, 81, 72, 18);
		panel.add(lblNewLabel_1);
		
		
		JLabel label = new JLabel("始发地");
		label.setBounds(14, 52, 61, 16);
		panel.add(label);
		
		JLabel label_1 = new JLabel("目的地");
		label_1.setBounds(201, 52, 61, 16);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("出发日期");
		label_2.setBounds(360, 52, 61, 16);
		panel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(360, 76, 130, 26);
		textField_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//CCI.main(null);
			}
		});
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 170, 705, 356);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setBounds(0, 7, 705, 321);
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_1.add(scrollpane);
		
		
		Vector<String>columnNames = new Vector<>();
		columnNames.add("航班号");
		columnNames.add("始发机场");
		columnNames.add("目的机场");
		columnNames.add("起飞时间");
		columnNames.add("到达时间");
		columnNames.add("价格");
		columnNames.add("航班号");
		columnNames.add("余票");

		table_2 = new JTable();
		JButton button = new JButton("查询");
		button.setBounds(577, 63, 117, 29);

		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setSize(723,574);
				ticketinformation.dcity=UserInformation.departurecity;
				ticketinformation.acity=UserInformation.arrivalcity;
				ticketinformation.date=textField_2.getText();
				try {
					ticketinformation.find();
					DefaultTableModel dtm = new DefaultTableModel(ticketinformation.tableValuse,columnNames);
					table_2.setModel(dtm);
					scrollpane.setViewportView(table_2);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				
				//PPnel清空
		
			
		});
		panel.add(button);
		    
		JButton button_1 = new JButton("\u6539\u7B7E");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(MainHome.logflag==0){
					logwindow.main("请登录");
				}else{
				
			 ticketinformation.airline = table_2.getValueAt(table_2.getSelectedRow(),0).toString();
          	 ticketinformation.departuretime =table_2.getValueAt(table_2.getSelectedRow(),1).toString();
          	 ticketinformation.arrivaltime =table_2.getValueAt(table_2.getSelectedRow(),2).toString();
          	 ticketinformation.departureairport = table_2.getValueAt(table_2.getSelectedRow(),3).toString();
          	 ticketinformation.arrivalairport = table_2.getValueAt(table_2.getSelectedRow(),4).toString();
          	 ticketinformation.price = table_2.getValueAt(table_2.getSelectedRow(),5).toString();
          	 ticketinformation.flightnumber =table_2.getValueAt(table_2.getSelectedRow(),6).toString();
          	 ticketinformation.ticketamount = Integer.parseInt(table_2.getValueAt(table_2.getSelectedRow(),7).toString());
          	try {
				ticketinformation.changeticket();ManageOrder.window.frame.setVisible(false);
				ManageOrder.defaultTableModel.setRowCount(0);
				ManageOrder.window = new ManageOrder();
				ManageOrder.window.frame.setVisible(false);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          	 frame.setVisible(false);
				}
			}
		});
		button_1.setBounds(628, 329, 63, 27);
		panel_1.add(button_1);
		JLabel label_3 = new JLabel("**************************************************************************************************");
		label_3.setBounds(0, 150, 705, 18);
		panel.add(label_3);
		
		
		
		
		

	}
}