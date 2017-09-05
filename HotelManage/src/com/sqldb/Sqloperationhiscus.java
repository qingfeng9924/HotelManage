package com.sqldb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class Sqloperationhiscus {
	  public Vector columnname,row;
	  public static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	  public static String url="jdbc:sqlserver://localhost:1433;DatabaseName=HotelManage";
	  public static String name="sa";
	  public static String passwd="qingfeng";
		public static String sql="select * from hiscustomer ";
		Connection ct=null;
	  PreparedStatement ps=null;
	  ResultSet rs=null;
		public Sqloperationhiscus()
		{
			try {
				Class.forName(driver);
				ct=DriverManager.getConnection(url,name,passwd);
				ps=ct.prepareStatement(sql);
				rs=ps.executeQuery();
				columnname=new Vector();
				columnname.add("客户ID");
				columnname.add("客户名字");
				columnname.add("入住时间");
				columnname.add("VIP");
			    row=new Vector();
				while(rs.next())
				{
				    Vector	hang=new Vector();
					hang.add(rs.getString(1));
					hang.add(rs.getString(2));
					hang.add(rs.getString(3));
					hang.add(rs.getString(4));
					//hang.add(rs.getString(5));
					row.add(hang);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
				
			}
		}
}