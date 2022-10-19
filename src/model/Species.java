package model;

public abstract class Species {
	
private String speciesName;
private String scientificName;

public Species(String speciesName, String scientificName) {
	super();
	this.speciesName = speciesName;
	this.scientificName = scientificName;
}

public String getSpeciesName() {
	return speciesName;
}

public void setSpeciesName(String speciesName) {
	this.speciesName = speciesName;
}

public String getScientificName() {
	return scientificName;
}

public void setScientificName(String scientificName) {
	this.scientificName = scientificName;
}

@Override
public String toString() {
	return "Species [speciesName=" + speciesName + ", scientificName=" + scientificName + "]";
}

}