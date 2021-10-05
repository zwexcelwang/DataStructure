package list;

public class Link {
	private Object element;
	private Link next;
	public Link(Object item, Link nextval){
		element = item;
		next = nextval;
	}
	public Link(Link nextval){
		next = nextval;
	}
	public Link next() {
		return next;
	}
	public Link setNext(Link nextval) {
		return next = nextval;
	}
	public Object element() {
		return element;
	}
	Object setElement(Object item) {
		return element = item;
	}
}
