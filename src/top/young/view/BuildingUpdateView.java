package top.young.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import top.young.dao.BuildingDao;
import top.young.model.Building;
import top.young.util.DbUtil;
import top.young.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class BuildingUpdateView extends JInternalFrame {
	private JTextField textField;
	private JComboBox NewACB = new JComboBox();
	private JComboBox OldACB = new JComboBox();
	private JComboBox BuildingNo = new JComboBox();
	private DbUtil dbUtil = new DbUtil();
	private String Anos[] = new String[20];
	private String Bnos[] = new String[20];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuildingUpdateView frame = new BuildingUpdateView();
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
	public BuildingUpdateView() {
		
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				addAreaInfo(e);
			}
		});
		
		setTitle("\u66F4\u65B0\u697C\u680B\u4FE1\u606F");
		setClosable(true);
		setBounds(100, 100, 529, 316);
		
		JLabel label_1 = new JLabel("\u6240\u5C5E\u533A\u57DF\uFF1A");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		NewACB.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		
		JLabel label = new JLabel("\u697C\u680B\u7F16\u53F7\uFF1A");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		textField.setColumns(10);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UpdateBuilding(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		
		JLabel label_1_1 = new JLabel("\u6240\u5C5E\u533A\u57DF\uFF1A");
		label_1_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		OldACB.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				addBuildingInfo(arg0);
			}
		});
		
		OldACB.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		
		BuildingNo.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		
		JLabel label_3 = new JLabel("\u9009\u62E9\u8981\u4FEE\u6539\u7684\u697C\u680B\uFF1A");
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		
		JLabel label_4 = new JLabel("\u4FEE\u6539\u540E\u7684\u4FE1\u606F\uFF1A");
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(146)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(159, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(BuildingNo, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(OldACB, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(NewACB, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addGap(45))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(OldACB, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(NewACB, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(6)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addComponent(BuildingNo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(52))
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
				this.OldACB.addItem(rs.getString("Ano"));
				this.NewACB.addItem(rs.getString("Ano"));
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
			pstmt.setString(1, this.OldACB.getSelectedItem().toString());
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
	
	private void UpdateBuilding(ActionEvent event)
	{
		Connection con = null;
		if(StringUtil.isEmpty(textField.getText()))
		{
			JOptionPane.showMessageDialog(null, "Â¥¶°±àºÅ²»ÄÜÎª¿Õ");
			return;
		}
		try {
			con = dbUtil.getCon();
			String sql = "select * from building where Ano=? and Bno=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, this.Anos[this.NewACB.getSelectedIndex()]);
			pstmt.setString(2, textField.getText());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				JOptionPane.showMessageDialog(null, "Â¥¶°±àºÅÒÑ´æÔÚ");
				return;
			}
			
			//Ã»ÓÐÖØ¸´Ïî£¬½øÐÐÌí¼Ó
			BuildingDao buildingDao = new BuildingDao();
			Building oldBuilding = new Building(this.Anos[this.OldACB.getSelectedIndex()],this.Bnos[this.BuildingNo.getSelectedIndex()]);
			Building newBuilding = new Building(this.Anos[this.NewACB.getSelectedIndex()],textField.getText());
			int num = buildingDao.update(con, newBuilding, oldBuilding);
			if(num==1) {
				JOptionPane.showMessageDialog(null, "ÐÞ¸Ä³É¹¦");
				resetNull();
			}else {
				JOptionPane.showMessageDialog(null, "ÐÞ¸ÄÊ§°Ü");
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
	
	private void resetNull()
	{
		this.textField.setText("");
		this.OldACB.setSelectedIndex(0);
		this.NewACB.setSelectedIndex(0);
		this.BuildingNo.setSelectedIndex(0);
	}

}
