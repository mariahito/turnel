import java.util.Stack;

public class BinaryTreeNode<T> {

    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;
    private T data;

    public BinaryTreeNode(){
        this(null,null,null);
    }

    public BinaryTreeNode(T theData){
        this(theData,null,null);
    }

    public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){
        data = theData;
        left = leftChild;
        right = rightChild;
    }

    public int size(){
        int size = 0; //the size of the tree

        //The size of the tree rooted at this node is one more than the
        //sum of the sizes of its children.
        if(left != null){
            size = size + left.size();
        }
        if(right != null){
            size = size + right.size();
        }
        return size + 1; //add one to account for the current node
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public BinaryTreeNode<T> deepCopy(){
        BinaryTreeNode<T> copy = new BinaryTreeNode<T>(this.data);
        BinaryTreeNode<T> newLeft = null;
        BinaryTreeNode<T> newRight = null;
        if (this.left != null) {
            newLeft = this.left.deepCopy();
            copy.setLeft(newLeft);
        }
        if (this.right != null) {
            newRight = this.right.deepCopy();
            copy.setRight(newRight);
        }
        return copy;
    }

    @Override
    public boolean equals(Object o){
        if (o == null || !(o instanceof BinaryTreeNode)) {
            return false;
        }
        BinaryTreeNode<T> b = (BinaryTreeNode<T>) o;
        return data.equals(b.data)
                && left.equals(b.getLeft())
                && right.equals(b.getRight());
    }

    public int height() {

        if (this == null)
            return 0;
        else
        {
            int leftHeight = this.left.height();
            int rightHeight = this.right.height();

            /* use the larger one */
            if (leftHeight > rightHeight)
                return (leftHeight + 1);
            else
                return (rightHeight + 1);
        }
    }

    public boolean full(){

        if(this.left == null && this.right == null )
            return true;

        if((this.left!=null) && (this.right!=null))

            // Checks if its complete binary tree and all the leave nodes are at same level
            return this.left.full() && this.right.full()
                    && (this.left.height() == this.right.height());

        return false;
    }

    public BinaryTreeNode<T> mirror(){
        return mirror(this);
    }

    private BinaryTreeNode<T> mirror(BinaryTreeNode<T> node)
    {
        if (node == null)
            return node;

        BinaryTreeNode<T> left = mirror(node.left);
        BinaryTreeNode<T> right = mirror(node.right);

        node.right = left;
        node.left = right;

        return node;
    }

    public String inOrder() {

        BinaryTreeNode<T> root = this;
        String result = "";
        if(root == null)
            return result;
        Stack<BinaryTreeNode<T>> stack = new Stack<BinaryTreeNode<T>>();
        stack.push(root);

        while(!stack.isEmpty()){
            BinaryTreeNode<T> top = stack.peek();
            if(top.getLeft() != null){
                stack.push(top.getLeft());
                top.setLeft(null);
            }else{
                result += top.getData();
                stack.pop();
                if(top.getRight()!=null){
                    stack.push(top.getRight());
                }
            }
        }

        return result;
    }

}
