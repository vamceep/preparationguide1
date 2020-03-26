package preparation.dynamicprogramming;

public class MinimumCoins {
    /**
     * Given an integer representing a given amount of change, write a function
     * to compute the total number of coins required to make that amount of change.
     * ex: coins = {10, 6, 1}
     * change: 12
     * find min coins required : 2
     */

    /**
     *
     * give 'change' from 1 to change, we calculate how many min coins required.
     * ex: {1,5,8} are coins, change is 5
     * so there are two answers. 1 * 5 = 5 coins or 1 * 5 i.e 1 5$ coin.
     * min of both {5, 1} is 1 so answers is 1.
     * while calculating for change 5, we keep calculate min coins required
     * for previous values which will be in the cache.
     * so when it comes to 5 we no need to calculate again for previous denominations
     *
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

    public static int minCointsBruitFroce(int[] coins, int change) {
        if(change == 0) {
            return 0;
        }
        int minCoins = Integer.MAX_VALUE;
        for(int i=0; i < coins.length; i++) {
            if(change - coins[i] >=0) {
                int currentMin = minCointsBruitFroce(coins, (change - coins[i]));
                if(currentMin < minCoins) {
                    minCoins = currentMin;
                    System.out.println(minCoins);
                }
            }
        }
        return minCoins+1;
    }
    public static void main(String[] args) {
//        int[] coins= {10,6,1};
//        int change = 12;

        int[] coins = {1,5,10,25};
        int change = 5;
        int minCoins  = minCoinsRequired(coins, change);
        System.out.println("Min coins for change : " + change + " = " + minCoins);
//        change = 6;
//        minCoins  = minCoinsRequired(coins, change);
//        System.out.println("Min coins for change : " + change + " = " + minCoins);
//        change = 49;
//        minCoins  = minCoinsRequired(coins, change);
//        System.out.println("Min coins for change : " + change + " = " + minCoins);

        minCoins = minCointsBruitFroce(coins, change);
        System.out.println("Min coins for change (Bruitforce) : " + change + " = " + minCoins);
    }
}
