package view_control;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.MainMenu;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AP_UI extends MainMenu {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextArea testQuestion = new JTextArea();
    private JTextArea testChoices = new JTextArea();
    private JTextArea testQuestionAnswer = new JTextArea();
	
	/**
	 * Create the frame.
	 */
	public AP_UI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblExamSections = new JLabel("Exam Sections");
		lblExamSections.setBounds(16, 6, 91, 16);
		contentPane.add(lblExamSections);
		
		JButton btnMath = new JButton("Math");
		btnMath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model_ap_exam.Question q = new model_ap_exam.MathQuestions();
				testQuestion.setText(q.getQuestion());
				testChoices.setText(q.getChoices());
				testQuestionAnswer.setText(q.getAnswer());
			}
		});
		btnMath.setBounds(59, 21, 75, 29);
		contentPane.add(btnMath);
		
		JButton btnDataTypes = new JButton("Data Types");
		btnDataTypes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model_ap_exam.Question q = new model_ap_exam.DataTypeQuestions();
				testQuestion.setText(q.getQuestion());
				testChoices.setText(q.getChoices());
				testQuestionAnswer.setText(q.getAnswer());
			}
		});
		btnDataTypes.setBounds(131, 21, 131, 29);
		contentPane.add(btnDataTypes);
		
		JButton btnBinaryMath = new JButton("Binary Math");
		btnBinaryMath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model_ap_exam.Question q = new model_ap_exam.BinaryMathQuestions();
				testQuestion.setText(q.getQuestion());
				testChoices.setText(q.getChoices());
				testQuestionAnswer.setText(q.getAnswer());
			}
		});
		btnBinaryMath.setBounds(260, 21, 117, 29);
		contentPane.add(btnBinaryMath);
		
		JButton btnConsole = new JButton("C");
		btnConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AP_Console.main(null);
			}
		});
		btnConsole.setForeground(Color.RED);
		btnConsole.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		btnConsole.setBackground(Color.LIGHT_GRAY);
		btnConsole.setBounds(406, 21, 21, 18);
		contentPane.add(btnConsole);
		
		testQuestion.setEditable(false);
		testQuestion.setLineWrap(true);
		testQuestion.setBounds(16, 62, 418, 39);
		contentPane.add(testQuestion);
	    
		testChoices.setEditable(false);
		testChoices.setLineWrap(true);
		testChoices.setBounds(16, 113, 418, 86);
		contentPane.add(testChoices);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setBounds(16, 211, 61, 16);
		contentPane.add(lblAnswer);
		
		testQuestionAnswer.setEditable(false);
		testQuestionAnswer.setLineWrap(true);
		testQuestionAnswer.setBounds(74, 211, 357, 39);
		contentPane.add(testQuestionAnswer);
	
	}
}
