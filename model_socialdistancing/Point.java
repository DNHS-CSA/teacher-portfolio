package model_socialdistancing;
import java.awt.Color;
import java.awt.Graphics;
/*
 * Class to represent a Point object used for drawing the graph
 */
public class Point {
	
	//a point has a value and the moment in time its value was captured
	public int time;
	public int value;
	
	
	public Point(int t, int v) {
		time 	=	t;
		value 	= 	v;
	}
	
	
}
