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
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Admin {
	static Admin window;
	static JFrame frame;
	static JTable table_2;
	static DefaultTableModel defaultTableModel_2;
	static Vector<String> columnNames2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Admin() throws ClassNotFoundException, SQLException {
		initialize();
	}

	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(100, 100, 805, 424);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 799, 390);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 793, 384);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("账单信息", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 6, 760, 326);
		panel_1.add(scrollPane_1);
		
		Vector<String> columnNames = new Vector<>();
        columnNames.add("用户");
        columnNames.add("收入");
        columnNames.add("支出");
        columnNames.add("时间");
        
        JTable table_1 = new JTable();
        Billinformation.displayallbill();
        DefaultTableModel defaultTableModel_1 = new DefaultTableModel(Billinformation.tableValues, columnNames);
        table_1.setModel(defaultTableModel_1);      
        scrollPane_1.setViewportView(table_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("航班管理", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(6, 6, 760, 278);
		panel_2.add(scrollPane_2);
		
		Vector<String> columnNames2 = new Vector<>();
        columnNames2.add("出发地");
        columnNames2.add("出发机场");
        columnNames2.add("到达地");
        columnNames2.add("到达机场");
        columnNames2.add("日期");
        columnNames2.add("出发时间");
        columnNames2.add("到达时间");
        columnNames2.add("航班号");
        columnNames2.add("航班公司");
        columnNames2.add("价格");
        columnNames2.add("余票量");
        columnNames2.add("航班流水号");

 
        table_2 = new JTable();
        Planeinformation.displayairline();
        defaultTableModel_2 = new DefaultTableModel(UserInformation.ordertickets, columnNames2);        
        table_2.setModel(defaultTableModel_2);      
        scrollPane_2.setViewportView(table_2);
        
        JButton button = new JButton("添加航班");
        button.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		AdminPlane.main(null);
        	}
        });
        button.setBounds(130, 296, 117, 29);
        panel_2.add(button);
        
        JButton button_1 = new JButton("删除航班");
        button_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        	}
        });
        button_1.setBounds(463, 296, 117, 29);
        panel_2.add(button_1);
        

	}

}
