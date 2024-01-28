package codeSamples;

public class MinJumpSteps {

	public static void main(String[] args) {
		System.out.println(Solution(10,85,30));
	}
	
	/*
	 * Count minimal number of jumps from position start to end. (Assume start < end)
	 * EX: 10 to 85 with size 30 step -> 3 steps required
	 */
	public static int Solution(int start, int end, int step) {
        int distance = end - start;
        int steps = distance / step;
        
        if (distance % step != 0) {
            steps++;
        }

        return steps;
	}

}
