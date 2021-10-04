package leetcode;

import java.util.PriorityQueue;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

import leetcode.Leetcode16_20.ListNode;

public class Leetcode21_25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	
	/**
	 * 合并两个有序链表，迭代
	 * 还可以用递归
	 * @param l1
	 * @param l2
	 * @return
	 */
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 	ListNode head;
	        ListNode newListNode;
	        if(l1 == null) {
	        	return l2;
	        }else if(l2 == null) {
	        	return l1;
	        }else {
	        	if(l1.val < l2.val) {
	        		head = l1;
	        		l1 = l1.next;
	        	}else {
	        		head = l2;
	        		l2 = l2.next;
	        	}
	        	newListNode = head;
	        	while(l1 != null && l2 != null){
	        		if(l1.val < l2.val) {
	        			newListNode.next = l1;
	        			l1 = l1.next ;
	        		}else {
	        			newListNode.next = l2;
	        			l2 = l2.next;
	        		}
	        		newListNode = newListNode.next;		        
		        }
	        	if(l1 == null) {
	        		newListNode.next = l2;
	        	}else {
	        		newListNode.next = l1;
	        	}
	        }          
	        return head;        
	  }
	 
	 /**
	  * 两两交换链表的节点
	  * 递归解法，递归是爸爸
	  * @param head
	  * @return
	  */
	 public ListNode swapPairs(ListNode head) {
		 if(head == null || head.next == null) {
			 return head;
		 }
		 ListNode temp = head.next;
		 head.next = swapPairs(temp.next);
		 temp.next = head;
		 return temp;
	 }
	    
	    /**
	     * 合并K个有序链表
	     * 优先队列解法 PriorityQueue在new时如果不传参，就按自然顺序对元素进行排序
	     * 先把元素都弄进优先队列，就是排好序的，然后再都读出来就完事
	     * @param lists
	     * @return
	     */
	    public ListNode mergeKLists2(ListNode[] lists) {
	        if(lists == null){
	           return null;
	       }
	        PriorityQueue<Integer> queue = new PriorityQueue();
	        for(ListNode node:lists){
	            while(node != null){
	                queue.add(node.val);
	                node = node.next;
	            }
	        }
	        ListNode res = new ListNode(0);
	        ListNode tmp= res;
	        while(!queue.isEmpty()){
	            ListNode temp = new ListNode(queue.poll());
	            tmp.next = temp;
	            tmp = tmp.next;
	        }
	        return res.next;
	    }
	 
	    private ListNode merge(ListNode l1, ListNode l2){
			ListNode res = new ListNode(0);
			ListNode tail = res;
			while(l1 != null && l2 != null){
				if(l1.val < l2.val){
					tail.next = l1;
					l1 = l1.next;
				}else {
					tail.next = l2;
					l2 = l2.next;
				}
				tail = tail.next;
			}
			if(l1 != null){
				tail.next = l1;
			}else{
				tail.next = l2;
			}
			return res.next;
		}
	    
		// 原地归并，并不申请新的数组空间，算法实现上，其实是找规律。
		public ListNode mergeKLists(ListNode[] lists) {
			// 步长为 2 时，和后面的第 1 个合并
			// 步长为 4 时，和后面的第 2 个合并
			// ...
			if(lists == null){
				return null;
			}
			int len = lists.length;
			int interval = 1;
			while(interval < len){
				for(int i = 0; i+interval < len; i += 2*interval){
					lists[i] = merge(lists[i], lists[i + interval]);
				}
				interval *= 2;
			}
			return len != 0 ? lists[0] : null;
		}

}
