package application;


public class Character {
	private Vitals vitals;
	private Equipment weapon;
	private Equipment armor;
	private Element element;
	private String name;
	private int experience = 0;
	
	public Character () {
		vitals = new Vitals();
		weapon = new Equipment(vitals.getVital(Stat.Intelect));
		armor = new Equipment(vitals.getVital(Stat.Intelect));
	}

	public void updateAllVitals (int hp, int mana, int stamina, int intelect, int speed) {
		vitals.updateAllVitals (hp, mana, stamina, intelect, speed);
	}

	public int getVital (Stat stat) {
		return vitals.getVital(stat);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}	
}
