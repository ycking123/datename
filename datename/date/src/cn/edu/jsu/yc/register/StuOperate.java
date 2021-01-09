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

public class StuOperate {//账号，密码存储
	 final static File file=new File("d:/stu/stu.txt");
	 public static boolean addStue(String stu,String uid) {//参数uid为学号
		  try(FileReader fr=new FileReader(file);
		      FileWriter fw=new FileWriter(file,true);){
		    char[] tmp=new char[1024];
		    int len=0;
		    while((len=fr.read(tmp))!=-1) {
		       if(new String(tmp,0,len).contains(uid)) {//读取的数据中包含学号
		         return false;
		    }}
		    fw.write(stu);
		  }catch(Exception e1) {e1.printStackTrace();}
		  return true;
		}
	 public static boolean contrast(String stu,String uid) {//参数uid为账号,stu密码
		  try(FileReader fr=new FileReader(file);
		      FileWriter fw=new FileWriter(file,true);){
		    char[] tmp=new char[1024];
		    int len=0;
		    while((len=fr.read(tmp))!=-1) {
		       if(new String(tmp,0,len).contains(uid)&&new String(tmp,0,len).contains(stu)) {//读取的数据中包含账号
		         return true;
		    }}
		    
		  }catch(Exception e1) {e1.printStackTrace();}
		  return false;
		}
	 public static void initTable(DefaultTableModel model) {
		  try(FileReader fr=new FileReader(file);//实例化字符文件流
		      BufferedReader br=new BufferedReader(fr);){//实例化缓冲流
		    String row=null;
		    while((row=br.readLine())!=null) {//按行读取数据
		      model.addRow(row.split("\t"));//将读取的行按分隔符拆分成字符串数组存入数据模型，关键代码
		    }
		  }catch(Exception e1) {e1.printStackTrace();}
		}

   public static void  sortgrade(DefaultTableModel model,JTable table) {
		TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//设置排序器
		table.setRowSorter(sorter);//设置表格的排序器
		ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
		//设置排序字段，下例为第1个字段升序
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
		sorter.setSortKeys(sortKeys);
   }
   public  static void seach(DefaultTableModel model,JTable table,String str) {
	   TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//设置表格模型排序器
	   table.setRowSorter(sorter);//设置表格排序器

	   RowFilter<Object, Object> cjFilter = new RowFilter<Object, Object>() {
		   public boolean include(Entry<? extends Object, ? extends Object> entry) {
			   
		     if(entry.getStringValue(1).contains(str) ) {//过滤第1个字段不包str
		       return true;
		     }
		     return false;
		  }
		 };
		 sorter.setRowFilter(cjFilter);//设置过滤器

   }
   
   
   

	}
