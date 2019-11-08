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

public class palindromeUI extends menuControl {

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
/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					palindromeUI frame = new palindromeUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/

	/**
	 * Create the frame.
	 */
	public palindromeUI() {
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
				pali_resultIJ.setText(palindrome.isPaliLog(pali_input.getText()));
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
