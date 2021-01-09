package cn.edu.jsu.yc.register;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import cn.edu.jsu.yc.datebase.frmTable05;
import cn.edu.jsu.yc.menu.Menu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Register1 extends JFrame {

	
	private JPanel contentPane;
	private JTextField txtXh;
	private JTextField txtXm;
	private JLabel lblMsgXh;
	private JLabel lblMsgXm;
	private JButton btnAdd;
	private JTextField textyzm;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register1 frame = new Register1();
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
	public Register1() {
		setTitle("\u767B\u5F55\u5165\u53E3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbXh = new JLabel("\u8D26\u53F7");
		lbXh.setBounds(20, 50, 57, 36);
		lbXh.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		contentPane.add(lbXh);
		
		txtXh = new JTextField();
		txtXh.setBounds(84, 56, 152, 32);
		contentPane.add(txtXh);
		txtXh.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5BC6\u7801");
		lblNewLabel.setBounds(20, 113, 58, 15);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		txtXm = new JTextField();
		txtXm.setBounds(84, 108, 152, 32);
		txtXm.setColumns(10);
		contentPane.add(txtXm);
		
		lblMsgXh = new JLabel("");
		lblMsgXh.setBounds(256, 56, 113, 30);
		lblMsgXh.setForeground(Color.RED);
		contentPane.add(lblMsgXh);
		
		lblMsgXm = new JLabel("");
		lblMsgXm.setBounds(244, 113, 125, 30);
		lblMsgXm.setForeground(Color.RED);
		contentPane.add(lblMsgXm);
		
		JButton btnadd = new JButton("\u767B\u5F55");
		btnadd.setBounds(74, 205, 81, 32);
		btnadd.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 17));
		btnadd.setForeground(new Color(0, 0, 0));
		contentPane.add(btnadd);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.setBounds(199, 205, 81, 32);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								addcount frame = new addcount();
								frame.setLocationRelativeTo(null);
								frame.setVisible(true);
								dispose();

								 
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		);
		btnNewButton.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 17));
		contentPane.add(btnNewButton);
		
		JLabel lbXh_1 = new JLabel("\u9A8C\u8BC1\u7801");
		lbXh_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lbXh_1.setBounds(20, 157, 57, 36);
		contentPane.add(lbXh_1);
		
		textyzm = new JTextField();//验证码
		textyzm.setColumns(10);
		textyzm.setBounds(84, 163, 81, 32);
		contentPane.add(textyzm);
		
		JButton btnadd_1 = new JButton("\u751F\u6210\u9A8C\u8BC1\u7801");
		int math=getNum(1000,10000);//随机生成验证码
		
		btnadd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null, math);
			}

			
		});
		btnadd_1.setForeground(Color.BLACK);
		btnadd_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 17));
		btnadd_1.setBounds(188, 163, 131, 32);
		contentPane.add(btnadd_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\86152\\Pictures\\Camera Roll\\QQ\u56FE\u724720210107150540.jpg"));
		lblNewLabel_1.setBounds(0, 0, 389, 273);
		contentPane.add(lblNewLabel_1);
		btnadd.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
			    if(addXm()&&addXh()&&addyzm())//进行输入数据检验
			    {
			    	 if(StuOperate.contrast(txtXh.getText(),txtXm.getText())) {
			    		 try {
			    			 EventQueue.invokeLater(new Runnable() {
			    					public void run() {
			    						try {
			    							Menu frame = new Menu();
			    							frame.setVisible(true);
			    						} catch (Exception e) {
			    							e.printStackTrace();
			    						}
			    					}
			    				});
			    				dispose();
			    			} catch (Exception e1) {
			    				e1.printStackTrace();
			    				
			    			}
			    		}else {
			    			JOptionPane.showMessageDialog(null, "账号或密码或验证码错误，请重新输入!");
			    		}
			    	 flush();
			    	 }
			    }

			});
		txtXm.addFocusListener(new FocusAdapter() {//给文本框增加焦点监听事件
			  public void focusLost(FocusEvent e) {//监听文本框失去焦点
			   addXm();
			  }
			});
		txtXh.addFocusListener(new FocusAdapter() {//给文本框增加焦点监听事件
			  public void focusLost(FocusEvent e) {//监听文本框失去焦点
			   addXh();
			  }
			});
		
	}
			private int getNum(int i, int j) {
				return (int)(Math.random()*(j-i+1)+i);
		
	}

			protected boolean addyzm() {
				return rootPaneCheckingEnabled;
				//if(Integer.parseInt(textyzm.getText())==math)
				//{
					//lblMsgXm.setText("密码不能为空");
					//txtXm.requestFocus();
					//txtXm.selectAll();
					//return true;
				//}
		
	}

			public void flush()//结束后清空
			{
				txtXh.setText("");
				txtXm.setText("");
				textyzm.setText("");
				lblMsgXm.setText("");
				lblMsgXh.setText("");
				
			}

       

	public boolean  addXm() {
		if(txtXm.getText().length()==0)
		{
			lblMsgXm.setText("密码不能为空");
			txtXm.requestFocus();
			txtXm.selectAll();
			return false;
		}
		if(txtXm.getText().length()<6||txtXm.getText().length()>12)
		{
			lblMsgXm.setText("密码不规范，请修改");
			txtXm.requestFocus();
			txtXm.selectAll();
			return false;
		}
		return  true;	
	}
	public boolean  addXh() {
		if(txtXh.getText().length()==0)
		{
			lblMsgXh.setText("账号不能为空");
			txtXh.requestFocus();
			txtXh.selectAll();
			return false;
		}
		if(txtXh.getText().length()<6||(txtXh.getText().length()>12))
		{
			lblMsgXh.setText("账号不规范，请修改");
			txtXh.requestFocus();
			txtXh.selectAll();
			return false;
		}
		return  true;	
	}
	}