package com.skilldistillery.jets.entities;

public class Passenger extends Jet implements Transport{

	public Passenger(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void paxLoad() {
		System.out.println(getModel() + " is now boarding passengers.");
	}
}
