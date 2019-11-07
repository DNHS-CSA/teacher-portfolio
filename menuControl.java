import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menuControl extends JFrame {

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
					menuControl frame = new menuControl();
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
	public menuControl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("Midterm");
		menuBar.add(mnFile);
		
		JMenuItem mntmStartrestart = new JMenuItem("Start/Restart");
		mnFile.add(mntmStartrestart);
		
		JMenuItem mntmScore = new JMenuItem("Score");
		mnFile.add(mntmScore);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		mnFile.add(mnNewMenu_1);
		
		JMenu mnCalculator = new JMenu("Intro");
		menuBar.add(mnCalculator);
		
		JMenu mnJumpers = new JMenu("Jumpers");
		mnCalculator.add(mnJumpers);
		
		JMenuItem mntmOriginal = new JMenuItem("Original");
		mnJumpers.add(mntmOriginal);
		
		JMenuItem mntmInputs = new JMenuItem("Inputs");
		mnJumpers.add(mntmInputs);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Pythagorus");
		mnCalculator.add(mntmNewMenuItem);
		
		JMenu mnNewMenu = new JMenu("Sprint 1");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmShorthand = new JMenuItem("Shorthand");
		mnNewMenu.add(mntmShorthand);
		
		JMenuItem mntmPalindrom = new JMenuItem("Palindrom 3");
		mnNewMenu.add(mntmPalindrom);
		
		JMenu mnSprint = new JMenu("Sprint 2");
		menuBar.add(mnSprint);
		
		JMenuItem mntmCalculator = new JMenuItem("Calculator");
		mntmCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator frame = new calculator();
				frame.setVisible(true);			
			}
		});
		mnSprint.add(mntmCalculator);
		
	}
	
}
