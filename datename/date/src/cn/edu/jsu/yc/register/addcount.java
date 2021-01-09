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

public class addcount extends JFrame {//ע���˺�

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
	public addcount() {//ע���˺�
		setTitle("\u6CE8\u518C\u8D26\u53F7");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		
		JLabel lbcode = new JLabel("\u8D26\u53F7");
		lbcode.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		lbcode.setBounds(74, 40, 57, 36);
		contentPane.add(lbcode);
		
		txtaccount = new JTextField();
		txtaccount.setBounds(157, 46, 152, 32);
		contentPane.add(txtaccount);
		txtaccount.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5BC6\u7801");
		lblNewLabel.setFont(new Font("΢���ź�", Font.PLAIN, 18));
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
		btnadd.setFont(new Font("����", Font.BOLD | Font.ITALIC, 17));
		btnadd.setForeground(new Color(0, 0, 0));
		btnadd.setBounds(74, 194, 81, 32);
		contentPane.add(btnadd);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		btnNewButton.setFont(new Font("����", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setBounds(213, 194, 81, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\86152\\Pictures\\Camera Roll\\QQ\u56FE\u724720210107150540.jpg"));
		lblNewLabel_1.setBounds(0, 0, 379, 276);
		contentPane.add(lblNewLabel_1);
		btnadd.addActionListener(new ActionListener() {//����ť���Ӽ����¼�
			  public void actionPerformed(ActionEvent e) {//������굥��
				  dispose();
			    if(addcode()&addXh())//�����������ݼ���
			    {
			    	 String stu=txtaccount.getText()+"\t"+txtcode.getText()+"\r\n";
			    	 if(StuOperate.addStue(stu,txtaccount.getText())) {
			    		    JOptionPane.showMessageDialog(null, "�������ݳɹ�!");
			    		}else {JOptionPane.showMessageDialog(null, "���˺��Ѵ���!");
			    		}
			    	 flush();
			    	 }
			    }

			});
		txtcode.addFocusListener(new FocusAdapter() {//���ı������ӽ�������¼�
			  public void focusLost(FocusEvent e) {//�����ı���ʧȥ����
			   addcode();
			  }
			});
		txtaccount.addFocusListener(new FocusAdapter() {//���ı������ӽ�������¼�
			  public void focusLost(FocusEvent e) {//�����ı���ʧȥ����
			   addXh();
			  }
			});
		
	}
			public void flush()//���������
			{
				
				txtaccount.setText("");
				txtcode.setText("");
				
				lblMsgcode.setText("");
				lblMsgaccount.setText("");
				
			}

       

			public boolean  addcode() {
				if(txtcode.getText().length()==0)
				{
					lblMsgcode.setText("���벻��Ϊ��");
					txtcode.requestFocus();
					txtcode.selectAll();
					return false;
				}
				if(txtcode.getText().length()<6||txtcode.getText().length()>12)
				{
					lblMsgcode.setText("���벻�淶�����޸�");
					txtcode.requestFocus();
					txtcode.selectAll();
					return false;
				}
				return  true;	
			}
			public boolean  addXh() {
				if(txtaccount.getText().length()==0)
				{
					lblMsgaccount.setText("�˺Ų���Ϊ��");
					txtaccount.requestFocus();
					txtaccount.selectAll();
					return false;
				}
				if(txtaccount.getText().length()<6||(txtaccount.getText().length()>12))
				{
					lblMsgaccount.setText("�˺Ų��淶�����޸�");
					txtaccount.requestFocus();
					txtaccount.selectAll();
					return false;
				}
				return  true;	
			}
	}