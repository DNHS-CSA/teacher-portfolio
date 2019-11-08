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
	private JTextField pali_result;
	
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
		lblPalindromeTester.setBounds(6, 6, 184, 26);
		contentPane.add(lblPalindromeTester);
		
		pali_input = new JTextField();
		pali_input.setBounds(6, 38, 438, 26);
		contentPane.add(pali_input);
		pali_input.setColumns(10);
		
		JButton btnTestPalindrome = new JButton("Test");
		btnTestPalindrome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pali_result.setText(palindrome.isPaliLog(pali_input.getText()));
			}
		});
		btnTestPalindrome.setBounds(153, 81, 145, 29);
		contentPane.add(btnTestPalindrome);
		
		pali_result = new JTextField();
		pali_result.setEditable(false);
		pali_result.setBounds(6, 129, 438, 143);
		contentPane.add(pali_result);
		pali_result.setColumns(10);
	}

}
