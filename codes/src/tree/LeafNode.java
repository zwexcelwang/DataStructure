package tree;

/**
 * 叶子结点
 * @author zui
 *
 */
public class LeafNode implements BinNode{

	private String var;	//Operand value
	public LeafNode(String val) {
		// TODO Auto-generated constructor stub
		var = val;
	}
	@Override
	public Object element() {
		// TODO Auto-generated method stub
		return var;
	}

	@Override
	public Object setElement(Object item) {
		// TODO Auto-generated method stub
		var = (String)item;
		return var;
	}

	@Override
	public BinNode left() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BinNode setLeft(BinNode binNode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BinNode right() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BinNode setRight(BinNode binNode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return true;
	}

}
