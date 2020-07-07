package top.young.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import top.young.model.Student;
import top.young.util.StringUtil;

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
		pstmt.setString(4, student.getCcno());
		pstmt.setString(5, student.getSsex());
		return pstmt.executeUpdate();
	}
	/**
	 * 学生信息查询(根据学号查询
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, String sno) throws Exception {
		String sql = "select * from student where sno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, sno);
		return pstmt.executeQuery();
	}
	public ResultSet list(Connection con) throws Exception {
		String sql = "select * from student";
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
	/**
	 * 学生信息删除（根据学号删除
	 * @param con
	 * @param sno
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String sno) throws Exception {
		String sql = "delete from student where sno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, sno);
		return pstmt.executeUpdate();
	}
	/**
	 * 根据学号修改学生信息
	 * @param con
	 * @param student
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,Student student) throws Exception {
		String sql = "update student set Sname=?,Mno=?,Ccno=?,Ssex=? where Sno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,student.getSname());
		pstmt.setString(2,student.getMno());
		pstmt.setString(3,student.getCcno());
		pstmt.setString(4,student.getSsex());
		pstmt.setString(5,student.getSno());
		return pstmt.executeUpdate();
	}
}
