/**
 * UI to support pallindrome evaluation
 * 
 * support one input and multiple outputs
 * 
 * @version 1.0
 * @author John Mortensen
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PalindromeUI extends MenuControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField pali_input;
	private JTextField pali_resultIJ;
	private JTextField pali_resultRecursion;
	private JTextField pali_resultReplace;
	
	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PalindromeUI frame = new PalindromeUI();
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
	public PalindromeUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPalindromeTester = new JLabel("Enter Palindrome Candidate");
		lblPalindromeTester.setBounds(6, 0, 184, 26);
		contentPane.add(lblPalindromeTester);
		
		pali_input = new JTextField();
		pali_input.setBounds(6, 21, 438, 26);
		contentPane.add(pali_input);
		pali_input.setColumns(10);
		
		JButton btnTestPalindrome = new JButton("Test");
		btnTestPalindrome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Three calls to Palindrome 
				pali_resultIJ.setText(					// Set return value of call to IJ answer
						Palindrome.isPaliLog(			// Call Pali logic, test user input, return Log ^
								pali_input.getText(), 	// Get text from user input ^
								1));					// Pick Loop IJ (1)
				
				pali_resultRecursion.setText(			// Set return value of call to Backwards answer
						Palindrome.isPaliLog(			// Call Pali logic, test user input, return Log ^
								pali_input.getText(), 	// Get text from user input ^
								2));					// Pick Recursion (2)
				
				pali_resultReplace.setText(				// Set Pali return of call to Replace answer
						Palindrome.isPaliLog(			// Call Pali logic, test user input, return Log ^
								pali_input.getText(), 	// Get text from user input ^
								3));					// Pick Replace all (3)
				
			}
		});
		btnTestPalindrome.setBounds(152, 49, 145, 29);
		contentPane.add(btnTestPalindrome);
		
		pali_resultIJ = new JTextField();
		pali_resultIJ.setEditable(false);
		pali_resultIJ.setBounds(6, 82, 438, 47);
		contentPane.add(pali_resultIJ);
		pali_resultIJ.setColumns(10);
		
		pali_resultRecursion = new JTextField();
		pali_resultRecursion.setEditable(false);
		pali_resultRecursion.setColumns(10);
		pali_resultRecursion.setBounds(6, 141, 438, 47);
		contentPane.add(pali_resultRecursion);
		
		pali_resultReplace = new JTextField();
		pali_resultReplace.setEditable(false);
		pali_resultReplace.setColumns(10);
		pali_resultReplace.setBounds(6, 200, 438, 47);
		contentPane.add(pali_resultReplace);
	}

}
