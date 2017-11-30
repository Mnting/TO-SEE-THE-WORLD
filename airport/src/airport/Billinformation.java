package airport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;



public class Billinformation {
	
	static Connection con;
    //驱动程序名
   static String driver = "com.mysql.jdbc.Driver";
   //URL指向要访问的数据库名mydata
   static String url = "jdbc:mysql://localhost:3306/airport";
   //MySQL配置时的用户名
   static String user = "root";
   //MySQL配置时的密码
   static String password = "526697";
   //遍历查询结果集 
   public static  Vector<Vector<String>> tableValues = new Vector<>();
;
   

   public static boolean displaybill() throws SQLException, ClassNotFoundException{
 	  Class.forName(driver);
     //1.getConnection()方法，连接MySQL数据库！！
     con = DriverManager.getConnection(url,user,password);
     if(!con.isClosed())
         System.out.println("Succeeded connecting to the Database!");
       //2.创建statement类对象，用来执行SQL语句！！
       Statement statement = con.createStatement();
       //要执行的SQL语句
       String sql = "select * from airport.billinformation";
       //3.ResultSet类，用来存放获取的结果集！！
       ResultSet rs = statement.executeQuery(sql);
       

		while(rs.next()){
        	if( rs.getString("username").equals(logwindow.nowuser) )
        	{
        		Vector<String> rowV = new Vector<>();
    			rowV.add(rs.getString("income"));
    			rowV.add(rs.getString("expend"));
    			rowV.add(rs.getString("time"));
    			tableValues.add(rowV);
        	}
		}
		
       rs.close();
       con.close();
   
 	return false;
 }
   
   public static boolean displayallbill() throws SQLException, ClassNotFoundException{
	 	  Class.forName(driver);
	     //1.getConnection()方法，连接MySQL数据库！！
	     con = DriverManager.getConnection(url,user,password);
	     if(!con.isClosed())
	         System.out.println("Succeeded connecting to the Database!");
	       //2.创建statement类对象，用来执行SQL语句！！
	       Statement statement = con.createStatement();
	       //要执行的SQL语句
	       String sql = "select * from airport.billinformation";
	       //3.ResultSet类，用来存放获取的结果集！！
	       ResultSet rs = statement.executeQuery(sql);
	       
			while(rs.next()){
	        	
	        		Vector<String> rowV = new Vector<>();
	    			rowV.add(rs.getString("username"));
	    			rowV.add(rs.getString("income"));
	    			rowV.add(rs.getString("expend"));
	    			rowV.add(rs.getString("time"));
	    			tableValues.add(rowV);
	        	
			}
			
	       rs.close();
	       con.close();
	   
	 	return false;
	 }
}
