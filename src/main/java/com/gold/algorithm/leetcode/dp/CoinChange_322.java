package com.gold.algorithm.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChange_322 {

    /**
     * 解法一： dp 二维数组，
     */
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        final boolean[][] status = new boolean[amount][amount + 1];

        // 初始化
        boolean flag = true;
        for (int i = 0; i < coins.length; i++) {
            final int coin = coins[i];
            if (coin == amount) {
                return 1;
            }
            if (coin <= status[0].length - 1) {
                status[0][coin] = true;
                flag = false;
            }
        }
        if (flag) {
            return -1;
        }

        // 状态转移
        for (int i = 1; i < amount; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (status[i - 1][j]) {
                    for (int t = 0; t < coins.length; t++) {
                        final int coin = coins[t];
                        if ((j + (long) coin) <= amount) {
                            status[i][j + coin] = true;
                        }
                    }
                }

                if (status[i][amount]) {
                    return i + 1;
                }
            }
        }

        return -1;
    }

    // 注意 int 的范围
//    public static void main(String[] args) {
//        int[] i = {1, 2147483647};
//        int amount = 2;
//        coinChange(i, amount);
//    }

    public static void main(String[] args) {
        int[] i = {1, 2, 5};
        int amount = 11;
        coinChange2(i, amount);
    }

    /**
     * dp:一维数组
     * 主要考虑：怎么表示每一步的状态
     */
    public static int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        final int[] status = new int[amount + 1];

        boolean flag = true;
        for (int i = 0; i < coins.length; i++) {
            final int coin = coins[i];
            if (coin == amount) {
                return 1;
            }
            if (coin <= status.length - 1) {
                status[coin] = 1;
                flag = false;
            }
        }
        if (flag) {
            return -1;
        }

        for (int i = 1; i < amount; i++) {
            for (int j = amount; j >= 1; j--) {
                if (status[j] == i) {
                    for (final int coin : coins) {
                        final long l = j + (long) coin;
                        if (l < amount) {
                            status[j + coin] = status[j] + 1;
                        } else if (l == amount) {
                            return status[j] + 1;
                        }
                    }
                }
            }
        }

        return -1;
    }

}
