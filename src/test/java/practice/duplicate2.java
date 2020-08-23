package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class duplicate2 {

	public static void main(String[] args) {

		// 5.1 Years of Experience in software testing, including software testing best
		// practices
		String input = "5.1 Years of Experience in software testing, including software testing best practices";
		char[] input_char = input.trim().toCharArray();

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < input_char.length; i++) {
			if (map.get(input_char[i]) == null) {
				map.put(input_char[i], 1);
			} else {
				map.put(input_char[i], map.get(input_char[i]) + 1);
			}
		}
		
		Set<Entry<Character, Integer>> entry = map.entrySet();
		for (Entry<Character, Integer> e : entry) {
			if(e.getValue()>1) {
				System.out.println("Duplicate element is: "+e.getKey() + " Appearing: "+e.getValue()+ " times.");
			}
		}
	}
}
