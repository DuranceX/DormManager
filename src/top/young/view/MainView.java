package top.young.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setTitle("\u5B66\u751F\u5BBF\u820D\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 780);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7CFB\u7EDF\u83DC\u5355");
		mnNewMenu.setIcon(new ImageIcon(MainView.class.getResource("/image/base.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mnNewMenu.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_1 = new JMenu("\u5B66\u751F\u4FE1\u606F");
		mnNewMenu_1.setIcon(new ImageIcon(MainView.class.getResource("/image/addUser.png")));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u589E\u52A0\u5B66\u751F\u4FE1\u606F");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentInfoAddView studentInfoAddView = new StudentInfoAddView();
				studentInfoAddView.setVisible(true);
				desktopPane.add(studentInfoAddView);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u67E5\u8BE2\u5B66\u751F\u4FE1\u606F");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentManagerView studentManagerView = new StudentManagerView();
				studentManagerView.setVisible(true);
				desktopPane.add(studentManagerView);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_5 = new JMenu("\u4F4F\u5BBF\u4FE1\u606F");
		mnNewMenu_5.setIcon(new ImageIcon(MainView.class.getResource("/image/userName.png")));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("\u6DFB\u52A0\u4F4F\u5BBF\u4FE1\u606F");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccomAddView accomAddView = new AccomAddView();
				accomAddView.setVisible(true);
				desktopPane.add(accomAddView);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("\u66F4\u65B0\u4F4F\u5BBF\u4FE1\u606F");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AccomManagerView accomManagerView = new AccomManagerView();
				accomManagerView.setVisible(true);
				desktopPane.add(accomManagerView);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_12);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("\u67E5\u8BE2\u4F4F\u5BBF\u4FE1\u606F");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccomSearchView accomSearchView = new AccomSearchView();
				accomSearchView.setVisible(true);
				desktopPane.add(accomSearchView);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_13);
		
		JMenu mnNewMenu_2 = new JMenu("\u697C\u680B\u4FE1\u606F");
		mnNewMenu_2.setIcon(new ImageIcon(MainView.class.getResource("/image/edit.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u6DFB\u52A0\u697C\u680B\u4FE1\u606F");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuildingAddView buildingAddView = new BuildingAddView();
				buildingAddView.setVisible(true);
				desktopPane.add(buildingAddView);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("\u66F4\u65B0\u697C\u680B\u4FE1\u606F");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuildingUpdateView buildingUpdateView = new BuildingUpdateView();
				buildingUpdateView.setVisible(true);
				desktopPane.add(buildingUpdateView);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_14);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("\u5220\u9664\u697C\u680B\u4FE1\u606F");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuildingDeleteView buildingDeleteView = new BuildingDeleteView();
				buildingDeleteView.setVisible(true);
				desktopPane.add(buildingDeleteView);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_15);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("\u67E5\u8BE2\u5BBF\u820D\u4FE1\u606F");
		mnNewMenu_2.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_4 = new JMenu("\u5E38\u7528\u529F\u80FD");
		mnNewMenu_4.setIcon(new ImageIcon(MainView.class.getResource("/image/exit.png")));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u62A5\u4FEE\u670D\u52A1");
		mnNewMenu_4.add(mntmNewMenuItem_9);
		
		JMenu mnNewMenu_6 = new JMenu("\u665A\u5F52\u8BB0\u5F55");
		mnNewMenu_4.add(mnNewMenu_6);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u6DFB\u52A0\u665A\u5F52\u8BB0\u5F55");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddLateView addLateView = new AddLateView();
				addLateView.setVisible(true);
				desktopPane.add(addLateView);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u6839\u636E\u5B66\u53F7\u67E5\u8BE2\u665A\u5F52\u8BB0\u5F55");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LateSearchView lateSearchView = new LateSearchView();
				lateSearchView.setVisible(true);
				desktopPane.add(lateSearchView);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_16 = new JMenuItem("\u6839\u636E\u65E5\u671F\u67E5\u8BE2\u665A\u5F52\u8BB0\u5F55");
		mntmNewMenuItem_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LateSearchView2 lateSearchView = new LateSearchView2();
				lateSearchView.setVisible(true);
				desktopPane.add(lateSearchView);
			}
		});
		mnNewMenu_6.add(mntmNewMenuItem_16);
		
		JMenu mnNewMenu_3 = new JMenu("\u5173\u4E8E");
		mnNewMenu_3.setIcon(new ImageIcon(MainView.class.getResource("/image/about.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		mnNewMenu_3.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u5E2E\u52A9");
		mnNewMenu_3.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
		setExtendedState( this.getExtendedState()|JFrame.MAXIMIZED_BOTH );
	}
}
