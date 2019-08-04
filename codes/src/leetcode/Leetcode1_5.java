package exer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Leetcode1_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums1 = {1, 2};
//		int[] nums2 = {3, 4};
//		System.out.println(findMedianSortedArrays(nums1, nums2));
		System.out.println(longestPalindrome("ac"));
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] label = new int[2];
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			hashMap.put(nums[i], i);
		}
		for(int i=0;i<nums.length;i++) {
			if(hashMap.containsKey(target-nums[i]) && hashMap.get(target-nums[i])!=i) {
				label[0] = i;
				label[1] = hashMap.get(target-nums[i]);
				break;
			}
		}
		return label;
	}

	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1,l2,0);
    }
	
    public ListNode add(ListNode l1, ListNode l2, int a){
        if(l1 == null && l2 == null && a == 0) return null;
        int x = l1==null ? 0 : l1.val;
        int y = l2==null ? 0 : l2.val;
        int sum = x + y + a;
        ListNode n = new ListNode(sum % 10);
        n.next = add(l1==null ? null : l1.next,
                     l2==null ? null : l2.next,
                     sum/10);
        return n;
    }
    
    public class ListNode {
    	 int val;
    	 ListNode next;
    	 ListNode(int x) { 
    		 val = x; 
    	}
    }
    
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        int end=0,start=0;
        Set<Character> set = new HashSet<>();
        while(start<n && end<n){
           if(set.contains(s.charAt(end))){
               set.remove(s.charAt(start++));
           }else{
               set.add(s.charAt(end++));
               res=Math.max(res,end-start);
           }    
        }
        return res;
    }
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	 int[] temp = new int[nums1.length + nums2.length];
    	 int i = 0;
    	 int j = 0;
    	 int k = 0;
    	 while(i < nums1.length && j < nums2.length) {
    		 if(nums1[i] < nums2[j]) {
    			 temp[k] = nums1[i];
    			 i++;
    		 }else {
    			 temp[k] = nums2[j];
    			 j++;
    		 }
    		 k++;
    	 }
    	 while(i < nums1.length) {
    		 temp[k++] = nums1[i++];
    	 }
    	 while(j < nums2.length) {
    		 temp[k++] = nums2[j++];
    	 }
//    	 for(int m =0; m<temp.length; m++) {
//    		 System.out.println(temp[m]);
//    	 }
        if(temp.length % 2 == 0) {
//        	System.out.println(temp[temp.length/2-1]);
//        	System.out.println(temp[temp.length/2]);
        	return (temp[temp.length/2-1] + temp[temp.length/2]) /2.0 ;
        }else {
        	return temp[(temp.length-1)/2];
        }
    }
    
    public static String longestPalindrome(String s) {
        int[][] dp = new int[s.length()][s.length()];
        String res = "";
        //考虑只有一个字符的情况,例a
        if(s.length() == 1) {
        	return s;
        }
        char[] charArray = s.toCharArray();
        //初始化
        for(int i=0; i<s.length(); i++){
            dp[i][i] = 1;
        }
        for(int len=2; len<=s.length(); len++) {
        	for(int i=0; i<=s.length()-len; i++) {
        		//最大下标为s.length()-1
        		int j = i + len -1;
        		if(len == 2 && charArray[i]==charArray[j]) {
        			dp[i][j] = 2;
        			res = s.substring(i,j+1);
        			continue;
        		}
        		if(charArray[i]==charArray[j] && dp[i+1][j-1] != 0) {
        			dp[i][j] = len;
        			res = s.substring(i,j+1);
        		}
        	}
        }
        //考虑没有回文字符串的情况。例ac
        if(res == "" && s.length()>1) {
        	res = s.substring(0, 1);
        }
        return res;
        
    }
    
    
    
    
}
