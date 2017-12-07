package edu.nelson.test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

/*
 * Collections are groups of OBJECTS
 * they can be stored in an ARRAY, SET, or QUEUE*/

public class CollectionTest {
	public static void main(String args[]) {
	
	ArrayList<String> team = new ArrayList<String>();
	team.add("Will");
	team.add("Katie");
	team.add("Davy");
	team.add("Richard");
	team.add("Mc Jean-Louis");
	
	System.out.println("The members of team 2 are: " +team);
	System.out.println("There are "+team.size()+" people in team 2.");
	}
}

public class CollectionHashMap {
	public static void main(String[] args) {
		/* Declaration */
		HashMap<Integer, String> team2 = new HashMap<Integer, String>();
		/* Add elements */
		team2.put(4, "Richard")
		team2.put(6, "Mc Jean-Louis");
		team2.put(1, "Will");
		team2.put(3, "Davy");
		team2.put(2, "Katie");
		
		System.out.println("Team 2 has "+team2.size()+" people in it.");
		
		/* Removing element by key */
		team2.remove(1);
		System.out.println(team2);
		
		/* Search for element by name */
		if(team2.containsKey("Will")) {
			System.out.println("Element Found");
		}
		else {
			System.out.println("Element Missing");
		}
		/* Remove all elements from HashMap */
		team2.clear();
	}
}


	
	
	/*
	 *Iterable<String> team = Arrays.asList("Will","Katie","Davy","Richard","McJean-Louis");
	 *
	 *for (String name : team) {
	 *	System.out.println(name);
	 *}
	
	 */
	
	


