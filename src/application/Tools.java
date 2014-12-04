package application;

import java.util.Random;

public class Tools {

	public static int randomInt(int min, int max) {
		Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	public static Element getRandomElement () {
		Element [] a = {Element.Fire, Element.Water, Element.Wind, Element.Earth};
		return a[randomInt(0,3)];
	}

}
