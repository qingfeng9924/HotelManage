package com.maple;

public class Bomb {
	int x;
	int y;
	int time=15;
	public Bomb(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public void lifeDown()
	{
		time--;
	}
}
