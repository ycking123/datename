package cn.edu.jsu.yc.datebaseinventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import cn.edu.jsu.yc.datebase.DatabaseConnectionSql;

public class DataOperate {//������Ʒ�������
	
	private static String  food[]= {"����","ѩ��","ũ��ɽȪ","����","ad��","��Ľϣ","������","˫��","������","���׿�","��ţ��ţ��","��ţ������","��ţ����","������ţ��","����������","��������","�츣��","�ܲ�ʿ","���������","�ɴ���","���","����","���ɵ���","���ɱ���","���ɿ���","÷��Ү","���","�̶���","���","����","��ɳ","����","�춹��","�̿�","�ڿ�","���ǿ�","���ֿ�","�ķֿ�","�߷ֿ�","�ŷֿ�","����","�̿�","����","����","����","����","����","ë��","����","ñ��","����","Χ��","����","�۾�","Ь��","��Ь","������","������","�ں�","�۵�"};
    
    public static int getNum(int start,int end) {//������ط���ָ����Χ�������
    	//Math.random()�������0.0��1.0֮�����
        return (int)(Math.random()*(end-start+1)+start);
    }
  
    
  static Vector<Vector> getSelectAll(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getString(1));//����ʱ��
    			row.add(rs.getString(2));//��ȡ��2���ֶα��
    			row.add(rs.getString(3));//��ȡ��3���ֶ�����
    			row.add(rs.getInt(4));//��ȡ��4���ֶμ۸�
    			rows.add(row);//����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//��������������
    }
    public static void main(String[] args) {
    	addjg();
    	
    }

    public static void addjg() {//���Ӽ۸�
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	String sql="insert into inventory(id,name,price,inventory) values(?,?,?,?)";//ʹ��ռλ������������
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
        	//ArrayList<Integer> alist=new ArrayList<Integer>();//���弯��
        	ArrayList<String> alist=new ArrayList<String>();//���弯��
        	int id=202100;//��ȡ���
        	int index=-1;
        	int index1=-1;
    		for(int i=1;i<=60;) {
    			
    			id++;
    			//String purchasetime=gettime().toString();
    			
    	        index++;
    	        String name=food[index];
    	        
    			if(!alist.contains(id)) {//�ж��Ƿ�Ψһ
    				//�����뼯��
    				alist.add(name);
    				int inventory=getNum(10, 100);//�����ȡ�۸�
    				int price=getNum(5, 400);//�����ȡ�۸�
    				//pstmt.setString(1, purchasetime);
    				
    	    		
    	    		pstmt.setInt(1, id);//�����1��ռλ��������
    	    		pstmt.setString(2,name);//�����2��ռλ��������
    	    		pstmt.setInt(3, price);//�����3��ռλ��������
    	    		pstmt.setInt(4,inventory);//�����4��ռλ��������
    	    		
    	    		pstmt.addBatch();//����������ȴ�ִ��
    				i++;//ѧ��Ψһ��ѭ����������ִ��
    			}
    		}
    		pstmt.executeBatch();//����ִ�в������
    		JOptionPane.showMessageDialog(null, "sucess");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
}

