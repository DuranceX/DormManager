package top.young.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import top.young.util.DbUtil;
import top.young.util.StringUtil;

import java.awt.event.ItemListener;
import java.awt.event.ActionListener;

public class StElecChargingView extends JInternalFrame {
	private JComboBox AreaComboBox = new JComboBox();
	private JComboBox BuildingComboBox = new JComboBox();
	private JComboBox DormComboBox = new JComboBox();
	private JLabel balance = new JLabel("");
	private DbUtil dbUtil = new DbUtil();
	private String Anos[] = new String[20];
	private String Bnos[] = new String[20];
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StElecChargingView frame = new StElecChargingView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StElecChargingView() {
		setClosable(true);
		setTitle("\u67E5\u8BE2\u5BBF\u820D\u4FE1\u606F");
		
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				addAreaInfo(e);
			}
		});
		
		setBounds(100, 100, 446, 432);
		
		JLabel label = new JLabel("\u5F53\u524D\u7535\u8D39\u4F59\u989D\uFF1A");
		label.setBounds(104, 201, 142, 54);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		balance.setBounds(233, 209, 62, 36);
		balance.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		JButton query_btn = new JButton("\u5145\u503C");
		query_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Charging(e);
			}
		});
		query_btn.setBounds(104, 334, 100, 36);
		query_btn.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		getContentPane().setLayout(null);
		getContentPane().add(label);
		getContentPane().add(balance);
		getContentPane().add(query_btn);
		
		JLabel label_2 = new JLabel("\u5143");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label_2.setBounds(305, 209, 58, 38);
		getContentPane().add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel("\u6240\u5C5E\u533A\u57DF\uFF1A");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(23, 34, 100, 35);
		getContentPane().add(lblNewLabel_1);
		AreaComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				addBuildingInfo(e);
			}
		});
		
		AreaComboBox.setBounds(150, 41, 239, 27);
		getContentPane().add(AreaComboBox);
		
		JLabel lblNewLabel_2 = new JLabel("\u6240\u5C5E\u697C\u680B\uFF1A");
		lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(23, 92, 100, 30);
		getContentPane().add(lblNewLabel_2);
		BuildingComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				addDnoInfo(e);
			}
		});
		
		BuildingComboBox.setBounds(150, 97, 239, 27);
		getContentPane().add(BuildingComboBox);
		DormComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		
		DormComboBox.setBounds(150, 151, 239, 27);
		getContentPane().add(DormComboBox);
		
		JLabel lblNewLabel_3 = new JLabel("\u5BBF\u820D\u7F16\u53F7\uFF1A");
		lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(23, 143, 100, 36);
		getContentPane().add(lblNewLabel_3);
		
		JLabel label_1 = new JLabel("\u8F93\u5165\u5145\u503C\u91D1\u989D\uFF1A");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label_1.setBounds(104, 256, 141, 45);
		getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(233, 263, 66, 30);
		getContentPane().add(textField);
		
		JLabel label_2_1 = new JLabel("\u5143");
		label_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label_2_1.setBounds(305, 256, 58, 45);
		getContentPane().add(label_2_1);
		
		JButton query_btn_1 = new JButton("\u91CD\u7F6E");
		query_btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetNull();
			}
		});
		query_btn_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		query_btn_1.setBounds(233, 334, 100, 36);
		getContentPane().add(query_btn_1);

	}
	
	@SuppressWarnings("unchecked")
	private void addAreaInfo(InternalFrameEvent arg0) {
		Connection con = null;
		int i=0;
		try {
			con = dbUtil.getCon();
			String sql = "select * from Area";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				this.AreaComboBox.addItem(rs.getString("Ano"));
				this.Anos[i++] = rs.getString("Ano");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dbUtil.clossCon(con);
				this.AreaComboBox.setSelectedIndex(-1);
				this.BuildingComboBox.setSelectedIndex(-1);
				this.DormComboBox.setSelectedIndex(-1);
				this.balance.setText("");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void addBuildingInfo(ItemEvent arg0)
	{
		Connection con = null;
		int i=0;
		try {
			con = dbUtil.getCon();
			String sql = "select * from Building where Ano=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, this.AreaComboBox.getSelectedItem().toString());
			ResultSet rs = pstmt.executeQuery();
			this.BuildingComboBox.removeAllItems();
			while(rs.next()) {
				this.BuildingComboBox.addItem(rs.getString("Bno"));
				this.Bnos[i++] = rs.getString("Bno");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dbUtil.clossCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void addDnoInfo(ItemEvent event) {
		// TODO Auto-generated method stub
		Connection con = null;
		int i=0;
		try {
			con = dbUtil.getCon();
			String sql = "select * from Dormitory where Ano = ? and Bno = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			//这里可能有bug，所以加了一个判断
			if(this.AreaComboBox.getSelectedItem() == null)
				return;
			pstmt.setString(1, this.AreaComboBox.getSelectedItem().toString());
			//这里可能有bug，所以加了一个判断
			if(this.BuildingComboBox.getSelectedItem() == null)
				return;
			pstmt.setString(2, this.BuildingComboBox.getSelectedItem().toString());
			ResultSet rs = pstmt.executeQuery();
			//清除所有items，用于后面放新的值
			this.DormComboBox.removeAllItems();
			while(rs.next()) {
				this.DormComboBox.addItem(rs.getString("Dno"));
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}finally {
			try {
				dbUtil.clossCon(con);
				getBalance();
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	
	private void getBalance()
	{
		Connection con = null;
		try {
			con = dbUtil.getCon();
			String sql = "select Elec from dormitory where Ano=? and Bno=? and Dno=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, this.AreaComboBox.getSelectedItem().toString());
			pstmt.setString(2, this.BuildingComboBox.getSelectedItem().toString());
			pstmt.setString(3, this.DormComboBox.getSelectedItem().toString());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				this.balance.setText(rs.getString("Elec"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dbUtil.clossCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private void Charging(ActionEvent e)
	{
		Connection con = null;
		try {
			int i = Integer.parseInt(this.textField.getText());
			int x = Integer.parseInt(this.balance.getText());
			con = dbUtil.getCon();
			String sql = "update dormitory set Elec =? where Ano=? and Bno=? and Dno=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, String.valueOf((i+x)));
			pstmt.setString(2, this.AreaComboBox.getSelectedItem().toString());
			pstmt.setString(3, this.BuildingComboBox.getSelectedItem().toString());
			pstmt.setString(4, this.DormComboBox.getSelectedItem().toString());
			int num = pstmt.executeUpdate();
			if(num==1) {
				JOptionPane.showMessageDialog(null, "充值成功");
				resetNull();
			}else {
				JOptionPane.showMessageDialog(null, "充值失败");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private void resetNull()
	{
		this.AreaComboBox.setSelectedIndex(-1);
		this.BuildingComboBox.setSelectedIndex(-1);
		this.DormComboBox.setSelectedIndex(-1);
		this.balance.setText("");
		this.textField.setText("");
	}
}
