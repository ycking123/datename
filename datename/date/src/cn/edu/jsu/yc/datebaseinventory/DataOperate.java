package cn.edu.jsu.yc.datebaseinventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import cn.edu.jsu.yc.datebase.DatabaseConnectionSql;

public class DataOperate {//加入商品库存数据
	
	private static String  food[]= {"可乐","雪碧","农夫山泉","怡宝","ad钙","安慕希","好丽友","双汇","方便面","凉白开","蒙牛纯牛奶","蒙牛酸酸乳","蒙牛酸奶","伊利纯牛奶","伊利酸酸乳","伊利酸奶","徐福记","熊博士","大白免奶糖","干脆面","香干","豆腐","真巧蛋糕","真巧饼干","真巧克力","梅尼耶","香翅","绿豆糕","红酒","红薯","豆沙","红糖","红豆糕","短裤","内裤","三角裤","三分裤","四分裤","七分裤","九分裤","长裤","绿裤","长袖","短袖","衬衫","外套","秋衣","毛衣","棉衣","帽子","手套","围巾","耳罩","眼镜","鞋子","拖鞋","口香糖","避孕套","口红","粉底"};
    
    public static int getNum(int start,int end) {//随机返回返回指定范围间的整数
    	//Math.random()随机返回0.0至1.0之间的数
        return (int)(Math.random()*(end-start+1)+start);
    }
  
    
  static Vector<Vector> getSelectAll(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
    	try(Connection conn=dbcs.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
    		while(rs.next()) {//遍历数据集
    			Vector row=new Vector();//定义行数据
    			row.add(rs.getString(1));//销售时间
    			row.add(rs.getString(2));//获取第2个字段编号
    			row.add(rs.getString(3));//获取第3个字段名称
    			row.add(rs.getInt(4));//获取第4个字段价格
    			rows.add(row);//将行数据添加到记录集合中
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//返回所有行数据
    }
    public static void main(String[] args) {
    	addjg();
    	
    }

    public static void addjg() {//增加价格
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
    	String sql="insert into inventory(id,name,price,inventory) values(?,?,?,?)";//使用占位符定义插入语句
    	try(Connection conn=dbcs.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
        	//ArrayList<Integer> alist=new ArrayList<Integer>();//定义集合
        	ArrayList<String> alist=new ArrayList<String>();//定义集合
        	int id=202100;//获取编号
        	int index=-1;
        	int index1=-1;
    		for(int i=1;i<=60;) {
    			
    			id++;
    			//String purchasetime=gettime().toString();
    			
    	        index++;
    	        String name=food[index];
    	        
    			if(!alist.contains(id)) {//判断是否唯一
    				//将加入集合
    				alist.add(name);
    				int inventory=getNum(10, 100);//随机获取价格
    				int price=getNum(5, 400);//随机获取价格
    				//pstmt.setString(1, purchasetime);
    				
    	    		
    	    		pstmt.setInt(1, id);//定义第1个占位符的内容
    	    		pstmt.setString(2,name);//定义第2个占位符的内容
    	    		pstmt.setInt(3, price);//定义第3个占位符的内容
    	    		pstmt.setInt(4,inventory);//定义第4个占位符的内容
    	    		
    	    		pstmt.addBatch();//加入批处理等待执行
    				i++;//学号唯一，循环继续往下执行
    			}
    		}
    		pstmt.executeBatch();//批量执行插入操作
    		JOptionPane.showMessageDialog(null, "sucess");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
}

