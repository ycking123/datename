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

public class Update extends JFrame {//������Ʒ��Ϣ

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
		lbbh.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		lbbh.setBounds(63, 26, 57, 36);
		contentPane.add(lbbh);
		
		txtbh = new JTextField();
		txtbh.setBounds(158, 32, 152, 32);
		contentPane.add(txtbh);
		txtbh.setColumns(10);
		
		JButton btnadd = new JButton("\u66F4\u65B0");
		btnadd.setFont(new Font("����", Font.BOLD | Font.ITALIC, 17));
		btnadd.setForeground(new Color(0, 0, 0));
		btnadd.setBounds(63, 178, 81, 32);
		contentPane.add(btnadd);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnNewButton.setFont(new Font("����", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setBounds(188, 178, 81, 32);
		contentPane.add(btnNewButton);
		
		JLabel lbbh_1 = new JLabel("\u66F4\u6539\u5B58\u8D27\u91CF");
		lbbh_1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
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
		lbbh_1_1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		lbbh_1_1.setBounds(63, 121, 106, 36);
		contentPane.add(lbbh_1_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\86152\\Pictures\\Camera Roll\\QQ\u56FE\u724720210109105141.jpg"));
		lblNewLabel.setBounds(0, 0, 379, 263);
		contentPane.add(lblNewLabel);
		btnadd.addActionListener(new ActionListener() {//����ť���Ӽ����¼�
			  public void actionPerformed(ActionEvent e) {//������굥��
				  updatedate(txtbh.getText(),Integer.parseInt(textjg.getText()),Integer.parseInt(textchl.getText()));		    	
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
    			row.add(rs.getInt(1));//����ʱ��
    			row.add(rs.getInt(2));
    			row.add(rs.getString(3));
    			rows.add(row);//����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//��������������
    }
	

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
		
	}

			public void flush()//���������
			{	
				txtbh.setText("");	
				textjg.setText("");	
				textchl.setText("");	
			}
	}