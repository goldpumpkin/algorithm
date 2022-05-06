package com.gold.algorithm.learnblock.graph;

import java.util.LinkedList;

/**
 * @author goldhuang
 * @Description: 无向图
 * @date 2021-04-16
 */
public class Graph {

    /**
     * 顶点个数
     */
    private int v;

    /**
     * 邻接表
     */
    private LinkedList<Integer> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // 无向图一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }
}
