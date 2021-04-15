package kuze.datastructures.graph;

/**
 * 并查集的实现
 */

public class UnionFind {

    public static int[] parent;

    public static int findParent(int x){
        if( x == parent[x]) return x;

        parent[x] = findParent(parent[x]);  // 路径压缩
        return parent[x];
    }

    public static void union(int x, int y){
        int p1 = findParent(x);
        int p2 = findParent(y);
        parent[p1] = p2;
    }
}
