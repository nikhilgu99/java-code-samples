package codeSamples;

import java.util.Stack;

public class NestedParentheses {

	public static void main(String[] args) {
		System.out.println(Solution("(()(())())"));
	}
	
	/*
	 * Determine whether a given string of parentheses (single type) is properly nested.
	 * Ex: (()(())()) -> true	()) -> false
	 */
	public static boolean Solution(String input) {
		
		Stack<Character> parentheses = new Stack<>();
		
		for (char c : input.toCharArray()) {
			if (c == '(') {
				parentheses.push(c);
			} else {
				if (parentheses.isEmpty()) {
					return false;
				}
				
				parentheses.pop();
			}
		}
		
		return parentheses.isEmpty() ? true : false;
	}

}
