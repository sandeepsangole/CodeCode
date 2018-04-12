package array;
/*

Boyer-Moore Voting Algorithm [Accepted]
Intuition

If we had some way of counting instances of the majority element as +1+1 and instances
of any other element as -1−1, summing them would make it obvious that the majority element
 is indeed the majority element.

Algorithm

Essentially, what Boyer-Moore does is look for a suffix sufsuf of nums where suf[0]suf[0]
is the majority element in that suffix. To do this, we maintain a count, which is incremented
whenever we see an instance of our current candidate for majority element and decremented whenever
we see anything else. Whenever count equals 0, we effectively forget about everything in nums up
to the current index and consider the current number as the candidate for majority element.
It is not immediately obvious why we can get away with forgetting prefixes of nums - consider
the following examples (pipes are inserted to separate runs of nonzero count).

[7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7]

 */
public class MajorityElement {

	public static void main(String[] args) {
		int[] arr = {8,8,7,7,7};

		System.out.println(majorityElement(arr));
	}


	public static int majorityElement(int[] nums) {
		
		int count = 1;
		int res = nums[0];
		
		for(int i = 1;i<nums.length;i++){
			
			if(count == 0){
				
				count++;
				res = nums[i];
			}
			
			else if(nums[i] == res){
				count++;
			} else {
				count--;
			}
		}
		
		return res;
	}
	
	


}
