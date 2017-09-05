package com.sqldb;
import java.sql.*;
import com.view.*;
import java.util.*;

//import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
public class Sqloperation {
    public Vector columnname,row;
    public static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String url="jdbc:sqlserver://localhost:1433;DatabaseName=HotelManage";
    public static String name="sa";
    public static String passwd="qingfeng";
	public static String sql="select * from logintable";
	Connection ct=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
	public Sqloperation()
	{
		try {
			Class.forName(driver);
			ct=DriverManager.getConnection(url,name,passwd);
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			columnname=new Vector();
			columnname.add("员工号");
			columnname.add("姓名");
			columnname.add("性别");
			columnname.add("年龄");
			columnname.add("职位");
			columnname.add("薪水");
			columnname.add("headplace");
			
		    row=new Vector();
			while(rs.next())
			{
			    Vector	hang=new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				hang.add(rs.getString(7));
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
//	public void loginconfer()
//	{
//		try {
//			Class.forName(driver);
//			ct=DriverManager.getConnection(url,name,passwd);
//			ps=ct.prepareStatement(sql);
//			rs=ps.executeQuery();
//			while(rs.next())
//			{
//				String tempid=rs.getString(1);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}

}
