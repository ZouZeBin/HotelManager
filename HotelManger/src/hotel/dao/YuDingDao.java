package hotel.dao;

import hotel.model.YuDing;
import hotel.util.TimeUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 预订管理dao
 * @author Administrator
 *
 */
public class YuDingDao {
	
	/**
	 * 添加预订信息
	 * @param con
	 * @param book
	 * @return
	 * @throws SQLException
	 */
	public int addBook(Connection con,YuDing book) throws SQLException{
		String sql = "insert into t_book values(null,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getName());
		pstmt.setString(2,book.getPhone());
		pstmt.setString(3, book.getCheckTime());
		pstmt.setString(4, TimeUtil.formatTime());
		pstmt.setString(5, book.getState());
		return pstmt.executeUpdate();
	}
	/**
	 * 查询预订信息
	 * @param con
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public ResultSet findUsInfo(Connection con,String name) throws SQLException{
		StringBuffer sql = new StringBuffer( "select * from t_book where 1 = 1");
		if(name != null && !"".equals(name)){
			sql.append(" and name = '"+name+"'");
		}
		PreparedStatement pstmt = con.prepareStatement(sql.toString());
		return pstmt.executeQuery();
		
	}
	/**
	 * 更新预订状态
	 * @return
	 * @throws SQLException 
	 */
	public int uodateUsState(Connection con,int id) throws SQLException{
		String sql = "update t_book set state = '已退订' where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		return pstmt.executeUpdate();
		
	}
}
