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
					JOptionPane.showMessageDialog(null, "���ͳ���Խ�磡", "��������", JOptionPane.ERROR_MESSAGE);
					return false;
				}
				}
				catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null, "����Ϊ:"+m.group(4), "ע�⣡", JOptionPane.INFORMATION_MESSAGE);
				}
				for(int i =0;i<m.groupCount();i++)
					if(i==1||i==2||i==4)
					table.add(m.group(i));//1Ϊ���� 2Ϊ���� 4Ϊ����
				len = len+value_split[num].length()+1;
				num++;
			}else
			{
				JOptionPane.showMessageDialog(null, "������Ҫִ�е���䣬����ִ�У�", "��������", JOptionPane.ERROR_MESSAGE);
				return false;	
			}
			}
			SaveFile.savefile(table,tablename);
			}else{
				JOptionPane.showMessageDialog(null, "�ñ��Ѵ��ڣ�", "��������", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			return true;
		
	}
}
