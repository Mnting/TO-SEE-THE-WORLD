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

import javax.swing.JLabel;

public class Accountinformation {
	
	static String username = null;
	static Vector<Vector<String>> account;
    static String[] columnNames={"鐢ㄦ埛鍚�","骞撮緞","鎬у埆","Email"}; //鍒楀悕 
    static JLabel lblTel;
	static String IDnum;
	static String realname;
	static String TEL;
    static String[][] rowData=new String[5][4]; //琛ㄦ牸鏁版嵁

	 //澹版槑Connection瀵硅薄
    static Connection con;
     //椹卞姩绋嬪簭鍚�
    static String driver = "com.mysql.jdbc.Driver";
    //URL鎸囧悜瑕佽闂殑鏁版嵁搴撳悕mydata
    static String url = "jdbc:mysql://localhost:3306/airport";
    //MySQL閰嶇疆鏃剁殑鐢ㄦ埛鍚�
    static String user = "root";
    //MySQL閰嶇疆鏃剁殑瀵嗙爜
    static String password = "526697";
    //閬嶅巻鏌ヨ缁撴灉闆�
    

    public static boolean displayaccount() throws SQLException, ClassNotFoundException{
    	account = new Vector<>();
    	int count=0;
  	  Class.forName(driver);
      //1.getConnection()鏂规硶锛岃繛鎺ySQL鏁版嵁搴擄紒锛�
      con = DriverManager.getConnection(url,user,password);
      if(!con.isClosed())
          System.out.println("Succeeded connecting to the Database!");
        //2.鍒涘缓statement绫诲璞★紝鐢ㄦ潵鎵цSQL璇彞锛侊紒
        Statement statement = con.createStatement();
        //瑕佹墽琛岀殑SQL璇彞
        String sql = "select * from airport.accountinformation";
        //3.ResultSet绫伙紝鐢ㄦ潵瀛樻斁鑾峰彇鐨勭粨鏋滈泦锛侊紒
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()){
        	
        	
            //鑾峰彇stuname杩欏垪鏁版嵁
        	if( rs.getString("username").equals(logwindow.nowuser) )
            //鑾峰彇stuid杩欏垪鏁版嵁
           {
        		 Vector<String>rowV = new Vector<>();
        		 rowV.add(rs.getString("realname")); //鍒濆鍖栨暟缁勫唴瀹� 
        		 rowV.add(rs.getString("IDnum"));
        		 rowV.add(rs.getString("TEL"));
        		 account.add(rowV);
        		 
        		 rowData[count][0]=rs.getString("realname");
        		 rowData[count][1]=rs.getString("IDnum");
        				 rowData[count][2]=rs.getString("TEL");
        				 count++;
        	}
       }          
        rs.close();
        con.close();
    
  	return false;
  }
    
    public static boolean addaccount() throws SQLException, ClassNotFoundException{
    	
    	SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		String timenumber = df.format(new Date());// new Date()为获取当前系统时间
		
  	  Class.forName(driver);
      //1.getConnection()鏂规硶锛岃繛鎺ySQL鏁版嵁搴擄紒锛�
      con = DriverManager.getConnection(url,user,password);
      if(!con.isClosed())
          System.out.println("Succeeded connecting to the Database!");
        //2.鍒涘缓statement绫诲璞★紝鐢ㄦ潵鎵цSQL璇彞锛侊紒
        Statement statement = con.createStatement();
        //瑕佹墽琛岀殑SQL璇彞
        String sql = "select * from airport.accountinformation";
        //3.ResultSet绫伙紝鐢ㄦ潵瀛樻斁鑾峰彇鐨勭粨鏋滈泦锛侊紒
        ResultSet rs = statement.executeQuery(sql);
      
        java.sql.PreparedStatement psql;
        psql= con.prepareStatement("insert into airport.accountinformation (username, TEL, IDnum,realname,number)" 
          			  + "values(?,?,?,?,?)");
        psql.setString(1, logwindow.nowuser);
        psql.setString(2, IDnum);
        psql.setString(3, TEL);
        psql.setString(4, realname);
        psql.setString(5, timenumber);
        psql.executeUpdate();
        rs.close();
        con.close();
        return true;
}
          

    
    public static boolean deleteaccount() throws SQLException, ClassNotFoundException{
    	  Class.forName(driver);
        //1.getConnection()鏂规硶锛岃繛鎺ySQL鏁版嵁搴擄紒锛�
        con = DriverManager.getConnection(url,user,password);
        if(!con.isClosed())
            System.out.println("Succeeded connecting to the Database!");
          //2.鍒涘缓statement绫诲璞★紝鐢ㄦ潵鎵цSQL璇彞锛侊紒
          Statement statement = con.createStatement();
          //瑕佹墽琛岀殑SQL璇彞
          
          String sql = "delete  from airport.accountinformation where IDnum ='"+IDnum+"'"; 
          PreparedStatement pstmt = con.prepareStatement(sql);
   	   	  pstmt.executeUpdate();
   	   	  con.close();
      
    	return false;
    }

}
