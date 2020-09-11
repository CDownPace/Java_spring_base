package com.iteima.jdbc;

import java.sql.DriverManager;

/**
 * 程序的耦合
 * @author guoyu.cai
 *
 */
public class JdbcDemo1 {
   public static void main(String[] args) throws  Exception {
	   /**
	    * 注册驱动
	    */
	   DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	   
	   /**
	    * 获取连接
	    */
	   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy","root","root");
	   /**
	    * 获取操作数据库的预处理对象
	    */
	   PreparedStatement pstm = conn.prepareStatement("select * from account");
	   
	   
	   /**
	    * 执行SQL，得到结果集
	    */
	   ResultSet rs = pstm.executeQuery();
	   /**
	    * 遍历结果集
	    */
	   while(rs.next()){
           System.out.println(rs.getString("name"));
       }
	   /**
	    * 释放资源
	    */
	   rs.close();
       pstm.close();
       conn.close();
	   
   }
}
