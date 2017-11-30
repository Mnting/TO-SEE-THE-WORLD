package airport;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Color;

public class MainHome {

	public static int logflag = 0;
	static JJFrame frame;
	public static JLabel lblNewLabel_1;
	public static JLabel lblNewLabel1;
	public static JLabel logout;
	static JLabel label_1;
	/**
	 * Launch the application.
	 */
	
	public static void closemainhome()
	{
		frame.setVisible(false);
	}
	
	public static void main(String[] args) {
		MainHome m = new MainHome();
		m.show();
		
	}
	void show(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainHome window = new MainHome();
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
	public MainHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JJFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(88, 185, 405, 287);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		String path = "pic/background.jpg";
		ImageIcon background = new ImageIcon(path);
		// 把背景图片显示在一个标签里面
		JLabel label = new JLabel(background);
		// 把标签的大小位置设置为图片刚好填充整个面板
		label.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		label.setOpaque(false);
		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
		JPanel imagePanel = (JPanel) frame.getContentPane();
		imagePanel.setOpaque(false);
		// 把背景图片添加到分层窗格的最底层作为背景
		panel.setOpaque(false);
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		
		JPanel toppanel = new JPanel();
		toppanel.setBounds(0, 0, 405, 287);
		toppanel.setOpaque(false);
		panel.add(toppanel);
		
		
		JButton ReserveButton = new JButton("预订机票");
		ReserveButton.setToolTipText("韩梦婷是大美女");
		ReserveButton.setBounds(74, 57, 261, 29);
		ReserveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reserve.main();
			}
		});
		toppanel.setLayout(null);
		toppanel.add(ReserveButton);
		
		JButton ManageButton = new JButton("订单管理");
		ManageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(MainHome.logflag==1){
					UserInformation.showaccountticket();
					UserInformation.disaplayordertickets();
					 ManageOrder.mngshow();
					}
					else{
						logwindow.main(null);
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		ManageButton.setBounds(74, 131, 261, 29);
		toppanel.add(ManageButton);
		
		JButton button = new JButton("账户管理");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(MainHome.logflag==1){
					AccountManage.main(null);
				}
				else{
					logwindow.main(null);
					if(MainHome.logflag==1){
						AccountManage.main(null);
					}
					
				}
			}
			
		});
		button.setBounds(74, 209, 261, 29);
		toppanel.add(button);
		
		lblNewLabel1 = new JLabel(" 登录/注册");
		logout = new JLabel("     登出");
		logout.setVisible(false);
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				logflag = 0;
				 lblNewLabel1.setVisible(true);
				 lblNewLabel_1.setText("");
				 logwindow.nowuser = null;
				 label_1.setVisible(true);
				 logout.setVisible(false);
			}
		});
		
		
		lblNewLabel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logwindow.main(null);
				
			}
		});
	
		lblNewLabel1.setBounds(511, 51, 75, 16);
		frame.getContentPane().add(lblNewLabel1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton.setForeground(new Color(224, 255, 255));
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.setBounds(573, 0, 27, 27);
		frame.getContentPane().add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(484, 25, 116, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		logout.setBounds(521, 50, 72, 18);
		frame.getContentPane().add(logout);
		
		label_1 = new JLabel("管理员入口");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Adminlog.main(null);
				frame.setVisible(false);
			}
		});
		label_1.setBounds(495, 536, 81, 16);
		frame.getContentPane().add(label_1);
		
		
		/**
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(6, 6, 315, 167);
		frame.getContentPane().add(lblNewLabel);

		ImageIcon title = new ImageIcon("pic/title.jpg");
		// 把背景图片显示在一个标签里面
		lblNewLabel.setIcon(title);
		*/
		
		
		}
}
