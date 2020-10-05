import java.util.*;

public class Ballot implements Comparable<Ballot>{

	private ArrayList<String> preferences;

	// construct the ballot from an array of Strings
	public Ballot(String[] names){
		preferences = new ArrayList<>();
		for(String name: names){
			preferences.add(name);
		}
	}

	// return the first choice candidate for this ballot
	public String getCandidate(){
		return preferences.get(0);
	}

	// remove a specific candidate from the preferences
	public void eliminate(String name){
		preferences.remove(name);
	}

	// compare this ballot to another in alphabetical order
	// by first choice candidate
	public int compareTo(Ballot other){
		return getCandidate().compareTo(other.getCandidate());
	}
}
