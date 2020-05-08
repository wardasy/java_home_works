/**
 * warda shekh yousef 209011501
 * shadi shnakher 	  3122770259
 */
package components;

import java.util.ArrayList;
import java.util.Random;

import utilities.Timer;
import utilities.Utilities;
/**
 * Class for random traffic light
 */
public abstract class TrafficLights  implements Timer, Utilities{
	private static final int minDelay=2;
	private static final int maxDelay=6;
	private static int objectsCount=1;
	private int delay;
	private int greenLightIndex;
	private int id;
	private ArrayList<Road> roads;
	private boolean trafficLightsOn;
	private int workingTime;

	/**Constructor
	 * @param ArrayList of roads
	 */
	public TrafficLights(ArrayList<Road> roads) {
		this.setRoads(roads);
		this.setId(this.getObjectsCount());
		this.setObjectsCount(objectsCount+1);	
		this.greenLightIndex=-1;
		this.workingTime=0;
		this.setDelay(this.getRandomInt(minDelay, maxDelay));
		}

	public int getObjectsCount() {
		return objectsCount;
		}
	public void setObjectsCount(int objectsCount) {
		this.objectsCount = objectsCount;
		}
	public int getDelay() {
		return delay;
		}
	
	public void setDelay(int delay) {
		this.delay = delay;
		}
	public int getGreenLightIndex() {
		return greenLightIndex;
		}
	
	public void setGreenLightIndex(int greenLightIndex) {
		this.greenLightIndex = greenLightIndex;
		}

	public int getId() {
		return id;
		}
	public void setId(int id) {
		this.id = id;
		}
	public ArrayList<Road> getRoads() {
		return roads;
		}
	public void setRoads(ArrayList<Road> roads) {
		this.roads=new ArrayList<Road>();
		this.roads = roads;
		}

	public boolean getTrafficLightsOn() {
		return trafficLightsOn;
		}
	public void setTrafficLightsOn(boolean trafficLightsOn) {
		this.trafficLightsOn = trafficLightsOn;
		}
	@Override
	public String toString() {
		return ""+ this.trafficLightsOn ;
		}

	public int getWorkingTime() {
		return workingTime;
		}
	public void setWorkingTime(int workingTime) {
		this.workingTime = workingTime;
		}
	public abstract void changeIndex();
	public void changeLights(){
		if (this.roads.size()==0) {
			System.out.println(this.toString() + ": No entering roads, can not change lights");
			return;
			}
		this.greenLightIndex=++this.greenLightIndex % this.roads.size();
		this.setGreenLight(this.greenLightIndex);	
		}
	public void setGreenLight(int index) {
		if(!this.trafficLightsOn) {
			System.out.println("Random traffic lights traffic lights are OFF");
			}
		if(greenLightIndex>=0) {
			roads.get(greenLightIndex).setGreenlight(false);
			greenLightIndex=index;
			roads.get(greenLightIndex).setGreenlight(true);
			System.out.println(roads.get(greenLightIndex).toString() + ": green light");
			}
		}
	/**
	 *method "incrementDrivingTime" advances the traffic light's operation time 
	 * also checks whether it's time to switch lights
	 *@return void
	 */
	public void incrementDrivingTime() {
		this.setWorkingTime(this.workingTime+1);
		changeLights();
		}
	public void setLightsOn() {
		if (this.roads.size()>0) {
			greenLightIndex=new Random().nextInt(this.roads.size());
			this.setTrafficLightsOn(true);
			setDelay(new Random().nextInt(maxDelay));
			System.out.println(super.getClass().getSimpleName()+" traffic lights "+this.roads.get(greenLightIndex).getEndJunction().getJunctionName()+" turned ON. Delay time: " + delay);
			setGreenLight(greenLightIndex);
			}
		else System.out.println(this.toString() + ": No entering roads, traffic lights can't be turned on.");
		}	
}
