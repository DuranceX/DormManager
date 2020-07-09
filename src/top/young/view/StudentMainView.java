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
		
		JMenu menu = new JMenu("\u4FEE\u6539\u5BC6\u7801");
		menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StChangePswView stChangePswView = new StChangePswView();
				stChangePswView.setVisible(true);
				desktopPane.add(stChangePswView);
			}
		});
		menuBar.add(menu);
		
		JMenu menu_1 = new JMenu("\u67E5\u8BE2\u7535\u8D39");
		menu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(menu_1);
		
		JMenu menu_2 = new JMenu("\u62A5\u4FEE");
		menuBar.add(menu_2);
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
