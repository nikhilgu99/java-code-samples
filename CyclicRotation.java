package codeSamples;

import java.util.Arrays;

public class CyclicRotation {

	public static void main(String[] args) {
		
		int[] testArray = {3, 8, 9, 7, 6};
		System.out.println(Arrays.toString(Solution(testArray, 3)));
	}
	
	/*
	 *  Rotate an array to the right by a given number of steps.
	 *  Ex: [3, 8, 9, 7, 6] 3 times ->  [9, 7, 6, 3, 8]
	 */
	public static int[] Solution(int[] numbers, int rotations) {
        if (numbers == null || numbers.length == 0) {
            return numbers;
        }

        int length = numbers.length;
        rotations = rotations % length; 

        if (rotations == 0) {
            return numbers;
        }

        int[] rotatedNumbers = new int[length];

        for (int i = 0; i < length; i++) {
            int newIndex = (i + rotations) % length;
            rotatedNumbers[newIndex] = numbers[i];
        }

        return rotatedNumbers;
    }

}
