import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;

public class Recruiting {
	
	Map<String, Person> peopleNames;
	List<Person> people;
	
	public static void main(String[] args) throws Exception { new Recruiting().run(); };
	public void run() throws Exception {
		Scanner file = new Scanner(new File("recruiting.dat"));
		
		int times = Integer.parseInt(file.nextLine());
		for (int repeats = 0; repeats < times; repeats++) {
			int amountPeople = Integer.parseInt(file.nextLine());
			peopleNames = new HashMap<String, Person>();
			people = new ArrayList<Person>();
			for (int a = 0; a < amountPeople; a++) {
				Person person = new Person(file.nextLine());
				peopleNames.put(person.name, person);
				people.add(person);
			}
			for (Person person : people) {
				for (String connection : person.input) {
					person.connections.add(peopleNames.get(connection.replace("*", "")));
				}
				person.connections.remove(0);
			}
			people.forEach((person) -> {
				person.calculateScore();
			});
			Collections.sort(people);
			Collections.reverse(people);
			String out = "";
			for (Person person : people) {
				if (person.rank == 0)
					out += person.toString() + " ";
			}
			out.trim();
			System.out.println(out);
		}
		
		file.close();
	}
}

class Person implements Comparable<Person> {
	String name;
	int rank;
	List<Person> connections;
	Double score;
	
	String[] input;
	
	public Person(String in) {
		this.input = in.split("[:, ]+");
		name = input[0].replace("*", "");
		rank = input[0].lastIndexOf("*") + 1;
		connections = new ArrayList<Person>();
	}
	
	public void calculateScore() {
		if (rank > 0) this.score = -1.0;
		else {
			double score = 0;
			for (Person firstDegree : connections) {
				score += firstDegree.rank;
				for (Person secondDegree : firstDegree.connections) {
					score += secondDegree.rank / 2.0;
				}
			}
			this.score = score;
		}
	}

	public int compareTo(Person o) {
		int compare = o.score.compareTo(score);
		if (compare == 0) compare = name.compareTo(o.name);
		return compare < 0 ? 1 : -1;
	}
	
	public String toString() {
		return name;
	}
}