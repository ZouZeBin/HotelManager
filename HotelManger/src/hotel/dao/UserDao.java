package hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import hotel.model.User;

/**
 * 用户dao层
 * @author Administrator
 *
 */
public class UserDao {
	
	/**
	 * 用户登陆验证
	 * @param conn
	 * @param user 传入user对象
	 * @return
	 * @throws Exception
	 */
	public User login(Connection conn,User user) throws Exception{
		User resUser = null;
		String sql = "select * from t_user where userName = ? and password = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);//预编译sql
		//传入参数 userName用户名 1   password登陆密码 2
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		ResultSet re = pstmt.executeQuery();
		if(re.next()){
			resUser = new User();//实例化用户对象
			resUser.setUserName(re.getString("userName"));
			resUser.setPassword(re.getString("password"));
		}
		return resUser;
	}
}
