package com.view;
import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.math.*;
import com.mytool.*;
public class OpenWindow extends JWindow implements Runnable {
	int width=Toolkit.getDefaultToolkit().getScreenSize().width;
	int height=Toolkit.getDefaultToolkit().getScreenSize().height;
	FlashPanel fp=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OpenWindow op=new OpenWindow();
	}
	public OpenWindow()
	{
		fp=new FlashPanel();
		Thread t=new Thread(this);
		t.start();
		//this.setLayout(null);
		//fp.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.add(fp);
		this.setSize(width/2, height/2);
		this.setLocation(350, 200);
		this.setVisible(true);
	}
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(17000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.dispose();
			new UserLogin();
			break;
		}
		
	}
}
class FlashPanel extends JPanel implements Runnable
{
	//Timer timer=new Timer(1000,this.repaint());
	//Tool tool=null;
	Thread t=null;
	private int time=0;
	private int x=500;
	private int y=100;
	private int dian=0;
	private int speed=10;
//	private int xr=50;
//	private int yr=50;
	Image imag1=null;
	Image imaglove=null;
	String []A={"联","盟","青","年","旅","店","最","优","的","服","务","欢","迎","您"};
	public FlashPanel()
	{
		imag1=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/BumpOW.jpg"));
		t=new Thread(this);
		t.start();
//		try {
//			imaglove=ImageIO.read(new File("image/Bumplove.gif"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//System.out.println("OK");
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		//super.paintComponent(g);
		//System.out.println("OK");
		g.setColor(Color.white);
		g.setFont(new Font("宋体",Font.BOLD,30));
		if(time==0)
		{
			g.drawImage(imag1, 0,0,this.getWidth(), this.getHeight()-30,this);
			g.setFont(new Font("华文新魏",Font.BOLD,50));
			g.drawString("旅店管理联盟", 50, 70);
		}
		if(time==2)
		{
			for(int i=0;i<2;i++)
			{
				//g.setColor(new Color(r,z,b));
				g.drawString(A[i], x, y+i*30);
			}
		}else if(time==4)
			{
				for(int i=2;i<6;i++)
				{
				g.drawString(A[i],x, y+(i-2)*30);
				}
			}else if(time==6)
			{
				for(int i=6;i<11;i++)
				{
				g.drawString(A[i],x, y+(i-6)*30);
				}
			}else if(time==8)
			{
				g.setFont(new Font("华文新魏",Font.BOLD,50));
				g.drawString(A[11],400, 300);
			}else if(time==9)
			{
				g.setFont(new Font("华文新魏",Font.BOLD,50));
				g.drawString(A[12],460, 300);
			}else if(time==10)
			{
				g.setFont(new Font("华文新魏",Font.BOLD,50));
				g.drawString(A[13],520, 300);
			}
		g.setColor(new Color(62,188,202));
		g.drawLine(0, this.getHeight()-30, this.getWidth(),  this.getHeight()-30);
		g.fillRoundRect(-15, this.getHeight()-30, time*20+speed, 30, 30, 30);
		g.setColor(Color.white);
		g.drawRoundRect(-15, this.getHeight()-30+2, time*20+speed-5, 30-5, 30, 30);
		//g.draw3DRect(0, this.getHeight()-30, time*20+speed, 30,true);
		//g.fillRect(0, this.getHeight()-30, time*20+speed, 30);
		g.setColor(Color.black);
		g.setFont(new Font("华文新魏",Font.BOLD,40));
		for(int i=0;i<time*20+speed-25;i+=5)
		{
			g.setColor(Color.white);
			g.drawLine(i, this.getHeight()-28,i+5 , this.getHeight()-5);
		}
		g.setColor(Color.black);
		g.drawString("正在加载中", 250, this.getHeight()-5);
		//g.drawString(". . .",450,this.getHeight()-10);
		//g.drawRoundRect(100, 100, 100, 100, 10, 100);
		for(int i=0;i<dian;i++)
		{
			g.drawString(".", 450+dian*50, this.getHeight()-10);
			System.out.println(+dian);
		}
		//g.drawImage(imaglove, 50, 100, xr, yr, this);
		this.repaint();
	}
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			time++;
			if(time==4)x=x+40;
			if(time==6)x=x+40;
			speed+=25;
			//System.out.println("OK"+time);
			if(dian==3)
			{
				dian=0;
			}
			
		}
		
	}
}
