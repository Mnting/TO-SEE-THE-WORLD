import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import java.util.ArrayList;

public class Create {
	public static boolean Create(String tablename , String value){
			if(FindTableName.FindName(tablename)){
			int len = 0,num=0;
			ArrayList<String> table = new ArrayList<String>();
			table.add(tablename);
			String[] value_split = value.split(",");
			while(len<value.length()){
				String pattern = "(primary|PRIMARY|\\w+)\\s+(int|char|INT|CHAR|KEY|key)\\s*(\\(((\\d|\\w+))\\))?";
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(value_split[num]);
			if(m.find()){
				try{
				if(m.group(4)!=null&&Integer.valueOf(m.group(4)).intValue()>8)
				{
					JOptionPane.showMessageDialog(null, "类型长度越界！", "出错啦！", JOptionPane.ERROR_MESSAGE);
					return false;
				}
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "主键为:"+m.group(4), "注意！", JOptionPane.INFORMATION_MESSAGE);
				}
				for(int i =0;i<m.groupCount();i++)
					if(i==1||i==2||i==4)
					table.add(m.group(i));//1为列名 2为类型 4为长度
				len = len+value_split[num].length()+1;
				num++;
			}else
			{
				JOptionPane.showMessageDialog(null, "请检查需要执行的语句，不能执行！", "出错啦！", JOptionPane.ERROR_MESSAGE);
				return false;	
			}
			}
			SaveFile.savefile(table,tablename);
			}else{
				JOptionPane.showMessageDialog(null, "该表已存在！", "出错啦！", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			return true;
		
	}
}
