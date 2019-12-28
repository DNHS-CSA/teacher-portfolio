package view_control;
/**
 * UI to support MethodSearch evaluation
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
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import control_file_search.MethodSearch;

import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JList;

public class MethodSearchUI extends MainMenu {

	/**
	 * 
	 */
	// view section ++
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField filename;
	private JTextField searchTerm;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MethodSearchUI frame = new MethodSearchUI();
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
	public MethodSearchUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		DefaultListModel<String> l1 = new DefaultListModel<>();  // support for JList
		JList<String> list = new JList<>(l1);  					// l1 is JList working element
        list.setBounds(16,101, 414,137);  
        contentPane.add(list); 
       
		JLabel lblFileName = new JLabel("Search File Name");
		lblFileName.setBounds(6, 0, 184, 26);
		contentPane.add(lblFileName);
		
		filename = new JTextField();
		filename.setBounds(6, 21, 438, 26);
		contentPane.add(filename);
		filename.setColumns(10);
		filename.setText("control_ap_exam/BinaryMathQuestions.java");
		
		JLabel lblTerm = new JLabel("Search Term");
		lblTerm.setBounds(6, 38, 184, 26);
		contentPane.add(lblTerm);
		
		searchTerm = new JTextField();
		searchTerm.setColumns(10);
		searchTerm.setBounds(6, 63, 438, 26);
		contentPane.add(searchTerm);
		searchTerm.setText("Binary");

		JButton buttonTest = new JButton("Test");
		buttonTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> methods = MethodSearch.getMethods(filename.getText(), searchTerm.getText());
				l1.clear();
				for (String method: methods) {
					l1.addElement(method);
				}
			}
		});
		buttonTest.setBounds(275, 0, 145, 29);
		contentPane.add(buttonTest);
		
		JButton buttonTestConsole = new JButton("C");
		buttonTestConsole.setForeground(Color.RED);
		buttonTestConsole.setBackground(Color.LIGHT_GRAY);
		buttonTestConsole.setFont(new Font("Lucida Grande", Font.PLAIN, 8));
		buttonTestConsole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MethodSearch.main(filename.getText(), searchTerm.getText());
			}
		});
		buttonTestConsole.setBounds(419, 7, 21, 18);
		contentPane.add(buttonTestConsole); 
         
		
	}
}
