package socialdistancing;

//entry point
public class _Main {
	Settings sets;
	Control control;

	/* 
	 * Entry point, starts Settings Panel
	 */
	public static void main( String[] args ) {
		//this is instance of main
		_Main m = new _Main();
		
		//start settings panel
		m.sets = new Settings(m);
		m.sets.setVisible(true); //activates Settings panel
	}
	
	/*
	 * Call back to start a new simulation with user defined simulation Settings
	 */
	public void simulation() {
		//new Simulation for each run from Settings panel
		control = new Control(sets); // sets are critical for Simulation
		control.runSimulation();
	}
}