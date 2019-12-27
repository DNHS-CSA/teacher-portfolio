package view_control;
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

import control_palindrome.Palindrome;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class PalindromeUI extends MainMenu {

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
	public static void main(String[] args) {
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JButton buttonTestPali = new JButton("Test");
		buttonTestPali.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Three calls to Pali Testers 
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
		buttonTestPali.setBounds(117, 41, 145, 29);
		contentPane.add(buttonTestPali);
		
		JButton buttonTestPaliC = new JButton("C");
		buttonTestPaliC.setForeground(Color.RED);
		buttonTestPaliC.setBackground(Color.LIGHT_GRAY);
		buttonTestPaliC.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		buttonTestPaliC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Call to Pali Console Tester 
				Palindrome.main(null);
			}
		});
		buttonTestPaliC.setBounds(423, 7, 21, 18);
		contentPane.add(buttonTestPaliC);
		
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
