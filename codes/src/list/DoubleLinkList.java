package list;

public class DoubleLinkList implements IList{

    private DLink head;
    private DLink tail;
    protected DLink curr;

    public DoubleLinkList() {
        // TODO Auto-generated constructor stub
        setup();
    }

    public DoubleLinkList(int size) {
        // TODO Auto-generated constructor stub
        setup();
    }
    private void setup() {
        tail = head = curr = new DLink(null);
    }

    @Override
    public void clear() {
        head.setNext(null);
        curr = tail = head;
    }

    @Override
    public void insert(Object item) {
        if(curr == null) {
            System.out.print("No current element");
        }else {
            curr.setNext(new DLink(item, curr.next(), curr));
            if(curr.next().next()!= null){
                //如果等于null，说明新插入的这个后面是null，那它就不需要设置前驱节点
                curr.next().next().setPrev(curr.next());
            }
            if(tail == curr) {
                //如果是在表尾插入一个，那么tail往后
                tail = curr.next();
            }
        }
    }

    @Override
    public void append(Object item) {
        tail.setNext(new DLink(item, null, tail));
        tail = tail.next();
    }

    @Override
    public Object remove() {
        if(!isInList()) {
            return null;
        }else {
            //删的是curr.next()
            Object item = curr.next().element();
            if(curr.next().next() != null) {
                curr.next().next().setPrev(curr);
            }else {
                tail = curr;
            }
            curr.setNext(curr.next().next());
            return item;
        }
    }

    @Override
    public void setFirst() {
        curr = head;
    }

    @Override
    public void next() {
        if(curr != null) {
            curr = curr.next();
        }
    }

    @Override
    public void prev() {
        if(curr!=null) {
            curr = curr.prev();
        }
    }

    @Override
    public int length() {
        int count = 0;
        //head不存数据，不算
        for(DLink temp = head.next(); temp != null; temp = temp.next()) {
            count++;
        }
        return count;
    }

    @Override
    public void setPos(int pos) {
        curr = head;
        for(int i=0; (curr != null) && (i<pos); i++) {
            curr = curr.next();
        }
    }

    @Override
    public void setValue(Object val) {
        if(!isInList()) {
            curr.next().setElement(val);
        }
    }

    @Override
    public Object currValue() {
        if(!isInList()) {
            return null;
        }
        return curr.next().element();
    }

    @Override
    public boolean isEmpty() {
        //head只是个指针，不存数据的那种
        return head.next() == null;
    }

    @Override
    public boolean isInList() {
        return (curr != null) && (curr.next() != null);
    }

    @Override
    public void print() {

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
}
