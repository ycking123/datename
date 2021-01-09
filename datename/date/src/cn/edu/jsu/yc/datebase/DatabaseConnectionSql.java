package cn.edu.jsu.yc.datebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionSql {
	// 定义SQLServer的数据库驱动程序
	public static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;
	// 定义SQLServer数据库的连接地址
	public static final String DBURL = "jdbc:sqlserver://localhost:1433;DatabaseName=design" ;
	// SQL数据库的连接用户名
	public static final String DBUSER = "sa" ;
	// MySQL数据库的连接密码
	public static final String DBPASS = "3482079514yc" ;
	  private Connection conn=null; //保存连接对象
	  public DatabaseConnectionSql() {//构造方法连接数据库
	    try {
	      Class.forName(DBDRIVER);
	      this.conn=DriverManager.getConnection(DBURL,DBUSER,DBPASS);
	    } catch (Exception e) {e.printStackTrace();}
	  }
	  public Connection getConnection() {//返回数据库连接对象
	    return this.conn;
	  }
	  public void close() {//关闭数据连接
	    if(this.conn!=null) {
	      try {this.conn.close();} catch (SQLException e) {e.printStackTrace();}
	}}}