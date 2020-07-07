package top.young.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
