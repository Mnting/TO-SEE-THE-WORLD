package airport;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.FocusManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;




class JJPasswordField extends JPasswordField{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String sstr=null;
	public JJPasswordField(String str){
		sstr=str;
	}
	
	protected void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		if (getText().isEmpty() && !(FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this)) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setFont(new Font("Verdana",Font.PLAIN,16));
			g2.setColor(Color.gray);
			g2.drawString(this.sstr,10,25); // figure out x, y from font's
											// FontMetrics and size of
											// component.
			g2.dispose();
		}
}
}

public class logwindow {
	public static String nowuser = null;
	static JJFrame frame;
	private JJTextField textField;
	private JLabel label;
	private JLabel label_1;
	static String str;
	/**
	 * Launch the application.
	 */
	private JPasswordField passwordField;
	private JLabel label_2;
	private JButton btnNewButton_2;
	public static void main(String args) {
		str=args;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logwindow window = new logwindow();
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
	public logwindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JJFrame(str);
		frame.setBounds(100, 100, 666, 520);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JJTextField("Username(phone-number)");
		textField.setBounds(213, 149, 230, 35);
		frame.getContentPane().add(textField);
		
		
		passwordField = new JJPasswordField("Password");
		passwordField.setBounds(213, 215, 230, 35);
		passwordField.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyChar()==KeyEvent.VK_ENTER)
				{
					UserInformation.username=textField.getText();
					UserInformation.password1=passwordField.getText();
					try {
						try {
							if(UserInformation.checkpassword()==true)
							{
								MainHome.lblNewLabel_1.setText("尊敬的用户:"+textField.getText());
								MainHome.logflag = 1;
								nowuser = textField.getText();
;								MainHome.lblNewLabel1.setVisible(false);
								MainHome.logout.setVisible(true);
								MainHome.label_1.setVisible(false);
								frame.setVisible(false);
							}
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.setBounds(213, 279, 100, 29);
		btnNewButton.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				UserInformation.username=textField.getText();
				UserInformation.password1=passwordField.getText();
				try {
					try {
						if(UserInformation.checkpassword()==true)
						{
							MainHome.lblNewLabel_1.setText("尊敬的用户:"+textField.getText());
							MainHome.logflag = 1;
							nowuser = textField.getText();
							MainHome.logout.setVisible(true);
							MainHome.label_1.setVisible(false);
							MainHome.lblNewLabel1.setVisible(false);
							frame.setVisible(false);
						}
						else{
							JOptionPane.showMessageDialog(null, "账户密码错误", "账户密码错误", JOptionPane.ERROR_MESSAGE); 
						}
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		frame.getContentPane().add(btnNewButton);
		
		label_2 = new JLabel("注册成功");
		label_2.setVisible(false);
		label_2.setBounds(213, 250, 61, 16);
		frame.getContentPane().add(label_2);
		
		JButton btnNewButton_1 = new JButton("注册");
		btnNewButton_1.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UserInformation.username=textField.getText();
				UserInformation.password1=passwordField.getText();
				try {
					if(UserInformation.checkusername()==true)
					{
						MainHome.lblNewLabel_1.setText("尊敬的用户:"+textField.getText());
						MainHome.logflag = 1;
						nowuser = textField.getText();
						MainHome.logout.setVisible(true);
						MainHome.lblNewLabel1.setVisible(false);
						MainHome.label_1.setVisible(false);
						frame.setVisible(false);
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			
			}}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_1.setBounds(321, 279, 100, 29);
		
		frame.getContentPane().add(btnNewButton_1);
		
		label = new JLabel("用户名：");
		label.setBounds(213, 121, 61, 16);
		frame.getContentPane().add(label);
		
		label_1 = new JLabel("密码：");
		label_1.setBounds(213, 187, 61, 16);
		frame.getContentPane().add(label_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(640, 0, 26, 26);
		frame.getContentPane().add(btnNewButton_2);
		
		
		
		
	}
}
