package binarytree;

/**
 * 分支结点
 * @author zui
 *
 */
public class IntlNode implements BinNode{
	private Character opx;	//Operator value
	private BinNode left;	//Pointer to left child
	private BinNode right;	//Pointer to right child
	
	public IntlNode(Character op, BinNode l, BinNode r) {
		// TODO Auto-generated constructor stub
		opx = op;
		left = l;
		right = r;
	}
	@Override
	public Object element() {
		// TODO Auto-generated method stub
		return opx;
	}

	@Override
	public Object setElement(Object item) {
		// TODO Auto-generated method stub
		opx = (Character)item;
		return opx;
	}

	@Override
	public BinNode left() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BinNode setLeft(BinNode binNode) {
		// TODO Auto-generated method stub
		left = binNode;
		return left;
	}

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
		return false;
	}

}
