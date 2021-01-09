package cn.edu.jsu.yc.Dao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.yc.datebase.DatabaseConnectionSql;
import cn.edu.jsu.yc.register.StuOperate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Update extends JFrame {//更新商品信息

	private JPanel contentPane;
	private JTextField txtbh;
	private JButton btnAdd;
	private JTextField textchl;
	private JTextField textjg;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);

					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Update() {
		setTitle("\u66F4\u65B0\u5546\u54C1\u6570\u636E");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		
		JLabel lbbh = new JLabel("\u7F16\u53F7");
		lbbh.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lbbh.setBounds(63, 26, 57, 36);
		contentPane.add(lbbh);
		
		txtbh = new JTextField();
		txtbh.setBounds(158, 32, 152, 32);
		contentPane.add(txtbh);
		txtbh.setColumns(10);
		
		JButton btnadd = new JButton("\u66F4\u65B0");
		btnadd.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 17));
		btnadd.setForeground(new Color(0, 0, 0));
		btnadd.setBounds(63, 178, 81, 32);
		contentPane.add(btnadd);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setBounds(188, 178, 81, 32);
		contentPane.add(btnNewButton);
		
		JLabel lbbh_1 = new JLabel("\u66F4\u6539\u5B58\u8D27\u91CF");
		lbbh_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lbbh_1.setBounds(59, 75, 110, 36);
		contentPane.add(lbbh_1);
		
		textchl = new JTextField();
		textchl.setColumns(10);
		textchl.setBounds(158, 81, 152, 32);
		contentPane.add(textchl);
		
		textjg = new JTextField();
		textjg.setColumns(10);
		textjg.setBounds(158, 123, 152, 32);
		contentPane.add(textjg);
		
		JLabel lbbh_1_1 = new JLabel("\u66F4\u6539\u4EF7\u683C");
		lbbh_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lbbh_1_1.setBounds(63, 121, 106, 36);
		contentPane.add(lbbh_1_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\86152\\Pictures\\Camera Roll\\QQ\u56FE\u724720210109105141.jpg"));
		lblNewLabel.setBounds(0, 0, 379, 263);
		contentPane.add(lblNewLabel);
		btnadd.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
				  updatedate(txtbh.getText(),Integer.parseInt(textjg.getText()),Integer.parseInt(textchl.getText()));		    	
			    	 flush();
			    	 }
			});
		
		
	}
	public static Vector<Vector> getSelectAll(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
    	try(Connection conn=dbcs.getConnection();//获取数据库接
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
    		while(rs.next()) {//遍历数据集
    			Vector row=new Vector();//定义行数据
    			row.add(rs.getInt(1));//销售时间
    			row.add(rs.getInt(2));
    			row.add(rs.getString(3));
    			rows.add(row);//将行数据添加到记录集合中
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//返回所有行数据
    }
	

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
		
	}

			public void flush()//结束后清空
			{	
				txtbh.setText("");	
				textjg.setText("");	
				textchl.setText("");	
			}
	}