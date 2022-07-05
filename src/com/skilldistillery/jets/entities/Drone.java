package com.skilldistillery.jets.entities;

public class Drone extends Jet implements SpecialSupport, Combat {

	public Drone(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fight() {
		System.out.println(getModel() + " is not equipped for a dogfight. Disengage to avoid destruction.");
	}

	@Override
	public void dropBombs() {
		int random = (int) Math.random() *4;
		switch (random) {
		case 1: 
			System.out.println(getModel() + " has a positive I.D. on target. Payload initiated."); break;
		case 2: 
			System.out.println("Someone forgot to load the bombs. " + getModel() + " should probably head back to the airfield."); break;
		case 3: 
			System.out.println("Sensor malfunciton- " + getModel() + " can't confirm target. Launch sequence aborted."); break;
		default: break;
		}
	}

	@Override
	public void videoFeed() {
		System.out.println(getModel() + " has started transmitting a live feed.");
	}

	@Override
	public void thermalSensor() {
		int random = (int) (Math.random() *2);
		switch (random) {
		case 0: 
			System.out.println(getModel() + " is scanning area. No thermal signature detected."); break;
		case 1: 
			System.out.println(getModel() + " has detected a thermal signatures in the area."); break;
		default: break;
		}
	}
}