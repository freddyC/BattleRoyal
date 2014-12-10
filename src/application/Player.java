package application;


public class Player implements GameData {
	private Vitals vitals;
	private Equipment weapon;
	private Equipment armor;
	private EElement element;
	private String name;
	private int experience = 0;
	private ActionTurn turn;
	
	public Player () {
		vitals = new Vitals();
		weapon = new Equipment(vitals.getVital(EStat.Intelect));
		armor = new Equipment(vitals.getVital(EStat.Intelect));
	}
	
	public void queueTurn (long waitTime) {
		turn = new ActionTurn(name, waitTime, this);
		GameLoop.addAction(turn);
	}

	public void updateAllVitals (int hp, int mana, int stamina, int intelect, int speed) {
		vitals.updateAllVitals (hp, mana, stamina, intelect, speed);
	}

	public int getVital (EStat stat) {
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
		queueTurn(Tools.TURN_LENGTH - getVital(EStat.Speed));
		GameLoop.pause();
		
	}

	public EElement getElement() {
		return element;
	}

	public void setElement(EElement element) {
		this.element = element;
	}

	public boolean hasTurn() {
		return (turn != null);
	}

	public ActionTurn getTurn() {
		return turn;
	}
}
