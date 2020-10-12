package com.abhishek.algorithms.davincicode.adt.list.linkedlist;

import com.abhishek.algorithms.davincicode.nodes.linkedlist.singly.SinglyNode;

public class SinglyLinkedList<T> {
	private SinglyNode<T> head;
	private int size;

	public SinglyLinkedList() {
		this.head = null;
		this.size = 0;
	}

	public SinglyLinkedList(T data) {
		this.head = new SinglyNode<T>(data);
		this.size = 0;
	}

	public T addStart(T data) {
		SinglyNode<T> newSinglyNode = new SinglyNode<T>(data);
		newSinglyNode.setNext(this.head);
		this.head = newSinglyNode;
		this.size++;
		return data;
	}

	public T addEnd(T data) {
		SinglyNode<T> newSinglyNode = new SinglyNode<T>(data);
		SinglyNode<T> temp = this.head;
		if (temp == null) {
			this.head = newSinglyNode;
		} else {
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(newSinglyNode);
		}
		this.size++;
		return data;
	}

	public T deleteFromStart() {
		SinglyNode<T> deleted = this.head;
		if (deleted == null)
			return null;
		this.head = this.head.getNext();
		this.size--;
		return deleted.getData();
	}

	public T deleteFromEnd() {
		SinglyNode<T> deleted = this.head;
		if (deleted == null)
			return null;
		else if (this.size == 1) {
			this.size--;
			this.head = null;
			return deleted.getData();
		}
		SinglyNode<T> temp = deleted;
		deleted = deleted.getNext();
		while (deleted != null) {
			temp = deleted;
			deleted = deleted.getNext();
		}
		temp.setNext(null);
		this.size--;
		return temp.getData();
	}

	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		SinglyNode<T> singlyNode = this.head;
		String str = "";
		while (singlyNode != null) {
			str += singlyNode.getData() + "->";
			singlyNode = singlyNode.getNext();
		}
		return str;
	}

	public SinglyNode<T> getHead() {
		return head;
	}

	public void setHead(SinglyNode<T> head) {
		this.head = head;
	}
}
