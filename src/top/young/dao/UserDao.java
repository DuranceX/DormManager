package top.young.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import top.young.model.User;

public class UserDao {
	/**
	 * 用户登录
	 * @param con
	 * @param user
	 * @return
	 * @throws SQLException 
	 */
	public User login(Connection con, User user) throws SQLException {
		User resultUser = null;
		String sql = "select * from User where username=? and password=? and identity=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, String.valueOf(user.getIdentity()));
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			resultUser = new User();
			resultUser.setUsername(rs.getString("username"));
			resultUser.setPassword(rs.getString("password"));
			resultUser.setIdentity(Integer.parseInt(rs.getString("identity")));
		}
		return resultUser;
	}
	/**
	 * 用户注册Dao
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int addUser(Connection con, User user) throws Exception {
		String sql = "insert into User values(null,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUsername());
		pstmt.setString(2,user.getPassword());
		pstmt.setInt(3,user.getIdentity());
		return pstmt.executeUpdate();
	}
}
