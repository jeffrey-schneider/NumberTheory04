package numberTheory;

import java.util.Arrays;

/**
 * @author MM mushfiqazeri@gmail.com 
 *
 */
public class ChangeMakingProblem {
    public static void main(String[] args) {
        int[] coins = {1, 5, 10, 25, 100, 500, 1000, 2000, 5000, 10000}; // Available coin denominations
        int amount = 15063; // Amount of change needed
        
        int[] result = makeChange(coins, amount);
        System.out.println("Minimum number of coins needed: " + result[amount]);
        System.out.println("Coins used:");
        printCoinsUsed(result, coins);
    }
    
    /**
     * 
     * @param coins
     * @param amount
     * @return
     */
    public static int[] makeChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // Array to store the minimum number of coins for each amount
        int[] usedCoins = new int[amount + 1]; // Array to track the coins used
        
        Arrays.fill(dp, Integer.MAX_VALUE); // Initialize all amounts with a large value
        dp[0] = 0; // Base case: no coins needed to make zero change
        
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] + 1 < dp[i]) {
                    dp[i] = dp[i - coin] + 1;
                    usedCoins[i] = coin; // Track the coin used to make the amount
                }
            }
        }
        
        return usedCoins;
    }
    
    /**
     * 
     * @param usedCoins
     * @param coins
     */
    public static void printCoinsUsed(int[] usedCoins, int[] coins) {
        int amount = usedCoins.length - 1;
        while (amount > 0) {
            int coin = usedCoins[amount];
            System.out.print(coin + " ");
            amount -= coin;
        }
    }
}




/**
 * In the code above, the makeChange method uses a dynamic programming approach to find the minimum number of coins needed 
 * for each amount from 0 to the target amount. The dp array keeps track of the minimum number of coins, and the usedCoins 
 * array tracks the coins used to make each amount.
 * 
 * The printCoinsUsed method prints the coins used to make the target amount by backtracking through the usedCoins array.
 * 
 * In the main method, you can modify the coins array to include different coin denominations, and set the amount variable 
 * to the desired target amount. The program will output the minimum number of coins needed to make the change and the coins used in the solution.
 */

