package cn.edu.jsu.yc.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cn.edu.jsu.yc.datebase.DatabaseConnectionSql;

class Test {//测试类
	
	@org.junit.jupiter.api.Test
	/*void test() {
		try {
			assertEquals(getNum(1,1),1);
		} catch (Exception e) {
			e.printStackTrace();
		}
			}*/
	void test1() {
		
			try {
				addalldate("2019401256","ak47",1000,12);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	
	void test2() {
		try {
			deletedate("2019401256");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	void test3() {
		try {
			updatedate("香蕉",3,3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private Integer getNum(int start, int end) {
		
	    	//Math.random()随机返回0.0至1.0之间的数
	        return (int)(Math.random()*(end-start+1)+start);
	    }
	

	
	protected void deletedate(String id) {
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
    	String sql="delete from inventory where id= ?";//使用占位符定义插入语句
    	try(Connection conn=dbcs.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
        	//ArrayList<String> alist=new ArrayList<String>();//定义集合	    		
    				//将加入集合
    				//alist.add(id);
    				
    				pstmt.setString(1, id);//定义第1个占位符的内容		    	    	
    	    		pstmt.addBatch();//加入批处理等待执行
    				
    		pstmt.executeBatch();//批量执行插入操作
    		JOptionPane.showMessageDialog(null, "success");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}

}
	protected void addalldate(String id,String name,int price,int inventory) {
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
		String sql="insert into inventory(id,name,price,inventory) values(?,?,?,?)";//使用占位符定义插入语句
		try(Connection conn=dbcs.getConnection();//获取数据库接
			PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	    	ArrayList<String> alist=new ArrayList<String>();//定义集合
			for(int i=1;i<=1;) {
				
				if(!alist.contains(id)) {//判断是否唯一
					//将加入集合
					alist.add(id);
					
					
					pstmt.setString(1, id);//定义第1个占位符的内容
		    		pstmt.setString(2,name);//定义第2个占位符的内容
		    		pstmt.setInt(3, price);//定义第3个占位符的内容
		    		pstmt.setInt(4, inventory);//定义第4个占位符的内容
		    		pstmt.addBatch();//加入批处理等待执行
					i++;//学号唯一，循环继续往下执行
				}
			}
			pstmt.executeBatch();//批量执行插入操作
			JOptionPane.showMessageDialog(null, "success");
		}catch(SQLException e) {
			e.printStackTrace();
		}}

protected void updatedate(String id,int price,int inventory) {
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	String sql="update  inventory set price=? ,inventory=? where id=?";//使用占位符定义插入语句
	try(Connection conn=dbcs.getConnection();//获取数据库接
		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    	ArrayList<String> alist=new ArrayList<String>();//定义集合	    		
				//将加入集合
				alist.add(id);
		        pstmt.setInt(1, price);
		        pstmt.setInt(2,inventory);
				pstmt.setString(3, id);//定义第1个占位符的内容	
				
	    		pstmt.addBatch();//加入批处理等待执行
				
		pstmt.executeBatch();//批量执行插入操作
		JOptionPane.showMessageDialog(null, "success");
	}catch(SQLException e) {
		e.printStackTrace();
	}

}}
