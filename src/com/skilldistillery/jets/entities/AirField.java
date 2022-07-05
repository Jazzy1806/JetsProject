package com.skilldistillery.jets.entities;

import java.io.*;
import java.util.*;

public class AirField {
	private ArrayList<Jet> jets;
	
	public AirField() {
		jets =  new ArrayList<Jet>();
		inventory("jets.csv");
	}
	
	public ArrayList<Jet> inventory(String filename) {
		try (BufferedReader bufIn = new BufferedReader(new FileReader(filename))) {
			String line;
			String[] readJets;
			while ((line = bufIn.readLine()) != null) {
				readJets = line.split(",");
				addJet(readJets[0], readJets[1], Double.parseDouble(readJets[2]), Integer.parseInt(readJets[3]), Long.parseLong(readJets[4]));
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return jets;
	}
	
	public ArrayList<Jet> getJets() {
		ArrayList<Jet> inventory = new ArrayList<Jet>();
		for (Jet jet : this.jets) {
			if (jet != null) {
				inventory.add(jet);
			}
		}
		return inventory;
	}
	
	public void addJet(String type, String model, double speed, int range, long price) {
		if (type.toLowerCase().equals("cargo")) {
			jets.add(new Cargo(model, speed, range, price));
		}
		else if (type.toLowerCase().equals("fighter")) {
			jets.add(new Fighter(model, speed, range, price));
		}
		else if (type.toLowerCase().equals("passenger")) {
			jets.add(new Passenger(model, speed, range, price));
		}
		else if (type.toLowerCase().equals("drone")) {
			jets.add(new Drone(model, speed, range, price));
		}
	}
	
	public void removeJet(int selection) {
		jets.remove(selection - 1);
	}
	
	public Jet getJet(int index) {
		return jets.get(index);
	}
	
	public void hirePilot (int aircraft, int pilotChoice) {
		ArrayList<Pilot> pilotList = new ArrayList<Pilot>();
		pilotList = jets.get(0).getPilots();
		jets.get(aircraft-1).setPilot(pilotList.get(pilotChoice-1));	
		System.out.println("You have hired a new pilot!");
	}
}
