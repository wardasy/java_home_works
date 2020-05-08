/**
 * warda shekh yousef 209011501
 * shadi shnakher 	  3122770259
 */
package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import utilities.Point;
import utilities.Utilities;

public class Map implements Utilities {
	private ArrayList<Junction> junctions;
	private ArrayList<Road> roads;
	private ArrayList<TrafficLights> lights;
	/** Constructor 
	 * Creates a random map 
	 * @param numOfJuncs 
	 */
	public Map (int numOfJunctions) {
		this.junctions=new ArrayList<Junction>();
		this.lights=new ArrayList<TrafficLights>();
		this.roads=new ArrayList<Road>();
		for (int i = 1; i < numOfJunctions+1; i++) {
			boolean isLightedJunction=this.getRandomBoolean();
			if(!isLightedJunction)
				this.junctions.add(new Junction(i+"" , getRandomInt(0,800), getRandomInt(0,600)));
			else {
				boolean isSequential=this.getRandomBoolean();
				LightedJunction temp=new LightedJunction();
				this.junctions.add(temp);
				this.lights.add(temp.getTrafficLights());
				}	
			}
		for(Junction junc:this.junctions)
			System.out.print(""+junc.toString() + " has been created\n");
		SetAllRoads();
		turnLightsOn();
		}
	/**
	 * Auxiliary method - print 
	 */
	public void  printLight() {
		for(Junction junc : this.junctions) {
			String className = junc.getClass().getSimpleName();
			if(className.equals("LightedJunction")) {
				if(((LightedJunction)junc).getTrafficLights().getTrafficLightsOn()==true) {
					System.out.println(((LightedJunction)junc).getTrafficLights().getClass().getSimpleName()+" traffic lights "+junc.getJunctionName());
					System.out.println("- on delay");
					}
				}
			}
		}
	/*sets & gets*/
	
	/**Gets junctions list
	 * @return ArrayList of junctions
	 */
	public ArrayList<Junction> getJunctions() {return junctions; }
	/**Gets  junctions list
	 * @return ArrayList of Road
	 */
	public ArrayList<Road> getRoads() {return roads;}
	/**Sets the ArrayList of roads
	 * @param roads 
	 */
	public void setRoads(ArrayList<Road> roads) {this.roads =new ArrayList<Road>(roads);}
	/**Gets junctions list
	 * @return ArrayList of TrafficLights
	 */
	public ArrayList<TrafficLights> getLights() {return lights;}
	/**Sets the ArrayList of lights
	 * @param lights
	 */
	public void setLights(ArrayList<TrafficLights> lights) {this.lights = lights;}
	/**Sets the ArrayList of junctions
	 * @param junctions 
	 */
	public void setJunctions(ArrayList<Junction> junctions) {this.junctions = new ArrayList<Junction>(junctions);}
	/*metods*/
	public void SetAllRoads() {
		System.out.println("================= CREATING ROADS=================");
		for(Junction start :this.junctions) {
			for(Junction end:this.junctions ) 
				if(start!=end) {
					this.roads.add(new Road(start,end));
				}		
			}
		}
	/**
	 *method for lightning the traffic lights for the ctor.
	 */
	public void turnLightsOn(){
		System.out.println("================= TRAFFIC LIGHTS TURN ON =================");
		int j=0;
		for(int i=0;i<this.junctions.size();i++){
			String className = this.junctions.get(i).getClass().getSimpleName();
			if(className.equals("LightedJunction")) {
				this.lights.get(j).setLightsOn();
				j+=1;
			}
		}
	}
}
