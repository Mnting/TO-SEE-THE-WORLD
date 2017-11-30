package airport;

import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminPlane {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPlane window = new AdminPlane();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public AdminPlane() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 494, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 482, 334);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("出发地");
		lblNewLabel.setBounds(25, 43, 61, 16);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(98, 38, 130, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("目的地");
		label.setBounds(255, 43, 61, 16);
		panel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(332, 38, 130, 26);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("出发机场");
		label_1.setBounds(25, 86, 61, 16);
		panel.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(98, 81, 130, 26);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_2 = new JLabel("到达机场");
		label_2.setBounds(255, 86, 61, 16);
		panel.add(label_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(332, 81, 130, 26);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("出发时间");
		lblNewLabel_1.setBounds(25, 129, 61, 16);
		panel.add(lblNewLabel_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(98, 124, 130, 26);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_3 = new JLabel("到达时间");
		label_3.setBounds(255, 129, 61, 16);
		panel.add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setBounds(332, 124, 130, 26);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_4 = new JLabel("日期");
		label_4.setBounds(25, 168, 61, 16);
		panel.add(label_4);
		
		textField_6 = new JTextField();
		textField_6.setBounds(98, 163, 130, 26);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_5 = new JLabel("价格");
		label_5.setBounds(255, 168, 61, 16);
		panel.add(label_5);
		
		textField_7 = new JTextField();
		textField_7.setBounds(332, 163, 130, 26);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel label_6 = new JLabel("航班号");
		label_6.setBounds(25, 209, 61, 16);
		panel.add(label_6);
		
		textField_8 = new JTextField();
		textField_8.setBounds(98, 204, 130, 26);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel label_7 = new JLabel("航空公司");
		label_7.setBounds(255, 209, 61, 16);
		panel.add(label_7);
		
		textField_9 = new JTextField();
		textField_9.setBounds(332, 204, 130, 26);
		panel.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel label_8 = new JLabel("余票量");
		label_8.setBounds(25, 249, 61, 16);
		panel.add(label_8);
		
		textField_10 = new JTextField();
		textField_10.setBounds(98, 244, 130, 26);
		panel.add(textField_10);
		textField_10.setColumns(10);
		
		JButton button = new JButton("添加航班");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Planeinformation.departurecity=textField.getText();
				Planeinformation.date=textField_6.getText();
				Planeinformation.arrivalcity=textField_1.getText();
				Planeinformation.flightnumber=textField_8.getText();
				Planeinformation.departureairport=textField_2.getText();
				Planeinformation.arrivalairport=textField_3.getText();
				Planeinformation.departuretime=textField_4.getText();
				Planeinformation.arrivaltime=textField_5.getText();
				Planeinformation.price=textField_7.getText();
				Planeinformation.airline=textField_9.getText();
				Planeinformation.ticketamount=textField_10.getText();
				try {
					Planeinformation.addairline();
					frame.setVisible(false);
					Admin.window.frame.setVisible(false);
					
					Admin.defaultTableModel_2.setRowCount(0);
					Admin.window=new Admin();
					Admin.window.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button.setBounds(168, 282, 117, 29);
		panel.add(button);

		
	}
}
