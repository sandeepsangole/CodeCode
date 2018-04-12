package strings;

public class RomanToInteger {

	public static void main(String[] args) {
		RomanToInteger obj = new RomanToInteger();
	//	System.out.println(obj.romanToInt("XII"));
		//System.out.println(obj.romanToInt("IX"));
		System.out.println(obj.romanToInt("IIIIII"));
	}

	public int romanToInt(String s){

		int[] nums = new int[s.length()];

		for (int i = 0; i < s.length() ; i++){

			switch (s.charAt(i)){
				case 'X' : nums[i] = 10; break;
				case 'V' : nums[i] = 5; break;
				case 'I' : nums[i] = 1; break;
			}
		}

		int sum = 0;
		for (int i = 0;i<nums.length - 1;i++){
			if(nums[i] < nums[i + 1]){
				sum-=nums[i];
			} else {
				sum+=nums[i];
			}
		}

		return sum + nums[nums.length - 1];

	}
}
