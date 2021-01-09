package cn.edu.jsu.yc.register;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.yc.Dao.Adddate;
import cn.edu.jsu.yc.Dao.Delete;
import cn.edu.jsu.yc.Dao.Update;
import cn.edu.jsu.yc.datebase.frmTable05;

import cn.edu.jsu.yc.datebaseinventory.FrmTable06;

import cn.edu.jsu.yc.datebaseworkers.FrmTable07;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class Administrator extends JDialog {//管理员功能

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			Administrator dialog = new Administrator();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public Administrator() {
		setTitle("\u7BA1\u7406\u5458\u529F\u80FD");
		setBounds(100, 100, 449, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("\u67E5\u8BE2\u5546\u54C1\u5E93\u5B58");
			btnNewButton.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 12));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FrmTable06 frame = new FrmTable06();// 实例化窗体
					frame.setLocationRelativeTo(null);// 窗体居中
					frame.setVisible(true);// 窗体可见
				}
			});
			btnNewButton.setBounds(72, 66, 115, 33);
			contentPanel.add(btnNewButton);
		}
		{
			JLabel lblNewLabel = new JLabel("\u8BF7\u9009\u62E9");
			lblNewLabel.setFont(new Font("华文行楷", Font.BOLD, 17));
			lblNewLabel.setForeground(new Color(0, 0, 0));
			lblNewLabel.setBounds(182, 23, 70, 33);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton btnNewButton_1 = new JButton("\u589E\u52A0\u5546\u54C1\u4FE1\u606F");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
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
				}
			});
			btnNewButton_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 12));
			btnNewButton_1.setBounds(72, 124, 115, 33);
			contentPanel.add(btnNewButton_1);
		}
		{
			JButton btnNewButton_3 = new JButton("\u67E5\u8BE2\u9500\u552E\u60C5\u51B5");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frmTable05 frame = new frmTable05();// 实例化窗体
					frame.setLocationRelativeTo(null);// 窗体居中
					frame.setVisible(true);// 窗体可见
				}
			});
			btnNewButton_3.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 12));
			btnNewButton_3.setBounds(269, 66, 115, 33);
			contentPanel.add(btnNewButton_3);
		}
		{
			JButton btnNewButton_1 = new JButton("\u5220\u9664\u5546\u54C1\u4FE1\u606F");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Delete frame = new Delete();
								frame.setLocationRelativeTo(null);
								frame.setVisible(true);

								 
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			});
			btnNewButton_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 12));
			btnNewButton_1.setBounds(269, 124, 115, 33);
			contentPanel.add(btnNewButton_1);
		}
		
		JButton btnNewButton_1 = new JButton("\u66F4\u6539\u5546\u54C1\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_1.setBounds(72, 192, 115, 33);
		contentPanel.add(btnNewButton_1);
		{
			JButton btnNewButton_1_1 = new JButton("\u67E5\u8BE2\u5458\u5DE5\u4FE1\u606F");
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FrmTable07 frame = new FrmTable07();// 实例化窗体
					frame.setLocationRelativeTo(null);// 窗体居中
					frame.setVisible(true);// 窗体可见
					
				}
			});
			btnNewButton_1_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 12));
			btnNewButton_1_1.setBounds(269, 192, 115, 33);
			contentPanel.add(btnNewButton_1_1);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\86152\\Pictures\\Camera Roll\\QQ\u56FE\u724720210109105153.jpg"));
			lblNewLabel_1.setBounds(0, 0, 518, 263);
			contentPanel.add(lblNewLabel_1);
		}
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 203, 23);
		contentPanel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
	}
}
