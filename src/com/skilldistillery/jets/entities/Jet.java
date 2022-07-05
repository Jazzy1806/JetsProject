package com.skilldistillery.jets.entities;

import java.text.DecimalFormat;

public abstract class Jet {
	DecimalFormat df = new DecimalFormat("0.00");
	DecimalFormat priceFormat = new DecimalFormat("###,###,###,###,###,###,###,###,###,###.00");
	DecimalFormat rangeFormat = new DecimalFormat("###,###,###");

	private String model;
	private double speed;
	private int range;
	private long price;
	
	public Jet() {
		
	}

	public Jet(String model, double speed, int range, long price) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public double getSpeedInMach() {
		double mach = speed * 0.001303;
		return mach;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
	
	public void fly() {

		System.out.println(getModel() + " has a speed of " + speed + " MPH (MACH  " + df.format(getSpeedInMach()) + "), with a range of " + rangeFormat.format(range) + " miles, "
				+ "so it can fly " + df.format(range / speed) + " hours before it runs out of fuel. It sells for a cool $" + priceFormat.format(price));
	}

	@Override
	public String toString() {
		return "Type of jet: " + getClass().getSimpleName() + ", Model: " +  model + ", Speed: " + speed + " MPH, Range: " + rangeFormat.format(range) + " miles, Price: $" + priceFormat.format(price);
	}
	

}
