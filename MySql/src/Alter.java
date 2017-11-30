import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Alter {
	public static void Add(String tablename,String values){
		String pattern = "(\\w+)\\s+(int|char|INT|CHAR)\\s*(\\(((\\d|\\w+))\\))?";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(values);
		ArrayList<String> col = new ArrayList<String>();
		if(m.find()){
			try{
				BufferedReader br = new BufferedReader(
						new FileReader(
								new File("C:\\Users\\Mnting\\Desktop\\DBMS\\table.txt")));
				String line = "";
				while((line=br.readLine())!=null){
					String[] text = line.split("\\s+");
					ArrayList<String> al = new ArrayList<String>();
					 if(!text[0].equals(tablename))
						 {
						 	col.add(line);
						 	continue;
						 }
					 al.add(line);
					 for(int j=0;j<m.groupCount();j++)
							if(j==1||j==2||j==4){
								al.add(m.group(j));
							}
					 String regexp = "\\[|\\]|\\,";
					col.add(al.toString().replaceAll(regexp, ""));
				}
				
				br.close();
				BufferedWriter bw = new BufferedWriter(
										new FileWriter(new File("C:\\Users\\Mnting\\Desktop\\DBMS\\table.txt")));
				for(int j=0;j<col.size();j++)
					{
						bw.append(col.get(j));
						bw.newLine();
					}
				bw.flush();
				bw.close();
				JOptionPane.showMessageDialog(null, "添加成功！");
			}catch(FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "找不到文件！", "出错啦！", JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Sorry！", "Warning！", JOptionPane.ERROR_MESSAGE);
			}
		}else
		{
			JOptionPane.showMessageDialog(null, "请检查需要执行的语句！", "出错啦！", JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void Drop(String tablename,String values){
		try{
			int index = 0;
			ArrayList<String> col = new ArrayList<String>();
			BufferedReader br = new BufferedReader(
					new FileReader(
							new File("C:\\Users\\Mnting\\Desktop\\DBMS\\table.txt")));
			String line = "";
			while((line=br.readLine())!=null){
				String[] text = line.split(" ");
				ArrayList<String> al = new ArrayList<String>();
				 if(!text[0].equals(tablename))
					 {
					 	col.add(line);
					 	continue;
					 }
				 for(int j=0;j<text.length;j++)
						if(!text[j].equals(values)){
							al.add(text[j]);
						}else{
							index = (j-1)/3;
							j=j+2;
						}
				 String regexp = "\\[|\\]|\\,";
				col.add(al.toString().replaceAll(regexp, ""));
			}
			
			br.close();
			BufferedWriter bw = new BufferedWriter(
									new FileWriter(new File("C:\\Users\\Mnting\\Desktop\\DBMS\\table.txt")));
			for(int j=0;j<col.size();j++)
				{
					bw.append(col.get(j));
					bw.newLine();
				}
			bw.flush();
			bw.close();
			
			String line_1 = "";
			ArrayList<String> col_1 = new ArrayList<String>();
			BufferedReader br_1 = new BufferedReader(
					new FileReader(new File("C:\\Users\\Mnting\\Desktop\\DBMS\\"+tablename+".txt")));
			while((line_1=br_1.readLine())!=null){
				String[] text = line_1.split(" ");
				ArrayList<String> al = new ArrayList<String>();
				for(int i=0;i<text.length;i++){
					if(i==index)
						{
							continue;
						}
					al.add(text[i]);
				}
				 String regexp = "\\[|\\]|\\,";
					col_1.add(al.toString().replaceAll(regexp, ""));
			}
			br_1.close();
			BufferedWriter bw_1 = new BufferedWriter(
									new FileWriter(new File("C:\\Users\\Mnting\\Desktop\\DBMS\\"+tablename+".txt")));
			for(int j=0;j<col_1.size();j++)
				{
					bw_1.append(col_1.get(j));
					bw_1.newLine();
				}
			bw_1.flush();
			bw_1.close();
			
			JOptionPane.showMessageDialog(null, "删除成功！");
		}catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "找不到文件！", "出错啦！", JOptionPane.ERROR_MESSAGE);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Sorry！", "Warning！", JOptionPane.ERROR_MESSAGE);
		}

	}
}
