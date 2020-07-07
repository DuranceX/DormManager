package top.young.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import top.young.dao.BuildingDao;
import top.young.model.Building;
import top.young.util.DbUtil;
import top.young.util.StringUtil;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class BuildingAddView extends JInternalFrame {
	private JTextField textField;
	private JComboBox AreaComboBox = new JComboBox();
	private DbUtil dbUtil = new DbUtil();
	private String Anos[] = new String[20];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuildingAddView frame = new BuildingAddView();
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
	public BuildingAddView() {
		setClosable(true);
		
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				addAreaInfo(e);
			}
		});
		
		setTitle("\u6DFB\u52A0\u697C\u680B\u4FE1\u606F");
		
		setBounds(100, 100, 413, 300);
		
		JLabel label = new JLabel("\u697C\u680B\u7F16\u53F7\uFF1A");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6240\u5C5E\u533A\u57DF\uFF1A");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		AreaComboBox.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addBuilding(e);
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(86)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(75)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(AreaComboBox, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField)))))
					.addContainerGap(88, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(AreaComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(49, Short.MAX_VALUE))
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
	
	private void addBuilding(ActionEvent event) throws Exception
	{
		Connection con = null;
		if(StringUtil.isEmpty(textField.getText()))
		{
			JOptionPane.showMessageDialog(null, "Â¥¶°±àºÅ²»ÄÜÎª¿Õ");
			return;
		}
		try {
			con = dbUtil.getCon();
			String sql = "select * from building where Bno=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, textField.getText());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				JOptionPane.showMessageDialog(null, "Â¥¶°±àºÅÒÑ´æÔÚ");
				return;
			}
			
			//Ã»ÓÐÖØ¸´Ïî£¬½øÐÐÌí¼Ó
			BuildingDao buildingDao = new BuildingDao();
			Building building = new Building(this.Anos[this.AreaComboBox.getSelectedIndex()],textField.getText());
			int num = buildingDao.add(con, building);
			if(num==1) {
				JOptionPane.showMessageDialog(null, "Ìí¼Ó³É¹¦");
				resetNull();
			}else {
				JOptionPane.showMessageDialog(null, "Ìí¼ÓÊ§°Ü");
			}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally {
			dbUtil.clossCon(con);
		}
	}
	
	private void resetNull()
	{
		this.textField.setText("");
		this.AreaComboBox.setSelectedIndex(0);
	}
}
