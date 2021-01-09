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

public class Adddate extends JFrame {//������Ʒ��Ϣ

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
		lbbh.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		lbbh.setBounds(48, 23, 57, 36);
		contentPane.add(lbbh);
		
		txtbh = new JTextField();
		txtbh.setBounds(127, 29, 152, 32);
		contentPane.add(txtbh);
		txtbh.setColumns(10);
		
		JLabel lblxm = new JLabel("\u59D3\u540D");
		lblxm.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		lblxm.setBounds(48, 76, 58, 15);
		contentPane.add(lblxm);
		
		txtxm = new JTextField();
		txtxm.setColumns(10);
		txtxm.setBounds(127, 71, 152, 32);
		contentPane.add(txtxm);
		
		JButton btnadd = new JButton("\u6DFB\u52A0");
		btnadd.setFont(new Font("����", Font.BOLD | Font.ITALIC, 17));
		btnadd.setForeground(new Color(0, 0, 0));
		btnadd.setBounds(63, 207, 81, 32);
		contentPane.add(btnadd);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnNewButton.setFont(new Font("����", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setBounds(182, 207, 81, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblprice = new JLabel("\u4EF7\u683C");
		lblprice.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		lblprice.setBounds(48, 118, 58, 15);
		contentPane.add(lblprice);
		
		JLabel lblchl = new JLabel("\u5B58\u8D27\u91CF");
		lblchl.setFont(new Font("΢���ź�", Font.PLAIN, 18));
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
		btnadd.addActionListener(new ActionListener() {//����ť���Ӽ����¼�
			  public void actionPerformed(ActionEvent e) {//������굥��
				  addalldate(txtbh.getText(),txtxm.getText(),Integer.parseInt(textprice.getText()),Integer.parseInt(textinventory.getText()));
			    	 
			    	 
			    	 flush();
			    	 }

			
			    
			});
		
		
	}
	public static Vector<Vector> getSelectAll(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getString(1));//����ʱ��
    			row.add(rs.getString(2));//��ȡ��2���ֶα��
    			row.add(rs.getInt(3));//��ȡ��3���ֶ�����
    			row.add(rs.getInt(4));//��ȡ��4���ֶμ۸�
    			rows.add(row);//����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//��������������
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
		    	}
		
	}

			public void flush()//���������
			{
				
				textprice.setText("");
				txtxm.setText("");
				txtbh.setText("");
				textinventory.setText("");
					
			}

       

	}