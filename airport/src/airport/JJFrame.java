package airport;

import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;

public class JJFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	//用于处理拖动事件，表示鼠标按下时的坐标，相对于JFrame
	int xOld = 0;
	int yOld = 0;
	
public JJFrame(){
	
	getContentPane().setLayout(null);
	
	
	
	
//处理拖动事件
this.addMouseListener(new MouseAdapter() {
	public void mousePressed(MouseEvent e) {
		xOld = e.getX();
		yOld = e.getY();
	}
	});
this.addMouseMotionListener(new MouseMotionAdapter() {
	public void mouseDragged(MouseEvent e) {
		int xOnScreen = e.getXOnScreen();
		int yOnScreen = e.getYOnScreen();
		int xx = xOnScreen - xOld;
		int yy = yOnScreen - yOld;
		JJFrame.this.setLocation(xx, yy);
	}
});




this.setBounds(100, 100, 450, 300);
this.setUndecorated(true);
}

	public JJFrame(String str){
		this.setTitle(str);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 134, 28);
		lblNewLabel.setText(str);
		getContentPane().add(lblNewLabel);
	//处理拖动事件
	this.addMouseListener(new MouseAdapter() {
		public void mousePressed(MouseEvent e) {
			xOld = e.getX();
			yOld = e.getY();
		}
		});
	this.addMouseMotionListener(new MouseMotionAdapter() {
		public void mouseDragged(MouseEvent e) {
			int xOnScreen = e.getXOnScreen();
			int yOnScreen = e.getYOnScreen();
			int xx = xOnScreen - xOld;
			int yy = yOnScreen - yOld;
			JJFrame.this.setLocation(xx, yy);
		}
	});

	

	
this.setBounds(100, 100, 450, 300);
	this.setUndecorated(true);
	}
	
}

