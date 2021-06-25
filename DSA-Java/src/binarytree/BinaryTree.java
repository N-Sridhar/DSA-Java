package binarytree;

import java.util.LinkedList;
import java.util.Queue;

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

	void levelOrder(Node n) {
		if (n == null) {
			return;
		} else {
//			int h = height(n);
//			for (int i = 0; i <= h; i++) {
//				printLevelOrder(n, i);
//			}

			Queue<Node> q = new LinkedList<>();
			q.add(n);

			while (!q.isEmpty()) {
				Node temp = q.poll();

				System.out.print(temp.data + " ");

				if (temp.left != null)
					q.add(temp.left);

				if (temp.right != null)
					q.add(temp.right);
			}
		}
	}

	int height(Node n) {
		if (n == null) {
			return 0;
		} else {
			int lh = height(n.left);
			int rh = height(n.right);
			return (1 + Math.max(lh, rh));
		}

	}

	void printLevelOrder(Node n, int h) {
		if (n == null) {
			return;
		} else if (h == 1) {
			System.out.print(n.data + " ");
		} else if (h > 1) {
			printLevelOrder(n.left, h - 1);
			printLevelOrder(n.right, h - 1);
		}
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

		System.out.println("BFS:");
		tree.levelOrder(tree.root);

		System.out.println("\n\nDFSs");
		System.out.println("IN-ORDER:");
		tree.inOrder(tree.root);

		System.out.println("\nPRE-ORDER:");
		tree.preOrder(tree.root);

		System.out.println("\nPOST-ORDER:");
		tree.postOrder(tree.root);
	}

}
