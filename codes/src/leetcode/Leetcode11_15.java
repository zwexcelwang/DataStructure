package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Leetcode11_15 {
	
	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(height));
	}

	/**
	 * 盛最多水的容器
	 * @param height
	 * @return
	 */
	public static int maxArea(int[] height) {
		int maxArea = 0;
        for(int i = 0; i<height.length-1; i++) {
        	System.out.println(i);
        	for(int j = i+1; j<height.length; j++) {
        		System.out.println(j);
            	int len = height[i]>height[j]? height[j] : height[i];
            	int area = len * (j-i);
            	maxArea = Math.max(maxArea, area);
        	}

        }
        return maxArea;
    }
	
	/**
	 * 双指针办法
	 * @param height
	 * @return
	 */
	 public int maxArea2(int[] height) {
        int maxarea = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
            	 l++;
            } 
            else {
            	r--;
            }
         
        }
        return maxarea;
	}
	 
	 /**
	  * 整数转罗马字符
	  * @param num
	  * @return
	  */
	 public static String intToRoman(int num) {
        int values[]=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String strs[]=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        String str="";
        //从最大的开始算。
        for(int i=0; i<13; i++){
            //>=的意思就是使用多个values[i]
            //比如3999，要有3个1000。
            /*
            while(num>=values[i]){
                num -= values[i];
                str += strs[i];
            }
            */
            //这里还有一种方法，就是去用num/values[i]
            //这样就可以循环加上这个strs[i]
            if(num == 0) {
            	  break;
            }
            int times = num/values[i];
            if(times == 0) {
            	continue;
            }       
            for(int t=0;t<times;t++) {
                str+=strs[i];
            }
            num=num-(times * values[i]);
        }
        return str;
    }
	 
	 /**
	  * 罗马数字转整数
	  * @param s
	  * @return
	  */
	 public static int romanToInt(String s) {
        if (s == null || s.length() == 0)    return -1;
 
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        int result = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; i--) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1)))
                result += map.get(s.charAt(i));
            else
                result -= map.get(s.charAt(i));
        }
        return result;
      }

	 /**
	  * 最长公共前缀
	  * @param strs
	  * @return
	  */
	 public String longestCommonPrefix(String[] strs) {
	        if(strs.length == 0) 
	            return "";
	        //做参照
	        String ans = strs[0];
	        for(int i=1; i<strs.length;i++) {
	            int j=0;
	            for(;j<ans.length() && j < strs[i].length();j++) {
	                if(ans.charAt(j) != strs[i].charAt(j))
	                    break;
	            }
	            //已经找到的前缀，就不用再用第一个当参照了
	            ans = ans.substring(0, j);
	            if(ans.equals(""))
	                return ans;
	        }
	        return ans;
	    }
	 
	 
	 /**
	  * 三数之和
	  * @param nums
	  * @return
	  */
	 public List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> result = new ArrayList<>();
	        //排序，为了避免重复
	        Arrays.sort(nums);
	        for (int i = 0; i < nums.length; i++) {
	        	//只有正数必然是不可以的，i是三个数里最小的
	            if (nums[i] > 0) break;
	            //往后挪动到重复的最后一个
	            if (i > 0 && nums[i] == nums[i - 1]) continue;
	            //j从最后开始
	            int j = nums.length - 1;
	            int target = 0 - nums[i];
	            int k = i + 1;
	            while (k < j) {
	                if (nums[k] + nums[j] == target) {
	                	//找到了一组结果
	                    List<Integer> item = Arrays.asList(nums[i], nums[k], nums[j]);
	                    result.add(item);
	                    //移动到下一个数字不一样的地方，找不同的
	                    while (k < j && nums[k] == nums[k + 1]) k++;
	                    while (k < j && nums[j] == nums[j - 1]) j--;
	                    //这两步是因为找到跟下一个不同的地方，但是指针还没有挪过去，so进行此操作
	                    k++;
	                    j--;
	                } else if (nums[k] + nums[j] < target) {
	                    k++;	//说明k太小
	                } else {
	                    j--;	//说明j太大
	                }
	            }
	        }
	        return result;
	 }
}
