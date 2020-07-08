package top.young.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import de.wannawork.jcalendar.JCalendarComboBox;
import top.young.dao.LateDao;
import top.young.model.Late;
import top.young.util.DbUtil;
import top.young.util.StringUtil;

public class AddLateView extends JInternalFrame {
	private JTextField textField;
	private DbUtil dbUtil = new DbUtil();
	private LateDao lateDao = new LateDao();
	private JComboBox AreaComboBox;
	private JComboBox BuildingComboBox;
	private JComboBox DnoComboBox;
	private JCalendarComboBox calendarComboBox;
	private JTextArea textArea;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLateView frame = new AddLateView();
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
	public AddLateView() {
		setClosable(true);
		setTitle("\u6DFB\u52A0\u665A\u5F52\u8BB0\u5F55");
		setBounds(100, 100, 370, 527);
		
		AreaComboBox = new JComboBox();
		
		JLabel lblNewLabel_1 = new JLabel("\u6240\u5C5E\u533A\u57DF\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		BuildingComboBox = new JComboBox();
		
		JLabel lblNewLabel_2 = new JLabel("\u6240\u5C5E\u697C\u680B\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("\u5BBF\u820D\u7F16\u53F7\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		DnoComboBox = new JComboBox();
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
//				fillInfoToComboBox(arg0);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				fillInfoToComboBox(e);
			}
		});
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
//				fillInfoToComboBox(arg0);
			}
		});
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3_1 = new JLabel("\u665A\u5F52\u65F6\u95F4\uFF1A");
		lblNewLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		calendarComboBox = new JCalendarComboBox();
		
		JLabel lblNewLabel_4 = new JLabel("\u665A\u5F52\u539F\u56E0\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 16));
		
		textArea = new JTextArea();
		textArea.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addInfoActionPerformed(arg0);
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
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(DnoComboBox, 0, 176, Short.MAX_VALUE)
								.addComponent(BuildingComboBox, 0, 176, Short.MAX_VALUE)
								.addComponent(AreaComboBox, 0, 176, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)))
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(calendarComboBox, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
								.addComponent(lblNewLabel_4)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(46)
							.addComponent(btnNewButton)
							.addGap(40)
							.addComponent(btnNewButton_1)))
					.addGap(47))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
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
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(calendarComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
	}
	private void fillInfoToComboBox(KeyEvent arg0) {
		// TODO Auto-generated method stub
		String sno = this.textField.getText();
		Connection con = null;
		try {
			con = dbUtil.getCon();
			String sql = "select * from accommodation where sno=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sno);
			ResultSet rs = pstmt.executeQuery();
			this.AreaComboBox.removeAllItems();
			this.BuildingComboBox.removeAllItems();
			this.DnoComboBox.removeAllItems();
			if(rs.next()) {
				this.AreaComboBox.addItem(rs.getString("Ano"));
				this.BuildingComboBox.addItem(rs.getString("Bno"));
				this.DnoComboBox.addItem(rs.getString("Dno"));
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
	/**
	 * 添加晚归信息
	 * @param arg0
	 */
	private void addInfoActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Connection con = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String sno = this.textField.getText();
		String ano = this.AreaComboBox.getSelectedItem().toString();
		String bno = this.BuildingComboBox.getSelectedItem().toString();
		String dno = this.DnoComboBox.getSelectedItem().toString();
		String ldate = format.format(this.calendarComboBox.getCalendar().getTime());
		System.out.print(ldate);
		String lreason = this.textArea.getText();
		if(StringUtil.isEmpty(sno)) {
			JOptionPane.showMessageDialog(null, "请输入学号");
			return;
		}
		if(StringUtil.isEmpty(ldate)) {
			JOptionPane.showMessageDialog(null, "请输入晚归日期");
			return;
		}
		if(StringUtil.isEmpty(lreason)) {
			JOptionPane.showMessageDialog(null, "请输入晚归原因");
			return;
		}
		try {
			con = dbUtil.getCon();
			Late late = new Late(ano,bno,dno,sno,ldate,lreason); 
			int res = this.lateDao.add(con, late);
			if(res == 1) {
				JOptionPane.showMessageDialog(null, "添加成功");
				resetNull();
			}else {
				JOptionPane.showMessageDialog(null, "添加失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 置空操作
	 */
	public void resetNull() {
		this.textField.setText("");
		this.textArea.setText("");
		this.AreaComboBox.setSelectedIndex(-1);
		this.BuildingComboBox.setSelectedIndex(-1);
		this.DnoComboBox.setSelectedIndex(-1);
	}
	private void resetActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		resetNull();
	}
}
