package cn.edu.jsu.yc.register;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class addcount extends JFrame {//注册账号

	private JPanel contentPane;
	private JTextField txtaccount;
	private JTextField txtcode;
	private JLabel lblMsgaccount;
	private JLabel lblMsgcode;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addcount frame = new addcount();
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
	public addcount() {//注册账号
		setTitle("\u6CE8\u518C\u8D26\u53F7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		
		JLabel lbcode = new JLabel("\u8D26\u53F7");
		lbcode.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lbcode.setBounds(74, 40, 57, 36);
		contentPane.add(lbcode);
		
		txtaccount = new JTextField();
		txtaccount.setBounds(157, 46, 152, 32);
		contentPane.add(txtaccount);
		txtaccount.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5BC6\u7801");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel.setBounds(74, 129, 58, 15);
		contentPane.add(lblNewLabel);
		
		txtcode = new JTextField();
		txtcode.setColumns(10);
		txtcode.setBounds(157, 124, 152, 32);
		contentPane.add(txtcode);
		
		lblMsgaccount = new JLabel("");
		lblMsgaccount.setForeground(Color.RED);
		lblMsgaccount.setBounds(167, 88, 142, 26);
		contentPane.add(lblMsgaccount);
		
		lblMsgcode = new JLabel("");
		lblMsgcode.setForeground(Color.RED);
		lblMsgcode.setBounds(167, 165, 142, 24);
		contentPane.add(lblMsgcode);
		
		JButton btnadd = new JButton("\u6CE8\u518C");
		btnadd.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 17));
		btnadd.setForeground(new Color(0, 0, 0));
		btnadd.setBounds(74, 194, 81, 32);
		contentPane.add(btnadd);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setBounds(213, 194, 81, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\86152\\Pictures\\Camera Roll\\QQ\u56FE\u724720210107150540.jpg"));
		lblNewLabel_1.setBounds(0, 0, 379, 276);
		contentPane.add(lblNewLabel_1);
		btnadd.addActionListener(new ActionListener() {//给按钮增加监听事件
			  public void actionPerformed(ActionEvent e) {//监听鼠标单击
				  dispose();
			    if(addcode()&addXh())//进行输入数据检验
			    {
			    	 String stu=txtaccount.getText()+"\t"+txtcode.getText()+"\r\n";
			    	 if(StuOperate.addStue(stu,txtaccount.getText())) {
			    		    JOptionPane.showMessageDialog(null, "增加数据成功!");
			    		}else {JOptionPane.showMessageDialog(null, "此账号已存在!");
			    		}
			    	 flush();
			    	 }
			    }

			});
		txtcode.addFocusListener(new FocusAdapter() {//给文本框增加焦点监听事件
			  public void focusLost(FocusEvent e) {//监听文本框失去焦点
			   addcode();
			  }
			});
		txtaccount.addFocusListener(new FocusAdapter() {//给文本框增加焦点监听事件
			  public void focusLost(FocusEvent e) {//监听文本框失去焦点
			   addXh();
			  }
			});
		
	}
			public void flush()//结束后清空
			{
				
				txtaccount.setText("");
				txtcode.setText("");
				
				lblMsgcode.setText("");
				lblMsgaccount.setText("");
				
			}

       

			public boolean  addcode() {
				if(txtcode.getText().length()==0)
				{
					lblMsgcode.setText("密码不能为空");
					txtcode.requestFocus();
					txtcode.selectAll();
					return false;
				}
				if(txtcode.getText().length()<6||txtcode.getText().length()>12)
				{
					lblMsgcode.setText("密码不规范，请修改");
					txtcode.requestFocus();
					txtcode.selectAll();
					return false;
				}
				return  true;	
			}
			public boolean  addXh() {
				if(txtaccount.getText().length()==0)
				{
					lblMsgaccount.setText("账号不能为空");
					txtaccount.requestFocus();
					txtaccount.selectAll();
					return false;
				}
				if(txtaccount.getText().length()<6||(txtaccount.getText().length()>12))
				{
					lblMsgaccount.setText("账号不规范，请修改");
					txtaccount.requestFocus();
					txtaccount.selectAll();
					return false;
				}
				return  true;	
			}
	}