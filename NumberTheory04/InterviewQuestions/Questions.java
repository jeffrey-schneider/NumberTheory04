package InterviewQuestions;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.lang.model.element.Element;

public class Questions {
	private static final DecimalFormat df = new DecimalFormat("#.00");	static int denomination[] = { 500000, 100000, 50000, 10000, 5000, 2000, 1000, 500, 100, 25, 10, 5, 1};
	
	public static void makeChange(double v) {
		double summation = 0.0;
		int d = (int) (v * 100);	
		
		Vector<Integer> ans = new Vector<>();
		for(int i = 0; i < denomination.length; i++) {
			while(d>= denomination[i]) {
				ans.add(denomination[i]);
				d -= denomination[i];				
			}			
		}
		
		double buffer = 0.0;
		
		System.out.printf("\nTo make change for %.2f\n", v);
		System.out.println("Bill/Coin\tSummary");
		for(int i=0; i<ans.size(); i++) {
			buffer = ans.elementAt(i)/100.0;
			summation += buffer;
			//System.out.println(buffer + " " + df.format(summation));
			System.out.printf("%,9.2f \t %,.2f\n", buffer, summation);
		}
		
		
		
		
	}
	
	
	}
	

