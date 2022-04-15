package com.gold.algorithm.leetcode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/smallest-k-lcci/solution/
 * 思路：
 * 1. 优先队列
 * 2. 快排
 * 3. 排序取值
 */
public class SmallestK_Interview_17 {

    /**
     * V1
     */
    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (arr.length <= k) {
            return arr;
        }

        int[] heap = Arrays.copyOf(arr, k);
        heapify(heap);

        int max = heap[0];
        for (int i = k - 1; i < arr.length; i++) {
            if (arr[i] < max) {
                heap[0] = arr[i];
                heapify(heap);
                max = heap[0];
            }
        }

        return heap;
    }

    private void heapify(int[] data) {
        int n = data.length - 1;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            int max = data[i];

            int lIndex = 2 * i + 1;
            int rIndex = 2 * i + 2;
            rIndex = Math.min(rIndex, n);

            if (data[lIndex] > max) {
                data[i] = data[lIndex];
                data[lIndex] = max;
                max = data[i];
            }

            if (data[rIndex] > max) {
                data[i] = data[rIndex];
                data[rIndex] = max;
            }
        }
    }

    /**
     * V2
     * 超出时间限制
     */
    public int[] smallestK1(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (arr.length <= k) {
            return arr;
        }

        heapify1(arr, 0, k - 1);

        for (int i = k; i < arr.length; i++) {
            int n = arr[i];
            if (n < arr[0]) {
                arr[0] = n;
                heapify1(arr, 0, k - 1);
            }
        }

        return Arrays.copyOf(arr, k);
    }

    private void heapify1(int[] data, int s, int e) {
        for (int i = (e - 1) / 2; i >= s; i--) {
            compareAndSwap(data, i, e);
        }
    }

    private void compareAndSwap(int[] data, int i, int limitIndex) {
        int maxIndex = i;
        while (true) {
            int max = data[i];

            int l = 2 * i + 1;
            int r = 2 * i + 2;
            r = Math.min(r, limitIndex);

            if (data[l] > max) {
                maxIndex = l;
            }
            if (data[r] > max) {
                maxIndex = r;
            }

            if (maxIndex == i) {
                return;
            }

            data[i] = data[maxIndex];
            data[maxIndex] = max;
            maxIndex = i;
        }
    }

    /**
     * V3
     */
    public int[] smallestK3(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (arr.length <= k) {
            return arr;
        }

        int[] heap = Arrays.copyOf(arr, k);
        heapify2(heap);

        int max = heap[0];
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < max) {
                heap[0] = arr[i];
                heapify2(heap);
                max = heap[0];
            }
        }

        return heap;
    }

    private void heapify2(int[] heap) {
        int e = heap.length - 1;
        for (int i = (e - 1) / 2; i >= 0; i--) {
            compareAndSwap(heap, i);
        }
    }

    private void compareAndSwap(int[] heap, int i) {
        int maxIndex = i;
        while (true) {
            int max = heap[i];

            int l = 2 * i + 1;
            int r = 2 * i + 2;
            r = Math.min(r, heap.length - 1);

            if (heap[l] > max) {
                maxIndex = l;
            }
            if (heap[r] > max) {
                maxIndex = r;
            }

            if (maxIndex == i) {
                return;
            }

            heap[i] = heap[maxIndex];
            heap[maxIndex] = max;
            maxIndex = i;
        }
    }

}
