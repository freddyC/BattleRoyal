package application;

import java.util.HashMap;

public class ElementCoupling {
	private static ElementCoupling instance = null;
	private HashMap<EElement, HashMap<EElement, Integer>> couplingStat;
	private HashMap<EElement, HashMap<EElement, String>>  couplingText;
	
	public static ElementCoupling getInstance() {
		if(instance == null) {
			instance = new ElementCoupling();
		}
		return instance;
	}

	
	protected ElementCoupling() {
		couplingStat = new HashMap<EElement, HashMap<EElement, Integer>>();
		HashMap<EElement, Integer> fireEffect = new HashMap <EElement,Integer>();
		fireEffect.put(EElement.Fire, 0);
		fireEffect.put(EElement.Water, -1);
		fireEffect.put(EElement.Earth, 0);
		fireEffect.put(EElement.Wind, 1);
		
		HashMap<EElement, Integer> waterEffect = new HashMap <EElement,Integer>();
		waterEffect.put(EElement.Fire, 1);
		waterEffect.put(EElement.Water, 0);
		waterEffect.put(EElement.Earth, -1);
		waterEffect.put(EElement.Wind, 0);
		
		HashMap<EElement, Integer> earthEffect = new HashMap <EElement,Integer>();
		earthEffect.put(EElement.Fire, 0);
		earthEffect.put(EElement.Water, 1);
		earthEffect.put(EElement.Earth, 0);
		earthEffect.put(EElement.Wind, -1);
		
		HashMap<EElement, Integer> windEffect = new HashMap <EElement,Integer>();
		windEffect.put(EElement.Fire, -1);
		windEffect.put(EElement.Water, 0);
		windEffect.put(EElement.Earth, 1);
		windEffect.put(EElement.Wind, 0);
		
		couplingStat.put(EElement.Fire, fireEffect);
		couplingStat.put(EElement.Wind, windEffect);
		couplingStat.put(EElement.Water, waterEffect);
		couplingStat.put(EElement.Earth, earthEffect);
		
		couplingText = new HashMap<EElement, HashMap<EElement, String>>();
		HashMap<EElement, String> fireDesc = new HashMap <EElement,String>();
		fireDesc.put(EElement.Water, "doused");
		fireDesc.put(EElement.Wind, "kindled");
		fireDesc.put(EElement.Earth, "unaffected");
		fireDesc.put(EElement.Fire, "unaffected");

		HashMap<EElement, String> waterDesc = new HashMap <EElement,String>();
		waterDesc.put(EElement.Water, "unaffected");
		waterDesc.put(EElement.Wind, "unaffected");
		waterDesc.put(EElement.Earth, "muddied");
		waterDesc.put(EElement.Fire, "boiled");

		HashMap<EElement, String> earthDesc = new HashMap <EElement,String>();
		earthDesc.put(EElement.Water, "quickened");
		earthDesc.put(EElement.Wind, "eroded");
		earthDesc.put(EElement.Earth, "unaffected");
		earthDesc.put(EElement.Fire, "unaffected");

		HashMap<EElement, String> windDesc = new HashMap <EElement,String>();
		windDesc.put(EElement.Water, "unaffected");
		windDesc.put(EElement.Wind, "unaffected");
		windDesc.put(EElement.Earth, "given projectiles");
		windDesc.put(EElement.Fire, "miss directed");

		couplingText.put(EElement.Fire, fireDesc);
		couplingText.put(EElement.Wind, windDesc);
		couplingText.put(EElement.Water, waterDesc);
		couplingText.put(EElement.Earth, earthDesc);
	
	}
	


	public int getElementalCoupling (EElement actioner, EElement actionee) {
		return (couplingStat.get(actioner)).get(actionee);
	}


	public String getCouplingText (EElement actioner, EElement actionee) {
		return (couplingText.get(actioner)).get(actionee);
	}
}
