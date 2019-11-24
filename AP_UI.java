
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AP_Exam.AP_Console;
import AP_Exam.MathQuestions;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class AP_UI extends MenuControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public AP_UI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnMath_1 = new JButton("Math");
		btnMath_1.setBounds(55, 59, 75, 29);
		btnMath_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MathQuestions math = new MathQuestions();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnMath_1);
		
		JButton btnConversitions = new JButton("Converstions");
		btnConversitions.setBounds(135, 59, 131, 29);
		contentPane.add(btnConversitions);
		
		JButton btnBinaryMath = new JButton("Binary Math");
		btnBinaryMath.setBounds(271, 59, 117, 29);
		contentPane.add(btnBinaryMath);
		
		JLabel lblExamSections = new JLabel("Exam Sections");
		lblExamSections.setBounds(26, 21, 91, 16);
		contentPane.add(lblExamSections);
		
		JButton button = new JButton("C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AP_Console.main();
			}
		});
		button.setForeground(Color.RED);
		button.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(406, 21, 21, 18);
		contentPane.add(button);
	}
}
