package application;


public class Character {
	private Vitals vitals;
	private Equipment weapon;
	private Equipment armor;
	private Element element;
	private String name;
	private int experience = 0;
	
	public void initVitals (int hp, int mana, int stamina, int intelect, int speed) {
		if (vitals != null) {
			System.out.println("you can't init vitals if they already exist silly");
			return;
		}
		
		vitals = new Vitals();
		vitals.increaseVital(Stat.HP, vitals.getVital(Stat.HP) * hp);
		vitals.increaseVital(Stat.Mana, vitals.getVital(Stat.Mana) * mana);
		vitals.increaseVital(Stat.Stamina, vitals.getVital(Stat.Stamina) + stamina);
		vitals.increaseVital(Stat.Intelect, vitals.getVital(Stat.Intelect) + intelect);
		vitals.increaseVital(Stat.Speed, vitals.getVital(Stat.Speed) + speed);
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
	
	void createWeapon () {
		weapon = new Equipment(vitals.getVital(Stat.Intelect));
	}
	
	void createArmor () {
		armor = new Equipment(vitals.getVital(Stat.Intelect));
	}
}
