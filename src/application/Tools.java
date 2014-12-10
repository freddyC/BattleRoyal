package application;

import java.util.Random;

public class Tools {
	
	public static int randomInt(int min, int max) {
		Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	public static EElement getRandomElement () {
		EElement [] a = {EElement.Fire, EElement.Water, EElement.Wind, EElement.Earth};
		return a[randomInt(0,3)];
	}

	public static long TURN_LENGTH = 1000;
}
