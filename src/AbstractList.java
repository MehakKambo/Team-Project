/*
 * CS11 Spring 2020, 05/25/2020
 * Team Leader: Mehakpreet Kambo
 * Written by Daniel Watts, Emily Yamauchi, and Mehakpreet Kambo.
 * Team Project #2(Chapter 16, Programming Project #3)
 * This abstract class implements the common behavior List<E> and has subclasses ArrayList, and 
 * LinkedList. This class contains the methods that are factored out so no redundancy occurs in the two 
 * subclasses. The abstract methods in this abstract class are acting  in the interface role. 
 */
import java.util.Iterator;
public abstract class AbstractList<E> implements List<E> {
	//post: returns the current number of elements in the list.
	public abstract int size(); 

	// pre : 0 <= index <= size() (throws IndexOutOfBoundsException if not)
	// post: inserts the given value at the given index, shifting subsequent
	//       values right
	public abstract void add(int index,E value);

	// pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
	// post: removes value at the given index, shifting subsequent values left
	public abstract void remove(int index);

	//post: list is empty.
	public abstract void clear();


	//post: appends the given value to the end of the list
	//     This method is overridden by the ArrayList class.
	public void add(E value) {
		add(size(), value);
	}

	//post: returns the position of the first occurrence of the given.
	public int indexOf(E value) {
		int index = 0;
		for (E item : this) {
			if (item.equals(value)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	// pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
	// post: replaces the value at the given index with the given value
	// This method is overridden by the ArrayList subclass. 
	public void set(int index, E value) {
		checkIndex(index);
		remove(index);
		add(index,value);
	}

	//cannot be abstracted out if kept hidden from user, need private accessor
	private void checkIndex(int index) { 
		if (index < 0 || index >= this.size()) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
	}

	//post: appends all values in the given list to the end of this list
	public void addAll(List<E> other) {
		for (E val : other) {
			this.add(val);
		}
	}

	/*moves any iterator "moves" amount,
       to land on index, 1 move = adv to index 1*/
	private Iterator<E> movedIterator(int moves) {
		Iterator<E> movedIter = this.iterator();
		movedIter.next(); // need to move iterator up, so itr can remove if needed
		for (int i = 0; i < moves; i++) {
			movedIter.next();
		}
		return movedIter;
	}

	// pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
	// post: returns the value at the given index in the list
	public E get(int index) {
		checkIndex(index);
		if (index == 0) { //cannot pass
			Iterator<E> itr = this.iterator();
			return itr.next();
		} else {
			int adjustedIndex = index - 1; // have adjust since return of itr.next points at val AHEAD of index
			Iterator<E> itr = movedIterator(adjustedIndex);
			E val = itr.next();
			return val;
		}
	}

	//post: returns true if the given value is contained in the list,    
	//       false otherwise
	public boolean contains(E value) {
		return indexOf(value)>=0;
	}

	//post: returns true if list is empty, false otherwise
	public boolean isEmpty(){
		return this.size() == 0;
	}

	//post: creates a comma-separated, bracketed version of the list
	public String toString() {
		String repres;
		if (this.size() == 0) {
			return "[]";
		} else {
			Iterator<E> itr = this.iterator();
			repres = "[" + itr.next();
			while (itr.hasNext()) {
				repres += ", " + itr.next();
			}
			repres += "]";
		}
		return repres;
	}
}