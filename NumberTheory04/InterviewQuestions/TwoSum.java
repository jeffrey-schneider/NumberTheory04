package InterviewQuestions;

/**
 * Given an array of integers, return the indices of the two numbers 
 * whose sum is equal to a given target.
 * 
 * You may assume that each input would have exactly one solution, 
 * and you may not use the same element twice.
 * 
 */


public class TwoSum {

	public static void main(String[] args) {
		int[] a = {2, 7, 11, 15};
		int target = 9;	
		
		int[] b = getBruteForce(a, target);
		for (int i : b) {
			System.out.println(i);
		}

	}
	
	/** * Time complexity O(n^2)
	 * @param nums
	 * @param target 
	 */
	public static int[] getBruteForce(int[] nums, int target) {
		for(int i = 0; i <= nums.length; i++) {
			for(int j = i + 1; j <= nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					return new int[] {i,j};
				}
			}
		}
		return new int[] {};
	}

}
