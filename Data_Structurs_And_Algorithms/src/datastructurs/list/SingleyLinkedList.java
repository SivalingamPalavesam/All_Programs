package datastructurs.list;

public class SingleyLinkedList {
	private static ListNode head;

	private static class ListNode {
		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public int length() {
		if (head == null) {
			return 0;
		}

		int count = 0;
		ListNode current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public void display(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println("null");

	}

	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode;
	}

	public void insertLast(int value) {
		ListNode newNode = new ListNode(value);
		if (head == null) {
			head = newNode;
			return;
		}
		ListNode current = head;
		while (null != current.next) {
			current = current.next;
		}
		current.next = newNode;
	}

	public ListNode deleteFirst() {
		if (head == null) {
			return null;
		}
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		return temp;
	}

	public ListNode deleteLast() {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode current = head;
		ListNode previous = null;
		while (null != current.next) {
			previous = current;
			current = current.next;

		}
		previous.next = null;
		return current;
	}

	public boolean findValue(ListNode head,int searchKey)
	{
		ListNode current = head;
		while(current != null)
		{

			if(current.data == searchKey)
			{
				return true;
			}
			current = current.next;
		}
		return false;
	}

	public ListNode reverse(ListNode head)
	{
		if(head == null)
		{
			return head;
		}

		ListNode current =head;
		ListNode previous =null;
		ListNode next = null;

		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;

	}
	public static void main(String[] args) {
		SingleyLinkedList obj = new SingleyLinkedList();
		System.out.println("Insert head index value");
		// obj.insertFirst(5);
		// obj.insertFirst(8);
		// obj.insertFirst(4);
		// obj.insertFirst(3);
		// obj.insertFirst(2);
		// obj.display();

		System.out.println("Insert Last index value");
		obj.insertLast(5);
		obj.insertLast(8);
		obj.insertLast(4);
		obj.insertLast(3);
		obj.insertLast(2);
		obj.display(head);

		/*
		 * System.out.println("Delete first value");
		 * System.out.println(obj.deleteFirst().data);
		 * System.out.println(obj.deleteFirst().data); //
		 * System.out.println(obj.deleteFirst().data); obj.display();
		 * 
		 * System.out.println("Delete Last value");
		 * System.out.println(obj.deleteLast().data);
		 * System.out.println(obj.deleteLast().data); //
		 * System.out.println(obj.deleteLast().data); obj.display();
		 */
		
		/*
		 * if(obj.findValue(head, 11)) { System.out.println("Search key found!!!"); }
		 * else { System.out.println("Search Key not found !!!"); }
		 */
		
		ListNode reverseOrder = obj.reverse(head);

		obj.display(reverseOrder);

		


	}
}
