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
		
		JSlider sliderNumPeople = new JSlider(0,500,20);
		sliderNumPeople.setMajorTickSpacing(100);
		sliderNumPeople.setMinorTickSpacing(50);
		sliderNumPeople.setPaintTicks(true);
		sliderNumPeople.setPaintLabels(true);
		sliderNumPeople.setBounds(10, 36, 200, 45);
		getContentPane().add(sliderNumPeople);
		
		JLabel lblNumberOfPeople = new JLabel("Percentage of People to be Infected:");
		lblNumberOfPeople.setBounds(10, 92, 233, 14);
		getContentPane().add(lblNumberOfPeople);
		
		JSlider sliderToBeInfected = new JSlider(0,100,5);
		sliderToBeInfected.setMajorTickSpacing(25);
		sliderToBeInfected.setMinorTickSpacing(10);
		sliderToBeInfected.setPaintTicks(true);
		sliderToBeInfected.setPaintLabels(true);
		sliderToBeInfected.setBounds(10, 117, 200, 45);
		getContentPane().add(sliderToBeInfected);
		
		JLabel lblNumberOfMoving = new JLabel("Percentage of Moving People:");
		lblNumberOfMoving.setBounds(10, 173, 233, 14);
		getContentPane().add(lblNumberOfMoving);
		
		JSlider sliderToRoam = new JSlider(0,100,5);
		sliderToRoam.setMajorTickSpacing(25);
		sliderToRoam.setMinorTickSpacing(10);
		sliderToRoam.setPaintTicks(true);
		sliderToRoam.setPaintLabels(true);
		sliderToRoam.setBounds(10, 198, 200, 45);
		getContentPane().add(sliderToRoam);
		
		JLabel lblFastestRecoveryTime = new JLabel("Fastest Recovery Time:");
		lblFastestRecoveryTime.setBounds(10, 254, 200, 14);
		getContentPane().add(lblFastestRecoveryTime);
		
		JSlider sliderSickTimeLow = new JSlider(0,100,5);
		sliderSickTimeLow.setMajorTickSpacing(25);
		sliderSickTimeLow.setMinorTickSpacing(10);
		sliderSickTimeLow.setPaintTicks(true);
		sliderSickTimeLow.setPaintLabels(true);
		sliderSickTimeLow.setBounds(10, 279, 200, 45);
		getContentPane().add(sliderSickTimeLow);
		
		JLabel lblSlowestRecoveryTime = new JLabel("Slowest Recovery Time:");
		lblSlowestRecoveryTime.setBounds(10, 335, 244, 14);
		getContentPane().add(lblSlowestRecoveryTime);
		
		JSlider sliderSickTimeMax = new JSlider(0,100,5);
		sliderSickTimeMax.setMajorTickSpacing(25);
		sliderSickTimeMax.setMinorTickSpacing(10);
		sliderSickTimeMax.setPaintTicks(true);
		sliderSickTimeMax.setPaintLabels(true);
		sliderSickTimeMax.setBounds(10, 360, 200, 45);
		getContentPane().add(sliderSickTimeMax);
		JLabel lblPercentageOfPeople = new JLabel("Percentage of People to Die:");
		lblPercentageOfPeople.setBounds(20, 416, 260, 14);
		getContentPane().add(lblPercentageOfPeople);
		
		JSlider sliderToDie = new JSlider(0,100,5);
		sliderToDie.setMajorTickSpacing(25);
		sliderToDie.setMinorTickSpacing(10);
		sliderToDie.setPaintTicks(true);
		sliderToDie.setPaintLabels(true);
		sliderToDie.setBounds(10, 441, 200, 45);
		getContentPane().add(sliderToDie);
		
		JButton btnRunSimulation = new JButton("Run Simulation");
		btnRunSimulation.setBounds(10, 525, 200, 23);
		btnRunSimulation.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Control.numPeople = sliderNumPeople.getValue();
				Control.toRoam = sliderToRoam.getValue()/100.0;
				Control.toBeInfected = sliderToBeInfected.getValue()/100.0;
				Control.toDie = sliderToDie.getValue()/100.0;
				Control.sickTimeLow = (sliderSickTimeLow.getValue()*1000);
				Control.sickTimeMax = (sliderSickTimeMax.getValue()*1000);		
				new Control();

			}
		});
		sliderNumPeople.setValue(Control.numPeople);
		sliderToRoam.setValue((int) (Control.toRoam*100));
		sliderToBeInfected.setValue((int) (Control.toBeInfected*100));
		sliderToDie.setValue((int) (Control.toDie*100));
		sliderSickTimeLow.setValue((int) (Control.sickTimeLow/1000));
		sliderSickTimeMax.setValue((int) (Control.sickTimeMax/1000));

		getContentPane().add(btnRunSimulation);
			
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
