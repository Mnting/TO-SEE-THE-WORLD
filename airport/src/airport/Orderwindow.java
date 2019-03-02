package airport;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Orderwindow {
	static String OrderID;
	private JFrame frame; 
	JTable table_2;
	static String [][]account=new String[5][4];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Orderwindow window = new Orderwindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void windowclose(){
		frame.setVisible(false);
	}
	
	/**
	 * Create the application.
	 */
	
	
	public Orderwindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 451, 527);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 433, 169);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setText(ticketinformation.departurecity+"-"+ticketinformation.arrivalcity);
		label.setBounds(0, 0, 108, 28);
		panel.add(label);
		
		JLabel lblXx = new JLabel("");
		lblXx.setBounds(0, 32, 166, 18);
		lblXx.setText(ticketinformation.airline+ticketinformation.flightnumber);
		panel.add(lblXx);
		
		JLabel lblTime = new JLabel("");
		lblTime.setBounds(0, 83, 72, 18);
		lblTime.setText(ticketinformation.departuretime);
		panel.add(lblTime);
		
		JLabel lblDate = new JLabel();
		lblDate.setBounds(0, 63, 72, 18);
		lblDate.setText(Reserve.textField_2.getText());
		panel.add(lblDate);
		
		JLabel lblDate_1 = new JLabel();
		lblDate_1.setText(Reserve.textField_2.getText());
		lblDate_1.setBounds(355, 63, 72, 18);
		panel.add(lblDate_1);
		
		JLabel lblTime_1 = new JLabel("");
		lblTime_1.setBounds(355, 83, 72, 18);
		lblTime_1.setText(ticketinformation.arrivaltime);
		panel.add(lblTime_1);
		
		JLabel label_1 = new JLabel("\u2014\u2014\u2014\u2014>");
		label_1.setBounds(174, 83, 72, 18);
		panel.add(label_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setText(ticketinformation.departureairport);
		lblNewLabel.setBounds(0, 114, 118, 18);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(335, 114, 106, 18);
		lblNewLabel_1.setText(ticketinformation.arrivalairport);
		panel.add(lblNewLabel_1);
		
		Vector<String>columnNames = new Vector<>();
		columnNames.add("乘客姓名");
		columnNames.add("身份证号");
		columnNames.add("电话号");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 167, 433, 262);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(14, 13, 393, 236);
		panel_2.add(scrollPane);
		table_2 = new JTable();
		try {
			Accountinformation.displayaccount();
			DefaultTableModel dtm = new DefaultTableModel(Accountinformation.account,columnNames);
			table_2.setModel(dtm);
			scrollPane.setViewportView(table_2);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 429, 433, 51);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton button = new JButton("\u652F\u4ED8");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
				OrderID = df.format(new Date());// new Date()为获取当前系统时间
			try {
			    account[0][0]=table_2.getValueAt(table_2.getSelectedRow(),0).toString();
				account[0][1]=table_2.getValueAt(table_2.getSelectedRow(),1).toString();
				account[0][2]=table_2.getValueAt(table_2.getSelectedRow(),2).toString();
					ticketinformation.orderadd();
					ticketinformation.changeticketamount();
					ticketinformation.addpassengerinformation();
					windowclose();
					Reserve.window.setVisible(false);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setBounds(149, 13, 113, 27);
		panel_1.add(button);
}
}
