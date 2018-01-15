package dp.matrix.dp;

import java.util.Stack;

/*
84. Largest Rectangle in Histogram

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
find the area of largest rectangle in the histogram.

 */
public class HistogramArea {

	public static void main(String[] args) {

		System.out.println(maxHistogram(new int[] { 2, 1, 5, 6, 2, 3 }));
	}

	public static int maxHistogram(int[] heights) {
		//1. insert into stack if stack is empty or peek is smaller than height
		//2. If peek is grater than height then remove an calculate area
		//3. heights[top] * i - stack.peek() - 1)

		if (heights == null || heights.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		int            max   = 0;
		int            i     = 0;
		while (i < heights.length) {

			if (stack.isEmpty() || stack.peek() < heights[ i ]) {
				stack.push(i); // index
				i++;
			} else {

				int h = heights[ stack.pop() ];
				int w = stack.isEmpty() ? heights[ i ] : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}
		}

		return max;
	}
}
