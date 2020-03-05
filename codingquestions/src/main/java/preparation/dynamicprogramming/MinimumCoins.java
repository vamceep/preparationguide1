package preparation.dynamicprogramming;

public class MinimumCoins {
    /**
     * Given an integer representing a given amount of change, write a function
     * to compute the total number of coins required to make that amount of change.
     * ex: coins = {10, 6, 1}
     * change: 12
     * find min coins required : 2
     */

    public static int minCoinsRequired(int[] coins, int change) {
        /**
         * for the range of change 1 to given change
         * identify min coins required and cache them.
         * Reuse for higher change value.
         */
        int[] cache = new int[change+1]; // initializes to 0
        for(int i = 1; i<= change;i++) {
            int minCoins = Integer.MAX_VALUE;
            for(int coin  : coins) {
                int remain = i - coin;
                if(remain >= 0) {
                    int currentMin = cache[remain] + 1;
                    if(currentMin < minCoins) {
                        minCoins = currentMin;
                    }
                }
            }
            cache[i] = minCoins;
        }

        return cache[change];
    }

    public static void main(String[] args) {
//        int[] coins= {10,6,1};
//        int change = 12;

        int[] coins = {1,5,10,25};
        int change = 1;
        int minCoins  = minCoinsRequired(coins, change);
        System.out.println("Min coins for change : " + change + " = " + minCoins);
        change = 6;
        minCoins  = minCoinsRequired(coins, change);
        System.out.println("Min coins for change : " + change + " = " + minCoins);
        change = 49;
        minCoins  = minCoinsRequired(coins, change);
        System.out.println("Min coins for change : " + change + " = " + minCoins);
    }
}
