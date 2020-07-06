package top.young.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import top.young.dao.UserDao;
import top.young.model.User;
import top.young.util.DbUtil;
import top.young.util.StringUtil;

public class RegisterView extends JFrame {

	private JPanel contentPane;
	private JTextField text_user;
	private JLabel lblNewLabel_1;
	private JPasswordField text_pass;
	private JPasswordField text_pass_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();
	JRadioButton studentRadioButton = new JRadioButton("\u5B66\u751F");
	JRadioButton adminRadioButton = new JRadioButton("\u7BA1\u7406\u5458");
	ButtonGroup group=new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView frame = new RegisterView();
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
	public RegisterView() {

		setResizable(false);
		setTitle("\u7528\u6237\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		text_user = new JTextField();
		text_user.setFont(new Font("宋体", Font.PLAIN, 16));
		text_user.setColumns(10);
		
		lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		text_pass = new JPasswordField();
		text_pass.setFont(new Font("宋体", Font.PLAIN, 16));
		
		text_pass_2 = new JPasswordField();
		text_pass_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		

		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					registerActionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon(RegisterView.class.getResource("/image/add.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("\u6E05\u7A7A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(RegisterView.class.getResource("/image/reset.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		group.add(studentRadioButton);
		group.add(adminRadioButton);
		lblNewLabel_3 = new JLabel("\u7528\u6237\u6CE8\u518C");
		lblNewLabel_3.setFont(new Font("宋体", Font.BOLD, 27));
		lblNewLabel_3.setIcon(new ImageIcon(RegisterView.class.getResource("/image/OIP (1).png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(text_pass, 220, 220, 220))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel)
								.addGap(18)
								.addComponent(text_user, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(text_pass_2, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(66)
									.addComponent(studentRadioButton))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(32)
									.addComponent(btnNewButton)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
									.addComponent(adminRadioButton)
									.addGap(58))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(74)
									.addComponent(btnNewButton_1)))))
					.addGap(178))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(122)
					.addComponent(lblNewLabel_3)
					.addContainerGap(130, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addComponent(lblNewLabel_3)
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(text_user, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_pass, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(text_pass_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(studentRadioButton)
						.addComponent(adminRadioButton))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	private void clearActionPerformed(ActionEvent e) {
		this.text_user.setText("");
		this.text_pass.setText("");
		this.text_pass_2.setText("");
	}
	private void registerActionPerformed(ActionEvent e) throws Exception {
		// TODO Auto-generated method stub
		String userName = this.text_user.getText();
		String password = String.valueOf(this.text_pass.getPassword());
		String password2 = new String(this.text_pass_2.getPassword());
		int identity = -1;
		if(this.studentRadioButton.isSelected()) {
			identity = 0;
		}
		else if(this.adminRadioButton.isSelected()) {
			identity = 1;
		}else {
			JOptionPane.showMessageDialog(null, "请选择注册类型");
			return;
		}
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		if(StringUtil.isEmpty(password2)) {
			JOptionPane.showMessageDialog(null, "确认密码不能为空");
			return;
		}
		if(!password.contentEquals(password2)) {
			JOptionPane.showMessageDialog(null,"两次密码不一致");
			return;
		}
		//判断数据库中是否已经有相同的用户名
		Connection con = null;
		try {
			con = dbUtil.getCon();
			String sql = "select * from User where username=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userName);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "用户名已经存在，请更换用户名");
				return;
			}
			else {
				User user = new User(userName,password,identity);
				int addNum = userDao.addUser(con, user);
				if(addNum==1) {
					JOptionPane.showMessageDialog(null, "注册成功");
					//注册成功
					dispose();
					
					
				}else {
					JOptionPane.showMessageDialog(null, "注册失败");
					//注册失败
				}
			}
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			dbUtil.clossCon(con);
		}
		
	}
}
