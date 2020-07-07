package top.young.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import top.young.model.Accommodation;

public class AccommodationDao {
	/**
	 * 住宿信息添加Dao
	 * @param con
	 * @param Accommodation
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Accommodation accommodation) throws Exception {
		String sql = "insert into Accommodation values(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, accommodation.getSno());
		pstmt.setString(2, accommodation.getAno());
		pstmt.setString(3,accommodation.getBno());
		pstmt.setString(4, accommodation.getDno());
		return pstmt.executeUpdate();
	}
	/**
	 * 住宿信息查询(根据学号查询
	 * @param con
	 * @param Accommodation
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, String sno) throws Exception {
		String sql = "select * from Accommodation,cclass,major where sno=? and Accommodation.mno = major.mno and Accommodation.ccno=cclass.ccno";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, sno);
		return pstmt.executeQuery();
	}
	public ResultSet list(Connection con) throws Exception {
		String sql = "select * from Accommodation,cclass,major where Accommodation.mno = major.mno and Accommodation.ccno=cclass.ccno";
		PreparedStatement pstmt = con.prepareStatement(sql);
		return pstmt.executeQuery();
	}
	/**
	 * 住宿信息删除（根据学号删除
	 * @param con
	 * @param sno
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String sno) throws Exception {
		String sql = "delete from Accommodation where sno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, sno);
		return pstmt.executeUpdate();
	}
	/**
	 * 根据学号修改学生信息
	 * @param con
	 * @param Accommodation
	 * @return
	 * @throws Exception
	 */
//	public int update(Connection con,Accommodation accommodation) throws Exception {
//		String sql = "update Accommodation set Sname=?,Mno=?,Ccno=?,Ssex=? where Sno=?";
//		PreparedStatement pstmt = con.prepareStatement(sql);
//		pstmt.setString(1,accommodation.getSname());
//		pstmt.setString(2,accommodation.getMno());
//		pstmt.setString(3,accommodation.getCcno());
//		pstmt.setString(4,accommodation.getSsex());
//		pstmt.setString(5,accommodation.getSno());
//		return pstmt.executeUpdate();
//	}
}
