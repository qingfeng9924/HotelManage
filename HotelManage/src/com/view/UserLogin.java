package com.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import com.sqldb.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import javax.swing.*;
import javax.tools.Tool;
class UserLogin extends JDialog implements Runnable {
	static String position="清风";
	int x=Toolkit.getDefaultToolkit().getScreenSize().width/2-300;
	int y=Toolkit.getDefaultToolkit().getScreenSize().height/2-200;
	LoginPanel lp=null;
	AePlayWave aw=new AePlayWave("wav/1.wav");
	public UserLogin()
	{
		lp=new LoginPanel();
		aw.start();
		//this.setLayout(null);
		lp.setBounds(0, 100, 550,350);
		this.add(lp);
		this.setUndecorated(true);
		this.setSize(550, 350);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(x, y);
		this.setVisible(true);
		Thread t=new Thread(this);
		t.start();
	}
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(1000);
				//System.out.println("ok");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(LoginPanel.islogin==true)
			{
				this.dispose();
				Window.devide=Window.width;
				new Window();
				//aw.destroy();
				break;
			}
		}
	}

}
class LoginPanel extends JPanel implements ActionListener
{
	static boolean islogin=false;
	boolean isloginname=false;
    String loginid=null;
	String loginpsswd=null;
	//Sqloperation sp=null;
	MeteorPanel mp=null;
	//登陆界面的JLabel
	JLabel jlb1=null;
	JLabel jlb2=null;
	//登录界面的JTexField和JPasswd
	JTextField jtf1=null;
	JPasswordField jpf1=null;
	Image imgloginp2=null;
	//登录确定按钮和退出按钮
	JButton jb1=null;
	JButton jb2=null;
	Connection ct=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
	public LoginPanel()
	{
		this.setLayout(null);
		mp=new MeteorPanel();
		mp.setBounds(0, 0, 550, 220);
		try {
			imgloginp2=ImageIO.read(new File("image/Bump_loginp2.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jb1=new JButton("登录");
		jb1.setBounds(350,320,70,20);
		jb1.setBackground(Color.ORANGE);
		jb1.setActionCommand("login");
		jb1.addActionListener(this);
		//jb1.setBorder(BorderFactory.createCompoundBorder());
		jb2=new JButton("取消");
		jb2.setBounds(450,320,70,20);
		jb2.setBackground(Color.ORANGE);
		jb2.setActionCommand("cancel");
		jb2.addActionListener(this);
		jlb1=new JLabel("用户名：");
		jlb1.setBounds(300, 250, 70, 30);
		jlb2=new JLabel("密    码：");
		jlb2.setBounds(300, 280, 70, 30);
		jtf1=new JTextField(); 
		jtf1.setBounds(350, 257, 160, 20);
		jtf1.setBorder(BorderFactory.createLoweredBevelBorder());
		jpf1=new JPasswordField();
		jpf1.setBounds(350, 287, 160, 20);
		jpf1.setBorder(BorderFactory.createLoweredBevelBorder());
		this.add(jb1);
		this.add(jb2);
		this.add(jlb1);
		this.add(jlb2);
		this.add(jtf1);
		this.add(jpf1);
		this.add(mp);
		//this.setBackground(null);
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		//super.paintComponent(g);
		g.drawImage(imgloginp2,0,220,550, 350,this);
		g.setFont(new Font("华文新魏",Font.CENTER_BASELINE,30));
		g.setColor(Color.white);
		g.drawString("@清风工作室", 0, 320);
		this.repaint();
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("login"))
		{
			loginid=jtf1.getText();
			loginpsswd=new String(jpf1.getPassword());
			Sqloperation.sql="select * from logintable where "+"loginid = '"+loginid+"'";
			try {
				Class.forName(Sqloperation.driver);
				ct=DriverManager.getConnection(Sqloperation.url,Sqloperation.name,Sqloperation.passwd);
				ps=ct.prepareStatement(Sqloperation.sql);
				rs=ps.executeQuery();
				while(rs.next())
				{
					String tempid=rs.getString(1).trim();
					System.out.println(tempid);
					if(loginid.equals(tempid))
					{
						String temppasswd=rs.getString(2).trim();
						this.isloginname=true;
						UserLogin.position=rs.getString(3).trim();
						System.out.println(UserLogin.position);
						if(temppasswd.equals(loginpsswd))
						{
							islogin=true;
							System.out.println(""+islogin);
							break;
						}else
						{
							JOptionPane.showMessageDialog(null, "密码错误","提示",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				if(this.isloginname==false)
				{
					JOptionPane.showMessageDialog(null, "用户名不存在","提示",JOptionPane.ERROR_MESSAGE);

				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally
			{
					try {
						if(rs!=null)
						{
						rs.close();
						}
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
					//System.out.println(Sqloperation.sql);
	
			}
			
		}
		if(e.getActionCommand().equals("cancel"))
		{
			System.exit(0);
		}
		
	}
}
class MeteorPanel extends JPanel
{
	int w=50;
	int h=50;
	Vector <Meteor>vt=new Vector<Meteor>();
	Image imglogin1=null;
	Image imgmeteor=null;
	Image imgyan=null;
	Meteor mt=null;
	Image imgxiaohui=null;
	public MeteorPanel()
	{
		for(int i=0;i<10;i++)
		{
			mt=new Meteor(0,i*10);
			Thread t=new Thread(mt);
			t.start();
			vt.add(mt);
		}
		try {
			imglogin1=ImageIO.read(new File("image/Bump_loginp 1.JPG"));
			imgmeteor=ImageIO.read(new File("image/Bump_meteor.gif"));
			imgyan=ImageIO.read(new File("image/Bump_yan.gif"));
			imgxiaohui=ImageIO.read(new File("image/Bump_xiaohui.gif"));
			System.out.println("OK");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void paint(Graphics g)
	{
		//this.setLayout(null);
		super.paint(g);
		g.setColor(Color.WHITE);
		g.drawImage(imglogin1, 0,0,550,220, this);
		g.drawImage(imgyan, 0, 0, 300, 200, this);
		g.drawImage(imgxiaohui, 200,10,70,70, this);
		g.setFont(new Font("华文新魏",Font.BOLD,60));
		g.drawString("联盟登录",w+250 , h);
		g.drawString("League",w+280, 100);
		g.drawString("Hotel", w+290, 150);
		//g.drawImage(imglogin2, 0,0,550,350, this);
		for(int i=0;i<vt.size();i++)
		{
			Meteor temp=vt.get(i);
			if(temp.islive==true)
			{
				g.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
				g.drawImage(imgmeteor, temp.x, temp.y, 20, 5, this);
			}else if(temp.islive==false)
			{
				vt.remove(i);
			}
		}
		this.increase();
		this.repaint();
	}
	public void increase()
	{
		if(vt.size()<150)
		{
			Meteor mt=new Meteor((int)(Math.random()*550),(int)(Math.random()*220));
			Thread t=new Thread(mt);
			t.start();
			vt.add(mt);
		}
	}
}
class Meteor implements Runnable
{
	int x=0;
	int y=0;
	//Meteor mt=null;
	boolean islive=true;
	public Meteor(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			x+=10;
			y-=5;
			if(x>550)
			{
				this.islive=false;
			}
			if(this.islive==false)
			{
				break;
			}	
		}
		
	}
}
//播放声音的类
class AePlayWave extends Thread {

	private String filename;
	public AePlayWave(String wavfile) {
		filename = wavfile;

	}

	public void run() {
		File soundFile = new File(filename);
		AudioInputStream audioInputStream = null;
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}

		AudioFormat format = audioInputStream.getFormat();
		SourceDataLine auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		try {
			auline = (SourceDataLine) AudioSystem.getLine(info);
			auline.open(format);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		auline.start();
		int nBytesRead = 0;
		//这是缓冲
		byte[] abData = new byte[512];

		try {
			while (nBytesRead != -1) {
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0)
					auline.write(abData, 0, nBytesRead);
				if(LoginPanel.islogin==true)
				{
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		} finally {
			auline.drain();
			auline.close();
		}
//		if(LoginPanel.islogin==true)
//		{
//			auline.drain();
//			auline.close();
//			auline.stop();
//			break;
//		}
	}

	
}
