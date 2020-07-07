package top.young.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import top.young.dao.AccommodationDao;
import top.young.model.Accommodation;
import top.young.util.DbUtil;

public class AccomAddView extends JInternalFrame {
	private JTextField textField;
	private JLabel lblNewLabel_3;
	private JComboBox AreaComboBox = new JComboBox();
	private JComboBox BuildingComboBox = new JComboBox();
	private JComboBox DnoComboBox = new JComboBox();
	private DbUtil dbUtil = new DbUtil();
	private AccommodationDao accommodationDao = new AccommodationDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccomAddView frame = new AccomAddView();
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
	public AccomAddView() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				addAreaInfo(e);
			}
		});
		setTitle("\u6DFB\u52A0\u4F4F\u5BBF\u4FE1\u606F");
		setClosable(true);
		setBounds(100, 100, 390, 354);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1 = new JLabel("\u6240\u5C5E\u533A\u57DF\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("\u6240\u5C5E\u697C\u680B\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		lblNewLabel_3 = new JLabel("\u5BBF\u820D\u7F16\u53F7\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		

		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					addAccomInfoActionPerformed(arg0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_3)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnNewButton)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(AreaComboBox, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
								.addComponent(BuildingComboBox, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
								.addComponent(DnoComboBox, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(57)
							.addComponent(btnNewButton_1)))
					.addGap(111))
		);
		AreaComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				addBuildingInfo(arg0);
			}
		});
		BuildingComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDnoInfo(e);
			}

		});
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(AreaComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(BuildingComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(DnoComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addContainerGap(110, Short.MAX_VALUE))
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
	private void addBuildingInfo(ItemEvent arg0) {
		// TODO Auto-generated method stub
		Connection con = null;
		int i=0;
		try {
			con = dbUtil.getCon();
			String sql = "select * from Building where Ano = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			if(this.AreaComboBox.getSelectedIndex()==-1)
				return;
			pstmt.setString(1, this.AreaComboBox.getSelectedItem().toString());
			ResultSet rs = pstmt.executeQuery();
			//清除所有items，用于后面放新的值
			this.BuildingComboBox.removeAllItems();
			while(rs.next()) {
				this.BuildingComboBox.addItem(rs.getString("Bno"));
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
	private void addDnoInfo(ActionEvent e) {
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
			this.DnoComboBox.removeAllItems();
			while(rs.next()) {
				this.DnoComboBox.addItem(rs.getString("Dno"));
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}finally {
			try {
				dbUtil.clossCon(con);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}
	private void addAccomInfoActionPerformed(ActionEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
			con = dbUtil.getCon();
			//先判断学号是否在数据库中已经存在
			String sql = "select * from Student where sno=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, this.textField.getText());
			ResultSet rs = pstmt.executeQuery();
			if(!rs.next()) {
				JOptionPane.showMessageDialog(null, "请输入正确的学号");
				return;
			}
			//将数据写入数据库
			//先判断是否有空数据
			if(this.AreaComboBox.getSelectedIndex()==-1 || this.BuildingComboBox.getSelectedIndex()==-1 ||this.DnoComboBox.getSelectedIndex()==-1 ) {
				JOptionPane.showMessageDialog(null, "请将信息填写完整");
				return;
			}
			//写入数据
			Accommodation accommodation = new Accommodation();
			accommodation.setSno(this.textField.getText());
			accommodation.setAno(this.AreaComboBox.getSelectedItem().toString());
			accommodation.setBno(this.BuildingComboBox.getSelectedItem().toString());
			accommodation.setDno(this.DnoComboBox.getSelectedItem().toString());
			int num = this.accommodationDao.add(con, accommodation);
			if(num==1) {
				JOptionPane.showMessageDialog(null, "添加成功");
				resetNull();
			}else {
				JOptionPane.showMessageDialog(null, "添加失败");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtil.clossCon(con);
		}	
	}
	private void resetActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		resetNull();
	}
	public void resetNull() {
		this.textField.setText("");
		this.AreaComboBox.setSelectedIndex(-1);
		this.BuildingComboBox.setSelectedIndex(-1);
		this.DnoComboBox.setSelectedIndex(-1);
	}
}

