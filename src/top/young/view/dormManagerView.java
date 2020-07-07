package top.young.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import top.young.dao.StudentDao;
import top.young.util.DbUtil;
import top.young.util.StringUtil;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class dormManagerView extends JInternalFrame {
	private JTextField SearchText;
	private JTable table;
	private DbUtil dbUtil = new DbUtil();
	private StudentDao studentDao = new StudentDao();
	private JTextField SnoText;
	private JTextField textField_1;
	private JTextField MajorText;
	private JTextField ClassText;
	private JTextField SexText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dormManagerView frame = new dormManagerView();
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
	public dormManagerView() {
		setClosable(true);
		setTitle("\u5B66\u751F\u4FE1\u606F\u7EF4\u62A4");
		setBounds(100, 100, 597, 667);
		
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
					.addComponent(NameText, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		SnoText = new JTextField();
		SnoText.setFont(new Font("宋体", Font.PLAIN, 16));
		SnoText.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 16));
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 16));
		
		MajorText = new JTextField();
		MajorText.setFont(new Font("宋体", Font.PLAIN, 16));
		MajorText.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u4E13\u4E1A\uFF1A");
		lblNewLabel_1_2.setFont(new Font("宋体", Font.PLAIN, 16));
		
		ClassText = new JTextField();
		ClassText.setFont(new Font("宋体", Font.PLAIN, 16));
		ClassText.setColumns(10);
		
		JLabel lblNewLabel_1_3 = new JLabel("\u73ED\u7EA7\uFF1A");
		lblNewLabel_1_3.setFont(new Font("宋体", Font.PLAIN, 16));
		
		SexText = new JTextField();
		SexText.setFont(new Font("宋体", Font.PLAIN, 16));
		SexText.setColumns(10);
		
		JLabel lblNewLabel_1_4 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_1_4.setFont(new Font("宋体", Font.PLAIN, 16));
		
		JButton btnNewButton_1 = new JButton("\u66F4\u65B0");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout gl_NameText = new GroupLayout(NameText);
		gl_NameText.setHorizontalGroup(
			gl_NameText.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NameText.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_NameText.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_NameText.createSequentialGroup()
							.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(SexText, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_NameText.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_NameText.createSequentialGroup()
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addGap(6)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_NameText.createSequentialGroup()
								.addComponent(lblNewLabel_1)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(SnoText, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_NameText.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_NameText.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_NameText.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_NameText.createSequentialGroup()
									.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(MajorText, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_NameText.createSequentialGroup()
									.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(ClassText, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_NameText.createSequentialGroup()
							.addGap(43)
							.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		gl_NameText.setVerticalGroup(
			gl_NameText.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_NameText.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_NameText.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_NameText.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_1)
							.addComponent(SnoText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_NameText.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addComponent(MajorText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_NameText.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_NameText.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addComponent(ClassText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_NameText.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_NameText.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_NameText.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addComponent(SexText, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u4E13\u4E1A", "\u73ED\u7EA7", "\u6027\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true
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
				rs = studentDao.list(con);
			else
				rs = studentDao.list(con,sno);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("Student.Sno"));
				v.add(rs.getString("Sname"));
				v.add(rs.getString("Major.Mname"));
				v.add(rs.getString("Cclass.CCname"));
				v.add(rs.getString("Ssex"));
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
}
