package stack;


public class SeqStack {
	
	private static final int defaultSize = 10;
	private int size;
	private int top;
	private Object[] listArray;
	
	public SeqStack() {
		// TODO Auto-generated constructor stub
		setup(defaultSize);
	}
	
	public SeqStack(int sz) {
		setup(sz);
	}

	private void setup(int sz) {
		size = sz;
		top = 0;
		listArray = new Object[sz];
	}
	
	public void clear() {
		top = 0;
	}
	
	public void push(Object item) {
		if(top >= size) {
			System.out.print("Stack overflow");
		}else {
			listArray[top] = item;
			top++;
		}
	}
	
	public Object pop() {
		if(isEmpty()) {
			System.out.print("Empty Stack");
		}else {
			top--;
			return listArray[top];
		}
		return null;
	}
	
	public Object topValue() {
		if(isEmpty()) {
			System.out.print("Empty Stack");
		}else {
			return listArray[top-1];
		}
		return null;
	}
	
	public boolean isEmpty() {
		return top == 0;
	}
	
}
