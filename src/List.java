/*
 * CS11 Spring 2020, 05/25/2020
 * Team Leader: Mehakpreet Kambo
 * Team Members: Daniels Watts, Emily Yamauchi, and Mehakpreet Kambo
 * Team Project #2(Chapter 16, Programming Project #3)
 * This interface is used for the completion of this project.
 * Generic interface for a List of E objects.
 */
public interface List<E> extends Iterable<E> {
	public int size();
	public E get(int index);
	public int indexOf(E value);
	public boolean isEmpty();
	public boolean contains(E value);
	public void add(E value);
	public void add(int index, E value);
	public void addAll(List<E> other);
	public void remove(int index);
	public void set(int index, E value);
	public void clear();
}
