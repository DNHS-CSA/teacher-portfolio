import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuControl extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuControl frame = new MenuControl();
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
	public MenuControl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCalculator = new JMenu("Home");
		menuBar.add(mnCalculator);
		
		JMenu mnJumpers = new JMenu("Intro");
		menuBar.add(mnJumpers);
		
		JMenuItem mntmOriginal = new JMenuItem("Jumpers");
		mnJumpers.add(mntmOriginal);
		
		JMenuItem mntmInputs = new JMenuItem("Pythagorean");
		mnJumpers.add(mntmInputs);
		
		JMenu mnNewMenu = new JMenu("Labs");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmShorthand = new JMenuItem("Shorthand");
		mnNewMenu.add(mntmShorthand);
		
		JMenuItem mntmPalindrom = new JMenuItem("Palindrom 3");
		mntmPalindrom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PalindromeUI frame = new PalindromeUI();
				frame.setVisible(true);			
			}
		});
		mnNewMenu.add(mntmPalindrom);
		
		
		JMenu mnSprint = new JMenu("Jigsaw");
		menuBar.add(mnSprint);
		
		JMenuItem mntmCalculator = new JMenuItem("Calculator");
		mntmCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calculator frame = new Calculator();
				frame.setVisible(true);		
			}
		});
		mnSprint.add(mntmCalculator);
		
		JMenuItem mntmMethodSearch = new JMenuItem("Method Search");
		mntmMethodSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MethodSearchUI frame = new MethodSearchUI();
				frame.setVisible(true);
			}
		});
		mnSprint.add(mntmMethodSearch);
		
		JMenuItem mntmApExam = new JMenuItem("AP Exam");
		mntmApExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AP_Exam.AP_Console.main();
			}
		});
		menuBar.add(mntmApExam);
		
	}
	
}
