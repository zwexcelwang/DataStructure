package queue;

/**
 * 顺序队列
 */
public class SeqQueue {
	private static final int defaultSize = 10;
	private int size;
	private int front;	//表示队首元素的前驱
	private int rear;	//表示队尾
	private Object[] listArray;
	
	public SeqQueue() {
		// TODO Auto-generated constructor stub
		setup(defaultSize);
	}
	
	public SeqQueue(int sz) {
		// TODO Auto-generated constructor stub
		setup(sz);
	}
	
	private void setup(int sz) {
		size = sz+1;	//避免队满和队空不好区分
		front = 0;
		rear = 0;
		listArray = new Object[sz+1];
	}
	
	public void clear() {
		front = 0;
		rear = 0;
	}
	
	public void enqueue(Object item) {
		//rear后面那个是front就表示队满
		if(((rear+1) % size) == front) {
			System.out.print("Queue is full");
		}else {
			rear = (rear+1) % size;
			listArray[rear] = item;
		}
	}
	
	public Object dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is full");
		}else {
			//front 表示队首元素的前驱位置
			front = (front+1) % size;
			return listArray[front];
		}
		return null;
	}
	
	public Object firstValue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
		}else {
			return listArray[(front+1) % size];
		}
		return null;
	}
	
	public boolean isEmpty() {
		return front == rear;
	}
}
