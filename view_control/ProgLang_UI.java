package view_control;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

import model_prog_lang.Java;
import model_prog_lang.Python;
import model_prog_lang.Ruby;

public class ProgLang_UI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPleaseEnterThe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgLang_UI frame = new ProgLang_UI();
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
	public ProgLang_UI() {
				
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 706, 457);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPleaseEnterThe = new JTextField();
		txtPleaseEnterThe.setBackground(new Color(255, 250, 205));
		txtPleaseEnterThe.setBounds(16, 5, 466, 55);
		txtPleaseEnterThe.setText("Please Enter The Parameter You Want To Search Here");
		contentPane.add(txtPleaseEnterThe);
		txtPleaseEnterThe.setColumns(10);
		
		JLabel lblProgrammingLanguagesFound = new JLabel("Programming Languages Found:");
		lblProgrammingLanguagesFound.setForeground(new Color(25, 25, 112));
		lblProgrammingLanguagesFound.setBackground(new Color(0, 0, 128));
		lblProgrammingLanguagesFound.setBounds(5, 386, 687, 37);
		contentPane.add(lblProgrammingLanguagesFound);
		
		JButton btnPressToSearch = new JButton("Press to Search");
		btnPressToSearch.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnPressToSearch.setBorderPainted(false);
		btnPressToSearch.setOpaque(true);
		btnPressToSearch.setForeground(new Color(25, 25, 112));
		btnPressToSearch.setBounds(494, 10, 189, 46);
		//contentPane.add(btnPressToSearch);
		//btnPressToSearch.setOpaque(true);
		btnPressToSearch.setBackground(new Color(216, 191, 216));
		btnPressToSearch.setContentAreaFilled(true);
		contentPane.add(btnPressToSearch);
		
		JTextArea txtrListOfParameters = new JTextArea();
		txtrListOfParameters.setBackground(new Color(176, 224, 230));
		txtrListOfParameters.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		txtrListOfParameters.setBounds(5, 72, 217, 302);
		txtrListOfParameters.setText( new Python().toString() );
		contentPane.add(txtrListOfParameters);
		txtrListOfParameters.setLineWrap(true);
		
		JTextArea txtrListOfParameters_1 = new JTextArea();
		txtrListOfParameters_1.setBackground(new Color(176, 224, 230));
		txtrListOfParameters_1.setText( new Ruby().toString() );
		txtrListOfParameters_1.setLineWrap(true);
		txtrListOfParameters_1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		txtrListOfParameters_1.setBounds(230, 72, 224, 302);
		contentPane.add(txtrListOfParameters_1);
		
		JTextArea txtrJavaParameters = new JTextArea();
		txtrJavaParameters.setBackground(new Color(176, 224, 230));
		txtrJavaParameters.setText( new Java().toString() );
		txtrJavaParameters.setLineWrap(true);
		txtrJavaParameters.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		txtrJavaParameters.setBounds(460, 72, 232, 302);
		contentPane.add(txtrJavaParameters);
		btnPressToSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblProgrammingLanguagesFound.setText(model_prog_lang.AttributesSearch.main(txtPleaseEnterThe.getText()));
			}
		});
		
	}
}
