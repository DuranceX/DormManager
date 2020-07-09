package top.young.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class StElecChargingView extends JInternalFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StElecChargingView frame = new StElecChargingView();
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
	public StElecChargingView() {
		setBounds(100, 100, 512, 390);
		
		JLabel label = new JLabel("\u5F53\u524D\u7535\u8D39\u4F59\u989D\uFF1A");
		label.setBounds(105, 174, 141, 45);
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JLabel balance = new JLabel("");
		balance.setBounds(234, 174, 66, 45);
		balance.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JLabel label_2 = new JLabel("\u5143");
		label_2.setBounds(306, 174, 58, 45);
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		JLabel label_1 = new JLabel("\u8F93\u5165\u5145\u503C\u91D1\u989D\uFF1A");
		label_1.setBounds(105, 225, 141, 45);
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setBounds(234, 232, 66, 30);
		textField.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		textField.setColumns(10);
		getContentPane().setLayout(null);
		getContentPane().add(label_1);
		getContentPane().add(textField);
		getContentPane().add(label);
		getContentPane().add(balance);
		getContentPane().add(label_2);
		
		JLabel label_2_1 = new JLabel("\u5143");
		label_2_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		label_2_1.setBounds(306, 225, 58, 45);
		getContentPane().add(label_2_1);
		
		JButton btnNewButton = new JButton("\u5145\u503C");
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btnNewButton.setBounds(118, 288, 96, 33);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btnNewButton_1.setBounds(236, 288, 96, 33);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblXuanze = new JLabel("\u9009\u62E9\u533A\u57DF\uFF1A");
		lblXuanze.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblXuanze.setBounds(105, 28, 141, 45);
		getContentPane().add(lblXuanze);
		
		JLabel lblXuanze_1 = new JLabel("\u9009\u62E9\u697C\u680B\uFF1A");
		lblXuanze_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblXuanze_1.setBounds(105, 76, 141, 45);
		getContentPane().add(lblXuanze_1);
		
		JLabel lblXuanze_2 = new JLabel("\u9009\u62E9\u5BBF\u820D\uFF1A");
		lblXuanze_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		lblXuanze_2.setBounds(105, 119, 141, 45);
		getContentPane().add(lblXuanze_2);
		
		JComboBox BuildingComboBox = new JComboBox();
		BuildingComboBox.setBounds(199, 88, 141, 27);
		getContentPane().add(BuildingComboBox);
		
		JComboBox DormComboBox = new JComboBox();
		DormComboBox.setBounds(199, 131, 141, 27);
		getContentPane().add(DormComboBox);
		
		JComboBox BuildingComboBox_1 = new JComboBox();
		BuildingComboBox_1.setBounds(199, 40, 141, 27);
		getContentPane().add(BuildingComboBox_1);

	}
}
