package com.sqldb;

import java.sql.*;
import com.view.*;
import java.util.*;

//import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
public class Sqloperationroom {
    public Vector columnname,row;
    public static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String url="jdbc:sqlserver://localhost:1433;DatabaseName=HotelManage";
    public static String name="sa";
    public static String passwd="qingfeng";
	public static String sql="select * from roomtable";
	Connection ct=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
	public Sqloperationroom()
	{
		try {
			Class.forName(driver);
			ct=DriverManager.getConnection(url,name,passwd);
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			columnname=new Vector();
			columnname.add("房间号");
			columnname.add("房间类型");
			columnname.add("是否预订");
			columnname.add("价格");
			columnname.add("简介");
		    row=new Vector();
			while(rs.next())
			{
			    Vector	hang=new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));
				hang.add(rs.getString(5));
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
