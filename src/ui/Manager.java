
package ui;
import java.util.Scanner;
import model.Controller;

// Description:this program will allow you to register a species, consult the species already registered, delete species 
//and even edit the characteristic of some of these species, facilitating the work of the teachers.

public class Manager {

	private Scanner sc;
	private Controller controller;
	
	public Manager() {
		super();
		this.sc = new Scanner(System.in);
		this.controller = new Controller();
	}
	
	public static void main(String [] args) {
		
		Manager m = new Manager();
		m.menu();
	
	}


	
    /**
	 * Description: Displays by console the possible options that the user can choose from
     * pre: none
	 * pos: none
	 * @return not return
     */
    public void menu() {

	System.out.println("Welcome to icesi species");
	
	boolean exit = false;
	
	while(!exit) {
		System.out.println("1.Consult species");
		System.out.println("2.Register species");
		System.out.println("3.Delete Species");
		System.out.println("4.Edit Species");
		int option = sc.nextInt();
		
		switch(option) {
		case 1:
		System.out.println("1.Show all species");
		System.out.println("2.Show all fauna species");
		System.out.println("3.Show all flora species");
		int show = sc.nextInt();
		
		System.out.println(controller.showSpecies(show));
		
		break;
		
		case 2: 
		System.out.println("1.Register a species of fauna");
		System.out.println("2.Register a species of flora");
		int option1 = sc.nextInt();
		 
		 if(option1==1) {
			 registerSpeciesFauna();
		  } else if(option==2) {
			  registerSpeciesFlora();
		  }else {
			  System.out.println("Type a valid option");
		  }
			break;
		case 3:
	      deleteSpecies();
		  break;
		case 4:
		  System.out.println("1.Edit a species of fauna");
		  System.out.println("2.Edit a species of flora");
         
		  int option2 = sc.nextInt();
		  
		  if(option2==1) {
			
			editSpeciesFauna();
		  
		} else if(option==2) {
			
			editSpeciesFlora();
		 
		}else {
			 System.out.println("Type a valid option");
		 
		}
			break;
		default:
		  System.out.println("Type a valid option");
			break;
			
		}
	}
	
  }

	/**
	 * Description: Requests by console the data required to record a species of fauna and saves them.
	 * pre: none
	 * pos: none
	 * @return not return
	 */
	private void registerSpeciesFauna(){

	  System.out.println("Enter the species's name ");
	  sc.nextLine();
	  String speciesName = sc.nextLine();

      System.out.println("Enter the scientific name of the specie");
	  String scientificName = sc.nextLine();
	  
	  System.out.println("Is it a migratory species");
	  System.out.println("true or false");
	  boolean isMigratory = sc.nextBoolean();
	  
	  System.out.println("Enter the weight of the fauna species");
	  double maxWeigth = sc.nextDouble();
	  

		if (controller.registerSpeciesFauna(speciesName, scientificName, isMigratory, maxWeigth)) {

			System.out.println("Species of fauna successfully registered");

		} else {
			System.out.println("Error,species could not be registered");
		}

	}
	
	/**
	 * Description: Allows to register a species of flora type asking by console for the attributes that it must have.
	 * pre: none
	 * pos: none
	 * @return not return
	 */
	private void registerSpeciesFlora() {
		
	  System.out.println("Enter the species's name ");
	  sc.nextLine();
	  String speciesName = sc.nextLine();

      System.out.println("Enter the scientific name of the specie");
	  String scientificName = sc.nextLine();
	  
	  System.out.println("Does the flora species have flowers? ");
	  System.out.println("true or false");
	  boolean hasFlowers = sc.nextBoolean();
      
	  System.out.println("Does the flora species have fruits? ");
	  System.out.println("true or false");
	  boolean hasFruits = sc.nextBoolean();

      System.out.println("What is the maximum height of the species?");
	  double maxHeigth = sc.nextDouble();
	  
	  if(controller.registerSpeciesFlora(speciesName, scientificName, hasFlowers, hasFruits, maxHeigth)) {

		System.out.println("The fauna species was successfully recorded");
  
	  } else {
		System.out.println("Error,species could not be registered");
	  }
  
		
	}

	/**
	 * Description: This method shows the existing species in order to remind the user of 
	 * their names and other characteristics, knowing this, the user can choose which species to eliminate.
	 * pre:There must be at least one species
	 * pos: none
	 * @return not return
	 */
	private void deleteSpecies(){
    
	System.out.println(controller.showSpecies(1));

	System.out.println("Type the name of the species to be deleted ");
    sc.nextLine();
	String speciesName = sc.nextLine();
	
	if(controller.deleteSpecies(speciesName)) {

		System.out.println("Species successfully removed");
  
	  } else {
		System.out.println("Error, the species could not be eliminated");
	  }
	}

	/**
	 * Description: Allows you to edit a characteristic alredy recorded for a species of fauna
	 * pre: none
	 * pos: none
	 * @return not return
	 */
	private void editSpeciesFauna(){
    
		System.out.println("Which feature do you want to modify?");

		System.out.println("1. Species Name\n2. Scientific Name\n3.Is it migratory?\n4. Max Weigth");
		int optionToModify = sc.nextInt();
        
		System.out.println("Type the new information of the characteristic");
        sc.nextLine();
        String newCharacteristic = sc.nextLine();

		System.out.println("Type the name of the species for which you want to edit these characteristics");
		String speciesName = sc.nextLine();

		if(controller.editSpeciesFauna(optionToModify, newCharacteristic, speciesName)) {

			System.out.println("Information about the property located at:"+optionToModify+"was successfully modified ");
	  
		} else {
			
			System.out.println("The requested feature could not be modified");

		}
	  
	}

	/**
	 * Description: Allows you to edit a characteristic alredy recorded for a species of flora
	 * pre: none
	 * pos: none
	 * @return not return
	 */
	private void editSpeciesFlora(){
      
		System.out.println("Which feature do you want to modify?");
		System.out.println("1. Species Name\n2. Scientific Name\n3.Has Flowers?\n4.Has Fruits?\n5. Max Heigth");
		int optionToModify = sc.nextInt();

		System.out.println("Type the new information of the characteristic");
        sc.nextLine();
        String newCharacteristic = sc.nextLine();

		System.out.println("Type the name of the species for which you want to edit these characteristics");
		String speciesName = sc.nextLine();

		if(controller.editSpeciesFlora(optionToModify, newCharacteristic, speciesName)) {

			System.out.println("Information about the property located at:"+optionToModify+"was successfully modified ");
	  
		} else {
			
			System.out.println("The requested feature could not be modified");

		}
	}
}
