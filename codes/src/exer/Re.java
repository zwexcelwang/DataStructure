package exer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.sun.javafx.collections.MappingChange.Map;


public class Re {

	public static void main(String[] args) {
		//int ans = testSet("abcabcbb");
		//System.out.println("abcabcbb".charAt(0));
		String string = "{}";

		System.out.println(isValid(string));
		
	}
	
	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<Character, Character>(); 
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        
        char[] chars = s.toCharArray();
        for(int i =0;i<chars.length; i++){
            if(chars[i] == '(' || chars[i] == '[' || chars[i] == '{'){
            	System.out.println("1");
                stack.push(chars[i]);
            }else{
                if(map.get(stack.pop()) != chars[i]){
                	System.out.println("3");
                    return false;
                }
            }
        }
        return true;
    }
	
	public static int testSet(String s) {
		int n = s.length();
        int res = 0;
        int end=0,start=0;
        Set<Character> set = new HashSet<>();
        while(start<n && end<n){
           if(set.contains(s.charAt(end))){
               set.remove(s.charAt(start++));
           }else{
        	   System.out.println("end" + end);
               set.add(s.charAt(end++));
               System.out.println("start" + start);
               System.out.println(end-start);
               res=Math.max(res,end-start);
               System.out.println("res" + res);
               
           }    
        }
        return res;
    
	}
}
