package astar;

import java.util.List;

public class SearchResult {
    private Double optimalCost;
    private List<Integer> path;
    private int expanded;
    private int pushes;
    private int maxFrontier;
    private double runtimeSeconds;
    private String mode;

    public SearchResult(Double optimalCost, List<Integer> path,
                        int expanded, int pushes, int maxFrontier,
                        double runtimeSeconds, String mode) {
        this.optimalCost = optimalCost;
        this.path = path;
        this.expanded = expanded;
        this.pushes = pushes;
        this.maxFrontier = maxFrontier;
        this.runtimeSeconds = runtimeSeconds;
        this.mode = mode;
    }

    public Double getOptimalCost() { return optimalCost; }
    public List<Integer> getPath() { return path; }
    public int getExpanded() { return expanded; }
    public int getPushes() { return pushes; }
    public int getMaxFrontier() { return maxFrontier; }
    public double getRuntimeSeconds() { return runtimeSeconds; }
    public String getMode() { return mode; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MODE: ").append(mode).append("\n");

        if (optimalCost != null) {
            sb.append("Optimal cost: ").append(optimalCost).append("\n");
            sb.append("Path: ");
            for (int i = 0; i < path.size(); i++) {
                if (i > 0) sb.append(" -> ");
                sb.append(path.get(i));
            }
            sb.append("\n");
        } else {
            sb.append("Optimal cost: NO PATH\n");
        }

        sb.append("Expanded: ").append(expanded).append("\n");
        sb.append("Pushes: ").append(pushes).append("\n");
        sb.append("Max frontier: ").append(maxFrontier).append("\n");
        sb.append("Runtime (s): ").append(String.format("%.6f", runtimeSeconds)).append("\n");

        return sb.toString();
    }
}

