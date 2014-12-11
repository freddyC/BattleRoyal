package application;


public class Equipment {
	EnumElement element;
	int strength;
	int forgings;

	public Equipment(int intelect) {
		super();
		element = Tools.getRandomElement();
		forgings = 0;
		forge(intelect);
	}
	
	public EnumElement getElement() {
		return element;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public void forge (int intelect) {
		forgings++;
		strength += Tools.randomInt(1 + intelect, 5 + intelect);
	}
	
	public Equipment reForge (int intelect) {
		return generateEquipment(forgings - Tools.randomInt(0, 3), intelect);
	}
	
	
	public static Equipment generateEquipment (int level, int intelect) {
		if (level < 1) {
			level = 1;
		}
		
		Equipment eq = new Equipment(intelect);
		
		for (int i = 0; i < level; ++i) {
			eq.strength += Tools.randomInt(2, 6);
		}
		
		return eq;
	}
}
