package InterviewQuestions;

import java.util.*;

public class KLehmerNumbers {
    
    // Function to calculate Euler's totient function phi(n)
    static int phi(int n) {
        int result = n; // Initialize result as n
      
        // Consider all prime factors of n and subtract their multiples from result
        for (int p = 2; p * p <= n; ++p) {
            // Check if p is a prime factor of n
            if (n % p == 0) {
                // Update result when it is divisible by p
                result -= result / p;
                // Remove all multiples of p from n
                while (n % p == 0)
                    n /= p;
            }
        }
      
        // If n has a prime factor greater than sqrt(n), then there can be at most one such prime factor
        // which can divide n and it must be greater than sqrt(n)
        if (n > 1)
            result -= result / n;
      
        return result;
    }

    // Function to check if a number is a k-Lehmer number
    static boolean isKLehmer(int n, int k) {
        int phiN = phi(n);
        return (phiN != 0 && (n - 1) % phiN == 0 && Math.pow(phiN, k) % (n - 1) == 0);
    }

    // Function to find and print k-Lehmer numbers up to a given limit
    static void findKLehmerNumbers(int limit, int k) {
        List<Integer> kLehmerNumbers = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isKLehmer(i, k)) {
                kLehmerNumbers.add(i);
            }
        }
        System.out.println("k-Lehmer numbers for k = " + k + " up to " + limit + ": " + kLehmerNumbers);
    }

    public static void main(String[] args) {
        int limit = 1000; // Limit for the range of numbers to check
        int k = 2; // Choose the value of k for k-Lehmer numbers
        findKLehmerNumbers(limit, k);
    }
}


