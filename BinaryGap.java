package codeSamples;

public class BinaryGap {

	public static void main(String[] args) {
		System.out.println(Solution(1106));
	}
	
	/*
	 *  Find longest sequence of zeros in binary representation of an integer.
	 *  Ex: 1106 -> 10001010010 -> 3
	 */
	public static int Solution(int N) {
		
        String binaryString = Integer.toBinaryString(N); //Get binary notation
        
        int currentChain = 0, maxChain = 0;
        
        for (char digit : binaryString.toCharArray()) {
            if (digit == '0') {
                currentChain++;
            } else {
            	// Store new longest chain if it's longer than stored one
                maxChain = (maxChain > currentChain) ? maxChain : currentChain;
                currentChain = 0;
            }
        }
        
        return maxChain;
	}

}
