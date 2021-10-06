package stack;

import list.Link;

/**
 * 链式栈
 */
public class LinkStack {

	//指向栈顶第一个结点的指针
	private Link top;
	public LinkStack() {
		// TODO Auto-generated constructor stub
		setup();
	}
	
	public LinkStack(int sz) {
		// TODO Auto-generated constructor stub
		setup();
	}
	 
	private void setup() {
		top = null;
	}
	
	public void clear() {
		top = null;
	}
	
	public void push(Object item) {
		// 这个新加入的节点的next指向原来的top， 然后自己变成top
		top = new Link(item, top);
	}
	
	public Object pop() {
		if(isEmpty()) {
			System.out.print("Empty Stack");
			return null;
		}else {
			Object item = top.element();
			top = top.next();
			return item;
		}

	}
	
	public Object topValue() {
		if(isEmpty()) {
			System.out.print("No top value");
		}else {
			return top.element();
		}
		return null;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}
