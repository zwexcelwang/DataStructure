package leetcode;

import java.util.HashMap;

public class Leetcode6_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(convert("LEETCODEISHIRING", 4));
		//System.out.println(reverse(-1230));
		//System.out.println(myAtoi("+1"));
		System.out.println(isPalindrome(-121));
	}

	/**
	 * z字形变换
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert(String s, int numRows) {
		StringBuffer buffer = new StringBuffer();
		HashMap<Integer, Integer> map = new HashMap<>();
		//形状以此为一个循环
		int n = 2 * numRows -2;
		if(n == 0){
			//考虑只有一个字母的情况
			return s;
	    }
		//看字母处在形状的哪个位置
		for(int i=0; i<s.length(); i++) {
			map.put(i, i % n);
			//System.out.println("i:" + i%n);
		}
		for(int i=0; i<numRows; i++) {
			//System.out.println("i:(numRows)" + i);
			if(i==0 || i == numRows-1) {
				for(int j=0; j<s.length(); j++) {
					//System.out.println("j1:(s)" + j);
					if(map.get(j) == i) {
						//System.out.println(s.charAt(j));
						buffer.append(s.charAt(j));
					}
				}
			}else {
				for(int j=0; j<s.length(); j++) {
					//System.out.println("j2:(s)" + j);
					if(map.get(j) == i || map.get(j) == n-i) {
						//System.out.println(s.charAt(j));
						buffer.append(s.charAt(j));
					}
				}
			}   
		}
	return buffer.toString();
	}

	
	/**
	 * 整数反转
	 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]
	 * @param x
	 * @return
	 */
	public static int reverse(int x) {
		int rev = 0;//rev存储反转的数字
        while(x!=0){
            int pop = x % 10;//pop表示弹出的数
            System.out.println(pop);
            //如果已经反转内容rev大于Integr最大值/10,那么一定溢出；
            // 如果最rev反转内容等于最大值/10且最后一位pop的数字大于7，那么就从正数这边溢出了
            //另外一种就是从负数那边溢出了
            if((rev>Integer.MAX_VALUE/10||(rev==Integer.MAX_VALUE/10&&pop>7))
                    ||rev<Integer.MIN_VALUE/10||(rev==Integer.MIN_VALUE/10&&pop<-8)){
                return 0;
            }
            rev=rev*10 + pop;//把pop防到rev后面
            System.out.println(rev);
            x/=10;//去掉已经pop的内容
        }
        return rev;
    }
	
	/**
	 * INT 的 MAX_VALUE为：2147483647
	 * @param str
	 * @return
	 */
	public static int myAtoi(String str) {
		str  = str.trim();
        char[] array = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        if(str.isEmpty()) {
        	return 0;
        }
        int i = 0; 
        if(array[i] == '-' || array[i] == '+') {
        	sb.append(array[i]);
        	i++;
        }
        //第一个字符不是数字，无法进行有效的转换
        if(i<array.length && !Character.isDigit(array[i])) {
        	return 0;
        }
        while(i<array.length) {
        	if(Character.isDigit(array[i])) {
        		 sb.append(array[i]);  
        	}else {
        		break;
        	}
        	i++;
        }
        String string = sb.toString();
        System.out.println(string);
        if(string == null || string.equals("-") || string.equals("+")) {
        	return 0;
        }else {
        	try {
        		//溢出的时候：例如91283472332，输出MAX_VALUE:2147483647
        		if(sb.substring(0, 1).equals("+")) {
        			return Integer.valueOf(string.substring(1, string.length()));
        		}else {
        			return Integer.valueOf(string);
        		}
    		}catch (Exception e) {
    			if(sb.substring(0, 1).equals("-")) {
    				return Integer.MIN_VALUE;
    			}else {
    				return Integer.MAX_VALUE;
    			}
    		}	
        }
	}
		
	/**
	 * 判断一个数字是否是回文数
	 * 即从左往右和从右往左读出的都是一样的
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome(int x) {
		String string = Integer.toString(x);
		int i = 0;
		if(string.length() == 1) {
			return true;
		}
		while(i<string.length()) {
			if(string.charAt(i) != string.charAt(string.length()-i-1)) {
				return false;
			}
			i++;
		}
		return true;
    }


	
	/**
	 * 自己实现正则表达式匹配
	 * 据说用的是回溯法，但是我没分析出来，卑微.jpg
	 * 这明明用的递归（小声bb)
	 * 正则里  * 可以匹配0个或多个前面的那个字符
	 *  . 可以匹配任意单个字符
	 * @param text
	 * @param pattern
	 * @return
	 */
	public static boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) {
        	return text.isEmpty();
        }
        //text不为空并且第一个字符和正则能配上
        boolean first_match = (!text.isEmpty() &&
                              (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
        	//就当正则前面的*配的是0个那个字符
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
            //第二行匹配类似abb和a*
        } else {
        	//放在第二个的不是*，没有那么多乱七八糟的事
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

}