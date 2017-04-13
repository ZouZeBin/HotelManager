package hotel.util;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 * 数据库连接工具类
 * @author Administrator
 *
 */
public class DbUtil {
	/**
	 * 数据库地址
	 */
	private String dbUrl="jdbc:mysql://localhost:3306/db_hotel?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
	/**
	 * 数据库登录名
	 */
	private String dbUserName="root";
	/**
	 * 数据库密码
	 */
	private String dbPassword="root";
	/**
	 * mysql 驱动
	 */
	private String jdbcName="com.mysql.jdbc.Driver";
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		return con;
	}
	
	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con) throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("连接成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
