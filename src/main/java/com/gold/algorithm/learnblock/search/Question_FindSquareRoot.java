package com.gold.algorithm.learnblock.search;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author goldhuang
 * @Description: 查找一个数的平方根, 要求精确到小数点后 6 位
 * 关键点：数据类型 double, 跳出条件
 * @date 2021-03-18
 */
public class Question_FindSquareRoot {

    public static void main(String[] args) {
        System.out.println(squareSearch(6, 6));
        System.out.println(squareSearch(6, 3));
        System.out.println(squareSearch(4, 3));
        System.out.println(squareSearch(10, 3));

        System.out.println("-------------------------------------------------");

        System.out.println(squareSearch2(6, 6, 0, 6));
        System.out.println(squareSearch2(6, 3, 0, 6));
        System.out.println(squareSearch2(4, 3, 0, 4));
        System.out.println(squareSearch2(10, 3, 0, 10));

    }

    public static double squareSearch(int target, int precision) {
        double l = 0;
        double r = target;
        double mid = target / 2;

        while (l <= r) {

            double tmp = mid * mid;
            if (tmp == target) {
                return BigDecimal.valueOf(mid).setScale(precision, RoundingMode.HALF_UP).doubleValue();
            } else if (tmp < target) {
                l = mid;
            } else {
                r = mid;
            }

            if (Math.abs(tmp - target) < 0.00001) {
                return BigDecimal.valueOf(mid).setScale(precision, RoundingMode.HALF_UP).doubleValue();
            }

            mid = l + (r - l) / 2;
        }

        return -1;
    }

    public static double squareSearch2(int target, int precision, double left, double right) {
        double mid = left + (right - left) / 2;
        double tmp = mid * mid;
        if (tmp == target || Math.abs(tmp - target) < 0.00001) {
            return BigDecimal.valueOf(mid).setScale(precision, RoundingMode.HALF_UP).doubleValue();
        }

        if (tmp < target) {
            left = mid;
        } else {
            right = mid;
        }

        return squareSearch2(target, precision, left, right);
    }
}
