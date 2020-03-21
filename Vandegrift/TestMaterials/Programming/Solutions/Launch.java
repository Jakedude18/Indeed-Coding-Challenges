import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;

public class Launch {
	public static void main(String[] args) throws Exception { new Launch().run(); };
	public void run() throws Exception {
		Scanner file = new Scanner(new File("launch.dat"));
		
		int times = Integer.parseInt(file.nextLine());
		for (int repeats = 0; repeats < times; repeats++) {
			List<Day> days = new ArrayList<Day>();
			int totalDays = file.nextInt();
			file.nextLine();
			for (int d = 0; d < totalDays; d++) {
				String l = file.nextLine();
				days.add(new Day(d, l));
			}
			Day launchDay = null;
			for (Day day : days) {
				if (launchDay == null) launchDay = day;
				if (day.isPriorityDay) {
					if (day.rainChance <= 25) {
						launchDay = day;
						break;
					} else if (day.rainChance < launchDay.rainChance)
						launchDay = day;
				} else if (!launchDay.isPriorityDay)
					if (day.rainChance < launchDay.rainChance)
						launchDay = day;
			}
			System.out.println("Launch Date: " + launchDay.title);
		}
		
		file.close();
	}
}

class Day {
	String title;
	int originalOrder;
	boolean isPriorityDay;
	int rainChance;
	
	public Day(int o, String l) {
		String[] n = l.replaceAll("[%,]", "").split(" ");
		
		title = l.substring(0, l.indexOf(" - "));
		originalOrder = o;
		isPriorityDay = "Friday Saturday Sunday".contains(n[0]);
		rainChance = Integer.parseInt(n[4]);
	}
}