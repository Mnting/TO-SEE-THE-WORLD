import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Update {
	public static void Update(String tablename,String colname,String values){
		try{
		int valuesindex =0;
		BufferedReader br = new BufferedReader(
				new FileReader(
						new File("C:\\Users\\Mnting\\Desktop\\DBMS\\table.txt")));
		String line = "";
		while((line=br.readLine())!=null){
			String[] text = line.split(" ");
			if(!text[0].equals(tablename))
				continue;
			
			for(int i=1;i<text.length;i++)
			{
				if(text[i].equals(colname))
				{
						valuesindex=(i-1)/3;
						break;
				}
			}
break;
}//當前while循環獲取元數據
		br.close();
		
		ArrayList<String> al =new ArrayList<String>();
		BufferedReader br_1 = new BufferedReader(
				new FileReader(
						new File("C:\\Users\\Mnting\\Desktop\\DBMS\\"+tablename+".txt")));
		String line_1 = "";
		while((line_1=br_1.readLine())!=null){
			String[] text_1 = line_1.split(" ");
			text_1[valuesindex]=values;
			String str = "";
			for(int i=0;i<text_1.length;i++)
				str+=text_1[i]+" ";
			al.add(str);
		}
		br_1.close();
		
		BufferedWriter bw = new BufferedWriter(
				new FileWriter(
						new File("C:\\Users\\Mnting\\Desktop\\DBMS\\"+tablename+".txt")));
		for(int i=0;i<al.size();i++){
			bw.append(al.get(i));
			bw.newLine();
		}
		bw.flush();
		bw.close();
		JOptionPane.showMessageDialog(null, "Update成功！");
		}catch(Exception e){
			
		}
	}
}
