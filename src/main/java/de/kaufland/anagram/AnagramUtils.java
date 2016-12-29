package de.kaufland.anagram;

/**
 * @author vinodjagwani
 *
 * Util class for defining helper methods.
 */
import java.util.Arrays;

public class AnagramUtils {

	public static String sort(String input) {
		char[] ch = input.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
}
