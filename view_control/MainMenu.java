package view_control;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class MainMenu extends JFrame {

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
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		// JLabel with image 
		JLabel pic = new JLabel("");        
        java.awt.Image image = new ImageIcon("view_control/APCompSci.jpeg").getImage();
        pic.setIcon(new ImageIcon(image));
        pic.setBounds(377, 111, 128, 128);
        
        // Content Panel to add Label and Image
        //https://docs.oracle.com/javase/tutorial/uiswing/components/rootpane.html
        Container content = getContentPane();
        content.setBackground(new Color(100,100,255));
        content.add(pic);
        
        // Menu Objects 
        JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
        
		JMenu mnHone = new JMenu("Home");
		menuBar.add(mnHone);
		
		JMenuItem mntmPreferences = new JMenuItem("Preferences");
		mnHone.add(mntmPreferences);
		
		JMenu mnApTest = new JMenu("AP Test");
		menuBar.add(mnApTest);
		
		JMenuItem mntmApReview = new JMenuItem("Review");
		mntmApReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AP_UI frame = new AP_UI();
				frame.setVisible(true);
			}
		});
		mnApTest.add(mntmApReview);
		
		JMenu mnJig = new JMenu("Labs");
		menuBar.add(mnJig);
		
		JMenuItem mntmCalculator = new JMenuItem("Calculator");
		mntmCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorUI frame = new CalculatorUI();
				frame.setVisible(true);		
			}
		});
		mnJig.add(mntmCalculator);
		
		JMenuItem mntmMethodSearch = new JMenuItem("File Search");
		mntmMethodSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MethodSearchUI frame = new MethodSearchUI();
				frame.setVisible(true);
			}
		});
		
		JMenuItem mntmPalindrome = new JMenuItem("Palindrome");
		mntmPalindrome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PalindromeUI frame = new PalindromeUI();
				frame.setVisible(true);
			}
		});
		mnJig.add(mntmPalindrome);
		mnJig.add(mntmMethodSearch);
		
		JMenuItem mntmProgrammingLanguages = new JMenuItem("Model Search");
		mntmProgrammingLanguages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProgLang_UI frame = new ProgLang_UI();
				frame.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Method Show");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MethodShowUI frame = new MethodShowUI();
				frame.setVisible(true);
			}
		});
		mnJig.add(mntmNewMenuItem);
		mnJig.add(mntmProgrammingLanguages);
		
		
	}
	
}
