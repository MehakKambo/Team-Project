/*
 * CS11 Spring 2020, 05/25/2020
 * Team Leader: Mehakpreet Kambo
 * Modified by Daniel Watts, Emily Yamauchi, and Mehakpreet Kambo.
 * Team Project #2(Chapter 16, Programming Project #3)
 * Methods factored out from this class into the AbstractList class are get(index), indexOf(value),
 * isEmpty(), contains(value), add(value), addAll(List<E> other), set(index, value). 
 * Class LinkedList<E> can be used to store a list of values of type E.
 */
import java.util.*;
public class LinkedList<E> extends AbstractList<E> {
	private ListNode<E> front;  // first value in the list
	private ListNode<E> back;   // last value in the list
	private int size;           // current number of elements

	// post: constructs an empty list
	public LinkedList() {
		front = new ListNode<E>(null);
		back = new ListNode<E>(null);
		clear();
	}

	// post: returns the current number of elements in the list
	public int size() {
		return size;
	}

	// pre: 0 <= index <= size() (throws IndexOutOfBoundsException if not)
	// post: inserts the given value at the given index, shifting subsequent
	//       values right
	public void add(int index, E value) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}

		ListNode<E> current = nodeAt(index - 1);
		ListNode<E> newNode = new ListNode<E>(value, current.next, current);
		current.next = newNode;
		newNode.next.prev = newNode;
		size++;
	}

	// pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
	// post: removes value at the given index, shifting subsequent values left
	public void remove(int index) {
		checkIndex(index);
		ListNode<E> current = nodeAt(index - 1);
		current.next = current.next.next;
		current.next.prev = current;
		size--;
	}

	// post: list is empty
	public void clear() {
		front.next = back;
		back.prev = front;
		size = 0;
	}

	// post: returns an iterator for this list
	public Iterator<E> iterator() {
		return new LinkedIterator();
	}

	// pre : 0 <= index < size()
	// post: returns the node at a specific index.  Uses the fact that the list
	//       is doubly-linked to start from the front or the back, whichever
	//       is closer.
	private ListNode<E> nodeAt(int index) {
		ListNode<E> current;
		if (index < size / 2) {
			current = front;
			for (int i = 0; i < index + 1; i++) {
				current = current.next;
			}
		} else {
			current = back;
			for (int i = size; i >= index + 1; i--) {
				current = current.prev;
			}
		}
		return current;
	}

	// post: throws an IndexOutOfBoundsException if the given index is
	//       not a legal index of the current list
	private void checkIndex(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
	}

	private static class ListNode<E> {
		public E data;         // data stored in this node
		public ListNode<E> next;  // link to next node in the list
		public ListNode<E> prev;  // link to previous node in the list

		// post: constructs a node with given data and given links
		public ListNode(E data, ListNode<E> next, ListNode<E> prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

		// post: constructs a node with given data and null links
		public ListNode(E data) {
			this(data, null, null);
		}
	}

	private class LinkedIterator implements Iterator<E> {
		private ListNode<E> current;  // location of next value to return
		private boolean removeOK;  // whether it's okay to remove now

		// post: constructs an iterator for the given list
		public LinkedIterator() {
			current = front.next;
			removeOK = false;
		}

		// post: returns true if there are more elements left, false otherwise
		public boolean hasNext() {
			return current != back;
		}

		// pre : hasNext()
		// post: returns the next element in the iteration
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E result = current.data;
			current = current.next;
			removeOK = true;
			return result;
		}

		// pre : next() has been called without a call on remove (i.e., at most
		//       one call per call on next)
		// post: removes the last element returned by the iterator
		public void remove() {
			if (!removeOK) {
				throw new IllegalStateException();
			}
			ListNode<E> prev2 = current.prev.prev;
			prev2.next = current;
			current.prev = prev2;
			size--;
			removeOK = false;
		}
	}
}
