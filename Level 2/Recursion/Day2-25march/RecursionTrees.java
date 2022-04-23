// permutation -> left to right and right to left, both directions -> arrangement
// combination -> left to right or right to left, one direction only -> not an arrangement

import java.util.*;

public class RecursionTrees {

    public static int coinChangePermutation_IN(int[] coins, int tar, String psf) {
        if (tar == 0) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            if (tar - coins[i] >= 0) {
                count += coinChangePermutation_IN(coins, tar - coins[i], psf + coins[i] + " ");
            }
        }

        return count;

    }

    public static int coinChangeCombination_IN(int[] coins, int tar, int idx, String psf) {
        if (tar == 0) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < coins.length; i++) {
            if (tar - coins[i] >= 0) {
                count += coinChangeCombination_IN(coins, tar - coins[i], i, psf + coins[i] + " ");
            }
        }
        return count;
    }

    public static int coinChangePermutation_Sin(int[] coins, int tar, String psf) {
        if (tar == 0) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > 0 && tar - coins[i] >= 0) {
                int val = coins[i];
                coins[i] = -coins[i];   // mark => convert to -ve so that there is no call from here
                count += coinChangePermutation_Sin(coins, tar - val, psf + val + " ");
                coins[i] = -coins[i];   // unmark => convert to +ve so that there can be calls from here now
            }
        }

        return count;
    }

    public static int coinChangeCombination_Sin(int[] coins, int tar, int idx, String psf) {
        if (tar == 0) {
            System.out.println(psf);
            return 1;
        }

        int count = 0;
        for (int i = idx; i < coins.length; i++) {
            if (tar - coins[i] >= 0) {
                count += coinChangeCombination_Sin(coins, tar - coins[i], i + 1, psf + coins[i] + " ");
            }
        }
        return count;
    }

    //                  ==========   subsequence method    =============

    public static int coinChangePermutation_IN_Sub(int[] coins, int tar, int idx, String psf) {
        if (tar == 0 || idx == coins.length) {
            if (tar == 0) {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0)
            count += coinChangePermutation_IN_Sub(coins, tar - coins[idx], 0, psf + coins[idx] + " ");
        count += coinChangePermutation_IN_Sub(coins, tar, idx + 1, psf);

        return count;
    }

    public static int coinChangeCombination_IN_Sub(int[] coins, int tar, int idx, String psf) {
        if (tar == 0 || idx == coins.length) {
            if (tar == 0) {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0)
            count += coinChangeCombination_IN_Sub(coins, tar - coins[idx], idx, psf + coins[idx] + " ");
        count += coinChangeCombination_IN_Sub(coins, tar, idx + 1, psf);

        return count;
    }

    public static int coinChangeCombination_Sin_Sub(int[] coins, int tar, int idx, String psf) {
        if (tar == 0 || idx == coins.length) {
            if (tar == 0) {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }

        int count = 0;

        if (tar - coins[idx] >= 0) {
            count += coinChangeCombination_Sin_Sub(coins, tar - coins[idx], idx + 1, psf + coins[idx] + " ");
        }
        count += coinChangeCombination_Sin_Sub(coins, tar, idx + 1, psf);

        return count;
    }

    public static int coinChangePermutation_Sin_Sub(int[] coins, int tar, int idx, String psf) {
        if (tar == 0 || idx == coins.length) {
            if (tar == 0) {
                System.out.println(psf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        if (tar - coins[idx] >= 0) {
            int val = coins[idx];
            coins[idx] = -coins[idx];
            count += coinChangePermutation_IN_Sub(coins, tar - val, 0, psf + val + " ");
            coins[idx] = -coins[idx];
        }
        count += coinChangePermutation_IN_Sub(coins, tar, idx + 1, psf);

        return count;
    }

    public static void main(String[] args) {
        int[] coins = { 2, 3, 5, 7 };
        int tar = 10;

        // System.out.println(coinChangePermutation_IN(coins, tar, ""));
        // System.out.println(coinChangeCombination_IN(coins, tar,0, ""));
        // System.out.println(coinChangeCombination_Sin(coins, tar, 0, ""));
        // System.out.println(coinChangePermutation_Sin(coins, tar, ""));

        System.out.println(coinChangeCombination_Sin_Sub(coins, tar, 0, ""));
    }
}
