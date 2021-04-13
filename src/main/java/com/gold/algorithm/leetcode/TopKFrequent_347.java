package com.gold.algorithm.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author goldhuang
 * @Description: TopK 问题
 * @date 2021-04-13
 */
public class TopKFrequent_347 {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.merge(i, 1, Integer::sum);
        }

        PriorityQueue<Integer> p = new PriorityQueue<>(
            Comparator.comparingInt(count::get)
        );

        for (Integer i : count.keySet()) {
            p.offer(i);
            if (p.size() > k) {
                p.poll();
            }
        }

        return p.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums) {
            count.merge(i, 1, Integer::sum);
        }

        return count.keySet().stream()
            .sorted(((o1, o2) -> count.get(o2) - count.get(o1)))
            .limit(k)
            .mapToInt(Integer::intValue)
            .toArray();

    }
}
