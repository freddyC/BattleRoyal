package application;


public class Player implements GameData {
	private Vitals vitals;
	private Equipment weapon;
	private Equipment armor;
	private ElementEnum element;
	private String name;
	private int experience = 0;
	private ActPlayersTurn turn;
	private Watched watchedState;  
	
	public Player () {
		vitals = new Vitals();
		weapon = new Equipment(vitals.getVital(StatEnum.Intelect));
		armor = new Equipment(vitals.getVital(StatEnum.Intelect));
	}
	
	public void queueTurn () throws InterruptedException {
		turn = new ActPlayersTurn(name + "_turn_timer", Tools.TURN_LENGTH - vitals.getVital(StatEnum.Speed));
		GameLoop.addAction(turn);
		GameLoop.pause();
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

	public void setName(String n) {
		if (Players.invalidName(n)) {
			InterruptedException e = new InterruptedException();
			e.printStackTrace();
			return;
		}
		name = n;
		try {
			queueTurn();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ElementEnum getElement() {
		return element;
	}

	public void setElement(ElementEnum element) {
		this.element = element;
	}
}
