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
public class AccomSearchView extends JInternalFrame {
	private JTextField SearchText;
	private JTable table;
	private DbUtil dbUtil = new DbUtil();
	private AccommodationDao accommodationDao = new AccommodationDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccomSearchView frame = new AccomSearchView();
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
	public AccomSearchView() {
		setClosable(true);
		setTitle("\u4F4F\u5BBF\u4FE1\u606F\u67E5\u8BE2");
		setBounds(100, 100, 597, 465);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u641C\u7D22", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 489, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(46, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(243, Short.MAX_VALUE))
		);
		
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
	
}
