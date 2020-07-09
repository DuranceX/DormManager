package top.young.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import top.young.dao.UserDao;
import top.young.model.User;
import top.young.util.DbUtil;
import top.young.util.StringUtil;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JRadioButton;

public class StudentLoginView extends JFrame {

	private JPanel contentPane;
	private JTextField text_username;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPasswordField text_password;
	private JButton btnNewButton_1;
	private static String login_id;
	private static String login_username;
	private static String login_password;
	private static int identity;
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();
	//定义按钮组
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
					//String lookAndFeel = "javax.swing.plaf.metal.MetalLookAndFeel"; 
					UIManager.setLookAndFeel(lookAndFeel); 
					StudentLoginView frame = new StudentLoginView();
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
	public StudentLoginView() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentLoginView.class.getResource("/image/OIP.png")));
		setTitle("\u5B66\u751F\u5BBF\u820D\u7BA1\u7406\u7CFB\u7EDF(\u5B66\u751F\u7AEF)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		text_username = new JTextField();
		text_username.setText("3171602051");
		text_username.setFont(new Font("宋体", Font.PLAIN, 16));
		text_username.setColumns(10);
		
		lblNewLabel_1 = new JLabel("\u5B66\u751F\u5BBF\u820D\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 25));
		lblNewLabel_1.setIcon(new ImageIcon(StudentLoginView.class.getResource("/image/OIP (1).png")));
		
		lblNewLabel_2 = new JLabel("\u5BC6 \u7801:");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		text_password = new JPasswordField();
		text_password.setToolTipText("");
		text_password.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setIcon(new ImageIcon(StudentLoginView.class.getResource("/image/login.png")));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loginActionPerformed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		
		btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(StudentLoginView.class.getResource("/image/exit.png")));
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(82)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(btnNewButton)
							.addGap(41)
							.addComponent(btnNewButton_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(text_username, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
								.addComponent(text_password, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))))
					.addGap(81))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(87)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(text_username, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_password, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(69)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(37))
		);
		contentPane.setLayout(gl_contentPane);
		//设置窗口居中显示
		this.setLocationRelativeTo(null);
	}
	/**
	 * 登录按钮事件
	 * @param e
	 * @throws Exception 
	 */
	private void loginActionPerformed(ActionEvent evt) throws Exception {
		// TODO Auto-generated method stub
		String userName  = text_username.getText();
		String passWord =  new String(text_password.getPassword());
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if(StringUtil.isEmpty(passWord)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		else {
			User user =null;
			user = new User(userName,passWord,0);
			Connection con = null;
			try {
				con = dbUtil.getCon();
				User currentUser = userDao.login(con,user);
				if(currentUser == null){
					JOptionPane.showMessageDialog(null, "用户名或密码错误");
					return;
				}
				else {
					//进入主页面
					dispose();
					login_id = currentUser.getId();
					login_username = currentUser.getUsername();
					login_password  = currentUser.getPassword();
					identity = currentUser.getIdentity();
					new StudentMainView().setVisible(true);;
				}
			}
			catch(Exception e){
				System.out.println("未知错误");
			}
			finally {
				dbUtil.clossCon(con);
			}
		}
	}

	public static String getLogin_id() {
		return login_id;
	}

	public static void setLogin_id(String login_id) {
		StudentLoginView.login_id = login_id;
	}

	public static String getLogin_username() {
		return login_username;
	}

	public static void setLogin_username(String login_username) {
		StudentLoginView.login_username = login_username;
	}

	public static String getLogin_password() {
		return login_password;
	}

	public static void setLogin_password(String login_password) {
		StudentLoginView.login_password = login_password;
	}

	public static int getIdentity() {
		return identity;
	}

	public static void setIdentity(int identity) {
		StudentLoginView.identity = identity;
	}
	
}
