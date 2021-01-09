package cn.edu.jsu.yc.register;



import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.jsu.yc.Dao.Buy;
import cn.edu.jsu.yc.datebase.frmTable05;
import cn.edu.jsu.yc.datebaseinventory.FrmTable06;


import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Client extends JDialog {//顾客功能

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
	public Client () {
		setTitle("\u987E\u5BA2\u529F\u80FD");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("\u6D4F\u89C8\u5546\u54C1");
			btnNewButton.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 12));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					FrmTable06 frame = new FrmTable06();// 实例化窗体
					frame.setLocationRelativeTo(null);// 窗体居中
					frame.setVisible(true);// 窗体可见
				}
			});
			btnNewButton.setBounds(117, 81, 164, 48);
			contentPanel.add(btnNewButton);
		}
		{
			JLabel lblNewLabel = new JLabel("\u8BF7\u9009\u62E9");
			lblNewLabel.setFont(new Font("华文行楷", Font.BOLD, 17));
			lblNewLabel.setForeground(new Color(0, 0, 0));
			lblNewLabel.setBounds(164, 23, 83, 48);
			contentPanel.add(lblNewLabel);
		}
		{
			JButton btnNewButton_3 = new JButton("\u8D2D\u4E70\u5546\u54C1");
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
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
					dispose();
				}
			});
			btnNewButton_3.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 12));
			btnNewButton_3.setBounds(117, 166, 164, 48);
			contentPanel.add(btnNewButton_3);
		}
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\86152\\Pictures\\Camera Roll\\QQ\u56FE\u724720210109105153.jpg"));
		lblNewLabel_1.setBounds(0, 0, 436, 263);
		contentPanel.add(lblNewLabel_1);
	}
}
