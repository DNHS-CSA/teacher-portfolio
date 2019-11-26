
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AP_Exam.AP_Console;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AP_UI extends MenuControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextArea testQuestion = new JTextArea();
    private JTextArea testChoices = new JTextArea();
    private JTextField textField;

	
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
		btnMath_1.setBounds(59, 21, 75, 29);
		btnMath_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AP_Exam.Question q = new AP_Exam.MathQuestions();
				testQuestion.setText(q.getQuestion());
				testChoices.setText(q.getChoices());
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnMath_1);
		
		JButton btnConversitions = new JButton("Data Types");
		btnConversitions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AP_Exam.Question q = new AP_Exam.DataTypeQuestions();
				testQuestion.setText(q.getQuestion());
				testChoices.setText(q.getChoices());
			}
		});
		btnConversitions.setBounds(131, 21, 131, 29);
		contentPane.add(btnConversitions);
		
		JButton btnBinaryMath = new JButton("Binary Math");
		btnBinaryMath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AP_Exam.Question q = new AP_Exam.BinaryMathQuestions();
				testQuestion.setText(q.getQuestion());
				testChoices.setText(q.getChoices());
			}
		});
		btnBinaryMath.setBounds(260, 21, 117, 29);
		contentPane.add(btnBinaryMath);
		
		JLabel lblExamSections = new JLabel("Exam Sections");
		lblExamSections.setBounds(16, 6, 91, 16);
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
		
		JSeparator separator = new JSeparator();
		separator.setBounds(16, 51, 438, 16);
		contentPane.add(separator);
		
		testQuestion.setLineWrap(true);
		testQuestion.setEditable(false);
		testQuestion.setBounds(16, 79, 418, 39);
		contentPane.add(testQuestion);
	    
		testChoices.setLineWrap(true);
		testChoices.setEditable(false);
		testChoices.setBounds(16, 130, 418, 86);
		contentPane.add(testChoices);
		
		JLabel lblResponse = new JLabel("Response");
		lblResponse.setBounds(16, 228, 61, 16);
		contentPane.add(lblResponse);
		
		textField = new JTextField();
		textField.setBounds(77, 223, 36, 26);
		contentPane.add(textField);
		textField.setColumns(10);
	
	}
}
