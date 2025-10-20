package astar;

import java.util.*;

public class AStarSolver {
    private Graph graph;
    private int expanded, pushes, maxFrontier;

    public AStarSolver(Graph graph) { this.graph = graph; }

    public SearchResult solve(int source, int destination, HeuristicFunction heuristic) {
        long startTime = System.nanoTime();
        expanded = pushes = maxFrontier = 0;

        Map<Integer, Double> gCost = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        gCost.put(source, 0.0);
        parent.put(source, null);

        PriorityQueue<Node> heap = new PriorityQueue<>();
        heap.offer(new Node(source, heuristic.calculate(source,destination,graph)));
        pushes++;

        Set<Integer> visited = new HashSet<>();

        while (!heap.isEmpty()) {
            maxFrontier = Math.max(maxFrontier, heap.size());
            Node current = heap.poll();
            int curr = current.id;

            if (visited.contains(curr)) continue;
            visited.add(curr);
            expanded++;

            if (curr == destination) {
                double runtime = (System.nanoTime() - startTime)/1e9;
                return new SearchResult(
                        gCost.get(destination),
                        reconstructPath(parent, source, destination),
                        expanded, pushes, maxFrontier,
                        runtime, ""
                );
            }

            for (int[] n : graph.getNeighbors(curr)) {
                int nb = n[0]; double w = n[1];
                double newG = gCost.get(curr)+w;

                if (!gCost.containsKey(nb) || newG<gCost.get(nb)) {
                    gCost.put(nb,newG);
                    parent.put(nb,curr);
                    heap.offer(new Node(nb, newG+heuristic.calculate(nb,destination,graph)));
                    pushes++;
                }
            }
        }
        double runtime = (System.nanoTime() - startTime)/1e9;
        return new SearchResult(null, new ArrayList<>(), expanded, pushes, maxFrontier, runtime, "");
    }

    private List<Integer> reconstructPath(Map<Integer,Integer> parent, int source, int dest){
        List<Integer> path = new ArrayList<>();
        Integer cur = dest;
        while(cur != null){ path.add(cur); cur = parent.get(cur); }
        Collections.reverse(path);
        return path;
    }
}

