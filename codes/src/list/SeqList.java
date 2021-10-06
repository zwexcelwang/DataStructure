package list;

/**
 * 数组实现线性表,顺序表
 */
public class SeqList implements IList{
	
	private static final int defaultSize = 100;    //所能包含默认值
	private int msize;	//所能包含的个数
	private int numInList;	//实际元素个数
	private int curr;	//记录当前元素位置
	private Object[] listArray;		//包含元素的数组
	
	public SeqList() {
		// TODO Auto-generated constructor stub
		setup(defaultSize);
	}
	
	public SeqList(int size) {
		setup(size);
	}
	
	private void setup(int size) {
		msize = size;
		numInList = 0;
		listArray = new Object[size];
	}
	
	
 	@Override
	public void clear() {
		// TODO Auto-generated method stub
		numInList = 0;
		curr = 0;
	}

	@Override
	public void insert(Object item) {
		// TODO Auto-generated method stub
		if(numInList >= msize) {
			System.out.print("List is full");
		}else if(curr<0 || curr>numInList){
			System.out.print("Bad value for curr");
		}else {
			for(int i=numInList; i>curr; i--) {
				listArray[i] = listArray[i-1];
			}
			listArray[curr] = item;
			numInList++;
		}
	}

	@Override
	public void append(Object item) {
		// TODO Auto-generated method stub
		if(numInList >= msize) {
			System.out.print("List is full");
		}else {
			listArray[numInList] = item;
			numInList++;
		}
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		// remove and return current Object
		if(isEmpty()) {
			System.out.print("Can not delete from empty list");
		}else if(!isInList()) {
			System.out.print("No current element");
		}else {
			Object item = listArray[curr];
			for(int i=curr; i<numInList-1; i++) {
				listArray[i] = listArray[i+1];
			}
			numInList--;
			return item;
		}
		return null;
	}

	@Override
	public void setFirst() {
		// TODO Auto-generated method stub
		curr = 0;
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		curr++;
	}

	@Override
	public void prev() {
		// TODO Auto-generated method stub
		curr--;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return numInList;
	}

	@Override
	public void setPos(int pos) {
		// TODO Auto-generated method stub
		curr = pos;
	}

	@Override
	public void setValue(Object val) {
		// TODO Auto-generated method stub
		if(!isInList()) {
			System.out.print("No current element");
		}else {
			listArray[curr] = val;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numInList == 0;
	}

	@Override
	public boolean isInList() {
		// TODO Auto-generated method stub
		// the curr is within list
		if(curr>=0 && curr<numInList) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.print("()");
		}else {
			System.out.print("(");
			// for(初值；boolean；变化）
			for(setFirst(); isInList(); next()) {
				System.out.print(currValue() + " ");
			}
			System.out.print(")");
		}
	}
	
	public Object currValue() {
		if(!isInList()) {
			System.out.print("No current element");
		}else {
			return listArray[curr];
		}
		return null;
	}

}
