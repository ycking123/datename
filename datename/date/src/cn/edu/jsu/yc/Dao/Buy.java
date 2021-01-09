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

public class Buy extends JFrame {//�û�������Ʒ

	private JPanel contentPane;
	private JTextField txtname;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buy frame = new Buy();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);

					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Buy() {
		setTitle("\u8D2D\u4E70\u5546\u54C1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		
		JLabel lbbh = new JLabel("\u540D\u79F0");
		lbbh.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		lbbh.setBounds(70, 86, 57, 36);
		contentPane.add(lbbh);
		
		txtname = new JTextField();
		txtname.setBounds(160, 92, 152, 32);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JButton btnadd = new JButton("\u8D2D\u4E70");
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\86152\\Pictures\\Camera Roll\\QQ\u56FE\u724720210109105153.jpg"));
		lblNewLabel.setBounds(0, 0, 379, 263);
		contentPane.add(lblNewLabel);
		btnadd.addActionListener(new ActionListener() {//����ť���Ӽ����¼�
			  public void actionPerformed(ActionEvent e) {//������굥��
				  updatedate(txtname.getText());		    	
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
    			
    			row.add(rs.getString(1));
    			rows.add(row);//����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//��������������
    }
	

			protected void updatedate(String name) {
				DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
		    	String sql="update  inventory set inventory=inventory-1 where name=?";//ʹ��ռλ������������
		    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
		    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
		        	//ArrayList<String> alist=new ArrayList<String>();//���弯��	    		
		    				//�����뼯��
		    				//alist.add(id);
		    		        
		    				pstmt.setString(1,name);//�����1��ռλ��������	
		    				
		    	    		pstmt.addBatch();//����������ȴ�ִ��
		    				
		    		pstmt.executeBatch();//����ִ�в������
		    		JOptionPane.showMessageDialog(null, "success");
		    	}catch(SQLException e) {
		    		e.printStackTrace();
		    	}
		
	}

			public void flush()//���������
			{	
				txtname.setText("");	
					
			}
	}