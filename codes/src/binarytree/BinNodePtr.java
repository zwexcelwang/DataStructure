package binarytree;


/**
 * 二叉树
 * @author zui
 *
 */
public class BinNodePtr implements BinNode{
	
	private Object element;	//Object for this node
	private BinNode left;	//Pointer to left child
	private BinNode right;	//Pointer to right child
	
	//Constructor1
	public BinNodePtr() {
		// TODO Auto-generated constructor stub
		left = right = null;
	}
	
	//Constructor2
	public BinNodePtr(Object val) {
		left = right = null;
		element = val;
	}
	
	//Constructor3
	public BinNodePtr(Object val, BinNode l, BinNode r) {
		left = l;
		right = r;
		element = val;
	}
	
	//Return and set the element value
	@Override
	public Object element() {
		// TODO Auto-generated method stub
		return element;
	}

	@Override
	public Object setElement(Object item) {
		// TODO Auto-generated method stub
		element = item;
		return element;
	}

	
	//return and set left child
	@Override
	public BinNode left() {
		// TODO Auto-generated method stub
		return left;
	}
	@Override
	public BinNode setLeft(BinNode binNode) {
		// TODO Auto-generated method stub
		left = binNode;
		return left;
	}

	//return and set right child
	@Override
	public BinNode right() {
		// TODO Auto-generated method stub
		return right;
	}
	@Override
	public BinNode setRight(BinNode binNode) {
		// TODO Auto-generated method stub
		right = binNode;
		return right;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return (left == null) && (right == null);
	}

}
