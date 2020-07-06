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

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField text_username;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPasswordField text_password;
	private JButton btnNewButton_1;
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();

	JRadioButton studentRadioButton = new JRadioButton("\u5B66\u751F");
	
	JRadioButton adminRadioButton = new JRadioButton("\u7BA1\u7406\u5458");
	//���尴ť��
	ButtonGroup group=new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/image/OIP.png")));
		setTitle("\u5B66\u751F\u5BBF\u820D\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D:");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 16));
		
		text_username = new JTextField();
		text_username.setFont(new Font("����", Font.PLAIN, 16));
		text_username.setColumns(10);
		
		lblNewLabel_1 = new JLabel("\u5B66\u751F\u5BBF\u820D\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 25));
		lblNewLabel_1.setIcon(new ImageIcon(LoginView.class.getResource("/image/OIP (1).png")));
		
		lblNewLabel_2 = new JLabel("\u5BC6 \u7801:");
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 16));
		
		text_password = new JPasswordField();
		text_password.setFont(new Font("����", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setIcon(new ImageIcon(LoginView.class.getResource("/image/login.png")));
		btnNewButton.setFont(new Font("����", Font.PLAIN, 16));
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
		
		btnNewButton_1 = new JButton("\u6CE8\u518C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisterView registerView = new RegisterView();
				registerView.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(LoginView.class.getResource("/image/addUser.png")));
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 16));



		group.add(studentRadioButton);
		group.add(adminRadioButton);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(82)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(29)
									.addComponent(btnNewButton))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(studentRadioButton)
									.addGap(13)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(41)
									.addComponent(btnNewButton_1))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(19)
									.addComponent(adminRadioButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))))
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
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
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
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(adminRadioButton)
						.addComponent(studentRadioButton))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(37))
		);
		contentPane.setLayout(gl_contentPane);
		//���ô��ھ�����ʾ
		this.setLocationRelativeTo(null);
	}
	/**
	 * ��¼��ť�¼�
	 * @param e
	 * @throws Exception 
	 */
	private void loginActionPerformed(ActionEvent evt) throws Exception {
		// TODO Auto-generated method stub
		String userName  = text_username.getText();
		String passWord =  new String(text_password.getPassword());
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
			return;
		}
		if(StringUtil.isEmpty(passWord)) {
			JOptionPane.showMessageDialog(null, "���벻��Ϊ��");
			return;
		}
		if(group.getSelection() == null) {
			JOptionPane.showMessageDialog(null, "����ѡ���¼�û�����");
			return;
		}
		else {
			User user =null;
			if(studentRadioButton.isSelected())
				user = new User(userName,passWord,0);
			else
				user = new User(userName,passWord,1);
			Connection con = null;
			try {
				con = dbUtil.getCon();
				User currentUser = userDao.login(con,user);
				if(currentUser == null){
					JOptionPane.showMessageDialog(null, "�û������������");
					return;
				}
				else {
					//������ҳ��
					dispose();
					new MainView().setVisible(true);
				}
			}
			catch(Exception e){
				System.out.println("δ֪����");
			}
			finally {
				dbUtil.clossCon(con);
			}
		}
	}
}