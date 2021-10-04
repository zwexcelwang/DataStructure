package tree;

public class MaxHelp {
	private Elem[] Heap;	//pointer to the heap array
	private int size;	//maximum size of the heap
	private int n;		//number of elements now in heap
	
	public MaxHelp(Elem[] h, int num, int max) {
		// TODO Auto-generated constructor stub
		Heap = h;
		n = num;
		size = max;
	}
	
	public int heapsize() { //return current size of the heap
		return n;
	}
	
	public boolean isLeaf(int pos) {
		return (pos >= n/2) && (pos < n);
	}
	
	
	

}
