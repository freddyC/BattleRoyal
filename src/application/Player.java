package application;


public class Player implements GameData {
	private Vitals vitals;
	private Equipment weapon;
	private Equipment armor;
	private ElementEnum element;
	private String name;
	private int experience = 0;
	private GameLoop gl;
	private ActPlayersTurn turn;
	private Watched watchedState;  
	
	public Player () {
		gl = GameLoop.getInstance();
		vitals = new Vitals();
		weapon = new Equipment(vitals.getVital(StatEnum.Intelect));
		armor = new Equipment(vitals.getVital(StatEnum.Intelect));
	}
	
	public void queueTurn () throws InterruptedException {
		turn = new ActPlayersTurn(name + "_turn_timer", 5000 - vitals.getVital(StatEnum.Speed));
		gl.addAction(turn);
	}

	public void updateAllVitals (int hp, int mana, int stamina, int intelect, int speed) {
		vitals.updateAllVitals (hp, mana, stamina, intelect, speed);
	}

	public int getVital (StatEnum stat) {
		return vitals.getVital(stat);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) throws InterruptedException {
		this.name = name;
		queueTurn();
	}

	public ElementEnum getElement() {
		return element;
	}

	public void setElement(ElementEnum element) {
		this.element = element;
	}
}
