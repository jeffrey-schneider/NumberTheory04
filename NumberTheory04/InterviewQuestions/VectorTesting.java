package InterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorTesting {
	//ArrayLists are not thread-safe

	public static void main(String[] args) {
		int size = 1_000_000;
		
		List<Integer> arrayList = new ArrayList<>();
		long start = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			arrayList.add(i);
		}
		long end = System.currentTimeMillis();
		System.out.println("Added " + size + " elements to ArrayList: " +
				(end - start) + " ms");
	
	
		List<Integer> vector = new Vector<>();	
		start = System.currentTimeMillis();
		for (int i = 0; i < size; i++) {
			vector.add(i);
		}
		end = System.currentTimeMillis();
		System.out.println("Added " + size + " elements to Vector: " +
				(end - start) + " ms");
		
		
		
		//Lets try the above multi-threaded style.
		//  Not thread safe:
		//     List<Integer> multithreadedList = new ArrayList<>();
		//  Collections.synchronizedList() is a wrapper that makes ArrayLists threadsafe.
		//
		List<Integer> multithreadedList = Collections.synchronizedList(new ArrayList<>());
		start = System.currentTimeMillis();
		Thread t1 = new Thread(()-> {		
			for (int i = 0; i < size; i++) {
				multithreadedList.add(i);
			}
		});
		Thread t2 = new Thread(()-> {		
			for (int i = 0; i < size; i++) {
				multithreadedList.add(i);
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		end = System.currentTimeMillis();
		System.out.println("Added " + size + " elements to ArrayList: " +
				(end - start) + " ms");
		
		
		List<Integer> multithreadedVector = new Vector<>();
				start = System.currentTimeMillis();
				t1 = new Thread(()-> {		
					for (int i = 0; i < size; i++) {
						multithreadedVector.add(i);
					}
				});
				t2 = new Thread(()-> {		
					for (int i = 0; i < size; i++) {
						multithreadedVector.add(i);
					}
				});
				t1.start();
				t2.start();
				try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					t2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				end = System.currentTimeMillis();
				System.out.println("Added " + size + " elements to Vector: " +
						(end - start) + " ms");	
				
				System.out.println(multithreadedList.size());
				System.out.println(multithreadedVector.size());
	}
	
	
	
}
