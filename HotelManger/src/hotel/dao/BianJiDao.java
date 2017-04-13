package hotel.dao;

import hotel.model.KeFang;
import hotel.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 查询编辑模块dao
 * @author Administrator
 *
 */
public class BianJiDao {
	/**
	 * 通过房间号查询房客信息
	 * @param con
	 * @param roomNum
	 * @return
	 * @throws SQLException 
	 */
	public ResultSet findTenantInfo(Connection con,String roomNum,String idNum,String name) throws SQLException{
		StringBuffer sql = new StringBuffer( "select * from t_household where 1 = 1");
		if(roomNum != null && !"".equals(roomNum)){
			sql.append(" and roomNum = '"+roomNum+"'");
		}
		if(idNum != null && !"".equals(idNum)){
			sql.append(" and idNum = '"+idNum+"'");
		}
		if(name != null && !"".equals(name)){
			sql.append(" and name = '"+name+"'");
		}
		System.out.println(sql.toString());
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		return pstmt.executeQuery();
		
	}
	/**
	 * 通过房间号查询客房状态
	 * @param con
	 * @param roomNum
	 * @return
	 * @throws SQLException
	 */
	public ResultSet findGuestRoomState(Connection con,String roomNum) throws SQLException{
		StringBuffer sql = new StringBuffer( "select * from t_guestroom where 1 = 1");
		if(roomNum != null && !"".equals(roomNum)){
			sql.append(" and num = '"+roomNum+"'");
		}
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		return pstmt.executeQuery();
	}
	/**
	 * 编辑客房信息
	 * @param con
	 * @param guestRoom
	 * @return
	 * @throws SQLException 
	 */
	public int updateGuestRoom(Connection con,KeFang guestRoom) throws SQLException{
		String sql = "update t_guestroom set num = ?,type = ?,state = ? where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, guestRoom.getNum());
		pstmt.setString(2, guestRoom.getType());
		pstmt.setInt(3, guestRoom.getState());
		pstmt.setInt(4, guestRoom.getId());
		return pstmt.executeUpdate();
	}
	/**
	 * 修改管理员资料
	 * @param con
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public int updateAdmin(Connection con,String password) throws SQLException{
		String sql = "update t_user set password = ? where userName = 'admin'";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, password);
		return pstmt.executeUpdate();
	}
	/**
	 * 查询旧密码
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public String oldPassword(Connection con) throws SQLException{
		String sql = "select * from t_user where userName = 'admin'";
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		ResultSet resultSet = pstmt.executeQuery();
		User user = new User();
		while(resultSet.next()){
			 user.setPassword(resultSet.getString("password"));
		}
			return user.getPassword();

	}
}
