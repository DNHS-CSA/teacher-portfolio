package socialdistancing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/* Setting control Panel for Simulation
 * JLabel and JSlider work together to get inputs from User
 */
public class Settings extends JFrame {
	// simulation control starting values
	public static final int sNumPeople = 100;			// people in the simulation
	public static final double sToRoam = .10;			// % population that required to roam in simulation (essential workers, rule breakers)
	public static final double sToBeInfected = .02;		// % of population that has virus in simulation
	public static final double sToDie = .06;			// % population that would die out of those that get infected
	public static final int sSickTimeLow = 5000;		// Minimum time to recover 5 seconds
	public static final int sSickTimeMax = 10000;		// Max time to recover 10 seconds
		
	public int numPeople;
	public double toRoam;
	public double toBeInfected;
	public double toDie;
	public int sickTimeLow;
	public int sickTimeMax;
	
	public Settings(_Main mainCallBack) {
		setBounds(100, 100, 350, 650);	
		getContentPane().setLayout(null);
		
		// Number of people in Simulation
		JLabel labelNumPeople = new JLabel("Total Number of People in Simulation: ");
		labelNumPeople.setBounds(10, 11, 200, 14);
		getContentPane().add(labelNumPeople);
		JSlider sliderNumPeople = new JSlider(0,500,20);
		sliderNumPeople.setMajorTickSpacing(100);
		sliderNumPeople.setMinorTickSpacing(50);
		sliderNumPeople.setPaintTicks(true);
		sliderNumPeople.setPaintLabels(true);
		sliderNumPeople.setBounds(10, 36, 200, 45);
		getContentPane().add(sliderNumPeople);
		
		// Percentage of people initially infected
		JLabel labelToBeInfected = new JLabel("Percentage of People initially Infected:");
		labelToBeInfected.setBounds(10, 92, 233, 14);
		getContentPane().add(labelToBeInfected);
		JSlider sliderToBeInfected = new JSlider(0,100,5);
		sliderToBeInfected.setMajorTickSpacing(25);
		sliderToBeInfected.setMinorTickSpacing(10);
		sliderToBeInfected.setPaintTicks(true);
		sliderToBeInfected.setPaintLabels(true);
		sliderToBeInfected.setBounds(10, 117, 200, 45);
		getContentPane().add(sliderToBeInfected);
		
		// Percentage of people initially roaming in Simulation 
		JLabel labelToRoam = new JLabel("Percentage of People initially Roaming: ");
		getContentPane().add(labelToRoam);	
		JSlider sliderToRoam = new JSlider(0,100,5);
		sliderToRoam.setMajorTickSpacing(25);
		sliderToRoam.setMinorTickSpacing(10);
		sliderToRoam.setPaintTicks(true);
		sliderToRoam.setPaintLabels(true);
		sliderToRoam.setBounds(10, 198, 200, 45);
		getContentPane().add(sliderToRoam);
		
		// The fastest recovery time after being infected
		JLabel labelSickTimeLow = new JLabel("Fastest Recovery Time in Seconds:");
		labelSickTimeLow.setBounds(10, 254, 200, 14);
		getContentPane().add(labelSickTimeLow);
		JSlider sliderSickTimeLow = new JSlider(0,100,5);
		sliderSickTimeLow.setMajorTickSpacing(25);
		sliderSickTimeLow.setMinorTickSpacing(10);
		sliderSickTimeLow.setPaintTicks(true);
		sliderSickTimeLow.setPaintLabels(true);
		sliderSickTimeLow.setBounds(10, 279, 200, 45);
		getContentPane().add(sliderSickTimeLow);
		
		// The longest recovery time after being infected
		JLabel labelSickTimeMax = new JLabel("Slowest Recovery Time in Seconds:");
		labelSickTimeMax.setBounds(10, 335, 244, 14);
		getContentPane().add(labelSickTimeMax);	
		JSlider sliderSickTimeMax = new JSlider(0,100,5);
		sliderSickTimeMax.setMajorTickSpacing(25);
		sliderSickTimeMax.setMinorTickSpacing(10);
		sliderSickTimeMax.setPaintTicks(true);
		sliderSickTimeMax.setPaintLabels(true);
		sliderSickTimeMax.setBounds(10, 360, 200, 45);
		getContentPane().add(sliderSickTimeMax);
		
		// The percentage of people that don't recover from infection
		JLabel labelToDie = new JLabel("Percentage of People that Die after being infected:");
		labelToDie.setBounds(20, 416, 260, 14);
		getContentPane().add(labelToDie);		
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
				numPeople = sliderNumPeople.getValue();
				toRoam = sliderToRoam.getValue()/100.0;
				toBeInfected = sliderToBeInfected.getValue()/100.0;
				toDie = sliderToDie.getValue()/100.0;
				sickTimeLow = (sliderSickTimeLow.getValue()*1000);
				sickTimeMax = (sliderSickTimeMax.getValue()*1000);
				// call back to main to start new simulation
				mainCallBack.simulation();
			}
		});
		
		// initialize values based off of reasonable defaults
		sliderNumPeople.setValue(sNumPeople);
		sliderToRoam.setValue((int) (sToRoam*100));
		sliderToBeInfected.setValue((int) (sToBeInfected*100));
		sliderToDie.setValue((int) (sToDie*100));
		sliderSickTimeLow.setValue((int) (sSickTimeLow/1000));
		sliderSickTimeMax.setValue((int) (sSickTimeMax/1000));

		getContentPane().add(btnRunSimulation);
			
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
