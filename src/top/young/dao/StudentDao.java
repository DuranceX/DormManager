package top.young.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import top.young.model.Student;

public class StudentDao {
	/**
	 * 学生信息添加Dao
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Student student) throws Exception {
		String sql = "insert into student values(?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, student.getSno());
		pstmt.setString(2, student.getSname());
		pstmt.setString(3,student.getMno());
		pstmt.setString(4, student.getSclass());
		pstmt.setString(5, student.getSsex());
		return pstmt.executeUpdate();
	}
}
