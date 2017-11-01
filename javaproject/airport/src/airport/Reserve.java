package airport;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.Collection;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.awt.ScrollPane;
import java.awt.Label;
import javax.swing.BoxLayout;

public class Reserve extends JFrame {
	static JTextField textField_2;
	static JComboBox comboBox_1,comboBox;

	static Reserve window;

	private JTable table_2;
	public static void main(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Reserve();
					window.setSize(723,168);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	
	/**
	 * Create the application.
	 */
	public Reserve() {
		initialize1();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize1() {
		
		setBounds(100, 100, 723, 576);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 705, 526);
		getContentPane().add(panel);
		panel.setLayout(null);
		
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
		
		String labels[] = { "上海", "北京", "武汉", "泰安", "哈尔滨"};  
		
		comboBox = new JComboBox(labels);
		comboBox.setBounds(14, 76, 95, 27);
		comboBox.setEditable(true); 
		panel.add(comboBox);
		
		comboBox_1 = new JComboBox(labels);
		comboBox_1.setBounds(201, 75, 95, 27);
		comboBox_1.setEditable(true); 
		panel.add(comboBox_1);
		
		JButton btnNewButton = new JButton("<>");
		btnNewButton.setBounds(123, 75, 61, 29);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object cityname;
				cityname=comboBox.getSelectedItem();
				comboBox.setSelectedItem(comboBox_1.getSelectedItem());
				comboBox_1.setSelectedItem(cityname);

			}
		});
		panel.add(btnNewButton);
		panel_1.setLayout(null);
		
		
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setBounds(0, 5, 705, 323);
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
				setSize(723,574);
				ticketinformation.dcity=comboBox.getSelectedItem();
				ticketinformation.acity=comboBox_1.getSelectedItem();
				ticketinformation.date=textField_2.getText();
				try {
					ticketinformation.find();
					DefaultTableModel dtm = new DefaultTableModel(ticketinformation.tableValuse,columnNames);
					table_2.setModel(dtm);
					table_2.setBounds(0, 0, 705, 356);
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
		    
		JButton button_1 = new JButton("订票");
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
				Orderwindow.main(null);
				}
			}
		});
		button_1.setBounds(578, 329, 113, 27);
		panel_1.add(button_1);
		JLabel label_3 = new JLabel("**************************************************************************************************");
		label_3.setBounds(0, 150, 705, 18);
		panel.add(label_3);
		
		
		
		
		

	}
}
