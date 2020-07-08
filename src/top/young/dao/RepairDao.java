package top.young.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import top.young.model.Repair;

public class RepairDao {
	public int add(Connection con,Repair repair) throws SQLException {
		String sql = "insert into repair values(null,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, repair.getAno());
		pstmt.setString(2, repair.getBno());
		pstmt.setString(3, repair.getDno());
		pstmt.setString(4, repair.getSubmittime());
		pstmt.setString(5, repair.getRreason());
		return pstmt.executeUpdate();
	}
	public ResultSet list(Connection con) throws Exception {
		String sql = "select * from repair";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	public int delete(Connection con,String id) throws Exception {
		String sql = "delete from repair where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,id);
		return pstmt.executeUpdate();
	}
}
