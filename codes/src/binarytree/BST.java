package binarytree;

public class BST {
    private BinNode root;
    public BST() {
        root = null;
    }
    public void clear() {
        root = null;
    }

    public void insert(Elem val) {
        root = insertHelp(root, val);
    }

    public void remove(int key) {
        root = removeHelp(root, key);
    }

    public Elem find(int key) {
        return findHelp(root, key);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void print() {
        if(root == null) {
            System.out.print("The BST is Empty");
        }else {
            printHelp(root, 0);
            System.out.println(" ");
        }
    }

    private Elem findHelp(BinNode root, int key) {
        if(root == null) {
            return null;
        }else {
            Elem elem = (Elem) root.element();
            if(elem.key() == key) {
                return elem;
            }else if(elem.key() < key){
                return findHelp(root.left(), key);
            }else{
                return findHelp(root.right(), key);
            }
        }
    }

    private BinNode insertHelp(BinNode root, Elem val) {
        if(root == null) {
            return new BinNodePtr(val) ;
        }else{
            Elem elem = (Elem) root.element();
            if(elem.key() <= val.key()) {
                root.setRight(insertHelp(root.right(), val));
            }else {
                root.setLeft(insertHelp(root.left(), val));
            }
            return root;    //将最后新生成的分支传回去
        }
    }

    private Elem getMin(BinNode root) {
        if(root.left() == null) {
            return (Elem) root.element();
        }else {
            return getMin(root.left());
        }
    }

    private BinNode delMin(BinNode root) {
        if(root.left() == null) {
            //这就说明这个root就是min
//            root = root.right();
//            return root;
            // 只需要将原来指向root的指向它的右结点，就被删除了
            return root.right();
        }else {
            root.setLeft(delMin(root.left()));
            return root;
        }
    }

    private BinNode removeHelp(BinNode root, int key) {
        if(root == null) {
            return null;
        }else {
            Elem elem = (Elem) root.element();
            if(key < elem.key()) {
                root.setLeft(removeHelp(root.left(), key));
            }else if(key > elem.key()) {
                root.setRight(removeHelp(root.right(), key));
            }else {     //找到了
                if(root.left() == null) {
                    return root.right();
                }else if(root.right() == null) {
                    return root.left();
                }else {
                    //就是两个孩子都不是空
                    Elem temp = getMin(root.right());   //找那个最小的
                    root.setElement(temp);          //把它变成root
                    root.setRight(delMin(root.right()));    //然后删掉它
                }
            }
            return root;
        }
    }

    private void printHelp(BinNode root, int level){
        if(root == null) {
            return;
        }else {
            printHelp(root.left(), level+1);
            for(int i=0; i<level; i++){
                System.out.println(root.element());
            }
            printHelp(root.right(), level+1);
        }
    }
}
