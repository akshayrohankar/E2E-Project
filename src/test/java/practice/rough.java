package practice;

import java.text.NumberFormat;
import java.text.ParseException;

public class rough {

	public static void main(String[] args) throws ParseException {

		
		Number i = NumberFormat.getNumberInstance(java.util.Locale.US).parse("265,858");
		System.out.println(i);
	}
}
