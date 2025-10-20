package astar;

import java.util.*;

public class Graph {
    private Map<Integer, Vertex> vertices;
    private Map<String, Double> edges;
    private Map<Integer, List<int[]>> adjacency;

    public Graph() {
        this.vertices = new HashMap<>();
        this.edges = new HashMap<>();
        this.adjacency = new HashMap<>();
    }

    public void addVertex(int id, int cellId) {
        if (!vertices.containsKey(id)) {
            vertices.put(id, new Vertex(id, cellId));
            adjacency.put(id, new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, double weight) {
        adjacency.putIfAbsent(u, new ArrayList<>());
        adjacency.putIfAbsent(v, new ArrayList<>());

        int first = Math.min(u, v);
        int second = Math.max(u, v);
        String key = first + "-" + second;

        if (!edges.containsKey(key)) {
            edges.put(key, weight);
            adjacency.get(u).add(new int[]{v, (int)weight});
            adjacency.get(v).add(new int[]{u, (int)weight});
        }
    }

    public Vertex getVertex(int id) { return vertices.get(id); }
    public List<int[]> getNeighbors(int nodeId) { return adjacency.getOrDefault(nodeId, new ArrayList<>()); }
    public int[] getVertexCoordinates(int nodeId) {
        Vertex v = vertices.get(nodeId);
        return v != null ? v.getCoordinates() : new int[]{0, 0};
    }
    public Map<Integer, Vertex> getVertices() { return vertices; }
}

