package com.gold.algorithm.leetcode;

import java.util.*;

/**
 * @author goldhuang
 * @Description: 对 PriorityQueue api 的熟悉
 * @date 2021-04-13
 */
public class TopKFrequent_692 {

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordsCount = new HashMap<>(words.length);
        for (int i = 0; i < words.length; i++) {
            wordsCount.merge(words[i], 1, Integer::sum);
        }

        // 构建堆 - 注意比较器
        PriorityQueue<String> heap = new PriorityQueue<>(
            (w1, w2) -> wordsCount.get(w1).equals(wordsCount.get(w2)) ?
                w2.compareTo(w1) : wordsCount.get(w1) - wordsCount.get(w2)
        );

        for (String word : wordsCount.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // 注意顺序
        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty()) {
           ans.add(heap.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
