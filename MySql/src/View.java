import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class View {
	public static void View(String name, String sql) {
		try {
			File fl = new File("C:\\Users\\Mnting\\Desktop\\DBMS\\table.txt");
			FileWriter fw = new FileWriter(fl, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("view" + "	" + name + "	" + sql);
			bw.newLine();
			bw.flush();
			bw.close();
			fw.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "找不到文件！", "出错啦！", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Sorry！", "Warning！", JOptionPane.ERROR_MESSAGE);
		}
	}
}
