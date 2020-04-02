package socialdistancing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Settings extends JFrame {
	
	public Settings() {
		setBounds(100, 100, 350, 650);
		
		getContentPane().setLayout(null);
		
		JLabel lblTotalNumberOf = new JLabel("Total Number of People: ");
		lblTotalNumberOf.setBounds(10, 11, 200, 14);
		getContentPane().add(lblTotalNumberOf);
		
		JSlider sliderNumPpl = new JSlider(0,500,20);
		sliderNumPpl.setMajorTickSpacing(100);
		sliderNumPpl.setMinorTickSpacing(50);
		sliderNumPpl.setPaintTicks(true);
		sliderNumPpl.setPaintLabels(true);
		sliderNumPpl.setBounds(10, 36, 200, 45);
		getContentPane().add(sliderNumPpl);
		
		JLabel lblNumberOfPeople = new JLabel("Percentage of People to be Infected:");
		lblNumberOfPeople.setBounds(10, 92, 233, 14);
		getContentPane().add(lblNumberOfPeople);
		
		JSlider sliderInfected = new JSlider(0,100,5);
		sliderInfected.setMajorTickSpacing(25);
		sliderInfected.setMinorTickSpacing(10);
		sliderInfected.setPaintTicks(true);
		sliderInfected.setPaintLabels(true);
		sliderInfected.setBounds(10, 117, 200, 45);
		getContentPane().add(sliderInfected);
		
		JLabel lblNumberOfMoving = new JLabel("Percentage of Moving People:");
		lblNumberOfMoving.setBounds(10, 173, 233, 14);
		getContentPane().add(lblNumberOfMoving);
		
		JSlider slider_2 = new JSlider(0,100,5);
		slider_2.setMajorTickSpacing(25);
		slider_2.setMinorTickSpacing(10);
		slider_2.setPaintTicks(true);
		slider_2.setPaintLabels(true);
		slider_2.setBounds(10, 198, 200, 45);
		getContentPane().add(slider_2);
		
		JLabel lblFastestRecoveryTime = new JLabel("Fastest Recovery Time:");
		lblFastestRecoveryTime.setBounds(10, 254, 200, 14);
		getContentPane().add(lblFastestRecoveryTime);
		
		JSlider slider_3 = new JSlider(0,100,5);
		slider_3.setMajorTickSpacing(25);
		slider_3.setMinorTickSpacing(10);
		slider_3.setPaintTicks(true);
		slider_3.setPaintLabels(true);
		slider_3.setBounds(10, 279, 200, 45);
		getContentPane().add(slider_3);
		
		JLabel lblSlowestRecoveryTime = new JLabel("Slowest Recovery Time:");
		lblSlowestRecoveryTime.setBounds(10, 335, 244, 14);
		getContentPane().add(lblSlowestRecoveryTime);
		
		JSlider slider_4 = new JSlider(0,100,5);
		slider_4.setMajorTickSpacing(25);
		slider_4.setMinorTickSpacing(10);
		slider_4.setPaintTicks(true);
		slider_4.setPaintLabels(true);
		slider_4.setBounds(10, 360, 200, 45);
		getContentPane().add(slider_4);
		JLabel lblPercentageOfPeople = new JLabel("Percentage of People to Die:");
		lblPercentageOfPeople.setBounds(20, 416, 260, 14);
		getContentPane().add(lblPercentageOfPeople);
		
		JSlider slider = new JSlider(0,100,5);
		slider.setMajorTickSpacing(25);
		slider.setMinorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBounds(10, 441, 200, 45);
		getContentPane().add(slider);
		
		JButton btnRunSimulation = new JButton("Run Simulation");
		btnRunSimulation.setBounds(10, 525, 200, 23);
		btnRunSimulation.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("pressed button");
				 int np = sliderNumPpl.getValue();
				 double roam = (slider_2.getValue()/100);
				 double infected = sliderInfected.getValue();
				 double die = slider.getValue();
				 int sicklow = (slider_3.getValue()*800);
				 int sickMax = (slider_4.getValue()*800);
				new Control(np, roam, infected, die, sicklow, sickMax);
			}
		}
				
				);
		getContentPane().add(btnRunSimulation);
		
		
	
	
	
	
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
