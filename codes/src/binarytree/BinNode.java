package binarytree;

//ADT for binary tree nodes
public interface BinNode {
	//return and set the element value
	public Object element();
	public Object setElement(Object item);
	
	//return and set left child
	public BinNode left();
	public BinNode setLeft(BinNode binNode);
	
	//return and set right child
	public BinNode right();
	public BinNode setRight(BinNode binNode);
	
	//Return true if this is a leaf node
	public boolean isLeaf();
	
}
