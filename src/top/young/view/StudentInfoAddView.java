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

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import top.young.dao.StudentDao;
import top.young.model.Student;
import top.young.model.User;
import top.young.util.DbUtil;
import top.young.util.StringUtil;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class StudentInfoAddView extends JInternalFrame {
	private DbUtil dbUtil = new DbUtil();
	private StudentDao studentDao = new StudentDao();
	private JTextField SnoText;
	private JTextField SnameText;
	private JLabel lblNewLabel_4;
	JComboBox MnoCombobox = new JComboBox();
	JComboBox classComboBox = new JComboBox();
	JComboBox sex = new JComboBox();
	private String Ccnos[] = new String[100];
	private String Mnos[] = new String[100];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfoAddView frame = new StudentInfoAddView();
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
	public StudentInfoAddView() {
		setClosable(true);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent arg0) {
				try {
					addMnoInfo(arg0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		getContentPane().setFont(new Font("宋体", Font.PLAIN, 16));
		setTitle("\u6DFB\u52A0\u5B66\u751F\u4FE1\u606F");
		setBounds(100, 100, 521, 264);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		SnoText = new JTextField();
		SnoText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u4E13\u4E1A\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("\u73ED\u7EA7\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		SnameText = new JTextField();
		SnameText.setColumns(10);
		
		lblNewLabel_4 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addStudentActionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}


		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetActionPerformed(e);
			}


		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		

		sex.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(SnoText, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(MnoCombobox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(classComboBox, 0, 142, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(SnameText, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(sex, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
							.addGap(1)))
					.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(162, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(59)
					.addComponent(btnNewButton_1)
					.addGap(154))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(SnameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(SnoText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(sex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(MnoCombobox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(classComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		MnoCombobox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					changeClassItems(arg0);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		getContentPane().setLayout(groupLayout);

	}
	private void resetActionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		resetNull();
	}
	public void resetNull() {
		this.SnameText.setText("");
		this.SnoText.setText("");
		this.MnoCombobox.setSelectedIndex(-1);
		this.sex.setSelectedIndex(-1);
		this.classComboBox.setSelectedIndex(-1);	
	}
	/**
	 * 初始化的时候调用数据库填充专业的item
	 * @param arg0
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	private void addMnoInfo(InternalFrameEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		Connection con = null;
		int i=0;
		try {
			con = dbUtil.getCon();
			String sql = "select * from Major";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				this.Mnos[i++] = rs.getString("Mno");
				this.MnoCombobox.addItem(rs.getString("Mname"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtil.clossCon(con);
		}
	}
	/**
	 * 当选定专业的combox的item之后更新class的item
	 * @param arg0
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	private void changeClassItems(ItemEvent arg0) throws Exception {
		// TODO Auto-generated method stub
		if(this.MnoCombobox.getSelectedIndex()==-1)
			return;
		Connection con = null;
		int i=0;
		try {
			con = dbUtil.getCon();
			String sql = "select * from CClass where Mno=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,this.Mnos[this.MnoCombobox.getSelectedIndex()]);
			ResultSet rs = pstmt.executeQuery();
			//先清空已有的item
			this.classComboBox.removeAllItems();
			while(rs.next()) {
				this.Ccnos[i++] = rs.getString("Ccno");
				this.classComboBox.addItem(rs.getString("Ccname"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbUtil.clossCon(con);
		}
		
	}
	/**
	 * @param e
	 * @throws Exception
	 */
	private void addStudentActionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String Sno = this.SnoText.getText();
		String Sname = this.SnameText.getText();
		String Mno;
		String Sex;
		String Sclass;
		if(StringUtil.isEmpty(Sno)) {
			JOptionPane.showMessageDialog(null, "学号不能为空");
			return;
		}
		if(StringUtil.isEmpty(Sname)) {
			JOptionPane.showMessageDialog(null, "姓名不能为空");
			return;
		}
		if(this.MnoCombobox.getSelectedItem()==null) {
			JOptionPane.showMessageDialog(null, "专业号不能为空");
			return;
		}
		else {
			Mno = this.Mnos[this.MnoCombobox.getSelectedIndex()];
		}
		if(this.sex.getSelectedItem()==null) {
			JOptionPane.showMessageDialog(null, "性别不能为空");
			return;
		}else {
			Sex = this.sex.getSelectedItem().toString();
		}
		if(this.classComboBox.getSelectedItem()==null) {
			JOptionPane.showMessageDialog(null, "班级不能为空");
			return;
		}else {
			Sclass = this.Ccnos[this.classComboBox.getSelectedIndex()];
		}
		Student student = new Student(Sno,Mno,Sclass,Sname,Sex);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = studentDao.add(con, student);
			if(addNum==1) {
				JOptionPane.showMessageDialog(null, "添加成功");
				resetNull();
			}else {
				JOptionPane.showMessageDialog(null, "添加失败");;
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			dbUtil.clossCon(con);
		}
		
		
	}
}
