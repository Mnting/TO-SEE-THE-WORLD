package airport;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Adminlog {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminlog window = new Adminlog();
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
	public Adminlog() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblid = new JLabel("管理员ID");
		lblid.setBounds(59, 61, 61, 16);
		frame.getContentPane().add(lblid);
		
		textField = new JTextField();
		textField.setBounds(154, 56, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("密码");
		label.setBounds(59, 118, 61, 16);
		frame.getContentPane().add(label);
		
		password = new JPasswordField();
		password.setBounds(154, 113, 130, 26);
		password.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyChar()==KeyEvent.VK_ENTER)
				{
					frame.setVisible(false);
				//MainHome.frame.setVisible(false);
				Admin.main(null);
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JButton button = new JButton("登录");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textField.getText().equals("h") && password.getText().equals("h"))
				{
					frame.setVisible(false);
					//MainHome.frame.setVisible(false);
					Admin.main(null);
				}
			}
		});
		button.setBounds(132, 198, 117, 29);
		frame.getContentPane().add(button);
	}

}
