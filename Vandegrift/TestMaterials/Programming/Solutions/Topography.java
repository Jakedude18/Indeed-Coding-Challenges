import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;

public class Topography {
	
	int[][] map;
	List<Coordinate> lowestCoordinates;
	List<Coordinate> highestCoordinates;
	
	public static void main(String[] args) throws Exception { new Topography().run(); };
	public void run() throws Exception {
		Scanner file = new Scanner(new File("topography.dat"));
		
		int times = Integer.parseInt(file.nextLine());
		for (int repeats = 0; repeats < times; repeats++) {
			int maxX = file.nextInt();
			int maxY = file.nextInt();
			file.nextLine();
			
			Integer highest = null;
			Integer lowest = null;
			map = new int[maxY][maxX];
			for (int y = 0; y < maxY; y++) {
				String l = file.nextLine();
				for (int x = 0; x < maxX; x++) {
					Integer val = l.charAt(x) - '0';
					map[y][x] = val;
					if (lowest == null || val < lowest) {
						lowest = val;
						lowestCoordinates = new ArrayList<Coordinate>();
					}
					if (val == lowest) lowestCoordinates.add(new Coordinate(x, y));
					if (highest == null || val > highest) {
						highest = val;
						highestCoordinates = new ArrayList<Coordinate>();
						highestCoordinates.add(new Coordinate(x, y));
					}
					if (val == highest) highestCoordinates.add(new Coordinate(x, y));
				}
			}
			
			List<Area> areas = new ArrayList<Area>();
			for (int y = 0; y < maxY; y++) {
				for (int x = 0; x < maxX; x++) {
					Coordinate coordinate = new Coordinate(x, y);
					if (lowestCoordinates.contains(coordinate) || highestCoordinates.contains(coordinate)) {
						areas.add(locateArea(new Coordinate(x, y)));
					}
				}
			}
			Collections.sort(areas);
			areas.forEach((area) -> {
				System.out.println(area);
			});
			
			if (repeats + 1 != times) System.out.println();
		}
		
		file.close();
	}
	
	public Area locateArea(Coordinate c) {
		int e = map[c.y][c.x];
		TreeSet<Coordinate> set = countArea(e, c, new TreeSet<Coordinate>());
		lowestCoordinates.removeAll(set);
		highestCoordinates.removeAll(set);
		return new Area(set, e);
	}
	
	public TreeSet<Coordinate> countArea(int e, Coordinate c, TreeSet<Coordinate> sf) {
		if (c.y >= 0 && c.x >= 0 && c.y < map.length && c.x < map[0].length && map[c.y][c.x] == e && !sf.contains(c)) {
			TreeSet<Coordinate> s = new TreeSet<Coordinate>(sf);
			s.add(c);
			s.addAll(countArea(e, new Coordinate(c.x, c.y - 1), s));
			s.addAll(countArea(e, new Coordinate(c.x, c.y + 1), s));
			s.addAll(countArea(e, new Coordinate(c.x - 1, c.y), s));
			s.addAll(countArea(e, new Coordinate(c.x + 1, c.y), s));
			return s;
		} else return sf;
	}
}

class Coordinate implements Comparable<Coordinate> {
	int x, y;
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "(" + (x + 1) + ", " + (y + 1) + ")";
	}
	
	public int hashCode() {
		return new Integer(x + "0" + y).hashCode();
	}
	
	public boolean equals(Object o) {
		return o instanceof Coordinate && compareTo((Coordinate)o) == 0;
	}

	public int compareTo(Coordinate o) {
		if (x + y == o.x + o.y) return y - o.y;
		else return (x + y) - (o.x + o.y);
	}
}

class Area implements Comparable<Area> {
	Coordinate topLeft, bottomRight;
	int coordinates;
	int elevation;
	
	public Area(TreeSet<Coordinate> coordinates, int elevation) {
		this.topLeft = coordinates.first();
		this.bottomRight = coordinates.last();
		this.coordinates = coordinates.size();
		this.elevation = elevation;
	}
	
	public int compareTo(Area o) {
		return topLeft.compareTo(o.topLeft);
	}
	
	public String toString() {
		return coordinates + " coordinate(s) with elevation " + elevation + " from " + topLeft + " to " + bottomRight;
	}
}