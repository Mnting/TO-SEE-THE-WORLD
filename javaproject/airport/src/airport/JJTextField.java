package airport;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.FocusManager;
import javax.swing.JTextField;

class JJTextField extends JTextField {
	
	
	String sstr=null;
	public JJTextField(String str){
		sstr=str;
	}
	private static final long serialVersionUID = 1L;

	protected void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		if (getText().isEmpty() && !(FocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == this)) {
			Graphics2D g2 = (Graphics2D) g.create();
			g2.setFont(new Font("宋体",Font.PLAIN,16));
			g2.setColor(Color.gray);
			g2.drawString(this.sstr,10,25); // figure out x, y from font's
											// FontMetrics and size of
											// component.
			g2.dispose();
		}

	}
}

