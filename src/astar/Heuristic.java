package astar;

public class Heuristic {
    public static double zero(int node, int goal, Graph graph) { return 0.0; }

    public static double euclidean(int node, int goal, Graph graph) {
        int[] a = graph.getVertexCoordinates(node);
        int[] b = graph.getVertexCoordinates(goal);
        double dx = a[0] - b[0], dy = a[1] - b[1];
        return Math.sqrt(dx*dx + dy*dy);
    }

    public static double manhattan(int node, int goal, Graph graph) {
        int[] a = graph.getVertexCoordinates(node);
        int[] b = graph.getVertexCoordinates(goal);
        return Math.abs(a[0]-b[0]) + Math.abs(a[1]-b[1]);
    }
}

