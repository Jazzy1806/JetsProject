package com.skilldistillery.jets.entities;

public class Cargo extends Jet implements CargoCarrier {

	public Cargo(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void loadCargo() {
		System.out.println(getModel() + " is getting loaded up now...");
	}
}