package view_control;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control_ap_exam.APexam;

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
    private APexam exam = new APexam(20);
	
    /**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AP_UI frame = new AP_UI();
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
	public AP_UI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblExamSections = new JLabel("Exam Sections");
		lblExamSections.setBounds(12, 4, 91, 16);
		contentPane.add(lblExamSections);
		
		JButton btnMath = new JButton("Math");
		btnMath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model_questions.Question q = new control_ap_exam.MathQuestions();
				testQuestion.setText(q.getQuestion());
				testChoices.setText(q.getChoices());
				testQuestionAnswer.setText(q.getAnswer());
			}
		});
		btnMath.setBounds(0, 21, 75, 29);
		contentPane.add(btnMath);
		
		JButton btnDataTypes = new JButton("Data Types");
		btnDataTypes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model_questions.Question q = new control_ap_exam.DataTypeQuestions();
				testQuestion.setText(q.getQuestion());
				testChoices.setText(q.getChoices());
				testQuestionAnswer.setText(q.getAnswer());
			}
		});
		btnDataTypes.setBounds(64, 21, 131, 29);
		contentPane.add(btnDataTypes);
		
		JButton btnBinaryMath = new JButton("Binary Math");
		btnBinaryMath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model_questions.Question q = new control_ap_exam.BinaryMathQuestions();
				testQuestion.setText(q.getQuestion());
				testChoices.setText(q.getChoices());
				testQuestionAnswer.setText(q.getAnswer());
			}
		});
		btnBinaryMath.setBounds(183, 21, 117, 29);
		contentPane.add(btnBinaryMath);
		
		JButton btnRev = new JButton("<");
		btnRev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model_questions.Question q = exam.getQuestionRev();
				testQuestion.setText(q.getID() + ". " + q.getQuestion());
				testChoices.setText(q.getChoices());
				testQuestionAnswer.setText(q.getAnswer());
			}
		});
		btnRev.setBounds(312, 21, 39, 29);
		contentPane.add(btnRev);
		
		JButton btnFWD = new JButton(">");
		btnFWD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model_questions.Question q = exam.getQuestionFwd();
				testQuestion.setText(q.getID() + ". " + q.getQuestion());
				testChoices.setText(q.getChoices());
				testQuestionAnswer.setText(q.getAnswer());
			}
		});
		btnFWD.setBounds(390, 21, 39, 29);
		contentPane.add(btnFWD);
		
		JButton btnConsole = new JButton("C");
		btnConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AP_Console.main(null);
			}
		});
		btnConsole.setForeground(Color.RED);
		btnConsole.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		btnConsole.setBackground(Color.LIGHT_GRAY);
		btnConsole.setBounds(115, 4, 21, 18);
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
		
		JLabel lblqs = new JLabel("20Qs");
		lblqs.setBounds(354, 26, 39, 16);
		contentPane.add(lblqs);
		
	}
}
