package top.young.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
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
import javax.swing.table.DefaultTableModel;

import top.young.dao.RepairDao;
import top.young.model.Accommodation;
import top.young.util.DbUtil;
import top.young.util.StringUtil;

@SuppressWarnings("serial")
public class RepairManagerView extends JInternalFrame {
	private JTable table;
	private DbUtil dbUtil = new DbUtil();
	private RepairDao repairDao = new RepairDao();
	private JTextField idText;
	private JTextField BnoText;
	private JTextField AnoText;
	private JTextField DnoText;
	private JTextField textField;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RepairManagerView frame = new RepairManagerView();
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
	public RepairManagerView() {
		setClosable(true);
		setTitle("\u62A5\u4FEE\u670D\u52A1");
		setBounds(100, 100, 709, 724);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel NameText = new JPanel();
		NameText.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u62A5\u4FEE\u8BE6\u7EC6\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(NameText, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 585, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(72)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(NameText, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
					.addGap(63))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u7F16\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		idText = new JTextField();
		idText.setEnabled(false);
		idText.setFont(new Font("宋体", Font.PLAIN, 16));
		idText.setColumns(10);
		
		BnoText = new JTextField();
		BnoText.setFont(new Font("宋体", Font.PLAIN, 16));
		BnoText.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u6240\u5C5E\u697C\u680B\uFF1A");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		AnoText = new JTextField();
		AnoText.setFont(new Font("宋体", Font.PLAIN, 16));
		AnoText.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u6240\u5C5E\u533A\u57DF\uFF1A");
		lblNewLabel_1_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		DnoText = new JTextField();
		DnoText.setFont(new Font("宋体", Font.PLAIN, 16));
		DnoText.setColumns(10);
		
		JLabel lblNewLabel_1_3 = new JLabel("\u5BBF\u820D\u7F16\u53F7\uFF1A");
		lblNewLabel_1_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelActionPerformed(arg0);
			}


		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton btnNewButton_2 = new JButton("\u5DF2\u89E3\u51B3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteAccomActionPerformed(arg0);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 16));
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u62A5\u4FEE\u65F6\u95F4\uFF1A");
		lblNewLabel_1_1_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel("\u62A5\u4FEE\u539F\u56E0\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		textArea = new JTextArea();
		GroupLayout gl_NameText = new GroupLayout(NameText);
		gl_NameText.setHorizontalGroup(
			gl_NameText.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NameText.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_NameText.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_NameText.createSequentialGroup()
							.addGroup(gl_NameText.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_NameText.createSequentialGroup()
									.addComponent(lblNewLabel_1_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(BnoText, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_NameText.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(26)
									.addComponent(idText, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
							.addGap(67)
							.addGroup(gl_NameText.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_3, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_NameText.createParallelGroup(Alignment.LEADING)
								.addComponent(AnoText, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
								.addComponent(DnoText, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_NameText.createSequentialGroup()
							.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_NameText.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(48, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_NameText.createSequentialGroup()
					.addContainerGap(151, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addGap(86)
					.addComponent(btnNewButton_1)
					.addGap(190))
		);
		gl_NameText.setVerticalGroup(
			gl_NameText.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NameText.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_NameText.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_NameText.createSequentialGroup()
							.addGroup(gl_NameText.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(idText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(20)
							.addGroup(gl_NameText.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(BnoText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(DnoText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_NameText.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_NameText.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(AnoText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_NameText.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_NameText.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addGap(50))
		);
		NameText.setLayout(gl_NameText);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				fillSelectedItemToTexts(arg0);
			}

		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u6240\u5C5E\u533A\u57DF", "\u6240\u5C5E\u697C\u680B", "\u5BBF\u820D\u7F16\u53F7", "\u62A5\u4FEE\u65F6\u95F4", "\u62A5\u4FEE\u539F\u56E0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		this.fillTable("");
	}
	@SuppressWarnings("unchecked")
	public void fillTable(String sno) {
		DefaultTableModel dtm = (DefaultTableModel)table.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		ResultSet rs = null;
		try {
			con = dbUtil.getCon();
			if(StringUtil.isEmpty(sno))
				rs = repairDao.list(con);
			else
				return;
//				rs = repairDao.list(con,sno);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("Ano"));
				v.add(rs.getString("Bno"));
				v.add(rs.getString("Dno"));
				v.add(rs.getString("Submittime"));
				v.add(rs.getString("Rreason"));
				dtm.addRow(v);
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
	 * 点击表格事件
	 * @param arg0
	 */
	private void fillSelectedItemToTexts(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		this.idText.setText((String)table.getValueAt(row, 0));
		this.AnoText.setText((String)table.getValueAt(row, 1));
		this.BnoText.setText((String)table.getValueAt(row, 2));
		this.DnoText.setText((String)table.getValueAt(row, 3));
		this.textField.setText((String)table.getValueAt(row, 4));
		this.textArea.setText((String)table.getValueAt(row, 5));
//		this.
	}
	/**
	 * 删除报修信息
	 * @param arg0
	 */
	private void deleteAccomActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String sno = this.idText.getText();
		if(StringUtil.isEmpty(sno)) {
			JOptionPane.showMessageDialog(null, "请先选择一条报修信息");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "你确定要删除这条报修信息吗？");
		if(n == 0) {
			//用户确定删除信息
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int res = repairDao.delete(con, sno);
				if(res==1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.fillTable("");
					this.resetNull();
					
				}else {
					JOptionPane.showMessageDialog(null, "删除失败");
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
	}
	/**
	 * 表单信息置空
	 */
	public void resetNull() {
		this.AnoText.setText("");
		this.BnoText.setText("");
		this.idText.setText("");
		this.DnoText.setText("");
		this.textField.setText("");
		this.textArea.setText("");
	}

	private void cancelActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		this.resetNull();
	}

}
