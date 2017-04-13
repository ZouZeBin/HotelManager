package hotel.dao;
/**
 * 客房表
 */
import hotel.model.KeFang;
import hotel.model.User;
import hotel.util.TimeUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KeFangDao {
	
	/**
	 * 更新客房状态
	 * @param con
	 * @param guestRoom
	 * @return
	 * @throws Exception
	 */
	public int updateState(Connection con,KeFang guestRoom) throws Exception{
		String sql = "update t_guestroom a set a.state = ? where a.num = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, guestRoom.getState());
		pstmt.setInt(2, guestRoom.getNum());
		return pstmt.executeUpdate();
	}
	/**
	 * 通过房间号查询客房是否存在/是否已入住
	 * @param con
	 * @param roomNum
	 * @return
	 * @throws SQLException
	 */
	public KeFang findByRoomNum(Connection con,int roomNum) throws SQLException{
		String sql = "select * from t_guestroom where num = ?";
		KeFang guestRoom = null;
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, roomNum);
		ResultSet resultSet = pstmt.executeQuery();
		if(resultSet.next()){
			guestRoom = new KeFang();//实例化用户对象
			guestRoom.setId(resultSet.getInt("id"));
			guestRoom.setNum(resultSet.getInt("num"));
			guestRoom.setState(resultSet.getInt("state"));
		}
		return guestRoom;
	}
	/**
	 * 添加房间信息
	 * @param con
	 * @param guestRoom
	 * @return
	 * @throws SQLException
	 */
	public int addGusteRoom(Connection con,KeFang guestRoom) throws SQLException{
		String sql = "insert into t_guestroom values(null,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, guestRoom.getNum());
		pstmt.setInt(2,guestRoom.getState());
		pstmt.setString(3, guestRoom.getType());
		return pstmt.executeUpdate();
	}
}
