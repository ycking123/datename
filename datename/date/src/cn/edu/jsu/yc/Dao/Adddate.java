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

public class Adddate extends JFrame {//加入商品信息

	private JPanel contentPane;
	private JTextField txtbh;
	private JTextField txtxm;
	private JButton btnAdd;
	private JTextField textprice;
	private JTextField textinventory;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adddate frame = new Adddate();
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
	public Adddate() {
		setTitle("\u6DFB\u52A0\u6570\u636E");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		
		JLabel lbbh = new JLabel("\u7F16\u53F7");
		lbbh.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lbbh.setBounds(48, 23, 57, 36);
		contentPane.add(lbbh);
		
		txtbh = new JTextField();
		txtbh.setBounds(127, 29, 152, 32);
		contentPane.add(txtbh);
		txtbh.setColumns(10);
		
		JLabel lblxm = new JLabel("\u59D3\u540D");
		lblxm.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblxm.setBounds(48, 76, 58, 15);
		contentPane.add(lblxm);
		
		txtxm = new JTextField();
		txtxm.setColumns(10);
		txtxm.setBounds(127, 71, 152, 32);
		contentPane.add(txtxm);
		
		JButton btnadd = new JButton("\u6DFB\u52A0");
		btnadd.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 17));
		btnadd.setForeground(new Color(0, 0, 0));
		btnadd.setBounds(63, 207, 81, 32);
		contentPane.add(btnadd);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setBounds(182, 207, 81, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblprice = new JLabel("\u4EF7\u683C");
		lblprice.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblprice.setBounds(48, 118, 58, 15);
		contentPane.add(lblprice);
		
		JLabel lblchl = new JLabel("\u5B58\u8D27\u91CF");
		lblchl.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblchl.setBounds(48, 160, 58, 15);
		contentPane.add(lblchl);
		
		textprice = new JTextField();
		textprice.setColumns(10);
		textprice.setBounds(127, 113, 152, 32);
		contentPane.add(textprice);
		
		textinventory = new JTextField();
		textinventory.setColumns(10);
		textinventory.setBounds(127, 155, 152, 32);
		contentPane.add(textinventory);
		
		JLabel lblinventory = new JLabel("New label");
		lblinventory.setIcon(new ImageIcon("C:\\Users\\86152\\Pictures\\Camera Roll\\QQ\u56FE\u724720210107150540.jpg"));
		lblinventory.setBounds(0, 0, 379, 263);
		contentPane.add(lblinventory);
		btnadd.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
				  addalldate(txtbh.getText(),txtxm.getText(),Integer.parseInt(textprice.getText()),Integer.parseInt(textinventory.getText()));
			    	 
			    	 
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
    			row.add(rs.getString(1));//销售时间
    			row.add(rs.getString(2));//获取第2个字段编号
    			row.add(rs.getInt(3));//获取第3个字段名称
    			row.add(rs.getInt(4));//获取第4个字段价格
    			rows.add(row);//将行数据添加到记录集合中
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//返回所有行数据
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
		    	}
		
	}

			public void flush()//结束后清空
			{
				
				textprice.setText("");
				txtxm.setText("");
				txtbh.setText("");
				textinventory.setText("");
					
			}

       

	}