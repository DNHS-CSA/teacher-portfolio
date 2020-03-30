package socialdistancing;

public class SimulationControl {
		// global counters
		public static int numInfected = 0;
		public static int numDied= 0;
		
		// Citizen simulation control
		static int numPeople = 100;			// people in the simulation
		static double toRoam = .10;			// % population that required to roam in simulation (essential workers, rule breakers)
		static double toBeInfected = .02;	// % of population that has virus in simulation
		static double toDie = .06;			// % population that would die out of those that get infected
		static int sickTimeLow = 5000;		// Minimum time to recover 5 seconds
		static int sickTimeMax = 10000;		// Max time to recover 10 seconds
}
