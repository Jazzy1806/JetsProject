package com.skilldistillery.jets.entities;

public class Fighter extends Jet implements Combat {

	public Fighter(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void fight() {
		System.out.println("Target is acquired. " + getModel() + " is moving to engage. Keep your arms and legs inside the aircraft and prepare for an epic dogfight.");
	}

	@Override
	public void dropBombs() {
		System.out.println("Target is locked in. " + getModel() + " is dropping payload.");
	}
}