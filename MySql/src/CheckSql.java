import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class CheckSql {
	public static void Check(String sql){
		CheckCreate(sql);
	}
	
	static void CheckCreate(String sql){
		String pattern = "(create|CREATE)\\s+(table|TABLE)\\s+(\\w+)\\s*\\(((.*))\\)";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(sql);
		
		if(m.find()){
			String tablename = m.group(3);
			String value = m.group(4);
			if(Create.Create(tablename, value)){
				JOptionPane.showMessageDialog(null, "创建成功！", "成功啦！", JOptionPane.INFORMATION_MESSAGE);
			}
		}else {
			CheckView(sql);
		}
	}
	
	static void CheckView(String sql){
		String pattern = "(create|CREATE)\\s+(view|VIEW)\\s+(\\w+)\\s+(as|AS)\\s+((.*))";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(sql);
		if(m.find()){
			View.View(m.group(3), m.group(5));
		}
		else{
			CheckSelect(sql);
		}
	}
	
	@SuppressWarnings("unused")
	static void CheckSelect(String sql){
		String pattern = "(select|SELECT)\\s+(.*)\\s+(from|FROM)\\s+((.*))";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(sql);
		if(m.find()){
			Select.Check(m.group(2),m.group(4));
			}else {
			//JOptionPane.showMessageDialog(null, "请检查需要执行的语句！", "出错啦！", JOptionPane.ERROR_MESSAGE);
				CheckDrop(sql);
			}
	}
	
	static void CheckDrop(String sql){
		String pattern = "(drop|DROP)\\s+(table|TABLE)\\s+((\\w+))";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(sql);
		
		if(m.find()){
			if(!FindTableName.FindName(m.group(3))){
				Drop.Drop(m.group(3));
			}else{
				JOptionPane.showMessageDialog(null, "该表不存在！", "出错啦！", JOptionPane.ERROR_MESSAGE);
			}
			
		}else {
			CheckInsert(sql);
		}
	}
	static void CheckInsert(String sql){
		String pattern = "(insert|INSERT)\\s+(into|INTO)\\s+(\\w+)\\s+(values|VALUES)(\\(((.*))\\))";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(sql);
		
		if(m.find()){
			if(!FindTableName.FindName(m.group(3))){
				if(Insert.Insert(m.group(3),m.group(6))){
					JOptionPane.showMessageDialog(null, "添加成功！");
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "该表不存在！", "出错啦！", JOptionPane.ERROR_MESSAGE);
			}
		}
		else{
			CheckAlterAdd(sql);
		}
	}
	
	static void CheckAlterAdd(String sql){
		String pattern = "(alter|ALTER)\\s+(table|TABLE)\\s+(\\w+)\\s+(add|ADD)\\s+((.*))";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(sql);
		
		if(m.find()){
			if(!FindTableName.FindName(m.group(3))){
			Alter.Add(m.group(3),m.group(5));
		}
			else{
				JOptionPane.showMessageDialog(null, "该表不存在！", "出错啦！", JOptionPane.ERROR_MESSAGE);
			}
		}
		else{
			CheckAlterDrop(sql);
		}
		}
	
	static void CheckAlterDrop(String sql){
		String pattern = "(alter|ALTER)\\s+(table|TABLE)\\s+(\\w+)\\s+(drop|DROP)\\s+(column|COLUMN)\\s+((\\w+))";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(sql);
		
		if(m.find()){
			if(!FindTableName.FindName(m.group(3))){
			Alter.Drop(m.group(3), m.group(6));
		}
			else{
				JOptionPane.showMessageDialog(null, "该表不存在！", "出错啦！", JOptionPane.ERROR_MESSAGE);
			}
		}
		else{
			CheckDelete(sql);
		}
	}
	
	static void CheckDelete(String sql){
		String pattern = "(delete|DELETE)\\s+(from|FROM)\\s+(\\w+)\\s+(where|WHERE)\\s+(\\w+)='((\\w+))'";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(sql);
		
		if(m.find()){
			if(!FindTableName.FindName(m.group(3))){
				Delete.Delete(m.group(3), m.group(5), m.group(6));
		}
			else{
				JOptionPane.showMessageDialog(null, "该表不存在！", "出错啦！", JOptionPane.ERROR_MESSAGE);
			}
		}
		else{
			CheckUpdate(sql);
		}
	}
	
	static void CheckUpdate(String sql){
		String pattern = "(update|UPDATE)\\s+(\\w+)\\s+(set|SET)\\s+(\\w+)='((\\w+))'";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(sql);
		
		if(m.find()){
			if(!FindTableName.FindName(m.group(2))){
				Update.Update(m.group(2), m.group(4),m.group(5));
		}
			else{
				JOptionPane.showMessageDialog(null, "该表不存在！", "出错啦！", JOptionPane.ERROR_MESSAGE);
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "请检查需要执行的语句！", "出错啦！", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
}
