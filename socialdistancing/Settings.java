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
	//simulation control starting values (constants)
	//health controls
	public static final int sNumPeople = 100;			// people in the simulation
	public static final double sToRoam = .10;			// % population that required to roam in simulation (essential workers, rule breakers)
	public static final double sToBeInfected = .02;		// % of population that has virus in simulation
	public static final double sToDie = .06;			// % population that would die out of those that get infected
	public static final int sSickTimeLow = 5000;		// Minimum time to recover 5 seconds
	public static final int sSickTimeMax = 10000;		// Max time to recover 10 seconds
	//frame extents
	public static final int sFrameX = 800;
	public static final int sFrameY = 600;
	//position extents, keep objects away from the edges
	public static final int sXExt = (int) (sFrameX - sFrameX*.04);
	public static final int sYExt = (int) (sFrameY - sFrameY*.03);
	//oval size, represents person in frame
	public static final int sOvalW = 10;	//Height
	public static final int sOvalH = 10;	//Width
	//refresh timer, also used to calculate time/age of infection
	public static final int sTimerValue = 16;

	//simulation control customizations for people
	public int numPeople = sNumPeople;
	public double toRoam = sToRoam;
	public double toBeInfected = sToBeInfected;
	public double toDie = sToDie;
	public int sickTimeLow = sSickTimeLow;
	public int sickTimeMax = sSickTimeMax;
	//simulation control customization for frame
	public int frameX = sFrameX;
	public int frameY = sFrameY;
	public int xExt = sXExt;
	public int yExt = sYExt;
	public int OvalW = sOvalW;
	public int OvalH = sOvalH;
	//simulation control refresh timer, also used to calculate time/age of infection
	public int timerValue = sTimerValue;
	
	public Settings(_Main mainCallBack) {
		setBounds(100, 100, 350, 650);	
		getContentPane().setLayout(null);
		
		// Number of people in Simulation
		JLabel labelNumPeople = new JLabel("Total Number of People in Simulation: ");
		labelNumPeople.setBounds(6, 30, 244, 14);
		getContentPane().add(labelNumPeople);
		JSlider sliderNumPeople = new JSlider(0,500,20);
		sliderNumPeople.setMajorTickSpacing(100);
		sliderNumPeople.setMinorTickSpacing(50);
		sliderNumPeople.setPaintTicks(true);
		sliderNumPeople.setPaintLabels(true);
		sliderNumPeople.setBounds(10, 42, 200, 45);
		getContentPane().add(sliderNumPeople);
		
		// Percentage of people initially infected
		JLabel labelToBeInfected = new JLabel("Percentage of People initially Infected:");
		labelToBeInfected.setBounds(6, 110, 270, 14);
		getContentPane().add(labelToBeInfected);
		JSlider sliderToBeInfected = new JSlider(0,10,1);
		sliderToBeInfected.setMajorTickSpacing(5);
		sliderToBeInfected.setMinorTickSpacing(1);
		sliderToBeInfected.setPaintTicks(true);
		sliderToBeInfected.setPaintLabels(true);
		sliderToBeInfected.setBounds(6, 123, 200, 45);
		getContentPane().add(sliderToBeInfected);
		
		// Percentage of people initially roaming in Simulation 
		JLabel labelToRoam = new JLabel("Percentage of People initially Roaming: ");
		labelToRoam.setBounds(6, 184, 270, 14);
		getContentPane().add(labelToRoam);	
		JSlider sliderToRoam = new JSlider(0,30,1);
		sliderToRoam.setMajorTickSpacing(10);
		sliderToRoam.setMinorTickSpacing(2);
		sliderToRoam.setPaintTicks(true);
		sliderToRoam.setPaintLabels(true);
		sliderToRoam.setBounds(6, 197, 200, 45);
		getContentPane().add(sliderToRoam);
		
		// The fastest recovery time after being infected
		JLabel labelSickTimeLow = new JLabel("Fastest Recovery Time in Days:");
		labelSickTimeLow.setBounds(10, 265, 270, 14);
		getContentPane().add(labelSickTimeLow);
		JSlider sliderSickTimeLow = new JSlider(0,30,1);
		sliderSickTimeLow.setMajorTickSpacing(10);
		sliderSickTimeLow.setMinorTickSpacing(2);
		sliderSickTimeLow.setPaintTicks(true);
		sliderSickTimeLow.setPaintLabels(true);
		sliderSickTimeLow.setBounds(6, 278, 200, 45);
		getContentPane().add(sliderSickTimeLow);
		
		// The longest recovery time after being infected
		JLabel labelSickTimeMax = new JLabel("Slowest Recovery Time in Days:");
		labelSickTimeMax.setBounds(10, 347, 270, 14);
		getContentPane().add(labelSickTimeMax);	
		JSlider sliderSickTimeMax = new JSlider(0,30,1);
		sliderSickTimeMax.setMajorTickSpacing(10);
		sliderSickTimeMax.setMinorTickSpacing(2);
		sliderSickTimeMax.setPaintTicks(true);
		sliderSickTimeMax.setPaintLabels(true);
		sliderSickTimeMax.setBounds(6, 359, 200, 45);
		getContentPane().add(sliderSickTimeMax);
		
		// The percentage of people that don't recover from infection
		JLabel labelToDie = new JLabel("Percentage of People that Die after being infected:");
		labelToDie.setBounds(10, 426, 324, 14);
		getContentPane().add(labelToDie);		
		JSlider sliderToDie = new JSlider(0,10,1);
		sliderToDie.setMajorTickSpacing(5);
		sliderToDie.setMinorTickSpacing(1);
		sliderToDie.setPaintTicks(true);
		sliderToDie.setPaintLabels(true);
		sliderToDie.setBounds(6, 440, 200, 45);
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
		sliderNumPeople.setValue(numPeople);
		sliderToRoam.setValue((int) (toRoam*100));
		sliderToBeInfected.setValue((int) (toBeInfected*100));
		sliderToDie.setValue((int) (toDie*100));
		sliderSickTimeLow.setValue((int) (sickTimeLow/1000));
		sliderSickTimeMax.setValue((int) (sickTimeMax/1000));

		getContentPane().add(btnRunSimulation);
			
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}