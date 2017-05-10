
public class BinaryTree<T> {

	private BinaryTreeNode<T> root;

	public BinaryTree() {
		this(null);
	}

	public BinaryTree(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}

	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	@Override
	public boolean equals(Object o) {
		boolean retVal = false;
		if (o instanceof BinaryTree<?>) {
			BinaryTree<?> tree = (BinaryTree<?>)o;
			retVal = this.root.equals(tree.root);
		}
		return retVal;
	}

	public BinaryTree<T> deepCopy() {
		if(root == null) {
			return null;
		}
		BinaryTreeNode<T> copiedRoot = root.deepCopy();
		return new BinaryTree<T>(copiedRoot);
	}

	public BinaryTree<T> combine(BinaryTreeNode<T> newRoot, BinaryTree<T> t,boolean left) {
		T data;
		BinaryTreeNode<T> otherRoot;

		if(newRoot == null) {
			data = null;
		} 
		else 
			data = newRoot.getData();

		if(t == null) {
			otherRoot = null;
		} 
		else 
			otherRoot = t.getRoot();

		if (left) {
			// Creating binary tree node with new roots data, root and given trees root
			BinaryTreeNode<T> node = new BinaryTreeNode<T>(data, root, otherRoot);
			return new BinaryTree<T>(node);
		}
		else {
			// Creating binary tree node with new roots data, given trees root and root
			BinaryTreeNode<T> node = new BinaryTreeNode<T>(data, otherRoot, root);
			return new BinaryTree<T>(node);
		}
	}

	public int size(){
		// Size of root
		return size(root);
	}

	public int size(BinaryTreeNode<T> r){
		if (r == null)
			return 0;
		else
		{
			int l = 1;
			l += size(r.getLeft());
			l += size(r.getRight());
			return l;
		}
	}

	public int height(){
		return root.height();
	}

	public boolean full(){
		return root.full();
	}

	public void mirror(){
		if(this.root == null){
			return;
		}
		this.root.mirror();
	}

	public String inOrder(){
		if(this.root == null)
			return"()";
		return root.inOrder();
	}
}

