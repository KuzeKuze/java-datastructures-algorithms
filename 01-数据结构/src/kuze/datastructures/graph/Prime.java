package kuze.datastructures.graph;

import java.util.ArrayList;
import java.util.List;


class MyThread extends Thread{
    @Override
    public void run(){
        throw new NullPointerException();
    }
}
public class Prime {
    public static void main(String[] args) {

        for(int i = 0; i < 50; i++){
            new MyThread().start();
        }
        throw new NumberFormatException();
//        int n,m;
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
//        m = sc.nextInt();
//
//        boolean[] selected = new boolean[n];  // 顶点是否在树中
//        int[] minDist = new int[n];         // 非树中顶点到树中顶点的所有边中的最小距离，初始为inf，表示不存在链路
//        int[] parent = new int[n];          // 最小距离的那个链路的父结点，初始为-1，表示不存在链路
//
//        for(int i = 0; i < n ; i++){
//            selected[i] = false;
//            minDist[i] = Integer.MAX_VALUE;
//            parent[i] = -1;
//        }
//
//        Node[] adj = new Node[n];
//        for(int i = 0; i < adj.length; i++){
//            adj[i] = new Node(i, 0);
//        }
//
//        Edge[] edges = new Edge[m];
//        for(int i = 0 ; i < m; i++){
//            int source = sc.nextInt();
//            int target = sc.nextInt();
//            int weight = sc.nextInt();
//            edges[i] = new Edge(source, target, weight);
//            adj[source].neighbors.add(new Node(target, weight));
//            adj[target].neighbors.add(new Node(source, weight));
//        }
//
//        // 先将0结点纳入树中
//        selected[0] = true;
//        minDist[0] = 0;
//        parent[0] = -1;
//        int lastNode = 0;
//        int num = 1; // 当前添加的节点数量
//        int minWeight = 0;
//        while(num != n){ // 当还没有添加完
//            for( Node nei : adj[lastNode].neighbors){
//                if(nei.weight < minDist[nei.val]){
//                    minDist[nei.val] = nei.weight;
//                    parent[nei.val] = lastNode;
//                }
//            }
//
//            // 信息更新完成，检索最小的minDist
//            int minIndex = 0;
//            int min = Integer.MAX_VALUE;
//            for(int i = 0; i < minDist.length; i++){
//                if( minDist[i] < min && selected[i] != true){
//                    min = minDist[i];
//                    minIndex = i;
//                }
//            }
//
//            // 将最小的节点纳入树中
//            selected[minIndex] = true;
//            num ++;
//            minWeight += min;  // 更新总的权值
//            lastNode = minIndex;
//        }
//
//        System.out.println(minWeight);
    }
}
class Node {
    int val;
    int weight;
    List<Node> neighbors = new ArrayList<>();

    public Node(int val, int weight) {
        this.val = val;
        this.weight = weight;
    }
}
