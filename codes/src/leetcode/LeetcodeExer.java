package exer;


public class LeetcodeExer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(strStr("hello","ll"));
		//countAndSay(10);
		//System.out.print(nextCount("111223"));
		System.out.println(divide(-2147483648, 1));
	}
	
	
	//System.out.println(strStr("hello","ll"));
	    public static int strStr(String haystack, String needle) {
	        char[] haystacks = haystack.toCharArray();
	        char[] needles = needle.toCharArray();   
	        for(int i=0; i<=haystacks.length-needles.length; i++){
	            if(haystacks[i] == needles[0]){
	                int num = 1;
	                for(int j=1; j<needles.length; j++){
	                    if(haystacks[i+j] == needles[j]){
	                        num++;
	                    }
	                }
	                if(num == needles.length){
	                    return i;
	                }
	            }
	        }
	        return -1;
	    }



	public static void countAndSay(int n) {
		String result = "1";
		for(int i=0; i<n; i++) {
			System.out.println(result);
			//System.out.println(i);
			result = nextCount(result);
		}
	}
	private static String nextCount(String count) {
		StringBuffer buffer = new StringBuffer();
		int length = count.length();
		char pre = ' ';
		char now;
		int i = 0;
		int num = 0;
		while(true) {
			if(pre == ' ') {
				pre = count.charAt(i);
				num++;
			}else {
				now = count.charAt(i);
				if(now == pre) {
					num++;
				}else {
					buffer.append(num);
					buffer.append(pre);
					pre = now;
					num = 1;
				}
			}
			i++;
			if(i == length) {
				buffer.append(num);
				buffer.append(pre);
				break;
			}	
		}
		return buffer.toString();
	}
	
	
	public static int divide(int dividend, int divisor) {
    	long divd = Math.abs((long)dividend);
    	long disr = Math.abs((long)divisor);
    	System.out.println(divd);
    	System.out.println(disr);
        if(divd < disr) {
        	System.out.println("000");
        	return 0;
        }else {
        	int n = 0;
        	while(divd >= disr) {
        		n++;
        		divd = divd - disr;
        	}
        	if(dividend * divisor < 0) {
        		return -n;
        	}else {
        		return n;
        	}
        }
    }
	
	
	
	
	
	
	
	
}
