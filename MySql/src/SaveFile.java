import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SaveFile {
	public static void savefile(ArrayList al,String tablename){
		try {
		File fl = new File("C:\\Users\\Mnting\\Desktop\\DBMS\\table.txt");
		FileWriter fw = new FileWriter(fl,true);
		BufferedWriter bw = new BufferedWriter(fw);
		for(int j=0;j<al.size();j++)
			bw.write((String) al.get(j)+" ");
			bw.newLine();
			bw.flush();
			bw.close();
            fw.close();
            
            File fl_1 = new File("C:\\Users\\Mnting\\Desktop\\DBMS\\tablename.txt");
    		FileWriter fw_1 = new FileWriter(fl_1,true);
    		BufferedWriter bw_1 = new BufferedWriter(fw_1);
    		bw_1.write((String) tablename);
    		bw_1.newLine();
    		bw_1.flush();
			bw_1.close();
            fw_1.close();
            
            String txtpath = "C:\\Users\\Mnting\\Desktop\\DBMS\\"+tablename+".txt";
            File f = new File(txtpath);
            if (!f.exists()) {
            f.createNewFile();
            }

            }catch(FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "找不到文件！", "出错啦！", JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Sorry！", "Warning！", JOptionPane.ERROR_MESSAGE);
			}
	}
}
