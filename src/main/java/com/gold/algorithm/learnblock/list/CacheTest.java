package com.gold.algorithm.learnblock.list;

/**
 * @author goldhuang
 * @Description:
 * @date 2021-03-10
 */
public class CacheTest {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.add(1);
        lruCache.add(2);
        lruCache.add(3);
        lruCache.add(4);
        lruCache.add(5);

        lruCache.get(4);

        lruCache.add(6);
    }
}
