package application;


public class Player implements GameData {
	private Vitals vitals;
	private Equipment weapon;
	private Equipment armor;
	private EnumElement element;
	private String name;
	private int experience = 0, level = 0;
	private ActionTurn turn;
	
	public void updateXP () {
		experience += Tools.randomInt(1, 100);
		if (experience >= 1000 ) {
			++level;
			experience = experience % 1000;
			levelUp();
		}
	}
	
	public void levelUp() {
		// choose attributes and value some how
		EnumStat stat = EnumStat.Speed;
		int change = 20;
		vitals.change(stat, change);
	}
	
	public Player () {
		vitals = new Vitals();
		weapon = new Equipment(vitals.getVital(EnumStat.Intelect));
		armor = new Equipment(vitals.getVital(EnumStat.Intelect));
	}
	
	public void queueTurn (long waitTime) {
		turn = new ActionTurn(name, waitTime, this);
		GameLoop.addAction(turn);
	}

	public void updateAllVitals (int hp, int mana, int stamina, int intelect, int speed) {
		vitals.updateAllVitals (hp, mana, stamina, intelect, speed);
	}

	public int getVital (EnumStat stat) {
		return vitals.getVital(stat);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String n) {
		// name only set once so it also pushes the player onto the game loop
		if (Players.invalidName(n)) {
			InterruptedException e = new InterruptedException();
			e.printStackTrace();
			return;
		}
		name = n;
		queueTurn(Tools.TURN_LENGTH - getVital(EnumStat.Speed));
	}

	public void changeVitals (EnumStat vital, int change) {
		vitals.change(vital, change);
	}
	
	public EnumElement getElement() {
		return element;
	}

	public void setElement(EnumElement element) {
		this.element = element;
	}

	public boolean hasTurn() {
		return (turn != null);
	}

	public ActionTurn getTurn() {
		return turn;
	}

	public EnumElement getWeaponAffinity() {
		return weapon.getElement();
	}

	public EnumElement getArmorAffinity() {
		return armor.getElement();
	}
}
