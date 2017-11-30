import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Drop {
	public static void Drop(String tablename){
		try {
			//删除该表
				File file=new File("C:\\Users\\Mnting\\Desktop\\DBMS");
				File[] files=file.listFiles();//获取文件列表 
				for(int i=0;i<files.length;i++)
				{
					if(!files[i].getName().equals(tablename+".txt"))
						continue;//如果不是文件就跳过（排除文件夹等）
				files[i].delete();//后缀名为txt就删除
				}
			//删除索引表中该表名
			File fl = new File("C:\\Users\\Mnting\\Desktop\\DBMS\\tablename.txt");
			FileReader fr = new FileReader(fl);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			//定义一个空字符串来接受读到的字符串
			ArrayList<String> str= new ArrayList<String>();
			//循环把读取到的字符赋给str
			while((line = br.readLine())!=null)
			{
			 String[] text = line.split(" ");
			 if(text[0].equals(tablename))
				 continue;
			 str.add(line);
			}
			br.close();
			fr.close();
			
			FileWriter fw = new FileWriter(fl);
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i=0;i<str.size();i++){
				bw.write(str.get(i));
				bw.newLine();
			}
			bw.flush();
			bw.close();
			fw.close();
			//删除数据字典中该行
			File fl_1 = new File("C:\\Users\\Mnting\\Desktop\\DBMS\\table.txt");
			FileReader fr_1 = new FileReader(fl_1);
			BufferedReader br_1 = new BufferedReader(fr_1);
			String line_1 = "";
			//定义一个空字符串来接受读到的字符串
			ArrayList<String> str_1=new ArrayList<String>();
			//循环把读取到的字符赋给str_1
			while((line_1 = br_1.readLine())!=null)
			{
			 String[] text_1 = line_1.split(" ");
			 if(text_1[0].equals(tablename))
				 continue;
			 str_1.add(line_1);
			}
			br_1.close();
			fr_1.close();
			
			FileWriter fw_1 = new FileWriter(fl_1);
			BufferedWriter bw_1 = new BufferedWriter(fw_1);
			for(int j=0;j<str_1.size();j++){
				bw_1.write(str_1.get(j));
				bw_1.newLine();
			}
			bw_1.flush();
			bw_1.close();
			fw_1.close();
			JOptionPane.showMessageDialog(null, tablename+"表已删除！", "成功啦！", JOptionPane.OK_OPTION);
			}catch(FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "找不到文件！", "出错啦！", JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Sorry！", "Warning！", JOptionPane.ERROR_MESSAGE);
			}
	}
}
