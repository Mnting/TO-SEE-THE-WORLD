import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Insert {
	public static boolean Insert(String tablename,String value){
		String regexp = "\'";
		String values = value.replaceAll(regexp, "");//String被final修飾 不可修改 需重新生成變量
		String pk = "";//主鍵
		int pknum = 0;
		try{
		BufferedReader br = new BufferedReader(
									new FileReader(
											new File("C:\\Users\\Mnting\\Desktop\\DBMS\\table.txt")));
		String line = "";
		ArrayList<String> Metadata = new ArrayList<String>();
		while((line=br.readLine())!=null){
			String[] text = line.split(" ");
			 if(!text[0].equals(tablename))
				 continue;
			 for(int i=1;i<text.length;i++)
				 {
				 	if(text[i].equals("primary")||text[i].equals("PRIMARY"))
				 		{
				 			pk = text[i+2];
				 			System.out.println(pk);
				 			for(int j=0;j<text.length;j++){
				 				if(text[j].equals(pk)){
				 					pknum=(j-1)/3;
				 					break;
				 				}
				 			}
				 			System.out.print(pknum);
				 			continue;
				 		}
				 		else{
				 			Metadata.add(text[i]);
				 		}
				 }
			 break;
		}//當前while循環獲取元數據
		br.close();
		String[] addvalues = values.split(",");
		if(pk.length()>0){
			BufferedReader br_1 = new BufferedReader(new FileReader(
					new File("C:\\Users\\Mnting\\Desktop\\DBMS\\"+tablename+".txt")));
			String line_1 = "";
			while((line_1=br_1.readLine())!=null){
				String[] text_1 = line_1.split(" ");
				if(text_1[pknum].equals(addvalues[pknum]))
				{
					JOptionPane.showMessageDialog(null, pk+"為主鍵，不可添加重複值！","失敗",JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
		}
		int num = 0;
		for(int i=1;i<Metadata.size();i++){
			
			if(Metadata.get(i).equals("int")||Metadata.get(i).equals("INT")){
				i++;
				if(Metadata.get(i).equals("null"))
					Metadata.set(i, "8");
				if(Integer.parseInt(Metadata.get(i))*10>(Integer.parseInt(addvalues[num]))){
					num++;
				}
				else{
					JOptionPane.showMessageDialog(null, "INT類型長度越界","添加失敗！",JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
			else if(Metadata.get(i).equals("char")||Metadata.get(i).equals("CHAR")){
				i++;
			/*	if(Metadata.get(i).equals("null"))
					Metadata.set(i, "8");
				if(Integer.parseInt(Metadata.get(i))*1000>(Integer.parseInt(addvalues[num]))){
					num++;
				}
				else{
					JOptionPane.showMessageDialog(null, "CHAR類型長度越界","添加失敗！",JOptionPane.ERROR_MESSAGE);
					return false;
				}*/
			}
		}
		BufferedWriter bw = new BufferedWriter(
				new FileWriter(
						new File("C:\\Users\\Mnting\\Desktop\\DBMS\\"+tablename+".txt"),true));
		for(int j=0;j<addvalues.length;j++)
		bw.append(addvalues[j]+" ");
		bw.newLine();
		bw.flush();
		bw.close();
		
		}catch(FileNotFoundException e) {
		JOptionPane.showMessageDialog(null, "找不到該表！", "出错啦！", JOptionPane.ERROR_MESSAGE);
		return false;
		}
	
		catch(Exception e) {
		JOptionPane.showMessageDialog(null, "Sorry！", "Warning！", JOptionPane.ERROR_MESSAGE);
		return false;
		}
		return true;

}
}
