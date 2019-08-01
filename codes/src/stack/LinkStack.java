package stack;

import list.Link;

public class LinkStack {

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
		top = new Link(item, top);
	}
	
	public Object pop() {
		if(isEmpty()) {
			System.out.print("Empty Stack");
		}else {
			Object item = top.element();
			top = top.next();
			return item;
		}
		return null;
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
