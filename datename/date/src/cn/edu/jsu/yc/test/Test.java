package cn.edu.jsu.yc.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cn.edu.jsu.yc.datebase.DatabaseConnectionSql;

class Test {//������
	
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
			updatedate("�㽶",3,3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private Integer getNum(int start, int end) {
		
	    	//Math.random()�������0.0��1.0֮�����
	        return (int)(Math.random()*(end-start+1)+start);
	    }
	

	
	protected void deletedate(String id) {
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	String sql="delete from inventory where id= ?";//ʹ��ռλ������������
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
        	//ArrayList<String> alist=new ArrayList<String>();//���弯��	    		
    				//�����뼯��
    				//alist.add(id);
    				
    				pstmt.setString(1, id);//�����1��ռλ��������		    	    	
    	    		pstmt.addBatch();//����������ȴ�ִ��
    				
    		pstmt.executeBatch();//����ִ�в������
    		JOptionPane.showMessageDialog(null, "success");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}

}
	protected void addalldate(String id,String name,int price,int inventory) {
		DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
		String sql="insert into inventory(id,name,price,inventory) values(?,?,?,?)";//ʹ��ռλ������������
		try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
			PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    	ArrayList<String> alist=new ArrayList<String>();//���弯��
			for(int i=1;i<=1;) {
				
				if(!alist.contains(id)) {//�ж��Ƿ�Ψһ
					//�����뼯��
					alist.add(id);
					
					
					pstmt.setString(1, id);//�����1��ռλ��������
		    		pstmt.setString(2,name);//�����2��ռλ��������
		    		pstmt.setInt(3, price);//�����3��ռλ��������
		    		pstmt.setInt(4, inventory);//�����4��ռλ��������
		    		pstmt.addBatch();//����������ȴ�ִ��
					i++;//ѧ��Ψһ��ѭ����������ִ��
				}
			}
			pstmt.executeBatch();//����ִ�в������
			JOptionPane.showMessageDialog(null, "success");
		}catch(SQLException e) {
			e.printStackTrace();
		}}

protected void updatedate(String id,int price,int inventory) {
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	String sql="update  inventory set price=? ,inventory=? where id=?";//ʹ��ռλ������������
	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    	ArrayList<String> alist=new ArrayList<String>();//���弯��	    		
				//�����뼯��
				alist.add(id);
		        pstmt.setInt(1, price);
		        pstmt.setInt(2,inventory);
				pstmt.setString(3, id);//�����1��ռλ��������	
				
	    		pstmt.addBatch();//����������ȴ�ִ��
				
		pstmt.executeBatch();//����ִ�в������
		JOptionPane.showMessageDialog(null, "success");
	}catch(SQLException e) {
		e.printStackTrace();
	}

}}
