package airport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Planeinformation {
	
	public static  Vector<Vector<String>> tableValues = new Vector<>();

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

    static String  departurecity,date,arrivalcity,flightnumber,departureairport,arrivalairport,departuretime,arrivaltime,price,airline,ticketamount,airlineID;
    //tianjia
    public static boolean addairline () throws SQLException, ClassNotFoundException{
    	  Class.forName(driver);
          //1.getConnection()方法，连接MySQL数据库！！
          con = DriverManager.getConnection(url,user,password);
          if(!con.isClosed())
              System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            //要执行的SQL语句
            
          	String airlineID = date+departuretime+arrivaltime+ flightnumber;
  			java.sql.PreparedStatement psql;
  			psql = con.prepareStatement("insert into airport.planeinformation (departurecity,date,arrivalcity,flightnumber,departureairport,arrivalairport,departuretime,arrivaltime,price,airline,ticketamount,airlineID) "
  					+ "values(?,?,?,?,?,?,?,?,?,?,?,?)");
  			psql.setString(1, departurecity);
  			psql.setString(2, date);
  			psql.setString(3, arrivalcity);
  			psql.setString(4, flightnumber);
  			psql.setString(5, departureairport);
  			psql.setString(6, arrivalairport);
  			psql.setString(7, departuretime);
  			psql.setString(8, arrivaltime);
  			psql.setString(10, airline);
  			psql.setString(9, price);
  			psql.setString(11, ticketamount);
  			psql.setString(12, airlineID);
  			

  			psql.executeUpdate();
  			psql.close();
  			
  			
  		return true;
  }
    public static boolean displayairline () throws SQLException, ClassNotFoundException{
  	  Class.forName(driver);
        //1.getConnection()方法，连接MySQL数据库！！
        con = DriverManager.getConnection(url,user,password);
        if(!con.isClosed())
            System.out.println("Succeeded connecting to the Database!");
          //2.创建statement类对象，用来执行SQL语句！！
          //要执行的SQL语句
        Statement statement = con.createStatement();
        String sql = "select * from airport.planeinformation";
        //3.ResultSet类，用来存放获取的结果集！！
        ResultSet rs = statement.executeQuery(sql);
        
        while(rs.next()){     	
        		Vector<String> rowV = new Vector<>();
    			rowV.add(rs.getString("departurecity"));
    			rowV.add(rs.getString("departureairport"));
    			rowV.add(rs.getString("arrivalcity"));
    			rowV.add(rs.getString("arrivalairport"));
    			rowV.add(rs.getString("date"));
    			rowV.add(rs.getString("departuretime"));
    			rowV.add(rs.getString("arrivaltime"));
    			rowV.add(rs.getString("flightnumber"));
    			rowV.add(rs.getString("airline"));
    		
    			tableValues.add(rowV);      	
		}  	
        rs.close();
        con.close();
    
  	return false;
}
}
