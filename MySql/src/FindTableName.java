import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;

public class FindTableName {
	public static boolean FindName(String tablename){
		try {
			File fl = new File("C:\\Users\\Mnting\\Desktop\\DBMS\\tablename.txt");
			FileReader fr = new FileReader(fl);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			//定义一个空字符串来接受读到的字符串
			String str="";
			//循环把读取到的字符赋给str
			while((line = br.readLine())!=null)
			{
			 str+=line+" ";
			}
			br.close();
			fr.close();
			if(str.contains(tablename)){
				return false;
			}
			
	            }catch(FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, "找不到文件！", "出错啦！", JOptionPane.ERROR_MESSAGE);
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Sorry！", "Warning！", JOptionPane.ERROR_MESSAGE);
				}
		return true;
	}
}
