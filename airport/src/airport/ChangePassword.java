package airport;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class ChangePassword {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword window = new ChangePassword();
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
	public ChangePassword() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 324, 302);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("鍘熷瘑鐮侊細");
		label.setBounds(59, 64, 61, 16);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("鏂板瘑鐮侊細");
		label_1.setBounds(59, 123, 61, 16);
		frame.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(128, 59, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		

		textField_1 = new JTextField();
		textField_1.setBounds(128, 118, 130, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		

		JButton button = new JButton("纭畾淇敼");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					UserInformation.password1=textField.getText();
					UserInformation.passwordnew=textField_1.getText();
					UserInformation.changepassword();
					if(UserInformation.changepassword()==true)
					{
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						AccountManage.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						MainHome.logflag = 0;
						MainHome.lblNewLabel1.setVisible(true);
						MainHome.lblNewLabel_1.setText("");
						logwindow.nowuser = null;
						MainHome.logout.setVisible(false);
						frame.setVisible(false);
						logwindow.main("请重新登录");
					}
					else
					{
						
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		button.setBounds(89, 190, 117, 29);
		frame.getContentPane().add(button);
	}
}
