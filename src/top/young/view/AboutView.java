package top.young.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class AboutView extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutView frame = new AboutView();
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
	public AboutView() {
		setTitle("\u5173\u4E8E\u6211\u4EEC");
		setClosable(true);
		setBounds(100, 100, 450, 410);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AboutView.class.getResource("/image/logo.jpg")));
		
		JLabel lblNewLabel_1 = new JLabel("\u4F5C\u8005\uFF1A\u9ECE\u6D0B \u8C22\u5609\u8FEA \u4E07\u5BA3\u6797 \u5F20\u65BD\u65BD");
		lblNewLabel_1.setFont(new Font("ËÎÌו", Font.PLAIN, 24));
		
		JLabel lblNewLabel_1_1 = new JLabel("\u4F5C\u54C1\uFF1A\u6C5F\u5927\u7248\u5B66\u751F\u5BBF\u820D\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_1_1.setFont(new Font("ËÎÌו", Font.PLAIN, 24));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(143)
					.addComponent(lblNewLabel)
					.addContainerGap(68, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(35, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel_1_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(19))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(42)
					.addComponent(lblNewLabel)
					.addGap(55)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(63, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
}
