package basedefine;

public class SinglyLinkedNode {
	public int data;
	public SinglyLinkedNode next;

	public SinglyLinkedNode(int data) {
		this.data = data;
		next = null;
	}

	public SinglyLinkedNode(int data, SinglyLinkedNode next) {
		this.data = data;
		this.next = next;
	}
}
