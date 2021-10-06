package binarytree;

public class MaxHeap {
	private Elem[] Heap;	//pointer to the heap array
	private int size;	//maximum size of the heap
	private int n;		//number of elements now in heap
	
	public MaxHeap(Elem[] h, int num, int max) {
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

	public int leftChild(int pos) {
		if(pos >= n/2) {
			System.out.println("Position has no left child");
			return Integer.MAX_VALUE;
		}else {
			return 2*pos + 1;
		}
	}

	public int rightChild(int pos) {
		if(pos >= (n-1)/2) {
			System.out.println("Position has no right child");
			return Integer.MAX_VALUE;
		}else {
			return 2*pos + 2;
		}
	}

	public int parent(int pos) {
		if(pos<=0) {
			System.out.println("Position has no parent");
			return Integer.MAX_VALUE;
		}else{
			return (pos-1)/2;
		}
	}

	public void buildHeap() {
		for(int i = n/2-1; i>=0; i--) {
			siftDown(i);
		}
	}

	private void siftDown(int pos){
		if(pos<0 || pos >=n) {
			System.out.println("Illegal heap position");
		}else {
			while(!isLeaf(pos)) {
				int j = leftChild(pos);
				if((j <(n-1)) && Heap[j].key() < Heap[j+1].key()) {
					j++;
				}
				if(Heap[pos].key() >= Heap[j].key()) {
					return;
				}
//				DSutil.swap(Heap, pos, j);
				swap(Heap, pos, j);
				pos = j;
			}
		}
	}
	private void swap(Elem[] Heap, int pos, int j){

	}

	public void insert(Elem val) {
		if(n >= size) {
			System.out.println("Heap is full");
			int curr = n++;
			Heap[curr] = val;
			while( curr!= 0 && Heap[curr].key() > Heap[parent(curr)].key()) {
//				DSutil.swap(Heap, curr, parent(curr));
				swap(Heap, curr, parent(curr));
				curr = parent(curr);
			}
		}
	}

	public Elem removeMax(){
		if(n <= 0){
			System.out.println("Removing from empty heap");
			return null;
		}else {
//				DSutil.swap(Heap, 0, --n);
			swap(Heap, 0, --n);
			if(n != 0) {
				siftDown(0);
			}
			return Heap[n];
		}
	}

	public Elem remove(int pos) {
		if(pos <= 0 || pos >=n){
			System.out.println("Illeagal heap position");
			return null;
		}else {
			//				DSutil.swap(Heap, pos, --n);
			swap(Heap, pos, --n);
			if(n != 0) {
				siftDown(pos);
			}
			return Heap[n];
		}
	}

}
