package application;

import java.util.Random;

public class Tools {

	public static int randomInt(int min, int max) {
		Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	public static ElementEnum getRandomElement () {
		ElementEnum [] a = {ElementEnum.Fire, ElementEnum.Water, ElementEnum.Wind, ElementEnum.Earth};
		return a[randomInt(0,3)];
	}

}
