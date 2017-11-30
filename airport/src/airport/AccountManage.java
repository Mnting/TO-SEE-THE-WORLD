package airport;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.FocusManager;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountManage {

	static JFrame frame;
	static AccountManage window; 
	private JJTextField textField;
	private JJTextField textField_1;
	private JJTextField textField_2;
	private JJTextField textField_3;
	private JJTextField textField_4;
	private JJTextField textField_5;
	private JJTextField textField_6;
	private JJTextField textField_7;
	private JJTextField textField_8;
	private JJTextField textField_9;
	private JJTextField textField_10;
	private JJTextField textField_11;
	private JJTextField textField_12;
	private JJTextField textField_13;
	private JJTextField textField_14;
	public Dialog add;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new AccountManage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AccountManage() throws ClassNotFoundException, SQLException {
		initialize();
	}

	
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		Accountinformation.displayaccount();
		frame.setTitle("账户信息");
		frame.setBounds(100, 100, 723, 575);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(23, 75, 679, 456);
		frame.getContentPane().add(tabbedPane);
		
		Frame f = null;
		add = new Dialog(f, "添加", true);//弹出的对话框
        add.setBounds(400, 200, 350, 150);//设置弹出对话框的位置和大小
        add.setLayout(new FlowLayout());//设置弹出对话框的布局为流式布局
        JLabel lab = new JLabel("确定添加该乘机人？");//创建lab标签填写提示内容
        JButton okBut = new JButton("确定");//创建确定按钮
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("个人信息", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 6, 646, 59);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("乘机人姓名：");
		label.setBounds(6, 16, 78, 16);
		panel_2.add(label);
		
		JLabel lblTel = new JLabel("TEL：");
		lblTel.setBounds(409, 16, 45, 16);
		panel_2.add(lblTel);
		
		JLabel label_1 = new JLabel("身份证号：");
		label_1.setBounds(174, 16, 71, 16);
		panel_2.add(label_1);
		
		textField = new JJTextField("请输入信息");
		textField.setText(Accountinformation.rowData[0][0]);
		textField.setBounds(84, 13, 78, 26);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JJTextField("请输入信息");
		textField_1.setText(Accountinformation.rowData[0][1]);
		textField_1.setBounds(235, 11, 162, 26);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JJTextField("请输入信息");
		textField_2.setText(Accountinformation.rowData[0][2]);
		textField_2.setBounds(442, 11, 130, 26);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_1 = new JButton("添加");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Accountinformation.realname=textField.getText();
				Accountinformation.TEL=textField_1.getText();
				Accountinformation.IDnum=textField_2.getText();	
				
				try {
					Accountinformation.addaccount();
					window.frame.setVisible(false);
					window = new AccountManage();
					window.frame.setVisible(true);

				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(584, 11, 56, 28);
		panel_2.add(button_1);
		
		
		
		
		JButton button_6 = new JButton("删除");
		button_6.setBounds(584, 11, 56, 28);
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
		            Accountinformation.IDnum=textField_1.getText();	
					Accountinformation.deleteaccount();
					for(int i=0;i<5;i++)
						for(int j=0;j<4;j++)
					Accountinformation.rowData[i][j]=null;
					
					window.frame.setVisible(false);
					window = new AccountManage();
					window.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel_2.add(button_6);
		
		if(Accountinformation.rowData[0][1]!=null)
		{
			button_6.setVisible(true);
			button_1.setVisible(false);
		}
		else
		{
			button_1.setVisible(true);
			button_6.setVisible(false);
		}
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(6, 77, 646, 59);
		panel.add(panel_3);
		
		JLabel label_2 = new JLabel("乘机人姓名：");
		label_2.setBounds(6, 16, 78, 16);
		panel_3.add(label_2);
		
		JLabel label_3 = new JLabel("TEL：");
		label_3.setBounds(411, 16, 45, 16);
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("身份证号：");
		label_4.setBounds(174, 16, 71, 16);
		panel_3.add(label_4);
		
		textField_3 = new JJTextField("请输入信息");
		textField_3.setText(Accountinformation.rowData[1][0]);
		textField_3.setColumns(10);
		textField_3.setBounds(84, 13, 78, 26);
		panel_3.add(textField_3);
		
		textField_4 = new JJTextField("请输入信息");
		textField_4.setText(Accountinformation.rowData[1][1]);
		textField_4.setColumns(10);
		textField_4.setColumns(10);
		textField_4.setBounds(237, 11, 162, 26);
		panel_3.add(textField_4);
		
		textField_5 = new JJTextField("请输入信息");
		textField_5.setText(Accountinformation.rowData[1][2]);
		textField_5.setColumns(10);
		textField_5.setColumns(10);
		textField_5.setBounds(444, 11, 130, 26);
		panel_3.add(textField_5);
		
		JButton button_2 = new JButton("添加");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Accountinformation.realname=textField_3.getText();
				Accountinformation.TEL=textField_4.getText();
				Accountinformation.IDnum=textField_5.getText();	
				
				try {
					Accountinformation.addaccount();
					window.frame.setVisible(false);
					window = new AccountManage();
					window.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(586, 11, 56, 28);
		panel_3.add(button_2);
		
		JButton button_7 = new JButton("删除");
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
		            Accountinformation.IDnum=textField_4.getText();	
					Accountinformation.deleteaccount();
					for(int i=0;i<5;i++)
						for(int j=0;j<4;j++)
					Accountinformation.rowData[i][j]=null;
					
					window.frame.setVisible(false);
					window = new AccountManage();
					window.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		button_7.setBounds(584, 11, 56, 28);
		panel_3.add(button_7);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(6, 148, 646, 59);
		panel.add(panel_4);
		
		if(Accountinformation.rowData[1][1]!=null)
		{
			button_7.setVisible(true);
			button_2.setVisible(false);
		}
		else
		{
			button_2.setVisible(true);
			button_7.setVisible(false);
		}
		
		JLabel label_5 = new JLabel("乘机人姓名：");
		label_5.setBounds(6, 16, 78, 16);
		panel_4.add(label_5);
		
		JLabel label_6 = new JLabel("TEL：");
		label_6.setBounds(412, 16, 45, 16);
		panel_4.add(label_6);
		
		JLabel label_7 = new JLabel("身份证号：");
		label_7.setBounds(174, 16, 71, 16);
		panel_4.add(label_7);
		
		textField_6 = new JJTextField("请输入信息");
		textField_6.setText(Accountinformation.rowData[2][0]);
		textField_6.setColumns(10);
		textField_6.setColumns(10);
		textField_6.setBounds(84, 13, 78, 26);
		panel_4.add(textField_6);
		
		textField_7 = new JJTextField("请输入信息");
		textField_7.setText(Accountinformation.rowData[2][1]);
		textField_7.setColumns(10);
		textField_7.setColumns(10);
		textField_7.setBounds(238, 11, 162, 26);
		panel_4.add(textField_7);
		
		textField_8 = new JJTextField("请输入信息");
		textField_8.setText(Accountinformation.rowData[2][2]);
		textField_8.setColumns(10);
		textField_8.setColumns(10);
		textField_8.setBounds(447, 11, 130, 26);
		panel_4.add(textField_8);
		
		
		JButton button_3 = new JButton("添加");
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Accountinformation.realname=textField_6.getText();
				Accountinformation.TEL=textField_7.getText();
				Accountinformation.IDnum=textField_8.getText();					
				try {
					Accountinformation.addaccount();
					window.frame.setVisible(false);
					window = new AccountManage();
					window.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_3.setBounds(584, 15, 56, 21);
		panel_4.add(button_3);
		
		JButton button_8 = new JButton("删除");
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
		            Accountinformation.IDnum=textField_7.getText();	
					Accountinformation.deleteaccount();
					for(int i=0;i<5;i++)
						for(int j=0;j<4;j++)
					Accountinformation.rowData[i][j]=null;
					
					window.frame.setVisible(false);
					window = new AccountManage();
					window.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		button_8.setBounds(584, 11, 56, 28);
		panel_4.add(button_8);
		
		if(Accountinformation.rowData[2][1]!=null)
		{
			button_8.setVisible(true);
			button_3.setVisible(false);
		}
		else
		{
			button_3.setVisible(true);
			button_8.setVisible(false);
		}
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(6, 219, 646, 59);
		panel.add(panel_5);
		
		JLabel label_8 = new JLabel("乘机人姓名：");
		label_8.setBounds(6, 16, 78, 16);
		panel_5.add(label_8);
		
		JLabel label_9 = new JLabel("TEL：");
		label_9.setBounds(413, 16, 45, 16);
		panel_5.add(label_9);
		
		JLabel label_10 = new JLabel("身份证号：");
		label_10.setBounds(174, 16, 71, 16);
		panel_5.add(label_10);
		
		textField_9 = new JJTextField("请输入信息");
		textField_9.setText(Accountinformation.rowData[3][0]);
		textField_9.setColumns(10);
		textField_9.setColumns(10);
		textField_9.setBounds(84, 13, 78, 26);
		panel_5.add(textField_9);
		
		textField_10 = new JJTextField("请输入信息");
		textField_10.setText(Accountinformation.rowData[3][1]);
		textField_10.setColumns(10);
		textField_10.setColumns(10);
		textField_10.setBounds(239, 11, 162, 26);
		panel_5.add(textField_10);
		
		textField_11 = new JJTextField("请输入信息");
		textField_11.setText(Accountinformation.rowData[3][2]);
		textField_11.setColumns(10);
		textField_11.setColumns(10);
		textField_11.setBounds(450, 11, 130, 26);
		panel_5.add(textField_11);
		
		JButton button_4 = new JButton("添加");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Accountinformation.realname=textField_9.getText();
				Accountinformation.TEL=textField_10.getText();
				Accountinformation.IDnum=textField_11.getText();	
				
				try {
					Accountinformation.addaccount();
					window.frame.setVisible(false);
					window = new AccountManage();
					window.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_4.setBounds(584, 11, 56, 28);
		panel_5.add(button_4);
		
		JButton button_9 = new JButton("删除");
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
		            Accountinformation.IDnum=textField_11.getText();	
					Accountinformation.deleteaccount();
					for(int i=0;i<5;i++)
						for(int j=0;j<4;j++)
					Accountinformation.rowData[i][j]=null;
					
					window.frame.setVisible(false);
					window = new AccountManage();
					window.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		button_9.setBounds(584, 11, 56, 28);
		panel_5.add(button_9);
		
		if(Accountinformation.rowData[3][1]!=null)
		{
			button_9.setVisible(true);
			button_4.setVisible(false);
		}
		else
		{
			button_4.setVisible(true);
			button_9.setVisible(false);
		}
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(6, 290, 646, 59);
		panel.add(panel_6);
		
		JLabel label_11 = new JLabel("乘机人姓名：");
		label_11.setBounds(6, 16, 78, 16);
		panel_6.add(label_11);
		
		JLabel label_12 = new JLabel("TEL：");
		label_12.setBounds(412, 16, 45, 16);
		panel_6.add(label_12);
		
		JLabel label_13 = new JLabel("身份证号：");
		label_13.setBounds(174, 16, 71, 16);
		panel_6.add(label_13);
		
		textField_12 = new JJTextField("请输入信息");
		textField_12.setText(Accountinformation.rowData[4][0]);
		textField_12.setColumns(10);
		textField_12.setColumns(10);
		textField_12.setBounds(84, 13, 78, 26);
		panel_6.add(textField_12);
		
		textField_13 = new JJTextField("请输入信息");
		textField_13.setText(Accountinformation.rowData[4][1]);
		textField_13.setColumns(10);
		textField_13.setColumns(10);
		textField_13.setBounds(238, 11, 162, 26);
		panel_6.add(textField_13);
		
		textField_14 = new JJTextField("请输入信息");
		textField_14.setText(Accountinformation.rowData[4][2]);
		textField_14.setColumns(10);
		textField_14.setColumns(10);
		textField_14.setBounds(448, 11, 130, 26);
		panel_6.add(textField_14);
		
		JButton button_5 = new JButton("添加");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Accountinformation.realname=textField_12.getText();
				Accountinformation.TEL=textField_13.getText();
				Accountinformation.IDnum=textField_14.getText();	
				
				try {
					Accountinformation.addaccount();
					window.frame.setVisible(false);
					window = new AccountManage();
					window.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_5.setBounds(584, 11, 56, 28);
		panel_6.add(button_5);
		
		JButton button_10 = new JButton("删除");
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
		            Accountinformation.IDnum=textField_14.getText();	
					Accountinformation.deleteaccount();
					for(int i=0;i<5;i++)
						for(int j=0;j<4;j++)
					Accountinformation.rowData[i][j]=null;
					
					window.frame.setVisible(false);
					window = new AccountManage();
					window.frame.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		button_10.setBounds(584, 11, 56, 28);
		panel_6.add(button_10);
		
		if(Accountinformation.rowData[4][1]!=null)
		{
			button_10.setVisible(true);
			button_5.setVisible(false);
		}
		else
		{
			button_5.setVisible(true);
			button_10.setVisible(false);
		}
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("账单信息", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 646, 398);
		panel_1.add(scrollPane);
		
		Vector<String> columnNames = new Vector<>();
        columnNames.add("收入");
        columnNames.add("支出");
        columnNames.add("时间");
        
        
        JTable table = new JTable();
        //创建表格模型
        Billinformation.displaybill();
        DefaultTableModel defaultTableModel = new DefaultTableModel(Billinformation.tableValues, columnNames);
        //设置JTable的表格模型
        
        table.setModel(defaultTableModel);
        
        scrollPane.setViewportView(table);
		
		
		
		JButton button = new JButton("修改密码");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePassword.main(null);
			}
		});
		button.setBounds(550, 34, 117, 29);
		frame.getContentPane().add(button);
		
		JLabel lblUsename = new JLabel("username");
		lblUsename.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblUsename.setText(logwindow.nowuser);
		lblUsename.setBounds(46, 23, 128, 40);
		frame.getContentPane().add(lblUsename);
		
		
	}
}
