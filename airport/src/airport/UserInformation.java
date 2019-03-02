package airport;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.sql.*;

import com.mysql.jdbc.PreparedStatement;

public class UserInformation {
    static Vector<Vector<Object>> ordertableValuse;
    static Vector<Vector<Object>> ordertickets;
	static String username = null;
    static String password1 = null;
    static String passwordnew = null;

    //声明Connection对象
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

    static String  departurecity,arrivalcity,flightnum,departureairport,arrivalairport,
	departuretime,arrivaltime,realname,tel,IDnum;
    //denglu
    public static boolean checkpassword() throws SQLException, ClassNotFoundException{
    	  Class.forName(driver);
          //1.getConnection()方法，连接MySQL数据库！！
          con = DriverManager.getConnection(url,user,password);
          if(!con.isClosed())
              System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select * from airport.userinformation";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
        
                //获取stuname这列数据
               if( rs.getString("username").equals(username) && rs.getString("password").equals(password1))
                //获取stuid这列数据
                
                	{rs.close();
                    con.close();
                    return true;
                    }
                }
               
                      
            rs.close();
            con.close();
        
		return false;
    }
    
    //zhuce
    public static boolean checkusername() throws SQLException, ClassNotFoundException{
  	  Class.forName(driver);
        //1.getConnection()方法，连接MySQL数据库！！
        con = DriverManager.getConnection(url,user,password);
        if(!con.isClosed())
            System.out.println("Succeeded connecting to the Database!");
          //2.创建statement类对象，用来执行SQL语句！！
          Statement statement = con.createStatement();
          //要执行的SQL语句
          String sql = "select * from airport.userinformation";
          //3.ResultSet类，用来存放获取的结果集！！
          ResultSet rs = statement.executeQuery(sql);
        
          while(rs.next()){
				if(rs.getString("username").equals(username))
				{
					rs.close();
					con.close();
					return false;
				}
			}
			
			java.sql.PreparedStatement psql;
			psql = con.prepareStatement("insert into airport.userinformation (username,password) "
					+ "values(?,?)");
			psql.setString(1, username);
			psql.setString(2, password);
			psql.executeUpdate();
			con.close();
			rs.close();
			psql.close();
			
			
		return true;
}
    
    public static void showaccountticket() throws ClassNotFoundException, SQLException{
    	 ordertableValuse = new Vector<>(); 
    	 Class.forName(driver);
         //1.getConnection()方法，连接MySQL数据库！！
         con = DriverManager.getConnection(url,user,password);
         if(!con.isClosed())
             System.out.println("Succeeded connecting to the Database!");
           //2.创建statement类对象，用来执行SQL语句！！
           Statement statement = con.createStatement();
           //要执行的SQL语句
           String sql = "select * from airport.orderinformation";
           //3.ResultSet类，用来存放获取的结果集！！
           ResultSet rs = statement.executeQuery(sql);
           
           while(rs.next()){
        	   if(rs.getString("orderID").equals(Orderwindow.OrderID) && rs.getString("status").equals("已支付")){
        		 departurecity =  rs.getString("departurecity");
        		 arrivalcity = rs.getString("arrivalcity");
        		flightnum =   rs.getString("flightnum");
        		  departuretime = rs.getString("departuretime");
        		arrivaltime = rs.getString("arrivaltime");
		 
           }
        	   }
           String sql_2 = "select * from airport.passengerinformation";
           ResultSet rs_2 = statement.executeQuery(sql_2);
           while(rs_2.next()){
        	   
        			 if(rs_2.getString("orderID").equals(Orderwindow.OrderID)){
        				 Vector<Object>rowV = new Vector<>();
                   	     rowV.add(rs_2.getString("realname"));
                   	     rowV.add(rs_2.getString("TEL"));
                   	     rowV.add(rs_2.getString("IDnum"));
                   	     ordertableValuse.add(rowV);
                   	     
                   	   
        			 }

        	  
           }
           rs.close();
           rs_2.close();
     	  con.close();
     	  
    }
    //xiugaimima
    public static boolean changepassword() throws SQLException, ClassNotFoundException{
  	  Class.forName(driver);
        //1.getConnection()方法，连接MySQL数据库！！
        con = DriverManager.getConnection(url,user,password);
        if(!con.isClosed())
            System.out.println("Succeeded connecting to the Database!");
          //2.创建statement类对象，用来执行SQL语句！！
          Statement statement = con.createStatement();
          //要执行的SQL语句
          String sql = "select * from airport.userinformation";
          //3.ResultSet类，用来存放获取的结果集！！
          ResultSet rs = statement.executeQuery(sql);
          
          System.out.println(passwordnew);

          while(rs.next()){
             if( rs.getString("username").equals(logwindow.nowuser))
              	{	
            	 String sql_2 = "update airport.userinformation set password='"+passwordnew+"'  where   username='"+logwindow.nowuser+"'";
                 PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql_2);
                 pst.executeUpdate(sql_2);
                 pst.close();
                 con.close();
                  return true;
                 }
              }                   
          rs.close();
          con.close();     
		return false;
  }
    public static void disaplayordertickets()throws SQLException, ClassNotFoundException{
    	ordertickets = new Vector<>();
    	Class.forName(driver);
        //1.getConnection()方法，连接MySQL数据库！！
        con = DriverManager.getConnection(url,user,password);
        if(!con.isClosed())
            System.out.println("Succeeded connecting to the Database!");
          //2.创建statement类对象，用来执行SQL语句！！
          Statement statement = con.createStatement();
          //要执行的SQL语句
          String sql = "select * from airport.orderinformation";
          //3.ResultSet类，用来存放获取的结果集！！
          ResultSet rs = statement.executeQuery(sql);
          while(rs.next()){
       	   if(rs.getString("username").equals(logwindow.nowuser)&&rs.getString("status").equals("已支付")){
       		 Vector<Object>rowVU = new Vector<>();
       		rowVU.add(rs.getString("departurecity"));
			rowVU.add(rs.getString("arrivalcity"));
			rowVU.add(rs.getString("date"));
			rowVU.add(rs.getString("departuretime"));
			rowVU.add(rs.getString("arrivaltime"));
			rowVU.add(rs.getString("flightnum"));
			rowVU.add(rs.getString("orderID"));
       	    ordertickets.add(rowVU);
       	   }
    }
          }
}


