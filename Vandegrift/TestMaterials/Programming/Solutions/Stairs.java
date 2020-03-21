import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;

public class Stairs {
	public static void main(String[] args) throws Exception { new Stairs().run(); };
	public void run() throws Exception {
		Scanner file = new Scanner(new File("stairs.dat"));
		
		int times = Integer.parseInt(file.nextLine());
		for (int repeats = 0; repeats < times; repeats++) {
			String[] dat = file.nextLine().split(" ");
			int n = Integer.parseInt(dat[0]);
			char material = dat[2].charAt(0);
			for (int s = 1; s <= n; s++) {
				if (dat[1].equals("R"))
					fill(' ', n - s);
				fill(material, s);
				System.out.println();
			}
		}
		
		file.close();
	}
	
	public void fill(char c, int m) {
		for (int v = 0; v < m; v++)
			System.out.print(c);
	}
}