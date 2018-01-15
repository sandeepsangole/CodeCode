package array;

public class ConsecutiveOnes {
	public static void main(String[] args) {
		System.out.println(findMaxConsecutiveOnes(new int[]{1}));
	}
	public static int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
		int count = 0;

		for(int i = 0;i<nums.length;i++){
			if(nums[i] == 1){
				count++;
			} else {
				max = Math.max(max,count);
				count = 0;
			}max = Math.max(max,count);
		}

		return Math.max(max,count);
	}
}
