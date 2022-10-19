package model;

public class Controller {

	private Species[] collection;

	public Controller() {
		super();
		this.collection = new Species[80];
		
	}
	
	/**
	 * Description:
	 * @param show int number of the chosen option 
	 * @return msg String Depending on the option chosen, a message will be displayed with all 
	 * the species recorded, with the fauna species recorded or with the flora species recorded.
	 */
	public String showSpecies(int show) {
		String msg = "";
	
		for (int i = 0; i < collection.length; i++) {
	
		  if (collection[i] != null) {
	
			switch (show) {
			  case 1:
				msg += " \n " + (i + 1) + " . " + collection[i].toString();
				break;
			  case 2:
				if (collection[i] instanceof Fauna) {
				  msg += " \n " + (i + 1) + " . " + collection[i].toString();
				}
				break;
			  case 3:
				if (collection[i] instanceof Flora) {
				  msg += " \n " + (i + 1) + " . " + collection[i].toString();
				}
				break;
			  default:
				break;
			}
		  }
		}
		if (msg.equals("")) {
		  msg = "There are no Species registered yet";
		}
	
		return msg;
	  }

	/**
	 * @param speciesName String species name 
	 * @param scientificName String scientific name of the species 
	 * @param isMigratory boolean whether it is (true) or not (false) a migratory species 
	 * @param maxWeigth double maximum weight of the fauna species 
	 * @return true boolean whether the species of fauna could be successfully recorded
	 */
	public boolean registerSpeciesFauna(String speciesName, String scientificName, boolean isMigratory, double maxWeigth) {
		
		Fauna myFauna = new Fauna(speciesName, scientificName, isMigratory, maxWeigth);

			for (int i = 0; i < collection.length; i++) {

				if (collection[i] == null) {

					collection[i] = myFauna;
					return true;
				}

			}
		return false;
			
	}
	
	/**
	 * @param speciesName String species name 
	 * @param scientificName String scientific name of the species 
	 * @param hasFlowers boolean whether it has (true) or not(false) flowers 
	 * @param hasFruits boolean whether it has (true) or not(false) fruits
	 * @param maxHeigth double maximum height of the species 
	 * @return true boolean if the species was successfully registered 
	 */
	public boolean registerSpeciesFlora(String speciesName, String scientificName, boolean hasFlowers,boolean hasFruits, double maxHeigth) {
		
		Flora myFlora = new Flora(speciesName, scientificName, hasFlowers, hasFruits, maxHeigth);

			for (int i = 0; i < collection.length; i++) {

				if (collection[i] == null) {

					collection[i] = myFlora;
					return true;
				}

			}
        return false;
		
	}
	
	/**
	 * @param speciesName String name of the species to be removed
	 * @return true boolean if the species was successfully eliminated
	 */
	public boolean deleteSpecies(String speciesName){
		
		for (int i = 0; i < collection.length; i++) {
			
			if (collection[i] != null){
			  
				if (collection[i].getSpeciesName().equals(speciesName)){
	  
				collection[i] = null;
	  
				return true;
			   }
			}
		}
		
		return false;
	}

	/**
	 * @param optionToModify int data to be modified
	 * @param newCharacteristic String the new data
	 * @param speciesName String name of the species for which this data is to be edited 
	 * @return true boolean whether the characteristic belonging to that species could be successfully modified 
	 */
	public boolean editSpeciesFauna(int optionToModify, String newCharacteristic, String speciesName){
    
		switch (optionToModify) {

			case 1: // Species Name

			  for (int i = 0; i < collection.length; i++) {
				
				if (collection[i].getSpeciesName().equalsIgnoreCase(speciesName)) {
				  
					collection[i].setSpeciesName(newCharacteristic);
				  
					return true;
				}
			  }
			  
		    break;
	  
			case 2: // Scientific Name

			  for (int i = 0; i < collection.length; i++) {

				if (collection[i].getSpeciesName().equalsIgnoreCase(speciesName)) {
				 
					collection[i].setScientificName(newCharacteristic);
				  
					return true;
				}
			  }
			break;
	  
			case 3: // is it Migratory? boolean

			  if (newCharacteristic.equalsIgnoreCase("true")) {

				for (int i = 0; i < collection.length; i++) {

				   if (collection[i].getSpeciesName().equalsIgnoreCase(speciesName)) {
	  
					if (collection[i] instanceof Fauna) {
	  
					  ((Fauna) collection[i]).setMigratory(true);
	  
					} else if (newCharacteristic.equalsIgnoreCase("false")) {
	  
					  ((Fauna) collection[i]).setMigratory(false);
	  
					}
				  }
	  
				}
			  }
			  break;
	  
			case 4: // Max Weight
	  
			  for (int i = 0; i < collection.length; i++) {
				
				if (collection[i].getSpeciesName().equalsIgnoreCase(speciesName)) {
	  
				  if (collection[i] instanceof Fauna) {
	  
					((Fauna) collection[i]).setMaxWeigth(Double.parseDouble(newCharacteristic));
	  
				   }
	  
				}
			  }
	  
			break;
		}
		  
		return false;
	}
	
	/**
	 * @param optionToModify int data to be modified
	 * @param newCharacteristic String the new data
	 * @param speciesName String name of the species for which this data is to be edited 
	 * @return true boolean whether the characteristic belonging to that species could be successfully modified 
	 */
	public boolean editSpeciesFlora(int optionToModify, String newCharacteristic, String speciesName){

		switch (optionToModify) {

			case 1: // Species Name

			  for (int i = 0; i < collection.length; i++) {
				
				if (collection[i].getSpeciesName().equalsIgnoreCase(speciesName)) {
				  
					collection[i].setSpeciesName(newCharacteristic);
				  
					return true;
				}
			  }
			  
		    break;
	  
			case 2: // Scientific Name

			  for (int i = 0; i < collection.length; i++) {

				if (collection[i].getSpeciesName().equalsIgnoreCase(speciesName)) {
				 
					collection[i].setScientificName(newCharacteristic);
				  
					return true;
				}
			  }
			break;
	  
			case 3: // Has Flowers? boolean

			  if (newCharacteristic.equalsIgnoreCase("true")) {

				for (int i = 0; i < collection.length; i++) {

				   if (collection[i].getSpeciesName().equalsIgnoreCase(speciesName)) {
	  
					if (collection[i] instanceof Flora) {
	  
					  ((Flora) collection[i]).setHasFlowers(true);
	  
					} else if (newCharacteristic.equalsIgnoreCase("false")) {
	  
					  ((Flora) collection[i]).setHasFlowers(false);;
	  
					}
				  }
	  
				}
			  }
			  
		   break;

			  case 4: // Has Fruits? boolean

			  if (newCharacteristic.equalsIgnoreCase("true")) {

				for (int i = 0; i < collection.length; i++) {

				   if (collection[i].getSpeciesName().equalsIgnoreCase(speciesName)) {
	  
					if (collection[i] instanceof Flora) {
	  
					  ((Flora) collection[i]).setHasFruits(false);
	  
					} else if (newCharacteristic.equalsIgnoreCase("false")) {
	  
					  ((Flora) collection[i]).setHasFruits(false);
	  
					}
				  }
	  
				}
			  }
			break;
	  
			case 5: // Max Height
	  
			  for (int i = 0; i < collection.length; i++) {
				
				if (collection[i].getSpeciesName().equalsIgnoreCase(speciesName)) {
	  
				  if (collection[i] instanceof Flora) {
	  
					((Flora) collection[i]).setMaxHeigth(Double.parseDouble(newCharacteristic));
	  
				   }
	  
				}
			  }
	  
			break;
		}
		  
		return false;
	}
}

