package com.view;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.maple.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.AncestorListener;

import com.mytool.Tool;
import com.sqldb.Sqloperation;
import com.sqldb.Sqloperationcust;
import com.sqldb.Sqloperationhiscus;
import com.sqldb.Sqloperationroom;
public class Window extends JFrame implements ActionListener,ItemListener,MouseListener{
	static float sumacc=0f;
	static int width=Toolkit.getDefaultToolkit().getScreenSize().width;
	static int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	Font font2=new Font("������κ",Font.BOLD,50);
	Font font1=new Font("����",Font.BOLD,20);
	Connection ct=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    int price=0;
	//����jscp�ֽ���
	static int devide=width;
	static int srcway=0;
	//static int roomstyle=0;
	Sqloperation sqlop=null;
	static String roomid=null;
	static String cname=null;
	//�رհ�ť
	JLabel jlb_close=null;
	//static JLabel templabel=null;
	Sqloperationroom spoproom=null;
	//jscp
	JScrollPane jscp=null;
	//����id
	String setacct=null;
	int rownum=0;
	//JMenuBar
	JMenuBar jbr=null;
	//JToolBar
	JToolBar jtb=null;
	//jsp
	static JSplitPane jsp=null;
	//JToolBar�е�JButton
	JButton jb1=null;
	JButton jb2=null;
	JButton jb3=null;
	JButton jb4=null;
	JButton jb5=null;
	//�˵�
	JMenu jm1=null;
	JMenu jm2=null;
	JMenu jm3=null;
	JMenu jm4=null;
	JMenu jm5=null;
	JMenu jm6=null;
	//jm1ѡ��
	JMenuItem jmi1_1=null;
	JMenuItem jmi1_2=null;
	JMenuItem jmi1_3=null;
	JMenuItem jmi1_4=null;
	JMenuItem jmi1_5=null;
	JMenuItem jmi1_6=null;
	//jm2ѡ��
	JMenuItem jmi2_1=null;
	JMenuItem jmi2_2=null;
	JMenuItem jmi2_3=null;
	JMenuItem jmi2_4=null;
	JMenuItem jmi2_5=null;
	//jm3ѡ��
	JMenuItem jmi3_1=null;
	JMenuItem jmi3_2=null;
	JMenuItem jmi3_3=null;
	JMenuItem jmi3_4=null;
	JMenuItem jmi3_5=null;
	//jm4ѡ��
	JMenuItem jmi4_1=null;
	JMenuItem jmi4_2=null;
	JMenuItem jmi4_3=null;
	JMenuItem jmi4_4=null;
	JMenuItem jmi4_5=null;
	//jp1
	JPanel jp1=null;
	Image im1=null;
	ImgBack imb1=null;
	//jp1�е�jlabel
	JLabel jlb1=null;
	JLabel jlb2=null;
	JLabel jlb3=null;
	JLabel jlb4=null;
	JLabel jlb5=null;
	JLabel jlb6=null;
	//jp2�е�
	JTable jtable=null;
	JPanel jp2=null;
	JPanel jp2_1=null;
	JButton jb2_1=null;
	JButton jb2_shwall=null;
	JButton jb2_2=null;
	JButton jb2_3=null;
	JButton jb2_4=null;
	JTextField jtf2_1=null;
	JButton jbbook=null;
	JButton jbreturn=null;
	//jp2�еĹ˿�
	JLabel jlbc_id=null;
	JLabel jlbc_name=null;
	JLabel jlbc_time=null;
	JLabel jlbc_rid=null;
	JLabel jlbc_person=null;
	JLabel jlbc_cost=null;
	JLabel jlbc_check=null;
	JTextField jlbc_getid=null;
	JTextField jlbc_getname=null;
	JTextField jlbc_gettime=null;
	JLabel  jlbc_getrid=null;
	JTextField jlbc_getperson=null;
	JTextField jlbc_getcost=null;
	//room label
	JLabel jlb_cinf=null;
	JLabel jlb_getcinf=null;
	JLabel jlb_rs=null;
	JLabel jlb_room1=null;
	JLabel jlb_room2=null;
	JLabel jlb_room3=null;
	JLabel jlb_room4=null;
	JLabel jlb_room5=null;
	JLabel jlb_room6=null;
	JLabel jlb_room7=null;
	JLabel jlb_room8=null;
	JLabel jlb_room9=null;
	JButton jb_surebook=null;
	JButton jbrbook=null;//�˶�
	JLabel jlb_rid=null;
	JLabel jlb_rprice=null;
	JLabel jlb_risbook=null;
	JLabel jlb_rstyle=null;
	JLabel jlb_getrid=null;
	JLabel jlb_getrprice=null;
	JLabel jlb_getrisbook=null;
	JLabel jlb_getrstyle=null;
	JLabel jlbr1=null;
	JLabel jlbr2=null;//������
	JLabel jlbr3=null;//������
	//jp3_1��
	JTextField jtfname=null;
	JTextField jtfsex=null;
	JTextField jtfage=null;
	JTextField jtfid=null;
	JTextField jtfposition=null;
	JTextField jtfsalary=null;
	JComboBox jbx=null;
	JLabel jlb3_opway=null;
	JLabel jlb3_opid=null;
	JLabel jlb3_name=null;
	JLabel jlb3_id=null;
	JLabel jlb3_sex=null;
	JLabel jlb3_age=null;
	JLabel jlb3_position=null;
	JLabel jlb3_salary=null;
	JLabel jlb3_getname=null;
	JLabel jlb3_getid=null;
	JLabel jlb3_getsex=null;
	JLabel jlb3_getage=null;
	JLabel jlb3_getposition=null;
	JLabel jlb3_getsalary=null;
	JLabel jlb3_head=null;
	JButton jbsure=null;
	//JButton jb2_1=null;
	//��ʷ�ͻ�ɾ��Button
	JButton jbdelete=null;
	//�ͻ�����JLabel
	JLabel jlb_cname=null;
	JLabel jlb_cid=null;
	JLabel jlb_cvip=null;
	JLabel jlb_ccost=null;
	JLabel jlb_cperson=null;
	JLabel jlb_crid=null;
	JLabel jlb_cisvip=null;
	JLabel jlb_getcname=null;
	JLabel jlb_getcid=null;
	JLabel jlb_getcvip=null;
	JLabel jlb_getccost=null;
	JLabel jlb_getcperson=null;
	JLabel jlb_getcrid=null;
	//GOODS
	JLabel jlb_g01=null;
	JLabel jlb_g02=null;
	JLabel jlb_g03=null;
	JLabel jlb_g04=null;
	JLabel jlb_g05=null;
	JLabel jlb_g06=null;
	JLabel jlb_g07=null;
	JLabel jlb_g08=null;
	JLabel jlb_g09=null;
	JLabel jlb_g10=null;
	//ȷ���˷�button
	JButton jbsurer=null;
	//jm5
	JMenuItem jmi5_1=null;
	//��������
	static int g01_Num,g02_Num,g03_Num,g04_Num,g05_Num,g06_Num,g07_Num,g08_Num,g09_Num,g10_Num;
	JLabel jlb_costlist=null;
	public static void main(String  []s)
	{
		new Window();
	}
	public Window()
	{
		try {
			im1=ImageIO.read(new File("image/Bump_jp1.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jlb_close=new JLabel(new ImageIcon("image/Bump_close.jpg"));
		jlb_close.setBounds(width-30, 0, 30, 30);
		jlb_close.addMouseListener(this);
		//im1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/Bump_xingkong.gif"));
		jtf2_1=new JTextField();
		imb1=new ImgBack(im1);
		jp1=new JPanel();
		jp1.setLayout(null);
		jp2=new JPanel();
		jp2.setLayout(null);
		imb1.setLayout(new GridLayout(7,1));
		jlb1=new JLabel("�˷�����",new ImageIcon("Image/Bump_getm.jpg"),0);
		jlb1.setEnabled(false);
		jlb1.addMouseListener(this);
		jlb2=new JLabel("��½����",new ImageIcon("Image/Bump_lgmg.jpg"),0);
		jlb2.setEnabled(false);
		if(UserLogin.position.equals("����Ա")||UserLogin.position.equals("���³�")||UserLogin.position.equals("�ܾ���"))
		{
		jlb2.setEnabled(true);
		}
		if(UserLogin.position.equals("����Ա")||UserLogin.position.equals("���³�")||UserLogin.position.equals("�ܾ���"))
		{
		jlb2.addMouseListener(this);
		}
		//jlb1.addMouseListener(this);
		jlb3=new JLabel("Ԥ������",new ImageIcon("Image/Bump_book.jpg"),0);
		jlb3.setEnabled(false);
		jlb4=new JLabel("�˶�����",new ImageIcon("Image/Bump_return.jpg"),0);
		jlb4.setEnabled(false);
		jlb3.addMouseListener(this);
		jlb4.addMouseListener(this);
		jlb5=new JLabel("��ס�ͻ�",new ImageIcon("Image/Bump_now.gif"),0);
		jlb5.setEnabled(false);
		jlb5.addMouseListener(this);
		jlb5.addMouseListener(this);
		jlb6=new JLabel("����",new ImageIcon("image/Bump_help.gif"),0);
		jlb6.setEnabled(false);
		jlb6.addMouseListener(this);
		jlb6.addMouseListener(this);
	//	jlb4=new JLabel(new ImageIcon("","Image/Bump_jp1_1.gif"),0);
//		jlb5=new JLabel(new ImageIcon("","Image/Bump_jp1_1.gif"),0);
		imb1.add(jlb1);
		imb1.add(jlb2);
		imb1.add(jlb3);
		imb1.add(jlb4);
		imb1.add(jlb5);
		imb1.add(jlb6);
//		imb1.add(jlb5);
		jp1.add(imb1);
		jp2_1=new JPanel();
		jp2_1.setLayout(null);
		jp2_1.setBounds(400,height-450, width-400, 450);
	    jsp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,jp1,jp2);
		jsp.setDividerLocation(devide);
		jsp.setDividerSize(1);
		jbr=new JMenuBar();
		jtb=new JToolBar();
		jb1=new JButton(new ImageIcon("image/Bump_account.JPG"));
		jb1.setActionCommand("act");
		jb1.addActionListener(this);
		jb2=new JButton(new ImageIcon("image/Bump_getm.jpg"));
		jb3=new JButton(new ImageIcon("image/Bump_book.jpg"));
		jb3.setActionCommand("jmibook");
		jb3.addActionListener(this);
		jb4=new JButton(new ImageIcon("image/Bump_return.jpg"));
		jb4.setActionCommand("jmireturn");
		jb4.addActionListener(this);
		jb5=new JButton(new ImageIcon("image/Bump_cmanage.gif"));
		jb5.setActionCommand("jmimanagc");
		jb5.addActionListener(this);
		jm1=new JMenu("ϵͳ");
		jm3=new JMenu("�õ����");
		jm4=new JMenu("�ͻ�����");
		jm5=new JMenu("����");
		jmi1_1=new JMenuItem("�л��˻�",new ImageIcon("image/Bump_account.JPG"));
		jmi1_2=new JMenuItem("��½����",new ImageIcon("image/Bump_lgmg.jpg"));
		jmi1_3=new JMenuItem("����",new ImageIcon("image/Bump_getm.jpg"));
		jmi1_4=new JMenuItem("������",new ImageIcon("image/Bump_year.jpg"));
		jmi1_5=new JMenuItem("��Ϸ",new ImageIcon("image/Bump_youxi.gif"));
		jmi1_6=new JMenuItem("�˳�",new ImageIcon("image/Bump_exit.jpg"));
		jmi2_1=new JMenuItem("���",new ImageIcon("image/Bump_add.jpg"));
		//jmi2_2=new JMenuItem("ɾ��",new ImageIcon("image/Bump_delete.jpg"));
		jmi2_3=new JMenuItem("�޸�",new ImageIcon("image/Bump_alter.jpg"));
		jmi2_4=new JMenuItem("ȫ��Ա��",new ImageIcon("image/Bump_showall.jpg"));
		jmi3_1=new JMenuItem("Ԥ������",new ImageIcon("image/Bump_book.jpg"));
		jmi3_2=new JMenuItem("�˶�����",new ImageIcon("image/Bump_return.jpg"));
		jmi3_3=new JMenuItem("�Ѷ�����",new ImageIcon("image/Bump_booked.jpg"));
		jmi3_4=new JMenuItem("ȫ������",new ImageIcon("image/Bump_rooms.jpg"));
		jmi3_5=new JMenuItem("��Ʒ��Ϣ",new ImageIcon("image/Bump_goods.jpg"));
		//jm4��jmi
		jmi4_1=new JMenuItem("��ס�ͻ�",new ImageIcon("image/Bump_now.gif"));
		jmi4_2=new JMenuItem("vip�ͻ�",new ImageIcon("image/Bump_vip.gif"));
		jmi4_3=new JMenuItem("��ʷ�ͻ�",new ImageIcon("image/Bump_history.gif"));
		jmi4_4=new JMenuItem("�ͻ�����",new ImageIcon("image/Bump_cmanage.gif"));
		jmi5_1=new JMenuItem("����",new ImageIcon("image/Bump_help.gif"));
		jmi5_1.setActionCommand("help");
		jmi5_1.addActionListener(this);
		jtb.add(jb1);
		jtb.add(jb2);
		jtb.add(jb3);
		jtb.add(jb4);
		jtb.add(jb5);
		jtb.setFloatable(false);
		jmi1_1.setActionCommand("act");
		jmi1_1.addActionListener(this);
		jmi1_2.setActionCommand("lgmg");
		jmi1_2.addActionListener(this);
		jmi1_3.setActionCommand("setacc");
		jmi1_3.addActionListener(this);
		jmi1_5.setActionCommand("game");
		jmi1_5.addActionListener(this);
		jmi1_6.setActionCommand("Systemout");
		jmi1_6.addActionListener(this);
		jmi2_1.setActionCommand("jmiadd");
		jmi2_1.addActionListener(this);
		//jmi2_2.setActionCommand("jmidelete");
		//jmi2_2.addActionListener(this);
		jmi2_3.setActionCommand("jmialter");
		jmi2_3.addActionListener(this);
		jmi2_4.setActionCommand("jmishowall");
		jmi2_4.addActionListener(this);
		jmi3_1.setActionCommand("jmibook");
		jmi3_1.addActionListener(this);
		jmi3_2.setActionCommand("jmireturn");
		jmi3_2.addActionListener(this);
		jmi3_3.setActionCommand("jmibooked");
		jmi3_3.addActionListener(this);
		jmi3_4.setActionCommand("jmiallroom");
		jmi3_4.addActionListener(this);
		jmi3_5.setActionCommand("jmigoods");
		//jmi4����
		jmi4_1.setActionCommand("jminowc");
		jmi4_1.addActionListener(this);
		jmi4_2.setActionCommand("jmivipc");
		jmi4_2.addActionListener(this);
		jmi4_3.setActionCommand("jmihisc");
		jmi4_3.addActionListener(this);
		jmi4_4.setActionCommand("jmimanagc");
		jmi4_4.addActionListener(this);
		jm1.add(jmi1_1);
		if(UserLogin.position.equals("����Ա")||UserLogin.position.equals("���³�")||UserLogin.position.equals("�ܾ���"))
		{
		jm1.add(jmi1_2);
		}
		jm1.add(jmi1_3);
		jm1.add(jmi1_4);
		jm1.add(jmi1_5);
		jm1.add(jmi1_6);
		jbr.add(jm1);
		jm2=new JMenu("���¹���");
		if(UserLogin.position.equals("����Ա")||UserLogin.position.equals("���³�")||UserLogin.position.equals("�ܾ���"))
		{
		jbr.add(jm2);
		jm2.add(jmi2_1);
		//jm2.add(jmi2_2);
		jm2.add(jmi2_3);
		jm2.add(jmi2_4);

		}
		jm3.add(jmi3_1);
		jm3.add(jmi3_2);
		jm3.add(jmi3_3);
		jm3.add(jmi3_4);
		jm3.add(jmi3_5);
		jm4.add(jmi4_1);
		jm4.add(jmi4_2);
		jm4.add(jmi4_3);
		jm4.add(jmi4_4);
		jm5.add(jmi5_1);
		jbr.add(jm3);
		jbr.add(jm4);
		jbr.add(jm5);
		this.add(jsp);
		this.add(jtb,"North");
		this.setJMenuBar(jbr);
		this.setUndecorated(true);
		this.setLocation(-5, 0);
		this.setSize(width,height+5);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("help"))
		{
			System.out.println("OK");
			if(jp2!=null)
			{
			jp2.removeAll();
			}
			jp2.setBackground(Color.cyan);
			jp1.setSize(200, height);
			imb1.setSize(200,height);
			this.devide=200;
			jsp.setDividerLocation(devide);
			JLabel jlbhelp=new JLabel("��л�ٶȣ�������Ȩ���壬�Ͻ�������ҵ��;");
			JLabel jlbhel=new JLabel("������");
			jlbhelp.setFont(font1);
			jlbhelp.setBounds(200, 300, 1000, 30);
			jlbhel.setFont(font2);
			jlbhel.setBounds(500, 500, 1000, 60);
			jp2.add(jlbhelp);
			jp2.add(jlbhel);
			this.repaint();
		}
		if(e.getActionCommand().equals("surerr"))
		{
			JOptionPane.showMessageDialog(null, "��ӭ�ٴι���","�˷��ɹ�",JOptionPane.ERROR_MESSAGE);
			Sqloperationcust.sql="select * from customer where cid='"+setacct+"'";
			Sqloperationcust sqlopcus=new Sqloperationcust();
			jtable=new JTable(sqlopcus.row,sqlopcus.columnname);
			roomid=jtable.getValueAt(0, 3).toString().trim();
			try {
				Class.forName(Sqloperationhiscus.driver);
				ct=DriverManager.getConnection(Sqloperationhiscus.url,Sqloperationhiscus.name,Sqloperationhiscus.passwd);
				ps=ct.prepareStatement("insert into hiscustomer values(?,?,?,?,?)");
				ps.setString(1, jtable.getValueAt(0, 0).toString().trim());
				ps.setString(2, jtable.getValueAt(0, 1).toString().trim());
				ps.setString(3, jtable.getValueAt(0, 2).toString().trim());
				//ps.setString(4, jtable.getValueAt(0, 4).toString().trim());
				ps.setString(5, jtable.getValueAt(0, 6).toString().trim());
				ps.execute();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}finally{
				try {
					ps.close();
					ct.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			try {
				Sqloperationcust.sql="delete from customer where cid='"+setacct+"'";
				Class.forName(Sqloperationcust.driver);
				ct=DriverManager.getConnection(Sqloperationcust.url,Sqloperationcust.name,Sqloperationcust.passwd);
				ps=ct.prepareStatement(Sqloperationcust.sql);
				ps.execute();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally
			{
				try {
					ps.close();
					ct.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			try {
				Class.forName(Sqloperationroom.driver);
				ct=DriverManager.getConnection(Sqloperationroom.url,Sqloperationroom.name,Sqloperationroom.passwd);
				ps=ct.prepareStatement("update roomtable set room_isbook='��' where room_id="+roomid+"'");
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		if(e.getActionCommand().equals("jiezhang"))
		{
			this.jiezhang();
		}
		if(e.getActionCommand().equals("setacc"))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			jbdelete=new JButton("����");
			jbdelete.setBackground(Color.cyan);
			jbdelete.setBounds(width-500, 0, 300, height);
			jbdelete.setActionCommand("jiezhang");
			jbdelete.addActionListener(this);
			jp2.setLayout(null);
			jp1.setSize(200, height);
			imb1.setSize(200,height);
			this.devide=200;
			jsp.setDividerLocation(devide);
			Sqloperationcust.sql="select * from customer";
			Sqloperationcust sqlopc=new Sqloperationcust();
			jtable=new JTable(sqlopc.row,sqlopc.columnname);
			jscp=new JScrollPane(jtable);
			jscp.setBounds(0, 0, width-500, height);
			jp2.add(jbdelete);
			jp2.add(jscp);
			jp2.repaint();
		}
		if(e.getActionCommand().equals("cdelete"))
		{
			int rowNum=0;
			rowNum=jtable.getSelectedRow();
			if(rowNum<1)
			{
				JOptionPane.showMessageDialog(null, "����˧","������Ц",JOptionPane.ERROR_MESSAGE);
			}else{
			String s=jtable.getValueAt(rowNum, 0).toString().trim();
			try {
			Class.forName(Sqloperationhiscus.driver);
			ct=DriverManager.getConnection(Sqloperationhiscus.url,Sqloperationhiscus.name,Sqloperationhiscus.passwd);
			ps=ct.prepareStatement("delete from hiscustomer where cid='"+s+"'");
			ps.execute();
			System.out.println("delete from hiscustomer where cid='"+s+"'");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}finally{
				try {
					if(ps!=null)
					ps.close();
					if(ct!=null)
					ct.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			jp2.repaint();
		}
		}
		if(e.getActionCommand().equals("jmimanagc"))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			jbdelete=new JButton("ɾ��");
			jbdelete.setBackground(Color.cyan);
			jbdelete.setBounds(width-500, 0, 300, height);
			jbdelete.setActionCommand("cdelete");
			jbdelete.addActionListener(this);
			jp2.setLayout(null);
			jp1.setSize(200, height);
			imb1.setSize(200,height);
			this.devide=200;
			jsp.setDividerLocation(devide);
			Sqloperationhiscus.sql="select * from hiscustomer";
			Sqloperationhiscus sqlopc=new Sqloperationhiscus();
			jtable=new JTable(sqlopc.row,sqlopc.columnname);
			jscp=new JScrollPane(jtable);
			jscp.setBounds(0, 0, width-500, height);
			jp2.add(jbdelete);
			jp2.add(jscp);
			jp2.repaint();
		}
		if(e.getActionCommand().equals("jmihisc"))
		{

			if(jp2!=null)
			{
				jp2.removeAll();
			}
			jp2.setLayout(null);
			jp1.setSize(200, height);
			imb1.setSize(200,height);
			this.devide=200;
			jsp.setDividerLocation(devide);
			Sqloperationhiscus.sql="select * from hiscustomer";
			Sqloperationhiscus sqlopc=new Sqloperationhiscus();
			jtable=new JTable(sqlopc.row,sqlopc.columnname);
			jscp=new JScrollPane(jtable);
			jscp.setBounds(0, 0, width-200, height);
			jp2.add(jscp);
			jp2.repaint();
		}
		if(e.getActionCommand().equals("jmivipc"))
		{

			if(jp2!=null)
			{
				jp2.removeAll();
			}
			jp2.setLayout(null);
			jp1.setSize(200, height);
			imb1.setSize(200,height);
			this.devide=200;
			jsp.setDividerLocation(devide);
			Sqloperationhiscus.sql="select * from hiscustomer where cisvip='"+"vip"+"'";
			Sqloperationhiscus sqlopc=new Sqloperationhiscus();
			jtable=new JTable(sqlopc.row,sqlopc.columnname);
			jscp=new JScrollPane(jtable);
			jscp.setBounds(0, 0, width-200, height);
			jp2.add(jscp);
			jp2.repaint();
		}
		if(e.getActionCommand().equals("jminowc"))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			jp2.setLayout(null);
			jp1.setSize(200, height);
			imb1.setSize(200,height);
			this.devide=200;
			jsp.setDividerLocation(devide);
			Sqloperationcust.sql="select * from customer";
			Sqloperationcust sqlopc=new Sqloperationcust();
			jtable=new JTable(sqlopc.row,sqlopc.columnname);
			jscp=new JScrollPane(jtable);
			jscp.setBounds(0, 0, width-200, height);
			jp2.add(jscp);
			jp2.repaint();
			
		}
		if(e.getActionCommand().equals("jmibooked"))
		{
			if(jp2!=null)
		{
			jp2.removeAll();
		}
			this.booked();
		}
		if(e.getActionCommand().equals("surereturn"))
		{
			//System.out.println("OK");
			try {
				Class.forName(Sqloperation.driver);
				ct=DriverManager.getConnection(Sqloperation.url,Sqloperation.name,Sqloperation.passwd);
				ps=ct.prepareStatement("delete from customer where crid ='"+roomid+"'");
				ps.execute();
				ps=ct.prepareStatement("update roomtable set room_isbook ='��' where room_id='"+roomid+"'");
				ps.execute();
				JOptionPane.showMessageDialog(null, "�ɹ��˶�","��ܰ��ʾ",JOptionPane.ERROR_MESSAGE);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally
			{
				try {
					if(ps!=null)
					ps.close();
					if(ct!=null)
					ct.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		if(e.getActionCommand().equals("jmireturn"))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			this.returnbook();
		}
		if(e.getActionCommand().equals("jmiallroom"))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			this.showallroom();
		}
		if(e.getActionCommand().equals("surebook"))
		{
			this.surebook();
		}
		if(e.getActionCommand().equals("book"))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			this.book();
		}
		if(e.getActionCommand().equals("jbreturn"))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
				this.bookroom();
			}
		}
		if(e.getActionCommand().equals("jmibook"))
		{
			this.bookroom();
			//this.templabel=jlb_room1;
			//System.out.println(jlb_room1.getText());
		}
		if(e.getActionCommand().equals("jmidelete"))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			this.loginmanage();
			this.delete();
		}
		if(e.getActionCommand().equals("jmishowall"))
		{
			jp2.setLayout(null);
			//this.loginmanage();
			this.showall();
		}
		if(e.getActionCommand().equals("jmialter"))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			jp2.setLayout(null);
			this.loginmanage();
			//jp2.add(jp2_1);
			this.alter();
			//this.repaint();
		}
		if(e.getActionCommand().equals("jmiadd"))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			jp2.setLayout(null);
			this.loginmanage();
			//jp2.setLayout(null);
			//jp2.add(jp2_1);
			//this.loginmanage();
			this.add();
			this.repaint();
		}
		if(e.getActionCommand().equals("delete"))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			this.loginmanage();
			this.delete();
		}
		if(e.getActionCommand().equals("altersure"))
		{
			this.altersure();
		}
		if(e.getActionCommand().equals("alter"))
		{
			if(jp2_1!=null)
			jp2_1.removeAll();
			//this.loginmanage();
			this.alter();
		}
		if(e.getActionCommand().equals("showall"))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			//this.loginmanage();
			//jp2.add(jp2_1);
			this.showall();
		}
		if(e.getActionCommand().equals("sureadd"))
		{
			this.sureadd();
		}
		if(e.getActionCommand().equals("add"))
		{	
			if(jp2_1!=null)
		{
			jp2_1.removeAll();
		}
			jp2.setLayout(null);
			this.add();
		}
		if(e.getActionCommand().equals("src"))
		{
			if(jp2_1!=null)
				jp2_1.removeAll();
			this.search();
			jp2_1.repaint();
		}
		if(e.getActionCommand().equals("act"))
		{
			LoginPanel.islogin=false;
			this.dispose();
			new UserLogin();
		}
		if(e.getActionCommand().equals("game"))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			jp1.setSize(200,height);
			imb1.setSize(200,height);
			jsp.setDividerLocation(200);
			Maple mp=new Maple();
			this.repaint();
			
		}
		if(e.getActionCommand().equals("lgmg"))
		{
			if(jp2!=null)
			jp2.removeAll();
			jp2.setLayout(null);
			this.loginmanage();
			jp2.repaint();
			
		}
		if(e.getActionCommand().equals("Systemout"))
		{
			System.exit(0);
		}
		
	}
	private void jiezhang() {
		// TODO Auto-generated method stub
		if(jp2!=null)
		{
			jp2.removeAll();
		}
		rownum=jtable.getSelectedRow();
		if(rownum<0)
		{
			JOptionPane.showMessageDialog(null, "�޸��Һ���","������Ц",JOptionPane.ERROR_MESSAGE);
		}else
		setacct=jtable.getValueAt(rownum, 0).toString().trim();
		jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
				"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
				"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
		jlb_costlist.setBackground(Color.cyan);
		jlb_costlist.setBounds(0, 520, 550, 100);
		jlb_g01=new JLabel("ѩ��*1",new ImageIcon("image/Bump_gxuebi.gif"),0);
		jlb_g01.setBounds(700, 140, 150, 100);
		jlb_g02=new JLabel("����*1",new ImageIcon("image/Bump_gyibao.gif"),0);
		jlb_g02.setBounds(700, 240, 150, 120);
		jlb_g03=new JLabel("����*1",new ImageIcon("image/Bump_glatiao.gif"),0);
		jlb_g03.setBounds(700, 360, 160, 100);
		jlb_g04=new JLabel("����*1",new ImageIcon("image/Bump_gpaomian.gif"),0);
		jlb_g04.setBounds(680, 460, 180, 100);
		jlb_g05=new JLabel("�ݽŷ�צ*1",new ImageIcon("image/Bump_gpiaojiao.gif"),0);
		jlb_g05.setBounds(680, 560, 200, 100);
		jlb_g06=new JLabel("���*1",new ImageIcon("image/Bump_gmianbao.gif"),0);
		jlb_g06.setBounds(920, 140, 180, 100);
		jlb_g07=new JLabel("Durex*1",new ImageIcon("image/Bump_gbyt.gif"),0);
		jlb_g07.setBounds(920, 240, 180, 100);
		jlb_g08=new JLabel("ơ��*1",new ImageIcon("image/Bump_gbeer.gif"),0);
		jlb_g08.setBounds(920, 340, 180, 120);
		jlb_g09=new JLabel("���Ǹɺ�*1",new ImageIcon("image/Bump_gredwine.gif"),0);
		jlb_g09.setBounds(920, 460, 180, 125);
		jlb_g10=new JLabel("ֽ��*1",new ImageIcon("image/Bump_gzhijing.gif"),0);
		jlb_g10.setBounds(920, 585, 180, 100);
		jlb_g01.addMouseListener(this);
		jlb_g02.addMouseListener(this);
		jlb_g03.addMouseListener(this);
		jlb_g04.addMouseListener(this);
		jlb_g05.addMouseListener(this);
		jlb_g06.addMouseListener(this);
		jlb_g07.addMouseListener(this);
		jlb_g08.addMouseListener(this);
		jlb_g09.addMouseListener(this);
		jlb_g10.addMouseListener(this);
		JLabel jlbelname=new JLabel("���˾Ƶ�");
		jlbelname.setBackground(Color.BLACK);
		jlbelname.setFont(font2);
		jlbelname.setBounds(450, 0, 400, 100);
		jp2.setBackground(Color.cyan);
		jp2.setLayout(null);
		jp1.setSize(200, height);
		imb1.setSize(200,height);
		this.devide=200;
		jsp.setDividerLocation(devide);
		jlb_cid=new JLabel("֤����:");
		jlb_cid.setFont(font1);
		jlb_cid.setBounds(0, 100, 100, 50);
		jlb_cname=new JLabel("����:");
		jlb_cname.setFont(font1);
		jlb_cname.setBounds(0, 200, 100, 50);
		jlb_crid=new JLabel("�����:");
		jlb_crid.setFont(font1);
		jlb_crid.setBounds(0, 300, 100, 50);
		jlb_cperson=new JLabel("����:");
		jlb_cperson.setFont(font1);
		jlb_cperson.setBounds(0, 400, 100, 50);
		jlb_ccost=new JLabel("������:");
		jlb_ccost.setFont(font1);
		jlb_ccost.setBounds(0, 500, 100, 50);
		if(setacct==null)
		{
			JOptionPane.showMessageDialog(null, "��ѡ������û�","֪����",JOptionPane.ERROR_MESSAGE);
		}else
		{
		Sqloperationcust.sql="select * from customer where cid='"+setacct+"'";
		Sqloperationcust sqlopc=new Sqloperationcust();
		jtable=new JTable(sqlopc.row,sqlopc.columnname);
		jlb_getcid=new JLabel(jtable.getValueAt(0, 0).toString().trim());
		jlb_getcid.setFont(font1);
		jlb_getcid.setBounds(100, 100, 200, 50);
		jlb_getcname=new JLabel(jtable.getValueAt(0, 1).toString().trim());
		jlb_getcname.setFont(font1);
		jlb_getcname.setBounds(100,200, 200, 50);
		jlb_getcrid=new JLabel(jtable.getValueAt(0, 3).toString().trim());
		jlb_getcrid.setFont(font1);
		jlb_getcrid.setBounds(100, 300, 200, 50);
		jlb_getcperson=new JLabel(jtable.getValueAt(0, 4).toString().trim());
		jlb_getcperson.setFont(font1);
		jlb_getcperson.setBounds(100, 400, 300, 50);
		jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
		jlb_getccost.setFont(font1);
		jlb_getccost.setBounds(100, 500, 200, 50);
		if(jtable.getValueAt(0, 6).toString().trim().equals("vip"))
		{
			jlb_cvip=new JLabel(new ImageIcon("image/Bump_vip.gif"));
			jlb_cvip.setBounds(250, 20, 230, 200);
			jp2.add(jlb_cvip);
		}
		jbsurer=new JButton("ȷ���˷�");
		jbsurer.setActionCommand("surerr");
		jbsurer.addActionListener(this);
		jbsurer.setBackground(Color.CYAN);
		jbsurer.setBounds(300, 600, 200, 50);
		jp2.add(jlb_costlist);
		jp2.add(jbsurer);
		jp2.add(jlb_g01);
		jp2.add(jlb_g02);
		jp2.add(jlb_g03);
		jp2.add(jlb_g04);
		jp2.add(jlb_g05);
		jp2.add(jlb_g06);
		jp2.add(jlb_g07);
		jp2.add(jlb_g08);
		jp2.add(jlb_g09);
		jp2.add(jlb_g10);
		jp2.add(jlb_cid);
		jp2.add(jlb_cname);
		jp2.add(jlb_crid);
		jp2.add(jlb_cperson);
		jp2.add(jlb_ccost);
		jp2.add(jlb_getcid);
		jp2.add(jlb_getccost);
		jp2.add(jlb_getcname);
		jp2.add(jlb_getcperson);
		jp2.add(jlb_getcrid);
		jp2.add(jlbelname);
		}
		
	}
	private void booked() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				// TODO Auto-generated method stub
						Sqloperationroom.sql="select * from roomtable";
						Sqloperationroom sqlop=new Sqloperationroom();
				        JTable jtisbook=new JTable(sqlop.row,sqlop.columnname);
						this.devide=200;
						imb1.setSize(devide,height);
						jp1.setSize(devide,height);
						jsp.setDividerLocation(devide);
						jp2.setLayout(new GridLayout(3,3));
						jp2.setBackground(Color.cyan);
						if(jtisbook.getValueAt(0, 2).toString().trim().equals("��"))
						{
						jlb_room1=new JLabel("001",new ImageIcon("image/Bump_r1booked.gif"),0);
						//jlb_room1.addMouseListener(this);
						}else{
						jlb_room1=new JLabel("001",new ImageIcon("image/Bump_single.gif"),0);
						jlb_room1.setEnabled(false);
						}
						if(jtisbook.getValueAt(1, 2).toString().trim().equals("��"))
						{
						jlb_room2=new JLabel("002",new ImageIcon("image/Bump_r1booked.gif"),0);
						//jlb_room2.addMouseListener(this);
						}else{
							jlb_room2=new JLabel("002",new ImageIcon("image/Bump_single.gif"),0);
							jlb_room2.setEnabled(false);
						}
						if(jtisbook.getValueAt(2, 2).toString().trim().equals("��"))
						{
						jlb_room3=new JLabel("003",new ImageIcon("image/Bump_r1booked.gif"),0);
						//jlb_room3.addMouseListener(this);
						}else{
						jlb_room3=new JLabel("003",new ImageIcon("image/Bump_single.gif"),0);
						jlb_room3.setEnabled(false);
						}
						if(jtisbook.getValueAt(3, 2).toString().trim().equals("��"))
						{
						jlb_room4=new JLabel("004",new ImageIcon("image/Bump_r2booked.gif"),0);
						// jlb_room4.addMouseListener(this);
						}else
						{
					    jlb_room4=new JLabel("004",new ImageIcon("image/Bump_double.gif"),0);
					    jlb_room4.setEnabled(false);
						}
						if(jtisbook.getValueAt(4, 2).toString().trim().equals("��"))
						{
						jlb_room5=new JLabel("005",new ImageIcon("image/Bump_r2booked.gif"),0);
						//jlb_room5.addMouseListener(this);
						}else
						{
						jlb_room5=new JLabel("005",new ImageIcon("image/Bump_double.gif"),0);
						jlb_room5.setEnabled(false);
						}
						if(jtisbook.getValueAt(5, 2).toString().trim().equals("��"))
						{
						jlb_room6=new JLabel("006",new ImageIcon("image/Bump_r2booked.gif"),0);
						//jlb_room6.addMouseListener(this);
						}else
						{
						jlb_room6=new JLabel("006",new ImageIcon("image/Bump_double.gif"),0);
						jlb_room6.setEnabled(false);
						}
						if(jtisbook.getValueAt(6, 2).toString().trim().equals("��"))
						{
						jlb_room7=new JLabel("007",new ImageIcon("image/Bump_r3booked.gif"),0);
						//jlb_room7.addMouseListener(this);
						}else
						{
						jlb_room7=new JLabel("007",new ImageIcon("image/Bump_family.gif"),0);
						jlb_room7.setEnabled(false);
						}
						if(jtisbook.getValueAt(7, 2).toString().trim().equals("��"))
						{
						jlb_room8=new JLabel("008",new ImageIcon("image/Bump_r3booked.gif"),0);
						//jlb_room8.addMouseListener(this);
						}else
						{
						jlb_room8=new JLabel("008",new ImageIcon("image/Bump_family.gif"),0);
						jlb_room8.setEnabled(false);
						}
						if(jtisbook.getValueAt(8, 2).toString().trim().equals("��"))
						{
						jlb_room9=new JLabel("009",new ImageIcon("image/Bump_r3booked.gif"),0);
						//jlb_room9.addMouseListener(this);
						}else
						{
						jlb_room9=new JLabel("009",new ImageIcon("image/Bump_family.gif"),0);
						jlb_room9.setEnabled(false);
						}
						jp2.add(jlb_room1);
						jp2.add(jlb_room2);
						jp2.add(jlb_room3);
						jp2.add(jlb_room4);
						jp2.add(jlb_room5);
						jp2.add(jlb_room6);
						jp2.add(jlb_room7);
						jp2.add(jlb_room8);
						jp2.add(jlb_room9);
		
	}
	private void returnbook() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Sqloperationroom.sql="select * from roomtable";
				Sqloperationroom sqlop=new Sqloperationroom();
		        JTable jtisbook=new JTable(sqlop.row,sqlop.columnname);
				this.devide=200;
				imb1.setSize(devide,height);
				jp1.setSize(devide,height);
				jsp.setDividerLocation(devide);
				jp2.setLayout(new GridLayout(3,3));
				jp2.setBackground(Color.cyan);
				if(jtisbook.getValueAt(0, 2).toString().trim().equals("��"))
				{
				jlb_room1=new JLabel("001",new ImageIcon("image/Bump_r1booked.gif"),0);
				jlb_room1.addMouseListener(this);
				}else{
				jlb_room1=new JLabel("001",new ImageIcon("image/Bump_single.gif"),0);
				jlb_room1.setEnabled(false);
				}
				if(jtisbook.getValueAt(1, 2).toString().trim().equals("��"))
				{
				jlb_room2=new JLabel("002",new ImageIcon("image/Bump_r1booked.gif"),0);
				jlb_room2.addMouseListener(this);
				}else{
					jlb_room2=new JLabel("002",new ImageIcon("image/Bump_single.gif"),0);
					jlb_room2.setEnabled(false);
				}
				if(jtisbook.getValueAt(2, 2).toString().trim().equals("��"))
				{
				jlb_room3=new JLabel("003",new ImageIcon("image/Bump_r1booked.gif"),0);
				jlb_room3.addMouseListener(this);
				}else{
				jlb_room3=new JLabel("003",new ImageIcon("image/Bump_single.gif"),0);
				jlb_room3.setEnabled(false);
				}
				if(jtisbook.getValueAt(3, 2).toString().trim().equals("��"))
				{
				jlb_room4=new JLabel("004",new ImageIcon("image/Bump_r2booked.gif"),0);
				 jlb_room4.addMouseListener(this);
				}else
				{
			    jlb_room4=new JLabel("004",new ImageIcon("image/Bump_double.gif"),0);
			    jlb_room4.setEnabled(false);
				}
				if(jtisbook.getValueAt(4, 2).toString().trim().equals("��"))
				{
				jlb_room5=new JLabel("005",new ImageIcon("image/Bump_r2booked.gif"),0);
				jlb_room5.addMouseListener(this);
				}else
				{
				jlb_room5=new JLabel("005",new ImageIcon("image/Bump_double.gif"),0);
				jlb_room5.setEnabled(false);
				}
				if(jtisbook.getValueAt(5, 2).toString().trim().equals("��"))
				{
				jlb_room6=new JLabel("006",new ImageIcon("image/Bump_r2booked.gif"),0);
				jlb_room6.addMouseListener(this);
				}else
				{
				jlb_room6=new JLabel("006",new ImageIcon("image/Bump_double.gif"),0);
				jlb_room6.setEnabled(false);
				}
				if(jtisbook.getValueAt(6, 2).toString().trim().equals("��"))
				{
				jlb_room7=new JLabel("007",new ImageIcon("image/Bump_r3booked.gif"),0);
				jlb_room7.addMouseListener(this);
				}else
				{
				jlb_room7=new JLabel("007",new ImageIcon("image/Bump_family.gif"),0);
				jlb_room7.setEnabled(false);
				}
				if(jtisbook.getValueAt(7, 2).toString().trim().equals("��"))
				{
				jlb_room8=new JLabel("008",new ImageIcon("image/Bump_r3booked.gif"),0);
				jlb_room8.addMouseListener(this);
				}else
				{
				jlb_room8=new JLabel("008",new ImageIcon("image/Bump_family.gif"),0);
				jlb_room8.setEnabled(false);
				}
				if(jtisbook.getValueAt(8, 2).toString().trim().equals("��"))
				{
				jlb_room9=new JLabel("009",new ImageIcon("image/Bump_r3booked.gif"),0);
				jlb_room9.addMouseListener(this);
				}else
				{
				jlb_room9=new JLabel("009",new ImageIcon("image/Bump_family.gif"),0);
				jlb_room9.setEnabled(false);
				}
				jp2.add(jlb_room1);
				jp2.add(jlb_room2);
				jp2.add(jlb_room3);
				jp2.add(jlb_room4);
				jp2.add(jlb_room5);
				jp2.add(jlb_room6);
				jp2.add(jlb_room7);
				jp2.add(jlb_room8);
				jp2.add(jlb_room9);
	}
	private void surebook() {
		// TODO Auto-generated method stub
		try {
			Class.forName(Sqloperationcust.driver);
			ct=DriverManager.getConnection(Sqloperationcust.url,Sqloperationcust.name,Sqloperationcust.passwd);
			ps=ct.prepareStatement("insert into customer values(?,?,?,?,?,?,?)");
			ps.setString(1, jlbc_getid.getText().trim());
			ps.setString(2, jlbc_getname.getText().trim());
			ps.setString(3, jlbc_gettime.getText().trim());
			ps.setString(4, jlbc_getrid.getText().trim());
			//System.out.println(Integer.parseInt(jlbc_person.getText()));
			if(jlbc_getperson.getText().trim().length()<1)
			{
			JOptionPane.showMessageDialog(null, "��������ס����","��ʾ",JOptionPane.ERROR_MESSAGE);
			}else{
			ps.setInt(5, Integer.parseInt(jlbc_getperson.getText().trim()));
			}
			if(jlbc_getcost.getText().length()<1)
			{
			JOptionPane.showMessageDialog(null, "�����뷿��۸�","��ʾ",JOptionPane.ERROR_MESSAGE);
			}else{
			ps.setFloat(6, Float.parseFloat(jlbc_getcost.getText().trim()));
			}
			ps.setString(7, "vip");
			if(jlbc_getid.getText().length()!=18)
			{
				System.out.println(jlbc_getid.getText()+"not null");
				JOptionPane.showMessageDialog(null, "������ͻ�18λID","��ʾ",JOptionPane.ERROR_MESSAGE);
			}else if(jlbc_getname.getText().length()<1)
			{
				JOptionPane.showMessageDialog(null, "������ͻ�����","��ʾ",JOptionPane.ERROR_MESSAGE);
			}
			else if(jlbc_getrid.getText().length()<1)
			{
				JOptionPane.showMessageDialog(null, "������ͻ���ס����","��ʾ",JOptionPane.ERROR_MESSAGE);
			}
			else{
			ps.execute();
			JOptionPane.showMessageDialog(null, "�ɹ���ס����ӭ����","��ʾ",JOptionPane.ERROR_MESSAGE);
			ps=ct.prepareStatement("update roomtable set room_isbook = '��'  where room_id='"+roomid+"'");
			ps.execute();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally
		{
			try {
				if(ps!=null)
				{
					ps.close();
				}
				if(ct!=null)
				{
					ct.close();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
			
		}
		
	}
	private void bookroom() {
		// TODO Auto-generated method stub}
		Sqloperationroom.sql="select * from roomtable";
		Sqloperationroom sqlop=new Sqloperationroom();
        JTable jtisbook=new JTable(sqlop.row,sqlop.columnname);
		if(jp2!=null)
		{
			jp2.removeAll();
		}
		this.devide=200;
		imb1.setSize(devide,height);
		jp1.setSize(devide,height);
		jsp.setDividerLocation(devide);
		jp2.setLayout(new GridLayout(3,3));
		jp2.setBackground(Color.cyan);
		if(jtisbook.getValueAt(0, 2).toString().trim().equals("��"))
		{
		jlb_room1=new JLabel("001",new ImageIcon("image/Bump_r1booked.gif"),0);
		jlb_room1.setEnabled(false);
		}else{
		jlb_room1=new JLabel("001",new ImageIcon("image/Bump_single.gif"),0);
		jlb_room1.addMouseListener(this);
		}
		if(jtisbook.getValueAt(1, 2).toString().trim().equals("��"))
		{
		jlb_room2=new JLabel("002",new ImageIcon("image/Bump_r1booked.gif"),0);
		jlb_room2.setEnabled(false);
		}else{
			jlb_room2=new JLabel("002",new ImageIcon("image/Bump_single.gif"),0);
			jlb_room2.addMouseListener(this);
		}
		if(jtisbook.getValueAt(2, 2).toString().trim().equals("��"))
		{
		jlb_room3=new JLabel("003",new ImageIcon("image/Bump_r1booked.gif"),0);
		jlb_room3.setEnabled(false);
		}else{
		jlb_room3=new JLabel("003",new ImageIcon("image/Bump_single.gif"),0);
		jlb_room3.addMouseListener(this);
		}
		if(jtisbook.getValueAt(3, 2).toString().trim().equals("��"))
		{
		jlb_room4=new JLabel("004",new ImageIcon("image/Bump_r2booked.gif"),0);
		jlb_room4.setEnabled(false);
		}else
		{
	    jlb_room4=new JLabel("004",new ImageIcon("image/Bump_double.gif"),0);
	    jlb_room4.addMouseListener(this);
		}
		if(jtisbook.getValueAt(4, 2).toString().trim().equals("��"))
		{
		jlb_room5=new JLabel("005",new ImageIcon("image/Bump_r2booked.gif"),0);
		jlb_room5.setEnabled(false);
		}else
		{
		jlb_room5=new JLabel("005",new ImageIcon("image/Bump_double.gif"),0);
		jlb_room5.addMouseListener(this);
		}
		if(jtisbook.getValueAt(5, 2).toString().trim().equals("��"))
		{
		jlb_room6=new JLabel("006",new ImageIcon("image/Bump_r2booked.gif"),0);
		jlb_room6.setEnabled(false);
		}else
		{
		jlb_room6=new JLabel("006",new ImageIcon("image/Bump_double.gif"),0);
		jlb_room6.addMouseListener(this);
		}
		if(jtisbook.getValueAt(6, 2).toString().trim().equals("��"))
		{
		jlb_room7=new JLabel("007",new ImageIcon("image/Bump_r3booked.gif"),0);
		jlb_room7.setEnabled(false);
		}else
		{
		jlb_room7=new JLabel("007",new ImageIcon("image/Bump_family.gif"),0);
		jlb_room7.addMouseListener(this);
		}
		if(jtisbook.getValueAt(7, 2).toString().trim().equals("��"))
		{
		jlb_room8=new JLabel("008",new ImageIcon("image/Bump_r3booked.gif"),0);
		jlb_room8.setEnabled(false);
		}else
		{
		jlb_room8=new JLabel("008",new ImageIcon("image/Bump_family.gif"),0);
		jlb_room8.addMouseListener(this);
		}
		if(jtisbook.getValueAt(8, 2).toString().trim().equals("��"))
		{
		jlb_room9=new JLabel("009",new ImageIcon("image/Bump_r3booked.gif"),0);
		jlb_room9.setEnabled(false);
		}else
		{
		jlb_room9=new JLabel("009",new ImageIcon("image/Bump_family.gif"),0);
		jlb_room9.addMouseListener(this);
		}
		jp2.add(jlb_room1);
		jp2.add(jlb_room2);
		jp2.add(jlb_room3);
		jp2.add(jlb_room4);
		jp2.add(jlb_room5);
		jp2.add(jlb_room6);
		jp2.add(jlb_room7);
		jp2.add(jlb_room8);
		jp2.add(jlb_room9);
	}
	private void book() {
		// TODO Auto-generated method stub
		if(jp2!=null)
		{
			jp2.removeAll();
		}
		im1=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_jp1.jpg"));
		imb1=new ImgBack(im1);
		jlbc_check=new JLabel("�Ǽ�");
		jlbc_check.setBounds(width/2-100, 0, 200, 50);
		jlbc_check.setFont(font2);
		jlbc_check.setBackground(Color.white);
		jb_surebook=new JButton("ȷ��");
		jb_surebook.setBackground(Color.cyan);
		jb_surebook.setBounds(width-500, height-200, 100, 30);
		jb_surebook.setActionCommand("surebook");
		jb_surebook.addActionListener(this);
		jlbc_getid=new JTextField();
		jlbc_getid.setBounds(550, 200, 300, 30);
		jlbc_getname=new JTextField();
		jlbc_getname.setBounds(550, 250, 300, 30);
		jlbc_getperson=new JTextField();
		jlbc_getperson.setBounds(550, 300, 300,30);
		jlbc_getcost=new JTextField(price+"");
		jlbc_getcost.setBounds(550, 400, 300, 30);
		jlbc_gettime=new JTextField(Calendar.getInstance().getTime().toLocaleString());
		jlbc_gettime.setBounds(550, 450, 300, 30);//550, 300, 300,30
		jlbc_getrid=new JLabel(roomid);
		jlbc_getrid.setBounds(550, 500, 300, 30);
		jlbc_id=new JLabel("�˿����֤��:");
		jlbc_id.setBounds(350, 200, 200, 30);
		jlbc_id.setFont(font1);
		jlbc_name=new JLabel("�˿�����:");
		jlbc_name.setBounds(350, 250, 200, 30);
		jlbc_name.setFont(font1);
		jlbc_time=new JLabel("��סʱ��:");
		jlbc_time.setBounds(350, 450, 200, 30);
		jlbc_time.setFont(font1);
		jlbc_cost=new JLabel("����۸�:");
		jlbc_cost.setBounds(350, 400, 200, 30);
		jlbc_cost.setFont(font1);
		jlbc_person=new JLabel("��ס����:");
		jlbc_person.setBounds(350, 300, 200, 30);
		jlbc_person.setFont(font1);
		jlbc_rid=new JLabel("��ס����:");
		jlbc_rid.setBounds(350, 500, 200, 30);
		jlbc_rid.setFont(font1);
		imb1.add(jb_surebook);
		imb1.add(jlbc_check);
		imb1.add(jlbc_getid);
		imb1.add(jlbc_getname);
		imb1.add(jlbc_getperson);
		imb1.add(jlbc_gettime);
		imb1.add(jlbc_getcost);
		imb1.add(jlbc_getrid);
		imb1.add(jlbc_id);
		imb1.add(jlbc_name);
		imb1.add(jlbc_person);
		imb1.add(jlbc_time);
		imb1.add(jlbc_cost);
		imb1.add(jlbc_rid);
		jp2.add(imb1);
		this.repaint();
		
	}
	private void showallroom() {
		// TODO Auto-generated method stub
		//System.out.println(width);
		Sqloperationroom.sql="select * from roomtable";
		Sqloperationroom sqlop=new Sqloperationroom();
        JTable jtisbook=new JTable(sqlop.row,sqlop.columnname);
		if(jp2!=null)
		{
			jp2.removeAll();
		}
		this.devide=200;
		imb1.setSize(devide,height);
		jp1.setSize(devide,height);
		jsp.setDividerLocation(devide);
		jp2.setLayout(new GridLayout(3,3));
		jp2.setBackground(Color.cyan);
		if(jtisbook.getValueAt(0, 2).toString().trim().equals("��"))
		{
		jlb_room1=new JLabel("001",new ImageIcon("image/Bump_r1booked.gif"),0);
		}else{
		jlb_room1=new JLabel("001",new ImageIcon("image/Bump_single.gif"),0);
		}
		if(jtisbook.getValueAt(1, 2).toString().trim().equals("��"))
		{
		jlb_room2=new JLabel("001",new ImageIcon("image/Bump_r1booked.gif"),0);
		}else{
			jlb_room2=new JLabel("002",new ImageIcon("image/Bump_single.gif"),0);
		}
		if(jtisbook.getValueAt(2, 2).toString().trim().equals("��"))
		{
		jlb_room3=new JLabel("003",new ImageIcon("image/Bump_r1booked.gif"),0);
		}else{
		jlb_room3=new JLabel("003",new ImageIcon("image/Bump_single.gif"),0);
		}
		if(jtisbook.getValueAt(3, 2).toString().trim().equals("��"))
		{
		jlb_room4=new JLabel("004",new ImageIcon("image/Bump_r2booked.gif"),0);
		}else
		{
	    jlb_room4=new JLabel("004",new ImageIcon("image/Bump_double.gif"),0);
		}
		if(jtisbook.getValueAt(4, 2).toString().trim().equals("��"))
		{
		jlb_room5=new JLabel("005",new ImageIcon("image/Bump_r2booked.gif"),0);
		}else
		{
		jlb_room5=new JLabel("005",new ImageIcon("image/Bump_double.gif"),0);
		}
		if(jtisbook.getValueAt(5, 2).toString().trim().equals("��"))
		{
		jlb_room6=new JLabel("006",new ImageIcon("image/Bump_r2booked.gif"),0);
		}else
		{
		jlb_room6=new JLabel("006",new ImageIcon("image/Bump_double.gif"),0);	
		}
		if(jtisbook.getValueAt(6, 2).toString().trim().equals("��"))
		{
		jlb_room7=new JLabel("007",new ImageIcon("image/Bump_r3booked.gif"),0);
		}else
		{
		jlb_room7=new JLabel("007",new ImageIcon("image/Bump_family.gif"),0);
		}
		if(jtisbook.getValueAt(7, 2).toString().trim().equals("��"))
		{
		jlb_room8=new JLabel("008",new ImageIcon("image/Bump_r3booked.gif"),0);
		}else
		{
		jlb_room8=new JLabel("008",new ImageIcon("image/Bump_family.gif"),0);
		}
		if(jtisbook.getValueAt(8, 2).toString().trim().equals("��"))
		{
		jlb_room9=new JLabel("009",new ImageIcon("image/Bump_r3booked.gif"),0);
		}else
		{
		jlb_room9=new JLabel("009",new ImageIcon("image/Bump_family.gif"),0);	
		}
		jlb_room1.addMouseListener(this);
		jlb_room2.addMouseListener(this);
		jlb_room3.addMouseListener(this);
		jlb_room4.addMouseListener(this);
		jlb_room5.addMouseListener(this);
		jlb_room6.addMouseListener(this);
		jlb_room7.addMouseListener(this);
		jlb_room8.addMouseListener(this);
		jlb_room9.addMouseListener(this);
		jp2.add(jlb_room1);
		jp2.add(jlb_room2);
		jp2.add(jlb_room3);
		jp2.add(jlb_room4);
		jp2.add(jlb_room5);
		jp2.add(jlb_room6);
		jp2.add(jlb_room7);
		jp2.add(jlb_room8);
		jp2.add(jlb_room9);
		this.repaint();
	}
	private void delete() {
		// TODO Auto-generated method stub
		try {
			Class.forName(Sqloperation.driver);
			ct=DriverManager.getConnection(Sqloperation.url,Sqloperation.name,Sqloperation.passwd);
			ps=ct.prepareStatement("delete from personmanage where emp_id='"+jtf2_1.getText()+"'");
			System.out.println("delete from personmanage where emp_id='"+jtf2_1.getText()+"'");
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(ps!=null)
				{
				ps.close();
				}
				if(ct!=null)
				{
				ct.close();
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private void altersure() {
		// TODO Auto-generated method stub
		try {
			System.out.println("OK");
			Class.forName(Sqloperation.driver);
			ct=DriverManager.getConnection(Sqloperation.url,Sqloperation.name,Sqloperation.passwd);
			ps=ct.prepareStatement("update personmanage set emp_id='"+jtfid.getText()+"' where emp_id='"+jtf2_1.getText()+"'");
			ps.execute();
			ps=ct.prepareStatement("update personmanage set emp_name='"+jtfname.getText()+"' where emp_id='"+jtf2_1.getText()+"'");
			ps.execute();
			ps=ct.prepareStatement("update personmanage set emp_sex='"+jtfsex.getText()+"' where emp_id='"+jtf2_1.getText()+"'");
			ps.execute();
			ps=ct.prepareStatement("update personmanage set emp_position='"+jtfposition.getText()+"' where emp_id='"+jtf2_1.getText()+"'");
			ps.execute();
			ps=ct.prepareStatement("update personmanage set emp_salary='"+jtfsalary.getText()+"' where emp_id='"+jtf2_1.getText()+"'");
			ps.execute();
			ps=ct.prepareStatement("update personmanage set emp_age='"+jtfage.getText()+"' where emp_id='"+jtf2_1.getText()+"'");
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(ps!=null)
				{
				ps.close();
				}
				if(ct!=null)
				{
				ct.close();
				}
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�","��ʾ",JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	public void loginmanage()
	{
		//System.out.println("ok");
		Sqloperation.sql="select * from personmanage";
		Sqloperation sqlp=new Sqloperation();
		jtable=new JTable(sqlp.row,sqlp.columnname);
		this.devide=200;
		imb1.setSize(devide,height);
		jp1.setSize(devide,height);
		jsp.setDividerLocation(devide);
		jb2_shwall=new JButton("��ʾȫ��Ա��");
		jb2_shwall.setActionCommand("showall");
		jb2_shwall.addActionListener(this);
		jb2_shwall.setBounds(0, height-150, 365, 50);
		jb2_shwall.setBackground(Color.cyan);
		String A[]={"����","����"};
		jbx=new JComboBox(A);
		jbx.setBounds(100, height-450, 200, 30);
		jbx.addItemListener(this);
		jlb3_opway=new JLabel("��ѡ���ѯ��ʽ��");
		jlb3_opway.setBounds(0, height-450, 110, 30);
		jscp=new JScrollPane(jtable);
		jtf2_1.setBounds(170, height-390, 200, 30);
		jlb3_opid=new JLabel("���������Ա��ID������:");
		jlb3_opid.setBounds(0, height-390, 170, 30);
		JLabel jlb2_x=new JLabel(new ImageIcon("image/Bump_jp2_1.gif"));
		jlb2_x.setBounds(0, height-500, 300, 500);
		//jp2_1.setBounds(x, y, width, height);
		jb2_1=new JButton("��ѯ");
		jb2_2=new JButton("���");
		jb2_3=new JButton("�޸�");
		jb2_4=new JButton("ɾ��");
		jb2_1.setActionCommand("src");
		jb2_1.addActionListener(this);
		jb2_2.setActionCommand("add");
		jb2_2.addActionListener(this);
		jb2_3.setActionCommand("alter");
		jb2_3.addActionListener(this);
		jb2_4.setActionCommand("delete");
		jb2_4.addActionListener(this);
		jb2_1.setBounds(300, height-350, 70, 30);
		jb2_1.setBackground(Color.cyan);
		jb2_2.setBounds(300, height-310, 70, 30);
		jb2_2.setBackground(Color.cyan);
		jb2_3.setBounds(300, height-270, 70, 30);
		jb2_3.setBackground(Color.cyan);
		jb2_4.setBounds(300, height-230, 70, 30);
		jb2_4.setBackground(Color.cyan);
		jp2.add(jb2_1);
		jp2.add(jb2_2);
		jp2.add(jb2_3);
		jp2.add(jb2_4);
		jscp.setBounds(0, 0,width-devide, height-450);
		//jp2_1.setBackground(Color.white);
		jp2.add(jb2_shwall);
		jp2.add(jlb3_opway);
		jp2.add(jbx);
		jp2.add(jtf2_1);
		jp2.add(jlb3_opid);
		jp2.add(jlb2_x);
		jp2.add(jp2_1);
		jp2.add(jscp);
		//this.repaint();
	}
	public void alter()
	{
		JTable jtabletemp=null;
		Sqloperation.sql="select * from personmanage where emp_id = '"+jtf2_1.getText()+"'";
		//System.out.println(jtf2_1.getText()+Sqloperation.sql);
		sqlop=new Sqloperation();
	    jtabletemp=new JTable(sqlop.row,sqlop.columnname);
		jbsure=new JButton("ȷ���޸�");
		jbsure.setActionCommand("altersure");
		jbsure.addActionListener(this);
		jbsure.setBackground(Color.cyan);
		jbsure.setBounds(500, 300, 100, 30);
		if(sqlop.row.size()==1)
		{
		jlb3_head=new JLabel(new ImageIcon(jtabletemp.getValueAt(0, 6).toString().trim()));
		//jlb3_head.setBounds(x, y, width, height);
		jlb3_name=new JLabel("����");
		jlb3_name.setBounds(0,150, 30, 30);
		jtfname=new JTextField(jtabletemp.getValueAt(0, 1).toString());
		jtfname.setBounds(30, 150, 200, 30);
		jlb3_sex=new JLabel("�Ա�:");
		jlb3_sex.setBounds(290,150, 30, 30);
		jtfsex=new JTextField(jtabletemp.getValueAt(0, 2).toString());
		jtfsex.setBounds(320, 150, 200, 30);
		jlb3_age=new JLabel("����:");
		jlb3_age.setBounds(0,180, 30, 30);
		jtfage=new JTextField(jtabletemp.getValueAt(0, 3).toString());
		jtfage.setBounds(30, 180, 200, 30);
		jlb3_id=new JLabel("����:");
		jlb3_id.setBounds(290,180, 30, 30);
		jtfid=new JTextField(jtabletemp.getValueAt(0, 0).toString());
		jtfid.setBounds(320, 180, 200, 30);
		jlb3_position=new JLabel("ְλ:");
		jlb3_position.setBounds(0,210, 30, 30);
		jtfposition=new JTextField(jtabletemp.getValueAt(0, 4).toString());
		jtfposition.setBounds(30, 210, 200, 30);
		jlb3_salary=new JLabel("нˮ:");
		jlb3_salary.setBounds(290,210, 30, 30);
		jtfsalary=new JTextField(jtabletemp.getValueAt(0, 5).toString());
		jtfsalary.setBounds(320, 210, 200, 30);
		jp2_1.add(jbsure);
		jp2_1.add(jtfage);
		jp2_1.add(jtfname);
		jp2_1.add(jtfid);
		jp2_1.add(jtfposition);
		jp2_1.add(jtfsex);
		jp2_1.add(jtfsalary);
		jp2_1.add(jlb3_age);
		jp2_1.add(jlb3_name);
		jp2_1.add(jlb3_sex);
		jp2_1.add(jlb3_id);
		jp2_1.add(jlb3_salary);
		jp2_1.add(jlb3_position);
		jp2.add(jp2_1);
		jp2.repaint();
		
		}else{
			JOptionPane.showMessageDialog(null, "������Ҫ������Ա��ID","��ʾ",JOptionPane.ERROR_MESSAGE);
		}
	}
	public void search()
	{
		System.out.println("src!");
		String gettemp=jtf2_1.getText().trim();
		if(srcway==1)
		{
			//System.out.println("ok!!!!!!!!");
			Sqloperation.sql="select * from personmanage where emp_id='"+gettemp+"'";
			sqlop=new Sqloperation();
			///System.out.println(Sqloperation.sql);
			jtable=new JTable(sqlop.row,sqlop.columnname);
			jlb3_name=new JLabel("����:");
			if(sqlop.row.size()>0)
			{
			System.out.println(jtable.getValueAt(0, 6).toString());
			jlb3_head=new JLabel(new ImageIcon(jtable.getValueAt(0, 6).toString()));
			jlb3_head.setBounds(320,0, 250, 250);
			jp2_1.setBounds(400,height-450, width-400, 450);
			jlb3_name.setBounds(0,150, 30, 30);
			jlb3_getname=new JLabel(jtable.getValueAt(0, 1).toString());
			jlb3_getname.setBounds(30,150, 30, 30);
			jlb3_sex=new JLabel("�Ա�:");
			jlb3_sex.setBounds(190,150, 30, 30);
			jlb3_getsex=new JLabel(jtable.getValueAt(0, 2).toString());
			jlb3_getsex.setBounds(220,150, 30, 30);
			jlb3_age=new JLabel("����:");
			jlb3_age.setBounds(0,180, 30, 30);
			jlb3_getage=new JLabel(jtable.getValueAt(0, 3).toString());
			jlb3_getage.setBounds(30,180, 30, 30);
			jlb3_id=new JLabel("����:");
			jlb3_id.setBounds(190,180, 30, 30);
			jlb3_getid=new JLabel(jtable.getValueAt(0, 0).toString());
			jlb3_getid.setBounds(220,180, 30, 30);
			jlb3_position=new JLabel("ְλ:");
			jlb3_position.setBounds(0,210, 30, 30);
			jlb3_getposition=new JLabel(jtable.getValueAt(0, 4).toString());
			jlb3_getposition.setBounds(30,210, 50, 30);
			jlb3_salary=new JLabel("нˮ:");
			jlb3_salary.setBounds(190,210, 30, 30);
			jlb3_getsalary=new JLabel(jtable.getValueAt(0, 5).toString());
			jlb3_getsalary.setBounds(220,210, 50, 30);
			jp2_1.add(jlb3_head);
			jp2_1.add(jlb3_getname);
			jp2_1.add(jlb3_name);
			jp2_1.add(jlb3_getsex);
			jp2_1.add(jlb3_sex);
			jp2_1.add(jlb3_getage);
			jp2_1.add(jlb3_age);
			jp2_1.add(jlb3_getid);
			jp2_1.add(jlb3_id);
			jp2_1.add(jlb3_getposition);
			jp2_1.add(jlb3_position);
			jp2_1.add(jlb3_getsalary);
			jp2_1.add(jlb3_salary);
			jp2.add(jp2_1);
			jp2.repaint();
			//System.out.println("OK"+jtable.getValueAt(0, 1).toString());
			}else{
				JOptionPane.showMessageDialog(null, "�����ڴ�Ա��","��ʾ",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(srcway==0)
		{
			Sqloperation.sql="select * from personmanage where emp_name='"+gettemp+"'";
			sqlop=new Sqloperation();
			jtable=new JTable(sqlop.row,sqlop.columnname);
			if(sqlop.row.size()>0)
			{
//				System.out.println("select * from personmanage where emp_name='"+gettemp+"'");
//				System.out.println(sqlop.row.size());
			jlb3_head=new JLabel(new ImageIcon(jtable.getValueAt(0, 6).toString()));
			jlb3_head.setBounds(320,0, 250, 250);
			jp2_1.setBounds(400,height-450, width-400, 450);
			jlb3_name=new JLabel("����:");
			jlb3_name.setBounds(0,150, 30, 30);
			jlb3_getname=new JLabel(jtable.getValueAt(0, 1).toString());
			jlb3_getname.setBounds(30,150, 30, 30);
			jlb3_sex=new JLabel("�Ա�:");
			jlb3_sex.setBounds(190,150, 30, 30);
			jlb3_getsex=new JLabel(jtable.getValueAt(0, 2).toString());
			jlb3_getsex.setBounds(220,150, 30, 30);
			jlb3_age=new JLabel("����:");
			jlb3_age.setBounds(0,180, 30, 30);
			jlb3_getage=new JLabel(jtable.getValueAt(0, 3).toString());
			jlb3_getage.setBounds(30,180, 30, 30);
			jlb3_id=new JLabel("����:");
			jlb3_id.setBounds(190,180, 30, 30);
			jlb3_getid=new JLabel(jtable.getValueAt(0, 0).toString());
			jlb3_getid.setBounds(220,180, 30, 30);
			jlb3_position=new JLabel("ְλ:");
			jlb3_position.setBounds(0,210, 30, 30);
			jlb3_getposition=new JLabel(jtable.getValueAt(0, 4).toString());
			jlb3_getposition.setBounds(30,210, 50, 30);
			jlb3_salary=new JLabel("нˮ:");
			jlb3_salary.setBounds(190,210, 30, 30);
			jlb3_getsalary=new JLabel(jtable.getValueAt(0, 5).toString());
			jlb3_getsalary.setBounds(220,210, 50, 30);
			jp2_1.add(jlb3_head);
			jp2_1.add(jlb3_getname);
			jp2_1.add(jlb3_name);
			jp2_1.add(jlb3_getsex);
			jp2_1.add(jlb3_sex);
			jp2_1.add(jlb3_getage);
			jp2_1.add(jlb3_age);
			jp2_1.add(jlb3_getid);
			jp2_1.add(jlb3_id);
			jp2_1.add(jlb3_getposition);
			jp2_1.add(jlb3_position);
			jp2_1.add(jlb3_getsalary);
			jp2_1.add(jlb3_salary);
			jp2.add(jp2_1);
			jp2.repaint();
			}else{
				JOptionPane.showMessageDialog(null, "�����ڴ�Ա��","��ʾ",JOptionPane.ERROR_MESSAGE);
			}
		}
		//System.out.println("OK"+jtable.getValueAt(0, 2).toString());
		this.repaint();
	}
	public void add()
	{
		//System.out.println("ok");
		jbsure=new JButton("ȷ�����");
		jbsure.setActionCommand("sureadd");
		jbsure.addActionListener(this);
		jbsure.setBackground(Color.cyan);
		jbsure.setBounds(500, 300, 100, 30);
		jlb3_name=new JLabel("����");
		jlb3_name.setBounds(0,150, 30, 30);
		jtfname=new JTextField();
		jtfname.setBounds(30, 150, 200, 30);
		jlb3_sex=new JLabel("�Ա�:");
		jlb3_sex.setBounds(290,150, 30, 30);
		jtfsex=new JTextField();
		jtfsex.setBounds(320, 150, 200, 30);
		jlb3_age=new JLabel("����:");
		jlb3_age.setBounds(0,180, 30, 30);
		jtfage=new JTextField();
		jtfage.setBounds(30, 180, 200, 30);
		jlb3_id=new JLabel("����:");
		jlb3_id.setBounds(290,180, 30, 30);
		jtfid=new JTextField();
		jtfid.setBounds(320, 180, 200, 30);
		jlb3_position=new JLabel("ְλ:");
		jlb3_position.setBounds(0,210, 30, 30);
		jtfposition=new JTextField();
		jtfposition.setBounds(30, 210, 200, 30);
		jlb3_salary=new JLabel("нˮ:");
		jlb3_salary.setBounds(290,210, 30, 30);
		jtfsalary=new JTextField();
		jtfsalary.setBounds(320, 210, 200, 30);
		jp2_1.add(jbsure);
		jp2_1.add(jtfage);
		jp2_1.add(jtfname);
		jp2_1.add(jtfid);
		jp2_1.add(jtfposition);
		jp2_1.add(jtfsex);
		jp2_1.add(jtfsalary);
		jp2_1.add(jlb3_age);
		jp2_1.add(jlb3_name);
		jp2_1.add(jlb3_sex);
		jp2_1.add(jlb3_id);
		jp2_1.add(jlb3_salary);
		jp2_1.add(jlb3_position);
		jp2.add(jp2_1);
		jp2.repaint();
	}
	public void sureadd()
	{
		Sqloperation.sql="insert into personmanage values(?,?,?,?,?,?,?)";
		//sqlop=new Sqloperation();
		try {
			Class.forName(Sqloperation.driver);
			ct=DriverManager.getConnection(Sqloperation.url,Sqloperation.name,Sqloperation.passwd);
			ps=ct.prepareStatement(Sqloperation.sql);
			ps.setString(1, jtfid.getText());
			ps.setString(2, jtfname.getText());
			ps.setString(3, jtfsex.getText());
			ps.setString(4, jtfage.getText());
			ps.setString(5, jtfposition.getText());
			ps.setString(6, jtfsalary.getText());
			ps.setString(7, "sd");
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(ps!=null)
				{
					ps.close();
				}
				if(ct!=null)
				{
					ct.close();
				}
				JOptionPane.showMessageDialog(null, "��ӳɹ�","��ʾ",JOptionPane.ERROR_MESSAGE);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
		}
				
	}
	public void showall()
	{
		if(jp2!=null)
			jp2.removeAll();
		Sqloperation.sql="select * from personmanage";
		Sqloperation sqlp=new Sqloperation();
		jtable=new JTable(sqlp.row,sqlp.columnname);
		jscp=new JScrollPane(jtable);
		jscp.setBounds(0, 0,width-devide, height);
		jp2.add(jscp);
		jp2.repaint();
	}
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getItem().equals("����"))
		{
			srcway=0;
			//System.out.println("0");
		}
		if(e.getItem().equals("����"))
		{
			srcway=1;
			//System.out.println("1");
		}
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		 if(((JLabel)e.getSource()).equals(jlb1))
		 {
			 System.out.println("OK");
			 if(jp2!=null)
				{
					jp2.removeAll();
				}
				jbdelete=new JButton("����");
				jbdelete.setBackground(Color.cyan);
				jbdelete.setBounds(width-500, 0, 300, height);
				jbdelete.setActionCommand("jiezhang");
				jbdelete.addActionListener(this);
				jp2.setLayout(null);
				jp1.setSize(200, height);
				imb1.setSize(200,height);
				this.devide=200;
				jsp.setDividerLocation(devide);
				Sqloperationcust.sql="select * from customer";
				Sqloperationcust sqlopc=new Sqloperationcust();
				jtable=new JTable(sqlopc.row,sqlopc.columnname);
				jscp=new JScrollPane(jtable);
				jscp.setBounds(0, 0, width-500, height);
				jp2.add(jbdelete);
				jp2.add(jscp);
				jp2.repaint();
		 }
		if(((JLabel)e.getSource()).equals(jlb2))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			jp2.setLayout(null);
			this.loginmanage();
		}
		if(((JLabel)e.getSource()).equals(jlb5))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			jp2.setLayout(null);
			jp2.setLayout(null);
			jp1.setSize(200, height);
			imb1.setSize(200,height);
			this.devide=200;
			jsp.setDividerLocation(devide);
			Sqloperationcust.sql="select * from customer";
			Sqloperationcust sqlopc=new Sqloperationcust();
			jtable=new JTable(sqlopc.row,sqlopc.columnname);
			jscp=new JScrollPane(jtable);
			jscp.setBounds(0, 0, width-200, height);
			jp2.add(jscp);
			jp2.repaint();
		}
		if(((JLabel)e.getSource()).equals(jlb_room1))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			price=168;
			this.roomid=jlb_room1.getText();
			this.enterroom();
		}
		 if(((JLabel)e.getSource()).equals(jlb_room2))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			price=168;
			this.roomid=jlb_room2.getText();
			//System.out.println(roomid);
			this.enterroom();
		}
		 if(((JLabel)e.getSource()).equals(jlb_room3))
		{
				if(jp2!=null)
				{
					jp2.removeAll();
				}
			price=168;
			this.roomid=jlb_room3.getText();
			//System.out.println("select * from roomtable where roo_id = '" +roomid+ "'");
			this.enterroom();
		}
		if(((JLabel)e.getSource()).equals(jlb_room4))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			price=228;
			System.out.println("OK");
			this.roomid=jlb_room4.getText();
			//System.out.println("select * from roomtable where roo_id = '" +roomid+ "'");
			this.enterroom();
		}
		if(((JLabel)e.getSource()).equals(jlb_room5))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			price=228;
			this.roomid=jlb_room5.getText();
			//System.out.println("select * from roomtable where roo_id = '" +roomid+ "'");
			this.enterroom();
		}
		 if(((JLabel)e.getSource()).equals(jlb_room6))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			price=228;
			this.roomid=jlb_room6.getText();
			//System.out.println("select * from roomtable where roo_id = '" +roomid+ "'");
			this.enterroom();
		}
		 if(((JLabel)e.getSource()).equals(jlb_room7))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			price=668;
			this.roomid=jlb_room7.getText();
			//System.out.println("select * from roomtable where roo_id = '" +roomid+ "'");
			this.enterroom();
		}
		 if(((JLabel)e.getSource()).equals(jlb_room8))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			price=668;
			this.roomid=jlb_room8.getText();
			//System.out.println("select * from roomtable where roo_id = '" +roomid+ "'");
			this.enterroom();
		}
		 if(((JLabel)e.getSource()).equals(jlb_room9))
		{
			if(jp2!=null)
			{
				jp2.removeAll();
			}
			price=668;
			this.roomid=jlb_room9.getText();
			//System.out.println("select * from roomtable where roo_id = '" +roomid+ "'");
			this.enterroom();
		}
		 if(((JLabel)e.getSource()).equals(jlb3))
		 {
			 this.bookroom();
		 }
		 if(((JLabel)e.getSource()).equals(jlb4))
		 {
			 if(jp2!=null)
			 {
				 jp2.removeAll();
			 }
			 this.returnbook();
		 }
		 if(((JLabel)e.getSource()).equals(jlb_g01))
		 {
			 if(e.getButton()==MouseEvent.BUTTON1)
			 {
		    jp2.remove(jlb_getccost);
		    jp2.remove(jlb_costlist);
			sumacc=sumacc+5;
			g01_Num++;
			jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
			jlb_getccost.setFont(font1);
			jlb_getccost.setBounds(100, 500, 200, 50);
			jp2.add(jlb_getccost);
			jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
					"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
					"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
			jlb_costlist.setBackground(Color.cyan);
			jlb_costlist.setBounds(0, 520, 550, 100);
			jp2.add(jlb_costlist);
			jp2.repaint();
			 }else
			 {
				    jp2.remove(jlb_getccost);
				    jp2.remove(jlb_costlist);
					sumacc=sumacc-5;
					g01_Num--;
					jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
					jlb_getccost.setFont(font1);
					jlb_getccost.setBounds(100, 500, 200, 50);
					jp2.add(jlb_getccost);
					jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
							"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
							"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
					jlb_costlist.setBackground(Color.cyan);
					jlb_costlist.setBounds(0, 520, 550, 100);
					jp2.add(jlb_costlist);
					jp2.repaint();
			 }
		 }
		 if(((JLabel)e.getSource()).equals(jlb_g02))
		 {
			 if(e.getButton()==MouseEvent.BUTTON1)
			 {
		    jp2.remove(jlb_getccost);
		    jp2.remove(jlb_costlist);
			sumacc=sumacc+2;
			g02_Num++;
			jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
			jlb_getccost.setFont(font1);
			jlb_getccost.setBounds(100, 500, 200, 50);
			jp2.add(jlb_getccost);
			jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
					"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
					"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
			jlb_costlist.setBackground(Color.cyan);
			jlb_costlist.setBounds(0, 520, 550, 100);
			jp2.add(jlb_costlist);
			jp2.repaint();
			 }else
			 {
				    jp2.remove(jlb_getccost);
				    jp2.remove(jlb_costlist);
					sumacc=sumacc+2;
					g02_Num--;
					jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
					jlb_getccost.setFont(font1);
					jlb_getccost.setBounds(100, 500, 200, 50);
					jp2.add(jlb_getccost);
					jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
							"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
							"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
					jlb_costlist.setBackground(Color.cyan);
					jlb_costlist.setBounds(0, 520, 550, 100);
					jp2.add(jlb_costlist);
					jp2.repaint(); 
			 }
		 }
		 if(((JLabel)e.getSource()).equals(jlb_g03))
		 {
			 if(e.getButton()==MouseEvent.BUTTON1)
			 {
		    System.out.println("ok");
		    jp2.remove(jlb_getccost);
		    jp2.remove(jlb_costlist);
			sumacc=sumacc+10;
			g03_Num++;
			jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
			jlb_getccost.setFont(font1);
			jlb_getccost.setBounds(100, 500, 200, 50);
			jp2.add(jlb_getccost);
			jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
					"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
					"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
			jlb_costlist.setBackground(Color.cyan);
			jlb_costlist.setBounds(0, 520, 550, 100);
			jp2.add(jlb_costlist);
			jp2.repaint();
			 }else
			 {
				    System.out.println("ok");
				    jp2.remove(jlb_getccost);
				    jp2.remove(jlb_costlist);
					sumacc=sumacc-10;
					g03_Num--;
					jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
					jlb_getccost.setFont(font1);
					jlb_getccost.setBounds(100, 500, 200, 50);
					jp2.add(jlb_getccost);
					jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
							"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
							"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
					jlb_costlist.setBackground(Color.cyan);
					jlb_costlist.setBounds(0, 520, 550, 100);
					jp2.add(jlb_costlist);
					jp2.repaint();
			 }
		 }
		 if(((JLabel)e.getSource()).equals(jlb_g04))
		 {
			 if(e.getButton()==MouseEvent.BUTTON1)
			 {
		    System.out.println("ok");
		    jp2.remove(jlb_getccost);
		    jp2.remove(jlb_costlist);
			sumacc=sumacc+8;
			g04_Num++;
			jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
			jlb_getccost.setFont(font1);
			jlb_getccost.setBounds(100, 500, 200, 50);
			jp2.add(jlb_getccost);
			jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
					"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
					"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
			jlb_costlist.setBackground(Color.cyan);
			jlb_costlist.setBounds(0, 520, 550, 100);
			jp2.add(jlb_costlist);
			jp2.repaint();
			 }else
			 {
				    jp2.remove(jlb_getccost);
				    jp2.remove(jlb_costlist);
					sumacc=sumacc-8;
					g04_Num--;
					jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
					jlb_getccost.setFont(font1);
					jlb_getccost.setBounds(100, 500, 200, 50);
					jp2.add(jlb_getccost);
					jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
							"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
							"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
					jlb_costlist.setBackground(Color.cyan);
					jlb_costlist.setBounds(0, 520, 550, 100);
					jp2.add(jlb_costlist);
					jp2.repaint();
			 }
		 }
		 if(((JLabel)e.getSource()).equals(jlb_g05))
		 {
			 if(e.getButton()==MouseEvent.BUTTON1)
			 {
		    jp2.remove(jlb_getccost);
		    jp2.remove(jlb_costlist);
			sumacc=sumacc+10;
			g05_Num++;
			jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
			jlb_getccost.setFont(font1);
			jlb_getccost.setBounds(100, 500, 200, 50);
			jp2.add(jlb_getccost);
			jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
					"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
					"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
			jlb_costlist.setBackground(Color.cyan);
			jlb_costlist.setBounds(0, 520, 550, 100);
			jp2.add(jlb_costlist);
			jp2.repaint();
			 }else
			 {
				    jp2.remove(jlb_getccost);
				    jp2.remove(jlb_costlist);
					sumacc=sumacc-10;
					g05_Num--;
					jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
					jlb_getccost.setFont(font1);
					jlb_getccost.setBounds(100, 500, 200, 50);
					jp2.add(jlb_getccost);
					jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
							"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
							"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
					jlb_costlist.setBackground(Color.cyan);
					jlb_costlist.setBounds(0, 520, 550, 100);
					jp2.add(jlb_costlist);
					jp2.repaint(); 
			 }
		 }
		 if(((JLabel)e.getSource()).equals(jlb_g06))
		 {
			 if(e.getButton()==MouseEvent.BUTTON1)
			 {
		    jp2.remove(jlb_getccost);
		    jp2.remove(jlb_costlist);
			sumacc=sumacc+6;
			g06_Num++;
			jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
			jlb_getccost.setFont(font1);
			jlb_getccost.setBounds(100, 500, 200, 50);
			jp2.add(jlb_getccost);
			jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
					"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
					"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
			jlb_costlist.setBackground(Color.cyan);
			jlb_costlist.setBounds(0, 520, 550, 100);
			jp2.add(jlb_costlist);
			jp2.repaint();
			 }else
			 {
				    jp2.remove(jlb_getccost);
				    jp2.remove(jlb_costlist);
					sumacc=sumacc-6;
					g06_Num--;
					jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
					jlb_getccost.setFont(font1);
					jlb_getccost.setBounds(100, 500, 200, 50);
					jp2.add(jlb_getccost);
					jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
							"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
							"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
					jlb_costlist.setBackground(Color.cyan);
					jlb_costlist.setBounds(0, 520, 550, 100);
					jp2.add(jlb_costlist);
					jp2.repaint(); 
			 }
		 }
		 if(((JLabel)e.getSource()).equals(jlb_g07))
		 {
			 if(e.getButton()==MouseEvent.BUTTON1)
			 {
		    jp2.remove(jlb_getccost);
		    jp2.remove(jlb_costlist);
			sumacc=sumacc+88;
			g07_Num++;
			jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
			jlb_getccost.setFont(font1);
			jlb_getccost.setBounds(100, 500, 200, 50);
			jp2.add(jlb_getccost);
			jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
					"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
					"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
			jlb_costlist.setBackground(Color.cyan);
			jlb_costlist.setBounds(0, 520, 550, 100);
			jp2.add(jlb_costlist);
			jp2.repaint();
			 }
			 else{
				    jp2.remove(jlb_getccost);
				    jp2.remove(jlb_costlist);
					sumacc=sumacc-88;
					g07_Num--;
					jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
					jlb_getccost.setFont(font1);
					jlb_getccost.setBounds(100, 500, 200, 50);
					jp2.add(jlb_getccost);
					jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
							"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
							"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
					jlb_costlist.setBackground(Color.cyan);
					jlb_costlist.setBounds(0, 520, 550, 100);
					jp2.add(jlb_costlist);
					jp2.repaint();
			 }
		 }
		 if(((JLabel)e.getSource()).equals(jlb_g08))
		 {
			 if(e.getButton()==MouseEvent.BUTTON1)
			 {
		    jp2.remove(jlb_getccost);
		    jp2.remove(jlb_costlist);
			sumacc=sumacc+5;
			g08_Num++;
			jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
			jlb_getccost.setFont(font1);
			jlb_getccost.setBounds(100, 500, 200, 50);
			jp2.add(jlb_getccost);
			jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
					"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
					"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
			jlb_costlist.setBackground(Color.cyan);
			jlb_costlist.setBounds(0, 520, 550, 100);
			jp2.add(jlb_costlist);
			jp2.repaint();
			 }else
			 {
				    jp2.remove(jlb_getccost);
				    jp2.remove(jlb_costlist);
					sumacc=sumacc-5;
					g08_Num--;
					jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
					jlb_getccost.setFont(font1);
					jlb_getccost.setBounds(100, 500, 200, 50);
					jp2.add(jlb_getccost);
					jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
							"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
							"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
					jlb_costlist.setBackground(Color.cyan);
					jlb_costlist.setBounds(0, 520, 550, 100);
					jp2.add(jlb_costlist);
					jp2.repaint(); 
			 }
		 }
		 if(((JLabel)e.getSource()).equals(jlb_g09))
		 {
			 if(e.getButton()==MouseEvent.BUTTON1)
			 {
		    jp2.remove(jlb_getccost);
		    jp2.remove(jlb_costlist);
		    g09_Num++;
			sumacc=sumacc+228;
			jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
			jlb_getccost.setFont(font1);
			jlb_getccost.setBounds(100, 500, 200, 50);
			jp2.add(jlb_getccost);
			jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
					"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
					"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
			jlb_costlist.setBackground(Color.cyan);
			jlb_costlist.setBounds(0, 520, 550, 100);
			jp2.add(jlb_costlist);
			jp2.repaint();
			 }else
			 {
				    jp2.remove(jlb_getccost);
				    jp2.remove(jlb_costlist);
					sumacc=sumacc-228;
					g09_Num--;
					jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
					jlb_getccost.setFont(font1);
					jlb_getccost.setBounds(100, 500, 200, 50);
					jp2.add(jlb_getccost);
					jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
							"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
							"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
					jlb_costlist.setBackground(Color.cyan);
					jlb_costlist.setBounds(0, 520, 550, 100);
					jp2.add(jlb_costlist);
					jp2.repaint(); 
			 }
		 }
		 if(((JLabel)e.getSource()).equals(jlb_g10))
		 {
			 if(e.getButton()==MouseEvent.BUTTON1){
		    System.out.println("ok");
		    jp2.remove(jlb_getccost);
		    jp2.remove(jlb_costlist);
			sumacc=sumacc+3;
			g10_Num++;
			jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
			jlb_getccost.setFont(font1);
			jlb_getccost.setBounds(100, 500, 200, 50);
			jp2.add(jlb_getccost);
			jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
					"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
					"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
			jlb_costlist.setBackground(Color.cyan);
			jlb_costlist.setBounds(0, 520, 550, 100);
			jp2.add(jlb_costlist);
			jp2.repaint();
			 }else
			 {
				    jp2.remove(jlb_getccost);
				    jp2.remove(jlb_costlist);
					sumacc=sumacc-3;
					g10_Num--;
					jlb_getccost=new JLabel(String.valueOf((Float.parseFloat(jtable.getValueAt(0, 5).toString().trim())+sumacc)));
					jlb_getccost.setFont(font1);
					jlb_getccost.setBounds(100, 500, 200, 50);
					jp2.add(jlb_getccost);
					jlb_costlist=new JLabel("ѩ��:"+g01_Num+"  ����:"+g02_Num+"  ����:"+g03_Num+"  ����:"+g04_Num+
							"  �ݽż�צ:"+g05_Num+"  ���:"+g06_Num+"  �����ף�"+g07_Num+"  ɽ��ơ��:"+g08_Num+
							"  ���ؼ�:"+g09_Num+"  ֽ��:"+g10_Num);
					jlb_costlist.setBackground(Color.cyan);
					jlb_costlist.setBounds(0, 520, 550, 100);
					jp2.add(jlb_costlist);
					jp2.repaint(); 
			 }
		 }
		 if(((JLabel)e.getSource()).equals(jlb6))
		 {
				if(jp2!=null)
				{
				jp2.removeAll();
				}
				jp2.setBackground(Color.cyan);
				jp1.setSize(200, height);
				imb1.setSize(200,height);
				this.devide=200;
				jsp.setDividerLocation(devide);
				JLabel jlbhelp=new JLabel("��л�ٶȣ�������Ȩ���壬�Ͻ�������ҵ��;");
				JLabel jlbhel=new JLabel("������");
				jlbhelp.setFont(font1);
				jlbhelp.setBounds(200, 300, 1000, 30);
				jlbhel.setFont(font2);
				jlbhel.setBounds(500, 500, 1000, 60);
				jp2.add(jlbhelp);
				jp2.add(jlbhel);
				this.repaint();
		 }
		
	}
	public void enterroom()
	{
		Sqloperationroom.sql="select * from roomtable where room_id='"+roomid+"'";
		Sqloperationroom sqlop=new Sqloperationroom();
	    JTable jtisbook=new JTable(sqlop.row,sqlop.columnname);
		JTable tempjt=null;
		jp2.setBackground(Color.cyan);
		jbbook=new JButton("Ԥ��");
		jbbook.setBounds(900, 600, 150, 50);
		jbbook.setBackground(Color.cyan);
		jbbook.setActionCommand("book");
		jbbook.addActionListener(this);
		jbrbook=new JButton("�˶�");
		jbrbook.setActionCommand("surereturn");
		jbrbook.addActionListener(this);
		jbrbook.setBackground(Color.cyan);
		jbrbook.setBounds(900, 600, 150, 50);
		jbreturn=new JButton("����");
		jbreturn.setBounds(600, 600, 150, 50);
		jbreturn.setBackground(Color.cyan);
		jbreturn.setActionCommand("jbreturn");
		jbreturn.addActionListener(this);
		jlb_rid=new JLabel("����� ��");
		jlb_rid.setBounds(650,0, 250, 50);
		jlb_rid.setFont(font2);
		jlb_rstyle=new JLabel("�������ͣ�");
		jlb_rstyle.setBounds(650,100, 300, 50);
		jlb_rstyle.setFont(font2);
		jlb_rprice=new JLabel("����۸�");
		jlb_rprice.setBounds(650,200, 300, 50);
		jlb_rprice.setFont(font2);
		jlb_risbook=new JLabel("�Ƿ�Ԥ����");
		jlb_risbook.setBounds(650,300, 300, 50);
		jlb_risbook.setFont(font2);
		try {
			Sqloperationroom.sql="select * from roomtable where room_id='"+roomid+"'";
			spoproom=new Sqloperationroom();
			tempjt=new JTable(spoproom.row,spoproom.columnname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(roomid.equals("001")||roomid.equals("002")||roomid.equals("003"))
		{
		jlb_rs=new JLabel(new ImageIcon("image/Bump_r1.gif"));
		jlb_rs.setBounds(0, 0, 600, 600);
		}
		else if(roomid.equals("004")||roomid.equals("005")||roomid.equals("006"))
		{
		jlb_rs=new JLabel(new ImageIcon("image/Bump_r2.gif"));
		jlb_rs.setBounds(0, 0, 600, 600);
		}
		else if(roomid.equals("007")||roomid.equals("008")||roomid.equals("009"))
		{
		jlb_rs=new JLabel(new ImageIcon("image/Bump_r3.gif"));
		jlb_rs.setBounds(0, 0, 600, 600);
		}
		jlbr2=new JLabel("��飺");
		jlbr2.setFont(new Font("΢���ź�",Font.BOLD,18));
		jlbr2.setBounds(540, 380, 650, 50);
		jlbr1=new JLabel(tempjt.getValueAt(0, 4).toString());
		jlbr1.setFont(new Font("΢���ź�",Font.BOLD,18));
		jlbr1.setBounds(540, 400, 650, 50);
		jlb_getrid=new JLabel(tempjt.getValueAt(0, 0).toString());
		//System.out.println(tempjt.getValueAt(0, 0).toString()+"!!!");
		jlb_getrid.setBounds(900, 0, 250, 50);
		jlb_getrid.setFont(font2);
		jlb_getrstyle=new JLabel(tempjt.getValueAt(0, 1).toString());
		jlb_getrstyle.setBounds(900,100, 250, 50);
		jlb_getrstyle.setFont(font2);
		jlb_getrisbook=new JLabel(tempjt.getValueAt(0, 3).toString());
		jlb_getrisbook.setBounds(900,200, 250, 50);
		jlb_getrisbook.setFont(font2);
		jlb_getrprice=new JLabel(tempjt.getValueAt(0, 2).toString());
		jlb_getrprice.setBounds(900,300, 250, 50);
		jlb_getrprice.setFont(font2);
		jp2.add(jlbr1);
		jp2.add(jlbr2);
		 if(jtisbook.getValueAt(0, 2).toString().trim().equals("��"))
		 {
		jp2.add(jbbook);
		 }else
		 {
			 jlb_cinf=new JLabel("Ԥ���ͻ���Ϣ��");
			 jlb_cinf.setBounds(550,450, 250, 50);
			 jlb_cinf.setFont(font1);
			 //Sqloperationcust.sql="select * from customer where crid = ' "+roomid+"'";
			 System.out.println(roomid);
			 Sqloperationcust sqlopcust=new Sqloperationcust();
			 JTable tempjtable=new JTable(sqlopcust.row,sqlopcust.columnname);
			 cname=tempjtable.getValueAt(0, 1).toString().trim();
			 jlb_getcinf=new JLabel(cname+",ס��ʱ�䣺"+tempjtable.getValueAt(0, 2).toString()+","+tempjtable.getValueAt(0, 3).toString()+"����");
			 jlb_getcinf.setBounds(700,450, 350, 50);
			 jlb_getcinf.setFont(font1);
			 jp2.add(jlb_getcinf);
			 jp2.add(jlb_cinf);
			 jp2.add(jbrbook);
		 }
		jp2.add(jbreturn);
		jp2.add(jlb_rs);
		jp2.add(jlb_rid);
		jp2.add(jlb_rprice);
		jp2.add(jlb_rstyle);
		jp2.add(jlb_risbook);
		jp2.add(jlb_getrid);
		jp2.add(jlb_getrisbook);
		jp2.add(jlb_getrprice);
		jp2.add(jlb_getrstyle);
		jp2.repaint();
	}
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(((JLabel)e.getSource()).equals(jlb1))
		{
			jlb1.setEnabled(true);
		}
		if(((JLabel)e.getSource()).equals(jlb2))
		{
			jlb2.setEnabled(true);
		}
		if(((JLabel)e.getSource()).equals(jlb3))
		{
			jlb3.setEnabled(true);
		}
		if(((JLabel)e.getSource()).equals(jlb4))
		{
			jlb4.setEnabled(true);
		}
		if(((JLabel)e.getSource()).equals(jlb5))
		{
			jlb5.setEnabled(true);
		}
		if(((JLabel)e.getSource()).equals(jlb6))
		{
			jlb6.setEnabled(true);
		}
	}
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(((JLabel)e.getSource()).equals(jlb1))
		{
			jlb1.setEnabled(false);
		}
		if(((JLabel)e.getSource()).equals(jlb3))
		{
			jlb3.setEnabled(false);
		}
		if(((JLabel)e.getSource()).equals(jlb4))
		{
			jlb4.setEnabled(false);
		}
		if(((JLabel)e.getSource()).equals(jlb5))
		{
			jlb5.setEnabled(false);
		}
		if(((JLabel)e.getSource()).equals(jlb6))
		{
			jlb6.setEnabled(false);
		}
	}

}
