import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;

public class Phobos {
	
	String vowels = "";
	String consonants = "";
	
	public static void main(String[] args) throws Exception { new Phobos().run(); };
	public void run() throws Exception {
		Scanner file = new Scanner(new File("phobos.dat"));
		
		for (char c = 65; c < 65 + 26; c++) {
			if ((c + "").matches("[AEIOU]")) vowels += c;
			else consonants += c;
		}
		
		int times = Integer.parseInt(file.nextLine());
		for (int repeats = 0; repeats < times; repeats++) {
			String encrypted = file.nextLine();
			double vowelCount = 0.0;
			for (char c : encrypted.toCharArray())
				if (vowels.contains(c + ""))
					vowelCount++;
			StringBuffer decrypted = new StringBuffer("");
			for (char c : encrypted.toCharArray()) {
				boolean reverse = vowels.contains(c + "") != vowelCount / encrypted.replace(" ", "").length() >= 0.5;
				decrypted.append(shift(c, reverse));
			}
			System.out.println(decrypted.reverse());
		}
		
		file.close();
	}
	
	public char shift(char c, boolean r) {
		int shift = r ? 1 : -1;
		if (vowels.contains(c + ""))
			return vowels.charAt((vowels.indexOf(c) + shift + vowels.length()) % vowels.length());
		else if (c == ' ')
			return c;
		else
			return consonants.charAt((consonants.indexOf(c) + shift + consonants.length()) % consonants.length());
	}
}