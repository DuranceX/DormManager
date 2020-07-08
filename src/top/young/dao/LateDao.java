package top.young.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import top.young.model.Late;

public class LateDao {
	public int add(Connection con,Late late) throws Exception {
		String sql = "insert into Late values(?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, late.getAno());
		pstmt.setString(2, late.getBno());
		pstmt.setString(3, late.getDno());
		pstmt.setString(4, late.getSno());
		pstmt.setString(5,late.getLtime());
		pstmt.setString(6, late.getLreason());
		return pstmt.executeUpdate();
	}
	/**
	 * 根据学号进行查询
	 * @param con
	 * @param sno
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, String sno) throws Exception {
		String sql  = "select * from late where sno = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, sno);
		return pstmt.executeQuery();
	}
	public ResultSet list(Connection con) throws Exception {
		String sql  = "select * from late";
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
	/**
	 * 根据日期进行查询
	 * @param con
	 * @param data
	 * @param flag
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, String date,int flag) throws Exception {
		String sql = "select * from late where ltime = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, date);
		return pstmt.executeQuery();
	}
}
