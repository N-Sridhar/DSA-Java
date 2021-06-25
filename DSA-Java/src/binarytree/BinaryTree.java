package binarytree;

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BinaryTree {

	Node root;

	BinaryTree() {
		root = null;
	}

	void inOrder(Node n) {
		if (n == null) {
			return;
		} else {
			inOrder(n.left);
			System.out.print(n.data + " ");
			inOrder(n.right);
		}
	}

	void preOrder(Node n) {
		if (n == null) {
			return;
		} else {
			System.out.print(n.data + " ");
			preOrder(n.left);
			preOrder(n.right);
		}
	}

	void postOrder(Node n) {
		if (n == null) {
			return;
		} else {
			postOrder(n.left);
			postOrder(n.right);
			System.out.print(n.data + " ");
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		System.out.println("IN-ORDER:");
		tree.inOrder(tree.root);

		System.out.println("\nPRE-ORDER:");
		tree.preOrder(tree.root);

		System.out.println("\nPOST-ORDER:");
		tree.postOrder(tree.root);
	}

}
