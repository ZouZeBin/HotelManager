package hotel.dao;

import hotel.model.ZhuHu;
import hotel.util.TimeUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RuZhuDao {
	
	/**
	 * 添加入住信息
	 * @param con
	 * @param household 对象参数
	 * @return
	 * @throws Exception
	 */
	public int addHousehold(Connection con,ZhuHu household) throws Exception{
		String sql = "insert into t_household values(null,?,?,?,?,?,?,null)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, household.getName());
		pstmt.setString(2,household.getIdNum());
		pstmt.setString(3, TimeUtil.formatTime());
		pstmt.setInt(4, household.getRoomNum());
		pstmt.setInt(5, household.getMoney());
		pstmt.setString(6, household.getState());
		return pstmt.executeUpdate();
	}
	/**
	 * 查询所有住户信息
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getGuestRoom(Connection con,String name) throws SQLException{
		StringBuffer sb = new StringBuffer("select * from t_household where state = '入住中'");
		if(name != null || "".equals(name)){
			sb.append(" and name like '%"+name+"%'");
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	/**
	 * 更新入住信息
	 * @param con
	 * @param roomNum
	 * @return
	 * @throws SQLException
	 */
	public int updateGuestRoom(Connection con,int id) throws SQLException{
		String sql = "update t_household set state = ?,outTime = ? where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "已退房");
		pstmt.setString(2, TimeUtil.formatTime());
		pstmt.setInt(3, id);
		return pstmt.executeUpdate();
	}
}
