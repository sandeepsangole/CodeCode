package array;

public class MajorityElement {

	public static void main(String[] args) {
		int[] arr = {8,8,7,7,7};
		System.out.println(majorityElement(arr));
	}

	public static int majorityElement(int[] nums) {
		int count = 1;
		int res = nums[0];

		for(int i = 1 ; i < nums.length;i++){

			if(count == 0){
				count++;
				res = nums[i];
			} else if(nums[i] == nums[i-1]){
				count++;
			} else {
				count --;
			}
		}

		return res;
	}

}
