package top.young.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import top.young.dao.UserDao;
import top.young.model.User;
import top.young.util.DbUtil;
import top.young.util.StringUtil;

public class StudentPassUpdateView extends JInternalFrame {
	private JTextField UserNameText;
	private JPasswordField OldPasswordField;
	private JPasswordField NewPasswordField;
	private JPasswordField comfirmPasswordField;
	private UserDao userDao = new UserDao();
	private DbUtil dbUtil = new DbUtil();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentPassUpdateView frame = new StudentPassUpdateView();
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
	public StudentPassUpdateView() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setClosable(true);
		setBounds(100, 100, 450, 313);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		UserNameText = new JTextField();
		UserNameText.setEditable(false);
		UserNameText.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u65E7\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		OldPasswordField = new JPasswordField();
		OldPasswordField.setFont(new Font("宋体", Font.PLAIN, 16));
		
		NewPasswordField = new JPasswordField();
		NewPasswordField.setFont(new Font("宋体", Font.PLAIN, 16));
		
		comfirmPasswordField = new JPasswordField();
		comfirmPasswordField.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("\u4FEE\u6539");
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatePassActionPerfored(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(72)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3)))
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(UserNameText, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
								.addComponent(OldPasswordField, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
								.addComponent(NewPasswordField, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
								.addComponent(comfirmPasswordField, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(130)
							.addComponent(btnNewButton)
							.addGap(47)
							.addComponent(btnNewButton_1)))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(UserNameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(OldPasswordField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(NewPasswordField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(comfirmPasswordField, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		System.out.println(StudentLoginView.getLogin_username());
		this.UserNameText.setText(StudentLoginView.getLogin_username());
	}
	/**修改密码
	 * 
	 * @param e
	 */
	private void updatePassActionPerfored(ActionEvent e) {
		// TODO Auto-generated method stub
		String old_password = new String(this.OldPasswordField.getPassword());
		String new_password = new String(this.NewPasswordField.getPassword());
		String new_password2 = new String(this.comfirmPasswordField.getPassword());
		if(StringUtil.isEmpty(old_password) || StringUtil.isEmpty(new_password) || StringUtil.isEmpty(new_password2)) {
			JOptionPane.showMessageDialog(null, "请将信息填写完整");
			return;
		}
		if(!old_password.equals(StudentLoginView.getLogin_password())) {
			JOptionPane.showMessageDialog(null, "原密码不一致，请重新输入");
			return;
		}
		if(!new_password.equals(new_password2)) {
			JOptionPane.showMessageDialog(null, "两次密码不一致，请重新输入");
			return;
		}
		Connection con = null;
		try {
			con =  dbUtil.getCon();
//			System.out.println(LoginView.getLogin_id()+" "+LoginView.getLogin_username()+" "+new_password+" "+LoginView.getIdentity());
			User user = new User(StudentLoginView.getLogin_id(),StudentLoginView.getLogin_username(),new_password,StudentLoginView.getIdentity());
			int res = userDao.update(con, user);
			if(res == 1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				dispose();
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				dbUtil.clossCon(con);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
