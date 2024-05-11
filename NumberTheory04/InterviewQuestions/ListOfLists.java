package InterviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class ListOfLists {
	public static void main(String[] args) {
		List<List<Integer>> listOfLists = new ArrayList<>();
		
		//Adding elements to outer list
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(4);
		list2.add(5);
		
		List<Integer> list3 = new ArrayList<>();
		list3.add(6);
		
		for(int i = 7; i <= 20; i++) {
			(i % 2 == 0? list2: list3).add(i);
		}
		
		//Adding inner lists to the outer list
		listOfLists.add(list1);
		listOfLists.add(list2);
		listOfLists.add(list3);
		
		//Accessing elements of the List of Lists
		for (List<Integer> list : listOfLists) {
			for (Integer integer : list) {
				System.out.print(integer + " ");
			}
			System.out.println();
		}
	}
}
