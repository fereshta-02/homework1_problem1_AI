package astar;

public enum HeuristicType {
    ZERO("zero"),
    EUCLIDEAN("euclidean"),
    MANHATTAN("manhattan");

    private String name;
    HeuristicType(String name) { this.name = name; }
    public String getName() { return name; }
}

