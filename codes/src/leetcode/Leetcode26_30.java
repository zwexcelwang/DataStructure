package leetcode;

import java.util.HashMap;

public class Leetcode26_30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,0,0,1,1,2,3,4,4};
		System.out.println(removeDuplicates(nums));
	}
	
	/**
	 * 删除排序数组内重复的数字
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) return 0;
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    return i + 1;
    }
	
	/**
	 * 移除元素
	 * @param nums
	 * @param val
	 * @return
	 */
	public int removeElement(int[] nums, int val) {
		int i = 0;
		for (int j = 0; j < nums.length; j++) {
	        if (nums[j] != val) {
	            nums[i] = nums[j];
	            i++;
	        }
	    }
	    return i;
	  }
	 
	/**
	 * 实现strStr()
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr(String haystack, String needle) {
		int l1 = haystack.length(), l2 = needle.length();
		if (l1 < l2) {
			return -1;
		} else if (l2 == 0) {
			return 0;
		}
		int threshold = l1 - l2;
		for (int i = 0; i <= threshold; i++) {
			if (haystack.substring(i, i + l2).equals(needle)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 两数相除
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public int divide(int dividend, int divisor) {
		if (dividend == 0 || divisor == 0) {
            return 0;
        }
        long d1 = dividend, d2 = divisor;
        long result = divideLong(Math.abs(d1), Math.abs(d2));
        result = d1 * d2 < 0 ? -result : result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) result;
    }
    public long divideLong(long d1,long d2){
        if(d1<d2) {
            return 0;
        }
        long sum=d2,num=1;
        while(sum+sum<=d1){
            sum+=sum;
            num+=num;
        }
        return num+divideLong(d1-sum,d2);
    }
}
