package queue;

import list.Link;

public class LinkQueue {
	private Link front;
	private Link rear;
	
	public LinkQueue() {
		// TODO Auto-generated constructor stub
		setup();
	}
	
	public LinkQueue(int sz) {
		// TODO Auto-generated constructor stub
		setup();
	}
	 
	private void setup() {
		front = null;
		rear = null;
	}
	
	public void clear() {
		front = null;
		rear = null;
	}
	
	public void enqueue(Object item) {
		if(rear != null) {
			rear.setNext(new Link(item, null));
			rear = rear.next();
		}else {
			//考虑空队列的情况
			front = rear = new Link(item, null);
		}
	}
	
	public Object dequeue() {
		if(isEmpty()) {
			System.out.println("Empty queue");
		}else {
			Object item = front.element();
			front = front.next();
			if(front == null) {
				rear = null;
			}
			return item;
		}
		return null;
	}
	
	public boolean isEmpty() {
		return front == null;
	}
}
