package list;


/**
 * 数组实现线性表
 */
public class ArrayList implements IList{

    private static final int defaultSize = 100;     //所能包含默认值

    private int msize;   //所能包含实际值
    private int numInList;   //实际元素个数
    private int curr;   //记录当前元素位置
    private Object[] listArray;

    public ArrayList(){
        setup(defaultSize);
    }

    public ArrayList(int sz){
        setup(sz);
    }
    private void setup(int sz) {
        msize = sz;
        numInList = curr = 0;
        listArray = new Object[sz];
    }

    @Override
    public void clear() {
        numInList = curr = 0;
    }

    @Override
    public void insert(Object item) {
        if(numInList >= msize) {
            System.out.println("List is full");
        }
        if(curr < 0 || curr>numInList) {
            System.out.println("Bad value for curr");
        }
        for(int i=numInList; i>curr; i--){
            listArray[i] = listArray[i-1];
        }
        listArray[curr] = item;
        numInList++;
    }

    @Override
    public void append(Object item) {
        if(numInList >= msize) {
            System.out.println("List is full");
        }
        listArray[numInList++] = item;
    }

    @Override
    public Object remove() {
        if(isEmpty()) {
            System.out.println("Can not delete from empty list");
        }
        if(!isInList()) {
            System.out.println("No current element");
        }
        Object item = listArray[curr];
        for(int i=curr; i< numInList-1; i++) {
            listArray[i] = listArray[i+1];
        }
        numInList--;
        return item;
    }

    @Override
    public void setFirst() {
        curr=0;
    }

    @Override
    public void next() {
        curr++;
    }

    @Override
    public void prev() {
        curr--;
    }

    @Override
    public int length() {
        return numInList;
    }

    @Override
    public void setPos(int pos) {
        curr = pos;
    }

    @Override
    public void setValue(Object val) {
        if(!isInList()) {
            System.out.println("No current element");
        }
        listArray[curr] = val;
    }

    @Override
    public Object currValue() {
        if(!isInList()) {
            System.out.println("No current element");
        }
        return listArray[curr];
    }

    @Override
    public boolean isEmpty() {
        return numInList==0;
    }

    @Override
    public boolean isInList() {
        return (curr>=0) && (curr<numInList);
    }

    @Override
    public void print() {
        if(isEmpty()) {
            System.out.println("()");
        }else {
            System.out.println("(");
            // for(初值；boolean；变化）
            for(setFirst(); isInList(); next()) {
                System.out.println(currValue() + " ");
            }
            System.out.println(")");
        }
    }
}
