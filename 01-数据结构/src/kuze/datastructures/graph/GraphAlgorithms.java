package kuze.datastructures.graph;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GraphAlgorithms {

    public static Map<Vertex, Boolean> visitedMap;
    public static void DFS(Vertex startVertex){

        System.out.println(startVertex);
        visitedMap.put(startVertex, true);

        for( Vertex vertex : startVertex.getNeighbors()){
            if(!visitedMap.get(vertex)){
                DFS(vertex);
            }
        }
    }

    public static boolean[] visited;
    public static void DFS(int[][] matrix, int startVertex){
        if(!visited[startVertex]){
            System.out.println(startVertex);
            visited[startVertex] = true;
        }
        for(int j = 0; j < matrix.length; j++){
            if(matrix[startVertex][j] != 0 && !visited[j]){
                DFS(matrix, j);
            }
        }
    }





    public static void BFS(Vertex startVertex){

        Queue<Vertex> queue = new LinkedList<>();
        queue.offer(startVertex);
        while(!queue.isEmpty()){
            Vertex vertex = queue.poll();
            System.out.println(vertex);
            visitedMap.put(vertex, true);
            for(Vertex neighbor : vertex.getNeighbors()){
                if(!visitedMap.get(neighbor)){
                    queue.offer(neighbor);
                }
            }
        }
    }


    public static void BFS(int[][] matrix, int startVertex){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);

        while(!queue.isEmpty()){
            int v = queue.poll();
            System.out.println(v);
            visited[startVertex] = true;
            for(int i = 0; i < matrix.length; i++){
                if(matrix[startVertex][i] != 0 && !visited[i]){
                    queue.offer(i);
                }
            }
        }
    }
}
