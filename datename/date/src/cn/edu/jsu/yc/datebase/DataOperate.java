package cn.edu.jsu.yc.datebase;


	/*import java.sql.Connection;
	import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
	import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;


	public class DataOperate {
		
		private static String firstName="��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
		
		private static String sc="���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
		
	    private static String boy="ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
	    
		private static String thing="";
	

	    public static int getNum(int start,int end) {//������ط���ָ����Χ�������
	    	//Math.random()�������0.0��1.0֮�����
	        return (int)(Math.random()*(end-start+1)+start);
	    }
	    //������ر��
	    public static StringBuilder getStuno() {//��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
	    	StringBuilder bh=new StringBuilder("201999");//���ǰ6λ��ͬ
	    	StringBuilder xh1=new StringBuilder(String.valueOf(getNum(1,9999)));//���ȡ��4λ
	    	if(xh1.length()==1) {
	    		xh1=xh1.insert(0, "000");//�����1λ����ǰ������2��0
	    		bh=bh.append(xh1);//ǰ6λ���3λƴ�ӳɱ��
	    	}else if(xh1.length()==2) {
	    		xh1=xh1.insert(0, "00");//�����2λ����ǰ������1��0
	    		bh=bh.append(xh1);
	    	}else if(xh1.length()==3) {
	    		xh1=xh1.insert(0, "0");//�����3λ����ǰ������1��0
	    		bh=bh.append(xh1);
	    	}else {
	    		bh=bh.append(xh1);
	    	}
	    	return bh;
	    }
	    //��������������� 
	    public static String getChineseName() {
	       int index=getNum(0, firstName.length()-1);//���ȡ�����ַ����е�����λ��
	        String first=firstName.substring(index, index+1);//��ȡ��λ�õ�����
	        int sex=getNum(0,1);//���ȡ�Ա�����1Ϊ������0ΪŮ��
	        String str=boy;//��������Ϊ�����ַ���
	        int length=boy.length();//��ȡ�����ַ����ĳ���
	        if(sex==0){//��������ȡΪ0�������ָ�ΪŮ��
	            str=girl;
	            length=girl.length();
	        }
	        index=getNum(0,length-1);//�����ȡ���ֵ�λ��
	        String second=str.substring(index, index+1);//��ȡ��λ���е�����
	        int hasThird=getNum(0,1);//�����ȡ�����Ƿ��е�������
	        String third="";//Ĭ��û�е�������
	        if(hasThird==1){//��������ȡΪ1�����е�������
	            index=getNum(0,length-1);
	            third=str.substring(index, index+1);
	        }
	        return first+second+third;//��������
	    	int index=getNum(0, firstName.length()-1);//���ȡ�����ַ����е�����λ��
	    	String first=firstName.substring(index, index+1);//��ȡ��λ�õ�����
	    	String second=sc.substring(index, index+1);//��ȡ��λ�õ�����
	    	return first+second;
	    }
	   
	    public static void addjg() {//���Ӽ۸�
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	    	String sql="insert into scj(bh,mc,jg,chl) values(?,?,?,?)";//ʹ��ռλ������������
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	        	ArrayList<String> alist=new ArrayList<String>();//���弯��
	    		for(int i=1;i<=300;) {
	    			String bh=getStuno().toString();//�����ȡ���
	    			if(!alist.contains(bh)) {//�жϱ���Ƿ�Ψһ
	    				alist.add(bh);//����ż��뼯��
	    				String mc=getChineseName();//�����ȡ����
	    				int jg=getNum(50, 100);//�����ȡ�۸�
	    				int chl=getNum(1, 100);//�����ȡ�����
	    				pstmt.setString(1, bh);//�����1��ռλ��������
	    	    		pstmt.setString(2, mc);//�����2��ռλ��������
	    	    		pstmt.setInt(3, jg);//�����3��ռλ��������
	    	    		pstmt.setInt(4, chl);//�����3��ռλ��������
	    	    		pstmt.addBatch();//����������ȴ�ִ��
	    				i++;//���Ψһ��ѭ����������ִ��
	    			}
	    		}
	    		pstmt.executeBatch();//����ִ�в������
	    		JOptionPane.showMessageDialog(null, "sucess");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
	    public static Vector<Vector> getSelectAll(String sql){
	    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
	    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
	    		while(rs.next()) {//�������ݼ�
	    			Vector row=new Vector();//����������
	    			row.add(rs.getString(1));//��ȡ��һ���ֶα��
	    			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�����
	    			row.add(rs.getInt(3));//��ȡ�������ֶμ۸�
	    			row.add(rs.getInt(4));//��ȡ��4���ֶδ����
	    			rows.add(row);//����������ӵ���¼������
	    		}
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return rows;//��������������
	    }
	    public static void main(String[] args) {
	    	addjg();
	    }
		
	}*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

public class DataOperate {//����10000����Ʒ������Ϣ
	private static String  food[]= {"����","ѩ��","ũ��ɽȪ","����","ad��","��Ľϣ","������","˫��","������","���׿�","��ţ��ţ��","��ţ������","��ţ����","������ţ��","����������","��������","�츣��","�ܲ�ʿ","���������","�ɴ���","���","����","���ɵ���","���ɱ���","���ɿ���","÷��Ү","���","�̶���","���","����","��ɳ","����","�춹��","�̿�","�ڿ�","���ǿ�","���ֿ�","�ķֿ�","�߷ֿ�","�ŷֿ�","����","�̿�","����","����","����","����","����","ë��","����","ñ��","����","Χ��","����","�۾�","Ь��","��Ь","������","������","�ں�","�۵�"};
    public static int getNum(int start,int end) {//������ط���ָ����Χ�������
    	//Math.random()�������0.0��1.0֮�����
        return (int)(Math.random()*(end-start+1)+start);
    }
    //������ر��
    public static StringBuilder getStuno() {//��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
    	StringBuilder xh=new StringBuilder("2021");//���ǰ4λ��ͬ
    	StringBuilder xh1=new StringBuilder(String.valueOf(getNum(1,60)));//���ȡ��4λ
    	if(xh1.length()==1) {
    		xh1=xh1.insert(0, "000");//�����1λ����ǰ������3��0 		
    		xh=xh.append(xh1);//ǰ6λ���4λƴ��
    	}/*else if(xh1.length()==2) {
    		xh1=xh1.insert(0, "00");//�����2λ����ǰ������2��0
    		xh=xh.append(xh1);
    	}else if(xh1.length()==3) {
    		xh1=xh1.insert(0, "0");//�����3λ����ǰ������1��0
    		xh=xh.append(xh1);
    	}*/
    	else {
    		xh=xh.append(xh1);
    	}
    	return xh;
    }
  //�������ʱ��
    public static StringBuilder gettime() {//��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
    	StringBuilder time=new StringBuilder("2021");//��
    	StringBuilder time1=new StringBuilder(String.valueOf(getNum(1,12)));//�·�
    	StringBuilder time2=new StringBuilder(String.valueOf(getNum(1,28)));//��
    	StringBuilder time3=new StringBuilder(String.valueOf(getNum(1,24)));//Сʱ
    	StringBuilder time4=new StringBuilder(String.valueOf(getNum(1,60)));//����
    	if(time1.length()==1) {
    		time1=time1.insert(0, "0");//�����1λ����ǰ������1��0 		
    		
    	}
    	if(time2.length()==1) {
    		time2=time2.insert(0, "0");//�����1λ����ǰ������1��0 		
    		
    	}
    	if(time3.length()==1) {
    		time3=time3.insert(0, "0");//�����1λ����ǰ������1��0 		
    	}
    	if(time4.length()==1) {
    		time4=time4.insert(0, "0");//�����1λ����ǰ������1��0 		
    	}
    	return time.append(time1.append(time2.append(time3.append(time4))));
    }
    
    //�����������
    public static String getName() {
        int index=getNum(0,59);//���ȡ�ַ����е�����λ��
        String name=food[index];
        return name;//��������
    }
    
    
    public static Vector<Vector> getSelectAll(String sql){
    	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
    		while(rs.next()) {//�������ݼ�
    			Vector row=new Vector();//����������
    			row.add(rs.getString(1));//����ʱ��
    			row.add(rs.getString(2));//��ȡ��2���ֶα��
    			row.add(rs.getString(3));//��ȡ��3���ֶ�����
    			row.add(rs.getInt(4));//��ȡ��4���ֶμ۸�
    			rows.add(row);//����������ӵ���¼������
    		}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return rows;//��������������
    }
    public static void main(String[] args) {
    	addjg();
    	
    }

    public static void addjg() {//���Ӽ۸�
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	String sql="insert into purchase(purchasetime,id,name,price) values(?,?,?,?)";//ʹ��ռλ������������
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
        	ArrayList<String> alist=new ArrayList<String>();//���弯��
    		for(int i=1;i<=10000;) {
    			String id=getStuno().toString();//�����ȡ���
    			String purchasetime=gettime().toString();
    			if(!alist.contains(purchasetime)) {//�ж��Ƿ�Ψһ
    				//�����뼯��
    				alist.add(purchasetime);
    				String name=getName();//�����ȡ����
    				int price=getNum(5, 400);//�����ȡ�۸�
    				pstmt.setString(1, purchasetime);
    				pstmt.setString(2, id);//�����1��ռλ��������
    	    		pstmt.setString(3,name);//�����2��ռλ��������
    	    		pstmt.setInt(4, price);//�����3��ռλ��������
    	    		pstmt.addBatch();//����������ȴ�ִ��
    				i++;//ѧ��Ψһ��ѭ����������ִ��
    			}
    		}
    		pstmt.executeBatch();//����ִ�в������
    		JOptionPane.showMessageDialog(null, "sucess");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
}

