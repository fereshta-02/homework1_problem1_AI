package astar;

public interface HeuristicFunction {
    double calculate(int node, int goal, Graph graph);
}

