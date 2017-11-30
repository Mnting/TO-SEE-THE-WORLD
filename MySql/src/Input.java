import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Input extends JFrame {

	private JPanel contentPane;
	public static JScrollPane jsp_1 ;
	/**
	 * Launch the application.
	 */
	public static void mainprogram(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Input frame = new Input();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Input() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1244, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(14, 13, 1198, 250);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 22));
		JScrollPane jsp = new JScrollPane(textArea);
		textArea.setBounds(0, 0, 554, 250);
		jsp.setBounds(0, 0, 1198, 250);
		textArea.setLineWrap(true);
		panel.add(jsp);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(14, 300, 1198, 250);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		jsp_1 = new JScrollPane();
		jsp_1.setBounds(0, 0, 1198, 250);
		panel_1.add(jsp_1);
		
		
		JButton btnNewButton = new JButton("run");
		btnNewButton.setBounds(563, 270, 113, 27);
		contentPane.add(btnNewButton);
		btnNewButton.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				jsp_1.setViewportView(null);
				try{
				if(textArea.getSelectedText().length()>0)
				{
					String sql = textArea.getSelectedText();
					CheckSql.Check(sql);
				}
				}
				catch(NullPointerException exception){
					JOptionPane.showMessageDialog(null, "请选择需要执行的语句！", "出错啦！", JOptionPane.ERROR_MESSAGE);
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
	}
}
