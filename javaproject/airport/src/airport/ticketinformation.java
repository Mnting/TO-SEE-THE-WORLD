package airport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;

public class ticketinformation {
	
	static Object dcity = null;
    static Object acity = null;
    static String date = null;
    static Vector<Vector<Object>> tableValuse;

    static String departurecity,arrivalcity,ddate,flightnumber,departureairport,arrivalairport,
    				departuretime,arrivaltime,price,airline;
    static int ticketamount;
    
    //声明Connection对象
    static Connection con;
     //驱动程序名
    static String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问的数据库名
    static String url = "jdbc:mysql://localhost:3306/airport";
    //MySQL配置时的用户名
    static String user = "root";
    //MySQL配置时的密码
    static String password = "526697";
    //遍历查询结果集

	public static void find() throws SQLException, ClassNotFoundException {
		departurecity=dcity.toString();
		arrivalcity=acity.toString();
		 tableValuse = new Vector<>();
		 ddate=date;
		 Class.forName(driver);
         //1.getConnection()方法，连接MySQL数据库！！
         con = DriverManager.getConnection(url,user,password);
         if(!con.isClosed())
             System.out.println("Succeeded connecting to the Database!");
           //2.创建statement类对象，用来执行SQL语句！！
           Statement statement = con.createStatement();
           //要执行的SQL语句
           String sql = "select * from airport.planeinformation";
           //3.ResultSet类，用来存放获取的结果集！！
           ResultSet rs = statement.executeQuery(sql);
           
           while(rs.next()){
       
               //获取stuname这列数据
              if( rs.getString("departurecity").equals(dcity) && rs.getString("date").equals(date) && rs.getString("arrivalcity").equals(acity))
               //获取stuid这列数据
               
               	{  
            	  
            	  Vector<Object>rowV = new Vector<>();
            	  rowV.add(rs.getString("airline"));
            	  rowV.add(rs.getString("departuretime"));
            	  rowV.add(rs.getString("arrivaltime"));
            	  rowV.add(rs.getString("departureairport"));
            	  rowV.add(rs.getString("arrivalairport"));
            	  rowV.add(rs.getString("price"));
            	  rowV.add(rs.getString("flightnumber"));
            	  rowV.add(rs.getString("ticketamount"));
            	 
            	  tableValuse.add(rowV); 	
            	
               } 
	}rs.close();
                   con.close();

    
}

	public static void orderadd() throws SQLException, ClassNotFoundException {
		
		 Class.forName(driver);
        //1.getConnection()方法，连接MySQL数据库！！
        con = DriverManager.getConnection(url,user,password);
        if(!con.isClosed())
            System.out.println("Succeeded connecting to the Database!");
        
          java.sql.PreparedStatement psql;
    	  psql= con.prepareStatement("insert into airport.orderinformation (orderID, status,flightnum,username,departuretime,arrivaltime,departurecity,arrivalcity,ticketnumber,date)" 
    			  + "values(?,?,?,?,?,?,?,?,?,?)");
    	  psql.setString(1, Orderwindow.OrderID);
    	  psql.setString(2, "已支付");
    	  psql.setString(3,flightnumber);
    	  psql.setString(4,logwindow.nowuser);
    	  psql.setString(5,departuretime);
    	  psql.setString(6,arrivaltime);
    	  psql.setString(7,departurecity);
    	  psql.setString(8,arrivalcity);
    	  psql.setString(9, "1");
    	  psql.setString(10, date);
    	  psql.executeUpdate();
    	  psql.close();
    	  
    	  java.sql.PreparedStatement psql_1;
    	  psql_1= con.prepareStatement("insert into airport.billinformation (username,income,expend,time)" 
    			  + "values(?,?,?,?)");
    	  psql_1.setString(1, logwindow.nowuser);
    	  psql_1.setString(2, "无");
    	  psql_1.setString(3,price);
    	  psql_1.setString(4,Orderwindow.OrderID);
    	  psql_1.executeUpdate();  
    	  psql_1.close();
    	  con.close();
    	  
    	 
	}
	
	public static void changeticketamount() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
        //1.getConnection()方法，连接MySQL数据库！！
        con = DriverManager.getConnection(url,user,password);
        if(!con.isClosed())
            System.out.println("Succeeded connecting to the Database!");
        int ta = ticketamount-1;System.out.println(ta);
       String sql = "update airport.planeinformation set ticketamount='"+ta+"'  where   flightnumber='"+flightnumber+"'";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.executeUpdate(sql);
        pst.close();
        con.close();
        
	}
	
	public static void addpassengerinformation() throws ClassNotFoundException, SQLException{
		Class.forName(driver);
        //1.getConnection()方法，连接MySQL数据库！！
        con = DriverManager.getConnection(url,user,password);
        if(!con.isClosed())
            System.out.println("Succeeded connecting to the Database!");
          java.sql.PreparedStatement psql;
    	  psql= con.prepareStatement("insert into airport.passengerinformation (IDnum,orderID,realname,TEL)" + "values(?,?,?,?)");
    	  psql.setString(1,Orderwindow.account[0][1]);
    	  psql.setString(2, Orderwindow.OrderID);
    	  psql.setString(3,Orderwindow.account[0][0]);
    	  psql.setString(4,Orderwindow.account[0][2]);
    	  psql.executeUpdate();
    	  con.close();
    	  psql.close();
	}
	
	public static boolean refoundticket()throws ClassNotFoundException, SQLException{
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		String rOrderID = df.format(new Date());// new Date()为获取当前系统时间
		
		if(flightnumber==null){
			return false;
		}
		
		else{
		Class.forName(driver);
	        //1.getConnection()方法，连接MySQL数据库！！
	        con = DriverManager.getConnection(url,user,password);
	        if(!con.isClosed())
	            System.out.println("Succeeded connecting to the Database!");
	        Statement statement = con.createStatement();
	        String sql = "select * from airport.orderinformation";
	       
	          java.sql.PreparedStatement psql;
	    	  psql= con.prepareStatement("insert into airport.orderinformation (orderID, status,flightnum,username,departuretime,arrivaltime,departurecity,arrivalcity,ticketnumber,date)" 
	    			  + "values(?,?,?,?,?,?,?,?,?,?)");
	    	  psql.setString(1, ManageOrder.rOrderID);
	    	  psql.setString(2, "已退票");
	    	  psql.setString(3,flightnumber);
	    	  psql.setString(4,logwindow.nowuser);
	    	  psql.setString(5,departuretime);
	    	  psql.setString(6,arrivaltime);
	    	  psql.setString(7,departurecity);
	    	  psql.setString(8,arrivalcity);
	    	  psql.setString(9, "1");
	    	  psql.setString(10, date);
	    	  psql.executeUpdate(); 
	    	  psql.close();
	    	  ManageOrder.rOrderID=null;
	    	  flightnumber=null;
	    	  departuretime=null;
	    	  arrivaltime=null;
	    	  departurecity=null;
	    	  arrivalcity=null;
	    	  date=null;
	    	   String sql_2 = "delete  from airport.passengerinformation  where orderID ='"+Orderwindow.OrderID+"'";
	    	   PreparedStatement pstmt = con.prepareStatement(sql_2);
	    	   pstmt.executeUpdate();
	    	  
	    	   java.sql.PreparedStatement psql_1;
	     	  psql_1= con.prepareStatement("insert into airport.billinformation (username,income,expend,time)" 
	     			  + "values(?,?,?,?)");
	     	  psql_1.setString(1, logwindow.nowuser);
	     	  psql_1.setString(2, price);
	     	  psql_1.setString(3,"无");
	     	  psql_1.setString(4,rOrderID);
	     	  psql_1.executeUpdate();
	     	  psql_1.close();
	    	   
	           
	     	  
	     	
	          
	          // rs.close();
	    	  con.close();
	    	  return true;
	    	  }
	    	  
	}
	public static void changeticket()throws ClassNotFoundException, SQLException{
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		String rOrderID = df.format(new Date());// new Date()为获取当前系统时间
		Class.forName(driver);
        //1.getConnection()方法，连接MySQL数据库！！
        con = DriverManager.getConnection(url,user,password);
        if(!con.isClosed())
            System.out.println("Succeeded connecting to the Database!");
        Statement statement = con.createStatement();
        String sql = "select * from airport.orderinformation";
          
          java.sql.PreparedStatement psql;
    	  psql= con.prepareStatement("insert into airport.orderinformation (orderID, status,flightnum,username,departuretime,arrivaltime,departurecity,arrivalcity,ticketnumber,date)" 
    			  + "values(?,?,?,?,?,?,?,?,?,?)");
    	  psql.setString(1, rOrderID);
    	  psql.setString(2, "已支付");
    	  psql.setString(3,flightnumber);
    	  psql.setString(4,logwindow.nowuser);
    	  psql.setString(5,departuretime);
    	  psql.setString(6,arrivaltime);
    	  psql.setString(7,departurecity);
    	  psql.setString(8,arrivalcity);
    	  psql.setString(9, "1");
    	  psql.setString(10, date);
    	  psql.executeUpdate();
    	   String sql_2 = "delete  from airport.passengerinformation where orderID ='"+Orderwindow.OrderID+"'";
    	   PreparedStatement pstmt = con.prepareStatement(sql_2);
    	   pstmt.executeUpdate();
    	   
           
           
           java.sql.PreparedStatement psql1;
     	  psql1= con.prepareStatement("insert into airport.passengerinformation (IDnum,orderID,realname,TEL)" + "values(?,?,?,?)");
     	  psql1.setString(1,Orderwindow.account[0][1]);
     	  psql1.setString(2, rOrderID);
     	  psql1.setString(3,Orderwindow.account[0][0]);
     	  psql1.setString(4,Orderwindow.account[0][2]);
     	  psql1.executeUpdate();
     	  
     	  psql1.close();psql.close();
           
     	  String sqll = "update airport.orderinformation set status='"+"已改签"+"'  where   orderID='"+Orderwindow.OrderID+"'";
          PreparedStatement pst = con.prepareStatement(sqll);
          pst.executeUpdate();
          pst.close();
          
          
     	  
    	  con.close();
    	  
	}
	
	
}

