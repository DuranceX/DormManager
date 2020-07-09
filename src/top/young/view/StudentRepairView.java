package top.young.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import top.young.dao.RepairDao;
import top.young.model.Accommodation;
import top.young.util.DbUtil;
import top.young.util.StringUtil;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;

@SuppressWarnings("serial")
public class StudentRepairView extends JInternalFrame {
	private DbUtil dbUtil = new DbUtil();
	private RepairDao repairDao = new RepairDao();
	private JTextField TextTime;
	private JTextArea reason = new JTextArea();
	private JComboBox AreaComboBox = new JComboBox();
	private JComboBox BuildingComboBox = new JComboBox();
	private JComboBox DormComboBox = new JComboBox();
	private String Anos[] = new String[20];
	private String Bnos[] = new String[20];
	private static String username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRepairView frame = new StudentRepairView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */
	public StudentRepairView() {
		
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				addAreaInfo(e);
			}
		});
		
		setClosable(true);
		setTitle("\u62A5\u4FEE\u670D\u52A1");
		setBounds(100, 100, 619, 335);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u6240\u5C5E\u697C\u680B\uFF1A");
		lblNewLabel_1_1.setBounds(318, 47, 80, 19);
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_2 = new JLabel("\u6240\u5C5E\u533A\u57DF\uFF1A");
		lblNewLabel_1_2.setBounds(48, 45, 80, 19);
		lblNewLabel_1_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_3 = new JLabel("\u5BBF\u820D\u7F16\u53F7\uFF1A");
		lblNewLabel_1_3.setBounds(48, 90, 80, 19);
		lblNewLabel_1_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u62A5\u4FEE\u65F6\u95F4\uFF1A");
		lblNewLabel_1_1_1.setBounds(318, 93, 80, 19);
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		TextTime = new JTextField();
		TextTime.setBounds(402, 90, 132, 25);
		TextTime.setFont(new Font("宋体", Font.PLAIN, 16));
		TextTime.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u62A5\u4FEE\u539F\u56E0\uFF1A");
		lblNewLabel.setBounds(48, 141, 80, 19);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton btnNewButton_2 = new JButton("\u63D0\u4EA4");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit();
			}
		});
		btnNewButton_2.setBounds(177, 245, 81, 27);
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetNull();
			}
		});
		btnNewButton_1.setBounds(344, 245, 81, 27);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		getContentPane().setLayout(null);
		getContentPane().add(lblNewLabel);
		getContentPane().add(lblNewLabel_1_2);
		getContentPane().add(lblNewLabel_1_1);
		getContentPane().add(lblNewLabel_1_3);
		getContentPane().add(lblNewLabel_1_1_1);
		getContentPane().add(TextTime);
		getContentPane().add(btnNewButton_2);
		getContentPane().add(btnNewButton_1);
		
		reason.setBounds(138, 139, 402, 74);
		getContentPane().add(reason);
		AreaComboBox.setEnabled(false);
		AreaComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				addBuildingInfo(e);
			}
		});
		
		AreaComboBox.setBounds(138, 42, 140, 27);
		getContentPane().add(AreaComboBox);
		BuildingComboBox.setEnabled(false);
		BuildingComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				addDnoInfo(e);
			}
		});
		
		BuildingComboBox.setBounds(402, 42, 132, 27);
		getContentPane().add(BuildingComboBox);
		DormComboBox.setEnabled(false);
		
		DormComboBox.setBounds(138, 87, 140, 27);
		getContentPane().add(DormComboBox);
	}
	
	private void submit()
	{
		Connection con = null;
		try {
			con = dbUtil.getCon();
			String sql = "insert into repair values(null,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, this.AreaComboBox.getSelectedItem().toString());
			pstmt.setString(2, this.BuildingComboBox.getSelectedItem().toString());
			pstmt.setString(3, this.DormComboBox.getSelectedItem().toString());
			pstmt.setString(4, this.TextTime.getText());
			pstmt.setString(5, this.reason.getText());
			int num = pstmt.executeUpdate();
			if(num==1) {
				JOptionPane.showMessageDialog(null, "提交成功");
				resetNull();
			}else {
				JOptionPane.showMessageDialog(null, "提交失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(c.getTime());
		this.TextTime.setText(dateStr);
	}
	
	private void resetNull()
	{
		this.AreaComboBox.setSelectedIndex(-1);
		this.BuildingComboBox.setSelectedIndex(-1);
		this.DormComboBox.setSelectedIndex(-1);
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(c.getTime());
		this.TextTime.setText(dateStr);
		this.reason.setText("");
	}
}
