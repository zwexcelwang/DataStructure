package list;

public class DLink {
    private Object element;
    private DLink prev;
    private DLink next;
    public DLink(Object item, DLink n, DLink p){
        element = item;
        next = n;
        prev = p;
    }
    public DLink(DLink n, DLink p){
        next = n;
        prev = p;
    }
    public DLink next() {
        return next;
    }
    public DLink prev() {
        return prev;
    }
    public DLink setNext(DLink nextval) {
        return next = nextval;
    }
    public DLink setPrev(DLink prevval) {
        return prev = prevval;
    }
    public Object element() {
        return element;
    }
    Object setElement(Object item) {
        return element = item;
    }
}
