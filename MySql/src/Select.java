import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Select {
	public static void Check(String Collist, String Condition) {
		String[] col = Collist.split("\\,");// *或者列名
		String[] condition = Condition.split("\\s+");// 表名+条件
		if (condition[0] != null && condition.length == 1) {
			Select_normal(col, condition[0]);
		} else if (condition.length > 1) {
			String pattern = "(.*)\\s+(where|WHERE)\\s+((.*))";
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(Condition);
			if (m.find()) {
				String[] tablelist = m.group(1).split("\\,");
				if (tablelist.length == 1) {
					Select_onetable(col, tablelist[0], m.group(3));
				}else{
					Select_moretable(col,tablelist,m.group(3));
				}
			} else {
				JOptionPane.showMessageDialog(null, "请检查需要执行的语句！", "出错啦！", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	static void Select_normal(String[] colrange, String tablename) {
		String path_1 = "C:\\Users\\Mnting\\Desktop\\DBMS\\table.txt";
		String path = "C:\\Users\\Mnting\\Desktop\\DBMS\\" + tablename + ".txt";// 2为列
																				// 4为表名
		int[] num = new int[colrange.length];// 要查找的列坐标
		ArrayList<String> resultheader = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		int colnum = 0;
		int col = 0;//列数
		try {
			File fl_1 = new File(path_1);
			FileReader fr_1 = new FileReader(fl_1);
			BufferedReader br_1 = new BufferedReader(fr_1);
			String line_1 = "";
			while ((line_1 = br_1.readLine()) != null) {
				String[] text = line_1.split("\\s+");
				if (text[0].equals(tablename)) {
					if (colrange[0].equals("*")) {
						for (int i = 1; i < text.length; i = i + 3) {
							if (!text[i].equals("primary") && !text[i].equals("PRIMARY")) {
								resultheader.add(text[i]);
								col++;
							}
						}
						break;
					} else {
						for (int j = 0; j < colrange.length; j++) {
							for (int i = 1; i < text.length; i = i + 3) {
								if (!colrange[j].equals(text[i])) {
									colnum++;
								} else {
									resultheader.add(text[i]);
									num[j] = colnum;
									colnum = 0;
									col = num.length;
									break;
								}
							}
						}
					}
				}
			}
			br_1.close();
			fr_1.close();

			File fl = new File(path);
			FileReader fr = new FileReader(fl);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			// 定义一个空字符串来接受读到的字符串
			String str = "";
			// 循环把读取到的字符赋给str
			if (colrange[0].equals("*"))
				while ((line = br.readLine()) != null) {
					String[] text = line.split("\\s+");
					for (int i = 0; i < text.length; i++) {
						result.add(text[i]);
						if (i == text.length - 1)
							for (int j = 0; j < colnum - text.length; j++)
								result.add(" ");
					}
				}
			else {
				while ((line = br.readLine()) != null) {
					String[] text = line.split("\\s+");
					for (int i = 0; i < text.length; i++) {
						for (int j = 0; j < num.length; j++) {
							if (i == num[j]) {
								result.add(text[i]);
							}
						}
						if (i == text.length - 1)
							for (int j = 0; j < colnum - text.length; j++)
								result.add(" ");
					}
				}
			}
			br.close();
			fr.close();
			Show(resultheader, result, col);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "找不到文件！", "出错啦！", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Warning！", "Sorry！", JOptionPane.ERROR_MESSAGE);
		}
	}

	static void Select_onetable(String[] colrange, String tablename, String Condition) {

		String path_1 = "C:\\Users\\Mnting\\Desktop\\DBMS\\table.txt";
		String path = "C:\\Users\\Mnting\\Desktop\\DBMS\\" + tablename + ".txt";// 2为列
																				// 4为表名
		String[] condition = Condition.split("\\s+and\\s+");
		ArrayList<String> conditionlist = new ArrayList<String>();// 所有条件list

		if (!FindTableName.FindName(tablename)) {
			for (int i = 0; i < condition.length; i++) {
				String pattern = "(.*)(>|>=|<|<=|=|!=)(.*)";
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(condition[i]);
				if (m.find()) {
					conditionlist.add(m.group(1));// 属性
					conditionlist.add(m.group(2));// 运算符
					conditionlist.add(m.group(3).replaceAll("\\'", ""));// 值*/
				}
			}
			int[] conditionnum = new int[conditionlist.size() /3];// 需要判断的条件列号
			int[] num = new int[colrange.length];// 要查找的列坐标
			ArrayList<String> resultheader = new ArrayList<String>();
			ArrayList<String> result = new ArrayList<String>();
			int colnum = 0;
			try {
				File fl_1 = new File(path_1);
				FileReader fr_1 = new FileReader(fl_1);
				BufferedReader br_1 = new BufferedReader(fr_1);
				String line_1 = "";
				while ((line_1 = br_1.readLine()) != null) {
					String[] text = line_1.split("\\s+");
					if (text[0].equals(tablename)) {
						if (colrange[0].equals("*")) {
							for (int j = 0; j < conditionlist.size(); j = j + 3) {
								for (int i = 1; i < text.length; i = i + 3) {
									if (!conditionlist.get(j).equals(text[i])) {
										colnum++;
									} else {
										
										conditionnum[j/3] = colnum;
										colnum = 0;
										break;
									}
								}
							}

							for (int jj = 1; jj < text.length; jj = jj + 3) {
								
								if (!text[jj].equals("primary") && !text[jj].equals("PRIMARY")) {
									resultheader.add(text[jj]);
								}
							}
							break;
						} else {
							for (int j = 0; j < colrange.length; j++) {
								for (int i = 1; i < text.length; i = i + 3) {
									if (!colrange[j].equals(text[i])) {
										colnum++;
									} else {
										resultheader.add(text[i]);
										num[j] = colnum;
										colnum = 0;
										break;
									}
								}
							}
							for (int j = 0; j < conditionlist.size(); j = j + 3) {
								for (int i = 1; i < text.length; i = i + 3) {
									if (!conditionlist.get(j).equals(text[i])) {
										colnum++;
									} else {
										conditionnum[j/3] = colnum;
										colnum = 0;
										break;
									}
								}
							}
						}
					}
				}
				br_1.close();
				fr_1.close();

				File fl = new File(path);
				FileReader fr = new FileReader(fl);
				BufferedReader br = new BufferedReader(fr);
				String line = null;
				// 定义一个空字符串来接受读到的字符串
				String str = "";
				// 循环把读取到的字符赋给str
				if (colrange[0].equals("*"))
					while ((line = br.readLine()) != null) {
						boolean flag = true;
						String[] text = line.split("\\s+");
						for (int j = 0; j < conditionnum.length; j++) {
							// 0 1 2 3 4 5 6
							// 0 1 2 3 4 5 6 7 8 9 10 11 12 运算符3n+1 右3n+2
							switch (conditionlist.get(3 * j + 1)) {
							case "<":
								if (Integer.parseInt(text[conditionnum[j]]) < Integer
										.parseInt(conditionlist.get(3 * j + 2))) {
								}else{flag=false;}
								break;
								
							case ">":if (Integer.parseInt(text[conditionnum[j]]) > Integer
									.parseInt(conditionlist.get(3 * j + 2))) {
							}else{flag=false;}
							break;
							
							case ">=":if (Integer.parseInt(text[conditionnum[j]]) >= Integer
									.parseInt(conditionlist.get(3 * j + 2))) {
							}else{flag=false;}
							break;
							
							case "<=":if (Integer.parseInt(text[conditionnum[j]]) <= Integer
									.parseInt(conditionlist.get(3 * j + 2))) {
							}else{flag=false;}
							break;
							
							case "=":if (Integer.parseInt(text[conditionnum[j]]) == Integer
									.parseInt(conditionlist.get(3 * j + 2))) {
							}else{flag=false;}
							break;
							
							case "!=":if (Integer.parseInt(text[conditionnum[j]]) != Integer
									.parseInt(conditionlist.get(3 * j + 2))) {
							}else{flag=false;}
							break;
							}
							if(!flag){
								break;
							}
						}
						if(flag)
						for (int i = 0; i < text.length; i++) {
							result.add(text[i]);
							if (i == text.length - 1)
								for (int j = 0; j < resultheader.size() - text.length; j++)
									result.add(" ");
						}
						flag=true;
					}
				else {
					while ((line = br.readLine()) != null) {
						boolean flag = true;
						String[] text = line.split("\\s+");
						for (int j = 0; j < conditionnum.length; j++) {
							// 0 1 2 3 4 5 6
							// 0 1 2 3 4 5 6 7 8 9 10 11 12 运算符3n+1 右3n+2
							switch (conditionlist.get(3 * j + 1)) {
							case "<":
								if (Integer.parseInt(text[conditionnum[j]]) < Integer
										.parseInt(conditionlist.get(3 * j + 2))) {
								}else{flag=false;}
								break;
								
							case ">":if (Integer.parseInt(text[conditionnum[j]]) > Integer
									.parseInt(conditionlist.get(3 * j + 2))) {
							}else{flag=false;}
							break;
							
							case ">=":if (Integer.parseInt(text[conditionnum[j]]) >= Integer
									.parseInt(conditionlist.get(3 * j + 2))) {
							}else{flag=false;}
							break;
							
							case "<=":if (Integer.parseInt(text[conditionnum[j]]) <= Integer
									.parseInt(conditionlist.get(3 * j + 2))) {
							}else{flag=false;}
							break;
							
							case "=":if (Integer.parseInt(text[conditionnum[j]]) == Integer
									.parseInt(conditionlist.get(3 * j + 2))) {
							}else{flag=false;}
							break;
							
							case "!=":if (Integer.parseInt(text[conditionnum[j]]) != Integer
									.parseInt(conditionlist.get(3 * j + 2))) {
							}else{flag=false;}
							break;
							}
							if(!flag){
								break;
							}
						}
						if(flag)
						for (int i = 0; i < text.length; i++) {
							for (int j = 0; j < num.length; j++) {
								if (i == num[j]) {
									result.add(text[i]);
								}
							}
							if (i == text.length - 1)
								for (int j = 0; j < colnum - text.length; j++)
									result.add(" ");
						}
					}
				}
				br.close();
				fr.close();
				Show(resultheader, result, resultheader.size());

			} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "找不到文件！", "出错啦！", JOptionPane.ERROR_MESSAGE);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Warning！", "Sorry！", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	static void Select_moretable(String[] colrange,String[] tablename,String Condition){
		
	}

	static void Show(ArrayList resultheader, ArrayList result, int colnum) {
		int num = 0;
		String[] header = new String[colnum];
		for (int i = 0; i < colnum; i++) {
			header[i] = (String) resultheader.get(i);
		}
		String[][] data = new String[result.size() / colnum][colnum];
		for (int i = 0; i < result.size() / colnum; i++)
			for (int j = 0; j < colnum; j++) {
				data[i][j] = (String) result.get(num++);
			}
		JTable jtable = new JTable(data, header);
		jtable.getTableHeader().setBackground(Color.pink);
		Input.jsp_1.setViewportView(jtable);
		/*
		 * String regexp = "\\[|\\]|\\,";
		 * System.out.println(result.toString().replaceAll(regexp, ""));
		 */
	}
}
