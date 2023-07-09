package numberTheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SieveOfEratosthenes {

	public static long sieveOfEratosthenesArray(int n)
	{
		long beginTime = System.nanoTime();
		boolean prime[] = new boolean[n + 1];
		for (int i = 0; i <= n; i++)
			prime[i] = true;

		for (int p = 2; p * p <= n; p++){
			if (prime[p] == true)
			{
				for (int i = p * p; i <= n; i += p)
					prime[i] = false;
			}
		}
		long endTime = System.nanoTime();
		long duration = endTime - beginTime;
		//System.out.println("\nDuration: "+ duration + " \n");

		for (int i = 2; i <= n; i++)
		{
			if (prime[i] == true)
				System.out.print(i + " ");				
		}
		
		return duration;
	}
	
	public static long sieveOfEratosthenesList(int n) {
		long beginTime = System.nanoTime();
		List<Boolean> sieve = new ArrayList<>();
		for(int i =0; i<= n; i++) {
			sieve.add(true);
		}
		for(int p = 2; p *p <= n; p++) {
			if(sieve.get(p) == true)
				for(int i = p*p; i<= n; i+= p) {
					sieve.set(i,false);
				}
		}
		long endTime = System.nanoTime();
		long duration = endTime - beginTime;
		//System.out.println("\nDuration: "+ duration + " \n");
		int i = 0;
		while(i < sieve.size()) {
			if(sieve.get(i) == true) {
				System.out.print(i + " " );
			}
			i++;
		}
		return duration;
	}
	public static void main(String[] args){		
		Long durationArray = sieveOfEratosthenesArray(10_000_000);		
		Long durationList = sieveOfEratosthenesList(10_000_000);
		System.out.println("\nDuration (Array) : " + durationArray);
		System.out.println("\nDuration (List ) : " + durationList);
	}

}
