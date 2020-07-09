package top.young.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class StudentMainView extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private static String Username = null;
	private static String Psw = null;
	
	public static String getUsername() {
		return Username;
	}

	public static void setUsername(String username) {
		Username = username;
	}

	public static String getPsw() {
		return Psw;
	}

	public static void setPsw(String psw) {
		Psw = psw;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMainView frame = new StudentMainView();
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
	public StudentMainView() {
		setTitle("\u5B66\u751F\u7AEF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u4E2A\u4EBA\u4FE1\u606F");
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(menu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentPassUpdateView passUpdateView = new StudentPassUpdateView();
				passUpdateView.setVisible(true);
				desktopPane.add(passUpdateView);
			}
		});
		menu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u7535\u8D39\u67E5\u8BE2/\u5145\u503C");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StElecChargingView stElecChargingView = new StElecChargingView();
				stElecChargingView.setVisible(true);
				desktopPane.add(stElecChargingView);
			}
		});
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem menuItem = new JMenuItem("\u62A5\u4FEE");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentRepairView studentRepairView = new StudentRepairView();
				studentRepairView.setVisible(true);
				desktopPane.add(studentRepairView);
			}
		});
		menuBar.add(menuItem);
		
		JMenuItem menuItem_2 = new JMenuItem("                                   ");
		menuBar.add(menuItem_2);
		
		JMenuItem menuItem_4 = new JMenuItem("                                    ");
		menuBar.add(menuItem_4);
		
		JMenuItem menuItem_7 = new JMenuItem("                                     ");
		menuBar.add(menuItem_7);
		
		JMenuItem menuItem_9 = new JMenuItem("                                ");
		menuBar.add(menuItem_9);
		
		JMenuItem menuItem_8 = new JMenuItem("                                   ");
		menuBar.add(menuItem_8);
		
		JMenuItem menuItem_5 = new JMenuItem("                                   ");
		menuBar.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("                                         ");
		menuBar.add(menuItem_6);
		
		JMenuItem menuItem_3 = new JMenuItem("                                             ");
		menuBar.add(menuItem_3);
		
		JMenuItem menuItem_1 = new JMenuItem("                                      ");
		menuBar.add(menuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("                                                                                                 ");
		menuBar.add(mntmNewMenuItem_2);
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
