import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;

public class Basalt {
	public static void main(String[] args) throws Exception { new Basalt().run(); };
	public void run() throws Exception {
		Scanner file = new Scanner(new File("basalt.dat"));
		
		List<Rock> rocks = new ArrayList<Rock>();
		
		int times = Integer.parseInt(file.nextLine());
		for (int repeats = 0; repeats < times; repeats++) {
			rocks.add(new Rock(file.nextDouble()));
		}
		Collections.sort(rocks);
		System.out.println(rocks.get(0).weight);
		System.out.println(rocks.get(rocks.size() - 1).weight);
		
		file.close();
	}
}

class Rock implements Comparable<Rock> {
	Double weight;
	
	public Rock(double weight) {
		this.weight = weight;
	}
	
	public int compareTo(Rock o) {
		return weight.compareTo(o.weight);
	}
}