package top.young.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import top.young.dao.BuildingDao;
import top.young.model.Building;
import top.young.util.DbUtil;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuildingDeleteView extends JInternalFrame {
	private DbUtil dbUtil = new DbUtil();
	private String Anos[] = new String[20];
	private JComboBox AreaComboBox = new JComboBox();
	private JComboBox BuildingNo = new JComboBox();
	private String Bnos[] = new String[20];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuildingDeleteView frame = new BuildingDeleteView();
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
	public BuildingDeleteView() {
		
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				addAreaInfo(e);
			}
		});
		
		setTitle("\u5220\u9664\u697C\u680B\u4FE1\u606F");
		setClosable(true);
		setBounds(100, 100, 408, 300);
		
		JButton button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteBuilding(e);
			}
		});
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetNull();
			}
		});
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		
		JLabel label_2 = new JLabel("\u697C\u680B\u7F16\u53F7\uFF1A");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		BuildingNo.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		
		JLabel label_1_1 = new JLabel("\u6240\u5C5E\u533A\u57DF\uFF1A");
		label_1_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		AreaComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				addBuildingInfo(arg0);
			}
		});
		
		AreaComboBox.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("\u9009\u62E9\u8981\u5220\u9664\u7684\u697C\u680B\uFF1A");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(94, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(AreaComboBox, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(BuildingNo, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
								.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))))
					.addGap(90))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(AreaComboBox, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(BuildingNo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

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
			this.BuildingNo.removeAllItems();
			while(rs.next()) {
				this.BuildingNo.addItem(rs.getString("Bno"));
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
	
	private void DeleteBuilding(ActionEvent event)
	{
		Connection con = null;
		try {
			con = dbUtil.getCon();
			String sql = "select * from Accommodation where Ano=? and Bno=?";
			PreparedStatement pstmt =  con.prepareStatement(sql);
			pstmt.setString(1, this.Anos[this.AreaComboBox.getSelectedIndex()]);
			pstmt.setString(2, this.Bnos[this.BuildingNo.getSelectedIndex()]);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				JOptionPane.showMessageDialog(null, "»¹ÓÐÑ§ÉúÔÚ¸ÃÂ¥¶°£¬ÎÞ·¨É¾³ý");
				return;
			}
			
			BuildingDao buildingDao = new BuildingDao();
			Building building = new Building(this.Anos[this.AreaComboBox.getSelectedIndex()],this.Bnos[this.BuildingNo.getSelectedIndex()]);
			int num = buildingDao.delete(con, building);
			if(num==1) {
				JOptionPane.showMessageDialog(null, "É¾³ý³É¹¦");
				resetNull();
			}else {
				JOptionPane.showMessageDialog(null, "É¾³ýÊ§°Ü");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void resetNull()
	{
		this.AreaComboBox.setSelectedIndex(-1);
		this.BuildingNo.setSelectedIndex(-1);
	}
}
