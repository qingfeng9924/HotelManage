package com.maple;

import javax.swing.*;

import com.sun.prism.impl.Disposer.Record;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Maple extends JFrame implements ActionListener{
	JMenuBar jmb=null;
	JMenu jm=null;
	JMenuItem jmi1=null;
	JMenuItem jmi_exit=null;
	
	StartPanel sp=null;
	GamePanel gp=null;
	public Maple()
	{
		jmi_exit=new JMenuItem("退出");
		jmi_exit.setBackground(Color.cyan);
		jmi_exit.setActionCommand("exit");
		jmi_exit.addActionListener(this);
		jmb=new JMenuBar();
		jm=new JMenu("游戏");
		jmi1=new JMenuItem("Start");
		jmi1.setActionCommand("Start");
		jmi1.addActionListener(this);
		sp=new StartPanel();
		sp.add(jmi1);
		jm.add(jmi1);
		jmb.add(jm);
		jm.add(jmi_exit);
		this.setUndecorated(true);
		this.setResizable(false);
		this.setJMenuBar(jmb);
		this.add(sp);
		this.setSize(1150,700);
		this.setLocation(205,100);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		//this.repaint();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("exit"))
		{
			this.dispose();
			
		}
		if(arg0.getActionCommand().equals("Start"))
		{
			gp=new GamePanel();
			this.remove(sp);
			Thread t=new Thread(gp);
			t.start();
			this.add(gp);
			this.addKeyListener(gp);
			System.out.println("OK");
			this.setSize(1150,700);
			this.setLocation(205,100);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
			
		}
		
	}

}
class StartPanel extends JPanel
{
	Image imag1=null;
	public StartPanel()
	{
		imag1=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_01.jpg"));
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(imag1, 0,0,1200, 600, this);
		Font myfont =new Font("宋体",Font.BOLD,30);
		g.setColor(Color.yellow);
		g.setFont(myfont);
		g.drawString("Maple Story", 300, 0);
	}
}
class GamePanel extends JPanel implements KeyListener,Runnable
{
	int direct=1;
	Image imagmap=null;
	Image imagR1=null;
	Image imagR2=null;
	Image imagR3=null;
	Image imagR4=null;
	Image imagL1=null;
	Image imagL2=null;
	Image imagL3=null;
	Image imagL4=null;
	Image imagU1=null;
	Image imagU2=null;
	Image imagD1=null;
	Image imagD2=null;
	Image imagmone=null;
	Image imagf1=null;
	Image imagf2=null;
	Image imagf3=null;
	Image imagf4=null;
	Image imags=null;
	Image imagf5=null;
	Image imaghead=null;
	Image imagms3=null;
	Image imagb1=null;
	Image imagb2=null;
	Image imagb3=null;
	Image imags1=null;
	Image imagf5l=null;
	Image imageb1=null;
	Image imagms7=null;
	static int imagmapx=0;
	static int imagmapy=0;
	Role rl=null;
	Beam beam=null;
	Vector<Monsterone> mv=new Vector<Monsterone>();
	Vector<Beam> beamv=new Vector<Beam>();
	Vector<Beam> shotv=new Vector<Beam>();
	Vector<Bigboss> bbv=new Vector<Bigboss>();
	Vector<Bomb> bmv=new Vector<Bomb>();
	//Vector<Evilbeam> ebmv=new Vector<Evilbeam>();
	//Monsterone mone=null;
	public GamePanel()
	{
		imagmap=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_Map2.jpg"));
		imagR1=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_1.gif"));
		imagR2=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_2.gif"));
		imagR3=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_3.gif"));
		imagR4=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_4.gif"));
		imagL1=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_5.gif"));
		imagL2=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_6.gif"));
		imagL3=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_7.gif"));
		imagL4=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_8.gif"));
		imagmone=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_MS_5.gif"));
		imagf1=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_fight1_1.gif"));
		imagf2=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_fight1_2 .gif"));
		imagf3=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_fight1_3.gif"));
		imagf4=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_fight1_4.gif"));
		imags=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_Sj.gif"));
		imagf5=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_fight5.gif"));
		imagf5l=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_fight5l.gif"));
		imagb1=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_bb_1.gif"));
		imagb2=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_bb_2.gif"));
		imagb3=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_bb_3.gif"));
		imags1=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_shot_1.gif"));
		imageb1=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_MS_eb1.gif"));
		imagms3=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_MS_3.gif"));
		imagms7=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_MS_7.gif"));

		imaghead=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_play.gif"));
		for(int i=0;i<20;i++)
		{
			Monsterone m=new Monsterone(800,40*i+300,1);
			Thread t=new Thread(m);
			t.start();
			mv.add(m);
		}
		/*
		imagU1=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_9.gif"));
		imagU2=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_0U1.gif"));
		imagD1=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_9.gif"));
		imagD2=Toolkit.getDefaultToolkit().getImage(JPanel.class.getResource("/Bump_0D1.gif"));
		*/
		rl=new Role(12,350,1,12,350);
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(imagmap, imagmapx, imagmapy,12000,600, this);
		this.drawRole(rl, g);
		this.drawmonsterone(g);
		this.drawbeam(g);
		this.drawshot(g);
		this.drawbigboss(g);
		this.draweb(g);
		Font myfont=new Font("楷书",Font.BOLD,20);
		g.setFont(myfont);
		//显示角色头像
		g.drawImage(imaghead, 400, 0,100,100,this );
		//显示人物当前等级
		g.setColor(Color.black);
		g.drawString("等级   :",500,20);
		g.drawString(Recored.rank+"", 600, 20);
		//显示人物当前任务经验
		g.drawString("经验值:",500,50);
		g.setColor(Color.blue);
		g.drawRect(580, 30, 200, 22);
		g.fillRect(580, 30, Recored.ex, 22);
		//显示人物当前生命值
		g.setColor(Color.red);
		g.drawString("生命值:",500,80);
		g.setColor(Color.yellow);
		g.drawRect(580, 60, 200, 22);
		g.fillRect(580, 60, Recored.lifeblood, 22);
		//显示当前任务能量和大招数量
		g.setColor(Color.BLACK);
		g.drawString("能量   :", 500, 110);
		g.drawRect(580, 90, 200, 22);
		g.fillRect(580, 90, Recored.power,23);
		if(bmv.size()>0)
		{
			this.drawbomb(g);
			System.out.println("爆炸了");
		}
		this.repaint();
	}
	public void drawbomb(Graphics g)
	{
		for(int i=0;i<bmv.size();i++)
		{
			Bomb bm=bmv.get(i);
			if(bm.time>10)
			{
				g.drawImage(imagb1, bm.x, bm.y, 200,200,this);
			}
			else if(bm.time<11&&bm.time>5)
			{
				g.drawImage(imagb2, bm.x, bm.y, 150,200,this);
			}
			else if(bm.time<6&&bm.time>0)
			{
				g.drawImage(imagb3, bm.x, bm.y, 50,50,this);
				System.out.println("nihao"+bm.x+bm.y);
			}
			else if(bm.time==0)
			{
				bmv.remove(i);
			}
			/*
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			bm.lifeDown();
			if(bm.time==0)
			{
				bmv.remove(i);
			}
		}
	}
	public void drawbigboss(Graphics g)
	{
		Bigboss temp=null;
		if(bbv.size()>0)
		{
			for(int i=0;i<bbv.size();i++)
			{
				
				temp=(Bigboss) bbv.get(i);
				if(temp.islive==true&&temp.type==0)
				{
				g.drawImage(imagms3, temp.x, temp.y, 200,200,this);
				g.setColor(Color.yellow);
				g.fillRect(temp.x, temp.y-10, temp.lifeblood, 10);
				}
				if(temp.islive==true&&temp.type==1)
				{
				g.drawImage(imagms7, temp.x, temp.y, 200,200,this);
				g.setColor(Color.yellow);
				g.fillRect(temp.x, temp.y-10, temp.lifeblood, 10);
				}
				if(temp.islive==false)
				{
					bbv.remove(i);
				}
			}
		}
	}
	public void drawmonsterone(Graphics g)
	{
		    Monsterone mone=null;
		    for(int i=0;i<mv.size();i++)
			{
			mone=(Monsterone) mv.get(i);
			if(mone.islive==true)
			{
			g.setColor(Color.red);
			g.fillRect(mone.x,mone.y-10,mone.lifeblood,10);
			g.drawImage(imagmone, mone.x,mone.y,100,100,this);
			}
			if(mone.islive==false)
			{
				mv.remove(i);
			}
			}
	}
	public void shot()
	{
		switch(rl.dir)
		{
		case 1:
		beam=new Beam(rl.x+105,rl.y+50,rl.dir);
		Thread t=new Thread(beam);
		t.start();
		shotv.add(beam);
		break;
		case 0:
			beam=new Beam(rl.x,rl.y+50,rl.dir);
			Thread s=new Thread(beam);
			s.start();
			shotv.add(beam);
			break;
		}
	}
	public void appearbigboss()
	{
		Bigboss bb=null;
		Bigboss b1=null;
		Bigboss b2=null;
		Bigboss b3=null;
		if(Recored.rank==3&&bb.num==0)
		{
			bb=new Bigboss(500,300,1);
			bb.num++;
			bb.lifeblood=1000;
			bb.bigkill=2;
			bb.type=0;
			Thread t=new Thread(bb);
			t.start();
			bbv.add(bb);
		}
		if(imagmapx<-2000&&bb.num<3)
		{
			b1=new Bigboss(500,300,1);
			b2=new Bigboss(500,300,1);
			b3=new Bigboss(500,300,1);
			b1.type=1;
			b1.lifeblood=1000;
			b1.bigkill=2;
			b2.type=1;
			b2.lifeblood=1000;
			b2.bigkill=2;
			b2.type=1;
			b3.type=1;
			b3.lifeblood=1000;
			b3.bigkill=2;
			bbv.add(b3);
			bbv.add(b2);
			bbv.add(b1);
			Thread t1=new Thread(b1);
			t1.start();
			Thread t2=new Thread(b2);
			t2.start();
			Thread t3=new Thread(b3);
			t3.start();
			bb.num+=3;
			
			
			
		}
	}
	public void monstermoveL()
	{
		Monsterone mone=null;
		for(int i=0;i<mv.size();i++)
		{
			mone=(Monsterone) mv.get(i);
			mone.x-=9;
			Monsterone temp=null;
			temp=mone;
			mv.set(i, temp);
			//System.out.println(""+temp.x);
		}
		Bigboss bb=null;
		for(int j=0;j<bbv.size();j++)
		{
			bb=bbv.get(j);
			bb.x-=9;
			Bigboss temp=null;
			temp=bb;
			bbv.set(j, temp);
		}
	}
	public void monstermoveR()
	{
		Monsterone mone=null;
		for(int i=0;i<mv.size();i++)
		{
			mone=(Monsterone) mv.get(i);
			mone.x+=9;
			Monsterone temp=null;
			temp=mone;
			mv.set(i, temp);
			System.out.println(""+temp.x);
		}
		Bigboss bb=null;
		for(int j=0;j<bbv.size();j++)
		{
			bb=bbv.get(j);
			bb.x+=9;
			Bigboss temp=null;
			temp=bb;
			bbv.set(j, temp);
			
		}
	}
	public void monsteroneislive()
	{
		Beam b=null;
		Beam bk=null;
		for(int k=0;k<beamv.size();k++)
		{
		bk=(Beam) beamv.get(k);
		if(bk.islive==true)
		{
			Monsterone mone=null;
			for(int n=0;n<mv.size();n++)
			{
				mone=(Monsterone) mv.get(n);
				if(mone.x>bk.x&&mone.x<bk.x+100&&mone.y>bk.y&&mone.y<bk.y+100)
				{
					if(mone.lifeblood==0||mone.lifeblood<0)
					{
					mone.islive=false;
					}
					mone.lifeblood-=100;
				}
			}
		}
			
		}
		for(int i=0;i<shotv.size();i++)
		{
			b=(Beam) shotv.get(i);
			if(b.islive==true)
			{
				Monsterone mone=null;
				for(int j=0;j<mv.size();j++)
				{
					mone=(Monsterone) mv.get(j);
					if(b.x>mone.x&&b.x<mone.x+90&&b.y>mone.y&&b.y<mone.y+90)
					{
						mone.lifeblood-=10;
						b.islive=false;
						if(mone.lifeblood==0||mone.lifeblood<0)
						{
							mone.islive=false;
							Recored.ex+=20;
							Recored.power+=20;
						}
					}
				}
			}
		}
	}
	public void drawshot(Graphics g)
	{
		Beam temp=null;
		for(int i=0;i<shotv.size();i++)
		{
			temp=(Beam) shotv.get(i);
			if(Recored.fireclass==5)
			{
			if(temp.islive==true)
			{
			g.drawImage(imags, temp.x, temp.y, 20,20,this);
			}
			}
			if(Recored.fireclass==4)
			{
				if(temp.islive==true)
				{
				g.drawImage(imags1, temp.x, temp.y, 20,20,this);
				}
			}
			if(temp.islive==false)
			{
				shotv.remove(i);
			}
		}
	}
	public void keya()
	{
		if(rl.x>13)
		{
		this.direct=0;
		this.rl.dir=0;
		this.rl.moveL();
		rl.rolx-=9;
		}
		if(rl.x<13)
		{
			rl.rolx-=9;
			imagmapx+=9;
			rl.x=12;
		}
		if(rl.rolx>12&&rl.x<13)
		{
			this.monstermoveR();
		}
		if(rl.rolx<12)
		{
			rl.rolx=12;
			imagmapx=0;
		}
	}
	public void keyj()
	{
		if(rl.dir==0){
			this.shot();
			this.direct=5;
			}
			if(rl.dir==1){
			this.shot();
			this.direct=5;
			}
	}
	public void keyk()
	{
		if(Recored.moonlightknife>0){
			if(rl.dir==0){
				this.direct=4;
			    this.playbeam();
			}
			if(rl.dir==1){
				this.direct=4;
				this.playbeam();
			}
			Recored.moonlightknife--;
			}
	}
	public void keyw()
	{
		if(rl.y>280)
		{
		if(rl.dir==1)
		{
		System.out.println(rl.dir);
		this.direct=3;
		rl.y=rl.y-5;
		}
		if(rl.dir==0)
		{
		System.out.println(rl.dir);
		this.direct=3;
		rl.y=rl.y-5;
		}
		}
		if(rl.y<300||rl.y==300)
		{
			rl.y=305;
		}
	}
	public void keys()
	{
		if(rl.y+170<600)
		{
			if(rl.y>300&&rl.y<600)
			{
				if(rl.dir==1)
				{
	//System.out.println(rl.dir);
					this.direct=3;
					rl.y=rl.y+5;
					}
				if(rl.dir==0)
				{
	//System.out.println(rl.dir);
					this.direct=3;
					rl.y=rl.y+5;
					}
				}
			}
		if(rl.y+170>600||rl.y+170==600)
		{
			rl.y=430;
		}
	}
	public void keyd()
	{
		this.direct=1;
		if(rl.x<800)
		{
		this.rl.dir=1;
		this.rl.moveR();
		rl.rolx+=9;
		}
		if(rl.x>800)
		{
			this.rl.dir=1;
			//this.rl.moveL();;
			rl.rolx+=9;
			imagmapx-=9;
			this.monstermoveL();
		}
	}
	
	public void bigbossislive()
	{
		Beam b=null;
		Beam b1=null;
		for(int k=0;k<beamv.size();k++)
		{
			b1=beamv.get(k);
			if(b1.islive==true)
			{
				Bigboss bs=null;
				for(int n=0;n<bbv.size();n++)
				{
					bs = bbv.get(n);
					if(b1.x>bs.x&&b1.x<bs.x+200&&b1.y>bs.y&&b1.y<bs.y+200)
					{
					    Bigboss.lifeblood-=30;
					    //System.out.println(Bigboss.lifeblood);
					}
					if(Bigboss.lifeblood==0||bs.lifeblood<0)
					{
						bs.islive=false;
						Bomb bm1=new Bomb(bs.x,bs.y);
						bmv.add(bm1);
						
					}
			}
		}
		}
		for(int i=0;i<shotv.size();i++)
		{
			b=shotv.get(i);
			if(b.islive==true)
			{
				Bigboss bb=null;
				for(int j=0;j<bbv.size();j++)
				{
					bb=bbv.get(j);
					if(b.x>bb.x&&b.x<bb.x+200&&b.y>bb.y&&b.y<bb.y+200)
					{
						b.islive=false;
					    bb.lifeblood--;
					    //System.out.println(bb.lifeblood);
					}
					if(bb.lifeblood==0||bb.lifeblood<0)
					{
						bb.islive=false;
						Bomb bm1=new Bomb(bb.x,bb.y);
						bmv.add(bm1);
						
					}
				}
			}
			
		}	
	}
	public void playbeam()
	{
		beam=new Beam(rl.x+5,rl.y+50,rl.dir);
		Thread t=new Thread(beam);
		t.start();
		System.out.println("技能线程启动");
		beamv.add(beam);
	}
	public void drawbeam(Graphics g)
	{
		Beam temp;
		for(int i=0;i<beamv.size();i++)
		{
			temp=(Beam) beamv.get(i);
			if(temp.islive==true)
			{
			switch(temp.dir)
			{
			case 0:
				g.drawImage(imagf3, temp.x, temp.y, 50,100,this);
				break;
			case 1:
				g.drawImage(imagf2, temp.x+100, temp.y, 50,100,this);
				break;
			}
			}
			this.repaint();
		}
	}
	public void draweb(Graphics g)
	{
		Bigboss bb=null;
		for(int i=0;i<bbv.size();i++)
		{
			bb=bbv.get(i);
			if(bb.islive==true)
			{
				Evilbeam eb=null;
				for(int j=0;j<bb.ebv.size();j++)
				{
					eb=bb.ebv.get(j);
					if(eb.islive==true)
					{
					g.drawImage(imageb1, eb.x, eb.y, 100,50,this);
					}
					if(eb.islive==false)
					{
						bb.ebv.remove(j);
					}
				}
			}
		}
	}
	public void drawRole(Role rl,Graphics g)
	{
		switch(rl.dir)
		{
		case 0:
			if(this.direct==0)
				{
				if(rl.rolx%4==0)
					g.drawImage(imagL1, rl.x,rl.y-10,120,120,this);
				if(rl.rolx%4==1)
					g.drawImage(imagL2, rl.x,rl.y-10,110,120,this);
				if(rl.rolx%4==2)
					g.drawImage(imagL3, rl.x,rl.y-10,120,120,this);
				if(rl.rolx%4==3)
					g.drawImage(imagL4, rl.x,rl.y-10,120,120,this);
				}
			if(this.direct==2)
			{
			if(rl.y%2==0)
				g.drawImage(imagL1, rl.x,rl.y,120,120,this);
			if(rl.y%2==1)
				g.drawImage(imagL2, rl.x,rl.y,120,120,this);
			}
			if(direct==3)
			{
			if(rl.y%2==0)
				g.drawImage(imagL1, rl.x,rl.y,120,120,this);
			if(rl.y%2==1)
				g.drawImage(imagL2, rl.x,rl.y,120,120,this);
			}
			if(direct==4)
			{
				g.drawImage(imagf4,  rl.x, rl.y+20, 120,100,this);
			}
			if(direct==5)
			{
				g.drawImage(imagf5l, rl.x, rl.y+20, 80,100,this);
			}
			break;
		case 1:
			if(this.direct==1)
			{
				if(rl.rolx%4==0)
					g.drawImage(imagR1, rl.x,rl.y,100,100,this);
				if(rl.rolx%4==1)
					g.drawImage(imagR2, rl.x,rl.y,100,100,this);
				if(rl.rolx%4==2)
					g.drawImage(imagR3, rl.x,rl.y,100,100,this);
				if(rl.rolx%4==3)
					g.drawImage(imagR4, rl.x,rl.y,100,102,this);
			}
			if(this.direct==2)
			{
			if(rl.y%2==0)
				g.drawImage(imagR2, rl.x,rl.y,100,100,this);
			if(rl.y%2==1)
				g.drawImage(imagR3, rl.x,rl.y,100,100,this);
			}
			if(direct==3)
			{
			if(rl.y%2==0)
				g.drawImage(imagR2, rl.x,rl.y,100,100,this);
			if(rl.y%2==1)
				g.drawImage(imagR3, rl.x,rl.y,100,100,this);
			}
			if(direct==4)
			{
				g.drawImage(imagf1, rl.x, rl.y+20, 120,80,this);
			}
			if(direct==5)
			{
				g.drawImage(imagf5, rl.x, rl.y+20, 100,100,this);
			}
			break;
		}
	}
	
	public void changefire()
	{
		if(Recored.rank<3)
		{
			Recored.fireclass=5;
		}
		if(Recored.rank>2)
		{
			Recored.fireclass=4;
		}
	}
public void keyPressed(KeyEvent E) {
	// TODO Auto-generated method stub
	if(E.getKeyCode()==KeyEvent.VK_D)
	{
		//System.out.println("你好");
		this.keyd();
		System.out.println(+imagmapx);
	}
	if(E.getKeyCode()==KeyEvent.VK_A)
	{
		//if(rl.rolx<9&&rl.rolx==9)
		//{
		//	rl.rolx=9;
		//}
		this.keya();
		
	}
	if(E.getKeyCode()==KeyEvent.VK_W)
	{
		this.keyw();
	}
	if(E.getKeyCode()==KeyEvent.VK_S)
	{
		this.keys();
		
		}
	if(E.getKeyCode()==KeyEvent.VK_J)
	{
		this.keyj();
	}
	if(E.getKeyCode()==KeyEvent.VK_K)
	{
		this.keyk();
	}
	this.repaint();
}
@Override
public void keyReleased(KeyEvent E) {
	// TODO Auto-generated method stub
	if(E.getKeyCode()==KeyEvent.VK_K)
	{
		if(rl.dir==0)
			this.direct=0;
		if(rl.dir==1)
			this.direct=1;
	}
	if(E.getKeyCode()==KeyEvent.VK_J)
	{
		if(rl.dir==0)
			this.direct=0;
		if(rl.dir==1)
			this.direct=1;
	}
	
}
@Override
public void keyTyped(KeyEvent E) {
	// TODO Auto-generated method stub	
}
@Override
public void run() {
	// TODO Auto-generated method stub
	while(true)
	{
		try{
			Thread.sleep(200);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		Recored.update();
		this.changefire();
		this.bigbossislive();
		this.appearbigboss();
		this.monsteroneislive();
		this.repaint();
	}
	
}
}