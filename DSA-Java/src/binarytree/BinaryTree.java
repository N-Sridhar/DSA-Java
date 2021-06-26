package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
			/**
			 * Recursion Method.
			 */
//			inOrder(n.left);
//			System.out.print(n.data + " ");
//			inOrder(n.right);

			/**
			 * Without Recursion.
			 */
			Stack<Node> s = new Stack<>();
			Node curr = n;

			while (curr != null || s.size() > 0) {
				while (curr != null) {
					s.push(curr);
					curr = curr.left;
				}

				curr = s.pop();
				System.out.print(curr.data + " ");
				curr = curr.right;
			}
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

	int diameter(Node n) {
		if (n == null) {
			return 0;
		} else {
			int lh = height(n.left);
			int rh = height(n.right);

			int ld = diameter(n.left);
			int rd = diameter(n.right);

			return Math.max(lh + rh + 1, Math.max(ld, rd));
		}
	}

	int width(Node n, int level) {
		if (n == null) {
			return 0;
		} else if (level == 1) {
			return 1;
		} else if (level > 1) {
			return width(n.left, level - 1) + width(n.right, level - 1);
		} else {
			return 0;
		}
	}

	int maxWidth(Node n) {
		int mw = 0;
		int w;
		int h = height(n);

		for (int i = 1; i <= h; i++) {
			w = width(n, i);
			mw = w > mw ? w : mw;
		}
		return mw;
	}

	void printDistance(Node n, int d) {
		if (n == null || d < 0) {
			return;
		} else if (d == 0) {
			System.out.print(n.data + " ");
		} else {
			printDistance(n.left, d - 1);
			printDistance(n.right, d - 1);
		}
	}

	boolean printAncestors(Node n, int target) {
		if (n == null) {
			return false;
		} else if (n.data == target) {
			return true;
		} else if (printAncestors(n.left, target) || printAncestors(n.right, target)) {
			System.out.print(n.data + " ");
			return true;
		} else {
			return false;
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

		System.out.println("\n\nTree Diameter: " + tree.diameter(tree.root) + ", Height: " + tree.height(tree.root)
				+ ", MaxWidth: " + tree.maxWidth(tree.root));

		System.out.println("\nPrint at 2 Distance:");
		tree.printDistance(tree.root, 2);

		System.out.println("\n\nAncestors of 4: ");
		tree.printAncestors(tree.root, 4);
	}

}
