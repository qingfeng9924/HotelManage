package com.maple;
import java.math.*;
import java.util.Vector;
public class Monster {
	int x;
	int y;
	int dir;
	
	boolean islive=true;
	public Monster(int x,int y,int dir)
	{
		this.x=x;
		this.y=y;
		this.dir=dir;
	}
}
class Monsterone extends Monster implements Runnable
{
     int lifeblood=100;
	public Monsterone(int x, int y, int dir) {
		super(x, y, dir);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
		try
		{
			Thread.sleep(200);
		}catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		switch(this.dir)
		{
		case 0:
			for(int i=0;i<15;i++)
			{
				try{
					Thread.sleep(200);
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				x-=4;
			}
			break;
		case 1:
			for(int i=0;i<15;i++)
			{
				try{
					Thread.sleep(200);
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				x+=4;
				if(x>1200)
				{
					x=1200;
				}
			}
			break;
		case 2:
			for(int i=0;i<15;i++)
			{
				try{
					Thread.sleep(200);
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				y-=4;
				if(y<300)
				{
					y=300;
				}
			}
			break;
		case 3:
			for(int i=0;i<15;i++)
			{
				try{
					Thread.sleep(100);
				}catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				y+=4;
				if(y>500)
				{
					y=500;
				}
			}
			break;
		}
		if(this.islive==false)
		{
			break;
		}
		this.dir=(int)(Math.random()*4);
		}
	}
	
	
}
class Bigboss extends Monster implements Runnable
{
	static int lifeblood;
	static int bigkill;
	static int num=0;
	int type=0;
	boolean islive=true;
	Vector<Evilbeam> ebv=new Vector<Evilbeam>();

	public Bigboss(int x, int y, int dir) {
		super(x, y, dir);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try
			{
				Thread.sleep(200);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			Evilbeam eb=null;
			switch(this.dir)
			{
			case 0:
				for(int i=0;i<15;i++)
				{
					try{
						Thread.sleep(200);
					}catch(InterruptedException e)
					{
						e.printStackTrace();
					}
					x-=4;
				}
				eb=new Evilbeam(this.x,this.y+50,0);
				ebv.addElement(eb);
				break;
			case 1:
				for(int i=0;i<15;i++)
				{
					try{
						Thread.sleep(200);
					}catch(InterruptedException e)
					{
						e.printStackTrace();
					}
					x+=4;
					if(x>1200)
					{
						x=1200;
					}
				}
				eb=new Evilbeam(this.x,this.y+50,0);
				ebv.addElement(eb);
				break;
			case 2:
				for(int i=0;i<15;i++)
				{
					try{
						Thread.sleep(200);
					}catch(InterruptedException e)
					{
						e.printStackTrace();
					}
					y-=4;
					if(y<300)
					{
						y=300;
					}
				}
				break;
			case 3:
				for(int i=0;i<15;i++)
				{
					try{
						Thread.sleep(100);
					}catch(InterruptedException e)
					{
						e.printStackTrace();
					}
					y+=4;
					if(y>500)
					{
						y=500;
					}
				}
				break;
			}
			if(this.islive==false)
			{
				break;
			}
			this.dir=(int)(Math.random()*4);
			Thread t=new Thread(eb);
			t.start();
			}
		}
}
class Evilbeam implements Runnable
{
	int x;
	int y;
	int dir;
	boolean islive=true;
	public Evilbeam(int x,int y,int dir)
	{
		this.x=x;
		this.y=y;
		this.dir=dir;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try{
				Thread.sleep(50);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			switch(this.dir)
			{
			case 0:
				x-=9;;
			
				break;
		
			}
			if(this.x<0||this.x>1200)
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
