package kuze.datastructures.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vertex {
    private String id;
    private int weight;
    private  List<Vertex> neighbors = new ArrayList<>();

    public Vertex(String id) {
        this.id = id;
    }

    public Vertex(String id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<Vertex> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Vertex> neighbors) {
        this.neighbors = neighbors;
    }

    public void addNeighbor(Vertex v){
        neighbors.add(v);
    }

    public boolean removeNeighbor(Vertex v){
        return neighbors.remove(v);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(id, vertex.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "id='" + id + '\'' +
                '}';
    }
}
