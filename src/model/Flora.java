package model;


public class Flora extends Species {

	private boolean hasFlowers;
	private boolean hasFruits;
	private double maxHeigth;

	public Flora(String speciesName, String scientificName, boolean hasFlowers, boolean hasFruits, double maxHeigth) {
		super(speciesName, scientificName);
		this.hasFlowers = hasFlowers;
		this.hasFruits = hasFruits;
		this.maxHeigth = maxHeigth;
	}
	
	public boolean HasFlowers() {
		return hasFlowers;
	}

	public void setHasFlowers(boolean hasFlowers) {
		this.hasFlowers = hasFlowers;
	}

	public boolean HasFruits() {
		return hasFruits;
	}

	public void setHasFruits(boolean hasFruits) {
		this.hasFruits = hasFruits;
	}

	public double getMaxHeigth() {
		return maxHeigth;
	}

	public void setMaxHeigth(double maxHeigth) {
		this.maxHeigth = maxHeigth;
	}

	@Override
	public String toString() {
		return super.toString()+"Flora [hasFlowers=" + hasFlowers + ", hasFruits=" + hasFruits + ", maxHeigth=" + maxHeigth + "]";
	}
}
