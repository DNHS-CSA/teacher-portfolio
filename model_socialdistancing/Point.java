package model_socialdistancing;
import java.awt.Color;
import java.awt.Graphics;
/*
 * Class to represent a Point object used for drawing the graph
 */
public class Point {
	
	//a point has a value and the moment in time its value was captured
	public static final int OvalW = 10;	//Height
	public static final int OvalH = 10;	//Width

	public int time;
	public int value;
	
	
	public Point(int t, int v) {
		time 	=	t;
		value 	= 	v;
	}
	
	
}
