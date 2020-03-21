import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;

public class Diplomacy {
	Country[][] map;
	List<Country> countries;
	List<Country> remainingCountries;
	List<Integer> emptySpaces;
	
	public static void main(String[] args) throws Exception { new Diplomacy().run(); };
	public void run() throws Exception {
		Scanner file = new Scanner(new File("diplomacy.dat"));
		
		int times = Integer.parseInt(file.nextLine());
		for (int repeats = 0; repeats < times; repeats++) {
			map = new Country[file.nextInt()][file.nextInt() * 2];
			file.nextLine();
			countries = new ArrayList<Country>();
			
			emptySpaces = new ArrayList<Integer>();
			
			String[] prefilledMap = file.nextLine().split(" ");
			List<Country> prefilledCountries = new ArrayList<Country>();
			for (int c = 0; c < prefilledMap.length; c++) {
				String prefilledCountry = prefilledMap[c];
				Country country = Country.tbd;
				if (prefilledCountry.equals("?")) {
					emptySpaces.add(c);
				} else {
					country = new Country(prefilledCountry);
					prefilledCountries.add(country);
				}
				int row = c / (map[0].length / 2);
				map[row][(c % (map[0].length / 2)) * 2 + row % 2] = country;
			}
			countries.addAll(prefilledCountries);
			
			remainingCountries = new ArrayList<Country>();
			String[] remainingCountryNames = file.nextLine().split(" ");
			for (String remainingCountryName : remainingCountryNames) {
				Country remainingCountry = new Country(remainingCountryName);
				countries.add(remainingCountry);
				remainingCountries.add(remainingCountry);
			}
			
			for (int type = 0; type <= 1; type++) {
				String[] pairs = file.nextLine().split(" ");
				for (String pair : pairs) {
					String[] countryNames = pair.split("-");
					
					Country countryA = countries.get(countries.indexOf(new Country(countryNames[0])));
					Country countryB = countries.get(countries.indexOf(new Country(countryNames[1])));
					
					if (type == 0) countryA.ally(countryB);
					else countryB.rival(countryA);
				}
			}
			
			List<List<Country>> permutation = permutate();
			int bestScore = Integer.MIN_VALUE;
			Iterator<Country> bestCountrySet = null;
			List<List<Country>> ties = new ArrayList<List<Country>>();
			for (List<Country> set : permutation) {
				Iterator<Country> setIterator = set.iterator();
				int totalScore = 0;
				for (int r = 0; r < map.length; r++) {
					for (int c = 0; c < map[r].length; c++) {
						if (map[r][c] != null && map[r][c].equals(Country.tbd)) {
							Country country = setIterator.next();
							int score = country.relationship(getNeighbors(r, c, set));
							totalScore += score;
						}
					}
				}
				if (totalScore > bestScore) {
					bestScore = totalScore;
					bestCountrySet = set.iterator();
					ties = new ArrayList<List<Country>>();
				} else if (totalScore == bestScore) {
					ties.add(set);
				}
			}
			
			String list = "";
			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map[r].length; c++) {
					Country a = map[r][c];
					if (a == null)
						continue;
					else if (a.equals(Country.tbd))
						a = bestCountrySet.next();
					list += a.name + " ";
				}
			}
			System.out.println(list.trim());
			
			//for (Country[] j : map)
				//System.out.println(Arrays.toString(j).replaceAll("[\\[\\]]|(null),*|(, )|", ""));
		}
		
		file.close();
	}
	
	public List<Country> getNeighbors(int r, int c, List<Country> set) {
		List<Country> neighbors = new ArrayList<Country>();
		for (int rTheta = -1; rTheta <= 1; rTheta++)
			for (int cTheta = -2; cTheta <= 2; cTheta++)
				if (Math.abs(rTheta) + Math.abs(cTheta) == 2) {
					Country neighbor = null;
					try {
						neighbor = map[r + rTheta][c + cTheta];
					} catch (Exception e) { continue; };
					if (neighbor.equals(Country.tbd) && !set.isEmpty()) {
						int setIndex = emptySpaces.indexOf(((r + rTheta) * map[0].length + (c + cTheta)) / 2);
						neighbors.add(set.get(setIndex));
					} else neighbors.add(neighbor);
				}
		return neighbors;
	}

	public List<List<Country>> permutate() {
		return permutate(new ArrayList<Country>());
	}
	
	public List<List<Country>> permutate(List<Country> countries) {
		List<List<Country>> permutation = new ArrayList<List<Country>>();
		for (Country country : this.remainingCountries) {
			if (!countries.contains(country)) {
				List<Country> selected = new ArrayList<Country>(countries);
				selected.add(country);
				permutation.addAll(permutate(selected));
			}
		}
		if (countries.size() == this.remainingCountries.size())
			permutation.add(countries);
		return permutation;
	}
}

class Country {
	static Country tbd = new Country("?");
	
	String name;
	List<Country> allies;
	List<Country> rivals;
	
	public Country(String name) {
		this.name = name;
		this.allies = new ArrayList<Country>();
		this.rivals = new ArrayList<Country>();
	}
	
	public int score(List<Country> neighbors) {
		int score = 0;
		for (Country neighbor : neighbors) {
			if (allies.contains(neighbor)) score++;
			if (rivals.contains(neighbor)) score--;
		}
		return score;
	}
	
	public void ally(Country o) {
		this.allies.add(o);
		o.allies.add(this);
	}

	public void rival(Country o) {
		this.rivals.add(o);
		o.rivals.add(this);
	}
	
	public int relationship(List<Country> a) {
		int score = 0;
		for (Country o : a) score += relationship(o);
		return score;
	}
	
	public int relationship(Country o) {
		return this.allies.contains(o) ? 1 : this.rivals.contains(o) ? -1 : 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Country && this.name.equals(((Country)obj).name);
	}
	
	@Override
	public String toString() {
		return name.toString();
	}
}