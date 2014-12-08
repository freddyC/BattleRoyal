package application;

import java.util.HashMap;

public class ElementCoupling {
	private static ElementCoupling instance = null;
	private HashMap<ElementEnum, HashMap<ElementEnum, Integer>> couplingStat;
	private HashMap<ElementEnum, HashMap<ElementEnum, String>>  couplingText;
	
	public static ElementCoupling getInstance() {
		if(instance == null) {
			instance = new ElementCoupling();
		}
		return instance;
	}

	
	protected ElementCoupling() {
		couplingStat = new HashMap<ElementEnum, HashMap<ElementEnum, Integer>>();
		HashMap<ElementEnum, Integer> fireEffect = new HashMap <ElementEnum,Integer>();
		fireEffect.put(ElementEnum.Fire, 0);
		fireEffect.put(ElementEnum.Water, -1);
		fireEffect.put(ElementEnum.Earth, 0);
		fireEffect.put(ElementEnum.Wind, 1);
		
		HashMap<ElementEnum, Integer> waterEffect = new HashMap <ElementEnum,Integer>();
		waterEffect.put(ElementEnum.Fire, 1);
		waterEffect.put(ElementEnum.Water, 0);
		waterEffect.put(ElementEnum.Earth, -1);
		waterEffect.put(ElementEnum.Wind, 0);
		
		HashMap<ElementEnum, Integer> earthEffect = new HashMap <ElementEnum,Integer>();
		earthEffect.put(ElementEnum.Fire, 0);
		earthEffect.put(ElementEnum.Water, 1);
		earthEffect.put(ElementEnum.Earth, 0);
		earthEffect.put(ElementEnum.Wind, -1);
		
		HashMap<ElementEnum, Integer> windEffect = new HashMap <ElementEnum,Integer>();
		windEffect.put(ElementEnum.Fire, -1);
		windEffect.put(ElementEnum.Water, 0);
		windEffect.put(ElementEnum.Earth, 1);
		windEffect.put(ElementEnum.Wind, 0);
		
		couplingStat.put(ElementEnum.Fire, fireEffect);
		couplingStat.put(ElementEnum.Wind, windEffect);
		couplingStat.put(ElementEnum.Water, waterEffect);
		couplingStat.put(ElementEnum.Earth, earthEffect);
		
		couplingText = new HashMap<ElementEnum, HashMap<ElementEnum, String>>();
		HashMap<ElementEnum, String> fireDesc = new HashMap <ElementEnum,String>();
		fireDesc.put(ElementEnum.Water, "doused");
		fireDesc.put(ElementEnum.Wind, "kindled");
		fireDesc.put(ElementEnum.Earth, "unaffected");
		fireDesc.put(ElementEnum.Fire, "unaffected");

		HashMap<ElementEnum, String> waterDesc = new HashMap <ElementEnum,String>();
		waterDesc.put(ElementEnum.Water, "unaffected");
		waterDesc.put(ElementEnum.Wind, "unaffected");
		waterDesc.put(ElementEnum.Earth, "muddied");
		waterDesc.put(ElementEnum.Fire, "boiled");

		HashMap<ElementEnum, String> earthDesc = new HashMap <ElementEnum,String>();
		earthDesc.put(ElementEnum.Water, "quickened");
		earthDesc.put(ElementEnum.Wind, "eroded");
		earthDesc.put(ElementEnum.Earth, "unaffected");
		earthDesc.put(ElementEnum.Fire, "unaffected");

		HashMap<ElementEnum, String> windDesc = new HashMap <ElementEnum,String>();
		windDesc.put(ElementEnum.Water, "unaffected");
		windDesc.put(ElementEnum.Wind, "unaffected");
		windDesc.put(ElementEnum.Earth, "given projectiles");
		windDesc.put(ElementEnum.Fire, "miss directed");

		couplingText.put(ElementEnum.Fire, fireDesc);
		couplingText.put(ElementEnum.Wind, windDesc);
		couplingText.put(ElementEnum.Water, waterDesc);
		couplingText.put(ElementEnum.Earth, earthDesc);
	
	}
	


	public int getElementalCoupling (ElementEnum actioner, ElementEnum actionee) {
		return (couplingStat.get(actioner)).get(actionee);
	}


	public String getCouplingText (ElementEnum actioner, ElementEnum actionee) {
		return (couplingText.get(actioner)).get(actionee);
	}
}
