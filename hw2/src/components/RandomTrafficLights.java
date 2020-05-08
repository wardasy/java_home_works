/**
 * warda shekh yousef 209011501
 * shadi shnakher 	  3122770259
 */
package components;

import java.util.ArrayList;
import java.util.Random;
/**
 * Class for random traffic light
 */
public class RandomTrafficLights extends TrafficLights{
	/**Constructor
	 * @param ArrayList of roads
	 */
	public RandomTrafficLights (ArrayList<Road> roads){
		super(roads);
	}
	/**
	 *method "changeIndex" returns index for green light
	 */
	public void changeIndex(){
		this.setGreenLightIndex(getRandomInt(0, this.getRoads().size()));
		}
}