package cn.edu.jsu.yc.register;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class StuOperate {//�˺ţ�����洢
	 final static File file=new File("d:/stu/stu.txt");
	 public static boolean addStue(String stu,String uid) {//����uidΪѧ��
		  try(FileReader fr=new FileReader(file);
		      FileWriter fw=new FileWriter(file,true);){
		    char[] tmp=new char[1024];
		    int len=0;
		    while((len=fr.read(tmp))!=-1) {
		       if(new String(tmp,0,len).contains(uid)) {//��ȡ�������а���ѧ��
		         return false;
		    }}
		    fw.write(stu);
		  }catch(Exception e1) {e1.printStackTrace();}
		  return true;
		}
	 public static boolean contrast(String stu,String uid) {//����uidΪ�˺�,stu����
		  try(FileReader fr=new FileReader(file);
		      FileWriter fw=new FileWriter(file,true);){
		    char[] tmp=new char[1024];
		    int len=0;
		    while((len=fr.read(tmp))!=-1) {
		       if(new String(tmp,0,len).contains(uid)&&new String(tmp,0,len).contains(stu)) {//��ȡ�������а����˺�
		         return true;
		    }}
		    
		  }catch(Exception e1) {e1.printStackTrace();}
		  return false;
		}
	 public static void initTable(DefaultTableModel model) {
		  try(FileReader fr=new FileReader(file);//ʵ�����ַ��ļ���
		      BufferedReader br=new BufferedReader(fr);){//ʵ����������
		    String row=null;
		    while((row=br.readLine())!=null) {//���ж�ȡ����
		      model.addRow(row.split("\t"));//����ȡ���а��ָ�����ֳ��ַ��������������ģ�ͣ��ؼ�����
		    }
		  }catch(Exception e1) {e1.printStackTrace();}
		}

   public static void  sortgrade(DefaultTableModel model,JTable table) {
		TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//����������
		table.setRowSorter(sorter);//���ñ���������
		ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
		//���������ֶΣ�����Ϊ��1���ֶ�����
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
   }
   public  static void seach(DefaultTableModel model,JTable table,String str) {
	   TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//���ñ��ģ��������
	   table.setRowSorter(sorter);//���ñ��������

	   RowFilter<Object, Object> cjFilter = new RowFilter<Object, Object>() {
		   public boolean include(Entry<? extends Object, ? extends Object> entry) {
			   
		     if(entry.getStringValue(1).contains(str) ) {//���˵�1���ֶβ���str
		       return true;
		     }
		     return false;
		  }
		 };
		 sorter.setRowFilter(cjFilter);//���ù�����

   }
   
   
   

	}
