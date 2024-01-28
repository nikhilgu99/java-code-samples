package codeSamples;

import java.util.Arrays;

public class MissingInteger {

	public static void main(String[] args) {
		int[] numbers = {1, 3, 6, 4, 1, 2};
		System.out.println(Solution(numbers));
	}
	
	/*
	 * Find the smallest positive integer that does not occur in a given sequence.
	 * Ex: [1, 6, 3, 4, 1, 2] -> Return 5
	 */
	public static int Solution(int[] numbers) {
		int smallestPositive = 1;
		
		Arrays.sort(numbers);
		
		for (int i : numbers) {
			if (i == smallestPositive) {
				smallestPositive++;
			} else if (i > smallestPositive) {
				break;
			}
		}
		
		return smallestPositive;
	}

}
