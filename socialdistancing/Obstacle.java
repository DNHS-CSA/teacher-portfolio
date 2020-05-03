package socialdistancing;

public class Obstacle {
		
	//Name of Building
	String name;
	int vx, vy, hx, hy;

	public Obstacle() {
		// default constructor initializes Fields
	}
		
    public Obstacle(String name, int vx, int vy, int hx, int hy) {
    	this.name = name;
    	this.vx = vx;
    	this.vy = vy;
    	this.hx = hx;
    	this.hy = hy;
    }
    
    public String getName() {
    	return name;
    }
   

}
