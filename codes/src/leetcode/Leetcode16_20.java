package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;



public class Leetcode16_20 {
	public static void main(String[] args) {
		//int[] nums = {-3,-2,-5,3,-4};
		//System.out.println(threeSumClosest(nums, -1));
		//int[] nums = {-3,-2,-1,0,0,1,2,3};
//		int[] nums = {0, 0, 0, 0};
//		System.out.println(fourSum(nums, 0));
		String string = "[";
		System.out.println(isValid(string));
	
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
	
	/**
	 * 四数之和，类似三数之和，直接在外面多加一层循坏
	 * @param nums
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if(nums.length < 4) {
			return result;
		}
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++) {
        	if (i > 0 && nums[i] == nums[i - 1]) continue;
        	for(int j=i+1; j<nums.length-2; j++) {
        		if (j > i+1 && nums[j] == nums[j - 1]) continue;
        		int k = j+1;
        		int m = nums.length-1;
        		while(k < m) {
        			if(nums[i] + nums[j] + nums[k] + nums[m] == target) {
        				List<Integer> list = new ArrayList<>();
        				list.add(nums[i]);
        				list.add(nums[j]);
        				list.add(nums[k]);
        				list.add(nums[m]);
        				result.add(list);
        				while(k < m && nums[k] == nums[k+1]) k++;
        				while(k < m && nums[m] == nums[m-1]) m--;
        				k++;
        				m--;
        			}else if(nums[i] + nums[j] + nums[k] + nums[m] < target) {
        				k++;
        			}else {
        				m--;
        			}
        		}	
        	}
        }
        return result;
    }
	
	
	/**
	 * 删除链表的倒数第n个结点
	 * 设置两个结点，p和q，先让p走n步，然后p和q一起走，当p走到最后的时候，q就是倒数第n个
	 * @param head
	 * @param n
	 * @return
	 */
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pListNode = head;
        ListNode qListNode = head;
        int i;
        for(i=0; i<n; i++) {
        	pListNode = pListNode.next;
        	if(pListNode == null){
                break;
            }
        }
        if(i == n-1 && pListNode == null) {
        	//pListNode移到null说明移出了链表
        	return head.next;
        }
        if(i < n-1 && pListNode == null) {
        	//pListNode移到null说明移出了链表
        	//[1] 1 这种情况
         	return head;
        }
        while(pListNode.next != null) {
        	pListNode = pListNode.next;
        	qListNode = qListNode.next;
        }
        qListNode.next = qListNode.next.next;
        return head;
    }
	
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	
	/**
	 * 有效的括号，配对字符串（）{} []这种，看括号的对应是否正确
	 * 我jio得可以用栈和map
	 * @param s
	 * @return
	 */
	public static boolean isValid(String s) {
       Stack<Character> stack = new Stack<>();
       HashMap<Character, Character> map = new HashMap<Character, Character>(); 
       map.put('(', ')');
       map.put('[', ']');
       map.put('{', '}');
       char[] chars = s.toCharArray();
       for(int i =0;i<chars.length; i++){
           if(map.containsKey(chars[i])){
        	   stack.push(chars[i]);
           }else{
        	   //如果没有左括号，那么栈为空
        	   //如果不是对应的左括号，pop()!=chars[i]
               if(stack.isEmpty() || map.get(stack.pop()) != chars[i]){
            	   return false;
               } 
           }          
       }
       if(!stack.isEmpty()) {
    	   return false;
       }else {
    	   return true;
       }
   }
}
