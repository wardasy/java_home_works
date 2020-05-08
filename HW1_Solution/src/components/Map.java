/**
 * 
 */
package components;

import java.util.ArrayList;
import java.util.Random;
import utilities.Point;

/**Represents Map
 * @author Sophie Krimberg
 */
public class Map {
	private ArrayList<Junction> junctions;
	private ArrayList<Road> roads;
	private final int randomJuncs=20;//quantity of junction for random constructors
	

	/** Default Constructor
	 * Creates a random map with saved in randomJuncs variable quantity of junctions
	 */
	public Map() {
		
		junctions=new ArrayList<Junction>();
		roads=new ArrayList<Road>();
		//create junctions
		for (int i=0; i<randomJuncs;i++) {
				junctions.add(new Junction(new String("" +i),new Point()));
		}
		//add roads
		setAllRoads();
	}	
	
	/** Constructor 
	 * Creates a full random map with given quantity of junctions
	 * @param numOfJuncs represents the given quantity of junctions
	 */
	public Map(int numOfJuncs){
		
		junctions=new ArrayList<Junction>();
		roads=new ArrayList<Road>();
		
		for (int i=0; i<numOfJuncs;i++) {
				junctions.add(new Junction(new String("" +i),new Point()));
		}
		
		setAllRoads();
	}	
	
	/** Constructor 
	 * Creates a random map with given quantities of junctions and roads.
	 * @param junctions represents the given quantity of junctions.
	 * @param roads represents the given quantity of roads.
	 */
	public Map(int junctions, int roads) {
			
		this.junctions=new ArrayList<Junction>();
		this.roads=new ArrayList<Road>();
		//create junctions
		for (int i=0; i<junctions;i++) {
				this.junctions.add(new Junction(new String("" +i),new Point()));
		}
		//create roads	
		for (int i=0; i<roads;i++) {
			int j=new Random().nextInt(junctions);
			if(i==j) {//don't create a road with the same junction at the start and the end
				j--;
			}
			else {//add a new road created with random arguments
				this.roads.add(new Road(this.junctions.get(i), this.junctions.get(j), VehicleType.getRandomVehicleTypes(), new Random().nextBoolean(),new Random().nextBoolean() ));
				if (new Random().nextBoolean()) {
					this.junctions.get(j).setLightsOn(); // turn on the traffic lights on some junctions, if the lights are already on, will be reseted.
				}
			}
		}
	}
		
	/** Constructor 
	 * Creates a map with given junctions list and random roads
	 * @param juncs ArrayList of junctions that the map will be based on.
	 */
	public Map (ArrayList<Junction> juncs) {
		this.junctions=new ArrayList<Junction>(juncs);
		this.roads=new ArrayList<Road>();
		setAllRoads();
	}
	
	/** Constructor 
	 * Creates a map with given junctions and roads
	 * @param juncs ArrayList of junctions that the map will be based on.
	 * @param roads ArrayList of roads that should be added to the map.
	 */
	public Map (ArrayList<Junction>juncs, ArrayList<Road>roads) {
		this.junctions=new ArrayList<Junction>(juncs);
		this.roads=new ArrayList<Road>(roads);
		
	}
	
	/** Connects all the existing junctions one to another with random roads (completes the full map creation) 
	 */
	public void setAllRoads() {
		for (int i=0; i<junctions.size();i++) {//connect every junction
			for (int j=0; j<junctions.size();j++) {//to all other junctions
				if(i==j) {//don't create a road with the same junction at the start and the end.
					
					continue;
				}
				//create a road with random parameters between the two junctions and add it to the list
				roads.add(new Road(junctions.get(i), junctions.get(j), VehicleType.getRandomVehicleTypes(), false,new Random().nextBoolean() ));
				if (new Random().nextBoolean()&&new Random().nextBoolean()&&new Random().nextBoolean()) {//probability=0.125
					junctions.get(j).setLightsOn(); // turn on the traffic lights on some junctions, if the lights are already on, will be reseted.
				}
					
			}
		}
	}
	
	/** Adds a given road to the map 
	 * connects it to the junctions 
	 * (if traffic lights are turned on, they have been reseted by addEnteringRoad method).
	 * @param r A Road to be added.
	 */
	public void addRoad(Road r){
		roads.add(r);
		r.getFromJunc().addExitingRoad(r);
		r.getToJunc().addEnteringRoad(r);
		System.out.println(r.toString() + " has been added to the map.");
	}
	
	/** Removes a given road from the map
	 *  disconnects it from the junctions and resets the traffics lights.
	 * @param r A Road to be removed
	 */
	public void removeRoad(Road r) {
		
		roads.remove(r);
		r.getFromJunc().getExitingRoads().remove(r);//disconnect the road from the junctions.
		r.getToJunc().getEnteringRoads().remove(r);
		r.getToJunc().getVehicles().remove(r);
		if(r.getToJunc().getLights()) {//if the road leads to lighted junction
			r.getToJunc().resetLights();
		}
		System.out.println(r.toString() + "has been removed from the map.");
	}
	
	/**Adds a given junction to the map
	 * @param junc A junction to be added
	 */
	public void addJunction(Junction junc) {
		junctions.add(junc);
		System.out.println(junc.toString() + " has been added to the map.");
	}
	
	/**Removes a given junction from the map
	 * and removes all the connected to the junction roads.
	 * @param junc represents the Junction to be removed.
	 */
	public void removeJunction(Junction junc) {
		junctions.remove(junc);
		System.out.println(junc.toString() + " has been removed from the map.");
		for (int i=0; i<junc.getEnteringRoads().size();i++) {
			removeRoad(junc.getEnteringRoads().get(i));
		}
		for (int i=0; i<junc.getExitingRoads().size(); i++) {
			removeRoad(junc.getExitingRoads().get(i));
		}
	}
	
	/**Gets a random junction from the map.
	 * 
	 * @return Junction
	 */
	public Junction getRandomJunction() {
		int index=new Random().nextInt(junctions.size());
		return junctions.get(index);
	}
	
	/**Gets current junctions list
	 * 
	 * @return ArrayList<Junction> 
	 */
	public ArrayList<Junction> getJunctions(){
		return junctions;
	}
}
