import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;

public class Rocket {
	char[][] map;
	
	public static void main(String[] args) throws Exception { new Rocket().run(); };
	public void run() throws Exception {
		Scanner file = new Scanner(new File("rocket.dat"));
		
		int times = Integer.parseInt(file.nextLine());
		for (int repeats = 0; repeats < times; repeats++) {
			map = new char[file.nextInt()][file.nextInt()];
			file.nextLine();
			for (int row = 0; row < map.length; row++)
				map[row] = file.nextLine().toCharArray();
			
			boolean result = false;
			for (int row = 0; row < map.length; row++)
				result = result || recur(row, 0);
			System.out.printf("Destination: %s\n", result ? "Mars" : "Asteroid");
		}
		
		file.close();
	}
	
	public boolean recur(int row, int col) {
		if (row >= 0 && row < map.length && col < map[row].length && map[row][col] == '.') {
			if (col + 1 == map[row].length) return true;
			boolean result = false;
			for (int rowDelta = -1; rowDelta <= 1; rowDelta++)
				result = result || recur(row + rowDelta, col + 1);
			return result;
		} else return false;
	}
}
