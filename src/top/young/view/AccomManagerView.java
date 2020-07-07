package top.young.view;

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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import top.young.dao.AccommodationDao;
import top.young.model.Accommodation;
import top.young.util.DbUtil;
import top.young.util.StringUtil;

@SuppressWarnings("serial")
public class AccomManagerView extends JInternalFrame {
	private JTextField SearchText;
	private JTable table;
	private DbUtil dbUtil = new DbUtil();
	private AccommodationDao accommodationDao = new AccommodationDao();
	private JTextField SnoText;
	private JTextField BnoText;
	private JTextField AnoText;
	private JTextField DnoText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccomManagerView frame = new AccomManagerView();
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
	public AccomManagerView() {
		setClosable(true);
		setTitle("\u4F4F\u5BBF\u4FE1\u606F\u66F4\u65B0");
		setBounds(100, 100, 597, 640);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel NameText = new JPanel();
		NameText.setBorder(new TitledBorder(null, "\u4FE1\u606F\u66F4\u65B0\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u641C\u7D22", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(NameText, GroupLayout.PREFERRED_SIZE, 490, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 489, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(NameText, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(74, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		SnoText = new JTextField();
		SnoText.setEnabled(false);
		SnoText.setFont(new Font("宋体", Font.PLAIN, 16));
		SnoText.setColumns(10);
		
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
		
		JButton btnNewButton_1 = new JButton("\u66F4\u65B0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateAccomActionPerformed(arg0);
			}

		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteAccomActionPerformed(arg0);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 16));
		GroupLayout gl_NameText = new GroupLayout(NameText);
		gl_NameText.setHorizontalGroup(
			gl_NameText.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NameText.createSequentialGroup()
					.addGroup(gl_NameText.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_NameText.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_NameText.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_NameText.createSequentialGroup()
									.addComponent(lblNewLabel_1_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(BnoText, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_NameText.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addGap(26)
									.addComponent(SnoText, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_NameText.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 60, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_NameText.createParallelGroup(Alignment.LEADING)
								.addComponent(AnoText, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
								.addComponent(DnoText, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
							.addGap(24))
						.addGroup(gl_NameText.createSequentialGroup()
							.addGap(154)
							.addComponent(btnNewButton_1)
							.addGap(50)
							.addComponent(btnNewButton_2)))
					.addContainerGap())
		);
		gl_NameText.setVerticalGroup(
			gl_NameText.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NameText.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_NameText.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(SnoText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(AnoText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_NameText.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(BnoText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(DnoText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_NameText.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton_2))
					.addContainerGap())
		);
		NameText.setLayout(gl_NameText);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		
		SearchText = new JTextField();
		SearchText.setFont(new Font("宋体", Font.PLAIN, 16));
		SearchText.setColumns(10);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getInfoBySno();
			}


		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(33)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(SearchText, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnNewButton)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(SearchText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
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
				"\u5B66\u53F7", "\u6240\u5C5E\u533A\u57DF", "\u6240\u5C5E\u697C\u680B", "\u5BBF\u820D\u7F16\u53F7"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);
		this.fillTable("");
	}
	/**
	 * 学生信息查询
	 */
	private void getInfoBySno() {
		// TODO Auto-generated method stub
		this.fillTable(this.SearchText.getText());
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
				rs = accommodationDao.list(con);
			else
				rs = accommodationDao.list(con,sno);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("Sno"));
				v.add(rs.getString("Ano"));
				v.add(rs.getString("Bno"));
				v.add(rs.getString("Dno"));
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
		this.SnoText.setText((String)table.getValueAt(row, 0));
		this.AnoText.setText((String)table.getValueAt(row, 1));
		this.BnoText.setText((String)table.getValueAt(row, 2));
		this.DnoText.setText((String)table.getValueAt(row, 3));
	}
	/**
	 * 删除住宿信息
	 * @param arg0
	 */
	private void deleteAccomActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String sno = this.SnoText.getText();
		if(StringUtil.isEmpty(sno)) {
			JOptionPane.showMessageDialog(null, "请先选择一条住宿信息");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "你确定要删除这条住宿信息吗？");
		if(n == 0) {
			//用户确定删除信息
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int res = accommodationDao.delete(con, sno);
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
		this.SnoText.setText("");
		this.DnoText.setText("");
	}
	/**
	 * 更新住宿信息操作
	 * @param arg0
	 */
	private void updateAccomActionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String sno = this.SnoText.getText();
		String ano = this.AnoText.getText();
		String bno = this.BnoText.getText();
		String dno = this.DnoText.getText();
		if(StringUtil.isEmpty(sno)) {
			JOptionPane.showMessageDialog(null, "请选择要修改的记录");
			return;
		}
		Accommodation accommodation = new Accommodation(sno,ano,bno,dno);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int updateCode = accommodationDao.update(con, accommodation);
			if(updateCode == 1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.fillTable("");
				this.resetNull();
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
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
