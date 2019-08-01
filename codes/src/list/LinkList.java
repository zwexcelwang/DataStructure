package list;

public class LinkList implements IList{

	private Link head;
	private Link tail;
	protected Link curr;
	
	public LinkList() {
		// TODO Auto-generated constructor stub
		setup();
	}
	
	public LinkList(int size) {
		// TODO Auto-generated constructor stub
		setup();
	}
	
	private void setup() {
		tail = head = curr = new Link(null);
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head.setNext(null);
		curr = tail = head;
	}

	@Override
	public void insert(Object item) {
		// TODO Auto-generated method stub
		if(curr == null) {
			System.out.print("No current element");
		}else {
			curr.setNext(new Link(item, curr.next()));
			if(tail == curr) {
				tail = curr.next();
			}
		}
	}

	@Override
	public void append(Object item) {
		// TODO Auto-generated method stub
		tail.setNext(new Link(item, null));
		tail = tail.next();
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		if(!isInList()) {
			return null;
		}else {
			Object item = curr.next().element();
			if(tail == curr.next()) {
				tail = curr;
			}			
			curr.setNext(curr.next().next());
			return item;
		}
	}

	@Override
	public void setFirst() {
		// TODO Auto-generated method stub
		curr = head;
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		if(curr != null) {
			curr = curr.next();
		}
	}

	@Override
	public void prev() {
		// TODO Auto-generated method stub
		if(curr == null || curr == head) {
			//表为空或者已在表头
			curr = null;
			return;
		}
		Link temp = head;
		while(temp != null && temp.next() != curr) {
			temp = temp.next();
		}
		curr = temp; 
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		int count = 0;
		for(Link temp = head.next(); temp != null; temp = temp.next()) {
			count++;
		}
		return count;
	}

	@Override
	public void setPos(int pos) {
		// TODO Auto-generated method stub
		curr = head;
		for(int i=0; (curr != null) && (i<pos); i++) {
			curr = curr.next();
		}
	}

	@Override
	public void setValue(Object val) {
		// TODO Auto-generated method stub
		if(!isInList()) {
			curr.next().setElement(val);
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head.next() == null;
	}

	@Override
	public boolean isInList() {
		// TODO Auto-generated method stub
		return (curr != null) && (curr.next() != null);
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.print("()");
		}else {
			System.out.print("(");
			for(setFirst(); isInList(); next()) {
				System.out.print(currValue() + " ");
			}
			System.out.print(")");
		}
	}

	@Override
	public Object currValue() {
		// TODO Auto-generated method stub
		if(!isInList()) {
			return null;
		}
		return curr.next().element();
	}
	
}
