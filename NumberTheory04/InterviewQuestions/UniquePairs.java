package InterviewQuestions;

import java.util.*;

public class UniquePairs {
    public static void main(String[] args) {
        Map<Pair<Integer, Integer>, Integer> uniquePairs = new HashMap<>();
        
        // Add unique pairs with their corresponding third elements
        addUniquePair(uniquePairs, 2, 4, 26);
        addUniquePair(uniquePairs, 4, 5, 16);
        addUniquePair(uniquePairs, 7, 8, 32);
        
        // Try adding a pair with existing first two elements
        addUniquePair(uniquePairs, 2, 4, 16);
        
        // Print the unique pairs
        System.out.println("Unique Pairs:");
        for (Map.Entry<Pair<Integer, Integer>, Integer> entry : uniquePairs.entrySet()) {
            Pair<Integer, Integer> pair = entry.getKey();
            int thirdElement = entry.getValue();
            System.out.println("(" + pair.getFirst() + ", " + pair.getSecond() + ", " + thirdElement + ")");
        }
    }
    
    // Helper method to add a unique pair with its corresponding third element
    public static void addUniquePair(Map<Pair<Integer, Integer>, Integer> map, int first, int second, int third) {
        Pair<Integer, Integer> pair = new Pair<>(first, second);
        if (!map.containsKey(pair)) {
            map.put(pair, third);
        } else {
            System.out.println("Duplicate pair: (" + first + ", " + second + ")");
        }
    }
}

// Pair class for storing two elements
class Pair<A, B> {
    private final A first;
    private final B second;
    
    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }
    
    public A getFirst() {
        return first;
    }
    
    public B getSecond() {
        return second;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
