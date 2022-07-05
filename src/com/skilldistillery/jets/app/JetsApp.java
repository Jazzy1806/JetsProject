package com.skilldistillery.jets.app;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.Cargo;
import com.skilldistillery.jets.entities.Drone;
import com.skilldistillery.jets.entities.Fighter;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.Passenger;

import java.util.*;

public class JetsApp {

	static AirField airfield = new AirField();
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		JetsApp ja = new JetsApp();
		ja.run();
	}

	public void run() {
		menu();
	}
	
	public void menu() {
		boolean keepGoing = true;
		
		System.out.print("Welcome to Golden Dragon Airfield. What would you like to do today? \n");
		while(keepGoing) {
			System.out.println("\n1. List all jets at the airfield: type \"list\"" +
							 "\n2. Fly all of the jets at the airfield: type \"fly\"" +
							 "\n3. View the fastest jet: type \"fastest\"" +
							 "\n4. View the jet with the longest range: type \"range\"" +
							 "\n5. Load all cargo jets: type \"cargo\"" +
							 "\n6. Load all passenger jets: type \"passenger\"" +
							 "\n7. Start a dogfight: type \"fight\"" +
							 "\n8. Have all combat jets drop their bombs: type \"bombs\"" +
							 "\n9. Have drones start a video feed : type \"video\"" +
							 "\n10. Have drones scan for thermal signatures : type \"thermal\"" +
							 "\n11. Add a jet to the airfield : type \"add\"" +
							 "\n12. Remove a jet from the airfield inventory : type \"remove\"" +
							 "\n13. Quit the program: type \"quit\"");
			String selection = (scan.nextLine()).toLowerCase();
			while (true) {
				if (!selection.equals("list") && !selection.equals("fly") &&
					!selection.equals("fastest") && !selection.equals("range") &&
					!selection.equals("cargo") && !selection.equals("passenger") &&
					!selection.equals("fight") && !selection.equals("bombs") &&
					!selection.equals("video") && !selection.equals("thermal") &&
					!selection.equals("add") && !selection.equals("remove") && !selection.equals("quit")) {
						System.out.println("Hmm... that's not an option. What would you like to do? ");
						selection = (scan.nextLine()).toLowerCase();
				}
				break;
			}
			switch (selection) {
				case "list": listAllJets(); break;
				case "fly": flyAllJets(); break;
				case "fastest": fastestJet(); break;
				case "range": longestRange(); break;
				case "cargo": loadCargo(); break;
				case "passenger": loadPax(); break;
				case "fight": dogfight(); break;
				case "bombs": dropBombs(); break;
				case "video": video(); break;
				case "thermal": thermalSensor(); break;
				case "add": addCustomJet(); break;
				case "remove": userRemoveJet(); break;
				default: quit(); keepGoing = false;
			}
		}
	}
	
	public void listAllJets() {
		for (Jet jet : airfield.getJets()) {
			if (jet != null) {
				System.out.println(jet);
			}
		}
	}
	
	public void flyAllJets() {
		for (Jet jet : airfield.getJets()) {
			if (jet != null) {
				jet.fly();
			}
		}
	}
	
	public void fastestJet() {
		Jet fastestJet = null;
		double fastestSpeed = 0;
		for (Jet jet : airfield.getJets()) {
			if (jet.getSpeed() > fastestSpeed) {
				fastestSpeed = jet.getSpeed();
				fastestJet = jet;
			}
		}
		System.out.println("The fastest jet at the airfield is: \n" + fastestJet);
	}

	public void longestRange() {
		Jet bestRange = null;
		double longestRange = 0;
		for (Jet jet : airfield.getJets()) {
			if (jet.getRange() > longestRange) {
				longestRange = jet.getRange();
				bestRange = jet;
			}
		}
		System.out.println("The jet with the longest range is: \n" + bestRange);
	}
	
	public void loadCargo() {
		for (Jet jet : airfield.getJets()) {
			if (jet instanceof Cargo) {
				((Cargo) jet).loadCargo();
			}
		}
	}
	
	public void loadPax() {
		for (Jet jet : airfield.getJets()) {
			if (jet instanceof Passenger) {
				((Passenger) jet).paxLoad();
			}
		}
	}
	
	public void dogfight() {
		for (Jet jet : airfield.getJets()) {
			if (jet instanceof Fighter) {
				((Fighter) jet).fight();;
			}
			else if (jet instanceof Drone) {
				((Drone) jet).fight();
			}
		}
	}
	
	public void dropBombs() {
		for (Jet jet : airfield.getJets()) {
			if (jet instanceof Fighter) {
				((Fighter) jet).dropBombs();;
			}
			else if (jet instanceof Drone) {
				((Drone) jet).dropBombs();
			}
		}
	}
	
	public void video() {
		for (Jet jet : airfield.getJets()) {
			if (jet instanceof Drone) {
				((Drone) jet).videoFeed();
			}
		}
	}
	
	public void thermalSensor() {
		for (Jet jet : airfield.getJets()) {
			if (jet instanceof Drone) {
				((Drone) jet).thermalSensor();
			}
		}
	}
	
	public void addCustomJet() {
		System.out.println("\nWhat type of jet would you like to add to the airfield? \n");
		System.out.println("1. Cargo jet: type \"cargo\"" +
						 "\n2. Fighter jet: type \"fighter\"" +
						 "\n3. Passenger jet: type \"passenger\"" +
						 "\n4. Drone: type \"drone\"");
		String jetType = scan.nextLine().toLowerCase();
		while (!jetType.equals("cargo") && !jetType.equals("fighter") && !jetType.equals("passenger") 
				&& !jetType.equals("drone")) {
			System.out.println("That's not a valid type of jet. Enter \"cargo\", \"fighter\", \"passenger\", or \"drone\"");
			jetType = scan.nextLine();
	}
		System.out.println("What is the model? ");
		String jetModel = scan.nextLine(); 
		
		System.out.println("What is the top speed?");
		double jetSpeed = scan.nextDouble();
		
		System.out.println("What is the max range? ");
		int jetRange = scan.nextInt();
		
		System.out.println("How much does it cost? ");
		long jetPrice = scan.nextLong();
		airfield.addJet(jetType, jetModel, jetSpeed, jetRange, jetPrice);
		System.out.println("Your jet has been added to the airfield.");
	}
	
	public void userRemoveJet() {
		int counter = 1;
		System.out.println("Enter the number of the jet you would like to remove: ");
		for (Jet jet : airfield.getJets()) {
			System.out.println(counter + ". " + jet);
			counter++;
		}
		int selection = scan.nextInt();
		airfield.removeJet(selection);
		System.out.println("The jet you selected has been removed from the airfield.");
		scan.nextLine(); //refresh the scanner
	}
	
	public void quit() {
		System.out.println("You've opted to leave the airfield. Have a great day!");
		scan.close();
		System.exit(0);
	}
}