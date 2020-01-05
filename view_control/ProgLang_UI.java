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

import control_prog_lang.ProgLangAttributes;
import control_prog_lang.Java;
import control_prog_lang.ProgLangManager;
import control_prog_lang.Python;
import control_prog_lang.Ruby;
import util.ConsoleMethods;

public class ProgLang_UI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSearchTerm;
	
	// Control variables for data
	ProgLangManager pLM = new ProgLangManager();
	ProgLangManager pLMbak = null;
	
	private int posIndex = 0;


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
		
		txtSearchTerm = new JTextField();
		txtSearchTerm.setBackground(new Color(255, 250, 205));
		txtSearchTerm.setBounds(16, 5, 466, 55);
		txtSearchTerm.setText("Please Enter Filter Term Here");
		contentPane.add(txtSearchTerm);
		txtSearchTerm.setColumns(10);
		
		JLabel lblProgLangFound = new JLabel("Programming Languages Found:");
		lblProgLangFound.setForeground(new Color(25, 25, 112));
		lblProgLangFound.setBackground(new Color(0, 0, 128));
		lblProgLangFound.setBounds(5, 386, 687, 37);
		contentPane.add(lblProgLangFound);
		
		JButton btnPressToSearch = new JButton("Press to Filter");
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
		
		JTextArea txtrBox1 = new JTextArea();
		txtrBox1.setBackground(new Color(176, 224, 230));
		txtrBox1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		txtrBox1.setBounds(29, 72, 201, 302);
		txtrBox1.setText( pLM.getProgLangByIndex(posIndex).toString() );
		contentPane.add(txtrBox1);
		txtrBox1.setLineWrap(true);
		
		JTextArea txtrBox2 = new JTextArea();
		txtrBox2.setBackground(new Color(176, 224, 230));
		txtrBox2.setText( pLM.getProgLangByIndex(posIndex+1).toString() );
		txtrBox2.setLineWrap(true);
		txtrBox2.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		txtrBox2.setBounds(242, 72, 208, 302);
		contentPane.add(txtrBox2);
		
		JTextArea txtrBox3 = new JTextArea();
		txtrBox3.setBackground(new Color(176, 224, 230));
		txtrBox3.setText( pLM.getProgLangByIndex(posIndex+2).toString()  );
		txtrBox3.setLineWrap(true);
		txtrBox3.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		txtrBox3.setBounds(462, 72, 217, 302);
		contentPane.add(txtrBox3);
		
		JButton button_shift_right = new JButton(">");
		button_shift_right.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Shift position index to right
				posIndex = pLM.incrementPositon(posIndex);
				// setter
				setTextBoxes( txtrBox1,  txtrBox2,  txtrBox3);
			}
		});
		button_shift_right.setBounds(679, 197, 27, 55);
		contentPane.add(button_shift_right);
		
		JButton button_shift_left = new JButton("<");
		button_shift_left.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Shift position index to left
				posIndex = pLM.decrementPositon(posIndex);
				// setter
				setTextBoxes( txtrBox1,  txtrBox2,  txtrBox3);
			}
		});
		button_shift_left.setBounds(0, 197, 27, 55);
		contentPane.add(button_shift_left);
		btnPressToSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Control variables
				posIndex = 0;
				if (pLMbak == null) pLMbak = pLM;
				
				// build a string of languages meeting filter
				String Answer = pLMbak.searchProgLangs(txtSearchTerm.getText());
				if (Answer.length() <= 1)
					Answer = "No match";
				lblProgLangFound.setText(Answer);
				
				// build a filtered list
				pLM = new ProgLangManager(pLMbak, txtSearchTerm.getText());
				// setter
				setTextBoxes( txtrBox1,  txtrBox2,  txtrBox3);
				
			}
		});
		
	}
	
	private void setTextBoxes(JTextArea txtrBox1, JTextArea txtrBox2, JTextArea txtrBox3)
	{	
		// set labels
		control_prog_lang.ProgLangAttributes am;
		txtrBox1.setText("");
		txtrBox2.setText("");
		txtrBox3.setText("");
		for (int i = 0; i < 3 && i < pLM.getSize(); i++) {
			am = pLM.getProgLangByIndex(posIndex+i);
			switch (i) {
			case 0:
				txtrBox1.setText(am.toString());
				break;
			case 1:
				txtrBox2.setText(am.toString());
				break;
			case 2:
				txtrBox3.setText(am.toString());
				break;
			}
		}
	}
	
}
