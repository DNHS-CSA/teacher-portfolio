package socialdistancing;

//entry point
public class _Main {
	Settings sets;
	Control control;

	/* 
	 * Entry point, starts Settings Panel
	 */
	public static void main( String[] args ) {
		//this instance
		_Main m = new _Main();
		
		//start settings panel
		m.sets = new Settings(m);
		m.sets.setVisible(true);	//activates Settings panel
	}
	
	/*
	 * Call back start a new Control with settings panel reference
	 */
	public void simulation() {
		//new simulation for each settings run
		control = new Control(sets);
		control.run();
	}
}