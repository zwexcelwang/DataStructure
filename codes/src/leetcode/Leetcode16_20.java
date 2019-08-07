package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;
import com.sun.org.apache.regexp.internal.recompile;


public class Leetcode16_20 {
	public static void main(String[] args) {
		int[] nums = {-3,-2,-5,3,-4};
		System.out.println(threeSumClosest(nums, -1));
	}
	
	/**
	 * 最接近的三数之和
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int threeSumClosest(int[] nums, int target) {
		//因为用MAX_VALUE在执行时，使用abs函数会出错，so把它减1
        int result = Integer.MAX_VALUE-1;
        Arrays.sort(nums);
        int sum;
        for (int i = 0; i < nums.length; i++) {
            int j = nums.length - 1;
            int k = i + 1;
//            System.out.println(i);
            while (k < j) {           
            	sum = nums[i] + nums[j] + nums[k];
//            	System.out.println("sum:" + sum);
//            	System.out.println("Math.abs(result-target):" + Math.abs(result-target));
//            	System.out.println("Math.abs(sum-target):" + Math.abs(sum-target));
            	result = Math.abs(result-target)<Math.abs(sum-target)?  result : sum;
//            	System.out.println("re:" + result);
            	if(sum < target) {
            		k++;
            	}else if(sum == target){
            		return target;
            	}else {
            		j--;
            	}
            }
        }
        return result;
    }
	
	/**
	 * 电话号码中的字母组合
	 * 递归
	 * @param digits
	 * @return
	 */
	public List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<>();
		if(digits.length()==0) {
			return list;
		}
       HashMap<String, String> map = new HashMap<>(); 
	   map.put("2", "abc");
	   map.put("3", "def");
	   map.put("4", "ghi");
	   map.put("5", "jkl");
	   map.put("6", "mno");
	   map.put("7", "pqrs");
	   map.put("8", "tuv");
	   map.put("9", "wxyz");
	   
	   List<String> list1=letterCombinations(digits.substring(1, digits.length()));
	   char[] chars = map.get(digits.charAt(0)).toCharArray();
	   if(list1.size() == 0) {
		   for (char c : chars) {
			   StringBuffer buffer = new StringBuffer();
			   buffer.append(c);
			   list.add(buffer.toString());
		   }
	   }else {
		   for (char c : chars) {
			   for (String string : list1) {
				   StringBuffer buffer = new StringBuffer();
				   buffer.append(c);
				   buffer.append(string);
				   list.add(buffer.toString());
			   }
		   }
	   }
	   return list;

	}
	
}
