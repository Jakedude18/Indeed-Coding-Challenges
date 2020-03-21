import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;

public class Boring {
	public static void main(String[] args) throws Exception { new Boring().run(); };
	public void run() throws Exception {
		Scanner file = new Scanner(new File("boring.dat"));
		
		int times = Integer.parseInt(file.nextLine());
		for (int repeats = 0; repeats < times; repeats++) {
			String line = " " + file.nextLine().toUpperCase() + " ";
			boolean contains = line.contains(" SPACE ") || line.contains(" BORING ");
			System.out.println(contains);
		}
		
		file.close();
	}
}
