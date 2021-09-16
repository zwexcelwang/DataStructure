package leetcode;


import java.util.HashMap;
import java.util.Map;

public class LeetcodeExer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache lruCache  = new LRUCache(3);
		lruCache.put(1,1);
		System.out.println("content" + lruCache.content);
		System.out.println("lru" + lruCache.lru);
		lruCache.put(2,2);
		System.out.println("content" + lruCache.content);
		System.out.println("lru" + lruCache.lru);
		lruCache.put(3,3);
		System.out.println("content" + lruCache.content);
		System.out.println("lru" + lruCache.lru);
		lruCache.put(4,4);
		System.out.println("content" + lruCache.content);
		System.out.println("lru" + lruCache.lru);
	}


	static class LRUCache {
		Map<Integer, Integer> lru;
		Map<Integer, Integer> content;
		int time;
		public LRUCache(int capacity) {
			lru = new HashMap<>();
			content = new HashMap<>();
			time = capacity;
		}

		public int get(int key) {
			int res = content.getOrDefault(key, -1);
			if(res != -1) {
				for(Map.Entry<Integer, Integer> entry : lru.entrySet()){
					if(key != entry.getKey()) {
						lru.put(entry.getKey(), entry.getValue()-1);
					}else {
						lru.put(entry.getKey(), time);
					}
				}
			}
			return res;
		}

		public void put(int key, int value) {
			int res = content.getOrDefault(key, -1);
			if(res!= -1){
				for(Map.Entry<Integer, Integer> entry : lru.entrySet()){
					lru.put(entry.getKey(), entry.getValue()-1);
				}
			}else if(content.size() == time) {
				int min = time;
				int minKey = 0;
				for(Map.Entry<Integer, Integer> entry : lru.entrySet()){
					if(entry.getValue() <= min) {
						min = entry.getValue();
						minKey = entry.getKey();
					}
					lru.put(entry.getKey(), entry.getValue()-1);
				}
				content.remove(minKey);
				lru.remove(minKey);
			}
			content.put(key, value);
			lru.put(key, time);
		}
	}

	/**
	 * Your LRUCache object will be instantiated and called as such:
	 * LRUCache obj = new LRUCache(capacity);
	 * int param_1 = obj.get(key);
	 * obj.put(key,value);
	 */



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
