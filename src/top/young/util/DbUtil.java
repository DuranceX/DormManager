package top.young.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ڷ�װ���ݿ�����
 * @author С��
 *
 */
public class DbUtil {
	private String dbUrl = "jdbc:mysql://106.15.249.29:3306/dorm?characterEncoding=utf8";
	private String dbUserName = "root";
	private String dbPassword = "abc123";
	private String jdbcName = "com.mysql.jdbc.Driver";
	/**
	 * ��ȡ���ݿ�����
	 * @return con����
	 * @throws Exception
	 */
	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName,dbPassword);
		return con;
	}
	public void clossCon(Connection con) throws Exception {
		if(con != null) {
			con.close();
		}
	}
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("���ݿ�����ʧ��");
			e.printStackTrace();
		}
	}
}
