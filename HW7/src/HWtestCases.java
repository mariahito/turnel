
import static org.junit.Assert.*;

public class HWtestCases {

	@org.junit.Test
	public void equalsTest() {
		BinaryTreeNode<Integer> node = new BinaryTreeNode<>(5);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(6);
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(5);
		
		BinaryTree<Integer> intTree = new BinaryTree<>(node);
		BinaryTree<Integer> intTree2 = new BinaryTree<>(node2);
		BinaryTree<Integer> intTree3 = new BinaryTree<>(node3);
		
		// Test with null object
		assertEquals(false, intTree.equals(null));
		
		// Test with one object and different values.
		assertEquals(false, intTree.equals(intTree2));
		
		// Test with one object and same values.
		assertEquals(true, intTree.equals(intTree3));
		
		node = new BinaryTreeNode<>(5, node2, null);
		node3 = new BinaryTreeNode<>(5, node2, null);
		
		intTree = new BinaryTree<>(node);
		intTree3 = new BinaryTree<>(node3);
		
		// Test with multiple values
		assertEquals(true, intTree.equals(intTree3));			
	}
	
	@org.junit.Test
	public void deepCopyTest() {
		BinaryTreeNode<Integer> node = new BinaryTreeNode<>(5);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(7);
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(6, node2, node);
		
		BinaryTree<Integer> intTree = new BinaryTree<>();
		BinaryTree<Integer> intTree2 = new BinaryTree<>(node2);
		BinaryTree<Integer> intTree3 = new BinaryTree<>(node3);
		
		BinaryTree<Integer> copied = intTree.deepCopy();
		
		// Test with no values in tree
		assertEquals(null, copied);
		
		copied = intTree2.deepCopy();
		
		// Test with one value.
		assertEquals(true, copied.equals(intTree2));
		
		copied = intTree3.deepCopy();
		
		// Test with more than one values
		assertEquals(true, copied.equals(intTree3));
		
	}
	
	@org.junit.Test
	public void combineTest() {
		BinaryTreeNode<Integer> node = new BinaryTreeNode<>(5);
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(7);
		BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(6, node2, node);
		
		BinaryTree<Integer> intTree = new BinaryTree<>();
		BinaryTree<Integer> intTree2 = new BinaryTree<>(node2);
		BinaryTree<Integer> intTree3 = new BinaryTree<>(node3);
		
		BinaryTree<Integer> combined = intTree.combine(node2, null, false);
		
		// Test with no values in tree
		assertEquals("7", combined.inOrder().trim());
		
		combined = intTree.combine(node2, intTree2, true);
		
		assertEquals("7 7", combined.inOrder().trim());
		
		combined = intTree.combine(node2, intTree3, true);
		
		assertEquals("7 7 6 5", combined.inOrder().trim());	
	}
}
