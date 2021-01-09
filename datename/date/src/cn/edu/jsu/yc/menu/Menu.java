package cn.edu.jsu.yc.menu;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cn.edu.jsu.yc.register.Administrator;
import cn.edu.jsu.yc.register.Client;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;



public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField txtKey;
	private DefaultTableModel model;
	private TableRowSorter sorter;
	private ArrayList<RowSorter.SortKey> sortKeys;
	
	private Vector<String> titles;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
	}

	
	public Menu() {
		setTitle("商品信息管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		sorter = new TableRowSorter<DefaultTableModel>(model);;
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1047, 42);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("主菜单");
		mnNewMenu.setFont(new Font("华文细黑", Font.BOLD, 14));
		mnNewMenu.setForeground(new Color(0, 0, 0));
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("顾客");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Client dialog = new Client();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("管理员");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Administrator dialog = new Administrator();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		mnNewMenu.add(mntmNewMenuItem);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\86152\\Pictures\\Camera Roll\\QQ图片20210109105141.jpg"));
		lblNewLabel.setBounds(0, 33, 1047, 519);
		contentPane.add(lblNewLabel);
		

	}
  }

