package binarytree;

import java.util.*;

import basedefine.SinglyLinkedNode;
import basedefine.TreeNode;

public class BinaryTree {

	TreeNode root, root1;

	BinaryTree() {
		root = null;
	}

	void levelOrder(TreeNode n) {
		if (n == null) {
			return;
		} else {
//			int h = height(n);
//			for (int i = 0; i <= h; i++) {
//				printLevelOrder(n, i);
//			}

			Queue<TreeNode> q = new LinkedList<>();
			q.add(n);

			while (!q.isEmpty()) {
				TreeNode temp = q.poll();

				System.out.print(temp.data + " ");

				if (temp.left != null)
					q.add(temp.left);

				if (temp.right != null)
					q.add(temp.right);
			}
		}
	}

	int height(TreeNode n) {
		if (n == null) {
			return 0;
		} else {
			int lh = height(n.left);
			int rh = height(n.right);
			return (1 + Math.max(lh, rh));
		}

	}

	void printLevelOrder(TreeNode n, int h) {
		if (n == null) {
			return;
		} else if (h == 1) {
			System.out.print(n.data + " ");
		} else if (h > 1) {
			printLevelOrder(n.left, h - 1);
			printLevelOrder(n.right, h - 1);
		}
	}

	void inOrder(TreeNode n) {
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
			Stack<TreeNode> s = new Stack<>();
			TreeNode curr = n;

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

	void preOrder(TreeNode n) {
		if (n == null) {
			return;
		} else {
			System.out.print(n.data + " ");
			preOrder(n.left);
			preOrder(n.right);
		}
	}

	void postOrder(TreeNode n) {
		if (n == null) {
			return;
		} else {
			postOrder(n.left);
			postOrder(n.right);
			System.out.print(n.data + " ");
		}
	}

	int diameter(TreeNode n) {
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

	int width(TreeNode n, int level) {
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

	int maxWidth(TreeNode n) {
		int mw = 0, w, h = height(n);

		for (int i = 1; i <= h; i++) {
			w = width(n, i);
			mw = w > mw ? w : mw;
		}
		return mw;
	}

	void printDistance(TreeNode n, int d) {
		if (n == null || d < 0) {
			return;
		} else if (d == 0) {
			System.out.print(n.data + " ");
		} else {
			printDistance(n.left, d - 1);
			printDistance(n.right, d - 1);
		}
	}

	boolean printAncestors(TreeNode n, int target) {
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

	boolean isSubTree(TreeNode main, TreeNode sub) {
		if (sub == null) {
			return true;
		} else if (main == null) {
			return false;
		} else if (areIdentical(main, sub)) {
			return true;
		} else {
			return isSubTree(main.left, sub) || isSubTree(main.right, sub);
		}
	}

	boolean areIdentical(TreeNode main, TreeNode sub) {
		if (main == null && sub == null) {
			return true;
		} else if (main == null || sub == null) {
			return false;
		} else {
			return main.data == sub.data && areIdentical(main.left, sub.left) && areIdentical(main.right, sub.right);
		}
	}

	int numBST(int n) {
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] += dp[i - j] * dp[j - 1];
			}
		}
		return dp[n];
	}

	List<TreeNode> constructTree(int start, int end) {
		List<TreeNode> result = new ArrayList<>();

		if (start > end) {
			result.add(null);
			return result;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> leftSubTrees = constructTree(start, i - 1);
			List<TreeNode> rightSubTrees = constructTree(i + 1, end);
			for (TreeNode leftSub : leftSubTrees) {
				for (TreeNode rightSub : rightSubTrees) {
					TreeNode n = new TreeNode(i);
					n.left = leftSub;
					n.right = rightSub;
					result.add(n);
				}
			}
		}
		return result;
	}

	TreeNode ArrayToBST(int[] arr) {
		return ConstructArrayToBST(arr, 0, arr.length - 1);
	}

	TreeNode ConstructArrayToBST(int[] arr, int start, int end) {
		if (start > end) {
			return null;
		} else {
			int mid = start + end >> 1;
			TreeNode tree = new TreeNode(arr[mid]);
			tree.left = ConstructArrayToBST(arr, start, mid - 1);
			tree.right = ConstructArrayToBST(arr, mid + 1, end);
			return tree;
		}
	}

	SinglyLinkedNode curr;

	TreeNode LinkedListToBST(SinglyLinkedNode head) {
		int count = 0;
		curr = head;
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		curr = head;
		return ConstructListToBST(1, count);
	}

	TreeNode ConstructListToBST(int start, int end) {
		if (start > end) {
			return null;
		} else {
			int mid = start + end >> 1;
			TreeNode tree = new TreeNode();
			tree.left = ConstructListToBST(start, mid - 1);
			tree.data = curr.data;
			curr = curr.next;
			tree.right = ConstructListToBST(mid + 1, end);
			return tree;
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
//
//		tree.root1 = new TreeNode(2);
//		tree.root1.left = new TreeNode(4);
//		tree.root1.right = new TreeNode(5);
//
//		System.out.println("BFS:");
//		tree.levelOrder(tree.root);
//
//		System.out.println("\n\nDFSs");
//		System.out.println("IN-ORDER:");
//		tree.inOrder(tree.root);
//
//		System.out.println("\nPRE-ORDER:");
//		tree.preOrder(tree.root);
//
//		System.out.println("\nPOST-ORDER:");
//		tree.postOrder(tree.root);
//
//		System.out.println("\n\nTree Diameter: " + tree.diameter(tree.root) + ", Height: " + tree.height(tree.root)
//				+ ", MaxWidth: " + tree.maxWidth(tree.root));
//
//		System.out.println("\nPrint at 2 Distance:");
//		tree.printDistance(tree.root, 2);
//
//		System.out.println("\n\nAncestors of 4: ");
//		tree.printAncestors(tree.root, 4);
//
//		System.out.println("\n\nT2 is sub of T1? " + tree.isSubTree(tree.root, tree.root1));
//
//		System.out.println("\n\nNum of BST of 3: " + tree.numBST(3));
//
//		System.out.println("\n\nConstruct BST from 1 to 3:" + tree.constructTree(1, 3));

//		tree.preOrder(tree.ArrayToBST(new int[] { -2, -1, 0, 1, 2, 3 }));
	}

}
