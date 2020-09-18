/*
 * CS11 Spring 2020, 05/25/2020
 * Team Leader: Mehakpreet Kambo
 * Team Members: Daniel Watts, Emily Yamauchi, and Mehakpreet Kambo.
 * Team Project #2(Chapter 16, Programming Project #3)
 * Created by Mehakpreet Kambo
 * This class tests the functionality of the class AbstractList and shows that
 * it truly is a generic class.
 */
public class ListClient {
	public static void main(String[] args) {
		//Using Integer wrapper class for both ArrayList as well as LinekdList,
		//to show that all the methods work for both list types. 
		System.out.println("Methods implemented using type Integer: \n");
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.println("ArrayList(Integer):");
		processIntList(list);
		System.out.println();
		//********************//
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		System.out.println("LinkedList(Integer): ");
		processIntList(list1);

		//Using String wrapper class for both ArrayList as well as LinekdList,
		//to show that all the methods work for both list types.
		System.out.println("\nMethods implemented using type String: \n");
		ArrayList<String> list2 = new ArrayList<String>();
		System.out.println("ArrayList(String): ");
		processStrList(list2);
		System.out.println();
		//*******************//
		LinkedList<String> list3 = new LinkedList<String>();
		System.out.println("LinkedList(String)");
		processStrList(list3);
	}

	//Implementing methods using Integer wrapper class.
	public static void processIntList(List<Integer> list) {
		list.add(42);
		list.add(18);
		list.add(27);
		list.add(93);
		list.add(30);
		System.out.println("Adding elements using add(value): "+ list);
		list.add(1, 1);
		list.add(4, 4);
		System.out.println("Adding elements using add(index, value) method: "+ list);
		list.remove(5);
		System.out.println("Removing the element(93) at index 5 from the list using remove(index): "+ list);
		int totalElements = list.size();// to get the size.
		System.out.println("Getting the number of elements in the list using size(): "+ totalElements);
		System.out.println("Getting the element at index 3 using get(index): "+ list.get(3));
		System.out.println("Getting the index of the element 30 using indexOf(value): "+ list.indexOf(30));
		System.out.println("Getting the index of the element 1000(not found) using indexOf(value): "
				+ list.indexOf(1000));
		list.set(4, 83);
		System.out.println("Replacing the element(4) at index 4 using set(index, value): "+ list);
		// Instantiated using ArrayList to show that this methods works with ArrayList.
		List<Integer> listImp = new ArrayList<Integer>();
		processAddAll(listImp);
		list.addAll(listImp);
		System.out.println("Implementing the addAll(value) using a new list(ArrayList): "+list);
		System.out.println("Is the list empty(using isEmpty())? "+ list.isEmpty());
		System.out.println("Do we have the element 1 in the list (using contains(value))? "+ list.contains(1));
		System.out.println("Do we have the element 100 in the list (using contains(value))? "+list.contains(100));
		list.clear();
		System.out.println("List after using clear(): "+ list);
		System.out.println("Is list empty now? "+ list.isEmpty());
		System.out.println("*********************************************************************");
	}

	//Implementing methods using String wrapper class.
	public static void processStrList(List<String> list3) {
		list3.add("Hello");
		list3.add("Beautiful");
		list3.add("World");
		list3.add("Computer");
		list3.add("Science");
		System.out.println("Adding elements using add(value): "+ list3);
		list3.add(2, "Amazing");
		list3.add(6, "Engineers");
		System.out.println("Adding elements using add(index, value) method: "+ list3);
		list3.remove(1);
		System.out.println("Removing the element(\"Beautiful\") at index 1 from the list using remove(index): "
				+ list3);
		int totalElements = list3.size(); // to get the size.
		System.out.println("Getting the number of elements in the list using size(): "+ totalElements);
		System.out.println("Getting the element at index 3 using get(index): "+ list3.get(3));
		System.out.println("Getting the index of the element \"Amazing\" using indexOf(value): "
				+ list3.indexOf("Amazing"));
		System.out.println("Getting the index of the element \"COVID-19\"(not found) using indexOf(value): "
				+ list3.indexOf("COVID-19"));
		list3.set(1, "Wonderful");
		System.out.println("Replacing the element(\"Amazing\") at index 1 using set(index, value): "+ list3);
		// Instantiated using LinkedList to show that this methods works with LinkedList.
		List<String> listImp = new LinkedList<String>();
		processAddAllStr(listImp);
		list3.addAll(listImp);
		System.out.println("Implementing the addAll(value) using a new list(LinkedList): "+list3);
		System.out.println("Is the list empty(using isEmpty())? "+ list3.isEmpty());
		System.out.println("Do we have the element \"Hello\" in the list (using contains(value))? "
				+ list3.contains("Hello"));
		System.out.println("Do we have the element \"VIRUS\" in the list (using contains(value))? "
				+list3.contains("VIRUS"));
		list3.clear();
		System.out.println("List after using clear(): "+ list3);
		System.out.println("Is list empty now? "+ list3.isEmpty());
		System.out.println("*********************************************************************");
	}
	//Adding Integer values to new list to 
	// show the correct execution of addAll() method.(Above, instantiated using ArrayList)
	public static void processAddAll(List<Integer> list4) {
		list4.add(99);
		list4.add(99);
		list4.add(99);
		list4.add(99);
	}
	//Adding String values to new list to 
	// show the correct execution of addAll() method.(Above, instantiated using LinkedList)
	public static void processAddAllStr(List<String> list5) {
		list5.add("Stay");
		list5.add("Home!");
		list5.add("Stay");
		list5.add("Safe!");
	}
}
