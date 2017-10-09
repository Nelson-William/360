package edu.nelson.test;
import java.util.Arrays;
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
	}


	
	
	/*
	 *Iterable<String> team = Arrays.asList("Will","Katie","Davy","Richard","McJean-Louis");
	 *
	 *for (String name : team) {
	 *	System.out.println(name);
	 *}
	
	 */
	
	

}
