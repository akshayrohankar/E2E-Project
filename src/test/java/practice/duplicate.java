package practice;

import java.util.HashSet;
import java.util.Set;

public class duplicate {

	public static void main(String[] args) {

		// 5.1 Years of Experience in software testing, including software testing best
		// practices

		String input = "5.1 Years of Experience in software testing, including software testing best practices";

		
		char[] input_char = input.trim().toCharArray();
		
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < input_char.length; i++) {
			if(set.add(input_char[i]) == false) {
				System.out.print(input_char[i]+ " ");
			}
		}
		
	}
}
