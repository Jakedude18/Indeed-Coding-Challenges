import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;

public class Zoom {
	int[][] oldImg;
	int[][] newImg;
	
	public static void main(String[] args) throws Exception { new Zoom().run(); };
	public void run() throws Exception {
		Scanner file = new Scanner(new File("zoom.dat"));
		
		int times = Integer.parseInt(file.nextLine());
		for (int repeats = 0; repeats < times; repeats++) {
			int size = Integer.parseInt(file.nextLine());
			oldImg = new int[size][size]; newImg = new int[size / 2][size / 2];
			for (int row = 0; row < size; row++)
				oldImg[row] = Arrays.stream(file.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for (int y = 0; y < size; y+=2) for (int x = 0; x < size; x+=2) zoom(new Point(y, x));
			for (int row = 0; row < size / 2; row++)
				System.out.println(Arrays.toString(newImg[row]).replaceAll("[\\[\\],]", ""));
			if (repeats + 1 < times)System.out.println();
		}
		
		file.close();
	}
	
	public void zoom(Point oldImgPoint) {
		double avg = 0.0;
		for (int y = oldImgPoint.y; y < oldImgPoint.y + 2; y++)
			for (int x = oldImgPoint.x; x < oldImgPoint.x + 2; x++)
				avg += oldImg[y][x];
		avg /= 4.0;
		int newImgValue = (int)Math.round(avg);
		Point newImgPoint = oldImgPoint.zoom();
		newImg[newImgPoint.y][newImgPoint.x] = newImgValue;
	}
}

class Point {
	int x, y;
	
	Point(int y, int x) {
		this.x = x;
		this.y = y;
	}
	
	Point zoom() {
		return new Point(this.y / 2, this.x / 2);
	}
}