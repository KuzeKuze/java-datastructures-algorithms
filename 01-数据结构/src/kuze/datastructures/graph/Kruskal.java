package kuze.datastructures.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Kruskal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Edge[] edges = new Edge[m];
        for(int i = 0; i < m; i++){
            int source = sc.nextInt();
            int target = sc.nextInt();
            int weight = sc.nextInt();
            edges[i] = new Edge(source, target, weight);
        }

        // 准备parent数组
        int[] parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        UnionFind.parent = parent;  // 赋值数组
        Arrays.sort(edges);
        int minWeight = 0;
        int linkNum = 0;
        List<Edge> treeEdges = new ArrayList<>();
        for(Edge edge : edges){
            if( linkNum == n-1){
                break;
            }

            int p1 = UnionFind.findParent(edge.source);
            int p2 = UnionFind.findParent(edge.target);
            if( p1 != p2 ){
                treeEdges.add(edge);
                UnionFind.union(p1,p2);
                linkNum ++;
                minWeight += edge.weight;
            }
        }

        for(Edge edge : treeEdges){
            System.out.println(edge);
        }
        System.out.println(minWeight);
    }

}

class Edge implements Comparable{
    int source;
    int target;
    int weight;

    public Edge(int source, int target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        return weight - ((Edge)o).weight;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "source=" + source +
                ", target=" + target +
                ", weight=" + weight +
                '}';
    }
}
