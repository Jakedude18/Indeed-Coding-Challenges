import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;

public class Potatoes {
	public static void main(String[] args) throws Exception { new Potatoes().run(); };
	public void run() throws Exception {
		Scanner file = new Scanner(new File("potatoes.dat"));
		
		final double idealTemp = convert(70);
		
		int times = Integer.parseInt(file.nextLine());
		for (int repeats = 0; repeats < times; repeats++) {
			double temp = file.nextDouble();
			Double difference = idealTemp - convert(temp);
			if (difference == 0) System.out.println("No change");
			else System.out.printf("%.2f degrees %s\n", Math.abs(difference), (difference > 0 ? "warmer" : "cooler"));
		}
		
		file.close();
	}
	public double convert(double fahrenheit) {
		return (fahrenheit - 32) * 5.0 / 9.0;
	}
}