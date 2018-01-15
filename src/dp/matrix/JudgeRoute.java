package dp.matrix;

/*

657. Judge Route Circle

Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this
 robot makes a circle, which means it moves back to the original place.

The move sequence is represented by a string. And each move is represent by a character.
The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false
representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false

 */
public class JudgeRoute {

	public static void main(String[] args) {

		System.out.println(isJudgeRouteCircle("UD"));
		System.out.println(isJudgeRouteCircle("LL"));

	}

	private static boolean isJudgeRouteCircle(String input){

		if(input == null || input.length() == 0){
			return false;
		}

		char[] inputArray = input.toCharArray();
		int position = 0;

		for(char c : inputArray){
			if(c == 'U') position++;
			if(c == 'D') position--;
			if(c == 'L') position--;
			if(c == 'R') position++;
		}

		return position == 0;

	}
}
