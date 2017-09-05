package com.maple;

class Role
{
	int rolx;
	int roly;
	int x;
	int y;
	int dir;
	public Role(int x,int y,int dir,int rolx,int roly)
	{
		this.x=x;
		this.y=y;
		this.dir=dir;
		this.rolx=rolx;
		this.roly=roly;
	}
	public void moveR()
	{
		x+=9;
	}
	public void moveL()
	{
		x-=9;
	}
}
/*
 * 人物技能：光照J
 */
class Beam implements Runnable
{
	int x;
	int y;
	int dir;
	boolean islive=true;
	public Beam(int x,int y,int dir )
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
			case 1:
				x+=9;
				break;
			}
			if(this.x<0||this.x>1200)
			{
				this.islive=false;
			}
			if(this.islive==false)
			{
				System.out.println("线程死亡");
				break;
			}
		}
		
	}
}