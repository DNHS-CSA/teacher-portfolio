package socialdistancing;

import java.util.ArrayList;
import java.util.List;

import java.awt.Rectangle;

public class Community {
	ArrayList<Building> buildings; //the community of Person objects	

    public Community() {
        AddBuildings();
    }

    void AddBuildings() {
    	//Setup the Buildings
		buildings = new ArrayList<Building>();
		buildings.add(new Building("Sprouts",550,0,620,160));
		buildings.add(new Building("Scripps Medical",200,0,-25,160));
		buildings.add(new Building("Board and Brew",550,400,620,400));
		buildings.add(new Building("Mr M's House",200,400,-25,400));
    }

}