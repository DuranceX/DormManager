package top.young.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import top.young.model.Building;

public class BuildingDao {

	/**
	 * 楼栋信息添加
	 * @param con
	 * @param building
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, Building building) throws Exception
	{
		String sql = "insert into Building values(?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, building.getAno());
		pstmt.setString(2, building.getBno());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 更新楼栋信息
	 * @param con
	 * @param building
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,Building new_building,Building old_building) throws Exception
	{
		String sql = "update Building set Ano=?,Bno=? where Ano=? and Bno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, new_building.getAno());
		pstmt.setString(2, new_building.getBno());
		pstmt.setString(3, old_building.getAno());
		pstmt.setString(4, old_building.getBno());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 删除楼栋
	 * @param con
	 * @param building
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,Building building) throws Exception
	{
		String sql = "delete from Building Where Ano=? and Bno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,building.getAno());
		pstmt.setString(2,building.getBno());
		return pstmt.executeUpdate();
	}
}
