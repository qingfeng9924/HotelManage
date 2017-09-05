package com.maple;

public class Recored {

	static int fireclass=5;
	static int ex=0;
	static int rank=1;
	static int lifeblood=100;
	static int power=100;
	static int moonlightknife=0;
	public static int getPower() {
		return power;
	}
	public static void setPower(int power) {
		power = power;
	}
	public static int getEx() {
		return ex;
	}
	public static void setEx(int ex) {
		Recored.ex = ex;
	}
	public static int getRank() {
		return rank;
	}
	public static void setRank(int rank) {
		Recored.rank = rank;
	}
	public static int getLifeblood() {
		return lifeblood;
	}
	public static void setLifeblood(int lifeblood) {
		Recored.lifeblood = lifeblood;
	}
	public static void update()
	{
		if(ex>100)
		{
			rank++;
			ex=0;
		}
		if(power>100)
		{
			moonlightknife++;
			power=0;
		}
	}
	
}
