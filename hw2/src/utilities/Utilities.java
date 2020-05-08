/**
 * warda shekh yousef 209011501
 * shadi shnakher 	  3122770259
 */
package utilities;

import java.util.ArrayList;
import java.util.Random;

public interface Utilities {
	/**
	 * @param Val
	 * @param min
	 * @param max
	 * @return boolean type
	 *Checks ligality for values ​​within minimum and maximum data limits.
	 */
	default boolean checkValue(double Val, double min, double max) {
		if(Val<max && Val>min)
			return true;
		return false;
		}
	default void correctingMessage(double wrongVal, double correctVal, String varName) {
		if(correctVal !=wrongVal)
			System.out.println(varName);
		}
	default void errorMessage(double wrongVal, String varName) {
		System.out.println(wrongVal+" is incorrect in "+varName);
		}

	/**
	 * Returns a random boolean value
	 * @return  boolean type
	 */
	default boolean getRandomBoolean() {
		boolean [] booleanElem={true,false};
		return booleanElem[ new Random().nextInt(booleanElem.length)];
		}

	/**
	 * @return random double at the limit of max, m
	 */
	default double getRandomDouble(double min, double max) {
		 double random_double = Math.random() * (max - min + 1) + min; 
		 return random_double;
		 }
	default int getRandomInt(int min, int max) {
		Random random = new Random();
		return random.nextInt(max-min+1) + min;
		}
	default ArrayList<Integer> getRandomIntArray(int min, int max, int arraySize) {
		ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <arraySize; i++) {
            list.add(getRandomInt(min,max));
            }
        return list;
        }
	/**
	 * Prints successful creation of an object message
	 * @param objName
	 */
	default void successMessage(String objName) {
		System.out.println(objName+" as been create");
		}
	
}
